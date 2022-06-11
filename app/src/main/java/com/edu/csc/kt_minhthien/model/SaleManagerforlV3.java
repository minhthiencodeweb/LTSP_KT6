package com.edu.csc.kt_minhthien.model;

import com.edu.csc.kt_minhthien.R;

import java.io.Serializable;
import java.util.ArrayList;

public class SaleManagerforlV3 implements Serializable{
    private ArrayList Products;

    public SaleManagerforlV3(){
        Products = new ArrayList();
    }


    public ArrayList getProducts() {
        return Products;
    }

    public void setProducts(ArrayList products) {
        Products = products;
    }

    public void generateProducts(){
        Products.clear();
        Products.add(new sanpham(R.drawable.h1,"Sản phẩm",42000));
        Products.add(new sanpham(R.drawable.h1,"Sản phẩm",50000));
        Products.add(new sanpham(R.drawable.h1,"Sản phẩm",2000));
        Products.add(new sanpham(R.drawable.h1,"Sản phẩm",60000));
        Products.add(new sanpham(R.drawable.h1,"Sản phẩm",10000));

    }
    private static SaleManagerforlV3 saleManager;

    public static SaleManagerforlV3 get(){
        if(saleManager == null)
            saleManager = new SaleManagerforlV3();
        return saleManager;
    }
}