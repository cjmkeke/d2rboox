package com.cjmkeke.d2rbooks.itemdatabase;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.adapter.AdapterUniqueItem;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentUniqueItemDatabaseBinding;
import com.cjmkeke.d2rbooks.model.Unique;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UniqueItemDatabase extends Fragment {

    private static final String TAG = "UniqueItemDatabase";
    private SharedPreferences fontSharedPreferences;
    private FragmentUniqueItemDatabaseBinding mBinding;

    private RecyclerView recyclerView;
    private AdapterUniqueItem adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Unique> arrayList;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private boolean isSwitched = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);

        mBinding = FragmentUniqueItemDatabaseBinding.inflate(inflater, container, false);

        recyclerView = mBinding.recyclerViewItemUnique.findViewById(R.id.recycler_view_item_unique); // 프레그먼트에서 사용
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        layoutManager.setItemPrefetchEnabled(false);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
        adapter = new AdapterUniqueItem(arrayList, getContext()); // 지금은 프레그먼트에서 사용, 엑티비티에서는 this
        recyclerView.setAdapter(adapter); // 어댑터 설정

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("item_data").child("unique");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Unique itemModels = dataSnapshot.getValue(Unique.class);
                    arrayList.add(itemModels);
                }
                adapter.notifyDataSetChanged();
                if (getContext() != null) {
                    applyFilter("전체보기"); // 데이터 로드 완료 후 필터 적용
                }
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

        mBinding.tvTitleChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSwitched = !isSwitched;
                adapter.isChanges = isSwitched;
                adapter.notifyDataSetChanged();
            }
        });

        String[] itemFilters = new String[]{"전체보기",
                "원드", "투척", "도검", "지팡이", "창", "셉터", "철퇴", "투창", "단도",
                "소뇌", "활", "도끼", "벨트", "부츠", "장갑", "방패", "갑옷", "투구",
                "성기사 전용", "드루이드 전용", "원소술사 전용", "야만용사 전용",
                "강령술사 전용", "암살자 전용", "아마존 전용", "써클릿", "주얼", "부적",
                "목걸이", "반지"
        };

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getContext(), R.layout.spinner_dropdown_item4, itemFilters);
        mBinding.uniqueSpinner.setAdapter(spinnerAdapter);

        // 초기 선택 처리
        applyFilter("전체보기"); // 기본 선택에 따라 초기 필터 적용

        // 스피너의 선택 리스너 설정
        mBinding.uniqueSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                applyFilter(selectedItem); // 선택된 아이템에 따라 필터 적용
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // 아무것도 선택되지 않은 경우 처리 (필요 시)
            }
        });


        return mBinding.getRoot();
    }

    private void applyFilter(String selectedItem) {
        boolean isAllSelected = false;
        ArrayList<Unique> filterArrayList = new ArrayList<>();

        if (selectedItem.equals("전체보기")) {
            filterArrayList.addAll(arrayList); // 전체 데이터를 추가
            isAllSelected = true;
        } else {
            // 필터링 매칭 데이터 정의
            Map<String, String> filterMap = new HashMap<>();
            filterMap.put("원드", "원드");
            filterMap.put("투척", "투척");
            filterMap.put("도검", "도검");
            filterMap.put("지팡이", "지팡이");
            filterMap.put("창", "창");
            filterMap.put("셉터", "셉터");
            filterMap.put("철퇴", "철퇴");
            filterMap.put("투창", "투창");
            filterMap.put("단도", "단도");
            filterMap.put("소뇌", "소뇌");
            filterMap.put("활", "활");
            filterMap.put("도끼", "도끼");
            filterMap.put("벨트", "벨트");
            filterMap.put("부츠", "부츠");
            filterMap.put("장갑", "장갑");
            filterMap.put("방패", "방패");
            filterMap.put("갑옷", "갑옷");
            filterMap.put("투구", "투구");
            filterMap.put("성기사 전용", "성기사");
            filterMap.put("드루이드 전용", "드루이드");
            filterMap.put("원소술사 전용", "원소술사");
            filterMap.put("야만용사 전용", "야만용사");
            filterMap.put("강령술사 전용", "강령술사");
            filterMap.put("암살자 전용", "암살자");
            filterMap.put("아마존 전용", "아마존");
            filterMap.put("써클릿", "써클릿");
            filterMap.put("주얼", "주얼");
            filterMap.put("부적", "부적");
            filterMap.put("목걸이", "목걸이");
            filterMap.put("반지", "반지");

            // 필터링 로직 적용
            String targetType = filterMap.get(selectedItem);
            if (targetType != null) {
                for (Unique unique : arrayList) {
                    if (targetType.equals(unique.getType())) {
                        filterArrayList.add(unique);
                    }
                }
            }
        }

        // 필터링된 데이터를 RecyclerView에 적용
        adapter.update(filterArrayList, isAllSelected);
        adapter.setSelectedItem(0); // 선택 상태 초기화
    }
}