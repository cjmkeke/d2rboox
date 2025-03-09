package com.cjmkeke.d2rbooks.itemdatabase;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.adapter.AdapterArmorItem;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentArmorItemDatabaseBinding;
import com.cjmkeke.d2rbooks.model.ItemModels;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ArmorItemDatabase extends Fragment {

    private FragmentArmorItemDatabaseBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    private RecyclerView recyclerView;
    private AdapterArmorItem adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ItemModels> arrayList;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentArmorItemDatabaseBinding.inflate(inflater, container, false);

        recyclerView = mBinding.recyclerViewItem.findViewById(R.id.recycler_view_item); // 프레그먼트에서 사용
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        layoutManager.setItemPrefetchEnabled(false);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
        adapter = new AdapterArmorItem(arrayList, getContext()); // 지금은 프레그먼트에서 사용, 엑티비티에서는 this
        recyclerView.setAdapter(adapter); // 어댑터 설정

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("item_data").child("armor");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ItemModels itemModels = dataSnapshot.getValue(ItemModels.class);
                    arrayList.add(itemModels);
                }
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mBinding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.searchUpdate(s.toString(), arrayList);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return mBinding.getRoot();
    }
}