package com.edu.csc.kt_minhthien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("List View");           // thiết lập tiêu đề nếu muón
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
                i = new Intent(MainActivity3.this,TTSVmenu1.class);  // chuyển sang màn hình 2
                startActivity(i);
                break;
            case R.id.menu2:
                //code xử lý khi bấm menu2
                i = new Intent(MainActivity3.this,Add_product.class);  // chuyển sang màn hình 2
                startActivity(i);
                break;
            case R.id.menu3:
                //code xử lý khi bấm menu3
                //Tạo đối tượng
                AlertDialog.Builder b = new AlertDialog.Builder(this);
                //Thiết lập tiêu đề
                b.setTitle("Xác nhận");
                b.setMessage("Bạn có đồng ý thoát chương trình không?");
                // Nút Ok
                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
                //Nút Cancel
                b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                //Tạo dialog
                AlertDialog al = b.create();
                //Hiển thị
                al.show();
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void moManHinhListView1(View view) {
        i = new Intent(MainActivity3.this,ListView1Activity.class);  // chuyển sang màn hình 1
        startActivity(i);
    }

    public void moManHinhListView2(View view) {
        i = new Intent(MainActivity3.this,ListView2Activity.class);  // chuyển sang màn hình 2
        startActivity(i);
    }

    public void moManHinhListView3(View view) {
        i = new Intent( MainActivity3.this,ListView3Activity.class);  // chuyển sang màn hình 3
        startActivity(i);
    }

    public void moManHinhListView4(View view) {
        i = new Intent( MainActivity3.this,ListView4Activity.class);  // chuyển sang màn hình 4
        startActivity(i);
    }
}