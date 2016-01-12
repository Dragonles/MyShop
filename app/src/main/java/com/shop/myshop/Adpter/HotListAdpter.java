package com.shop.myshop.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shop.myshop.bean.Adsress;
import com.shop.myshop.bean.Hot;
import com.shop.myshop.myshop.R;

import java.util.List;

/**
 * Created by Administrator on 2016/1/8.
 */
public class HotListAdpter extends BaseAdapter {
    private int[] images={R.drawable.nanzhuang_img, R.drawable.nvzhuang_frist,R.drawable.shuma_img};
    private String[] texts={"男装","女装","数码"};
    LayoutInflater inflater;
    public HotListAdpter(Context context)
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
        View v = inflater.inflate(R.layout.hot_list_item, null);
        ImageView iv = (ImageView) v.findViewById(R.id.hot_img);
        TextView tv = (TextView) v.findViewById(R.id.hot_text);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setPadding(8, 8, 8, 8);
        iv.setImageResource(images[position]);
        tv.setText(texts[position]);
        return v;
    }
}
