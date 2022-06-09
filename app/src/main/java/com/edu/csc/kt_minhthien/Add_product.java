package com.edu.csc.kt_minhthien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.edu.csc.kt_minhthien.model.ProductActivity;

public class Add_product extends AppCompatActivity {
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("ListView 3");
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // nếu btnAdd được click
        if (id == R.id.btnAdd) {
            //đến màng hình ProductActivity
            Intent intent = new Intent(this, ProductActivity.class);
            //tham số -1 tức ta không truyền 1 position của item nào cả
            //ta mở ProductActivity để thêm sp mới
            intent.putExtra(ProductActivity.EXTRA_POSITION, -1);
            startActivityForResult(intent, 0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




}