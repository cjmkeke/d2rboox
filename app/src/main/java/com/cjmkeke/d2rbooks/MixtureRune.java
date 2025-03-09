package com.cjmkeke.d2rbooks;

import android.content.SharedPreferences;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cjmkeke.d2rbooks.adapter.AdapterHaveRune;
import com.cjmkeke.d2rbooks.adapter.AdapterMixtureRune;
import com.cjmkeke.d2rbooks.constants.Rune;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivityMixtureRuneBinding;
import com.cjmkeke.d2rbooks.model.HaveRune;
import com.cjmkeke.d2rbooks.model.RuneWord;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MixtureRune extends AppCompatActivity {

    public class CustomItemDecoration extends RecyclerView.ItemDecoration {
        private final int[][] marginMatrix; // 마진값을 담는 배열
        private final int spanCount;

        public CustomItemDecoration(int[][] marginMatrix, int spanCount) {
            this.marginMatrix = marginMatrix;
            this.spanCount = spanCount;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // 현재 아이템의 위치
            int column = position % spanCount; // 열 계산
            int row = position / spanCount;   // 행 계산

            // 각 열과 행에 맞는 마진을 적용
            if (row < marginMatrix.length && column < marginMatrix[row].length) {
                int leftMargin = marginMatrix[row][column]; // 커스텀 마진 값
                outRect.left = leftMargin;  // 왼쪽 마진 적용
            }

            // 행 사이의 마진 적용
            if (row == 1) {
                outRect.top = 0;  // 1행과 2행 사이의 마진
            } else if (row == 2) {
                outRect.top = -5;  // 2행과 3행 사이의 마진
            } else if (row == 3) {
                outRect.top = -5;  // 3행과 4행 사이의 마진
            } else if (row == 4) {
                outRect.top = -5;   // 4행과 5행 사이의 마진
            } else {
                outRect.top = 0;   // 다른 행은 상단 마진 없음
            }

            // 하단 마진 (필요에 따라 조정 가능)
            outRect.bottom = 0;
        }

    }

    private final String TAG = "MixtureRune";
    private ActivityMixtureRuneBinding mrBinding;
    private RecyclerView recyclerView;
    private AdapterMixtureRune adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<RuneWord> arrayList;

    private RecyclerView haveRecyclerView;
    private AdapterHaveRune haveAdapter;
    private GridLayoutManager haveGidLayoutManager;
    private ArrayList<HaveRune> haveArrayList;
    private ArrayList<Boolean> filterArrayList;
    private final String SETTINGS_PROFILE = "Settings";
    private boolean isShowInventory;
    private SharedPreferences fontSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fontSharedPreferences = getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);

        mrBinding = ActivityMixtureRuneBinding.inflate(getLayoutInflater());
        setContentView(mrBinding.getRoot());

        SharedPreferences sharedPreferences = getSharedPreferences("app_settings_preferences", MODE_PRIVATE);

        // TODO 앱 셋팅부분
        SharedPreferences settingsApp = getSharedPreferences(SETTINGS_PROFILE, MODE_PRIVATE);
        SharedPreferences.Editor settingsEditor = settingsApp.edit();

        SharedPreferences elShared = getSharedPreferences(Rune.EL, MODE_PRIVATE);
        SharedPreferences eldShared = getSharedPreferences(Rune.ELD, MODE_PRIVATE);
        SharedPreferences tirShared = getSharedPreferences(Rune.TIR, MODE_PRIVATE);
        SharedPreferences nefShared = getSharedPreferences(Rune.NEF, MODE_PRIVATE);
        SharedPreferences ethShared = getSharedPreferences(Rune.ETH, MODE_PRIVATE);
        SharedPreferences ithShared = getSharedPreferences(Rune.ITH, MODE_PRIVATE);
        SharedPreferences talShared = getSharedPreferences(Rune.TAL, MODE_PRIVATE);
        SharedPreferences ralShared = getSharedPreferences(Rune.RAL, MODE_PRIVATE);
        SharedPreferences ortShared = getSharedPreferences(Rune.ORT, MODE_PRIVATE);
        SharedPreferences thulShared = getSharedPreferences(Rune.THUL, MODE_PRIVATE);
        SharedPreferences amnShared = getSharedPreferences(Rune.AMN, MODE_PRIVATE);
        SharedPreferences solShared = getSharedPreferences(Rune.SOL, MODE_PRIVATE);
        SharedPreferences shaelShared = getSharedPreferences(Rune.SHAEL, MODE_PRIVATE);
        SharedPreferences dolShared = getSharedPreferences(Rune.DOL, MODE_PRIVATE);
        SharedPreferences helShared = getSharedPreferences(Rune.HEL, MODE_PRIVATE);
        SharedPreferences ioShared = getSharedPreferences(Rune.IO, MODE_PRIVATE);
        SharedPreferences lumShared = getSharedPreferences(Rune.LUM, MODE_PRIVATE);
        SharedPreferences koShared = getSharedPreferences(Rune.KO, MODE_PRIVATE);
        SharedPreferences falShared = getSharedPreferences(Rune.FAL, MODE_PRIVATE);
        SharedPreferences lemShared = getSharedPreferences(Rune.LEM, MODE_PRIVATE);
        SharedPreferences pulShared = getSharedPreferences(Rune.PUL, MODE_PRIVATE);
        SharedPreferences umShared = getSharedPreferences(Rune.UM, MODE_PRIVATE);
        SharedPreferences malShared = getSharedPreferences(Rune.MAL, MODE_PRIVATE);
        SharedPreferences istShared = getSharedPreferences(Rune.IST, MODE_PRIVATE);
        SharedPreferences gulShared = getSharedPreferences(Rune.GUL, MODE_PRIVATE);
        SharedPreferences vexShared = getSharedPreferences(Rune.VEX, MODE_PRIVATE);
        SharedPreferences ohmShared = getSharedPreferences(Rune.OHM, MODE_PRIVATE);
        SharedPreferences loShared = getSharedPreferences(Rune.LO, MODE_PRIVATE);
        SharedPreferences surShared = getSharedPreferences(Rune.SUR, MODE_PRIVATE);
        SharedPreferences berShared = getSharedPreferences(Rune.BER, MODE_PRIVATE);
        SharedPreferences jahShared = getSharedPreferences(Rune.JAH, MODE_PRIVATE);
        SharedPreferences chamShared = getSharedPreferences(Rune.CHAM, MODE_PRIVATE);
        SharedPreferences zodShared = getSharedPreferences(Rune.ZOD, MODE_PRIVATE);

        int el = elShared.getInt(Rune.EL, 0);
        int eld = eldShared.getInt(Rune.ELD, 0);
        int tir = tirShared.getInt(Rune.TIR, 0);
        int nef = nefShared.getInt(Rune.NEF, 0);
        int eth = ethShared.getInt(Rune.ETH, 0);
        int ith = ithShared.getInt(Rune.ITH, 0);
        int tal = talShared.getInt(Rune.TAL, 0);
        int ral = ralShared.getInt(Rune.RAL, 0);
        int ort = ortShared.getInt(Rune.ORT, 0);
        int thul = thulShared.getInt(Rune.THUL, 0);
        int amn = amnShared.getInt(Rune.AMN, 0);
        int sol = solShared.getInt(Rune.SOL, 0);
        int shael = shaelShared.getInt(Rune.SHAEL, 0);
        int dol = dolShared.getInt(Rune.DOL, 0);
        int hel = helShared.getInt(Rune.HEL, 0);
        int io = ioShared.getInt(Rune.IO, 0);
        int lum = lumShared.getInt(Rune.LUM, 0);
        int ko = koShared.getInt(Rune.KO, 0);
        int fal = falShared.getInt(Rune.FAL, 0);
        int lem = lemShared.getInt(Rune.LEM, 0);
        int pul = pulShared.getInt(Rune.PUL, 0);
        int um = umShared.getInt(Rune.UM, 0);
        int mal = malShared.getInt(Rune.MAL, 0);
        int ist = istShared.getInt(Rune.IST, 0);
        int gul = gulShared.getInt(Rune.GUL, 0);
        int vex = vexShared.getInt(Rune.VEX, 0);
        int ohm = ohmShared.getInt(Rune.OHM, 0);
        int lo = loShared.getInt(Rune.LO, 0);
        int sur = surShared.getInt(Rune.SUR, 0);
        int ber = berShared.getInt(Rune.BER, 0);
        int jah = jahShared.getInt(Rune.JAH, 0);
        int cham = chamShared.getInt(Rune.CHAM, 0);
        int zod = zodShared.getInt(Rune.ZOD, 0);


        recyclerView = findViewById(R.id.recycler_view); // 메인 엑티비티에서 사용
        layoutManager = new LinearLayoutManager(this); // 메인 엑티비티에서 사용
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(0); // RecyclerView 캐시 비활성화
        layoutManager.setItemPrefetchEnabled(false);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
        adapter = new AdapterMixtureRune(arrayList, this); // 지금은 프레그먼트에서 사용, 엑티비티에서는 this
        recyclerView.setAdapter(adapter);

        haveRecyclerView = findViewById(R.id.have_rune_recyclerview); // 메인 엑티비티에서 사용
        haveGidLayoutManager = new GridLayoutManager(this, 7); // 그리드 열 개수 7로 설정
        haveRecyclerView.setHasFixedSize(true);
        haveGidLayoutManager.setItemPrefetchEnabled(false);
        haveRecyclerView.setLayoutManager(haveGidLayoutManager);
        haveArrayList = new ArrayList<>();
        haveAdapter = new AdapterHaveRune(haveArrayList, this); // 지금은 프레그먼트에서 사용, 엑티비티에서는 this
        haveRecyclerView.setAdapter(haveAdapter);

        // 1~5행, 1~7열에 대해 각 셀마다의 커스텀 마진값을 정의
        int[][] customMargins = {
                {15, 15, 13, 10, 8, 0, 0},   // 1번 행 (1~7열)
                {15, 15, 13, 10, 8, 0, 0},    // 2번 행
                {15, 15, 13, 10, 8, 0, 0},   // 3번 행
                {15, 15, 13, 10, 8, 0, 0},   // 4번 행
                {15, 15, 13, 10, 8, 0, 0},   // 5번 행
        };

        haveRecyclerView.addItemDecoration(new CustomItemDecoration(customMargins, 7)); // 7은 그리드의 열 개수

        // TODO 소유하고 있는 룬 정보
        if (el >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.el);
            haveArrayList.add(new HaveRune("EL", drawable));
        }

        if (eld >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.eld);
            haveArrayList.add(new HaveRune("ELD", drawable));
        }

        if (tir >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.tir);
            haveArrayList.add(new HaveRune("TIR", drawable));
        }

        if (nef >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.nef);
            haveArrayList.add(new HaveRune("NEF", drawable));
        }

        if (eth >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.eth);
            haveArrayList.add(new HaveRune("ETH", drawable));
        }

        if (ith >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.ith);
            haveArrayList.add(new HaveRune("ITH", drawable));
        }

        if (tal >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.tal);
            haveArrayList.add(new HaveRune("TAL", drawable));
        }

        if (ral >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.ral);
            haveArrayList.add(new HaveRune("RAL", drawable));
        }

        if (ort >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.ort);
            haveArrayList.add(new HaveRune("ORT", drawable));
        }

        if (thul >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.thul);
            haveArrayList.add(new HaveRune("THUL", drawable));
        }

        if (amn >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.amn);
            haveArrayList.add(new HaveRune("AMN", drawable));
        }

        if (sol >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.sol);
            haveArrayList.add(new HaveRune("SOL", drawable));
        }

        if (shael >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.shael);
            haveArrayList.add(new HaveRune("SHAEL", drawable));
        }

        if (dol >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.dol);
            haveArrayList.add(new HaveRune("DOL", drawable));
        }

        if (hel >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.hel);
            haveArrayList.add(new HaveRune("HEL", drawable));
        }

        if (io >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.io);
            haveArrayList.add(new HaveRune("IO", drawable));
        }

        if (lum >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.lum);
            haveArrayList.add(new HaveRune("LUM", drawable));
        }

        if (ko >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.ko);
            haveArrayList.add(new HaveRune("KO", drawable));
        }

        if (fal >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.fal);
            haveArrayList.add(new HaveRune("FAL", drawable));
        }

        if (lem >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.lem);
            haveArrayList.add(new HaveRune("LEM", drawable));
        }

        if (pul >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.pul);
            haveArrayList.add(new HaveRune("PUL", drawable));
        }

        if (um >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.um);
            haveArrayList.add(new HaveRune("UM", drawable));
        }

        if (mal >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.mal);
            haveArrayList.add(new HaveRune("MAL", drawable));
        }

        if (ist >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.ist);
            haveArrayList.add(new HaveRune("IST", drawable));
        }

        if (gul >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.gul);
            haveArrayList.add(new HaveRune("GUL", drawable));
        }

        if (vex >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.vex);
            haveArrayList.add(new HaveRune("VEX", drawable));
        }

        if (ohm >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.ohm);
            haveArrayList.add(new HaveRune("OHM", drawable));
        }

        if (lo >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.lo);
            haveArrayList.add(new HaveRune("LO", drawable));
        }

        if (sur >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.sur);
            haveArrayList.add(new HaveRune("SUR", drawable));
        }

        if (ber >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.ber);
            haveArrayList.add(new HaveRune("BER", drawable));
        }

        if (jah >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.jah);
            haveArrayList.add(new HaveRune("JAH", drawable));
        }

        if (cham >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.cham);
            haveArrayList.add(new HaveRune("CHAM", drawable));
        }

        if (zod >= 1) {
            Drawable drawable = ContextCompat.getDrawable(MixtureRune.this, R.drawable.zod);
            haveArrayList.add(new HaveRune("ZOD", drawable));
        }

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();
        databaseReference.child("runeword").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();

                for (DataSnapshot snap : snapshot.getChildren()) {
                    RuneWord runeWord = snap.getValue(RuneWord.class);
                    arrayList.add(runeWord);
                }

                adapter = new AdapterMixtureRune(arrayList, MixtureRune.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        // 드롭다운 기능
        String[] characterLists = new String[]{"보유중인 룬워드로 만들수 있는 전체 룬워드", "보유중인 룬워드로 만들수 있는 아마존 룬워드", "보유중인 룬워드로 만들수 있는 암살자 룬워드",
                "보유중인 룬워드로 만들수 있는 강령술사 룬워드", "보유중인 룬워드로 만들수 있는 야만용사 룬워드", "보유중인 룬워드로 만들수 있는 성기사 룬워드", "보유중인 룬워드로 만들수 있는 원소술사 룬워드",
                "보유중인 룬워드로 만들수 있는 드루이드 룬워드", "보유중인 룬워드로 만들수 있는 용병 룬워드", "보유중인 룬워드로 만들수 있는 초반 룬워드",
                "보유중인 룬워드로 만들수 있는 졸업 룬워드", "보유중인 룬워드로 만들수 있는 범용 룬워드", "보유중인 룬워드로 만들수 있는 래더전용 룬워드", "착용 레벨"};
        mrBinding.spinner.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_dropdown_item, characterLists));
        mrBinding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                boolean isAllSelected = false; // 전체가 선택되었는지 확인

                ArrayList<RuneWord> filterArrayList = new ArrayList<>();
                if (selectedItem.equals("보유중인 룬워드로 만들수 있는 전체 룬워드")) {
                    filterArrayList.addAll(arrayList); // 전체 데이터를 보여줌
                    adapter.setSelectedItem(0);
                    isAllSelected = true;
                } else {
                    for (RuneWord runeWord : arrayList) {
                        // 각 캐릭터에 맞는 RuneWord 필터링
                        switch (selectedItem) {
                            case "보유중인 룬워드로 만들수 있는 아마존 룬워드":
                                if (runeWord.isAmazon()) {
                                    filterArrayList.add(runeWord);
                                    adapter.setSelectedItem(0);
                                }
                                break;
                            case "보유중인 룬워드로 만들수 있는 암살자 룬워드":
                                if (runeWord.isAssassin()) {
                                    filterArrayList.add(runeWord);
                                    adapter.setSelectedItem(0);
                                }
                                break;
                            case "보유중인 룬워드로 만들수 있는 강령술사 룬워드":
                                if (runeWord.isNecromancer()) {
                                    filterArrayList.add(runeWord);
                                    adapter.setSelectedItem(0);
                                }
                                break;
                            case "보유중인 룬워드로 만들수 있는 야만용사 룬워드":
                                if (runeWord.isBarbarian()) {
                                    filterArrayList.add(runeWord);
                                    adapter.setSelectedItem(0);
                                }
                                break;
                            case "보유중인 룬워드로 만들수 있는 성기사 룬워드":
                                if (runeWord.isPaladins()) {
                                    filterArrayList.add(runeWord);
                                    adapter.setSelectedItem(0);
                                }
                                break;
                            case "보유중인 룬워드로 만들수 있는 원소술사 룬워드":
                                if (runeWord.isSorceress()) {
                                    filterArrayList.add(runeWord);
                                    adapter.setSelectedItem(0);
                                }
                                break;
                            case "보유중인 룬워드로 만들수 있는 드루이드 룬워드":
                                if (runeWord.isDruid()) {
                                    filterArrayList.add(runeWord);
                                    adapter.setSelectedItem(0);
                                }
                                break;
                            case "보유중인 룬워드로 만들수 있는 용병 룬워드":
                                if (runeWord.isMercenary()) {
                                    filterArrayList.add(runeWord);
                                    adapter.setSelectedItem(0);
                                }
                                break;
                            case "보유중인 룬워드로 만들수 있는 초반 룬워드":
                                if (runeWord.isEarly()) {
                                    filterArrayList.add(runeWord);
                                    adapter.setSelectedItem(0);
                                }
                                break;
                            case "보유중인 룬워드로 만들수 있는 졸업 룬워드":
                                if (runeWord.isSpecialItem()) {
                                    filterArrayList.add(runeWord);
                                    adapter.setSelectedItem(0);
                                }
                                break;
                            case "보유중인 룬워드로 만들수 있는 범용 룬워드":
                                if (runeWord.isAll()) {
                                    filterArrayList.add(runeWord);
                                    adapter.setSelectedItem(0);
                                }
                                break;
                            case "보유중인 룬워드로 만들수 있는 래더전용 룬워드":
                                if (runeWord.isLadder()) {
                                    filterArrayList.add(runeWord);
                                    adapter.setSelectedItem(0);
                                }
                                break;
                            case "착용 레벨":
                                if (runeWord.getLevel() > 0) {
                                    filterArrayList.add(runeWord);
                                    int a = runeWord.getLevel();
                                    adapter.setSelectedItem(a);
                                }
                                break;
                        }

                    }

                }
                // RecyclerView 어댑터에 필터링된 데이터 적용
                adapter.update(filterArrayList, isAllSelected);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // 기본 동작
            }
        });


        mrBinding.etSearch.addTextChangedListener(new TextWatcher() {
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

        // TODO 보유중인 룬 창 열고 닫기 리스너
        isShowInventory = settingsApp.getBoolean("inventory", true);

        // 초기에 isShowInventory 상태에 따라 UI 설정
        if (isShowInventory) {
            mrBinding.tvOpenSwitchRune.setText("현재 보유중인 룬 닫기");
            mrBinding.llRecycler.setVisibility(View.VISIBLE);
        } else {
            mrBinding.tvOpenSwitchRune.setText("현재 보유중인 룬 열기");
            mrBinding.llRecycler.setVisibility(View.GONE);
        }

        // 클릭 리스너 설정
        mrBinding.tvOpenSwitchRune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // isShowInventory가 true일 경우 닫기 동작
                if (isShowInventory) {
                    mrBinding.tvOpenSwitchRune.setText("현재 보유중인 룬 열기");
                    mrBinding.llRecycler.setVisibility(View.GONE);
                } else {
                    // false일 경우 열기 동작
                    mrBinding.tvOpenSwitchRune.setText("현재 보유중인 룬 닫기");
                    mrBinding.llRecycler.setVisibility(View.VISIBLE);
                }
                // 상태 변경 후 SharedPreferences에 저장
                isShowInventory = !isShowInventory;
                settingsEditor.putBoolean("inventory", isShowInventory);
                settingsEditor.apply();
            }
        });


    }
}