package com.shop.myshop.Adpter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shop.myshop.bean.HlistImg;
import com.shop.myshop.myshop.R;

import java.util.List;

/**
 * Created by Administrator on 2016/1/6.
 */
public class HorizontalListViewAdapter extends BaseAdapter {
     List<HlistImg> lists;
    private Context mContext;

    public HorizontalListViewAdapter(Context context,List<HlistImg> lists){
        this.mContext = context;
        this.lists=lists;
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

        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.horizontal_list_item, null);
            holder.mImage=(ImageView)convertView.findViewById(R.id.img_list_item);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
            holder.mImage.setBackgroundResource(lists.get(position).getImg());
        }

        return convertView;
    }

    class ViewHolder {
        private ImageView mImage;
    }
}
