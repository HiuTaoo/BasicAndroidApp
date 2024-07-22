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
import com.example.btl_api.object.CourseAdaper;
import com.example.btl_api.object.HP;
import com.example.btl_api.object.HPAdapter;
import com.example.btl_api.retrofit.SV;
import com.example.btl_api.retrofit.SVUntils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LichHocFragment extends Fragment {
    ListView listView, listView1;
    SV sv;
    HPAdapter hpAdapter, LHAdapter;
    ArrayList<HP> arrHP, arrLH;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lichhoc, container, false);
        sv = SVUntils.getService();
        Main mainActivity = (Main) getActivity();

        listView = view.findViewById(R.id.listview);
        listView1 = view.findViewById(R.id.listview1);

        LHAdapter= new HPAdapter(getActivity(), R.layout.hp_items, arrLH);
        hpAdapter= new HPAdapter(getActivity(), R.layout.hp_items, arrHP);

        sv.get_LichHoc(mainActivity.getID().toString()).enqueue(new Callback<ArrayList<HP>>() {
            @Override
            public void onResponse(Call<ArrayList<HP>> call, Response<ArrayList<HP>> response) {
                if(response.isSuccessful()){
                    arrLH =  response.body();
                    LHAdapter = new HPAdapter(getActivity(), R.layout.course_items, arrLH);
                    listView.setAdapter(LHAdapter);

                    sv.get_KQDK_By_ID(mainActivity.getID().toString()).enqueue(new Callback<ArrayList<HP>>() {
                        @Override
                        public void onResponse(Call<ArrayList<HP>> call, Response<ArrayList<HP>> response) {
                            if(response.isSuccessful()){
                                arrHP =  response.body();
                                hpAdapter = new HPAdapter(getActivity(), R.layout.course_items, arrHP);
                                listView1.setAdapter(hpAdapter);


                            }
                        }

                        @Override
                        public void onFailure(Call<ArrayList<HP>> call, Throwable t) {

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<ArrayList<HP>> call, Throwable t) {

            }
        });




        return view;
    }
}
