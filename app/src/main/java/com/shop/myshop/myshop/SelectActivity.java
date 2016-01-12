package com.shop.myshop.myshop;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.shop.myshop.Adpter.SelectAdpter;
import com.shop.myshop.bean.Select;
import com.shop.myshop.untils.GridViewForScrollView;
import com.shop.myshop.untils.HttpUtils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class SelectActivity extends AppCompatActivity {

    List<Select> list =new ArrayList<>();
    Spinner sp;
    String cname;
    ArrayAdapter<String> adapter;
    ProgressDialog progressDialog;
    SelectAdpter selectAdpter;
    private static final String[] m={"综合排序","价格从高到底","价格从低到高"};
    GridViewForScrollView gridViewForScrollView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        sp=(Spinner)findViewById(R.id.spinner_zonghe);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m);
        //设置下拉列表的风格
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter 添加到spinner中
        sp.setAdapter(adapter);
        //添加事件Spinner事件监听
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);
                ((TextView) parent.getChildAt(0)).setTextSize(14);
//                Toast.makeText(SelectActivity.this,position,Toast.LENGTH_SHORT).show();
                switch (position){
                    case 1:orderby();break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//        sp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch (position){
//                    case 1:orderby();break;
//                }
//            }
//        });
        //设置默认值
        sp.setVisibility(View.VISIBLE);
        gridViewForScrollView=(GridViewForScrollView)findViewById(R.id.select_gridview);
        gridViewForScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        Intent intent =getIntent();
        cname=intent.getStringExtra("cname");
        Log.i("cname",cname);
        selectgood(cname);
    }
    public void selectgood(String cname){
        String types = "/Long/selectgood";
        HashMap<String, String> map = new HashMap<>();
        map.put("classname", cname);
        HttpUtils.httputilsPost(types, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println("onSuccess" + s.toString());
                Log.i("sss",s.toString());
                try {
                    JSONObject data = new JSONObject(s);
                    String code = data.get("code").toString();
                    String nessage = data.get("message").toString();
                    JSONArray datas = (JSONArray) data.get("data");
                    List<Select> usersList = new ArrayList<Select>();
                    for (int i = 0; i < datas.length(); i++) {
                        JSONObject info = datas.getJSONObject(i);
                        Select order = new Select();
                        //order.setGoodsthnum((Integer) info.get("goodsThums"));
                        order.setGoodsname(info.get("goodsName").toString());
                        order.setSaleCount(info.get("saleCount").toString());
                        order.setShopPrice(info.get("shopPrice").toString());
                        list.add(order);
                    }
                    selectAdpter=new SelectAdpter(SelectActivity.this,list);
                    gridViewForScrollView.setAdapter(selectAdpter);
                    selectAdpter.notifyDataSetChanged();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onError(Throwable throwable, boolean b) {
                System.out.println("onError" + throwable.toString());
                Log.i("sser",throwable.getMessage());
            }

            @Override
            public void onCancelled(CancelledException e) {
                Log.i("CancelledException",e.toString());
            }

            @Override
            public void onFinished() {

            }
        });
    }
    //使用数组形式操作
    class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
        }

        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }
    public void orderby(){

        String types = "/Api/exeQuery";
        String sql="SELECT `goodsName`,`goodsThums`,`shopPrice`,`saleCount`,`catName` FROM wst_goods as wg JOIN wst_goods_cat_brands as wgcb ON wg.brandId=wgcb.brandId JOIN wst_goods_cats as wgc ON wgcb.catId=wgc.catId WHERE wgc.catName LIKE '%"+cname+"%' ORDER BY wg.shopPrice";
        HashMap<String, String> map = new HashMap<>();
        map.put("sql", sql);
        HttpUtils.httputilsPost(types, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println("onSuccess" + s.toString());
                Log.i("sss",s.toString());
                try {
                    JSONObject data = new JSONObject(s);
                    String code = data.get("code").toString();
                    String nessage = data.get("message").toString();
                    JSONArray datas = (JSONArray) data.get("data");
                    List<Select> usersList = new ArrayList<Select>();
                    for (int i = 0; i < datas.length(); i++) {
                        JSONObject info = datas.getJSONObject(i);
                        Select order = new Select();
                        //order.setGoodsthnum((Integer) info.get("goodsThums"));
                        order.setGoodsname(info.get("goodsName").toString());
                        order.setSaleCount(info.get("saleCount").toString());
                        order.setShopPrice(info.get("shopPrice").toString());
                        list.add(order);
                    }
                    selectAdpter=new SelectAdpter(SelectActivity.this,list);
                    gridViewForScrollView.setAdapter(selectAdpter);
                    selectAdpter.notifyDataSetChanged();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onError(Throwable throwable, boolean b) {
                System.out.println("onError" + throwable.toString());
                Log.i("sser",throwable.getMessage());
            }

            @Override
            public void onCancelled(CancelledException e) {
                Log.i("CancelledException",e.toString());
            }

            @Override
            public void onFinished() {

            }
        });
    }
}
