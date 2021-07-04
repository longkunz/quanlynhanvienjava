/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhanvien;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import javax.swing.JOptionPane;

/*
 * Hồ Sĩ Hùng
 * 31/12/2020
 */
public class QLNVModel extends DataBase {

    //Lấy dữ liệu tất cả nhân viên
    //Hồ Sĩ Hùng
    //31/12/2020
    public ArrayList<NhanVien> getAllData() throws SQLException, ParseException {
        ArrayList<NhanVien> kq = new ArrayList<NhanVien>();

        //Lấy danh sách nhân viên chính thức
        PreparedStatement stmt = c.prepareStatement("SELECT * FROM NhanVien JOIN NVChinhThuc on NhanVien.MaNV = NVChinhThuc.MaNV;");

        ResultSet result = DataBase.getData(stmt);

        while (result.next()) {
            //Chuyển ngày sinh
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date ngSinh = format.parse(result.getString(3));

            //Tạo đối tượng nhân viên, thêm vào mảng arrayList
            NhanVienChinhThuc nv = new NhanVienChinhThuc(result.getFloat(7), result.getString(1), result.getString(2), ngSinh, result.getString(4), result.getString(5));
            kq.add(nv);
        }

        //Lấy danh sách nhân viên Part Time
        stmt = c.prepareStatement("SELECT * FROM NhanVien JOIN NVPartTime on NhanVien.MaNV = NVPartTime.MaNV;");

        result = DataBase.getData(stmt);

        while (result.next()) {
            //Chuyển ngày sinh
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date ngSinh = format.parse(result.getString(3));

            //Tạo đối tượng nhân viên, thêm vào mảng arrayList
            NhanVienPartTime nv = new NhanVienPartTime(result.getInt(7), result.getString(1), result.getString(2), ngSinh, result.getString(4), result.getString(5));
            kq.add(nv);
        }

        //Lấy danh sách nhân viên hợp đồng
        stmt = c.prepareStatement("SELECT * FROM NhanVien JOIN NVHopDong on NhanVien.MaNV = NVHopDong.MaNV;");

        result = DataBase.getData(stmt);

        while (result.next()) {
            //Chuyển ngày sinh
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date ngSinh = format.parse(result.getString(3));

            //Tạo đối tượng nhân viên, thêm vào mảng arrayList
            NhanVienHopDong nv = new NhanVienHopDong(result.getInt(7), result.getString(1), result.getString(2), ngSinh, result.getString(4), result.getString(5));
            kq.add(nv);
        }

        return kq;
    }

    //Lê Tuấn Liêm
    //Chúc năng sửa thông tin
    //01/01/2021
    public int updateInforNhanVien(String maNV, String hoTen, String ngaySinh, String CMND, String diaChi) throws SQLException {

        PreparedStatement stmt = c.prepareStatement(String.format("UPDATE NhanVien SET HoTen = N'%s', NgSinh = '%s', CMND = '%s', DiaChi = N'%s' WHERE MaNV = '%s'",
                hoTen, ngaySinh, CMND, diaChi, maNV));

        return DataBase.setData(stmt);
    }

    //Thêm nhân viên vào csdl   
    //Hồ Viết Long
    //01/01/2020
    public boolean themNhanVien(NhanVien nv) throws SQLException {
        boolean result = false;
        String sql = "INSERT INTO NhanVien (MaNV, HoTen, NgSinh, CMND, DiaChi) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = DataBase.getConnection().prepareStatement(sql);
        statement.setString(1, nv.maNV);
        statement.setString(2, nv.hoTen);

        String ngaySinh = String.format("%tY-%tm-%td", nv.ngSinh, nv.ngSinh, nv.ngSinh);
        statement.setString(3, ngaySinh);

        statement.setString(4, nv.soCMND);
        statement.setString(5, nv.diaChi);
        int rowsInserted1 = statement.executeUpdate(); //Kiểm tra xem truy vấn "InsertNhanVien" có thành công hay không
        if (rowsInserted1 > 0) {
            result = true;
        }
        return result;
    }

    //Thêm loại nhân viên chính thức vào csdl
    //Hồ Viết Long
    //01/01/2020
    public boolean themNhanVienChinhThuc(NhanVienChinhThuc nv) throws SQLException {
        boolean result = false;
        String sql = "INSERT INTO NVChinhThuc (MaNV, HeSoLuong) VALUES (?, ?)";
        PreparedStatement statement = DataBase.getConnection().prepareStatement(sql);
        statement.setString(1, nv.maNV);
        statement.setFloat(2, nv.getHeSoLuong());
        int rowsInserted1 = statement.executeUpdate(); //Kiểm tra xem truy vấn "Insert" có thành công hay không
        if (rowsInserted1 > 0) {
            result = true;
        }
        return result;
    }

    //Thêm loại nhân viên hop dong vào csdl 
    //Hồ Viết Long
    //01/01/2020
    public boolean themNhanVienHopDong(NhanVienHopDong nv) throws SQLException {
        boolean result = false;
        String sql = "INSERT INTO NVHopDong (MaNV, SoNgayCong) VALUES (?, ?)";
        PreparedStatement statement = DataBase.getConnection().prepareStatement(sql);
        statement.setString(1, nv.maNV);
        statement.setInt(2, nv.getSoNgayCong());
        int rowsInserted1 = statement.executeUpdate(); //Kiểm tra xem truy vấn "Insert" có thành công hay không
        if (rowsInserted1 > 0) {
            result = true;
        }
        return result;
    }

    //Thêm loại nhân viên chính thức vào csdl
    //Hồ Viết Long
    //01/01/2020
    public boolean themNhanVienThoiVu(NhanVienPartTime nv) throws SQLException {
        boolean result = false;
        String sql = "INSERT INTO NVPartTime (MaNV, SoGioLam) VALUES (?, ?)";
        PreparedStatement statement = DataBase.getConnection().prepareStatement(sql);
        statement.setString(1, nv.maNV);
        statement.setInt(2, nv.getSoGioLam());
        int rowsInserted1 = statement.executeUpdate(); //Kiểm tra xem truy vấn "Insert" có thành công hay không
        if (rowsInserted1 > 0) {
            result = true;
        }
        return result;
    }

    //Lê Tuấn Liêm
    //Hàm xóa nhân viên
    //01/01/2021
    public int deleteData(String maNV, String LoaiNV) throws SQLException {
        //Truy vấn dữ liệu trên bảng NhanVien theo loại
        PreparedStatement stmt2 = c.prepareStatement(String.format("DELETE FROM %s WHERE MaNV = '%s'", LoaiNV, maNV));
        //Thực hiện truy vấn bảng NhanVien theo loại
        int q2 = stmt2.executeUpdate();

        //Tạo truy vấn dữ liệu trên bảng NhanVien
        PreparedStatement stmt = c.prepareStatement(String.format("DELETE FROM NhanVien WHERE MaNV = '%s'", maNV));
        //Thực hiện truy vấn bảng NhanVien
        int q1 = stmt.executeUpdate();

        //Trả về kết quả
        return q2+q1;
    }

    //Hồ Sĩ Hùng
    //HÀM TÌM KIẾM THÔNG TIN PHỤ ( JOIN QUA BẢNG CON ĐỂ LẤY THÔNG TIN)
    public ArrayList timKiemThongTinPhu(String maNV, int loaiNV) throws SQLException, ParseException {
        ArrayList kq = new ArrayList();
        ResultSet result;
        switch (loaiNV) {
            case 1:
                PreparedStatement stmt = c.prepareStatement("SELECT * FROM NhanVien JOIN NVChinhThuc on NhanVien.MaNV = NVChinhThuc.MaNV"
                        + " WHERE NhanVien.MaNV = ?");
                stmt.setString(1, maNV);

                result = DataBase.getData(stmt);

                kq = new ArrayList<NhanVienChinhThuc>();

                //Đưa dữ liệu từ câu truy vấn vào bảng
                while (result.next()) {
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date ngSinh = format.parse(result.getString(3));

                    NhanVienChinhThuc nv = new NhanVienChinhThuc(result.getFloat(7), result.getString(1),
                            result.getString(2), ngSinh, result.getString(4), result.getString(5));

                    kq.add(nv);
                }

                break;
            case 2:
                stmt = c.prepareStatement("SELECT * FROM NhanVien JOIN NVHopDong on NhanVien.MaNV = NVHopDong.MaNV"
                        + " WHERE NhanVien.MaNV = ?");
                stmt.setString(1, maNV);

                result = DataBase.getData(stmt);

                kq = new ArrayList<NhanVienHopDong>();

                //Đưa dữ liệu từ câu truy vấn vào bảng
                while (result.next()) {
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date ngSinh = format.parse(result.getString(3));

                    NhanVienHopDong nv = new NhanVienHopDong(result.getInt(7), result.getString(1),
                            result.getString(2), ngSinh, result.getString(4), result.getString(5));

                    kq.add(nv);
                }
                break;
            case 3:
                stmt = c.prepareStatement("SELECT * FROM NhanVien JOIN NVPartTime on NhanVien.MaNV = NVPartTime.MaNV"
                        + " WHERE NhanVien.MaNV = ?");
                stmt.setString(1, maNV);

                result = DataBase.getData(stmt);

                kq = new ArrayList<NhanVienPartTime>();

                //Đưa dữ liệu từ câu truy vấn vào bảng
                while (result.next()) {
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date ngSinh = format.parse(result.getString(3));

                    NhanVienPartTime nv = new NhanVienPartTime(result.getInt(7), result.getString(1),
                            result.getString(2), ngSinh, result.getString(4), result.getString(5));

                    kq.add(nv);
                }

                break;
            default:

        }

        return kq;
    }

    //Sắp xếp theo mã nhân viên
    //01/01/2021
    //Hồ Viết Long
    //02/01/2020
    //Hồ Sĩ Hùng cập nhập thêm chức năng
    public ArrayList<NhanVien> sapXepTheoMa(int loaiNV) throws SQLException, ParseException {
        ArrayList<NhanVien> listNV = new ArrayList<>();
        listNV = locLoaiNhanVien(loaiNV);

        //Nếu tham số truyền vào bằng 0, lấy tất cả dữ liệu
        if (loaiNV == 0) {
            listNV = getAllData();
        }

        listNV.sort(new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                return o1.maNV.compareTo(o2.maNV);
            }

        });
        return listNV;
    }

    //Sắp xếp theo tên nhân viên
    //01/01/2021
    //Hồ Viết Long
    //02/01/2020
    //Hồ Sĩ Hùng cập nhập thêm chức năng
    public ArrayList<NhanVien> sapXepTheoTen(int loaiNV) throws SQLException, ParseException {
        ArrayList<NhanVien> listNV = new ArrayList<>();
        listNV = locLoaiNhanVien(loaiNV);

        //Nếu tham số truyền vào bằng 0, lấy tất cả dữ liệu
        if (loaiNV == 0) {
            listNV = getAllData();
        }

        listNV.sort(new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                return o1.hoTen.compareTo(o2.hoTen);
            }

        });
        return listNV;
    }

    //Sắp xếp theo Tiền lương nhân viên 
    //01/01/2021
    //Hồ Viết Long
    //02/01/2020
    //Hồ Sĩ Hùng cập nhập thêm chức năng
    public ArrayList<NhanVien> sapXepTheoLuong(int loaiNV) throws SQLException, ParseException {
        ArrayList<NhanVien> listNV = new ArrayList<>();
        listNV = locLoaiNhanVien(loaiNV);

        //Nếu tham số truyền vào bằng 0, lấy tất cả dữ liệu
        if (loaiNV == 0) {
            listNV = getAllData();
        }

        listNV.sort(new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                if (o1.tinhLuong() > o2.tinhLuong()) {
                    return 1;
                } else if (o1.tinhLuong() < o2.tinhLuong()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return listNV;
    }

    //Sửa thông tin nhân viên chính thức 
    //01/01/2021
    //Hồ Viết Long, Lê Tuấn Liêm
    public int updateNhanVienChinhThuc(String maNV, float heSoLuong) throws SQLException {
        String sql = "UPDATE NVChinhThuc SET HeSoLuong = ? WHERE MaNV = ?";
        PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql);
        stmt.setString(2, maNV);
        stmt.setFloat(1, heSoLuong);
        int result = stmt.executeUpdate();
        return result;
    }

    //Sửa thông tin nhân viên Hợp đồng 
    //01/01/2021
    //Hồ Viết Long, Lê Tuấn Liêm
    public int updateNhanVienHopDong(String maNV, int SoNgayCong) throws SQLException {
        String sql = "UPDATE NVHopDong SET SoNgayCong = ? WHERE MaNV = ?";
        PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql);
        stmt.setString(2, maNV);
        stmt.setFloat(1, SoNgayCong);
        int result = stmt.executeUpdate();
        return result;
    }

    //Sửa thông tin nhân viên Thời vụ 
    //01/01/2021
    //Hồ Viết Long, Lê Tuấn Liêm
    public int updateNhanVienThoiVu(String maNV, int SoGioLam) throws SQLException {
        String sql = "UPDATE NVPartTime SET SoGioLam = ? WHERE MaNV = ?";
        PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql);
        stmt.setString(2, maNV);
        stmt.setFloat(1, SoGioLam);
        int result = stmt.executeUpdate();
        return result;
    }

    //TÌm kiếm nhân viên, theo từ khóa
    //01/01/2021
    //Hồ Viết Long, Lê Tuấn Liêm
    public ArrayList<NhanVien> searchNhanVien(String key) throws SQLException, ParseException {
        ArrayList<NhanVien> kq = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien\n"
                + "JOIN NVChinhThuc ON NhanVien.MaNV=NVChinhThuc.MaNV\n"
                + "WHERE NhanVien.HoTen LIKE '%" + key + "%' OR NhanVien.MaNV LIKE '%" + key + "%' OR NhanVien.CMND LIKE '%" + key + "%'";
        PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql);
        ResultSet result = DataBase.getData(stmt);
        while (result.next()) {
            //Chuyển ngày sinh
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date ngSinh = format.parse(result.getString(3));

            //Tạo đối tượng nhân viên, thêm vào mảng arrayList
            NhanVienChinhThuc nv = new NhanVienChinhThuc(result.getFloat(7), result.getString(1), result.getString(2), ngSinh, result.getString(4), result.getString(5));
            kq.add(nv);
        }

        //Lấy danh sách nhân viên Part Time
        stmt = c.prepareStatement("SELECT * FROM NhanVien\n"
                + "JOIN NVPartTime \n"
                + "ON NhanVien.MaNV=NVPartTime.MaNV\n"
                + "WHERE NhanVien.HoTen LIKE '%" + key + "%' OR NhanVien.MaNV LIKE '%" + key + "%' OR NhanVien.CMND LIKE '%" + key + "%'");

        result = DataBase.getData(stmt);

        while (result.next()) {
            //Chuyển ngày sinh
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date ngSinh = format.parse(result.getString(3));

            //Tạo đối tượng nhân viên, thêm vào mảng arrayList
            NhanVienPartTime nv = new NhanVienPartTime(result.getInt(7), result.getString(1), result.getString(2), ngSinh, result.getString(4), result.getString(5));
            kq.add(nv);
        }

        //Lấy danh sách nhân viên hợp đồng
        stmt = c.prepareStatement("SELECT * FROM NhanVien\n"
                + "JOIN NVHopDong \n"
                + "ON NhanVien.MaNV=NVHopDong.MaNV\n"
                + "WHERE NhanVien.HoTen LIKE '%" + key + "%' OR NhanVien.MaNV LIKE '%" + key + "%' OR NhanVien.CMND LIKE '%" + key + "%'");

        result = DataBase.getData(stmt);

        while (result.next()) {
            //Chuyển ngày sinh
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date ngSinh = format.parse(result.getString(3));

            //Tạo đối tượng nhân viên, thêm vào mảng arrayList
            NhanVienHopDong nv = new NhanVienHopDong(result.getInt(7), result.getString(1), result.getString(2), ngSinh, result.getString(4), result.getString(5));
            kq.add(nv);
        }
        return kq;
    }

    //Chức năng lọc loại nhân viên
    //02/01/2021
    //Hồ Sĩ Hùng
    public ArrayList<NhanVien> locLoaiNhanVien(int loaiNV) throws SQLException, ParseException {
        //LỌC NV TƯƠNG ỨNG THEO HỆ SỐ LOẠI NHÂN VIÊN
        //1 : NV CHÍNH THỨC
        //2 : NV HỢP ĐỒNG
        //3 : NV PART TIME
        ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
        switch (loaiNV) {
            case 1:

                PreparedStatement stmt = c.prepareStatement("SELECT * FROM NhanVien "
                        + "JOIN NVChinhThuc on NhanVien.MaNV = NVChinhThuc.MaNV;");

                ResultSet result = DataBase.getData(stmt);

                while (result.next()) {
                    //Chuyển ngày sinh
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date ngSinh = format.parse(result.getString(3));

                    //Tạo đối tượng nhân viên, thêm vào mảng arrayList
                    NhanVienChinhThuc nv = new NhanVienChinhThuc(result.getFloat(7),
                            result.getString(1), result.getString(2), ngSinh, result.getString(4), result.getString(5));
                    listNV.add(nv);
                }
                break;
            //NHÂN VIÊN HỢP ĐỒNG
            case 2:

                stmt = c.prepareStatement("SELECT * FROM NhanVien "
                        + "JOIN NVHopDong on NhanVien.MaNV = NVHopDong.MaNV;");

                result = DataBase.getData(stmt);

                while (result.next()) {
                    //Chuyển ngày sinh
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date ngSinh = format.parse(result.getString(3));

                    //Tạo đối tượng nhân viên, thêm vào mảng arrayList
                    NhanVienHopDong nv = new NhanVienHopDong(result.getInt(7),
                            result.getString(1), result.getString(2), ngSinh, result.getString(4), result.getString(5));
                    listNV.add(nv);
                }
                break;
            //NHÂN VIÊN PART TIME
            case 3:

                stmt = c.prepareStatement("SELECT * FROM NhanVien "
                        + "JOIN NVPartTime on NhanVien.MaNV = NVPartTime.MaNV;");

                result = DataBase.getData(stmt);

                while (result.next()) {
                    //Chuyển ngày sinh
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date ngSinh = format.parse(result.getString(3));

                    //Tạo đối tượng nhân viên, thêm vào mảng arrayList
                    NhanVienPartTime nv = new NhanVienPartTime(result.getInt(7),
                            result.getString(1), result.getString(2), ngSinh, result.getString(4), result.getString(5));
                    listNV.add(nv);
                }
                break;
            default:
                return listNV;
        }

        return listNV;
    }

    //Chức năng đăng nhập
    public boolean login(String user, String pass) throws SQLException {
        boolean result = false;
        String sql = "SELECT * FROM TAIKHOAN\n"
                + "WHERE USERNAME=? AND PASS=?";
        PreparedStatement statement = DataBase.getConnection().prepareStatement(sql);
        statement.setString(1, user);
        statement.setString(2, pass);
        int rowsInserted1 = statement.executeUpdate(); //Kiểm tra xem truy vấn có thành công hay không
        if (rowsInserted1 > 0) {
            result = true;
        }
        return result;
    }
}
