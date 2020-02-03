package com.example.foodies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BreakfastRecyclerViewAdapter extends RecyclerView.Adapter<BreakfastRecyclerViewAdapter.MyViewHolder> {

    private BreakfastTabFragment mContext ;
    private List<BreakfastItem> mData ;


//    public BreakfastRecyclerViewAdapter(Context mContext, List<BreakfastItem> mData) {
//        this.mContext = mContext;
//        this.mData = mData;
//    }

    public BreakfastRecyclerViewAdapter(BreakfastTabFragment breakfastTabFragment, List<BreakfastItem> lstBreakfastItem) {
        this.mContext = breakfastTabFragment;
        this.mData = lstBreakfastItem;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        view = mInflater.inflate(R.layout.item_recycler_caterogy,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.itemName.setText(mData.get(position).getItemName());
        holder.itemImage.setImageResource(mData.get(position).getImage());
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(mContext,Book_Activity.class);
//
//                // passing data to the book activity
//                intent.putExtra("Title",mData.get(position).getTitle());
//                intent.putExtra("Description",mData.get(position).getDescription());
//                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
//                // start the activity
//                mContext.startActivity(intent);
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        ImageView itemImage;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            itemName = (TextView) itemView.findViewById(R.id.iv_imageName) ;
            itemImage = (ImageView) itemView.findViewById(R.id.iv_image);
            cardView = (CardView) itemView.findViewById(R.id.recyclerItem_cardview);


        }
    }


}