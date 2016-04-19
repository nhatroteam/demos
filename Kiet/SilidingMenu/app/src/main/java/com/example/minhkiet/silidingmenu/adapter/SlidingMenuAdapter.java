package com.example.minhkiet.silidingmenu.adapter;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.minhkiet.silidingmenu.R;
import com.example.minhkiet.silidingmenu.model.ItemSlidingMenu;

import java.util.ArrayList;

/**
 * Created by Minh Kiet on 4/14/2016.
 */
public class SlidingMenuAdapter extends BaseAdapter {
    private ArrayList<ItemSlidingMenu> itemSlidingMenus;
    private LayoutInflater inflater;

    public SlidingMenuAdapter(Activity context, ArrayList<ItemSlidingMenu> itemSlidingMenus) {
        this.itemSlidingMenus = itemSlidingMenus;
        this.inflater = context.getLayoutInflater();
    }


    @Override
    public int getCount() {
        return itemSlidingMenus.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            viewHolder = new ViewHolder();

            convertView = inflater.inflate(R.layout.item_sliding_menu, null);

            viewHolder.image = (ImageView) convertView.findViewById(R.id.ivImage);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tvTitle);

            convertView.setTag(viewHolder);
        }

        ItemSlidingMenu item = itemSlidingMenus.get(position);

        viewHolder.image.setImageResource(item.getImageId());
        viewHolder.title.setText(item.getTitle());

        return convertView;
    }

    static class ViewHolder {
        ImageView image;
        TextView title;
    }
}
