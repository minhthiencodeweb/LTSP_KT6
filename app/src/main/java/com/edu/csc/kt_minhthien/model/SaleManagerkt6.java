package com.edu.csc.kt_minhthien.model;

import com.edu.csc.kt_minhthien.R;

import java.io.Serializable;
import java.util.ArrayList;

public class SaleManagerkt6 implements Serializable {
    private ArrayList Products;

    public SaleManagerkt6(){
        Products = new ArrayList();

    }


    public ArrayList getProducts(){
        return Products;
    }

    public void setProducts(ArrayList products){
        Products = products;
    }

    public void generateProducts(){
        Products.clear();
        Products.add(new Productkt6(R.drawable.h14,"Sản Phẩm 1","Giá:1000000" ));
        Products.add(new Productkt6(R.drawable.h12,"Sản Phẩm 2","Giá:2000000" ));
        Products.add(new Productkt6(R.drawable.h11,"Sản Phẩm 3","Giá:3000000" ));
        Products.add(new Productkt6(R.drawable.h10,"Sản Phẩm 4","Giá:4000000" ));
        Products.add(new Productkt6(R.drawable.h6,"Sản Phẩm 5","Giá:10000" ));
        Products.add(new Productkt6(R.drawable.h8,"Sản Phẩm 6","Giá:1000" ));
        Products.add(new Productkt6(R.drawable.h9,"Sản Phẩm 7","Giá:1500" ));

    }

    private static SaleManagerkt6 saleManagerkt6;

    public static SaleManagerkt6 get(){
        if(saleManagerkt6 == null)
            saleManagerkt6 = new SaleManagerkt6();
        return saleManagerkt6;
    }


}
