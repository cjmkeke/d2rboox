package com.cjmkeke.d2rbooks.adapter;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.dialog.PriceShow;
import com.cjmkeke.d2rbooks.model.Price;

import java.util.ArrayList;

public class AdapterPrice extends RecyclerView.Adapter<AdapterPrice.CustomViewHolder> {

    private static final String TAG = "AdapterPrice";
    private ArrayList<Price> arrayList;
    private Context context;
    
    public AdapterPrice(ArrayList<Price> arrayList, Context context) {
        this.context = context;
        this.arrayList = arrayList;
    }
    
    @NonNull
    @Override
    public AdapterPrice.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_price, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPrice.CustomViewHolder holder, int position) {
        holder.runeName.setText(arrayList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
         private TextView runeName;
         private LinearLayout mainLayout;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
             this.runeName = itemView.findViewById(R.id.tv_price_rune_name);
             this.mainLayout = itemView.findViewById(R.id.ll_main_view);

             mainLayout.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     int pos = getAdapterPosition();
                     Intent intent = new Intent(context, PriceShow.class);
                     intent.putExtra("key", arrayList.get(pos).getKey());
                     intent.putExtra("date", arrayList.get(pos).getDate());
                     Log.w(TAG, arrayList.get(pos).getKey());
                     Log.w(TAG, arrayList.get(pos).getDate());
                     context.startActivity(intent);
                 }
             });

        }
    }
}


