/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhanvien;

import java.util.Date;

/*
 * Nhân viên bán thời gian
 * Hồ Sĩ hùng
 * 30/12/2020
 */
public class NhanVienPartTime extends NhanVien {

    public static int LoaiNV = 3;

    //Fields
    private int soGioLam;
    public static int tienCong1h = 50000;

    //Properties
    public int getSoGioLam() {
        return soGioLam;
    }

    public void setSoGioLam(int soGioLam) {
        this.soGioLam = soGioLam;
    }

    public static int getTienCong1h() {
        return tienCong1h;
    }

    private static void setTienCong1h(int tienCong1h) {
        NhanVienPartTime.tienCong1h = tienCong1h;
    }

    //Constructor
    public NhanVienPartTime(int soGioLam, String maNV, String hoTen, Date ngSinh, String soCMND, String diaChi) {
        super(maNV, hoTen, ngSinh, soCMND, diaChi);
        this.soGioLam = soGioLam;
    }

    //Methods
    //Tinh tien thuong
    @Override
    public float tienThuong() {
        if (this.soGioLam > 50) {
            return (float) 0.3;
        } else if (this.soGioLam > 20) {
            return (float) 0.1;
        } else {
            return 0;
        }
    }

    //Tinh tien Luong
    @Override
    public float tinhLuong() {
        float kq = (this.soGioLam * tienCong1h) * (1 + tienThuong());
        return kq;
    }

    //Thay đổi tiền công một giờ
    public static void thayDoiTienCong1h(int value) {
        tienCong1h = value;
    }

    //ToString
    @Override
    public String toString() {
        String kq = "NhanVienPartTime{" + "soGioLam=" + soGioLam + '}';

        return kq;
    }

}
