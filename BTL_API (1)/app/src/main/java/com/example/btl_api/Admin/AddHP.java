package com.example.btl_api.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.btl_api.R;
import com.example.btl_api.object.HP;
import com.example.btl_api.object.chitietHP;
import com.example.btl_api.retrofit.SV;
import com.example.btl_api.retrofit.SVUntils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddHP extends AppCompatActivity {

    EditText txtMaHP, txtChiTietHP, txtNgayBD, txtNgayKT,txtPhong, txtTenHP, txtSoLuong;
    Button btnSaveHP, btnThoatHP;
    Spinner spCa, spThu,spTin;
    SV sv;
    ArrayList<String> arrTin = new ArrayList<>();
    ArrayList<String> arrCa = new ArrayList<>();
    ArrayList<String> arrThu = new ArrayList<>();

    ArrayAdapter<String> adapterTin, adapterCa, adapterThu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hp);
        InitWidget();
        sv = SVUntils.getService();
        for(int i =1 ; i<=4; i++){
            arrTin.add(String.valueOf(i));
        }
        for(int i =2 ; i<=7; i++){
            arrThu.add(String.valueOf(i));
        }
        for(int i =1 ; i<=6; i++){
            arrCa.add(String.valueOf(i));
        }
        adapterTin = new ArrayAdapter<String>(AddHP.this,android.R.layout.simple_expandable_list_item_1,arrTin);
        adapterThu = new ArrayAdapter<String>(AddHP.this,android.R.layout.simple_expandable_list_item_1,arrThu);
        adapterCa = new ArrayAdapter<String>(AddHP.this,android.R.layout.simple_expandable_list_item_1,arrCa);
        spTin.setAdapter(adapterTin);
        spCa.setAdapter(adapterCa);
        spThu.setAdapter(adapterThu);
        btnThoatHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddHP.this, MainAdmin.class);
                startActivity(intent);
            }
        });

        btnSaveHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HP hp = new HP(txtMaHP.getText().toString(),
                                txtTenHP.getText().toString(),
                                spTin.getSelectedItem().toString(),
                                txtSoLuong.getText().toString());
                chitietHP cthp = new chitietHP(txtMaHP.getText().toString(),
                                                txtTenHP.getText().toString(),
                                                txtChiTietHP.getText().toString(),
                                                txtNgayBD.getText().toString(),
                                                txtNgayKT.getText().toString(),
                                                spCa.getSelectedItem().toString(),
                                                spThu.getSelectedItem().toString(),
                                                txtPhong.getText().toString());
                sv.insertHP(hp).enqueue(new Callback<HP>() {
                    @Override
                    public void onResponse(Call<HP> call, Response<HP> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(AddHP.this,"Thanh Cong", Toast.LENGTH_SHORT).show();
                        }

                        sv.insertCTHP(cthp).enqueue(new Callback<chitietHP>() {
                            @Override
                            public void onResponse(Call<chitietHP> call, Response<chitietHP> response) {
                                if(response.isSuccessful()){
                                    Toast.makeText(AddHP.this,"Thanh Cong 1", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<chitietHP> call, Throwable t) {
                                Toast.makeText(AddHP.this,"That bai 1", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<HP> call, Throwable t) {
                        Toast.makeText(AddHP.this,"That bai", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }
    private void InitWidget(){
        txtMaHP = findViewById(R.id.txtMaHP);
        txtChiTietHP = findViewById(R.id.txtChiTietHP);
        txtNgayBD = findViewById(R.id.txtNgayBD);
        txtNgayKT = findViewById(R.id.txtNgayKT);
        txtPhong = findViewById(R.id.txtPhong);
        txtTenHP = findViewById(R.id.txtTenHP);
        txtSoLuong = findViewById(R.id.txtSoLuong);
        spCa = findViewById(R.id.spCa);
        spThu = findViewById(R.id.spThu);
        spTin = findViewById(R.id.spTin);
        btnSaveHP = findViewById(R.id.btnSaveHP);
        btnThoatHP = findViewById(R.id.btnThoatHP);
    }
}