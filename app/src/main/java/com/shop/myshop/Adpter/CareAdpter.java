package com.shop.myshop.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shop.myshop.bean.Adsress;
import com.shop.myshop.bean.Care;
import com.shop.myshop.myshop.R;

import java.util.List;

/**
 * Created by Administrator on 2015/12/17.
 */
public class CareAdpter extends BaseAdapter {
    Context context;
    List<Care> list;
    public CareAdpter(Context context, List<Care> list) {
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
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
            convertView= LayoutInflater.from(context).inflate(R.layout.care_lsit_item,null);
            holder.name=(TextView)convertView.findViewById(R.id.names);
            holder.img=(ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        }
        else {
            holder=(ViewHolder)convertView.getTag();
        }
        holder.name.setText(list.get(position).getCare_name());
        holder.img.setBackgroundResource(list.get(position).getCare_img());
        return convertView;
    }
    class ViewHolder
    {

        public TextView name;
        public ImageView img;

    }
}
