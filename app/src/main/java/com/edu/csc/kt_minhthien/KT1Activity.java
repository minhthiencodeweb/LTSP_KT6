package com.edu.csc.kt_minhthien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class KT1Activity extends AppCompatActivity {
    EditText edtCMND, edtPhone, edtDiaChi;
    Button btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt1);
        addControls();

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("KT số 1");           // thiết lập tiêu đề nếu muón
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //mũi tên quay lại


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(KT1Activity.this,"Bạn nhấn Cập nhật",Toast.LENGTH_LONG).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtCMND.setText("");
                edtPhone.setText("");
                edtDiaChi.setText("");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();   //quay lại
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addControls(){        //kết nối biến java vơi xml
        btn1 = findViewById(R.id.btnhap);
        btn2 = findViewById(R.id.btnlai);
        btn3 = findViewById(R.id.btnthoat);

    }



}