package com.cjmkeke.d2rbooks.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cjmkeke.d2rbooks.model.HaveRune;
import com.cjmkeke.d2rbooks.R;

import java.util.ArrayList;

public class AdapterHaveRune extends RecyclerView.Adapter<AdapterHaveRune.CustomViewHolder> {

    private ArrayList<HaveRune> arrayList;
    private Context mContext;

    public AdapterHaveRune(ArrayList<HaveRune> arrayList, Context context) {
        this.arrayList = arrayList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public AdapterHaveRune.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_have_rune, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHaveRune.CustomViewHolder holder, int position) {
        /** holder.testView.setOnClickListener **/

        holder.runeItem.setText(arrayList.get(position).getName());
        holder.runeImage.setBackground(arrayList.get(position).getDw());
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        /** private TextView testView; **/
        private TextView runeItem;
        private ImageView runeImage;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.runeItem = itemView.findViewById(R.id.tv_rune);
            this.runeImage = itemView.findViewById(R.id.iv_rune);

        }
    }
}

