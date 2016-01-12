package com.shop.myshop.bean;

/**
 * Created by Administrator on 2016/1/8.
 */
public class Hot {
    private String text;
    private int img;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Hot(String text, int img) {
        this.text = text;
        this.img = img;
    }
}
