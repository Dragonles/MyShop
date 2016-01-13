package com.shop.myshop.myshop;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shop.myshop.bean.MyScrollView;
import com.shop.myshop.fragment.ShopsAllFragment;
import com.shop.myshop.fragment.ShopsDongTaiFragment;
import com.shop.myshop.fragment.ShopsHomeFragment;
import com.shop.myshop.fragment.ShopsNewsFragment;
import com.shop.myshop.untils.CircleImageView;
import com.shop.myshop.untils.ShopsInfoDialog;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_shops_info)
public class ShopsInfoActivity extends AppCompatActivity implements MyScrollView.OnScrollListener, View.OnClickListener {

    private int searchLayoutTop;
    public static CheckBox cb_shopsinfo_collect;
    public static boolean iscollect = false;

    FragmentManager mfm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        cb_shopsinfo_collect = (CheckBox) findViewById(R.id.cb_shopsinfo_collect);
        cb_shopsinfo_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iscollect = cb_shopsinfo_collect.isChecked();
                if (cb_shopsinfo_collect.isChecked() == true){
                    cb_shopsinfo_collect.setText("取消收藏");
                } else {
                    cb_shopsinfo_collect.setText("收藏");
                }
            }
        });

        ll_shopsinfo_gone.bringToFront();
        sv_shopsinfo.setOnScrollListener(this);
        rb_shopsinfo_home.setOnClickListener(this);
        rb_shopsinfo_all.setOnClickListener(this);
        rb_shopsinfo_news.setOnClickListener(this);
        rb_shopsinfo_dongtai.setOnClickListener(this);
        rb_shopsinfo_home.setChecked(true);

        mfm = getSupportFragmentManager();
        if (savedInstanceState == null){
            FragmentTransaction ftt = mfm.beginTransaction();
            ShopsHomeFragment pf = new ShopsHomeFragment();
            rb_shopsinfo_home.setTextColor(Color.rgb(239,91,91));
            ftt.add(R.id.fragment_shopsinfo, pf, "shophome");
            ftt.commit();
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            searchLayoutTop = rl_shopsinfo_storebackground.getHeight();//获取searchLayout的顶部位置
        }
    }

    // 监听滚动Y值变化，通过addView和removeView来实现悬停效果
    @Override
    public void onScroll(int scrollY) {
        Log.i("ontouch","-----scrollY-----"+scrollY+"----searchLayoutTop----"+searchLayoutTop);
        if(scrollY >= searchLayoutTop){
            if (rg_shopsinfo_checkframe.getParent()!=ll_shopsinfo_gone) {
                ll_shopsinfo_scgone.removeView(rg_shopsinfo_checkframe);
                ll_shopsinfo_gone.addView(rg_shopsinfo_checkframe);
            }
        }else{
            if (rg_shopsinfo_checkframe.getParent()!=ll_shopsinfo_scgone) {
                ll_shopsinfo_gone.removeView(rg_shopsinfo_checkframe);
                ll_shopsinfo_scgone.addView(rg_shopsinfo_checkframe);
            }
        }
    }

    // fragment 切换
    @Override
    public void onClick(View v) {
        onScroll(sv_shopsinfo.getScrollY());
        FragmentTransaction ftt = mfm.beginTransaction();
        if (mfm.findFragmentByTag("shophome")!= null){
            ftt.hide(mfm.findFragmentByTag("shophome"));
        }
        if (mfm.findFragmentByTag("all")!= null){
            ftt.hide(mfm.findFragmentByTag("all"));
        }
        if (mfm.findFragmentByTag("news")!= null){
            ftt.hide(mfm.findFragmentByTag("news"));
        }
        if (mfm.findFragmentByTag("dongtai")!= null){
            ftt.hide(mfm.findFragmentByTag("dongtai"));
        }
        int id = v.getId();
        if (id == R.id.rb_shopsinfo_home){
            rb_shopsinfo_home.setTextColor(Color.rgb(239,91,91));
            rb_shopsinfo_all.setTextColor(Color.rgb(100,89,92));
            rb_shopsinfo_news.setTextColor(Color.rgb(100,89,92));
            rb_shopsinfo_dongtai.setTextColor(Color.rgb(100,89,92));
            if (mfm.findFragmentByTag("shophome")!=null){
                ftt.show(mfm.findFragmentByTag("shophome"));
            }else{
                ShopsHomeFragment hf = new ShopsHomeFragment();
                //add(父布局ID，Fragment，Tag);
                ftt.add(R.id.fragment_shopsinfo, hf, "shophome");
            }

        }else if (id == R.id.rb_shopsinfo_all){
            rb_shopsinfo_home.setTextColor(Color.rgb(100,89,92));
            rb_shopsinfo_all.setTextColor(Color.rgb(239,91,91));
            rb_shopsinfo_news.setTextColor(Color.rgb(100,89,92));
            rb_shopsinfo_dongtai.setTextColor(Color.rgb(100,89,92));
            if (mfm.findFragmentByTag("all")!=null){
                ftt.show(mfm.findFragmentByTag("all"));
            }else{
                ShopsAllFragment ff = new ShopsAllFragment();
                ftt.add(R.id.fragment_shopsinfo,ff,"all");
            }
        }else if (id == R.id.rb_shopsinfo_news){
            rb_shopsinfo_home.setTextColor(Color.rgb(100,89,92));
            rb_shopsinfo_all.setTextColor(Color.rgb(100,89,92));
            rb_shopsinfo_news.setTextColor(Color.rgb(239,91,91));
            rb_shopsinfo_dongtai.setTextColor(Color.rgb(100,89,92));
            if (mfm.findFragmentByTag("news")!=null){
                ftt.show(mfm.findFragmentByTag("news"));
            }else{
                ShopsNewsFragment nf = new ShopsNewsFragment();
                //add(父布局ID，Fragment，Tag);
                ftt.add(R.id.fragment_shopsinfo,nf,"news");
            }
        }else if (id == R.id.rb_shopsinfo_dongtai){
            rb_shopsinfo_home.setTextColor(Color.rgb(100,89,92));
            rb_shopsinfo_all.setTextColor(Color.rgb(100,89,92));
            rb_shopsinfo_news.setTextColor(Color.rgb(100,89,92));
            rb_shopsinfo_dongtai.setTextColor(Color.rgb(239,91,91));
            if (mfm.findFragmentByTag("dongtai")!=null){
                ftt.show(mfm.findFragmentByTag("dongtai"));
            }else{
                ShopsDongTaiFragment nf = new ShopsDongTaiFragment();
                //add(父布局ID，Fragment，Tag);
                ftt.add(R.id.fragment_shopsinfo,nf,"dongtai");
            }
        }
        ftt.commit();
    }

    // 返回按钮
    @Event(R.id.ib_shopsinfo_back)
    private void ShopsinfoBackEvent(View v){
        this.finish();
    }

    //搜索框
    @Event(R.id.et_shopsinfo_search)
    private void ShopsinfoSearchEvent(View v){
        // 跳转搜索页面
        Toast.makeText(ShopsInfoActivity.this,"跳转搜索页面",Toast.LENGTH_SHORT).show();
    }

    // 分类按钮
    @Event(R.id.btn_shopsinfo_classify)
    private void ShopsinfoClassifyEvent(View v){
        // 跳转分类页面
        Toast.makeText(ShopsInfoActivity.this,"跳转分类页面",Toast.LENGTH_SHORT).show();
    }

    // toolbar
    @ViewInject(R.id.rl_shopsinfo_toolbar)
    private RelativeLayout rl_shopsinfo_toolbar;

    @ViewInject(R.id.ll_shopsinfo_gone)
    private LinearLayout ll_shopsinfo_gone;

    // 店铺背景
    @ViewInject(R.id.rl_shopsinfo_storebackground)
    private RelativeLayout rl_shopsinfo_storebackground;

    // 店铺头像
    @ViewInject(R.id.civ_shopsinfo_storeheader)
    private CircleImageView civ_shopsinfo_storeheader;

    // 店铺名称
    @ViewInject(R.id.tv_shopsinfo_storename)
    private TextView tv_shopsinfo_storename;

    // 店铺等级
    @ViewInject(R.id.tv_shopsinfo_storegrade)
    private TextView tv_shopsinfo_storegrade;

    // 店铺粉丝数
    @ViewInject(R.id.tv_shopsinfo_fansnum)
    private TextView tv_shopsinfo_fansnum;

    // 菜单
    @Event(R.id.iv_shopsinfo_menu)
    private void ShopsinfoMenuEvent(View v){
        Log.i("dialog","---点击了---");
        ShopsInfoDialog selectDialog = new ShopsInfoDialog(this,R.style.dialog);//创建Dialog并设置样式主题
        Window win = selectDialog.getWindow();
        WindowManager.LayoutParams params = win.getAttributes();
        win.setGravity(Gravity.RIGHT | Gravity.TOP);
        int toolheight = rl_shopsinfo_toolbar.getHeight();
        params.x = 0; // 新位置X坐标
        params.y = toolheight; // 新位置Y坐标
        win.setAttributes(params);
        selectDialog.setCanceledOnTouchOutside(true);//设置点击Dialog外部任意区域关闭Dialog
        selectDialog.show();

    }

    // 单选
    @ViewInject(R.id.ll_shopsinfo_scgone)
    private LinearLayout ll_shopsinfo_scgone;

    // 单选
    @ViewInject(R.id.rg_shopsinfo_checkframe)
    private RadioGroup rg_shopsinfo_checkframe;

    // 店铺首页
    @ViewInject(R.id.rb_shopsinfo_home)
    private RadioButton rb_shopsinfo_home;

    // 全部宝贝
    @ViewInject(R.id.rb_shopsinfo_all)
    private RadioButton rb_shopsinfo_all;

    // 新品上架
    @ViewInject(R.id.rb_shopsinfo_news)
    private RadioButton rb_shopsinfo_news;

    // 店铺动态
    @ViewInject(R.id.rb_shopsinfo_dongtai)
    private RadioButton rb_shopsinfo_dongtai;

    // 滚动条
    @ViewInject(R.id.sv_shopsinfo)
    private MyScrollView sv_shopsinfo;

    // 宝贝分类
    @Event(R.id.tv_shopsinfo_classify)
    private void ShopsClassify(View view){
        // 跳转分类页面
        Toast.makeText(ShopsInfoActivity.this,"跳转分类页面",Toast.LENGTH_SHORT).show();
    }
    // 店铺简介
    @Event(R.id.tv_shopsinfo_info)
    private void ShopsInfo(View view){
        // 跳转店铺简介页面
        Toast.makeText(ShopsInfoActivity.this,"跳转店铺简介页面",Toast.LENGTH_SHORT).show();
    }
    // 联系卖家
    @Event(R.id.tv_shopsinfo_contact)
    private void ShopsContact(View view){
        // 跳转消息页面
        Toast.makeText(ShopsInfoActivity.this,"跳转聊天页面",Toast.LENGTH_SHORT).show();
    }

}
