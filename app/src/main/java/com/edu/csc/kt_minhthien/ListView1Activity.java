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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListView1Activity extends AppCompatActivity {
    ListView lvData1;
    String []arrData1;
    ArrayAdapter<String> adapter1;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view1);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("List View1");           // thiết lập tiêu đề nếu muón
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //mũi tên quay lại
        addControl();
        addEvent();

    }

    private void addEvent() {
        lvData1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListView1Activity.this,"Bạn chọn: "+ arrData1[i],Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addControl() {
        lvData1=findViewById(R.id.Lvdata1);
        arrData1=getResources().getStringArray(R.array.myclass);
        adapter1=new ArrayAdapter<String>(ListView1Activity.this, android.R.layout.simple_list_item_1,arrData1);
        lvData1.setAdapter(adapter1);
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
}