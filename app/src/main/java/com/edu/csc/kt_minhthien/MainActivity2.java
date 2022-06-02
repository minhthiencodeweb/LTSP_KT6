package com.edu.csc.kt_minhthien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    EditText edtNamDuong;
    TextView txtNamAm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addControls();



        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("KT số 2");           // thiết lập tiêu đề nếu muón
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //mũi tên quay lại
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


    public void xuLyChuyenDuongQuaAm(View view) {
        String []arrCan={"Canh","Tân","Nhâm","Quý","Giáp","Ất","Bính","Đinh","Mậu","Kỷ"};
        String []arrChi={"Thân","Dậu","Tuất","Hợi","Tý","Sửu","Dần","Mẹo","Thìn","Tỵ","Ngọ","Mùi"};
        int namDuong=Integer.parseInt(edtNamDuong.getText().toString());
        String can=arrCan[namDuong%10];
        String chi=arrChi[namDuong%12];
        txtNamAm.setText(can+" "+chi);
    }


    private void addControls(){        //kết nối biến java vơi xml
        edtNamDuong = findViewById(R.id.Nam);
        txtNamAm = findViewById(R.id.Lai);

    }
}