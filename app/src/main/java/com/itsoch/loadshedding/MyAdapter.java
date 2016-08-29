package com.itsoch.loadshedding;

/**
 * Created by saroj on 4/8/16.
 */
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<Item> {

    private final Context context;
    private final ArrayList<Item> itemsArrayList;

    static class ViewHolder {

        TextView textday;
        TextView text1;
        TextView text2;
        TextView text3;

    }

    public MyAdapter(Context context, ArrayList<Item> itemsArrayList) {

        super(context, R.layout.list_row, itemsArrayList);

        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView==null){


            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_row, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.textday = (TextView)convertView.findViewById(R.id.w1);
            viewHolder.text1 = (TextView)convertView.findViewById(R.id.l1);
            viewHolder.text2 = (TextView)convertView.findViewById(R.id.l2);
            viewHolder.text3 = (TextView)convertView.findViewById(R.id.l3);



            convertView.setTag(viewHolder);
        }

        else{

            viewHolder = (ViewHolder) convertView.getTag();
        }



        viewHolder.text1.setText(itemsArrayList.get(position).getTitle());
        viewHolder.text2.setText(itemsArrayList.get(position).getDescription());
        viewHolder.text3.setText(itemsArrayList.get(position).getthird());
        viewHolder.textday.setText(itemsArrayList.get(position).getDay());

        viewHolder = (ViewHolder)convertView.getTag();

        if(position == getday() )
        {
            convertView.setBackgroundColor(Color.parseColor("#00796b"));
            viewHolder.text1.setTextColor(Color.parseColor("#ffffff"));
            viewHolder.text2.setTextColor(Color.parseColor("#ffffff"));
            viewHolder.text3.setTextColor(Color.parseColor("#ffffff"));
        }
        else
        {}

        return convertView;

    }

    @Override
    public int getViewTypeCount() {
        return itemsArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static int getday()
    {
        Calendar calender = Calendar.getInstance();
        return ((calender.get(Calendar.DAY_OF_WEEK)-1));
    }
}

