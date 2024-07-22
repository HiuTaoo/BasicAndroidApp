package com.example.btl_api.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.btl_api.R;
import com.example.btl_api.object.Khoa;
import com.example.btl_api.object.NienKhoa;
import com.example.btl_api.object.TKSinhVien;
import com.example.btl_api.object.sinhVienClass;
import com.example.btl_api.retrofit.SV;
import com.example.btl_api.retrofit.SVUntils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddSV extends AppCompatActivity {
    SV sv;
    EditText txtIDSV, txtNameSV, txtNgaySinh,txtSDT,txtDiaChi;
    Spinner spinnerKhoa, spinnerNiemKhoa;
    RadioButton rbtnNam, rbtnNu;
    Button btnSave, btnThoat;
    ArrayList<Khoa> khoaList;
    ArrayList<NienKhoa> nienKhoaList;
    ArrayAdapter<Khoa> adapterKhoa;
    ArrayAdapter<NienKhoa> adapterNienKhoa;
    String gioitinh = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sv);
        InitWidget();
        khoaList = new ArrayList<>();
        nienKhoaList = new ArrayList<>();
        sv = SVUntils.getService();
        getListKhoa();
        getListNienKhoa();
        rbtnNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbtnNam.isChecked()) {
                    gioitinh = "1";
                    rbtnNu.setChecked(false);
                }
            }
        });
        rbtnNu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbtnNu.isChecked()) {
                    gioitinh = "0";
                    rbtnNam.setChecked(false);
                }
            }
        });

        String finalGioitinh = gioitinh;
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddSV.this, MainAdmin.class);
                startActivity(intent);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sinhVienClass addSV = new sinhVienClass(txtIDSV.getText().toString(),
                        txtNameSV.getText().toString(),
                        finalGioitinh,
                        txtNgaySinh.getText().toString(),
                        txtSDT.getText().toString(),
                        txtDiaChi.getText().toString(),
                        spinnerKhoa.getSelectedItem().toString(),
                        spinnerNiemKhoa.getSelectedItem().toString(), null);
                sv.insertSV(addSV).enqueue(new Callback<sinhVienClass>() {
                    @Override
                    public void onResponse(Call<sinhVienClass> call, Response<sinhVienClass> response) {
//                        if(response.isSuccessful()){
//                            Toast.makeText(AddSV.this,"Thanh Cong", Toast.LENGTH_SHORT).show();
//                        }
                    }

                    @Override
                    public void onFailure(Call<sinhVienClass> call, Throwable t) {
                        Toast.makeText(AddSV.this,"That bai", Toast.LENGTH_SHORT).show();
                    }
                });

                TKSinhVien tksv = new TKSinhVien(txtIDSV.getText().toString().trim(),
                        "123456");
                sv.insertTKSV(tksv).enqueue(new Callback<TKSinhVien>() {
                    @Override
                    public void onResponse(Call<TKSinhVien> call, Response<TKSinhVien> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(AddSV.this,"Thanh Cong 1", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<TKSinhVien> call, Throwable t) {

                    }
                });
            }
        });
    }
    private void getListKhoa(){
        sv.getKhoa().enqueue(new Callback<ArrayList<Khoa>>() {
            @Override
            public void onResponse(Call<ArrayList<Khoa>> call, Response<ArrayList<Khoa>> response) {
                khoaList = response.body();
                adapterKhoa = new ArrayAdapter<Khoa>(AddSV.this,android.R.layout.simple_expandable_list_item_1,khoaList);
                spinnerKhoa.setAdapter(adapterKhoa);

                sv.getNienKhoa().enqueue(new Callback<ArrayList<NienKhoa>>() {
                    @Override
                    public void onResponse(Call<ArrayList<NienKhoa>> call, Response<ArrayList<NienKhoa>> response) {
                        nienKhoaList = response.body();
                        adapterNienKhoa = new ArrayAdapter<NienKhoa>(AddSV.this,android.R.layout.simple_expandable_list_item_1,nienKhoaList);
                        spinnerNiemKhoa.setAdapter(adapterNienKhoa);
                    }

                    @Override
                    public void onFailure(Call<ArrayList<NienKhoa>> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onFailure(Call<ArrayList<Khoa>> call, Throwable t) {

            }
        });
    }
    private void getListNienKhoa(){

    }
    private void InitWidget(){
        txtIDSV = findViewById(R.id.txtIDSV);
        txtNameSV = findViewById(R.id.txtNameSV);
        txtNgaySinh = findViewById(R.id.txtNgaySinh);
        txtSDT = findViewById(R.id.txtSDT);
        txtDiaChi = findViewById(R.id.txtDiaChi);
        spinnerKhoa = findViewById(R.id.spinnerKhoa);
        spinnerNiemKhoa = findViewById(R.id.spinnerNienKhoa);
        btnSave = findViewById(R.id.btnSave);
        btnThoat = findViewById(R.id.btnThoat);
        rbtnNam = findViewById(R.id.rbtnNam);
        rbtnNu = findViewById(R.id.rbtnNu);
    }
}