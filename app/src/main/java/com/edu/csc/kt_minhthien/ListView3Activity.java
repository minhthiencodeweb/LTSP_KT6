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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.edu.csc.kt_minhthien.model.Contact;
import com.edu.csc.kt_minhthien.model.ProductActivity;

public class ListView3Activity extends AppCompatActivity {
    EditText edtMa, edtTen, edtPhone;
    Button btnLuu;
    ListView lvContact;
    ArrayAdapter<Contact> contactAdapter;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view3);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("ListView 3");
        actionBar.setDisplayHomeAsUpEnabled(true);
        addControls();
        addEvents();

    }

    private void addEvents() {
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyThemContact();
            }
        });
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact c = contactAdapter.getItem(position);
                edtMa.setText(c.getId()+"");
                edtTen.setText(c.getName());
                edtPhone.setText(c.getPhone());
            }
        });
        lvContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Contact c = contactAdapter.getItem(position);
//Tạo đối tượng
                AlertDialog.Builder b = new AlertDialog.Builder(ListView3Activity.this);
//Thiết lập tiêu đề
                b.setTitle("Xác nhận");
                b.setMessage("Bạn có đồng ý xoá không?");
// Nút Ok
                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        contactAdapter.remove(c);
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
                return false;
            }
        });
    }

    private void xuLyThemContact() {
        Contact c=new Contact();
        c.setId(Integer.parseInt(edtMa.getText().toString()));
        c.setName(edtTen.getText().toString());
        c.setPhone(edtPhone.getText().toString());
        contactAdapter.add(c);
    }

    private void addControls() {
        edtMa = findViewById(R.id.editid);
        edtTen = findViewById(R.id.editname);
        edtPhone = findViewById(R.id.editphone);
        btnLuu = findViewById(R.id.buttonlistaccount);
        lvContact = findViewById(R.id.lvcontactxml);

        contactAdapter = new ArrayAdapter<Contact>(ListView3Activity.this, android.R.layout.simple_list_item_1);
        lvContact.setAdapter(contactAdapter);
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
                i = new Intent(ListView3Activity.this,TTSVmenu1.class);  // chuyển sang màn hình 2
                startActivity(i);
                break;
            case R.id.menu2:
                //code xử lý khi bấm menu2
                i = new Intent(ListView3Activity.this, ProductActivity.class);  // chuyển sang màn hình 2
                startActivity(i);
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