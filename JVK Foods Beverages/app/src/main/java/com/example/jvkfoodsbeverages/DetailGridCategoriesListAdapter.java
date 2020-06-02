package com.example.jvkfoodsbeverages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class DetailGridCategoriesListAdapter extends BaseAdapter {

    Context context;
    CardView cardView;
    String[] categoryNameList;
    String[] categoryPlacesCount;
    LayoutInflater inflater;

    public DetailGridCategoriesListAdapter(Context ctx, String[] categoryNameList, String[] categoryPlacesCount) {

        this.context = ctx;
        this.categoryNameList = categoryNameList;
        this.categoryPlacesCount = categoryPlacesCount;
        this.cardView=cardView;
        inflater = (LayoutInflater.from(ctx));
    }

    @Override
    public int getCount() {
        return categoryNameList.length;
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

        convertView = inflater.inflate(R.layout.explore_categories_list_items_layout, null);

        TextView title = convertView.findViewById(R.id.tv_ex_category_title);
        TextView count = convertView.findViewById(R.id.tv_ex_category_count);
        CardView cardView_ex_category = convertView.findViewById(R.id.cardView_ex_category);

        title.setText(categoryNameList[position]);
        count.setText(categoryPlacesCount[position] + " places");

        return convertView;
    }
}