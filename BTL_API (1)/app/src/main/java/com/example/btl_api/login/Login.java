package com.example.btl_api.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.btl_api.Admin.MainAdmin;
import com.example.btl_api.R;
import com.example.btl_api.object.Khoa;
import com.example.btl_api.object.userPass;
import com.example.btl_api.retrofit.SV;
import com.example.btl_api.retrofit.SVUntils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText txtUser, txtPass;
    Button btnLogin, btnForget, btnLoginSV;
    SV sv;
    ArrayList<userPass> mList;
    ArrayList<Khoa> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginadmin);
        sv = SVUntils.getService();
        mList = new ArrayList<>();
        InitWidget();
        getListUser();
       // getKhoa();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
            }
        });
        btnLoginSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, LoginSV.class);
                startActivity(intent);
            }
        });

    }
    private void click(){
        String user = txtUser.getText().toString().trim();
        String pass = txtPass.getText().toString().trim();
        if(mList == null || mList.isEmpty()){
            return;
        }
        boolean isHasUser = false;
        for(userPass User : mList){
            if(user.toString().trim().equals(User.getUserName().toString().trim()) &&
                pass.toString().trim().equals(User.getPassword().toString().trim())){
                isHasUser = true;
                break;
            }
        }
        if (isHasUser) {
            Intent intent = new Intent(Login.this, MainAdmin.class);
            startActivity(intent);

        } else {
            Toast.makeText(Login.this,"Thất Bại", Toast.LENGTH_SHORT).show();
        }
    }

    private void getListUser(){
        sv.getName().enqueue(new Callback<ArrayList<userPass>>() {
            @Override
            public void onResponse(Call<ArrayList<userPass>> call, Response<ArrayList<userPass>> response) {
                mList = response.body();
            }

            @Override
            public void onFailure(Call<ArrayList<userPass>> call, Throwable t) {
                //Toast.makeText(Login.this,"That Bai",Toast.LENGTH_SHORT).show();
            }
        });
    }
//    private  void getKhoa(){
//        sv.getKhoa().enqueue(new Callback<ArrayList<Khoa>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Khoa>> call, Response<ArrayList<Khoa>> response) {
//                if(response.isSuccessful()){
//                    list = response.body();
//                    txtUser.setText("1");
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Khoa>> call, Throwable t) {
//
//            }
//        });
//    }
    private void InitWidget(){
        txtUser = findViewById(R.id.txtUserAdmin);
        txtPass = findViewById(R.id.txtPassAdmin);
        btnLogin = findViewById(R.id.btnLoginAdmin);
        btnForget = findViewById(R.id.btnForgetAdmin);
        btnLoginSV = findViewById(R.id.btnLoginSV);
    }
}
