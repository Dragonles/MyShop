package com.shop.myshop.myshop;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.shop.myshop.Adpter.CareAdpter;
import com.shop.myshop.bean.Care;

import java.util.ArrayList;
import java.util.List;

public class CareActivity extends AppCompatActivity {

    List<Care> list=new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care);
        listView=(ListView)findViewById(R.id.care_list);
        list.add(new Care(R.drawable.dianpu_img,"百万小店"));
        list.add(new Care(R.drawable.dainpu_imgs,"傻福小苍"));
        listView.setAdapter(new CareAdpter(getApplicationContext(),list));
    }

}
