package adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.neostore.R;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import activity.ProductDetailedActivity;
import activity.ProductTableActivity;
import model.TablesData;


public class TablesPrdListAdapter extends RecyclerView.Adapter<TablesPrdListAdapter.TablesViewHolder>{

    public List<TablesData> tablesDataList;
    Activity context;

    public class TablesViewHolder extends RecyclerView.ViewHolder {

        public ImageView img;
        public TextView name;
        public TextView type;
        public TextView price;
        public RatingBar rating;

        public TablesViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.iv_product_img);
            name = itemView.findViewById(R.id.tv_product_name);
            type = itemView.findViewById(R.id.tv_product_type);
            price = itemView.findViewById(R.id.tv_product_price);
            rating = itemView.findViewById(R.id.ratingBar);
        }
    }

    public TablesPrdListAdapter(List<TablesData> tablesData, Activity context) {

        tablesDataList = tablesData;
        this.context = context;
    }

    @NonNull
    @Override
    public TablesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_product_list, parent, false);
        TablesViewHolder tablesViewHolder = new TablesViewHolder(view);
        return tablesViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull TablesViewHolder holder, int position) {

        final TablesData currentItem = tablesDataList.get(position);
        Glide.with(context).load(currentItem.getProduct_images()).into(holder.img);

        holder.name.setText(currentItem.getName());
        holder.type.setText(currentItem.getProducer());
        holder.price.setText("Rs. " + format(currentItem.getCost()));
        holder.rating.setRating(currentItem.getRating());

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(context, ProductDetailedActivity.class);
            intent.putExtra("id", currentItem.getId());
            context.startActivity(intent);
        });
    }

    private String format(String cost) {

        int number = Integer.valueOf(cost);
        return NumberFormat.getNumberInstance(new Locale("en", "in")).format(number);
    }

    @Override
    public int getItemCount() {

        return tablesDataList.size();
    }

}