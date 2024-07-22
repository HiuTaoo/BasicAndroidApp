package com.example.btl_api.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.btl_api.Main;
import com.example.btl_api.R;
import com.example.btl_api.object.ChangePass;
import com.example.btl_api.retrofit.SV;
import com.example.btl_api.retrofit.SVUntils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordFragment extends Fragment {
    EditText pass, repass, newpass;
    TextView thongbao;
    Button OK;
    SV sv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_password, container, false);
        sv = SVUntils.getService();
        Main mainActivity = (Main) getActivity();
        pass = view.findViewById(R.id.pass);
        repass = view.findViewById(R.id.repass);
        newpass = view.findViewById(R.id.newpass);
        OK = view.findViewById(R.id.btnOK);
        thongbao = view.findViewById(R.id.thongbao);
        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pass.getText().toString().isEmpty() && repass.getText().toString().isEmpty() && newpass.getText().toString().isEmpty()){
                    thongbao.setText("Vui Lòng Nhập Đủ Thông Tin!");
                }else{
                    thongbao.setText("");
                    String passw = pass.getText().toString();
                    if(pass.getText().toString().equals(repass.getText().toString())){
                        if(mainActivity.getPassWord().toString().trim().equals(passw)){
                            ChangePass changePass = new ChangePass( newpass.getText().toString(),mainActivity.getUserName(), mainActivity.getPassWord());
                            sv.ChangePass(changePass).enqueue(new Callback<ChangePass>() {
                                @Override
                                public void onResponse(Call<ChangePass> call, Response<ChangePass> response) {
                                    thongbao.setText("Đổi Mật Khẩu Thành Công!");
                                }

                                @Override
                                public void onFailure(Call<ChangePass> call, Throwable t) {
                                    thongbao.setText("Thatbai");
                                }
                            });
                        }//else thongbao.setText("fgafs");
                    }else{
                        thongbao.setText("Mật khẩu không đồng nhất!");
                    }
                }

            }
        });

        return view;
    }
}
