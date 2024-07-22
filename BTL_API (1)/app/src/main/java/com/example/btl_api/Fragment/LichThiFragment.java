package com.example.btl_api.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.btl_api.Main;
import com.example.btl_api.R;
import com.example.btl_api.object.HPAdapter;
import com.example.btl_api.object.LichThi;
import com.example.btl_api.object.LichThiAdapter;
import com.example.btl_api.retrofit.SV;
import com.example.btl_api.retrofit.SVUntils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LichThiFragment extends Fragment {
    SV sv;
    LichThiAdapter adapter;
    ArrayList<LichThi> arr;
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lichthi, container, false);
        sv = SVUntils.getService();
        Main mainActivity = (Main) getActivity();
        listView = view.findViewById(R.id.listview);
        sv.getLichThi(mainActivity.getID().toString()).enqueue(new Callback<ArrayList<LichThi>>() {
            @Override
            public void onResponse(Call<ArrayList<LichThi>> call, Response<ArrayList<LichThi>> response) {
                if(response.isSuccessful()){
                    arr =  response.body();
                    adapter = new LichThiAdapter(getActivity(),R.layout.lichthi_items, arr);
                    listView.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<ArrayList<LichThi>> call, Throwable t) {

            }
        });

        return view;
    }
}
