package com.shop.myshop.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shop.myshop.bean.Select;
import com.shop.myshop.myshop.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/10.
 */
public class SelectAdpter extends BaseAdapter{
    Context context;
    List<Select> lists = new ArrayList<>();
    public SelectAdpter(Context context,List<Select> lists)
    {
        this.lists=lists;
        this.context=context;
    }
    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null)
        {
            holder= new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.select_item,null);
            holder.goodstitle=(TextView)convertView.findViewById(R.id.select_title);
            holder.select_img=(ImageView) convertView.findViewById(R.id.select_img);
            holder.goodsmoney=(TextView)convertView.findViewById(R.id.select_money);
            holder.counts=(TextView)convertView.findViewById(R.id.select_nmbuer);
            convertView.setTag(holder);
            holder.select_img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            holder.select_img.setPadding(8, 8, 8, 8);
        }
        else {
            holder=(ViewHolder)convertView.getTag();
        }
        holder.goodstitle.setText(lists.get(position).getGoodsname());
       // Picasso.with(context).load("http://122.114.62.25:8686/"+lists.get(position).getGoodsthnum()).into(holder.select_img);
        holder.goodsmoney.setText(lists.get(position).getShopPrice());
        holder.counts.setText(lists.get(position).getSaleCount());
        return convertView;
    }
    class ViewHolder
    {

        public TextView goodstitle;
        public ImageView select_img;
        public TextView goodsmoney;
        public TextView counts;
    }
}
