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

public class SanPhamAdapter extends ArrayAdapter<sanpham> {
    Activity context;
    int resourse;
    public SanPhamAdapter(Activity context, int resourse) {
        super(context, resourse);
        this.context=context;
        this.resourse=resourse;

    }
    @NonNull
    @Override
    public View getView(int postion, View convertView, ViewGroup parent){
        LayoutInflater inflater=this.context.getLayoutInflater();
        View customView=inflater.inflate(this.resourse,null);

        ImageView imgHinh=(ImageView) customView.findViewById(R.id.imgHinh); //R (bài mình)
        TextView txtTen= (TextView) customView.findViewById(R.id.txtTen);
        TextView txtGia= (TextView) customView.findViewById(R.id.txtGia);

        sanpham sp=getItem(postion);
        imgHinh.setImageResource(sp.getHinh());
        txtTen.setText(sp.getTen());
        txtGia.setText(sp.getGia()+"VND");

        return customView;

    }
}
