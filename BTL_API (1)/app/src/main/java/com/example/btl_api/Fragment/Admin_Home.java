package com.example.btl_api.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.btl_api.Admin.AddHP;
import com.example.btl_api.Admin.AddSV;
import com.example.btl_api.R;

public class Admin_Home extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_admin, container, false);
        ImageButton btnAddSV = view.findViewById(R.id.btnAddSV);
        ImageButton btnAddHP = view.findViewById(R.id.btnAddHP);
        btnAddSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), AddSV.class);
                startActivity(intent);
            }
        });
        btnAddHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), AddHP.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

