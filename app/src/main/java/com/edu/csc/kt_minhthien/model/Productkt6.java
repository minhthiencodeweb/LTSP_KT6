package com.edu.csc.kt_minhthien.model;

import java.io.Serializable;

public class Productkt6 implements Serializable {
    private int imageflag;
    private String nameflag;
    private String popuflag;

    public Productkt6() {
    }

    public Productkt6(int imageflag, String nameflag, String popuflag) {
        this.imageflag = imageflag;
        this.nameflag = nameflag;
        this.popuflag = popuflag;
    }

    public int getImageflag() {
        return imageflag;
    }

    public void setImageflag(int imageflag) {
        this.imageflag = imageflag;
    }

    public String getNameflag() {
        return nameflag;
    }

    public void setNameflag(String nameflag) {
        this.nameflag = nameflag;
    }

    public String getPopuflag() {
        return popuflag;
    }

    public void setPopuflag(String popuflag) {
        this.popuflag = popuflag;
    }

    public void getImageflag(String toString) {
    }
}
