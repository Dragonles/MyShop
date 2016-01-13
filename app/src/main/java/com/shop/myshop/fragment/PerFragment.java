package com.shop.myshop.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.shop.myshop.myshop.R;

public class PerFragment extends Fragment implements View.OnClickListener {

    FragmentManager mfm;
    RadioButton rb_user_footers,rb_user_having,rb_user_collect;

    public PerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_per,container,false);

        rb_user_footers = (RadioButton) v.findViewById(R.id.rb_user_footers); // 足迹
        rb_user_having = (RadioButton) v.findViewById(R.id.rb_user_having); // 已买到
        rb_user_collect = (RadioButton) v.findViewById(R.id.rb_user_collect); // 收藏

        rb_user_footers.setChecked(true);

        rb_user_footers.setOnClickListener(this);
        rb_user_having.setOnClickListener(this);
        rb_user_collect.setOnClickListener(this);

        mfm = getActivity().getSupportFragmentManager();
        if (savedInstanceState == null){
            FragmentTransaction ftt = mfm.beginTransaction();
            FooterFragment ff = new FooterFragment();

            ftt.add(R.id.fragment_per_parent, ff, "footers");
            ftt.commit();
        }

        return v;
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ftt = mfm.beginTransaction();
        if (mfm.findFragmentByTag("footers")!= null){
            ftt.hide(mfm.findFragmentByTag("footers"));
        }
        if (mfm.findFragmentByTag("having")!= null){
            ftt.hide(mfm.findFragmentByTag("having"));
        }
        if (mfm.findFragmentByTag("collect")!= null){
            ftt.hide(mfm.findFragmentByTag("collect"));
        }
        int id = v.getId();
        if (id == R.id.rb_user_footers){
            // 足迹
//            rb_shopsinfo_home.setTextColor(Color.rgb(239,91,91));
//            rb_shopsinfo_all.setTextColor(Color.rgb(100,89,92));
//            rb_shopsinfo_news.setTextColor(Color.rgb(100,89,92));
//            rb_shopsinfo_dongtai.setTextColor(Color.rgb(100,89,92));
            if (mfm.findFragmentByTag("footers")!=null){
                ftt.show(mfm.findFragmentByTag("footers"));
            }else{
                FooterFragment ff = new FooterFragment();
                //add(父布局ID，Fragment，Tag);
                ftt.add(R.id.fragment_per_parent, ff, "footers");
            }

        }else if (id == R.id.rb_user_having){
            //已买到
//            rb_shopsinfo_home.setTextColor(Color.rgb(100,89,92));
//            rb_shopsinfo_all.setTextColor(Color.rgb(239,91,91));
//            rb_shopsinfo_news.setTextColor(Color.rgb(100,89,92));
//            rb_shopsinfo_dongtai.setTextColor(Color.rgb(100,89,92));
            if (mfm.findFragmentByTag("having")!=null){
                ftt.show(mfm.findFragmentByTag("having"));
            }else{
                HavingFragment hf = new HavingFragment();
                ftt.add(R.id.fragment_per_parent,hf,"having");
            }
        }else if (id == R.id.rb_user_collect){
            // 收藏
//            rb_shopsinfo_home.setTextColor(Color.rgb(100,89,92));
//            rb_shopsinfo_all.setTextColor(Color.rgb(100,89,92));
//            rb_shopsinfo_news.setTextColor(Color.rgb(239,91,91));
//            rb_shopsinfo_dongtai.setTextColor(Color.rgb(100,89,92));
            if (mfm.findFragmentByTag("collect")!=null){
                ftt.show(mfm.findFragmentByTag("collect"));
            }else{
                CollectFragment cf = new CollectFragment();
                //add(父布局ID，Fragment，Tag);
                ftt.add(R.id.fragment_per_parent,cf,"collect");
            }
        }

        ftt.commit();
    }
}
