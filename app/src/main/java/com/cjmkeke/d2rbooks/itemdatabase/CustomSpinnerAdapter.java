package com.cjmkeke.d2rbooks.itemdatabase;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjmkeke.d2rbooks.R;

public class CustomSpinnerAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] items;
    private int[] images; // 이미지 리소스 ID 배열

    public CustomSpinnerAdapter(Context context, String[] items, int[] images) {
        super(context, 0, items);
        this.context = context;
        this.items = items;
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return createView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return createView(position, convertView, parent);
    }

    private View createView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner_item_with_image, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.spinner_image);
        TextView textView = convertView.findViewById(R.id.spinner_text);

        imageView.setImageResource(images[position]); // 이미지 설정
        textView.setText(items[position]); // 텍스트 설정

        // "힛파워 장갑" 아이템의 글자 색상을 빨간색으로 설정
        if (items[position].equals("힛파워 장갑")) {
            textView.setTextColor(Color.RED);
        } else if (items[position].equals("캐스터 벨트")) {
            textView.setTextColor(Color.RED);
        } else if (items[position].equals("캐스터 아뮬렛")) {
            textView.setTextColor(Color.RED);
        } else {
            textView.setTextColor(Color.parseColor("#D4C491")); // 기본 색상
        }

        return convertView;
    }
}
