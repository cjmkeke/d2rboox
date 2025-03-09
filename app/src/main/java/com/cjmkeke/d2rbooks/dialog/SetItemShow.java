package com.cjmkeke.d2rbooks.dialog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.adapter.AdapterSetItemList;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivitySetItemShowBinding;
import com.cjmkeke.d2rbooks.model.SetItem;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SetItemShow extends AppCompatActivity {

    private static final String TAG = "SetItemShow";
    private ActivitySetItemShowBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    private Intent intent;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;

    private String itemName;
    private String position;
    private String set_item_name;
    private String set_item_finished_effect;
    private String set_item_list;
    private String set_item_partial_effect;

    private RecyclerView recyclerView;
    private AdapterSetItemList adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<SetItem> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fontSharedPreferences = getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);

        mBinding = ActivitySetItemShowBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        recyclerView = mBinding.recyclerViewItemSetList.findViewById(R.id.recycler_view_item_set_list); // 프레그먼트에서 사용
        layoutManager = new LinearLayoutManager(this); // 메인 엑티비티에서 사용
        recyclerView.setHasFixedSize(true);
        layoutManager.setItemPrefetchEnabled(false);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
        adapter = new AdapterSetItemList(arrayList, this); // 지금은 프레그먼트에서 사용, 엑티비티에서는 this
        recyclerView.setAdapter(adapter); // 어댑터 설정

        intent = getIntent();
        itemName = intent.getStringExtra("set_item_name");
        position = intent.getStringExtra("position");
        set_item_name = intent.getStringExtra("set_item_name");
        set_item_finished_effect = intent.getStringExtra("set_item_finished_effect");
        set_item_list = intent.getStringExtra("set_item_list");
        set_item_partial_effect = intent.getStringExtra("set_item_partial_effect");

        mBinding.tvItemName.setText(set_item_name);
        mBinding.etItemOptionsPartialEffect.setText(set_item_partial_effect);
        mBinding.etItemOptionsFinisedEffect.setText(set_item_finished_effect);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser != null){
            if ("cjmkeke@gmail.com".equals(firebaseUser.getEmail())){
                mBinding.etItemOptionsFinisedEffect.setEnabled(true);
                mBinding.etItemOptionsPartialEffect.setEnabled(true);
            } else {
                mBinding.etItemOptionsFinisedEffect.setEnabled(false);
                mBinding.etItemOptionsPartialEffect.setEnabled(false);
            }
        } else {
            mBinding.etItemOptionsFinisedEffect.setEnabled(false);
            mBinding.etItemOptionsPartialEffect.setEnabled(false);
            Log.w(TAG, "firebaseUser가 null 상태입니다.");
        }

        databaseReference.child("item_data").child("set_item_list").child(position).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    SetItem user = snapshot.getValue(SetItem.class);
                    arrayList.add(user);
                }
                adapter.notifyDataSetChanged(); // 데이터 변경 후 notifyDataSetChanged() 호출
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // 에러 처리
            }
        });
    }
}