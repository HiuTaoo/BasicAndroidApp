package com.example.btl_api.object;

public class LichThi {
    private String ID, MaHP, TenHP, NgayThi, ThoiGian, HinhThuc, PhongThi, SBD;

    public LichThi(String ID, String maHP, String tenHP, String ngayThi, String thoiGian, String hinhThuc, String phongThi, String SBD) {
        this.ID = ID;
        MaHP = maHP;
        TenHP = tenHP;
        NgayThi = ngayThi;
        ThoiGian = thoiGian;
        HinhThuc = hinhThuc;
        PhongThi = phongThi;
        this.SBD = SBD;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaHP() {
        return MaHP;
    }

    public void setMaHP(String maHP) {
        MaHP = maHP;
    }

    public String getTenHP() {
        return TenHP;
    }

    public void setTenHP(String tenHP) {
        TenHP = tenHP;
    }

    public String getNgayThi() {
        return NgayThi;
    }

    public void setNgayThi(String ngayThi) {
        NgayThi = ngayThi;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String thoiGian) {
        ThoiGian = thoiGian;
    }

    public String getHinhThuc() {
        return HinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        HinhThuc = hinhThuc;
    }

    public String getPhongThi() {
        return PhongThi;
    }

    public void setPhongThi(String phongThi) {
        PhongThi = phongThi;
    }

    public String getSBD() {
        return SBD;
    }

    public void setSBD(String SBD) {
        this.SBD = SBD;
    }
}
