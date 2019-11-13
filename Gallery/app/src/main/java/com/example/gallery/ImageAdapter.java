package com.example.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public int[] imageArray = {
            R.drawable.img_a,
            R.drawable.img_b,
            R.drawable.img_c,
            R.drawable.img_d,
            R.drawable.img_e,
            R.drawable.img_f,
            R.drawable.img_g,
            R.drawable.img_h,
            R.drawable.img_i,
            R.drawable.img_j,
            R.drawable.img_k,
            R.drawable.img_l,
            R.drawable.img_m,
            R.drawable.img_n,
            R.drawable.img_o,
            R.drawable.img_p,
            R.drawable.img_q,
            R.drawable.img_r,
            R.drawable.img_s,
            R.drawable.img_t,
            R.drawable.img_u,
            R.drawable.img_v,
            R.drawable.img_w,
            R.drawable.img_x,
            R.drawable.img_y,
            R.drawable.img_z
    };

    public ImageAdapter(Context context){
        this.mContext=context;
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int position) {
        return imageArray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView=new ImageView(mContext);
        imageView.setImageResource(imageArray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(350,350));

        return imageView;
    }
}
