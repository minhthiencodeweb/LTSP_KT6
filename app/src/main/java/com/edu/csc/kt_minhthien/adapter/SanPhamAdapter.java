package com.edu.csc.kt_minhthien.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.edu.csc.kt_minhthien.R;
import com.edu.csc.kt_minhthien.model.sanpham;

import java.util.ArrayList;

public class SanPhamAdapter extends ArrayAdapter<sanpham> {
    Activity activity; //activity chứa listview
    public SanPhamAdapter(Activity activity, ArrayList products) {
        super(activity,0,products);
        this.activity=activity;


    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //position là vị trí của mỗi item, nó sẽ chạy hết mảng
        //lấy Layout cho từng item
        if(convertView == null) {

            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item,null);
        }


        ImageView imgHinh=(ImageView) convertView.findViewById(R.id.imgHinh); //R (bài mình)
        TextView txtTen= (TextView) convertView.findViewById(R.id.txtTen);
        TextView txtGia= (TextView) convertView.findViewById(R.id.txtGia);

        sanpham sp=getItem(position);
        imgHinh.setImageResource(sp.getHinh());
        txtTen.setText(sp.getTen());
        txtGia.setText(sp.getGia()+" VND");

        return convertView;

    }
}
