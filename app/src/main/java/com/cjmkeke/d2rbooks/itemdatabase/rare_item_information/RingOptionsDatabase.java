package com.cjmkeke.d2rbooks.itemdatabase.rare_item_information;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentRingOptionsDatabaseBinding;

import java.util.ArrayList;
import java.util.List;

public class RingOptionsDatabase extends Fragment {

    private static final String Tag = "RingOptionsDatabase";
    private FragmentRingOptionsDatabaseBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    boolean isPrefix1 = true;
    boolean isPrefix2 = true;
    boolean isPrefix3 = true;
    boolean isPrefix4 = true;
    boolean isPrefix5 = true;
    boolean isPrefix6 = true;
    boolean isPrefix7 = true;
    boolean isPrefix8 = true;
    boolean isPrefix9 = true;
    boolean isPrefix10 = true;
    boolean isPrefix11 = true;
    boolean isPrefix12 = true;
    boolean isSuffix1 = true;
    boolean isSuffix2 = true;
    boolean isSuffix3 = true;
    boolean isSuffix4 = true;
    boolean isSuffix5 = true;
    boolean isSuffix6 = true;
    boolean isSuffix7 = true;
    boolean isSuffix8 = true;
    boolean isSuffix9 = true;
    boolean isSuffix10 = true;
    boolean isSuffix11 = true;
    boolean isSuffix12 = true;
    boolean isSuffix13 = true;
    boolean isSuffix14 = true;
    boolean isSuffix15 = true;
    boolean isSuffix16 = true;
    boolean isSuffix17 = true;
    boolean isSuffix18 = true;
    boolean isSuffix19 = true;
    boolean isSuffix20 = true;
    boolean isSuffix21 = true;
    boolean isSuffix22 = true;
    private List<String> ringOptionsSuffix = new ArrayList<>();
    private List<String> ringOptionsPrefix = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentRingOptionsDatabaseBinding.inflate(inflater, container, false);

        // TODO 접미사
        String[] ringSuffix = new String[]{
                "시전 속도 +10",
                "결빙 감소 1/2",
                "힘 + 1-20",
                "민첩성 +1-15",
                "에너지 +1-15",
                "라이프 +1-40",
                "최소 데미지 +1-9",
                "최대 데미지 +1-4",
                "라이프 획득 +3-8",
                "마나 획득 +2-6",
                "화염 데미지 +2-6",
                "냉기 데미지 +3-6",
                "번개 데미지 +11-23",
                "독 데미지 +50",
                "라이프 회복 +3-9",
                "시야 증가 3 / 공격 등급 +30",
                "시야 증가 5 / 공격 등급 5%",
                "데미지 감소 +1-2",
                "매직 데미지 감소 +1-2",
                "매직 아이템 얻을 확률 증가 +5-15",
                "몬스터로부터 얻는 골드 증가 +25-30",
                "중독 시간 감소 +25%"
        };

        // TODO 접두사
        String[] ringPrefix = new String[]{
                "공격 등급 +21-120",
                "화염 저항력 +5-40",
                "냉기 저항력 +5-30",
                "번개 저항력 +5-30",
                "독 저항력 +5-30",
                "모든 저항력 +3-11",
                "마나 증가 +1-90",
                "마나 상승 +1 (적 제거시)",
                "매직 아이템 얻을 확률 증가 +5-10",
                "스태미나 +5-20",
                "시야 증가 +1-2"
        };

        RareHideAndShow rareHideAndShow = new RareHideAndShow(getContext(), ringOptionsSuffix, ringOptionsPrefix, ringPrefix, ringSuffix, mBinding.tvRingTitle);
        rareHideAndShow.setItemType("ring");

        mBinding.tvRingPrefix1.setOnClickListener(v -> {
            if (isPrefix1) {
                rareHideAndShow.addPreFix(ringOptionsPrefix, ringPrefix, 0, mBinding.tvRingPrefix1);
                isPrefix1 = false;
            } else {
                rareHideAndShow.removePreFix(ringOptionsPrefix, ringPrefix, 0, mBinding.tvRingPrefix1);
                isPrefix1 = true;
            }

        });

        mBinding.tvRingPrefix2.setOnClickListener(v -> {
            if (isPrefix2) {
                rareHideAndShow.addPreFix(ringOptionsPrefix, ringPrefix, 1, mBinding.tvRingPrefix2);
                isPrefix2 = false;
            } else {
                rareHideAndShow.removePreFix(ringOptionsPrefix, ringPrefix, 1, mBinding.tvRingPrefix2);
                isPrefix2 = true;
            }

        });

        mBinding.tvRingPrefix3.setOnClickListener(v -> {
            if (isPrefix3) {
                rareHideAndShow.addPreFix(ringOptionsPrefix, ringPrefix, 2, mBinding.tvRingPrefix3);
                isPrefix3 = false;
            } else {
                rareHideAndShow.removePreFix(ringOptionsPrefix, ringPrefix, 2, mBinding.tvRingPrefix3);
                isPrefix3 = true;
            }
        });

        mBinding.tvRingPrefix4.setOnClickListener(v -> {
            if (isPrefix4) {
                rareHideAndShow.addPreFix(ringOptionsPrefix, ringPrefix, 3, mBinding.tvRingPrefix4);
                isPrefix4 = false;
            } else {
                rareHideAndShow.removePreFix(ringOptionsPrefix, ringPrefix, 3, mBinding.tvRingPrefix4);
                isPrefix4 = true;
            }
        });

        mBinding.tvRingPrefix5.setOnClickListener(v -> {
            if (isPrefix5) {
                rareHideAndShow.addPreFix(ringOptionsPrefix, ringPrefix, 4, mBinding.tvRingPrefix5);
                isPrefix5 = false;
            } else {
                rareHideAndShow.removePreFix(ringOptionsPrefix, ringPrefix, 4, mBinding.tvRingPrefix5);
                isPrefix5 = true;
            }
        });

        mBinding.tvRingPrefix6.setOnClickListener(v -> {
            if (isPrefix6) {
                rareHideAndShow.addPreFix(ringOptionsPrefix, ringPrefix, 5, mBinding.tvRingPrefix6);
                isPrefix6 = false;
            } else {
                rareHideAndShow.removePreFix(ringOptionsPrefix, ringPrefix, 5, mBinding.tvRingPrefix6);
                isPrefix6 = true;
            }
        });

        mBinding.tvRingPrefix7.setOnClickListener(v -> {
            if (isPrefix7) {
                rareHideAndShow.addPreFix(ringOptionsPrefix, ringPrefix, 6, mBinding.tvRingPrefix7);
                isPrefix7 = false;
            } else {
                rareHideAndShow.removePreFix(ringOptionsPrefix, ringPrefix, 6, mBinding.tvRingPrefix7);
                isPrefix7 = true;
            }
        });

        mBinding.tvRingPrefix8.setOnClickListener(v -> {
            if (isPrefix8) {
                rareHideAndShow.addPreFix(ringOptionsPrefix, ringPrefix, 7, mBinding.tvRingPrefix8);
                isPrefix8 = false;
            } else {
                rareHideAndShow.removePreFix(ringOptionsPrefix, ringPrefix, 7, mBinding.tvRingPrefix8);
                isPrefix8 = true;
            }
        });

        mBinding.tvRingPrefix9.setOnClickListener(v -> {
            if (isPrefix9) {
                rareHideAndShow.addPreFix(ringOptionsPrefix, ringPrefix, 8, mBinding.tvRingPrefix9);
                isPrefix9 = false;
            } else {
                rareHideAndShow.removePreFix(ringOptionsPrefix, ringPrefix, 8, mBinding.tvRingPrefix9);
                isPrefix9 = true;
            }
        });

        mBinding.tvRingPrefix10.setOnClickListener(v -> {
            if (isPrefix10) {
                rareHideAndShow.addPreFix(ringOptionsPrefix, ringPrefix, 9, mBinding.tvRingPrefix10);
                isPrefix10 = false;
            } else {
                rareHideAndShow.removePreFix(ringOptionsPrefix, ringPrefix, 9, mBinding.tvRingPrefix10);
                isPrefix10 = true;
            }
        });

        mBinding.tvRingPrefix11.setOnClickListener(v -> {
            if (isPrefix11) {
                rareHideAndShow.addPreFix(ringOptionsPrefix, ringPrefix, 10, mBinding.tvRingPrefix11);
                isPrefix11 = false;
            } else {
                rareHideAndShow.removePreFix(ringOptionsPrefix, ringPrefix, 10, mBinding.tvRingPrefix11);
                isPrefix11 = true;
            }
        });

        mBinding.tvRingSuffix1.setOnClickListener(v -> {
            if (isSuffix1) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 0, mBinding.tvRingSuffix1);
                isSuffix1 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 0, mBinding.tvRingSuffix1);
                isSuffix1 = true;
            }
        });

        mBinding.tvRingSuffix2.setOnClickListener(v -> {
            if (isSuffix2) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 1, mBinding.tvRingSuffix2);
                isSuffix2 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 1, mBinding.tvRingSuffix2);
                isSuffix2 = true;
            }
        });

        mBinding.tvRingSuffix3.setOnClickListener(v -> {
            if (isSuffix3) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 2, mBinding.tvRingSuffix3);
                isSuffix3 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 2, mBinding.tvRingSuffix3);
                isSuffix3 = true;
            }
        });

        mBinding.tvRingSuffix4.setOnClickListener(v -> {
            if (isSuffix4) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 3, mBinding.tvRingSuffix4);
                isSuffix4 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 3, mBinding.tvRingSuffix4);
                isSuffix4 = true;
            }
        });

        mBinding.tvRingSuffix5.setOnClickListener(v -> {
            if (isSuffix5) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 4, mBinding.tvRingSuffix5);
                isSuffix5 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 4, mBinding.tvRingSuffix5);
                isSuffix5 = true;
            }
        });

        mBinding.tvRingSuffix6.setOnClickListener(v -> {
            if (isSuffix6) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 5, mBinding.tvRingSuffix6);
                isSuffix6 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 5, mBinding.tvRingSuffix6);
                isSuffix6 = true;
            }
        });

        mBinding.tvRingSuffix7.setOnClickListener(v -> {
            if (isSuffix7) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 6, mBinding.tvRingSuffix7);
                isSuffix7 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 6, mBinding.tvRingSuffix7);
                isSuffix7 = true;
            }
        });

        mBinding.tvRingSuffix8.setOnClickListener(v -> {

            if (isSuffix8) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 7, mBinding.tvRingSuffix8);
                isSuffix8 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 7, mBinding.tvRingSuffix8);
                isSuffix8 = true;
            }
        });

        mBinding.tvRingSuffix9.setOnClickListener(v -> {

            if (isSuffix9) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 8, mBinding.tvRingSuffix9);
                isSuffix9 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 8, mBinding.tvRingSuffix9);
                isSuffix9 = true;
            }
        });

        mBinding.tvRingSuffix10.setOnClickListener(v -> {
            if (isSuffix10) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 9, mBinding.tvRingSuffix10);
                isSuffix10 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 9, mBinding.tvRingSuffix10);
                isSuffix10 = true;
            }
        });

        mBinding.tvRingSuffix11.setOnClickListener(v -> {
            if (isSuffix11) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 10, mBinding.tvRingSuffix11);
                isSuffix11 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 10, mBinding.tvRingSuffix11);
                isSuffix11 = true;
            }
        });

        mBinding.tvRingSuffix12.setOnClickListener(v -> {
            if (isSuffix12) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 11, mBinding.tvRingSuffix12);
                isSuffix12 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 11, mBinding.tvRingSuffix12);
                isSuffix12 = true;
            }
        });

        mBinding.tvRingSuffix13.setOnClickListener(v -> {
            if (isSuffix13) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 12, mBinding.tvRingSuffix13);
                isSuffix13 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 12, mBinding.tvRingSuffix13);
                isSuffix13 = true;
            }
        });

        mBinding.tvRingSuffix14.setOnClickListener(v -> {
            if (isSuffix14) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 13, mBinding.tvRingSuffix14);
                isSuffix14 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 13, mBinding.tvRingSuffix14);
                isSuffix14 = true;
            }
        });

        mBinding.tvRingSuffix15.setOnClickListener(v -> {
            if (isSuffix15) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 14, mBinding.tvRingSuffix15);
                isSuffix15 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 14, mBinding.tvRingSuffix15);
                isSuffix15 = true;
            }
        });

        mBinding.tvRingSuffix16.setOnClickListener(v -> {
            if (isSuffix16) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 15, mBinding.tvRingSuffix16);
                isSuffix16 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 15, mBinding.tvRingSuffix16);
                isSuffix16 = true;
            }
        });

        mBinding.tvRingSuffix17.setOnClickListener(v -> {
            if (isSuffix17) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 16, mBinding.tvRingSuffix17);
                isSuffix17 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 16, mBinding.tvRingSuffix17);
                isSuffix17 = true;
            }
        });

        mBinding.tvRingSuffix18.setOnClickListener(v -> {
            if (isSuffix18) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 17, mBinding.tvRingSuffix18);
                isSuffix18 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 17, mBinding.tvRingSuffix18);
                isSuffix18 = true;
            }
        });

        mBinding.tvRingSuffix19.setOnClickListener(v -> {
            if (isSuffix19) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 18, mBinding.tvRingSuffix19);
                isSuffix19 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 18, mBinding.tvRingSuffix19);
                isSuffix19 = true;
            }
        });

        mBinding.tvRingSuffix20.setOnClickListener(v -> {
            if (isSuffix20) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 19, mBinding.tvRingSuffix20);
                isSuffix20 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 19, mBinding.tvRingSuffix20);
                isSuffix20 = true;
            }
        });

        mBinding.tvRingSuffix21.setOnClickListener(v -> {
            if (isSuffix21) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 20, mBinding.tvRingSuffix21);
                isSuffix21 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 20, mBinding.tvRingSuffix21);
                isSuffix21 = true;
            }
        });

        mBinding.tvRingSuffix22.setOnClickListener(v -> {
            if (isSuffix22) {
                rareHideAndShow.addSuffix(ringOptionsSuffix, ringSuffix, 21, mBinding.tvRingSuffix22);
                isSuffix22 = false;
            } else {
                rareHideAndShow.removeSuffix(ringOptionsSuffix, ringSuffix, 21, mBinding.tvRingSuffix22);
                isSuffix22 = true;
            }
        });


        return mBinding.getRoot();
    }

}