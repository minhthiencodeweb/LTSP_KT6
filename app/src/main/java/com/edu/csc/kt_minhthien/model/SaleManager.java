package com.edu.csc.kt_minhthien.model;

import java.io.Serializable;
import java.util.ArrayList;

public class SaleManager implements Serializable {
    private ArrayList<Product> Products;

    public SaleManager(){
        Products = new ArrayList<>();
    }


    public ArrayList<Product> getProducts() {
        return Products;
    }

    public void setProducts(ArrayList<Product> products) {
        Products = products;
    }

    public void generateProducts(){
        Products.clear();
        Products.add(new Product("Socola KitKat","Gói",42000));
        Products.add(new Product("Kẹo dẻo Jelly Bean","Hộp",50000));
        Products.add(new Product("Bánh kem Icecream Sandwich","Que",2000));
        Products.add(new Product("Mật ong rừng HoneyComb","Hũ",60000));
        Products.add(new Product("Bánh mì gừng GingerBread","Ổ",10000));

    }
    private static SaleManager saleManager;

    public static SaleManager get(){
        if(saleManager == null)
            saleManager = new SaleManager();
        return saleManager;
    }
}
