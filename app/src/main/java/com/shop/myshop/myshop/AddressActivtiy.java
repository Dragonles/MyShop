package com.shop.myshop.myshop;

import android.location.Address;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.shop.myshop.Adpter.AdressAdpter;
import com.shop.myshop.bean.Adsress;

import java.util.ArrayList;
import java.util.List;

public class AddressActivtiy extends AppCompatActivity {

    ListView mlstview;
    List<Adsress> lists = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_activtiy);
        mlstview=(ListView)findViewById(R.id.list_view);
        lists.add(new Adsress("猪猪侠","山东神临沂市河东经济开发区","13253436335"));
        mlstview.setAdapter(new AdressAdpter(getApplicationContext(),lists));
    }

}
