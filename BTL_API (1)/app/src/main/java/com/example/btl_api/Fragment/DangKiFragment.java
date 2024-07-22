package com.example.btl_api.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.btl_api.Main;
import com.example.btl_api.R;
import com.example.btl_api.object.Course;
import com.example.btl_api.object.CourseAdaper;
import com.example.btl_api.object.HP;
import com.example.btl_api.object.HPAdapter;
import com.example.btl_api.object.KQDK;
import com.example.btl_api.object.chitietHP;
import com.example.btl_api.retrofit.SV;
import com.example.btl_api.retrofit.SVUntils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DangKiFragment extends Fragment {
    TextView textView;
    Button OK;
    ListView listView, listView1, listView2;
    SV sv;
    ArrayList<Course> kq;
    ArrayList<HP> arrHP, arrDK;
    CourseAdaper adapter;
    HPAdapter hpAdapter, DKAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dangki, container, false);
        sv = SVUntils.getService();
        Main mainActivity = (Main) getActivity();

        textView = view.findViewById(R.id.tv);
        listView = view .findViewById(R.id.listview);
        listView1 = view .findViewById(R.id.listview1);
        listView2 = view .findViewById(R.id.listview2);
        OK =(Button) view.findViewById(R.id.OK);
        arrDK = new ArrayList<>();
        DKAdapter= new HPAdapter(getActivity(), R.layout.hp_items, arrDK);

        sv.getAllCourse().enqueue(new Callback<ArrayList<Course>>() {
            @Override
            public void onResponse(Call<ArrayList<Course>> call, Response<ArrayList<Course>> response) {
                if(response.isSuccessful()){
                    kq =  response.body();
                    adapter = new CourseAdaper(getActivity(), R.layout.course_items, kq);
                    listView.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<ArrayList<Course>> call, Throwable t) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t = kq.get(position).getMaHP().toString().trim();
                sv.getDetailCourse(t).enqueue(new Callback<ArrayList<HP>>() {
                    @Override
                    public void onResponse(Call<ArrayList<HP>> call, Response<ArrayList<HP>> response) {
                        if (response.isSuccessful()) {
                            arrHP = response.body();
                            hpAdapter = new HPAdapter(getActivity(), R.layout.hp_items, arrHP);
                            listView1.setAdapter(hpAdapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<HP>> call, Throwable t) {

                    }
                });
                arrDK = new ArrayList<>();
                DKAdapter= new HPAdapter(getActivity(), R.layout.hp_items, arrDK);
                listView2.setAdapter(DKAdapter);

                //hpAdapter = new HPAdapter(getActivity(), R.layout.hp_items, )
            }
        });

        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrDK.add(arrHP.get(position));
                DKAdapter.notifyDataSetChanged();
                listView2.setAdapter(DKAdapter);

                arrHP.remove(position);
                hpAdapter.notifyDataSetChanged();
                listView1.setAdapter(hpAdapter);

                return true;
            }
        });

        listView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrHP.add(arrDK.get(position));
                hpAdapter.notifyDataSetChanged();
                listView1.setAdapter(hpAdapter);

                arrDK.remove(position);
                DKAdapter.notifyDataSetChanged();
                listView2.setAdapter(DKAdapter);
                return false;
            }
        });

        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrHP.size() != 0){
                    Toast.makeText(getActivity(), "Vẫn còn môn cần đăng kí", Toast.LENGTH_SHORT).show();
                }else{
                    String id = mainActivity.getID();

                    for (HP  hp : arrDK
                    ) {
                        KQDK kqdk = new KQDK(id,hp.getMaHP().toString());
                        sv.InsertKQDK(kqdk).enqueue(new Callback<KQDK>() {
                            @Override
                            public void onResponse(Call<KQDK> call, Response<KQDK> response) {
                                arrDK.remove(hp);
                                DKAdapter.notifyDataSetChanged();
                                listView2.setAdapter(DKAdapter);


                            }

                            @Override
                            public void onFailure(Call<KQDK> call, Throwable t) {

                            }
                        });
                    }
                }
                sv.UpdateKQDK(arrDK.get(1).getMaHP().toString()).enqueue(new Callback<KQDK>() {
                    @Override
                    public void onResponse(Call<KQDK> call, Response<KQDK> response) {

                    }

                    @Override
                    public void onFailure(Call<KQDK> call, Throwable t) {

                    }
                });

            }
        });


        return view;
    }

}
