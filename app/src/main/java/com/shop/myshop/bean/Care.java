package com.shop.myshop.bean;

/**
 * Created by Administrator on 2015/12/17.
 */
public class Care  {
    private int care_img;
    private String care_name;

    public int getCare_img() {
        return care_img;
    }

    public void setCare_img(int care_img) {
        this.care_img = care_img;
    }

    public String getCare_name() {
        return care_name;
    }

    public void setCare_name(String care_name) {
        this.care_name = care_name;
    }

    public Care(int care_img, String care_name) {
        this.care_img = care_img;
        this.care_name = care_name;
    }
}
