package com.example.jvkfoodsbeverages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomSpinnerAdapter extends BaseAdapter {

    Context ctx;
    int flags[];
    String countryCode[];
    LayoutInflater inflater;

    public CustomSpinnerAdapter(Context applicationContext, int[] flags, String[] countryCode) {

        this.ctx=applicationContext;
        this.flags=flags;
        this.countryCode=countryCode;
        inflater=(LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return flags.length;
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

        convertView=inflater.inflate(R.layout.custom_spinner_items,null);

        ImageView icon=convertView.findViewById(R.id.iv_flag);
        TextView code=convertView.findViewById(R.id.tv_country_code);

        icon.setImageResource(flags[position]);
        code.setText(countryCode[position]);

        return convertView;
    }
}
