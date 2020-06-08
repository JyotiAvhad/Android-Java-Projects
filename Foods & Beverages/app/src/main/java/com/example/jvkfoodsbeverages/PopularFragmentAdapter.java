package com.example.jvkfoodsbeverages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PopularFragmentAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_popular_near_you_items_layout,parent,false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return PopularFragmentModel.title.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView;
        private ImageView imageView;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_itemText);
            imageView = itemView.findViewById(R.id.iv_itemImage);

            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            textView.setText( PopularFragmentModel.title[position]);
            imageView.setImageResource(PopularFragmentModel.picpath[position]);
        }

        @Override
        public void onClick(View v) {


        }
    }
}

