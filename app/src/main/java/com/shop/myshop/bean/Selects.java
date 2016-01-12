package com.shop.myshop.bean;

/**
 * Created by Administrator on 2016/1/10.
 */
public class Selects {
    private int img;
    private String title;
    private String money;
    private String number;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Selects(int img, String title, String money, String number) {
        this.img = img;
        this.title = title;
        this.money = money;
        this.number = number;
    }
}

