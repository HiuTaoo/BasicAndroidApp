package com.example.btl_api.object;

public class TKSinhVien {
    private String ID;
    private String PassWordSV;

    public TKSinhVien(String ID, String passWordSV) {
        this.ID = ID;
        PassWordSV = passWordSV;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassWordSV() {
        return PassWordSV;
    }

    public void setPassWordSV(String passWordSV) {
        PassWordSV = passWordSV;
    }
}
