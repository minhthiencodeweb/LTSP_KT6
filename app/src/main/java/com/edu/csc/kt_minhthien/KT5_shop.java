package com.edu.csc.kt_minhthien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.edu.csc.kt_minhthien.adapter.ProductAdapter;
import com.edu.csc.kt_minhthien.model.Product;
import com.edu.csc.kt_minhthien.model.ProductActivity;
import com.edu.csc.kt_minhthien.model.SaleManager;

import java.util.ArrayList;

public class KT5_shop extends AppCompatActivity {
    Button btnlist;
    ListView lvSanPhamkt5;
    ProductAdapter adapter;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt5_shop);
        lvSanPhamkt5=(ListView)findViewById(R.id.lvProducts);
        btnlist=findViewById(R.id.buttonlist);



//        btnlist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                i = new Intent(KT5_shop.this,ProductActivity.class);  // chuyển sang màn hình 3
//                startActivity(i);
//            }
//        });

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("List View nâng cao");           // thiết lập tiêu đề nếu muón
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //mũi tên quay lại

        //khởi tạo các sản phẩm
        SaleManager saleManager=SaleManager.get();
        saleManager.generateProducts();

        //lấy các product từ class saleManager
        ArrayList products = saleManager.getProducts();
        adapter = new ProductAdapter(this, products);
        lvSanPhamkt5.setAdapter(adapter);

        //click để xóa
        lvSanPhamkt5.setOnItemLongClickListener(new ItemLongClickRemove());


        //click để sửa
        lvSanPhamkt5.setOnItemClickListener((parent, view, position, id) ->{
            Intent intent = new Intent(KT5_shop.this, ProductActivity.class);
            intent.putExtra(ProductActivity.EXTRA_POSITION,position);
            startActivity(intent);
        });


    }



    //xóa item
    private class ItemLongClickRemove implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(KT5_shop.this);
            alertDialogBuilder.setMessage("Bán có muốn xóa sản phẩm này!");
            alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // xóa sp đang nhấn giữ
                    SaleManager.get().getProducts().remove(position);
                    //cập nhật lại listview
                    adapter.notifyDataSetChanged();

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




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override   //xử lý sự kiện khi bấm nút
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.btnAdd:
                //code xử lý khi bấm menu2
                openMyCustom();

                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openMyCustom() {
        // Khởi tạo AlertDialog từ đối tượng Builder. tham số truyền vào ở đây là context.
        final AlertDialog builder = new AlertDialog.Builder(this).create();

        // Khởi tạo đối tượng View từ file activity_add_edit_kt5.
        final View alert = LayoutInflater.from(this).inflate(R.layout.activity_product, null);

        // Set layout cho alert dialog
        builder.setView(alert);

        final EditText editTextTenSP;
        final EditText editTextDonVi;
        final EditText editTextGiaSP;
        Button buttonLuu;
        Button buttonThoat;

        // Tham chiếu các đối tượng có trên giao diện dialog vừa được set
        editTextTenSP = alert.findViewById(R.id.txtProductName1);
        editTextDonVi = alert.findViewById(R.id.txtUnit1);
        editTextGiaSP = alert.findViewById(R.id.txtPrice1);
        buttonLuu = alert.findViewById(R.id.btnOK1);
        buttonThoat = alert.findViewById(R.id.btnCancel1);

        // Tạo dialog và hiển thị
        builder.show();

        // Bắt sự kiện click vào nút Lưu
        buttonLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = new Product();
                product.setProductName(editTextTenSP.getText().toString());
                product.setUnit(editTextDonVi.getText().toString());
                String s = editTextGiaSP.getText().toString();
                s = s.replace(",", "");
                double price = Double.parseDouble(s);
                product.setPrice(price);
                adapter.add(product);
                adapter.notifyDataSetChanged();
                builder.dismiss();
            }
        });

        // Bắt sự kiện click vào nút Thoát
        buttonThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
            }
        });
    }


}


