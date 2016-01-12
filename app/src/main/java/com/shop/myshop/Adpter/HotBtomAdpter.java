package com.shop.myshop.Adpter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shop.myshop.myshop.R;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/1/8.
 */
public class HotBtomAdpter extends BaseAdapter {
    private int[] images={R.drawable.pixie_img, R.drawable.bao_img,R.drawable.shoubiao_img,R.drawable.huoji_img,R.drawable.lingshi_img};
    private String[] texts={"鞋履","女包","手表","烟酒","零食"};
    LayoutInflater inflater;
    public HotBtomAdpter(Context context)
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
        View v = inflater.inflate(R.layout.btom_list_item, null);
        ImageView iv = (ImageView) v.findViewById(R.id.btom_img);
        TextView tv = (TextView) v.findViewById(R.id.btom_texts);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setPadding(8, 8, 8, 8);
        iv.setImageResource(images[position]);
        tv.setText(texts[position]);
        return v;
    }
}
