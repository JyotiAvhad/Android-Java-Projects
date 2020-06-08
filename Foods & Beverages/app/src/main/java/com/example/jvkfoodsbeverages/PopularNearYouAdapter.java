package com.example.jvkfoodsbeverages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PopularNearYouAdapter extends RecyclerView.Adapter<PopularNearYouAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<PopularNearYouModel> popularNearYouModelArrayList;

    public PopularNearYouAdapter(Context ctx, ArrayList<PopularNearYouModel> popularNearYouModelArrayList) {

        inflater = LayoutInflater.from(ctx);
        this.popularNearYouModelArrayList = popularNearYouModelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.popular_near_you_items_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.f_name.setText(popularNearYouModelArrayList.get(position).getFoodName());
        holder.f_type.setText(popularNearYouModelArrayList.get(position).getFoodType());
        holder.f_img.setImageResource(popularNearYouModelArrayList.get(position).getFoodImg());
//        holder.f_rating.setRating(popularNearYouModelArrayList.get(position).getFoodRating());

        holder.f_rating.setRating(Float.parseFloat("4.0"));

    }

    @Override
    public int getItemCount() {

        return popularNearYouModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView f_name;
        TextView f_type;
        ImageView f_img;
        RatingBar f_rating;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            f_name = itemView.findViewById(R.id.tv_fname);
            f_type = itemView.findViewById(R.id.tv_ftype);
            f_img = itemView.findViewById(R.id.iv_food);
            f_rating = itemView.findViewById(R.id.ratingBar);

        }
    }
}
