package com.shop.myshop.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shop.myshop.myshop.R;

/**
 * Created by Administrator on 2016/1/6.
 */
public class HomeGridviewAdpter extends BaseAdapter {
    private int[] images={R.drawable.home_cloth_img, R.drawable.home_food_img,R.drawable.home_phone_img,R.drawable.home_baby_img};
    private String[] texts={"服装","饮食","数码","孕婴"};

    LayoutInflater inflater;
    public HomeGridviewAdpter(Context context)
    {
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v =inflater.inflate(R.layout.gridview_item,null);
        ImageView iv=(ImageView)v.findViewById(R.id.gridview_img);
        TextView tv=(TextView)v.findViewById(R.id.gridview_text);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setPadding(8, 8, 8, 8);
        iv.setImageResource(images[position]);
        tv.setText(texts[position]);
        return v;
    }
}
