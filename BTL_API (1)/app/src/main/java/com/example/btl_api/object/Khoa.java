package com.example.btl_api.object;

import androidx.annotation.NonNull;

public class Khoa {
    private String MaKhoa;

    public String getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        MaKhoa = maKhoa;
    }

    public Khoa(String maKhoa) {
        MaKhoa = maKhoa;
    }

    @NonNull
    @Override
    public String toString() {
        return MaKhoa;
    }
}
