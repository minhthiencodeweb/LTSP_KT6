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
import android.widget.ListView;
import android.widget.Toast;

import com.edu.csc.kt_minhthien.adapter.ProductAdapter;
import com.edu.csc.kt_minhthien.adapter.SanPhamAdapter;
import com.edu.csc.kt_minhthien.model.Product;
import com.edu.csc.kt_minhthien.model.SaleManager;
import com.edu.csc.kt_minhthien.model.sanpham;

import java.util.ArrayList;

public class KT5_shop extends AppCompatActivity {
    ListView lvSanPhamkt5;
    ProductAdapter productAdapter;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt5_shop);
        addControls();
        addEvents();
        fakeData();


        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("List View nâng cao");           // thiết lập tiêu đề nếu muón
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //mũi tên quay lại
    }

    private void addEvents() {
        lvSanPhamkt5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product sp = productAdapter.getItem(i);
                Toast.makeText(KT5_shop.this, "Bạn chọn: "+sp.getProductName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void fakeData() {
        productAdapter.add(new Product("Socola KitKat","Gói",42000));
        productAdapter.add(new Product("Kẹo dẻo Jelly Bean","Hộp",50000));
        productAdapter.add(new Product("Bánh kem Icecream Sandwich","Que",2000));
        productAdapter.add(new Product("Mật ong rừng HoneyComb","Hũ",60000));
        productAdapter.add(new Product("Bánh mì gừng GingerBread","Ổ",10000));
    }

    private void addControls() {
        lvSanPhamkt5 = findViewById(R.id.lvProducts2);
        productAdapter = new ProductAdapter(KT5_shop.this, R.layout.item_product);
        lvSanPhamkt5.setAdapter(productAdapter);
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
                i = new Intent(this,TTSVmenu1.class);  // chuyển sang màn hình 2
                startActivity(i);
                break;
            case R.id.menu2:
                //code xử lý khi bấm menu2
                i = new Intent(KT5_shop.this,Add_product.class);  // chuyển sang màn hình 2
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
}