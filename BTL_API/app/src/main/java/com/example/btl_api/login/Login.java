package com.example.btl_api.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.btl_api.Main;
import com.example.btl_api.R;
import com.example.btl_api.object.userPass;
import com.example.btl_api.retrofit.SV;
import com.example.btl_api.retrofit.SVUntils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText txtUser, txtPass;
    Button btnLogin, btnForget, btnAdmin;
    SV sv;
    ArrayList<userPass> mList;
    String ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sv = SVUntils.getService();
        mList = new ArrayList<>();
        InitWidget();
        getListUser();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
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
                ID= User.getID().toString().trim();
                break;
            }
        }
        if (isHasUser) {
            Intent intent = new Intent(Login.this, Main.class);
            Bundle bundle = new Bundle();
            bundle.putString("username", user);
            bundle.putString("password", pass);
            bundle.putString("id",ID);
            intent.putExtra("mpk",bundle);
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

    private void InitWidget(){ // Should be InitWidget()
        txtUser = findViewById(R.id.txtUser);
        txtPass = findViewById(R.id.txtPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnForget = findViewById(R.id.btnForget);
        btnAdmin = findViewById(R.id.btnAdmin);
    }
}
