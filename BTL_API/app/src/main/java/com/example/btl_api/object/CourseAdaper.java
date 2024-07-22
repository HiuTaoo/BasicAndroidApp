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

public class CourseAdaper extends ArrayAdapter<Course> {

    public CourseAdaper(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public CourseAdaper(@NonNull Context context, int resource, @NonNull List<Course> objects) {
        super(context, resource, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v==null){
            LayoutInflater vi =  LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.course_items, null);
        }
        Course p = getItem(position);
        if(p!=null){
            TextView v1 = (TextView) v.findViewById(R.id.MaHP);
            TextView v2 = (TextView) v.findViewById(R.id.TenHP);
            TextView v3 = (TextView) v.findViewById(R.id.SoTC);
            TextView v4 = (TextView) v.findViewById(R.id.SL);
            TextView v5 = (TextView) v.findViewById(R.id.SLDK);
            v1.setText(String.valueOf(p.getMaHP()));
            v2.setText(String.valueOf(p.getTenHP()));
            v3.setText("Số tín chỉ: "+String.valueOf(p.getSoTC()));
            v4.setText("Số lượng: "+String.valueOf(p.getSL()));
            v5.setText("Số lượng đã đăng kí: " +String.valueOf(p.getSLDK()));

        }
        return v;
    }
}
