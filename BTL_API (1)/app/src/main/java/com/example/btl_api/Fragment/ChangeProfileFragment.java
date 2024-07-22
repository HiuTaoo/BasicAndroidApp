package com.example.btl_api.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.btl_api.Main;
import com.example.btl_api.R;
import com.example.btl_api.object.SinhVien;
import com.example.btl_api.retrofit.SV;
import com.example.btl_api.retrofit.SVUntils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangeProfileFragment extends Fragment {
    EditText hoten,  ngaysinh, diachi, sdt,mail;
    Button Ok;
    SV sv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_profile, container, false);
        sv = SVUntils.getService();
        Main mainActivity = (Main) getActivity();

        hoten = view.findViewById(R.id.hoten);
        ngaysinh = view.findViewById(R.id.ngaysinh);
        diachi = view.findViewById(R.id.diachi);
        sdt = view.findViewById(R.id.sdt);
        mail = view.findViewById(R.id.mail);
        Ok = view.findViewById(R.id.btnOK);

        sv.getInfoByID(mainActivity.getID().toString()).enqueue(new Callback<SinhVien>() {
            @Override
            public void onResponse(Call<SinhVien> call, Response<SinhVien> response) {
                if(response.isSuccessful()){
                    SinhVien s = response.body();
                    if(s.getHoTen() != null)
                    hoten.setText(s.getHoTen().toString().trim());
                    /*String ngaySinh = s.getNgaySinh();

                    SimpleDateFormat sdfInput = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
                    SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-M-d");

                    try {
                        Date date = sdfInput.parse(ngaySinh);
                        String ngaySinhMongMuon = sdfOutput.format(date);
                        ngaysinh.setText(ngaySinhMongMuon);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }*/
                    if(s.getNgaySinh() != null)
                        ngaysinh.setText(s.getNgaySinh().toString().trim());
                    if(s.getSDT() != null)
                        sdt.setText(s.getSDT().toString().trim());
                    if(s.getEmail() != null)
                        mail.setText(s.getEmail().toString().trim());
                    if(s.getDiaChi() != null)
                        diachi.setText(s.getDiaChi().toString().trim());


                }
            }

            @Override
            public void onFailure(Call<SinhVien> call, Throwable t) {

            }
        });

        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVien svien = new SinhVien(mainActivity.getID().toString(),
                        hoten.getText().toString(),
                        ngaysinh.getText().toString(),
                        sdt.getText().toString(),
                        diachi.getText().toString(),
                        mail.getText().toString());
                sv.ChangeProfile(svien).enqueue(new Callback<SinhVien>() {
                    @Override
                    public void onResponse(Call<SinhVien> call, Response<SinhVien> response) {
                        Toast.makeText(getActivity(),"Cập Nhật Thông Tin Thành Công", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<SinhVien> call, Throwable t) {

                    }
                });
            }
        });


        return view;
    }
}
