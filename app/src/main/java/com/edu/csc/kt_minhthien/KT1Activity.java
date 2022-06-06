package com.edu.csc.kt_minhthien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class KT1Activity extends AppCompatActivity {
    EditText edtCMND, edtPhone, edtDiaChi;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt1);
        addControls();


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("KT số 1");           // thiết lập tiêu đề nếu muón
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //mũi tên quay lại

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }
    @Override   //xử lý sự kiện khi bấm nút
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menu1:
                //code xử lý khi bấm menu1
                Toast.makeText(this,"Bạn vừa bấm vào menu 1",Toast.LENGTH_LONG).show();
                break;
            case R.id.menu2:
                //code xử lý khi bấm menu2
                Toast.makeText(this,"Bạn vừa bấm vào menu 2",Toast.LENGTH_LONG).show();
                break;
            case R.id.menu3:
                //code xử lý khi bấm menu3
                i = new Intent(KT1Activity.this,KT1Activity.class);  // chuyển sang màn hình 2
                startActivity(i);
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }





    public void lamlai(View view) {
        edtCMND.setText("");
        edtPhone.setText("");
        edtDiaChi.setText("");
        edtCMND.requestFocus();
    }

    private void addControls(){        //kết nối biến java vơi xml
        edtCMND = findViewById(R.id.edtCMND);
        edtPhone = findViewById(R.id.edtPhone);
        edtDiaChi = findViewById(R.id.edtDiaChi);
    }


    public void capnhap(View view) {
        Toast.makeText(KT1Activity.this,"đã cập nhập ", Toast.LENGTH_LONG).show();
    }

    public void thoat(View view) {
        finish();
    }
}