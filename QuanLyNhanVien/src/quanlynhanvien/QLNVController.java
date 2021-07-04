/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhanvien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Array;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Controller QLNV
 * Hồ Sĩ Hùng
    31/12/2020
 */
public class QLNVController {

    private QLNVModel model;
    private QLNVView view;
    private QLNVLogin login;

    //Constructor
    public QLNVController(QLNVModel model, QLNVView view, QLNVLogin login) throws SQLException, ParseException {
        this.model = model;
        this.view = view;
        this.login = login;
        view.getCboLoaiNhanVien().setSelectedIndex(0);

        //KHÓA CHỨC NĂNG CẬP NHẬP HỆ SỐ
        khoa_MoKhoaCapNhapHeSo(false);
        view.getCboLoaiNhanVienCapNhap().setSelectedIndex(0);

        //Không cho phép enbale txtThongSoStatic
        //Để thay đổi biến này cần sử dụng chức năng CẬP NHẬP HỆ SỐ
        view.getTxtThongSoStatic().setEnabled(false);

        //Hiển thị toàn bộ nhân viên ra màn hình
        showTableNhanVien(model.getAllData());

        //Hiển thị thông tin nhân viên khi click vào table
        view.getTableNhanVien().addMouseListener(hienThiThongTinNV());

        //Sự kiện khi click nút Sửa
        view.getBtnSua().addActionListener(suaListener());

        //Gán sự kiện cho button thêm
        view.getBtnThem().addActionListener(themListener());

        //Gán sự kiện thay đổi label khi thay đổi index của combobox Loại nhân viên
        view.getCboLoaiNhanVien().addActionListener(chonCombobox());

        //Gán sự kiện cho button Xóa
        view.getBtnXoa().addActionListener(xoaListener());

        //Gán sự kiện cho cbb sắp xếp
        view.getCbbSapXep().addActionListener(tuyChonSapXep());

        //Gán sự kiện cho button tìm kiếm
        view.getBtnSearch().addActionListener(timKiemListener());

        //Gán sự kiện lọc loại nhân viên
        view.getCboLocLoaiNhanVien().setSelectedIndex(0);
        view.getCboLocLoaiNhanVien().addActionListener(locLoaiNVListener());

        //Gán sự kiện khi checkBox CẬP NHẬP HỆ SỐ thay đổi trạng thái
        view.getChkCapNhapHeSo().addActionListener(capNhapHeSoListerner());

        //Gán sự kiện thay đổi label khi thay đổi index của combobox Loại nhân viên TRONG CHỨC NĂNG CẬP NHẬP HỆ SỐ
        view.getCboLoaiNhanVienCapNhap().addActionListener(chonComboboxLoaiNVCNHS());

        //Gán sự kiện cho nút HỦY CHỨC NĂNG CẬP NHẬP HỆ SỐ
        view.getBtnHuyCapNhapHeSo1().addActionListener(huyCapNhapHeSoListener());

        //Gán sự kiện cho nút CẬP NHẬP CHỨC NĂNG CẬP NHẬP HỆ SỐ
        view.getBtnCapNhapHeSo().addActionListener(btnCapNhapHeSo());

        //Gán sự kiến nút đăng nhập
        login.getBtnLogin().addActionListener(loginListener());

        //Gán sự kiện nút thoát
        login.getBtnExit().addActionListener(exitListener());
    }

    //Hàm hiển thị nhân viên
    //Hồ Sĩ Hùng 01/01/2021
    private void showTableNhanVien(ArrayList<NhanVien> listNV) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableNhanVien().getModel();
        tableModel.setColumnCount(0);
        tableModel.setRowCount(0);
        tableModel.addColumn("Mã NV");
        tableModel.addColumn("Họ tên");
        tableModel.addColumn("Ngày sinh");
        tableModel.addColumn("CMND");
        tableModel.addColumn("Địa chỉ");
        tableModel.addColumn("Loại nhân viên");
        tableModel.addColumn("Hệ số thưởng");
        tableModel.addColumn("Lương");

        for (NhanVien nv : listNV) {
            String formatNgSinh = String.format("%tY-%tm-%td", nv.getNgSinh(), nv.getNgSinh(), nv.getNgSinh());

            //Xử lý loại nhân viên
            int loaiNV = 0;

            if (nv instanceof NhanVienHopDong) {
                loaiNV = NhanVienHopDong.LoaiNV;

                String tienLuong = String.format("%,.0f", nv.tinhLuong());

                tableModel.addRow(new Object[]{nv.getMaNV(), nv.getHoTen(), formatNgSinh, nv.getSoCMND(), nv.getDiaChi(), loaiNV,
                    nv.tienThuong(), tienLuong});
            } else if (nv instanceof NhanVienChinhThuc) {
                loaiNV = NhanVienChinhThuc.LoaiNV;

                String tienLuong = String.format("%,.0f", nv.tinhLuong());

                tableModel.addRow(new Object[]{nv.getMaNV(), nv.getHoTen(), formatNgSinh, nv.getSoCMND(), nv.getDiaChi(),
                    loaiNV, nv.tienThuong(), tienLuong});
            } else if (nv instanceof NhanVienPartTime) {
                loaiNV = NhanVienPartTime.LoaiNV;

                String tienLuong = String.format("%,.0f", nv.tinhLuong());

                tableModel.addRow(new Object[]{nv.getMaNV(), nv.getHoTen(), formatNgSinh, nv.getSoCMND(), nv.getDiaChi(),
                    loaiNV, nv.tienThuong(), tienLuong});
            }

        }

        //Hiển thị danh sách nhân viên
        view.getTableNhanVien().setModel(tableModel);

        //Mở combobox loại nhân viên
        view.getCboLoaiNhanVien().setEnabled(true);
    }

    //Hàm hiển thị thông tin nhân viên khi click vào bảng
    //Hồ Sĩ Hùng 01/01/2021
    //Cập nhập thêm ngày 02/01/2021
    private MouseListener hienThiThongTinNV() {
        return new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int iSelectedRows = view.getTableNhanVien().getSelectedRow();

                //Hiển thị dữ liệu
                String maNV = (String) view.getTableNhanVien().getValueAt(iSelectedRows, 0);
                view.getTxtMaNV().setText(maNV);

                view.getTxtHoTen().setText((String) view.getTableNhanVien().getValueAt(iSelectedRows, 1));

                view.getTxtNgaySinh().setText((String) view.getTableNhanVien().getValueAt(iSelectedRows, 2));

                view.getTxtCMND().setText((String) view.getTableNhanVien().getValueAt(iSelectedRows, 3));

                view.getTxtDiaChi().setText((String) view.getTableNhanVien().getValueAt(iSelectedRows, 4));

                //Xử lý combobox
                int loaiNV = Integer.parseInt(view.getTableNhanVien().getValueAt(iSelectedRows, 5).toString());

                view.getCboLoaiNhanVien().setSelectedIndex(loaiNV - 1);

                //HIỂN THỊ THÔNG TIN ĐI KÈM
                //Lấy danh sách kết quả tìm kiếm nhân viên
                switch (loaiNV) {
                    case 1:
                        ArrayList<NhanVienChinhThuc> listNVCT = new ArrayList<NhanVienChinhThuc>();
                        try {
                            listNVCT = model.timKiemThongTinPhu(maNV, NhanVienChinhThuc.LoaiNV);
                        } catch (SQLException ex) {
                            Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ParseException ex) {
                            Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        float heSoLuong = listNVCT.get(0).getHeSoLuong();

                        view.getTxtThongSoNhanVien().setText(Float.toString(heSoLuong));
                        view.getTxtThongSoStatic().setText(Integer.toString(NhanVienChinhThuc.tienLuongCoBan));
                        break;
                    case 2:
                        //Lấy danh sách kết quả tìm kiếm nhân viên
                        ArrayList<NhanVienHopDong> listNVHD = new ArrayList<NhanVienHopDong>();
                        try {
                            listNVHD = model.timKiemThongTinPhu(maNV, NhanVienHopDong.LoaiNV);
                        } catch (SQLException ex) {
                            Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ParseException ex) {
                            Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        int soNgayCong = listNVHD.get(0).getSoNgayCong();

                        view.getTxtThongSoNhanVien().setText(Integer.toString(soNgayCong));
                        view.getTxtThongSoStatic().setText(Integer.toString(NhanVienHopDong.soTienCongMoiNgay));
                        break;

                    case 3:
                        //Lấy danh sách kết quả tìm kiếm nhân viên
                        ArrayList<NhanVienPartTime> listNVPT = new ArrayList<NhanVienPartTime>();
                        try {
                            listNVPT = model.timKiemThongTinPhu(maNV, NhanVienPartTime.LoaiNV);
                        } catch (SQLException ex) {
                            Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ParseException ex) {
                            Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        int soGioLam = listNVPT.get(0).getSoGioLam();

                        view.getTxtThongSoNhanVien().setText(Integer.toString(soGioLam));
                        view.getTxtThongSoStatic().setText(Integer.toString(NhanVienPartTime.tienCong1h));
                        break;
                    default:
                        return;
                }
            }
        };

    }

    //Hàm thêm dữ liệu vào cơ sở dữ liệu
    //Hồ Viết Long 01/01/2020
    private ActionListener themListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!"".equals(view.getTxtMaNV().getText()) && !"".equals(view.getTxtCMND().getText()) && view.getTxtDiaChi().getText() != ""
                        && !"".equals(view.getTxtHoTen().getText()) && view.getTxtNgaySinh().getText() != "" && view.getTxtThongSoNhanVien().getText() != "") {
                    String maNV = view.getTxtMaNV().getText();
                    String hoTen = view.getTxtHoTen().getText();

                    //Xử lý ngày sinh
                    String ngaySinh = view.getTxtNgaySinh().getText();
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date ngSinh = null;
                    try {
                        ngSinh = format.parse(ngaySinh);

                    } catch (ParseException ex) {
                        Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    String cmnd = view.getTxtCMND().getText();
                    String diaChi = view.getTxtDiaChi().getText();
                    String thongSo = view.getTxtThongSoNhanVien().getText();
                    int index = view.getCboLoaiNhanVien().getSelectedIndex();

                    switch (index) {
                        case 0:
                            NhanVienChinhThuc nvct = new NhanVienChinhThuc(Float.parseFloat(thongSo), maNV, hoTen, ngSinh, cmnd, diaChi);
                            try {
                                if (model.themNhanVien(nvct) && model.themNhanVienChinhThuc(nvct)) {
                                    JOptionPane.showMessageDialog(view, "Thêm thành công!");
                                    deleteFields();
                                } else {
                                    JOptionPane.showMessageDialog(view, "Thêm không thành công!");
                                }
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                            break;
                        case 1:
                            NhanVienHopDong nvhd = new NhanVienHopDong(Integer.parseInt(thongSo), maNV, hoTen, ngSinh, cmnd, diaChi);
                            try {
                                if (model.themNhanVien(nvhd) && model.themNhanVienHopDong(nvhd)) {
                                    JOptionPane.showMessageDialog(view, "Thêm thành công!");
                                    deleteFields();
                                } else {
                                    JOptionPane.showMessageDialog(view, "Thêm không thành công!");
                                }
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                            break;
                        case 2:
                            NhanVienPartTime nvtv = new NhanVienPartTime(Integer.parseInt(thongSo), maNV, hoTen, ngSinh, cmnd, diaChi);
                            try {
                                if (model.themNhanVien(nvtv) && model.themNhanVienThoiVu(nvtv)) {
                                    JOptionPane.showMessageDialog(view, "Thêm thành công!");
                                    deleteFields();
                                } else {
                                    JOptionPane.showMessageDialog(view, "Thêm không thành công!");
                                }
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                            break;
                        default:
                            break;
                    }

                } else {
                    JOptionPane.showMessageDialog(view, "Không được để trống dữ liệu");
                }

                //Hiển thị nhân viên ra màn hình
                try {
                    showTableNhanVien(model.getAllData());
                } catch (SQLException ex) {
                    Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
    }

    //Hàm thêm textbox khi chọn loại nhân viên
    //Hồ Viết Long 01/01/2020
    //Hồ Sĩ Hùng cập nhập ngày 02/01/2020
    private ActionListener chonCombobox() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = view.getCboLoaiNhanVien().getSelectedIndex();
                switch (i) {
                    case 0:
                        view.getLbThongSoNhanVien().setText("Hệ số lương");
                        view.getLbThongSoStatic().setText("Lương cơ bản");
                        break;
                    case 1:
                        view.getLbThongSoNhanVien().setText("Số ngày làm");
                        view.getLbThongSoStatic().setText("Số tiền công mỗi ngày");
                        break;
                    case 2:
                        view.getLbThongSoNhanVien().setText("Số giờ làm");
                        view.getLbThongSoStatic().setText("Số tiền công một giờ");
                        break;
                }
            }
        };
    }

    //Sự kiện khi click nút Sửa
    //Hồ Sĩ Hùng, Lê Tuấn Liêm, Hồ Viết Long
    //01/01/2021
    private ActionListener suaListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getTxtHoTen().getText().trim().length() == 0 || view.getTxtNgaySinh().getText().trim().length() == 0 || view.getTxtDiaChi().getText().trim().length() == 0 || view.getTxtCMND().getText().trim().length() == 0) {
                    JOptionPane.showMessageDialog(view, "Bạn phải điền đầy đủ dữ liệu !!");
                } else {
                    //Đóng combobox loại nhân viên, mã nhân viên
                    view.getCboLoaiNhanVien().setEnabled(false);

                    //Sai tìm long nha
                    try {
                        if (view.getCboLoaiNhanVien().getSelectedIndex() == 0) {
                            if (model.updateInforNhanVien(view.getTxtMaNV().getText(), view.getTxtHoTen().getText(),
                                    view.getTxtNgaySinh().getText(), view.getTxtCMND().getText(), view.getTxtDiaChi().getText()) > 0
                                    && model.updateNhanVienChinhThuc(view.getTxtMaNV().getText(), Float.parseFloat(view.getTxtThongSoNhanVien().getText())) != 0) {
                                JOptionPane.showMessageDialog(view, "Sửa thành công !!");
                                deleteFields();
                            } else {
                                JOptionPane.showMessageDialog(view, "Sửa thất bại !!");
                            }
                            showTableNhanVien(model.getAllData());
                        } else if (view.getCboLoaiNhanVien().getSelectedIndex() == 1) {
                            if (model.updateInforNhanVien(view.getTxtMaNV().getText(), view.getTxtHoTen().getText(),
                                    view.getTxtNgaySinh().getText(), view.getTxtCMND().getText(), view.getTxtDiaChi().getText()) > 0
                                    && model.updateNhanVienHopDong(view.getTxtMaNV().getText(), Integer.parseInt(view.getTxtThongSoNhanVien().getText())) != 0) {
                                JOptionPane.showMessageDialog(view, "Sửa thành công !!");
                                deleteFields();
                            } else {
                                JOptionPane.showMessageDialog(view, "Sửa thất bại !!");
                            }
                            showTableNhanVien(model.getAllData());
                        } else {
                            if (model.updateInforNhanVien(view.getTxtMaNV().getText(), view.getTxtHoTen().getText(),
                                    view.getTxtNgaySinh().getText(), view.getTxtCMND().getText(), view.getTxtDiaChi().getText()) > 0
                                    && model.updateNhanVienThoiVu(view.getTxtMaNV().getText(), Integer.parseInt(view.getTxtThongSoNhanVien().getText())) != 0) {
                                JOptionPane.showMessageDialog(view, "Sửa thành công !!");
                                deleteFields();
                            } else {
                                JOptionPane.showMessageDialog(view, "Sửa thất bại !!");
                            }
                            showTableNhanVien(model.getAllData());
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
    }

    //Xóa dữ liệu
    //Lê Tuấn Liêm 01/01/2020
    private ActionListener xoaListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Kiểm tra nhập
                if (view.getTxtMaNV().getText().length() == 0) {
                    JOptionPane.showMessageDialog(view, "Bạn phải chọn dữ liệu cần xóa !!");
                } else {

                    String LoaiNhanVien = "";
                    //Hỏi khách hàng có chắc chắn muốn xóa ko
                    if (JOptionPane.showConfirmDialog(view, "Bạn thực sự muốn xóa không ??") == JOptionPane.YES_OPTION) {
                        //Xét loại nhân viên
                        if ((int) view.getTableNhanVien().getValueAt(0, 5) == 1) {
                            LoaiNhanVien = "NVChinhThuc";
                        } else if ((int) view.getTableNhanVien().getValueAt(0, 5) == 2) {
                            LoaiNhanVien = "NVHopDong";
                        } else if ((int) view.getTableNhanVien().getValueAt(0, 5) == 3) {
                            LoaiNhanVien = "NVPartTime";
                        }
                        try {
                            //Phần xóa nhiều dòng cùng 1 lúc
                            if (view.getTableNhanVien().getSelectedRowCount() > 1) {
                                int kq = 0;
                                int[] listSelect = view.getTableNhanVien().getSelectedRows();
                                for (int i = 0; i <= listSelect.length - 1; i++) {
                                    if ((int) view.getTableNhanVien().getValueAt(listSelect[i], 5) == 1) {
                                        LoaiNhanVien = "NVChinhThuc";
                                    } else if ((int) view.getTableNhanVien().getValueAt(listSelect[i], 5) == 2) {
                                        LoaiNhanVien = "NVHopDong";
                                    } else if ((int) view.getTableNhanVien().getValueAt(listSelect[i], 5) == 3) {
                                        LoaiNhanVien = "NVPartTime";
                                    }
                                    JOptionPane.showMessageDialog(view, (String) view.getTableNhanVien().getValueAt(listSelect[i], 0));
                                    if (model.deleteData((String) view.getTableNhanVien().getValueAt(listSelect[i], 0), LoaiNhanVien) != 0) {
                                        kq++;
                                    }
                                }
                                if (kq > 0) {
                                    JOptionPane.showMessageDialog(view, "Xoá thành công!");
                                } else {
                                    JOptionPane.showMessageDialog(view, "Xoá thất bại");
                                }

                            } else {
                                if (model.deleteData(view.getTxtMaNV().getText(), LoaiNhanVien) > 0) {
                                    JOptionPane.showMessageDialog(view, "Xoá thành công !!");
                                    deleteFields();

                                } else {
                                    JOptionPane.showMessageDialog(view, "Xoá thất bại !!");
                                }
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

                try {
                    showTableNhanVien(model.getAllData());
                } catch (SQLException ex) {
                    Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
    }

    //Hàm sắp xếp theo loại tùy chọn
    //Hồ Viết Long 01/01/2020
    private ActionListener tuyChonSapXep() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = view.getCbbSapXep().getSelectedIndex();
                switch (i) {
                    case 0: {
                        try {
                            //Hiển thị nhân viên ra màn hình
                            showTableNhanVien(model.getAllData());
                        } catch (SQLException ex) {
                            Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ParseException ex) {
                            Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    case 1: {
                        try {
                            //Hiển thị nhân viên ra màn hình
                            showTableNhanVien(model.sapXepTheoMa(view.getCboLocLoaiNhanVien().getSelectedIndex()));
                        } catch (SQLException ex) {
                            Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ParseException ex) {
                            Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                    case 2: {
                        try {
                            //Hiển thị nhân viên ra màn hình
                            showTableNhanVien(model.sapXepTheoTen(view.getCboLocLoaiNhanVien().getSelectedIndex()));
                        } catch (SQLException ex) {
                            Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ParseException ex) {
                            Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                    case 3: {
                        try {
                            //Hiển thị nhân viên ra màn hình
                            showTableNhanVien(model.sapXepTheoLuong(view.getCboLocLoaiNhanVien().getSelectedIndex()));
                        } catch (SQLException ex) {
                            Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ParseException ex) {
                            Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                }
            }
        };
    }

    //Hàm tìm kiếm theo tên hoặc mã nhân viên, hoặc sô CMND
    //Kết quả tìm kiếm là gần đúng
    //Hồ Viết Long, Lê Tuấn Liêm
    //01/01/2020
    private ActionListener timKiemListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = view.getTxtKey().getText();
                if (!key.equals("")) {
                    try {
                        showTableNhanVien(model.searchNhanVien(key));
                    } catch (SQLException ex) {
                        Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        //Hiển thị nhân viên ra màn hình
                        showTableNhanVien(model.getAllData());
                    } catch (SQLException ex) {
                        Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
    }

    //Lọc loại nhân viên
    //Hồ Sĩ Hùng
    //02/01/2020
    private ActionListener locLoaiNVListener() throws SQLException, ParseException {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int loaiNV = view.getCboLocLoaiNhanVien().getSelectedIndex();

                if (loaiNV == 0) {
                    //HIÊN THỊ TOÀN BỘ NHÂN VIÊN 
                    try {
                        showTableNhanVien(model.getAllData());
                    } catch (SQLException ex) {
                        Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    //HIÊN THỊ Nhân viên theo loại
                    try {
                        showTableNhanVien(model.locLoaiNhanVien(loaiNV));
                    } catch (SQLException ex) {
                        Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
    }

    //Hàm mở khóa/ khóa chức năng CẬP NHẬP HỆ SỐ
    //02/01/2021
    //Hồ Sĩ Hùng
    private void khoa_MoKhoaCapNhapHeSo(boolean value) {
        view.getTxtThongSoStaticCapNhap().setEnabled(value);
        view.getLbThongSoStaticCapNhap().setEnabled(value);
        view.getLbCapNhapHeSo().setEnabled(value);
        view.getCboLoaiNhanVienCapNhap().setEnabled(value);
        khoa_MoKhoaButtonCapNhapHeSo(value);
    }

    //Hàm mở khóa/ khóa nút cập nhập/ hủy CẬP NHẬP HỆ SỐ
    //02/01/2021
    //Hồ Sĩ Hùng
    private void khoa_MoKhoaButtonCapNhapHeSo(boolean value) {
        view.getBtnCapNhapHeSo().setEnabled(value);
        view.getBtnHuyCapNhapHeSo1().setEnabled(value);
    }

    //CHỨC NĂNG CẬP NHẬP HỆ SỐ
    //02/01/2021
    //Hồ Sĩ Hùng
    private ActionListener capNhapHeSoListerner() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = view.getChkCapNhapHeSo().isSelected();

                khoa_MoKhoaCapNhapHeSo(state);
            }
        };
    }

    //Sự kiện thay đổi label khi thay đổi index của combobox Loại nhân viên TRONG CHỨC NĂNG CẬP NHẬP HỆ SỐ
    //Hồ Sĩ Hùng
    //02/01/2021
    private ActionListener chonComboboxLoaiNVCNHS() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = view.getCboLoaiNhanVienCapNhap().getSelectedIndex();
                switch (index) {
                    case 0:
                        view.getLbThongSoStaticCapNhap().setText("Lương cơ bản");
                        break;
                    case 1:
                        view.getLbThongSoStaticCapNhap().setText("Tiền công một ngày");
                        break;
                    case 2:
                        view.getLbThongSoStaticCapNhap().setText("Tiền công một giờ");
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        };
    }

    //Sự kiện nút HỦY CHỨC NĂNG CẬP NHẬP HỆ SỐ
    private ActionListener huyCapNhapHeSoListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCboLoaiNhanVienCapNhap().setSelectedIndex(0);

                view.getTxtThongSoStaticCapNhap().setText("");

                view.getChkCapNhapHeSo().setSelected(false);

                khoa_MoKhoaCapNhapHeSo(false);
            }
        };
    }

    //Sư kiện nút cập nhập CHỨC NĂNG CẬP NHẬP HỆ SỐ
    //Hồ Sĩ Hùng
    //02/01/2021
    private ActionListener btnCapNhapHeSo() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(view, "Bạn thực sự muốn thay đổi?\n"
                        + "Điều này sẽ ảnh hưởng tới dữ liệu toàn cục!") == JOptionPane.YES_OPTION) {
                    int index = view.getCboLoaiNhanVienCapNhap().getSelectedIndex();

                    switch (index) {
                        case 0:
                            int luongCB = Integer.parseInt(view.getTxtThongSoStaticCapNhap().getText());
                            NhanVienChinhThuc.thayDoiLuongCoBan(luongCB);

                            JOptionPane.showMessageDialog(view, "Cập nhập thành công!");

                             {
                                try {
                                    showTableNhanVien(model.getAllData());
                                } catch (SQLException ex) {
                                    Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (ParseException ex) {
                                    Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            break;
                        case 1:
                            int tienCongMoiNgay = Integer.parseInt(view.getTxtThongSoStaticCapNhap().getText());
                            NhanVienHopDong.thayDoiTienCong1Ngay(tienCongMoiNgay);

                            JOptionPane.showMessageDialog(view, "Cập nhập thành công!");

                             {
                                try {
                                    showTableNhanVien(model.getAllData());
                                } catch (SQLException ex) {
                                    Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (ParseException ex) {
                                    Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            break;
                        case 2:
                            int tienCong1H = Integer.parseInt(view.getTxtThongSoStaticCapNhap().getText());
                            NhanVienPartTime.thayDoiTienCong1h(tienCong1H);

                            JOptionPane.showMessageDialog(view, "Cập nhập thành công!");

                             {
                                try {
                                    showTableNhanVien(model.getAllData());
                                } catch (SQLException ex) {
                                    Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (ParseException ex) {
                                    Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            break;
                        default:
                            throw new AssertionError();
                    }

                    //Khôi phục trạng thái ban đầu
                    view.getCboLoaiNhanVienCapNhap().setSelectedIndex(0);

                    view.getTxtThongSoStaticCapNhap().setText("");

                    view.getChkCapNhapHeSo().setSelected(false);

                    khoa_MoKhoaCapNhapHeSo(false);

                    view.getCbbSapXep().setSelectedIndex(0);
                    view.getCboLocLoaiNhanVien().setSelectedIndex(0);
                }
            }
        };
    }

    //Sự kiện kiểm tra tài khoản cho chức năng login
    private ActionListener loginListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!login.getTxtUser().getText().equals("") && !login.getTxtPass().getText().equals("")) {
                    login.setVisible(false);
                    view.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(login, "Không được để trống!!!");
                }
            }
        };
    }

    //Sự kiện thoát khi nhấn Exit ở form login
    private ActionListener exitListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login.dispose();
            }
        };
    }

    //Hàm xóa hết dữ liệu trong fields
    void deleteFields() {
        view.getTxtCMND().setText("");
        view.getTxtDiaChi().setText("");
        view.getTxtHoTen().setText("");
        view.getTxtMaNV().setText("");
        view.getTxtNgaySinh().setText("");
        view.getTxtThongSoNhanVien().setText("");
    }
}
