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

import com.edu.csc.kt_minhthien.adapter.ProductAdapterkt6;
import com.edu.csc.kt_minhthien.model.ProductActivitykt6;
import com.edu.csc.kt_minhthien.model.Productkt6;
import com.edu.csc.kt_minhthien.model.SaleManagerkt6;

import java.util.ArrayList;

public class MainKT6 extends AppCompatActivity {
    ListView lvProductkt6;
    ProductAdapterkt6 adapterkt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_kt6);
        lvProductkt6=(ListView) findViewById(R.id.lvflag);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("List KT6");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SaleManagerkt6 saleManager=SaleManagerkt6.get();
        saleManager.generateProducts();

        ArrayList products = saleManager.getProducts();
        adapterkt6 = new ProductAdapterkt6(this, products);
        lvProductkt6.setAdapter(adapterkt6);

        lvProductkt6.setOnItemLongClickListener(new ItemLongCLickRemove());

        lvProductkt6.setOnItemClickListener((parent, view, position, id) ->{
            Intent intent = new Intent(MainKT6.this, ProductActivitykt6.class);
            intent.putExtra( ProductActivitykt6.EXTRA_POSITION,position);
            startActivity(intent);
        });

    }

    private class ItemLongCLickRemove implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainKT6.this);
            alertDialogBuilder.setMessage("B??n c?? mu???n x??a s???n ph???m n??y!");
            alertDialogBuilder.setPositiveButton("C??", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // x??a sp ??ang nh???n gi???
                    SaleManagerkt6.get().getProducts().remove(position);
                    //c???p nh???t l???i listview
                    adapterkt6.notifyDataSetChanged();

                }
            });
            alertDialogBuilder.setNegativeButton("Kh??ng", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //kh??ng l??m g??
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
    @Override   //x??? l?? s??? ki???n khi b???m n??t
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.btnAdd:
                //code x??? l?? khi b???m menu2
                openMyCustom();

                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openMyCustom() {
        // Kh???i t???o AlertDialog t??? ?????i t?????ng Builder. tham s??? truy???n v??o ??? ????y l?? context.
        final AlertDialog builder = new AlertDialog.Builder(this).create();

        // Kh???i t???o ?????i t?????ng View t??? file activity_add_edit_kt5.
        final View alert = LayoutInflater.from(this).inflate(R.layout.activity_product_activitykt6, null);

        // Set layout cho alert dialog
        builder.setView(alert);

        final EditText editTextTen;
        final EditText editTextDan;
        Button buttonLuu;
        Button buttonThoat;

        // Tham chi???u c??c ?????i t?????ng c?? tr??n giao di???n dialog v???a ???????c set
        editTextTen = alert.findViewById(R.id.txtName );
        editTextDan = alert.findViewById(R.id.txtDan);

        buttonLuu = alert.findViewById(R.id.btnOK);
        buttonThoat = alert.findViewById(R.id.btnCancel);

        // T???o dialog v?? hi???n th???
        builder.show();

        // B???t s??? ki???n click v??o n??t L??u
        buttonLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Productkt6 product = new Productkt6();
                product.setNameflag(editTextTen.getText().toString());
                product.setPopuflag(editTextDan.getText().toString());

                adapterkt6.add(product);
                adapterkt6.notifyDataSetChanged();
                builder.dismiss();
            }
        });

        // B???t s??? ki???n click v??o n??t Tho??t
        buttonThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
            }
        });
    }
}