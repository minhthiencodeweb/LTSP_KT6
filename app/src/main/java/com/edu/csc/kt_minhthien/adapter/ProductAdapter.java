package com.edu.csc.kt_minhthien.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.edu.csc.kt_minhthien.R;
import com.edu.csc.kt_minhthien.model.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {
    Activity activity;
    int products;
    public ProductAdapter(Activity activity, int products){
        super(activity,products);
        this.activity=activity;
        this.products=products;

    }
    public View getView(int position, View convertView, ViewGroup viewGroup){
        if(convertView == null)
        {
            LayoutInflater inflater = this.activity.getLayoutInflater();
            convertView = inflater.inflate(this.products,null);
        }
        TextView tvProductName = (TextView) convertView.findViewById(R.id.tvProductName1);
        TextView tvUnit = (TextView) convertView.findViewById(R.id.tvUnit1);
        TextView tvPrice= (TextView) convertView.findViewById(R.id.tvPrice1);

        Product p = getItem(position);
        tvProductName.setText(p.getProductName());
        tvUnit.setText(p.getUnit());
        String s = (new DecimalFormat("#,###.##")).format(p.getPrice());
        tvPrice.setText(s);
        return convertView;

    }

}
