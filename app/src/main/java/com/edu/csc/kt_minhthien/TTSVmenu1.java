package com.edu.csc.kt_minhthien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TTSVmenu1 extends AppCompatActivity {
    ListView lvaccount;
    String []arraccount;
    ArrayAdapter<String> adapterac;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttsvmenu1);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Thong tin sinh vien");           // thiết lập tiêu đề nếu muón
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //mũi tên quay lại
        addControl();
    }

    private void addControl() {
        lvaccount=findViewById(R.id.listaccount);
        arraccount=getResources().getStringArray(R.array.myinfo);
        adapterac=new ArrayAdapter<String>(TTSVmenu1.this, android.R.layout.simple_list_item_1,arraccount);
        lvaccount.setAdapter(adapterac);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();                                                                       //quay lại
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

}