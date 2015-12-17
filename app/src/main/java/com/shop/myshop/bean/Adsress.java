package com.shop.myshop.bean;

/**
 * Created by Administrator on 2015/12/17.
 */
public class Adsress {
    private String names;
    private String phones;
    private String adresss;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getAdresss() {
        return adresss;
    }

    public void setAdresss(String adresss) {
        this.adresss = adresss;
    }

    public Adsress(String names, String adresss, String phones) {
        this.names = names;
        this.adresss = adresss;
        this.phones = phones;
    }
}
