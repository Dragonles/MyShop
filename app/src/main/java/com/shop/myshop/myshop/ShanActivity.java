package com.shop.myshop.myshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ShanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shan);
        new Thread (new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    /*
                    * 延迟3秒后跳转引导页（LeadActivity）
                    * */
                    Intent intent =new Intent(ShanActivity.this,LeadActivity.class);
                    ShanActivity.this.startActivity(intent);
                    ShanActivity.this.finish();
                    break;
                }
            }
        }).start();
    }

}
