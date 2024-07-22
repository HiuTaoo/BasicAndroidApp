package com.example.btl_api.object;

import androidx.annotation.NonNull;

public class HP  {
    private String MaHP, TenHP, MaCTHP, Start, End, Ca, Thu, Phong, SoTC ,SL;

    public HP(String maHP, String tenHP, String tin, String SL) {
        MaHP = maHP;
        TenHP = tenHP;
        SoTC = tin;
        this.SL = SL;
    }



    public String getSL() {
        return SL;
    }

    public void setSL(String SL) {
        this.SL = SL;
    }

    public String getPhong() {
        return Phong;
    }

    public void setPhong(String phong) {
        Phong = phong;
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

    public String getMaCTHP() {
        return MaCTHP;
    }

    public void setMaCTHP(String maCTHP) {
        MaCTHP = maCTHP;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }

    public String getCa() {
        return Ca;
    }

    public void setCa(String ca) {
        Ca = ca;
    }

    public String getThu() {
        return Thu;
    }

    public void setThu(String thu) {
        Thu = thu;
    }

    @NonNull
    @Override
    public String toString() {
        return MaHP;
    }

}
