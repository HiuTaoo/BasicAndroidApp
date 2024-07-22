package com.example.btl_api.object;

import androidx.annotation.NonNull;

public class NienKhoa {
    private String Khoa;

    public NienKhoa(String khoa) {
        Khoa = khoa;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String khoa) {
        Khoa = khoa;
    }
    @NonNull
    @Override
    public String toString() {
        return Khoa;
    }
}
