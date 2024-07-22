package com.example.btl_api.object;

public class KQDK {
    private String ID, MaHP;
    private Boolean isDeleted;

    public KQDK(String ID, String maHP, Boolean isDeleted) {
        this.ID = ID;
        MaHP = maHP;
        this.isDeleted = isDeleted;
    }

    public KQDK(String ID, String maHP) {
        this.ID = ID;
        MaHP = maHP;
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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
