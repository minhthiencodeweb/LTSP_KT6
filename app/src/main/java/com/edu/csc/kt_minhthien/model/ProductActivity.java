package com.edu.csc.kt_minhthien.model;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.edu.csc.kt_minhthien.R;

import java.text.DecimalFormat;

public class ProductActivity extends AppCompatActivity {
    public final static String EXTRA_POSITION="position";
    EditText txtProductName, txtUnit, txtPrice;
    Product product;
    Intent it;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //lấy các control trên layout
        txtProductName = findViewById(R.id.txtProductName1);
        txtUnit =  findViewById(R.id.txtUnit1);
        txtPrice =  findViewById(R.id.txtPrice1);

        //hiển thị lên màn hình
        it = getIntent();
        position = it.getExtras().getInt(EXTRA_POSITION);
        product = SaleManager.get().getProducts().get(position);
        txtProductName.setText(product.getProductName());

        txtUnit.setText(product.getUnit());
        String s = (new DecimalFormat("#,###.##")).format(product.getPrice());
        txtPrice.setText(s);

        //thiết đặt sự kiện khi click vào các button
        Button btnOK =  findViewById(R.id.btnOK1);
        Button btnCancel = findViewById(R.id.btnCancel1);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //lấy dữ liệu từ layout để cập nhập lại các sản phẩm trong mảng
                product.setProductName(txtProductName.getText().toString());
                product.setUnit(txtUnit.getText().toString());
                String s = txtPrice.getText().toString();
                s = s.replace(",", "");
                double price = Double.parseDouble(s);
                product.setPrice(price);

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