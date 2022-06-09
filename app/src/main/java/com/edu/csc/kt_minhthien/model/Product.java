package com.edu.csc.kt_minhthien.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String ProductName;
    private String Unit;
    private double Price;

    public Product() {
    }

    public Product(String pname, String unit, double price){
        ProductName = pname;
        Unit = unit;
        Price =  price;

    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}