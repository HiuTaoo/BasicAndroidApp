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

public class LichThiAdapter extends ArrayAdapter<LichThi> {

    public LichThiAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public LichThiAdapter(@NonNull Context context, int resource, @NonNull List<LichThi> objects) {
        super(context, resource, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v==null){
            LayoutInflater vi =  LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.lichthi_items, null);
        }
        LichThi p = getItem(position);
        if(p!=null){
            TextView v2 = (TextView) v.findViewById(R.id.ltMaHP);
            TextView v3 = (TextView) v.findViewById(R.id.ltTenHp);
            TextView v4 = (TextView) v.findViewById(R.id.ltDate);
            TextView v5 = (TextView) v.findViewById(R.id.ltTime);
            TextView v6 = (TextView) v.findViewById(R.id.ltHThuc);
            TextView v7 = (TextView) v.findViewById(R.id.ltPhong);
            TextView v8 = (TextView) v.findViewById(R.id.ltSBD);

            v2.setText("Mã Học Phần: "+String.valueOf(p.getMaHP()));
            v3.setText("Tên Học Phần: "+String.valueOf(p.getTenHP()));
            v4.setText("Ngày Thi: "+String.valueOf(p.getNgayThi()));
            v5.setText("Thời Gian Thi: " +String.valueOf(p.getThoiGian()));
            v6.setText("Hình Thức Thi: "+String.valueOf(p.getHinhThuc()));
            v7.setText("Phòng Thi: "+String.valueOf(p.getPhongThi()));
            v8.setText("Số Báo Danh: "+String.valueOf(p.getSBD()));


        }
        return v;
    }
}
