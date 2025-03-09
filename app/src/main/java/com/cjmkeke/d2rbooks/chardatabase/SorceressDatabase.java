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
import com.cjmkeke.d2rbooks.adapter.character.AdapterSorceress;
import com.cjmkeke.d2rbooks.chardatabase.write.SorceressWrite;
import com.cjmkeke.d2rbooks.databinding.FragmentSorceressDatabaseBinding;
import com.cjmkeke.d2rbooks.model.Character;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SorceressDatabase extends Fragment {

    private static final String TAG = "SorceressDatabase";
    private FragmentSorceressDatabaseBinding binding;
    private RecyclerView recyclerView;
    private AdapterSorceress adapter;
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
        binding = FragmentSorceressDatabaseBinding.inflate(inflater, container, false);

        recyclerView = binding.getRoot().findViewById(R.id.recycler_view_sorceress); // 프레그먼트에서 사용
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        layoutManager.setItemPrefetchEnabled(false);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
        adapter = new AdapterSorceress(arrayList, getContext());
        recyclerView.setAdapter(adapter);

        binding.tvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        binding.tvSorceressWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SorceressWrite.class);
                intent.putExtra(TAG, TAG);
                startActivity(intent);
            }
        });



        return binding.getRoot();
    }
}