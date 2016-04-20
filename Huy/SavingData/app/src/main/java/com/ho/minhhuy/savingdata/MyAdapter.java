package com.ho.minhhuy.savingdata;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hi on 3/24/2016.
 */
public class MyAdapter extends ArrayAdapter<Person> {
    Activity conActivity;
    int idLayout;
    ArrayList<Person> alpPersons;

    public MyAdapter(Activity content, int idLayout, ArrayList<Person> alPersons) {
        super(content, idLayout, alPersons);
        this.alpPersons = alPersons;
        this.idLayout = idLayout;
        conActivity = content;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = conActivity.getLayoutInflater();
            convertView = layoutInflater.inflate(idLayout, null);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.ten);
            viewHolder.tvsdt = (TextView) convertView.findViewById(R.id.sdt);
            convertView.setTag(viewHolder);
        }
        Person contact = alpPersons.get(position);
        viewHolder.tvName.setText("\t\tName : " + contact.getName());
        viewHolder.tvsdt.setText("\t\tPhone : " + contact.getAge());
        notifyDataSetChanged();
        return convertView;

    }

    static class ViewHolder {
        TextView tvName, tvsdt;
        ImageView imageView;

    }
}
