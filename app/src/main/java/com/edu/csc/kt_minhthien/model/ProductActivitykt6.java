package com.edu.csc.kt_minhthien.model;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.edu.csc.kt_minhthien.R;

public class ProductActivitykt6 extends AppCompatActivity {
    public final static String EXTRA_POSITION="position";
    EditText txtProductTen, txtProductDan;
    EditText txtProductFlag;
    Productkt6 product;
    Intent it;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_activitykt6);

        txtProductTen=findViewById(R.id.txtName);
        txtProductDan=findViewById(R.id.txtDan);
        txtProductFlag=findViewById(R.id.txthinh);

        it = getIntent();
        position = it.getExtras().getInt(EXTRA_POSITION);
        product = (Productkt6) SaleManagerkt6.get().getProducts().get(position);

        txtProductFlag.setText(product.getImageflag());
        txtProductTen.setText(product.getNameflag());
        txtProductDan.setText(product.getPopuflag());

        Button btnOK =findViewById(R.id.btnOK);
        Button btnCancel = findViewById(R.id.btnCancel);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product.getImageflag(txtProductFlag.getText().toString());
                product.setNameflag(txtProductTen.getText().toString());
                product.setPopuflag(txtProductDan.getText().toString());

                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //không làm gì cả và trở về màng hình trước
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED,returnIntent);
                finish();

            }
        });


    }
}