package com.example.btl_api.object;

public class sinhVienClass {
    private String ID;
    private String HoTen;
    private String GioiTinh, NgaySinh, SDT, DiaChi, MaKhoa, Khoa, Email;

    public sinhVienClass(String ID, String hoTen, String gioiTinh, String ngaySinh, String SDT, String diaChi, String maKhoa, String khoa) {
        this.ID = ID;
        HoTen = hoTen;
        GioiTinh = gioiTinh;
        NgaySinh = ngaySinh;
        this.SDT = SDT;
        DiaChi = diaChi;
        MaKhoa = maKhoa;
        Khoa = khoa;
    }

    public sinhVienClass(String ID, String hoTen, String gioiTinh, String ngaySinh, String SDT, String diaChi, String maKhoa, String khoa, String email) {
        this.ID = ID;
        HoTen = hoTen;
        GioiTinh = gioiTinh;
        NgaySinh = ngaySinh;
        this.SDT = SDT;
        DiaChi = diaChi;
        MaKhoa = maKhoa;
        Khoa = khoa;
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        MaKhoa = maKhoa;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String khoa) {
        Khoa = khoa;
    }
}
