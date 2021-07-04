/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhanvien;

import java.util.Date;

/*
 * Class NhanVien
 * Hồ Sĩ Hùng 31/12/2020
 */
public abstract  class NhanVien {
    //Fields
    protected String maNV;
    protected String hoTen;
    protected Date ngSinh;
    protected String soCMND;
    protected String diaChi;
    
    //Properties

    public String getMaNV() {
        return maNV;
    }

    private void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgSinh() {
        return ngSinh;
    }

    public void setNgSinh(Date ngSinh) {
        this.ngSinh = ngSinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    //Constructor

    public NhanVien(String maNV, String hoTen, Date ngSinh, String soCMND, String diaChi) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngSinh = ngSinh;
        this.soCMND = soCMND;
        this.diaChi = diaChi;
    }
    
    //Methods
    //Tinh tien thuong
    public abstract float tienThuong();
    
    //Tinh Luong
    public abstract  float tinhLuong();
    
    //To String

    @Override
    public String toString() {
        String kq = String.format("%-30s : %s%n", "Họ và tên", this.hoTen);
        kq += String.format("%-30s : %s%n", "Ngày sinh", this.ngSinh);
        kq += String.format("%-30s : %s%n", "CMND", this.soCMND);
        kq += String.format("%-30s : %s%n", "Địa chỉ", this.diaChi);
        
        return kq;
    }
}
