package com.example.chitramitra;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<com.example.chitramitra.GridItem> gridItems;

    public GridAdapter(Context context, ArrayList<com.example.chitramitra.GridItem> gridItems) {
        this.context = context;
        this.gridItems = gridItems;
    }

    @Override
    public int getCount() {
        return gridItems.size();
    }

    @Override
    public Object getItem(int position) {
        return gridItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.grid_item, null);


            ImageView imageView = (ImageView) gridView.findViewById(R.id.grid_image);
            TextView textView = (TextView) gridView.findViewById(R.id.item_name);

            com.example.chitramitra.GridItem item = gridItems.get(position);
            Picasso.get().load(item.getImgURL()).into(imageView);
            textView.setText(item.Title);
        } else {
            gridView = convertView;
        }

        return gridView;
    }
}
