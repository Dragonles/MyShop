package com.shop.myshop.Adpter;

import android.content.Context;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.shop.myshop.bean.Adsress;
import com.shop.myshop.myshop.R;

import java.util.List;

/**
 * Created by Administrator on 2015/12/17.
 */
public class AdressAdpter extends BaseAdapter {
    Context context;
    List<Adsress> list;
    public AdressAdpter(Context context, List<Adsress> list) {
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
            convertView= LayoutInflater.from(context).inflate(R.layout.address_list_item,null);
            holder.address_name=(TextView)convertView.findViewById(R.id.address_username);
            holder.phone=(TextView)convertView.findViewById(R.id.address_userphone);
            holder.address_adress=(TextView)convertView.findViewById(R.id.address_user_adress);
            convertView.setTag(holder);
        }
        else {
            holder=(ViewHolder)convertView.getTag();
        }
        holder.address_name.setText(list.get(position).getNames());
        holder.phone.setText(list.get(position).getPhones());
        holder.address_adress.setText(list.get(position).getAdresss());
        return convertView;
    }
    class ViewHolder
    {

        public TextView address_name;
        public TextView phone;
        public TextView address_adress;

    }
}
