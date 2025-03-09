package com.cjmkeke.d2rbooks.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cjmkeke.d2rbooks.ModifyRuneWord;
import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.Rune;
import com.cjmkeke.d2rbooks.dialog.ShowRuneWordDialog;
import com.cjmkeke.d2rbooks.model.RuneWord;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AdapterMixtureRune extends RecyclerView.Adapter<AdapterMixtureRune.CustomViewHolder> {

    private ArrayList<RuneWord> arrayList;
    public static ArrayList<RuneWord> originalList;  // 전체 데이터를 보관할 리스트
    private Context mContext;
    private int selectedItemLevel;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    public AdapterMixtureRune(ArrayList<RuneWord> arrayList, Context context) {
        this.originalList = new ArrayList<>(arrayList);  // 초기 데이터 저장
        this.arrayList = arrayList;
        this.mContext = context;
    }

    public void setSelectedItem(int a) {
        selectedItemLevel = a;
    }

    public void update(ArrayList<RuneWord> filterRuneWord, boolean isAllSelected) {
        if (isAllSelected) {
            // "전체"가 선택된 경우 originalList를 복원하고 정렬을 금지
            arrayList = new ArrayList<>(originalList);
        } else {
            // "전체"가 아닌 경우 필터링된 리스트에 대한 정렬 적용
            arrayList = filterRuneWord;

            // 레벨 기준에 따라 정렬
            Collections.sort(filterRuneWord, new Comparator<RuneWord>() {
                @Override
                public int compare(RuneWord o1, RuneWord o2) {
                    // 레벨이 0보다 작으면 이름(가나다순)으로 정렬
                    if (o1.getLevel() < 0 && o2.getLevel() < 0) {
                        return o1.getItemName().compareTo(o2.getItemName());
                    }
                    // 레벨이 0보다 크면 레벨로 정렬
                    else if (o1.getLevel() > 0 && o2.getLevel() > 0) {
                        return Integer.compare(o1.getLevel(), o2.getLevel());
                    }
                    // 그 외의 경우: 음수와 양수 레벨이 섞여 있을 때 적절한 비교 로직
                    return Integer.compare(o1.getLevel(), o2.getLevel());
                }
            });
        }

        notifyDataSetChanged();  // 데이터가 변경되었음을 알림
    }

    public void searchUpdate(String text, ArrayList<RuneWord> to) {
        ArrayList<RuneWord> filterRuneWord = new ArrayList<>();

        if (text.isEmpty()) {
            // 텍스트가 없을 때 원래 리스트를 다시 보여줌
            filterRuneWord.addAll(originalList);
        } else {
            String searchText = text.toLowerCase();  // 소문자로 변환
            for (RuneWord runeWord : to) {
                // 소문자로 변환 후 검색
                if (runeWord.getItemName().toLowerCase().contains(searchText)) {
                    filterRuneWord.add(runeWord);
                }
            }
        }

        arrayList = filterRuneWord;  // 필터된 리스트 또는 전체 리스트로 업데이트
        notifyDataSetChanged();  // 데이터 변경 알림
    }

    @NonNull
    @Override
    public AdapterMixtureRune.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_checked_runeword, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMixtureRune.CustomViewHolder holder, int position) {
        /** holder.testView.setOnClickListener **/

        SharedPreferences elShared = mContext.getSharedPreferences(Rune.EL, mContext.MODE_PRIVATE);
        SharedPreferences eldShared = mContext.getSharedPreferences(Rune.ELD, mContext.MODE_PRIVATE);
        SharedPreferences tirShared = mContext.getSharedPreferences(Rune.TIR, mContext.MODE_PRIVATE);
        SharedPreferences nefShared = mContext.getSharedPreferences(Rune.NEF, mContext.MODE_PRIVATE);
        SharedPreferences ethShared = mContext.getSharedPreferences(Rune.ETH, mContext.MODE_PRIVATE);
        SharedPreferences ithShared = mContext.getSharedPreferences(Rune.ITH, mContext.MODE_PRIVATE);
        SharedPreferences talShared = mContext.getSharedPreferences(Rune.TAL, mContext.MODE_PRIVATE);
        SharedPreferences ralShared = mContext.getSharedPreferences(Rune.RAL, mContext.MODE_PRIVATE);
        SharedPreferences ortShared = mContext.getSharedPreferences(Rune.ORT, mContext.MODE_PRIVATE);
        SharedPreferences thulShared = mContext.getSharedPreferences(Rune.THUL, mContext.MODE_PRIVATE);
        SharedPreferences amnShared = mContext.getSharedPreferences(Rune.AMN, mContext.MODE_PRIVATE);
        SharedPreferences solShared = mContext.getSharedPreferences(Rune.SOL, mContext.MODE_PRIVATE);
        SharedPreferences shaelShared = mContext.getSharedPreferences(Rune.SHAEL, mContext.MODE_PRIVATE);
        SharedPreferences dolShared = mContext.getSharedPreferences(Rune.DOL, mContext.MODE_PRIVATE);
        SharedPreferences helShared = mContext.getSharedPreferences(Rune.HEL, mContext.MODE_PRIVATE);
        SharedPreferences ioShared = mContext.getSharedPreferences(Rune.IO, mContext.MODE_PRIVATE);
        SharedPreferences lumShared = mContext.getSharedPreferences(Rune.LUM, mContext.MODE_PRIVATE);
        SharedPreferences koShared = mContext.getSharedPreferences(Rune.KO, mContext.MODE_PRIVATE);
        SharedPreferences falShared = mContext.getSharedPreferences(Rune.FAL, mContext.MODE_PRIVATE);
        SharedPreferences lemShared = mContext.getSharedPreferences(Rune.LEM, mContext.MODE_PRIVATE);
        SharedPreferences pulShared = mContext.getSharedPreferences(Rune.PUL, mContext.MODE_PRIVATE);
        SharedPreferences umShared = mContext.getSharedPreferences(Rune.UM, mContext.MODE_PRIVATE);
        SharedPreferences malShared = mContext.getSharedPreferences(Rune.MAL, mContext.MODE_PRIVATE);
        SharedPreferences istShared = mContext.getSharedPreferences(Rune.IST, mContext.MODE_PRIVATE);
        SharedPreferences gulShared = mContext.getSharedPreferences(Rune.GUL, mContext.MODE_PRIVATE);
        SharedPreferences vexShared = mContext.getSharedPreferences(Rune.VEX, mContext.MODE_PRIVATE);
        SharedPreferences ohmShared = mContext.getSharedPreferences(Rune.OHM, mContext.MODE_PRIVATE);
        SharedPreferences loShared = mContext.getSharedPreferences(Rune.LO, mContext.MODE_PRIVATE);
        SharedPreferences surShared = mContext.getSharedPreferences(Rune.SUR, mContext.MODE_PRIVATE);
        SharedPreferences berShared = mContext.getSharedPreferences(Rune.BER, mContext.MODE_PRIVATE);
        SharedPreferences jahShared = mContext.getSharedPreferences(Rune.JAH, mContext.MODE_PRIVATE);
        SharedPreferences chamShared = mContext.getSharedPreferences(Rune.CHAM, mContext.MODE_PRIVATE);
        SharedPreferences zodShared = mContext.getSharedPreferences(Rune.ZOD, mContext.MODE_PRIVATE);

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

        // 각 룬의 값을 로그로 출력
        holder.mainView.setVisibility(View.GONE);

        // TODO if 문 시작
        if (shael >= 1 && eth >= 1) {
            if (arrayList.get(position).getItemName().equals("각운")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (tir >= 1 && el >= 1) {
            if (arrayList.get(position).getItemName().equals("강철")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (amn >= 1 && tir >= 1) {
            if (arrayList.get(position).getItemName().equals("강함")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (ral >= 1 && ort >= 1 && tal >= 1) {
            if (arrayList.get(position).getItemName().equals("고대인의 서약")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (eth >= 1 && lum >= 1) {
            if (arrayList.get(position).getItemName().equals("광채")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (nef >= 1 && sol >= 1 && ith >= 1) {
            if (arrayList.get(position).getItemName().equals("광휘")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (nef >= 1 && tir >= 1) {
            if (arrayList.get(position).getItemName().equals("구렁텅이")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (tal >= 1 && ort >= 1 && thul >= 1) {
            if (arrayList.get(position).getItemName().equals("귀감")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (hel >= 1 && ko >= 1 && lem >= 1 && gul >= 1) {
            if (arrayList.get(position).getItemName().equals("균열")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (cham >= 1 && sur >= 1 && io >= 1 && lo >= 1) {
            if (arrayList.get(position).getItemName().equals("긍지")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (fal >= 1 && ohm >= 1 && ort >= 1 && jah >= 1) {
            if (arrayList.get(position).getItemName().equals("기근")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (lum >= 1 && io >= 1 && sol >= 1 && eth >= 1) {
            if (arrayList.get(position).getItemName().equals("기억")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (pul >= 1 && ral >= 1 && sol >= 1) {
            if (arrayList.get(position).getItemName().equals("깨우침")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (nef >= 1 && pul >= 1 && vex >= 1) {
            if (arrayList.get(position).getItemName().equals("꺼져가는 불길")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (io >= 1 && jah >= 1 && pul >= 1) {
            if (arrayList.get(position).getItemName().equals("꿈")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (jah >= 1 && lo >= 1 && mal >= 1 && gul >= 1) {
            if (arrayList.get(position).getItemName().equals("낙인")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (shael >= 1 && io >= 1 && ral >= 1) {
            if (arrayList.get(position).getItemName().equals("담금질")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (shael >= 1 && um >= 1 && pul >= 1 && lum >= 1) {
            if (arrayList.get(position).getItemName().equals("돌")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (jah >= 3 && mal >= 1 && sur >= 1 && ber >= 1) {
            if (arrayList.get(position).getItemName().equals("마지막 소원")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (tal >= 1 && dol >= 1 && mal >= 1) {
            if (arrayList.get(position).getItemName().equals("맹독")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (amn >= 1 && el >= 1 && ith >= 1 && tir >= 1 && sol >= 1) {
            if (arrayList.get(position).getItemName().equals("명예")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (dol >= 1 && ohm >= 1 && ber >= 1 && ist >= 1) {
            if (arrayList.get(position).getItemName().equals("명예의 굴레")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (tir >= 1 && tal >= 1 && amn >= 1) {
            if (arrayList.get(position).getItemName().equals("모서리")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (mal >= 1 && gul >= 1 && amn >= 1) {
            if (arrayList.get(position).getItemName().equals("모자이크")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (ber >= 2 && mal >= 1 && ist >= 1) {
            if (arrayList.get(position).getItemName().equals("무한")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (sur >= 1 && el >= 1) {
            if (arrayList.get(position).getItemName().equals("바람")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (shael >= 1 && io >= 1 && sol >= 1) {
            if (arrayList.get(position).getItemName().equals("방책방벽")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (shael >= 1 && thul >= 1 && lem >= 1) {
            if (arrayList.get(position).getItemName().equals("배신")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (lem >= 1 && ko >= 1 && tir >= 1) {
            if (arrayList.get(position).getItemName().equals("부")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (jah >= 1 && gul >= 1 && eth >= 1) {
            if (arrayList.get(position).getItemName().equals("분노")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (fal >= 1 && io >= 1 && ith >= 1 && el >= 1 && eld >= 1 && hel >= 1) {
            if (arrayList.get(position).getItemName().equals("불굴의 의지")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (vex >= 2 && lo >= 1 && jah >= 1) {
            if (arrayList.get(position).getItemName().equals("불사조 무기")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (vex >= 2 && lo >= 1 && jah >= 1) {
            if (arrayList.get(position).getItemName().equals("불사조 방패")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (ort >= 1 && mal >= 1 && ith >= 1) {
            if (arrayList.get(position).getItemName().equals("비")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (sol >= 1 && um >= 2) {
            if (arrayList.get(position).getItemName().equals("뼈")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (shael >= 1 && pul >= 1 && mal >= 1 && lum >= 1) {
            if (arrayList.get(position).getItemName().equals("서약")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (ort >= 1 && eth >= 1) {
            if (arrayList.get(position).getItemName().equals("서풍")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (shael >= 1 && ko >= 1 && nef >= 1) {
            if (arrayList.get(position).getItemName().equals("선율")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (ko >= 2 && mal >= 1) {
            if (arrayList.get(position).getItemName().equals("성역")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (amn >= 1 && ral >= 1 && mal >= 1 && ist >= 1 && ohm >= 1) {
            if (arrayList.get(position).getItemName().equals("소집")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (jah >= 1 && ith >= 1 && ber >= 1) {
            if (arrayList.get(position).getItemName().equals("수수께끼")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (dol >= 1 && io >= 1) {
            if (arrayList.get(position).getItemName().equals("순백")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (hel >= 1 && ko >= 1 && thul >= 1 && fal >= 1 && eth >= 1) {
            if (arrayList.get(position).getItemName().equals("순종")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (eth >= 1 && tir >= 1 && lo >= 1 && mal >= 1 && ral >= 1) {
            if (arrayList.get(position).getItemName().equals("슬픔")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (ohm >= 1 && jah >= 1 && lem >= 1 && eld >= 1) {
            if (arrayList.get(position).getItemName().equals("신념")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (eth >= 1 && ral >= 1 && ort >= 1 && tal >= 1) {
            if (arrayList.get(position).getItemName().equals("신성한 천둥")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (mal >= 1 && tir >= 1) {
            if (arrayList.get(position).getItemName().equals("신중")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (hel >= 1 && amn >= 1 && nef >= 1) {
            if (arrayList.get(position).getItemName().equals("신화")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (ith >= 1 && el >= 1 && eth >= 1) {
            if (arrayList.get(position).getItemName().equals("악의")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (cham >= 1 && shael >= 1 && gul >= 1 && thul >= 1 && ith >= 1) {
            if (arrayList.get(position).getItemName().equals("안개")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (ber >= 1 && tir >= 1 && um >= 1 && mal >= 1 && lum >= 1) {
            if (arrayList.get(position).getItemName().equals("야수")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (thul >= 1 && io >= 1 && nef >= 1) {
            if (arrayList.get(position).getItemName().equals("어둠")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (fal >= 1 && um >= 1 && pul >= 1) {
            if (arrayList.get(position).getItemName().equals("어스름")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (amn >= 1 && shael >= 1 && jah >= 1 && lo >= 1) {
            if (arrayList.get(position).getItemName().equals("얼음")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (cham >= 1 && shael >= 1 && um >= 1) {
            if (arrayList.get(position).getItemName().equals("역병")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (nef >= 1 && lum >= 1) {
            if (arrayList.get(position).getItemName().equals("연기")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (dol >= 1 && ort >= 1 && eld >= 1 && lem >= 1) {
            if (arrayList.get(position).getItemName().equals("열정")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (amn >= 1 && ber >= 1 && ist >= 1 && sol >= 1 && sur >= 1) {
            if (arrayList.get(position).getItemName().equals("영원")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (tal >= 1 && thul >= 1 && ort >= 1 && amn >= 1) {
            if (arrayList.get(position).getItemName().equals("영혼 무기")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (tal >= 1 && thul >= 1 && ort >= 1 && amn >= 1) {
            if (arrayList.get(position).getItemName().equals("영혼 방패")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (mal >= 1 && um >= 1 && gul >= 1 && fal >= 1) {
            if (arrayList.get(position).getItemName().equals("왕 시해자")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (amn >= 1 && ral >= 1 && thul >= 1) {
            if (arrayList.get(position).getItemName().equals("왕의 은총")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (sur >= 1 && lo >= 1 && sol >= 1) {
            if (arrayList.get(position).getItemName().equals("용")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (hel >= 1 && lum >= 1 && fal >= 1) {
            if (arrayList.get(position).getItemName().equals("용맹")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (ral >= 1 && gul >= 1 && eld >= 1) {
            if (arrayList.get(position).getItemName().equals("원칙")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (lem >= 1 && ko >= 1 && el >= 1 && eld >= 1) {
            if (arrayList.get(position).getItemName().equals("이유있는 항변")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (el >= 1 && sol >= 1 && dol >= 1 && lo >= 1) {
            if (arrayList.get(position).getItemName().equals("인내 무기")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (el >= 1 && sol >= 1 && dol >= 1 && lo >= 1) {
            if (arrayList.get(position).getItemName().equals("인내 아머")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (tir >= 1 && ral >= 1) {
            if (arrayList.get(position).getItemName().equals("잎새")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (tal >= 1 && eth >= 1) {
            if (arrayList.get(position).getItemName().equals("잠행")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (ort >= 1 && sol >= 1) {
            if (arrayList.get(position).getItemName().equals("전승")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (shael >= 1 && io >= 1 && ort >= 1) {
            if (arrayList.get(position).getItemName().equals("접지")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (sur >= 1 && cham >= 1 && amn >= 1 && lo >= 1) {
            if (arrayList.get(position).getItemName().equals("정의의 손길")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (tir >= 1 && ith >= 1 && sol >= 1 && ko >= 1) {
            if (arrayList.get(position).getItemName().equals("조화")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (vex >= 1 && hel >= 1 && el >= 1 && eld >= 1 && zod >= 1 && eth >= 1) {
            if (arrayList.get(position).getItemName().equals("죽어가는 자의 숨결")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (hel >= 1 && el >= 1 && vex >= 1 && ort >= 1 && gul >= 1) {
            if (arrayList.get(position).getItemName().equals("죽음")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (pul >= 1 && ith >= 1 && eld >= 1) {
            if (arrayList.get(position).getItemName().equals("지혜")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (pul >= 1 && lum >= 1 && ber >= 1 && mal >= 1) {
            if (arrayList.get(position).getItemName().equals("진노")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (zod >= 1 && ist >= 1 && lem >= 1 && lum >= 1 && io >= 1 && nef >= 1) {
            if (arrayList.get(position).getItemName().equals("집착")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (amn >= 1 && lem >= 1 && ko >= 1) {
            if (arrayList.get(position).getItemName().equals("집행자")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (ral >= 1 && ohm >= 1 && sur >= 1 && eth >= 1) {
            if (arrayList.get(position).getItemName().equals("찔레")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (lem >= 1 && ist >= 1 && io >= 1) {
            if (arrayList.get(position).getItemName().equals("착란")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (ko >= 1 && vex >= 1 && pul >= 1 && thul >= 1) {
            if (arrayList.get(position).getItemName().equals("참나무의 심장")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (shael >= 1 && um >= 1 && tir >= 1) {
            if (arrayList.get(position).getItemName().equals("초승달")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (vex >= 1 && ohm >= 1 && ist >= 1 && dol >= 1) {
            if (arrayList.get(position).getItemName().equals("추방")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (shael >= 1 && io >= 1 && tal >= 1) {
            if (arrayList.get(position).getItemName().equals("치료")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (dol >= 1 && eld >= 1 && hel >= 1 && ist >= 1 && tir >= 1 && vex >= 1) {
            if (arrayList.get(position).getItemName().equals("침묵")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (io >= 1 && cham >= 1 && fal >= 1) {
            if (arrayList.get(position).getItemName().equals("탈태")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (ral >= 1 && tir >= 1 && tal >= 1 && sol >= 1) {
            if (arrayList.get(position).getItemName().equals("통찰")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (shael >= 1 && ko >= 1 && eld >= 1) {
            if (arrayList.get(position).getItemName().equals("투지 무기")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (shael >= 1 && ko >= 1 && eld >= 1) {
            if (arrayList.get(position).getItemName().equals("투지 갑옷")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (vex >= 1 && lo >= 1 && ber >= 1 && jah >= 1 && ko >= 1) {
            if (arrayList.get(position).getItemName().equals("파괴")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (hel >= 1 && ohm >= 1 && um >= 1 && lo >= 1 && cham >= 1) {
            if (arrayList.get(position).getItemName().equals("파멸")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (shael >= 1 && um >= 1 && thul >= 1) {
            if (arrayList.get(position).getItemName().equals("평화")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (shael >= 1 && um >= 1 && thul >= 1) {
            if (arrayList.get(position).getItemName().equals("협박")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (fal >= 1 && ohm >= 1 && um >= 1) {
            if (arrayList.get(position).getItemName().equals("혼돈")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (shael >= 1 && io >= 1 && thul >= 1) {
            if (arrayList.get(position).getItemName().equals("화로")) {
                holder.mainView.setVisibility(View.VISIBLE);
                holder.runeItem.setText(arrayList.get(position).getItemName());
            }
        }

        if (arrayList.get(position).isEarly()) {
            holder.early.setVisibility(View.VISIBLE);
            holder.early.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "초반 전용", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            holder.early.setVisibility(View.GONE);
        }

        if (arrayList.get(position).isSpecialItem()) {
            holder.specialItem.setVisibility(View.VISIBLE);
            holder.specialItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "종결 아이템", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            holder.specialItem.setVisibility(View.GONE);
        }

        if (arrayList.get(position).isLadder()) {
            holder.ladder.setVisibility(View.VISIBLE);
            holder.ladder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "래더 전용", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            holder.ladder.setVisibility(View.GONE);
        }

        if (arrayList.get(position).isSorceress()) {
            holder.sorceress.setVisibility(View.VISIBLE);
            holder.sorceress.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "원소술사", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            holder.sorceress.setVisibility(View.GONE);
        }

        if (arrayList.get(position).isAmazon()) {
            holder.amazon.setVisibility(View.VISIBLE);
            holder.amazon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "아마존", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            holder.amazon.setVisibility(View.GONE);
        }

        if (arrayList.get(position).isAssassin()) {
            holder.assassin.setVisibility(View.VISIBLE);
            holder.assassin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "어쌔신", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            holder.assassin.setVisibility(View.GONE);
        }

        if (arrayList.get(position).isDruid()) {
            holder.druid.setVisibility(View.VISIBLE);
            holder.druid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "드루이드", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            holder.druid.setVisibility(View.GONE);
        }

        if (arrayList.get(position).isPaladins()) {
            holder.paladins.setVisibility(View.VISIBLE);
            holder.paladins.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "팔라딘", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            holder.paladins.setVisibility(View.GONE);
        }

        if (arrayList.get(position).isNecromancer()) {
            holder.necromancer.setVisibility(View.VISIBLE);
            holder.necromancer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "네크로맨서", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            holder.necromancer.setVisibility(View.GONE);
        }

        if (arrayList.get(position).isBarbarian()) {
            holder.barbarian.setVisibility(View.VISIBLE);
            holder.barbarian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "바바리안", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            holder.barbarian.setVisibility(View.GONE);
        }

        if (arrayList.get(position).isMercenary()) {
            holder.mercenary.setVisibility(View.VISIBLE);
            holder.mercenary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "용병", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            holder.mercenary.setVisibility(View.GONE);
        }

        holder.itemLevel.setVisibility(View.GONE);
        holder.modify.setVisibility(View.VISIBLE);
        if (selectedItemLevel > 0) {
            holder.spaceBar.setVisibility(View.VISIBLE);
            holder.itemLevel.setVisibility(View.VISIBLE);
            holder.itemLevel.setText("착용 레벨 : " + arrayList.get(position).getLevel());
            holder.amazon.setVisibility(View.GONE);
            holder.assassin.setVisibility(View.GONE);
            holder.barbarian.setVisibility(View.GONE);
            holder.druid.setVisibility(View.GONE);
            holder.necromancer.setVisibility(View.GONE);
            holder.paladins.setVisibility(View.GONE);
            holder.sorceress.setVisibility(View.GONE);
            holder.mercenary.setVisibility(View.GONE);
            holder.early.setVisibility(View.GONE);
            holder.ladder.setVisibility(View.GONE);
            holder.specialItem.setVisibility(View.GONE);
//            holder.modify.setVisibility(View.GONE);

        } else {
            holder.spaceBar.setVisibility(View.VISIBLE);
            holder.itemLevel.setVisibility(View.GONE);
        }

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            if (firebaseUser.getEmail().equals("cjmkeke@gmail.com")) {
                holder.modify.setVisibility(View.VISIBLE);
            } else {
                holder.modify.setVisibility(View.GONE);
            }
        } else {
            holder.modify.setVisibility(View.GONE);
        }

    } // TODO 홀더 부분 끝

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        /**
         * private TextView testView;
         **/
        private TextView runeItem, itemLevel, spaceBar;
        private ImageView sorceress, assassin, barbarian, druid, necromancer, paladins, amazon, mercenary;
        private ImageView specialItem, early, ladder;
        private LinearLayout mainView, itemShow;
        private TextView modify;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.runeItem = itemView.findViewById(R.id.tv_rune_word);
            this.itemShow = itemView.findViewById(R.id.ll_main_view);
            this.specialItem = itemView.findViewById(R.id.iv_special_item);
            this.early = itemView.findViewById(R.id.iv_early);
            this.ladder = itemView.findViewById(R.id.iv_ladder);
            this.sorceress = itemView.findViewById(R.id.iv_sorceress);
            this.assassin = itemView.findViewById(R.id.iv_assassin);
            this.barbarian = itemView.findViewById(R.id.iv_barbarian);
            this.druid = itemView.findViewById(R.id.iv_druid);
            this.necromancer = itemView.findViewById(R.id.iv_necromancer);
            this.paladins = itemView.findViewById(R.id.iv_paladins);
            this.amazon = itemView.findViewById(R.id.iv_amazon);
            this.mercenary = itemView.findViewById(R.id.iv_mercenary);
            this.mainView = itemView.findViewById(R.id.ll_main_view);
            this.modify = itemView.findViewById(R.id.tv_modify);
            this.itemLevel = itemView.findViewById(R.id.tv_item_level);
            this.spaceBar = itemView.findViewById(R.id.tv_space);
            itemShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    String runeName = arrayList.get(pos).getItemName();
                    String rune1 = arrayList.get(pos).getRune1();
                    String rune2 = arrayList.get(pos).getRune2();
                    String rune3 = arrayList.get(pos).getRune3();
                    String rune4 = arrayList.get(pos).getRune4();
                    String rune5 = arrayList.get(pos).getRune5();
                    String rune6 = arrayList.get(pos).getRune6();

                    String item_name = arrayList.get(pos).getItem_name();

                    boolean early = arrayList.get(pos).isEarly();
                    boolean specialItem = arrayList.get(pos).isSpecialItem();
                    boolean ladder = arrayList.get(pos).isLadder();
                    boolean sorceress = arrayList.get(pos).isSorceress();
                    boolean assassin = arrayList.get(pos).isAssassin();
                    boolean barbarian = arrayList.get(pos).isBarbarian();
                    boolean druid = arrayList.get(pos).isDruid();
                    boolean necromancer = arrayList.get(pos).isNecromancer();
                    boolean paladins = arrayList.get(pos).isPaladins();
                    boolean amazon = arrayList.get(pos).isAmazon();
                    boolean mercenary = arrayList.get(pos).isMercenary();

                    String url = arrayList.get(pos).getUrl();

                    Intent intent = new Intent(mContext, ShowRuneWordDialog.class);
                    intent.putExtra("runeName", runeName);
                    intent.putExtra("item_name", item_name);
                    intent.putExtra("rune1", rune1);
                    intent.putExtra("rune2", rune2);
                    intent.putExtra("rune3", rune3);
                    intent.putExtra("rune4", rune4);
                    intent.putExtra("rune5", rune5);
                    intent.putExtra("rune6", rune6);
                    intent.putExtra("url", url);
                    mContext.startActivity(intent);
                }
            });

            modify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    String runeName = arrayList.get(pos).getItemName();
                    Intent intent = new Intent(mContext, ModifyRuneWord.class);
                    intent.putExtra("runeName", runeName);
                    mContext.startActivity(intent);
                }
            });

        }
    }
}

