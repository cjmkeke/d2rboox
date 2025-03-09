package com.cjmkeke.d2rbooks.chardatabase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.adapter.character.AdapterAmazone;
import com.cjmkeke.d2rbooks.chardatabase.write.AmazoneWrite;
import com.cjmkeke.d2rbooks.databinding.FragmentAmazonDatabaseBinding;
import com.cjmkeke.d2rbooks.model.Character;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AmazonDatabase extends Fragment {

    private static final String TAG = "AmazonDatabase";
    private FragmentAmazonDatabaseBinding binding;
    private RecyclerView recyclerView;
    private AdapterAmazone adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Character> arrayList;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        requireActivity().getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAmazonDatabaseBinding.inflate(inflater, container, false);

        recyclerView = binding.getRoot().findViewById(R.id.recycler_view_amazon); // 프레그먼트에서 사용
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        layoutManager.setItemPrefetchEnabled(false);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
        adapter = new AdapterAmazone(arrayList, getContext());
        recyclerView.setAdapter(adapter);

        binding.tvAmazonWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AmazoneWrite.class);
                intent.putExtra(TAG, TAG);
                startActivity(intent);
            }
        });

        binding.tvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        Character character = new Character();
        character.setCharacterClass("매롱");
        character.setStrength("12030");

        arrayList.add(character);
        adapter.notifyDataSetChanged();

//        firebaseDatabase = FirebaseDatabase.getInstance();
//        databaseReference = firebaseDatabase.getReference("위치").child("위치");
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                arrayList.clear();
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                    Char item = dataSnapshot.getValue(Char.class);
//                    arrayList.add(item);
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        return binding.getRoot();
    }
}