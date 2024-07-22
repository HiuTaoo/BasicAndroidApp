package com.example.btl_api.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.btl_api.Admin.MainAdmin;
import com.example.btl_api.Main;
import com.example.btl_api.R;
import com.example.btl_api.object.TKSinhVien;
import com.example.btl_api.object.userPass;
import com.example.btl_api.retrofit.SV;
import com.example.btl_api.retrofit.SVUntils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginSV extends AppCompatActivity {

    EditText txtUserSV, txtPassSV;
    Button btnLoginSV, btnForgetSV, btnLoginNextAdmin;

    ArrayList<TKSinhVien> mListSV;
    SV sv;
    String ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sv);
        mListSV = new ArrayList<>();
        InitWidget();
        sv = SVUntils.getService();
        getListTKSV();
        btnLoginSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
            }
        });
        btnLoginNextAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginSV.this, Login.class);
                startActivity(intent);
            }
        });
    }

    private void click(){
        String user = txtUserSV.getText().toString().trim();
        String pass = txtPassSV.getText().toString().trim();
        if(mListSV == null || mListSV.isEmpty()){
            return;
        }
        boolean isHasUser = false;
        for(TKSinhVien User : mListSV){
            if(user.toString().trim().equals(User.getID().toString().trim()) &&
                    pass.toString().trim().equals(User.getPassWordSV().toString().trim())){
                isHasUser = true;
                ID= User.getID().toString().trim();
                break;
            }
        }
        if (isHasUser) {
            Intent intent = new Intent(LoginSV.this, Main.class);
            Bundle bundle = new Bundle();
            bundle.putString("username", user);
            bundle.putString("password", pass);
            bundle.putString("id",ID);
            intent.putExtra("mpk",bundle);
            startActivity(intent);
        } else {
            Toast.makeText(LoginSV.this,"Thất Bại", Toast.LENGTH_SHORT).show();
        }
    }
    private void getListTKSV(){
        sv.getTK().enqueue(new Callback<ArrayList<TKSinhVien>>() {
            @Override
            public void onResponse(Call<ArrayList<TKSinhVien>> call, Response<ArrayList<TKSinhVien>> response) {
                mListSV = response.body();
            }

            @Override
            public void onFailure(Call<ArrayList<TKSinhVien>> call, Throwable t) {

            }
        });
    }



    private void InitWidget(){ // Should be InitWidget()
        txtUserSV = findViewById(R.id.txtUser);
        txtPassSV = findViewById(R.id.txtPass);
        btnLoginSV = findViewById(R.id.btnLogin);
        btnForgetSV = findViewById(R.id.btnForget);
        btnLoginNextAdmin = findViewById(R.id.btnLoginNextAdmin);
    }
}