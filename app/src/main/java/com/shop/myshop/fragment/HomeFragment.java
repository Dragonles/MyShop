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
import android.widget.ListView;
import android.widget.ScrollView;

import com.shop.myshop.Adpter.HomeGridviewAdpter;
import com.shop.myshop.Adpter.HorizontalListViewAdapter;
import com.shop.myshop.Adpter.HotBtomAdpter;
import com.shop.myshop.Adpter.HotListAdpter;
import com.shop.myshop.bean.HlistImg;
import com.shop.myshop.bean.Hot;
import com.shop.myshop.myshop.AddressActivtiy;
import com.shop.myshop.myshop.CaptureActivity;
import com.shop.myshop.myshop.CareActivity;
import com.shop.myshop.myshop.LoginActivity;
import com.shop.myshop.myshop.R;
import com.shop.myshop.myshop.RegistActivity;
import com.shop.myshop.myshop.SelectActivity;
import com.shop.myshop.untils.GridViewForScrollView;
import com.shop.myshop.untils.HorizontalListView;
import com.shop.myshop.untils.HttpUtils;
import com.shop.myshop.untils.ListViewForScrollView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class  HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ImageButton mclass,mqrcode;
    GridViewForScrollView gridView,hot_btom_list;
   // private InfiniteIndicatorLayout mDefaultInDicator;
    ScrollView scr;
    HorizontalListView horizontalListView;
    List<HlistImg> list=new ArrayList<>();
    List<Hot> btom_list=new ArrayList<>();
    GridViewForScrollView hot_lists;
    List<Hot> hot_list = new ArrayList<>();
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
        hot_btom_list=(GridViewForScrollView)v.findViewById(R.id.hot_btom_list);
        mclass=(ImageButton)v.findViewById(R.id.allclass);
        hot_lists=(GridViewForScrollView)v.findViewById(R.id.hot_list);
        mclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent =new Intent(getActivity(), CareActivity.class);
//                startActivity(intent);

            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:intens("服装");break;
                    case 1:intens("食品");break;
                    case 2:intens("科技");break;
                    case 3:intens("水果");break;
                }
            }
        });
        gridView.setAdapter(new HomeGridviewAdpter(getActivity()));
        list.add(new HlistImg(R.drawable.tuijian_first));
        list.add(new HlistImg(R.drawable.tuijian_two));
        list.add(new HlistImg(R.drawable.tuijian_three));
        list.add(new HlistImg(R.drawable.tuijian_four));
        list.add(new HlistImg(R.drawable.chaonan_img));
        horizontalListView.setAdapter(new HorizontalListViewAdapter(getActivity(),list));
        hot_btom_list.setAdapter(new HotBtomAdpter(getActivity()));
        hot_lists.setAdapter(new HotListAdpter(getActivity()));
        return v;

    }

//    @Override
//    public void onSliderClick(BaseSliderView slider) {
//
//    }
    public void intens(String classname){
        Intent intent =new Intent(getActivity(),SelectActivity.class);
        intent.putExtra("cname",classname);
        startActivity(intent);
    }
}

