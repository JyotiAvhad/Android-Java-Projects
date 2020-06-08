package com.example.jvkfoodsbeverages;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExploreCategoriesAdapter extends RecyclerView.Adapter<ExploreCategoriesAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<ExploreCategoriesModel> exploreCategoriesModelArrayList;

    public ExploreCategoriesAdapter(Context ctx, ArrayList<ExploreCategoriesModel> exploreCategoriesModelArrayList) {

        inflater = LayoutInflater.from(ctx);
        this.exploreCategoriesModelArrayList = exploreCategoriesModelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.explore_categories_items_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull  MyViewHolder holder, int position) {

        holder.c_name.setText(exploreCategoriesModelArrayList.get(position).getCatName());
        holder.p_count.setText(exploreCategoriesModelArrayList.get(position).getCatPlacesCount());
//        holder.cv_bg.setCardBackgroundColor(exploreCategoriesModelArrayList.get(position).getCatBGColor());

//        holder.cv_bg.setCardBackgroundColor(exploreCategoriesModelArrayList.get(position).getCatBGColor());

        //for random card view color
//        holder.cv_bg.setBackgroundColor(new Random().nextInt());


    }

    @Override
    public int getItemCount() {

        return exploreCategoriesModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView c_name;
        TextView p_count;
        CardView cv_bg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            c_name = itemView.findViewById(R.id.tv_category_title);
            p_count = itemView.findViewById(R.id.tv_category_count);
            cv_bg = itemView.findViewById(R.id.cardView_category);

        }
    }
}
