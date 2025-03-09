package com.cjmkeke.d2rbooks.adapter;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.dialog.UniqueItemShow;
import com.cjmkeke.d2rbooks.model.Unique;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AdapterUniqueItem extends RecyclerView.Adapter<AdapterUniqueItem.CustomViewHolder> {

    private ArrayList<Unique> arrayList;
    private Context mContext;
    private SharedPreferences fontSharedPreferences;
    private String currentFont;
    public static ArrayList<Unique> originalList;  // 전체 데이터를 보관할 리스트
    public static boolean isChanges;
    private int selectedItemLevel;
    private float fontSize = 0.7f;
    private static final String TAG = "AdapterUniqueItem";

    public AdapterUniqueItem(ArrayList<Unique> arrayList, Context context) {
        this.originalList = arrayList;
        this.arrayList = arrayList;
        this.mContext = context;

        // 폰트 설정 로직 초기화
        fontSharedPreferences = context.getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값: nanum
    }

    @NonNull
    @Override
    public AdapterUniqueItem.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_unique, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUniqueItem.CustomViewHolder holder, int position) {
        /** holder.testView.setOnClickListener **/

        if (isChanges) {
            String itemName = arrayList.get(position).getItem_name();

            // 아이템 이름에서 괄호의 시작과 끝 인덱스를 찾음
            int indexStart = itemName.indexOf("(");
            int indexEnd = itemName.indexOf(")");

            if (indexStart != -1 && indexEnd != -1 && indexEnd > indexStart) {
                // 괄호 전의 텍스트와 괄호 안의 텍스트 분리
                String beforeBracket = itemName.substring(0, indexStart).trim();
                String insideBracket = itemName.substring(indexStart, indexEnd + 1).trim();
                // 두 텍스트를 결합해 Spannable 형태로 만듦
                SpannableString spannable = new SpannableString(beforeBracket + " " + insideBracket);

                // 괄호 안의 텍스트에 폰트 크기 축소 적용
                spannable.setSpan(new RelativeSizeSpan(fontSize),
                        indexStart,
                        indexStart + insideBracket.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                // TextView에 적용
                holder.itemName.setText(spannable);
            } else {
                // 괄호가 없는 경우 기본 텍스트 설정
                holder.itemName.setText(itemName);
            }
        } else {
//            holder.itemName.setText(arrayList.get(position).getDrop_name());
            String itemName = arrayList.get(position).getDrop_name();

            // 아이템 이름에서 괄호의 시작과 끝 인덱스를 찾음
            int indexStart = itemName.indexOf("(");
            int indexEnd = itemName.indexOf(")");

            if (indexStart != -1 && indexEnd != -1 && indexEnd > indexStart) {
                // 괄호 전의 텍스트와 괄호 안의 텍스트 분리
                String beforeBracket = itemName.substring(0, indexStart).trim();
                String insideBracket = itemName.substring(indexStart, indexEnd + 1).trim();

                // 두 텍스트를 결합해 Spannable 형태로 만듦
                SpannableString spannable = new SpannableString(beforeBracket + " " + insideBracket);

                // 괄호 안의 텍스트에 폰트 크기 축소 적용
                spannable.setSpan(new RelativeSizeSpan(fontSize),
                        indexStart,
                        indexStart + insideBracket.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                // TextView에 적용
                holder.itemName.setText(spannable);
            } else {
                // 괄호가 없는 경우 기본 텍스트 설정
                holder.itemName.setText(itemName);
            }
        }

        holder.type.setText(arrayList.get(position).getType());

        holder.character.setVisibility(View.GONE);
        if (arrayList.get(position).getType().equals("성기사 전용")) {
            int id = mContext.getResources().getIdentifier("paladins", "drawable", mContext.getPackageName());
            holder.character.setVisibility(View.VISIBLE);
            holder.character.setBackgroundResource(id);
        }

        if (arrayList.get(position).getType().equals("드루이드 전용")) {
            int id = mContext.getResources().getIdentifier("druid", "drawable", mContext.getPackageName());
            holder.character.setVisibility(View.VISIBLE);
            holder.character.setBackgroundResource(id);
        }

        if (arrayList.get(position).getType().equals("원소술사 전용")) {
            int id = mContext.getResources().getIdentifier("sorceress", "drawable", mContext.getPackageName());
            holder.character.setVisibility(View.VISIBLE);
            holder.character.setBackgroundResource(id);
        }

        if (arrayList.get(position).getType().equals("야만용사 전용")) {
            int id = mContext.getResources().getIdentifier("barbarian", "drawable", mContext.getPackageName());
            holder.character.setVisibility(View.VISIBLE);
            holder.character.setBackgroundResource(id);
        }

        if (arrayList.get(position).getType().equals("암살자 전용")) {
            int id = mContext.getResources().getIdentifier("assassin", "drawable", mContext.getPackageName());
            holder.character.setVisibility(View.VISIBLE);
            holder.character.setBackgroundResource(id);
        }

        if (arrayList.get(position).getType().equals("아마존 전용")) {
            int id = mContext.getResources().getIdentifier("amazon", "drawable", mContext.getPackageName());
            holder.character.setVisibility(View.VISIBLE);
            holder.character.setBackgroundResource(id);
        }

        if (arrayList.get(position).getRating().trim().equals("노말")) {
            int id = mContext.getResources().getIdentifier("dw_normal","drawable",mContext.getPackageName());
            holder.rating.setBackgroundResource(id);
            holder.rating.setTextColor(Color.parseColor("#D4C491"));
            holder.rating.setText(arrayList.get(position).getRating());
        }

        if (arrayList.get(position).getRating().trim().equals("익셉셔널")) {
            int id = mContext.getResources().getIdentifier("dw_exceptional","drawable",mContext.getPackageName());
            holder.rating.setBackgroundResource(id);
            holder.rating.setTextColor(Color.parseColor("#D4C491"));
            holder.rating.setText(arrayList.get(position).getRating());
        }

        if (arrayList.get(position).getRating().trim().equals("엘리트")) {
            int id = mContext.getResources().getIdentifier("dw_elite","drawable",mContext.getPackageName());
            holder.rating.setBackgroundResource(id);
            holder.rating.setTextColor(Color.parseColor("#D4C491"));
            holder.rating.setText(arrayList.get(position).getRating());
        }


        if (arrayList.get(position).getRating().trim().equals("유니크")) {
            int id = mContext.getResources().getIdentifier("dw_elite","drawable",mContext.getPackageName());
            holder.rating.setBackgroundResource(id);
            holder.rating.setTextColor(Color.parseColor("#D4C491"));
            holder.rating.setText(arrayList.get(position).getRating());
        }


        applyFont(holder);

    }

    public void setSelectedItem(int a) {
        selectedItemLevel = a;
    }

    public void update(ArrayList<Unique> filterUnique, boolean isAllSelected) {
        if (isAllSelected) {
            // "전체"가 선택된 경우 originalList를 복원하고 정렬을 금지
            arrayList = new ArrayList<>(originalList);
        } else {
            // "전체"가 아닌 경우 필터링된 리스트에 대한 정렬 적용
            arrayList = filterUnique;

            // 레벨 기준에 따라 정렬
            Collections.sort(filterUnique, new Comparator<Unique>() {
                @Override
                public int compare(Unique o1, Unique o2) {
                    return o1.getItem_name().compareTo(o2.getItem_name());
                }
            });
        }

        notifyDataSetChanged();  // 데이터가 변경되었음을 알림
    }

    public void searchUpdate(String text, ArrayList<Unique> to) {
        ArrayList<Unique> filterUnique = new ArrayList<>();

        if (text.isEmpty()) {
            // 입력된 텍스트가 없을 경우 원래 리스트를 복원
            filterUnique.addAll(originalList);
        } else {
            // 입력된 텍스트를 소문자로 변환
            String searchText = text.toLowerCase();

            // 검색어가 포함된 아이템만 필터링하여 추가
            for (Unique item : to) {
                if (item.getItem_name().toLowerCase().contains(searchText)) {
                    filterUnique.add(item);
                }
            }

            for (Unique item : to) {
                if (item.getDrop_name().toLowerCase().contains(searchText)) {
                    filterUnique.add(item);
                }
            }
        }

        // 필터링된 리스트로 갱신
        arrayList = filterUnique;
        notifyDataSetChanged();  // 어댑터에 데이터 변경 알림
    }

    private void highValueResell(int position, String itemName, AdapterUniqueItem.CustomViewHolder holder) {
        if (arrayList.get(position).getItem_name().equals(itemName)) {
            holder.itemName.setTextColor(Color.parseColor("#BD880B"));
        }
    }

    private void highValueResell(int position, String itemName, String changeName, AdapterUniqueItem.CustomViewHolder holder) {
        if (arrayList.get(position).getItem_name().equals(itemName)) {
            holder.itemName.setText(changeName);
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

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView itemName;
        private TextView type;
        private TextView character;
        private TextView rating;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemName = itemView.findViewById(R.id.tv_item_name);
            this.type = itemView.findViewById(R.id.tv_item_type);
            this.character = itemView.findViewById(R.id.tv_char_unique);
            this.rating = itemView.findViewById(R.id.tv_item_rating);

            itemName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    String itemName = arrayList.get(pos).getItem_name();
                    String drop_name = arrayList.get(pos).getDrop_name();
                    String img = arrayList.get(pos).getImg();
                    String options = arrayList.get(pos).getOptions();
                    String type = arrayList.get(pos).getType();

                    Intent intent = new Intent(mContext, UniqueItemShow.class);
                    intent.putExtra("item_name", itemName);
                    intent.putExtra("drop_name", drop_name);
                    intent.putExtra("img", img);
                    intent.putExtra("options", options);
                    intent.putExtra("type", type);
                    intent.putExtra("index", pos);
                    mContext.startActivity(intent);
                }
            });

        }
    }


}

