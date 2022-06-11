package com.edu.csc.kt_minhthien.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.csc.kt_minhthien.R;
import com.edu.csc.kt_minhthien.model.Productkt6;

import java.util.ArrayList;

public class ProductAdapterkt6 extends ArrayAdapter<Productkt6> {
    Activity activity;
    public ProductAdapterkt6(Activity activity, ArrayList products){
        super(activity, 0 , products);
        this.activity=activity;
    }
    public View getView(int position, View converView, ViewGroup viewGroup){
        if(converView==null){
            LayoutInflater inflater=this.activity.getLayoutInflater();
            converView = inflater.inflate(R.layout.itemkt6,null);
        }

        ImageView Proanhflag = (ImageView) converView.findViewById(R.id.anhcoxml);
        TextView Protenflag = (TextView) converView.findViewById(R.id.quocgiaxml);
        TextView Prodanflag = (TextView) converView.findViewById(R.id.dansoxml);

        Productkt6 p = getItem(position);
        Proanhflag.setImageResource(p.getImageflag());
        Protenflag.setText(p.getNameflag());
        Prodanflag.setText(p.getPopuflag());
        return converView;
    }
}
