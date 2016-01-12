package com.shop.myshop.bean;

/**
 * Created by Administrator on 2016/1/11.
 */
public class Select {
    private  String goodsname;
    private int goodsthnum;
    private String shopPrice;//价格
    private String saleCount;

    public Select() {

    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public int getGoodsthnum() {
        return goodsthnum;
    }

    public void setGoodsthnum(int goodsthnum) {
        this.goodsthnum = goodsthnum;
    }

    public String getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(String shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(String saleCount) {
        this.saleCount = saleCount;
    }

    public Select(String goodsname, String saleCount, String shopPrice, int goodsthnum) {
        this.goodsname = goodsname;
        this.saleCount = saleCount;
        this.shopPrice = shopPrice;
        this.goodsthnum = goodsthnum;
    }
}
