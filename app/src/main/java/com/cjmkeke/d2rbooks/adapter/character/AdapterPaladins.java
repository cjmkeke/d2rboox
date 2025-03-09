package com.cjmkeke.d2rbooks.adapter.character;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.model.Character;

import java.util.ArrayList;

public class AdapterPaladins extends RecyclerView.Adapter<AdapterPaladins.CustomViewHolder> {

    private ArrayList<Character> arrayList;
    private Context context;

    public AdapterPaladins(ArrayList<Character> arrayList, Context context) {
        this.context = context;
        this.arrayList = arrayList;
    }
    
    @NonNull
    @Override
    public AdapterPaladins.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_char, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPaladins.CustomViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
         private TextView itemName;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
             this.itemName = itemView.findViewById(R.id.tv_item_name_char);


        }
    }
}


