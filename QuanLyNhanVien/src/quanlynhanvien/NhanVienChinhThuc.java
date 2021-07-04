/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhanvien;

import java.util.Date;

/*
 * Hồ Sĩ Hùng
 * 31/12/2020
 */
public class NhanVienChinhThuc extends NhanVien {
    public static int LoaiNV = 1;

    //Fields
    public static int tienLuongCoBan = 4000000;
    private float heSoLuong;

    //Properties

    public static int getTienLuongCoBan() {
        return tienLuongCoBan;
    }

    private  static void setTienLuongCoBan(int tienLuongCoBan) {
        NhanVienChinhThuc.tienLuongCoBan = tienLuongCoBan;
    }

    public float getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(float heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    //Constructor
    public NhanVienChinhThuc(float heSoLuong, String maNV, String hoTen, Date ngSinh, String soCMND, String diaChi) {
        super(maNV, hoTen, ngSinh, soCMND, diaChi);
        this.heSoLuong = heSoLuong;
    }

    //Methods
    //Tinh tien thuong
    @Override
    public float tienThuong() {
        if (this.heSoLuong >= 2) {
            return (float) 0.25;
        } else if (this.heSoLuong >= 1.5) {
            return (float) 0.2;
        } else {
            return 0;
        }
    }

    //Tinh luong
    @Override
    public float tinhLuong() {
        float kq = ((float) this.tienLuongCoBan * this.heSoLuong) * (1 + tienThuong());
        return kq;
    }

    //Thay đổi hệ số lương
    public static void thayDoiLuongCoBan(int value) {
        tienLuongCoBan = value;
    }
}
