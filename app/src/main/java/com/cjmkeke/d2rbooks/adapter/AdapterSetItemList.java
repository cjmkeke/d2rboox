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
import com.cjmkeke.d2rbooks.dialog.SetItemShowIndividual;
import com.cjmkeke.d2rbooks.model.SetItem;

import java.util.ArrayList;

public class AdapterSetItemList extends RecyclerView.Adapter<AdapterSetItemList.CustomViewHolder> {

    private ArrayList<SetItem> arrayList;
    private Context mContext;

    public AdapterSetItemList(ArrayList<SetItem> arrayList, Context context) {
        this.arrayList = arrayList;
        this.mContext = context;

    }

    @NonNull
    @Override
    public AdapterSetItemList.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_set_item_list, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSetItemList.CustomViewHolder holder, int position) {
        /** holder.testView.setOnClickListener **/

        holder.itemName.setText(arrayList.get(position).getItem_name());

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        /** private TextView testView; **/
        private TextView itemName;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            /** this.testView = itemView.findViewById(R.id.testViewId); **/
            this.itemName = itemView.findViewById(R.id.tv_item_name);

            itemName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(mContext, SetItemShowIndividual.class);
                    intent.putExtra("item_name", arrayList.get(getAdapterPosition()).getItem_name());
                    intent.putExtra("set_item_partial_effect", arrayList.get(getAdapterPosition()).getSet_item_partial_effect());
                    intent.putExtra("options", arrayList.get(getAdapterPosition()).getOption());
                    intent.putExtra("options1", arrayList.get(getAdapterPosition()).getOption1());
                    intent.putExtra("options2", arrayList.get(getAdapterPosition()).getOption2());
                    intent.putExtra("set_name", arrayList.get(getAdapterPosition()).getSet_item_name());
                    intent.putExtra("type", arrayList.get(getAdapterPosition()).getType());
                    intent.putExtra("img", arrayList.get(getAdapterPosition()).getImg());
                    mContext.startActivity(intent);

                }
            });

        }
    }
}

