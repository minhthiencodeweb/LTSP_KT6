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
//T???o ?????i t?????ng
                AlertDialog.Builder b = new AlertDialog.Builder(ListView3Activity.this);
//Thi???t l???p ti??u ?????
                b.setTitle("X??c nh???n");
                b.setMessage("B???n c?? ?????ng ?? xo?? kh??ng?");
// N??t Ok
                b.setPositiveButton("?????ng ??", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        contactAdapter.remove(c);
                    }
                });
//N??t Cancel
                b.setNegativeButton("Kh??ng ?????ng ??", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
//T???o dialog
                AlertDialog al = b.create();
//Hi???n th???
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

    @Override   //x??? l?? s??? ki???n khi b???m n??t
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menu1:
                //code x??? l?? khi b???m menu1
                i = new Intent(ListView3Activity.this,TTSVmenu1.class);  // chuy???n sang m??n h??nh 2
                startActivity(i);
                break;
            case R.id.menu2:
                //code x??? l?? khi b???m menu2
                i = new Intent(ListView3Activity.this, ProductActivity.class);  // chuy???n sang m??n h??nh 2
                startActivity(i);
                break;
            case R.id.menu3:
                //T???o ?????i t?????ng
                AlertDialog.Builder b = new AlertDialog.Builder(this);
                //Thi???t l???p ti??u ?????
                b.setTitle("X??c nh???n");
                b.setMessage("B???n c?? ?????ng ?? tho??t ch????ng tr??nh kh??ng?");
                // N??t Ok
                b.setPositiveButton("?????ng ??", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
                //N??t Cancel
                b.setNegativeButton("Kh??ng ?????ng ??", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                //T???o dialog
                AlertDialog al = b.create();
                //Hi???n th???
                al.show();
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}