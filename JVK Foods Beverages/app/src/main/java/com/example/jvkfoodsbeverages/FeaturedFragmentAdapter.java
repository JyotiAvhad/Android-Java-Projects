package com.example.jvkfoodsbeverages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FeaturedFragmentAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_popular_near_you_items_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((MyViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return FeaturedFragmentModel.myImageNameList.length;
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView ff_name;
        TextView ff_type;
        ImageView ff_img;
        RatingBar ff_ratings;

        public MyViewHolder (@NonNull View itemView) {
            super(itemView);

            ff_name = itemView.findViewById(R.id.tv_ff_name);
            ff_type = itemView.findViewById(R.id.tv_ff_type);
            ff_img = itemView.findViewById(R.id.iv_ff_food);
            ff_ratings = itemView.findViewById(R.id.ratingBar_ff);

            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            ff_name.setText( FeaturedFragmentModel.myImageNameList[position]);
            ff_type.setText( FeaturedFragmentModel.myImageTypeList[position]);
            ff_img.setImageResource(FeaturedFragmentModel.myImageList[position]);
            ff_ratings.setRating(Float.parseFloat("3.0"));
        }

        @Override
        public void onClick(View v) {


        }
    }
}

