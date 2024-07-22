package com.example.btl_api.object;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.btl_api.R;

import java.util.List;

public class HPAdapter extends ArrayAdapter<HP> {
    public HPAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public HPAdapter(@NonNull Context context, int resource, @NonNull List<HP> objects) {
        super(context, resource, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v==null){
            LayoutInflater vi =  LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.hp_items, null);
        }
        HP p = getItem(position);
        if(p!=null){
            TextView v1 = (TextView) v.findViewById(R.id.TenHocPhan);
            TextView v2 = (TextView) v.findViewById(R.id.MaCTHP);
            TextView v3 = (TextView) v.findViewById(R.id.DateStart);
            TextView v4 = (TextView) v.findViewById(R.id.DateEnd);
            TextView v5 = (TextView) v.findViewById(R.id.Ca);
            TextView v6 = (TextView) v.findViewById(R.id.Thu);
            v1.setText("Tên học phần: " + p.getTenHP().toString().trim());
            v2.setText("Mã học phần: " + p.getMaCTHP().toString().trim());
            v3.setText("Ngày bắt đầu: "+String.valueOf(p.getStart()).trim());
            v4.setText("Ngày kết thúc: "+String.valueOf(p.getEnd()).trim());
            v5.setText("Ca: "+String.valueOf(p.getCa()).trim());
            v6.setText("Thứ: "+String.valueOf(p.getThu()).trim());
        }
        return v;
    }
}
