package com.example.btl_api.object;

import androidx.annotation.NonNull;

public class Course {
    private String MaHP, TenHP, SoTC, SL, SLDK;

    public Course(String maHP, String tenHP, String soTC, String SL, String SLDK) {
        MaHP = maHP;
        TenHP = tenHP;
        SoTC = soTC;
        this.SL = SL;
        this.SLDK = SLDK;
    }

    public String getSoTC() {
        return SoTC;
    }

    public void setSoTC(String soTC) {
        SoTC = soTC;
    }

    public String getSL() {
        return SL;
    }

    public void setSL(String SL) {
        this.SL = SL;
    }

    public String getSLDK() {
        return SLDK;
    }

    public void setSLDK(String SLDK) {
        this.SLDK = SLDK;
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

    @NonNull
    @Override
    public String toString() {
        return MaHP;
    }
}
