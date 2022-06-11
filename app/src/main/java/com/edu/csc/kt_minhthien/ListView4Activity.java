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

import com.edu.csc.kt_minhthien.adapter.SanPhamAdapter;
import com.edu.csc.kt_minhthien.model.SaleManagerforlV3;
import com.edu.csc.kt_minhthien.model.sanpham;

import java.util.ArrayList;

public class ListView4Activity extends AppCompatActivity {
    ListView lvSanPham;
    SanPhamAdapter sanPhamAdapter;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view4);
        lvSanPham=findViewById(R.id.Lvsanpham);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("List View nâng cao");           // thiết lập tiêu đề nếu muón
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //mũi tên quay lại
//        addControls();
        addEvents();
//        fakeData();

        //khởi tạo các sản phẩm
        SaleManagerforlV3 saleManagerforlV3 = SaleManagerforlV3.get();
        saleManagerforlV3.generateProducts();

        //lấy các product từ class saleManager
        ArrayList products = saleManagerforlV3.getProducts();

        //fakeData();
        sanPhamAdapter = new SanPhamAdapter(ListView4Activity.this,products);
        lvSanPham.setAdapter(sanPhamAdapter);

        lvSanPham.setOnItemLongClickListener(new ItemLongClickRemove());



    }

    private class ItemLongClickRemove implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ListView4Activity.this);
            alertDialogBuilder.setMessage("Bán có muốn xóa sản phẩm này!");
            alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // xóa sp đang nhấn giữ
                    SaleManagerforlV3.get().getProducts().remove(position);
                    //cập nhật lại listview
                    sanPhamAdapter.notifyDataSetChanged();

                }
            });
            alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //không làm gì
                }
            });
            alertDialogBuilder.show();
            return true;
        }

    }

//    private void fakeData() {
//        sanPhamAdapter.add(new sanpham(R.drawable.h1,"sanpham1",60000));
//        sanPhamAdapter.add(new sanpham(R.drawable.h2,"sanpham2",10000));
//        sanPhamAdapter.add(new sanpham(R.drawable.h3,"sanpham3",70000));
//        sanPhamAdapter.add(new sanpham(R.drawable.h4,"sanpham4",2000));
//        sanPhamAdapter.add(new sanpham(R.drawable.h5,"sanpham5",1000));
//        sanPhamAdapter.add(new sanpham(R.drawable.h1,"sanpham6",17000));
//        sanPhamAdapter.add(new sanpham(R.drawable.h2,"sanpham7",10000));
//        sanPhamAdapter.add(new sanpham(R.drawable.h3,"sanpham8",6100));
//        sanPhamAdapter.add(new sanpham(R.drawable.h4,"sanpham9",64000));
//        sanPhamAdapter.add(new sanpham(R.drawable.h5,"sanpham10",14000));
//
//
//    }

    private void addEvents() {
        lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                sanpham sp = sanPhamAdapter.getItem(i);
                Toast.makeText(ListView4Activity.this, "Bạn chọn: "+sp.getTen(), Toast.LENGTH_LONG).show();
            }
        });

    }

//    private void addControls() {
//        lvSanPham = findViewById(R.id.Lvsanpham);
//        sanPhamAdapter = new SanPhamAdapter(ListView4Activity.this, R.layout.item);
//        lvSanPham.setAdapter(sanPhamAdapter);
//
//    }

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
                i = new Intent(ListView4Activity.this,TTSVmenu1.class);  // chuyển sang màn hình 2
                startActivity(i);
                break;
            case R.id.menu2:
                //code xử lý khi bấm menu2
                Toast.makeText(this,"Bạn vừa bấm vào menu 2",Toast.LENGTH_LONG).show();
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