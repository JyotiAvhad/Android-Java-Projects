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

public class DetailCategoriesGridItemAdapter extends RecyclerView.Adapter<DetailCategoriesGridItemAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<DetailCategoriesGridItemModel> detailCategoriesGridItemModels;

    public DetailCategoriesGridItemAdapter(Context ctx, ArrayList<DetailCategoriesGridItemModel> detailCategoriesGridItemModelArrayList) {

        inflater = LayoutInflater.from(ctx);
        this.detailCategoriesGridItemModels = detailCategoriesGridItemModelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.details_grid_categories_items_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.title.setText(detailCategoriesGridItemModels.get(position).getTitle());
        holder.subTitle.setText(detailCategoriesGridItemModels.get(position).getSubTitle());
//        holder.f_img.setImageResource(detailCategoriesGridItemModels.get(position).getFoodImg());
//        holder.f_rating.setRating(popularNearYouModelArrayList.get(position).getFoodRating());

//        holder.f_rating.setRating(Float.parseFloat("4.0"));

    }

    @Override
    public int getItemCount() {

        return detailCategoriesGridItemModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView subTitle;
        ImageView f_img;
        RatingBar f_rating;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_grid_title);
            subTitle = itemView.findViewById(R.id.tv_grid_sub_title);
//            f_type = itemView.findViewById(R.id.tv_grid_price);
//            f_img = itemView.findViewById(R.id.iv_food);
//            f_rating = itemView.findViewById(R.id.ratingBar);

        }
    }
}
