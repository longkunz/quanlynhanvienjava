/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhanvien;

import java.util.Date;

/*
 * Nhân viên hợp đồng
 * Hồ Sĩ Hùng
 * 31/12/2020
 */
public class NhanVienHopDong extends NhanVien {

    public static int LoaiNV = 2;

    //Fields
    private int soNgayCong;
    public static int soTienCongMoiNgay = 80000;

    //Properties
    public int getSoNgayCong() {
        return soNgayCong;
    }

    public void setSoNgayCong(int soNgayCong) {
        this.soNgayCong = soNgayCong;
    }

    public static int getSoTienCongMoiNgay() {
        return soTienCongMoiNgay;
    }

    private static void setSoTienCongMoiNgay(int soTienCongMoiNgay) {
        NhanVienHopDong.soTienCongMoiNgay = soTienCongMoiNgay;
    }

    //Constructor
    public NhanVienHopDong(int soNgayCong, String maNV, String hoTen, Date ngSinh, String soCMND, String diaChi) {
        super(maNV, hoTen, ngSinh, soCMND, diaChi);
        this.soNgayCong = soNgayCong;
    }

    //Methods
    //Tinh tien thuong
    @Override
    public float tienThuong() {
        if (soNgayCong > 25) {
            return (float) 0.3;
        } else {
            if (soNgayCong > 15) {
                return (float) 0.2;
            } else {
                return 0;
            }
        }
    }

    //Tinh tien luong
    @Override
    public float tinhLuong() {
        float kq = (this.soNgayCong * soTienCongMoiNgay) * (1 + tienThuong());
        return kq;
    }

    //Thay đổi hệ số tiền công 1 ngày
    public static void thayDoiTienCong1Ngay(int value) {
        soTienCongMoiNgay = value;
    }

}
