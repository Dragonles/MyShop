package com.shop.myshop.untils;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.shop.myshop.myshop.R;
import com.shop.myshop.myshop.ShopsInfoActivity;

/**
 * Created by 陈增庆 on 2016/1/10.
 */
public class ShopsInfoDialog extends AlertDialog {
    public ShopsInfoDialog(Context context) {
        super(context);
    }

    public ShopsInfoDialog(Context context, int theme) {
        super(context, theme);
    }

    private TextView tv_shopsdialog_message,tv_shopsdialog_classify,tv_shopsdialog_collect,tv_shopsdialog_contact,tv_shopsdialog_backtohome;

    private ImageView iv_shopsdialog_collect;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_shopsinfo_menu_style);
        tv_shopsdialog_message = (TextView) findViewById(R.id.tv_shopsdialog_message); //消息
        tv_shopsdialog_classify = (TextView) findViewById(R.id.tv_shopsdialog_classify); //分类
        tv_shopsdialog_collect = (TextView) findViewById(R.id.tv_shopsdialog_collect); //收藏
        tv_shopsdialog_contact = (TextView) findViewById(R.id.tv_shopsdialog_contact); //联系卖家
        tv_shopsdialog_backtohome = (TextView) findViewById(R.id.tv_shopsdialog_backtohome); //返回首页
        iv_shopsdialog_collect = (ImageView) findViewById(R.id.iv_shopsdialog_collect);
        changeCollect();
        tv_shopsdialog_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"点击了消息",Toast.LENGTH_SHORT).show();
            }
        });
        tv_shopsdialog_classify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"点击了分类",Toast.LENGTH_SHORT).show();
            }
        });
        tv_shopsdialog_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ShopsInfoActivity.iscollect == false){
                    ShopsInfoActivity.iscollect = true;
                    iv_shopsdialog_collect.setImageResource(R.drawable.iconfont_favor_checked);
                    tv_shopsdialog_collect.setText("取消收藏");
                    ShopsInfoActivity.cb_shopsinfo_collect.setChecked(true);
                    ShopsInfoActivity.cb_shopsinfo_collect.setText("取消收藏");
                } else {
                    ShopsInfoActivity.iscollect = false;
                    iv_shopsdialog_collect.setImageResource(R.drawable.iconfont_favor);
                    tv_shopsdialog_collect.setText("收藏");
                    ShopsInfoActivity.cb_shopsinfo_collect.setChecked(false);
                    ShopsInfoActivity.cb_shopsinfo_collect.setText("收藏");
                }
            }
        });
        tv_shopsdialog_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"点击了联系卖家",Toast.LENGTH_SHORT).show();
            }
        });
        tv_shopsdialog_backtohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"点击了返回首页",Toast.LENGTH_SHORT).show();
            }
        });

    }

    // 更该收藏按钮状态
    public void changeCollect (){
        if (ShopsInfoActivity.iscollect == true){
            iv_shopsdialog_collect.setImageResource(R.drawable.iconfont_favor_checked);
            tv_shopsdialog_collect.setText("取消收藏");
        } else {
            iv_shopsdialog_collect.setImageResource(R.drawable.iconfont_favor);
            tv_shopsdialog_collect.setText("收藏");
        }
    }

}
