package com.shop.myshop.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.shop.myshop.Adpter.HomeGridviewAdpter;
import com.shop.myshop.Adpter.HorizontalListViewAdapter;
import com.shop.myshop.bean.HlistImg;
import com.shop.myshop.myshop.AddressActivtiy;
import com.shop.myshop.myshop.CaptureActivity;
import com.shop.myshop.myshop.CareActivity;
import com.shop.myshop.myshop.LoginActivity;
import com.shop.myshop.myshop.R;
import com.shop.myshop.myshop.RegistActivity;
import com.shop.myshop.untils.GridViewForScrollView;
import com.shop.myshop.untils.HorizontalListView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ImageButton mclass,mqrcode;
    GridViewForScrollView gridView;
    ScrollView scr;
    HorizontalListView horizontalListView;
    List<HlistImg> list=new ArrayList<>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home,container,false);
        gridView=(GridViewForScrollView)v.findViewById(R.id.gridview);
       horizontalListView=(HorizontalListView)v.findViewById(R.id.horizontalistview);
        //scr=(ScrollView)v.findViewById(R.id.scview);
        mqrcode=(ImageButton)v.findViewById(R.id.qrcode);
        mqrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), CaptureActivity.class);
                startActivity(intent);
            }
        });
        mclass=(ImageButton)v.findViewById(R.id.allclass);
        mclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), CareActivity.class);
                startActivity(intent);
            }
        });
        gridView.setAdapter(new HomeGridviewAdpter(getActivity()));
        list.add(new HlistImg(R.drawable.tuijian_first));
        list.add(new HlistImg(R.drawable.tuijian_two));
        list.add(new HlistImg(R.drawable.tuijian_three));
        list.add(new HlistImg(R.drawable.tuijian_four));
        horizontalListView.setAdapter(new HorizontalListViewAdapter(getActivity(),list));
        horizontalListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("ss","go");
                return true;
            }
        });
        horizontalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("itme",position+"");
            }
        });
        return v;

    }
}

