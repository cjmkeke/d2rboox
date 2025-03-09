package com.cjmkeke.d2rbooks.itemdatabase;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.adapter.AdapterSetItem;
import com.cjmkeke.d2rbooks.databinding.FragmentSetItemDatabaseBinding;
import com.cjmkeke.d2rbooks.model.SetItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SetItemDatabase extends Fragment {

    private FragmentSetItemDatabaseBinding mBinding;
    private RecyclerView recyclerView;
    private AdapterSetItem adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<SetItem> arrayList;
    private ArrayList<SetItem> individualList = new ArrayList<>();
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private DatabaseReference databaseReference1;
    private boolean isCheckedButton = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentSetItemDatabaseBinding.inflate(inflater, container, false);

        recyclerView = mBinding.recyclerViewItemSet.findViewById(R.id.recycler_view_item_set);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
        adapter = new AdapterSetItem(arrayList, getContext());
        recyclerView.setAdapter(adapter);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("item_data").child("set");
        databaseReference1 = firebaseDatabase.getReference();

        // 초기 데이터 로드
        loadOriginalItemList();

        mBinding.tvTitleChangeSet.setOnClickListener(v -> {
            if (isCheckedButton) {
                loadIndividualItemList();
                isCheckedButton = false;
            } else {
                loadOriginalItemList();
                isCheckedButton = true;
            }
        });

        return mBinding.getRoot();
    }


    private void loadOriginalItemList() {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    SetItem user = snapshot.getValue(SetItem.class);
                    arrayList.add(user);
                }
                adapter.resetUpdate();  // 원래 데이터로 돌아가도록 업데이트 초기화
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("SetItemDatabase", "Failed to load original items.", error.toException());
            }
        });
    }

    private void loadIndividualItemList() {
        databaseReference1.child("item_data").child("set_item_list_Individual").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    SetItem setItem = dataSnapshot.getValue(SetItem.class);
                    individualList.add(setItem);
                }
                adapter.setUpdate(individualList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("SetItemDatabase", "Failed to load individual items.", error.toException());
            }
        });
    }



}
