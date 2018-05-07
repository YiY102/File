package com.example.main.file;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.main.file.Model.Content;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Main on 2018-04-20.
 */
@AllArgsConstructor
@NoArgsConstructor

public class ListViewAdapter extends BaseAdapter{
    ArrayList<Content>items = new ArrayList<>();
     Context context;

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Holder holder = new Holder();
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).
                    inflate(R.layout.listview_item, viewGroup, false);
            holder.storelocation_lv = view.findViewById(R.id.storelocation_lv);
            holder.storename_lv = view.findViewById(R.id.storename_lv);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        Content item = (Content)getItem(i);

        holder.storename_lv.setText(item.getName());
        holder.storelocation_lv.setText(item.getLocation());







        return view;
    }


    private class Holder {

        TextView storelocation_lv;
        TextView storename_lv;

    }
}