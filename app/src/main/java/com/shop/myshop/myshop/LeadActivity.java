package com.shop.myshop.myshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.shop.myshop.untils.JazzyViewPager;
import com.shop.myshop.untils.OutlineContainer;

import java.util.ArrayList;
import java.util.List;

public class LeadActivity extends AppCompatActivity {

    List<View> list_lead_view = new ArrayList<>();
    private JazzyViewPager mJazzy;
    Button gos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead);
        View v1 = LayoutInflater.from(LeadActivity.this).inflate(R.layout.view_pager1,null);
        View v2 = LayoutInflater.from(LeadActivity.this).inflate(R.layout.view_pager2,null);
        View v3 = LayoutInflater.from(LeadActivity.this).inflate(R.layout.view_pager3,null);
        list_lead_view.add(v1);
        list_lead_view.add(v2);
        list_lead_view.add(v3);
        setupJazziness(JazzyViewPager.TransitionEffect.CubeOut);
        gos=(Button)v3.findViewById(R.id.go);
        gos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LeadActivity.this,MainActivity.class);
                LeadActivity.this.finish();
                startActivity(intent);
            }
        });
    }

    private void setupJazziness(JazzyViewPager.TransitionEffect effect) {
        mJazzy = (JazzyViewPager) findViewById(R.id.jazzy_pager);
        mJazzy.setTransitionEffect(effect);
        mJazzy.setAdapter(new MainAdapter());
        mJazzy.setPageMargin(30);
    }
    private class MainAdapter extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View v = list_lead_view.get(position);
            container.addView(v,ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            mJazzy.setObjectForPosition(v, position);
            // container.removeView(list_lead_view.get(position));
            return v;

        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object obj) {
            container.removeView(mJazzy.findViewFromObject(position));
        }
        @Override
        public int getCount() {
            return 3;
        }
        @Override
        public boolean isViewFromObject(View view, Object obj) {
            if (view instanceof OutlineContainer) {
                return ((OutlineContainer) view).getChildAt(0) == obj;
            } else {
                return view == obj;
            }
        }
    }
}
