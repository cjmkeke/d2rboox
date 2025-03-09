package com.cjmkeke.d2rbooks.adapter;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.dialog.HelmItemShow;
import com.cjmkeke.d2rbooks.model.ItemModels;

import java.util.ArrayList;

public class AdapterHelmItem extends RecyclerView.Adapter<AdapterHelmItem.CustomViewHolder> {

    private ArrayList<ItemModels> arrayList;
    private Context mContext;
    private SharedPreferences fontSharedPreferences;
    private String currentFont;

    public AdapterHelmItem(ArrayList<ItemModels> arrayList, Context context) {
        this.arrayList = arrayList;
        this.mContext = context;

        // 폰트 설정 로직 초기화
        fontSharedPreferences = context.getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값: nanum
    }

    @NonNull
    @Override
    public AdapterHelmItem.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_checked_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHelmItem.CustomViewHolder holder, int position) {
        /** holder.testView.setOnClickListener **/

        holder.itemName.setText(arrayList.get(position).getItem_name());

        if (arrayList.get(position).getRating().trim().equals("노말")){
            holder.type.setText("NOMAL");
            holder.type.setTextColor(Color.parseColor("#1E88E5"));
        }

        if (arrayList.get(position).getRating().trim().equals("익셉셔널")){
            holder.type.setText("EXCEPTIONAL");
            holder.type.setTextColor(Color.parseColor("#BD880B"));
        }

        if (arrayList.get(position).getRating().trim().equals("고급")){
            holder.type.setText("ELITE");
            holder.type.setTextColor(Color.parseColor("#F4511E"));
        }

        if (arrayList.get(position).getRating().trim().equals("써클릿")){
            holder.type.setText("써클릿");
            holder.type.setTextColor(Color.parseColor("#6E6EFF")); // 파란색
        }


        holder.character.setVisibility(View.GONE);
        if (arrayList.get(position).getCharacter().trim().equals("드루이드")){
            holder.character.setVisibility(View.VISIBLE);
            int id = mContext.getResources().getIdentifier("druid", "drawable", mContext.getPackageName());
            holder.character.setBackgroundResource(id);
        }

        if (arrayList.get(position).getCharacter().trim().equals("야만용사")){
            holder.character.setVisibility(View.VISIBLE);
            int id = mContext.getResources().getIdentifier("barbarian", "drawable", mContext.getPackageName());
            holder.character.setBackgroundResource(id);
        }

        holder.itemName.setTextColor(Color.parseColor("#D4C491"));
        applyFont(holder);
    }

    private void highValueResell(int position, String itemName, AdapterHelmItem.CustomViewHolder holder){
        if (arrayList.get(position).getItem_name().equals(itemName)){
            holder.itemName.setTextColor(Color.parseColor("#BD880B"));
        }
    }

    private void applyFont(CustomViewHolder holder) {
        if ("kodia".equals(currentFont)) {
            holder.itemName.setTypeface(mContext.getResources().getFont(R.font.kodia));
            holder.type.setTypeface(mContext.getResources().getFont(R.font.kodia));
        } else {
            holder.itemName.setTypeface(mContext.getResources().getFont(R.font.nanumlight));
            holder.type.setTypeface(mContext.getResources().getFont(R.font.nanumlight));
        }
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView itemName;
        private TextView type;
        private TextView character;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemName = itemView.findViewById(R.id.tv_item_name);
            this.type = itemView.findViewById(R.id.tv_item_type);
            this.character = itemView.findViewById(R.id.tv_char);

            itemName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    String itemName = arrayList.get(pos).getItem_name();
                    String defense = arrayList.get(pos).getDefense();
                    String rating = arrayList.get(pos).getRating();
                    String src = arrayList.get(pos).getSrc();
                    String comment = arrayList.get(pos).getComment();
                    String position = arrayList.get(pos).getIndex();
                    String soket = arrayList.get(pos).getSoket();

                    Intent intent = new Intent(mContext, HelmItemShow.class);
                    intent.putExtra("item_name", itemName);
                    intent.putExtra("defense", defense);
                    intent.putExtra("rating", rating);
                    intent.putExtra("soket", soket);
                    intent.putExtra("src", src);
                    intent.putExtra("position", position);
                    intent.putExtra("comment", comment);
                    mContext.startActivity(intent);
                }
            });

        }
    }
}

