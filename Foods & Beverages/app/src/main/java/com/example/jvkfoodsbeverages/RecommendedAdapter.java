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

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<RecommendedModel> recommendedModelArrayList;

    public RecommendedAdapter(Context ctx, ArrayList<RecommendedModel> recommendedModels) {

        inflater = LayoutInflater.from(ctx);
        this.recommendedModelArrayList = recommendedModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recommended_items_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.r_name.setText(recommendedModelArrayList.get(position).getrName());
        holder.r_type.setText(recommendedModelArrayList.get(position).getrType());
        holder.r_img.setImageResource(recommendedModelArrayList.get(position).getrImg());
//        holder.f_rating.setRating(popularNearYouModelArrayList.get(position).getFoodRating());

        holder.r_rating.setRating(Float.parseFloat("4.0"));

    }

    @Override
    public int getItemCount() {

        return recommendedModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView r_name;
        TextView r_type;
        ImageView r_img;
        RatingBar r_rating;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            r_name = itemView.findViewById(R.id.tv_rname);
            r_type = itemView.findViewById(R.id.tv_rtype);
            r_img = itemView.findViewById(R.id.iv_rfood);
            r_rating = itemView.findViewById(R.id.ratingBar_recom);

        }
    }
}
