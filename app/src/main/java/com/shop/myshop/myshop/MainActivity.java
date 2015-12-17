package com.shop.myshop.myshop;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;

import com.shop.myshop.fragment.HomeFragment;
import com.shop.myshop.fragment.MessageFragment;
import com.shop.myshop.fragment.PerFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FragmentManager mfm;
    FragmentTransaction ftt;
    RadioButton mhome,mmessage,mper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mhome = (RadioButton)findViewById(R.id.home);//主页的单选按钮
        mmessage = (RadioButton)findViewById(R.id.message);//信息的单选按钮
        mper = (RadioButton)findViewById(R.id.per);//个人的单选按钮
        mhome.setChecked(true);

        //为每个按钮添加点击事件
        mmessage.setOnClickListener(this);
        mper.setOnClickListener(this);
        mhome.setOnClickListener(this);
        mper.setOnClickListener(this);

        mfm = getSupportFragmentManager();
        if (savedInstanceState == null){
            FragmentTransaction ftt = mfm.beginTransaction();
            HomeFragment pf = new HomeFragment();
            ftt.add(R.id.fragment_parent, pf, "home");
            ftt.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ftt = mfm.beginTransaction();
        if (mfm.findFragmentByTag("home")!= null){
            ftt.hide(mfm.findFragmentByTag("home"));
        }
        if (mfm.findFragmentByTag("message")!= null){
            ftt.hide(mfm.findFragmentByTag("message"));
        }
        if (mfm.findFragmentByTag("per")!= null){
            ftt.hide(mfm.findFragmentByTag("per"));
        }
        int id = v.getId();
        if (id == R.id.home){
            if (mfm.findFragmentByTag("home")!=null){
                ftt.show(mfm.findFragmentByTag("home"));
            }else{
                HomeFragment hf = new HomeFragment();
                //add(父布局ID，Fragment，Tag);
                ftt.add(R.id.fragment_parent, hf, "home");
            }

        }else if (id == R.id.message){
            if (mfm.findFragmentByTag("message")!=null){
                ftt.show(mfm.findFragmentByTag("message"));
            }else{
                MessageFragment ff = new MessageFragment();
                ftt.add(R.id.fragment_parent,ff,"message");
            }
        }else if (id == R.id.per){   //我的
            if (mfm.findFragmentByTag("per")!=null){
                ftt.show(mfm.findFragmentByTag("per"));
            }else{
                PerFragment nf = new PerFragment();
                //add(父布局ID，Fragment，Tag);
                ftt.add(R.id.fragment_parent,nf,"per");
            }
        }
        ftt.commit();
    }
}
