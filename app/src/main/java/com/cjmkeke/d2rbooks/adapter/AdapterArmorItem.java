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
import com.cjmkeke.d2rbooks.dialog.ArmorItemShow;
import com.cjmkeke.d2rbooks.model.ItemModels;

import java.util.ArrayList;
public class AdapterArmorItem extends RecyclerView.Adapter<AdapterArmorItem.CustomViewHolder> {

    private ArrayList<ItemModels> arrayList;
    private Context mContext;
    private SharedPreferences fontSharedPreferences;
    private String currentFont;
    public static ArrayList<ItemModels> originalList;  // 전체 데이터를 보관할 리스트

    public AdapterArmorItem(ArrayList<ItemModels> arrayList, Context context) {
        this.originalList = arrayList;
        this.arrayList = arrayList;
        this.mContext = context;

        // 폰트 설정 로직 초기화
        fontSharedPreferences = context.getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값: nanum
    }

    @NonNull
    @Override
    public AdapterArmorItem.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_checked_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterArmorItem.CustomViewHolder holder, int position) {
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

        holder.itemName.setTextColor(Color.parseColor("#D4C491"));
        highValueResell(position, "메이지 플레이트", holder);
        highValueResell(position, "더스크 슈라우드", holder);
        highValueResell(position, "아콘 플레이트", holder);
        highValueResell(position, "와이어 플리스", holder);
        highValueResell(position, "세이크리드 아머", holder);
        applyFont(holder);

    }

    public void searchUpdate(String text, ArrayList<ItemModels> to) {
        ArrayList<ItemModels> filterItemModels = new ArrayList<>();

        if (text.isEmpty()) {
            // 입력된 텍스트가 없을 경우 원래 리스트를 복원
            filterItemModels.addAll(originalList);
        } else {
            // 입력된 텍스트를 소문자로 변환
            String searchText = text.toLowerCase();

            // 검색어가 포함된 아이템만 필터링하여 추가
            for (ItemModels item : to) {
                if (item.getItem_name().toLowerCase().contains(searchText)) {
                    filterItemModels.add(item);
                }
            }
        }

        // 필터링된 리스트로 갱신
        arrayList = filterItemModels;
        notifyDataSetChanged();  // 어댑터에 데이터 변경 알림
    }


    private void highValueResell(int position, String itemName, AdapterArmorItem.CustomViewHolder holder){
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

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemName = itemView.findViewById(R.id.tv_item_name);
            this.type = itemView.findViewById(R.id.tv_item_type);

            itemName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    String itemName = arrayList.get(pos).getItem_name();
                    String defense = arrayList.get(pos).getDefense();
                    String rating = arrayList.get(pos).getRating();
                    String character = arrayList.get(pos).getCharacter();
                    String comment = arrayList.get(pos).getComment();
                    String src = arrayList.get(pos).getSrc();
                    String position = arrayList.get(pos).getIndex();
                    String soket = arrayList.get(pos).getSoket();

                    Intent intent = new Intent(mContext, ArmorItemShow.class);
                    intent.putExtra("item_name", itemName);
                    intent.putExtra("defense", defense);
                    intent.putExtra("rating", rating);
                    intent.putExtra("soket", soket);
                    intent.putExtra("character", character);
                    intent.putExtra("position", position);
                    intent.putExtra("comment", comment);
                    intent.putExtra("src", src);
                    mContext.startActivity(intent);
                }
            });

        }
    }
}

