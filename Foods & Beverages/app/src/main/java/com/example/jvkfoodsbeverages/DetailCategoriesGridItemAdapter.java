package com.example.jvkfoodsbeverages;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

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
        holder.cv_addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = v.getContext();

                //Initializing a bottom sheet
                AddToCartBottomSheetDialog bottomSheetDialogFragment = new AddToCartBottomSheetDialog();
                //show it
                bottomSheetDialogFragment.show(((FragmentActivity) context).getSupportFragmentManager(), bottomSheetDialogFragment.getTag());

            }
        });

    }

    @Override
    public int getItemCount() {

        return detailCategoriesGridItemModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView subTitle;
        CardView cv_addToCart;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_grid_title);
            subTitle = itemView.findViewById(R.id.tv_grid_sub_title);
            cv_addToCart = itemView.findViewById(R.id.cardView_addToCart);

        }
    }
}
