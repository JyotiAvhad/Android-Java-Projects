package com.example.jvkfoodsbeverages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VoucherDiscountAdapter extends RecyclerView.Adapter<VoucherDiscountAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<VoucherDiscountModel> voucherDiscountModels;

    public VoucherDiscountAdapter(Context ctx, ArrayList<VoucherDiscountModel> voucherDiscountModels) {

        inflater = LayoutInflater.from(ctx);
        this.voucherDiscountModels = voucherDiscountModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.voucher_discount_items_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.iv_vd.setImageResource(voucherDiscountModels.get(position).getVdImg());

    }

    @Override
    public int getItemCount() {

        return voucherDiscountModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView iv_vd;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_vd = itemView.findViewById(R.id.iv_voucher_discount);

        }
    }
}
