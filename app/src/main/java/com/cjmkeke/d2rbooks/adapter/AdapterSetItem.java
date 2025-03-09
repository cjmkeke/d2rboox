package com.cjmkeke.d2rbooks.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.dialog.SetItemShow;
import com.cjmkeke.d2rbooks.dialog.SetItemShowIndividual;
import com.cjmkeke.d2rbooks.model.SetItem;

import java.util.ArrayList;

public class AdapterSetItem extends RecyclerView.Adapter<AdapterSetItem.CustomViewHolder> {

    private ArrayList<SetItem> arrayList;
    private Context mContext;
    private boolean isUpdate = false;
    private ArrayList<SetItem> newFilterItems = new ArrayList<>();

    public AdapterSetItem(ArrayList<SetItem> arrayList, Context context) {
        this.arrayList = arrayList;
        this.mContext = context;

    }

    @NonNull
    @Override
    public AdapterSetItem.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_set_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSetItem.CustomViewHolder holder, int position) {
        if (isUpdate && position < newFilterItems.size()) {
            holder.itemName.setText(newFilterItems.get(position).getItem_name());
        } else {
            holder.itemName.setText(arrayList.get(position).getSet_item_name());
        }
    }

    @Override
    public int getItemCount() {
        return isUpdate ? newFilterItems.size() : arrayList.size();
    }

    public void setUpdate(ArrayList<SetItem> arrayList) {
        newFilterItems = arrayList;
        isUpdate = true;
        notifyDataSetChanged();
    }

    public void resetUpdate() {
        isUpdate = false;
        notifyDataSetChanged();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        /**
         * private TextView testView;
         **/
        private TextView itemName;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            /** this.testView = itemView.findViewById(R.id.testViewId); **/
            this.itemName = itemView.findViewById(R.id.tv_item_name);

            itemName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Intent intent;
                        if (!isUpdate) {
                            intent = new Intent(mContext, SetItemShow.class);
                            intent.putExtra("position", String.valueOf(position));
                            intent.putExtra("set_item_name", arrayList.get(position).getSet_item_name());
                            intent.putExtra("set_item_finished_effect", arrayList.get(position).getSet_item_finished_effect());
                            intent.putExtra("set_item_list", arrayList.get(position).getSet_item_list());
                            intent.putExtra("set_item_partial_effect", arrayList.get(position).getSet_item_partial_effect());
                        } else {
                            intent = new Intent(mContext, SetItemShowIndividual.class);
                            intent.putExtra("position", String.valueOf(position));
                            intent.putExtra("item_name", newFilterItems.get(position).getItem_name());
                            intent.putExtra("set_item_partial_effect", newFilterItems.get(position).getSet_item_finished_effect());
                            intent.putExtra("options1", newFilterItems.get(position).getOption1());
                            intent.putExtra("options2", newFilterItems.get(position).getOption2());  // 수정된 부분
                            intent.putExtra("set_name", newFilterItems.get(position).getSet_name());
                            intent.putExtra("type", newFilterItems.get(position).getType());
                            intent.putExtra("img", newFilterItems.get(position).getImg());
                        }
                        mContext.startActivity(intent);
                    }
                }
            });


        }
    }
}

