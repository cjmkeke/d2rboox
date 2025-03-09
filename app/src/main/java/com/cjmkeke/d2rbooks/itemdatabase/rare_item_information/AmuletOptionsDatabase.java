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
import com.cjmkeke.d2rbooks.databinding.FragmentAmuletOptionsDatabaseBinding;

import java.util.ArrayList;
import java.util.List;

public class AmuletOptionsDatabase extends Fragment {

    private static final String TAG = "AmuletOptionsDatabase";
    private FragmentAmuletOptionsDatabaseBinding mBinding;
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
    private List<String> amuletOptionsSuffix = new ArrayList<>();
    private List<String> amuletOptionsPrefix = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentAmuletOptionsDatabaseBinding.inflate(inflater, container, false);

        amuletOptionsSuffix.clear();
        amuletOptionsPrefix.clear();

        // TODO 접미사
        String[] amuletSuffix = new String[]{
                "시전 속도 +10",
                "결빙 감소 1/2",
                "힘 +1-30",
                "민첩성 +1-30",
                "에너지 +1-20",
                "라이프 +1-60",
                "최소 데미지 +1-9",
                "최대 데미지 +1-4",
                "라이프 획득 +2-6",
                "마나 획득 +3-8",
                "화염 데미지 +2-6",
                "냉기 데미지 +3-6",
                "번개 데미지 +11-23",
                "독 데미지 +50",
                "라이프 회복 +2-10",
                "시야 증가 3 / 5",
                "시야증가 5 / 5%",
                "데미지 감소 +1-7",
                "매직 데미지 감소 +1-3",
                "매직 아이템 얻을 확률 증가 +5-25",
                "몬스터로부터 얻는 골드 증가 +25-80",
                "중독 시간 감소 +25-75"
        };

        // TODO 접두사
        String[] amuletPrefix = new String[]{
                "캐릭터 모든 스킬 1-2",
                "캐릭터 개별 스킬 1-2",
                "공격 등급 1-20",
                "화염 저항력 +5-40",
                "냉기 저항력 +5-40",
                "번개 저항력 +5-40",
                "독 저항력 +5-40",
                "모든 저항력 +3-20",
                "마나 증가+1-90",
                "데미지 마나 흡수+7-12",
                "매직 아이템 얻을 확률 증가 +5-10",
                "스태미나 +5-20"
        };
        
        RareHideAndShow rareHideAndShow = new RareHideAndShow(getContext(), amuletOptionsSuffix, amuletOptionsPrefix, amuletPrefix, amuletSuffix, mBinding.tvAmuletTitle);
        rareHideAndShow.setItemType("amulet");

        mBinding.tvAmuletSuffix1.setOnClickListener(v -> {
            if (isSuffix1) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 0, mBinding.tvAmuletSuffix1);
                isSuffix1 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 0, mBinding.tvAmuletSuffix1);
                isSuffix1 = true;
            }
        });

        mBinding.tvAmuletSuffix2.setOnClickListener(v -> {
            if (isSuffix2) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 1, mBinding.tvAmuletSuffix2);
                isSuffix2 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 1, mBinding.tvAmuletSuffix2);
                isSuffix2 = true;
            }
        });

        mBinding.tvAmuletSuffix3.setOnClickListener(v -> {
            if (isSuffix3) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 2, mBinding.tvAmuletSuffix3);
                isSuffix3 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 2, mBinding.tvAmuletSuffix3);
                isSuffix3 = true;
            }
        });

        mBinding.tvAmuletSuffix4.setOnClickListener(v -> {
            if (isSuffix4) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 3, mBinding.tvAmuletSuffix4);
                isSuffix4 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 3, mBinding.tvAmuletSuffix4);
                isSuffix4 = true;
            }
        });

        mBinding.tvAmuletSuffix5.setOnClickListener(v -> {
            if (isSuffix5) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 4, mBinding.tvAmuletSuffix5);
                isSuffix5 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 4, mBinding.tvAmuletSuffix5);
                isSuffix5 = true;
            }
        });

        mBinding.tvAmuletSuffix6.setOnClickListener(v -> {
            if (isSuffix6) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 5, mBinding.tvAmuletSuffix6);
                isSuffix6 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 5, mBinding.tvAmuletSuffix6);
                isSuffix6 = true;
            }
        });

        mBinding.tvAmuletSuffix7.setOnClickListener(v -> {
            if (isSuffix7) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 6, mBinding.tvAmuletSuffix7);
                isSuffix7 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 6, mBinding.tvAmuletSuffix7);
                isSuffix7 = true;
            }
        });

        mBinding.tvAmuletSuffix8.setOnClickListener(v -> {

            if (isSuffix8) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 7, mBinding.tvAmuletSuffix8);
                isSuffix8 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 7, mBinding.tvAmuletSuffix8);
                isSuffix8 = true;
            }
        });

        mBinding.tvAmuletSuffix9.setOnClickListener(v -> {

            if (isSuffix9) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 8, mBinding.tvAmuletSuffix9);
                isSuffix9 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 8, mBinding.tvAmuletSuffix9);
                isSuffix9 = true;
            }
        });

        mBinding.tvAmuletSuffix10.setOnClickListener(v -> {
            if (isSuffix10) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 9, mBinding.tvAmuletSuffix10);
                isSuffix10 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 9, mBinding.tvAmuletSuffix10);
                isSuffix10 = true;
            }
        });

        mBinding.tvAmuletSuffix11.setOnClickListener(v -> {
            if (isSuffix11) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 10, mBinding.tvAmuletSuffix11);
                isSuffix11 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 10, mBinding.tvAmuletSuffix11);
                isSuffix11 = true;
            }
        });

        mBinding.tvAmuletSuffix12.setOnClickListener(v -> {
            if (isSuffix12) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 11, mBinding.tvAmuletSuffix12);
                isSuffix12 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 11, mBinding.tvAmuletSuffix12);
                isSuffix12 = true;
            }
        });

        mBinding.tvAmuletSuffix13.setOnClickListener(v -> {
            if (isSuffix13) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 12, mBinding.tvAmuletSuffix13);
                isSuffix13 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 12, mBinding.tvAmuletSuffix13);
                isSuffix13 = true;
            }
        });

        mBinding.tvAmuletSuffix14.setOnClickListener(v -> {
            if (isSuffix14) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 13, mBinding.tvAmuletSuffix14);
                isSuffix14 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 13, mBinding.tvAmuletSuffix14);
                isSuffix14 = true;
            }
        });

        mBinding.tvAmuletSuffix15.setOnClickListener(v -> {
            if (isSuffix15) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 14, mBinding.tvAmuletSuffix15);
                isSuffix15 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 14, mBinding.tvAmuletSuffix15);
                isSuffix15 = true;
            }
        });

        mBinding.tvAmuletSuffix16.setOnClickListener(v -> {
            if (isSuffix16) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 15, mBinding.tvAmuletSuffix16);
                isSuffix16 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 15, mBinding.tvAmuletSuffix16);
                isSuffix16 = true;
            }
        });

        mBinding.tvAmuletSuffix17.setOnClickListener(v -> {
            if (isSuffix17) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 16, mBinding.tvAmuletSuffix17);
                isSuffix17 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 16, mBinding.tvAmuletSuffix17);
                isSuffix17 = true;
            }
        });

        mBinding.tvAmuletSuffix18.setOnClickListener(v -> {
            if (isSuffix18) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 17, mBinding.tvAmuletSuffix18);
                isSuffix18 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 17, mBinding.tvAmuletSuffix18);
                isSuffix18 = true;
            }
        });

        mBinding.tvAmuletSuffix19.setOnClickListener(v -> {
            if (isSuffix19) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 18, mBinding.tvAmuletSuffix19);
                isSuffix19 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 18, mBinding.tvAmuletSuffix19);
                isSuffix19 = true;
            }
        });

        mBinding.tvAmuletSuffix20.setOnClickListener(v -> {
            if (isSuffix20) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 19, mBinding.tvAmuletSuffix20);
                isSuffix20 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 19, mBinding.tvAmuletSuffix20);
                isSuffix20 = true;
            }
        });

        mBinding.tvAmuletSuffix21.setOnClickListener(v -> {
            if (isSuffix21) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 20, mBinding.tvAmuletSuffix21);
                isSuffix21 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 20, mBinding.tvAmuletSuffix21);
                isSuffix21 = true;
            }
        });

        mBinding.tvAmuletSuffix22.setOnClickListener(v -> {
            if (isSuffix22) {
                rareHideAndShow.addSuffix(amuletOptionsSuffix, amuletSuffix, 21, mBinding.tvAmuletSuffix22);
                isSuffix22 = false;
            } else {
                rareHideAndShow.removeSuffix(amuletOptionsSuffix, amuletSuffix, 21, mBinding.tvAmuletSuffix22);
                isSuffix22 = true;
            }
        });

        mBinding.tvAmuletPrefix1.setOnClickListener(v -> {
            mBinding.tvAmuletPrefix2.setClickable(false);
            if (isPrefix1) {
                rareHideAndShow.addPreFix(amuletOptionsPrefix, amuletPrefix, 0, mBinding.tvAmuletPrefix1);
                isPrefix1 = false;
            } else {
                rareHideAndShow.removePreFix(amuletOptionsPrefix, amuletPrefix, 0, mBinding.tvAmuletPrefix1);
                isPrefix1 = true;
                mBinding.tvAmuletPrefix2.setClickable(true);
            }

        });

        mBinding.tvAmuletPrefix2.setOnClickListener(v -> {
            mBinding.tvAmuletPrefix1.setClickable(false);
            if (isPrefix2) {
                rareHideAndShow.addPreFix(amuletOptionsPrefix, amuletPrefix, 1, mBinding.tvAmuletPrefix2);
                isPrefix2 = false;
            } else {
                rareHideAndShow.removePreFix(amuletOptionsPrefix, amuletPrefix, 1, mBinding.tvAmuletPrefix2);
                isPrefix2 = true;
                mBinding.tvAmuletPrefix1.setClickable(true);
            }

        });

        mBinding.tvAmuletPrefix3.setOnClickListener(v -> {
            if (isPrefix3) {
                rareHideAndShow.addPreFix(amuletOptionsPrefix, amuletPrefix, 2, mBinding.tvAmuletPrefix3);
                isPrefix3 = false;
            } else {
                rareHideAndShow.removePreFix(amuletOptionsPrefix, amuletPrefix, 2, mBinding.tvAmuletPrefix3);
                isPrefix3 = true;
            }
        });

        mBinding.tvAmuletPrefix4.setOnClickListener(v -> {
            if (isPrefix4) {
                rareHideAndShow.addPreFix(amuletOptionsPrefix, amuletPrefix, 3, mBinding.tvAmuletPrefix4);
                isPrefix4 = false;
            } else {
                rareHideAndShow.removePreFix(amuletOptionsPrefix, amuletPrefix, 3, mBinding.tvAmuletPrefix4);
                isPrefix4 = true;
            }
        });

        mBinding.tvAmuletPrefix5.setOnClickListener(v -> {
            if (isPrefix5) {
                rareHideAndShow.addPreFix(amuletOptionsPrefix, amuletPrefix, 4, mBinding.tvAmuletPrefix5);
                isPrefix5 = false;
            } else {
                rareHideAndShow.removePreFix(amuletOptionsPrefix, amuletPrefix, 4, mBinding.tvAmuletPrefix5);
                isPrefix5 = true;
            }
        });

        mBinding.tvAmuletPrefix6.setOnClickListener(v -> {
            if (isPrefix6) {
                rareHideAndShow.addPreFix(amuletOptionsPrefix, amuletPrefix, 5, mBinding.tvAmuletPrefix6);
                isPrefix6 = false;
            } else {
                rareHideAndShow.removePreFix(amuletOptionsPrefix, amuletPrefix, 5, mBinding.tvAmuletPrefix6);
                isPrefix6 = true;
            }
        });

        mBinding.tvAmuletPrefix7.setOnClickListener(v -> {
            if (isPrefix7) {
                rareHideAndShow.addPreFix(amuletOptionsPrefix, amuletPrefix, 6, mBinding.tvAmuletPrefix7);
                isPrefix7 = false;
            } else {
                rareHideAndShow.removePreFix(amuletOptionsPrefix, amuletPrefix, 6, mBinding.tvAmuletPrefix7);
                isPrefix7 = true;
            }
        });

        mBinding.tvAmuletPrefix8.setOnClickListener(v -> {
            if (isPrefix8) {
                rareHideAndShow.addPreFix(amuletOptionsPrefix, amuletPrefix, 7, mBinding.tvAmuletPrefix8);
                isPrefix8 = false;
            } else {
                rareHideAndShow.removePreFix(amuletOptionsPrefix, amuletPrefix, 7, mBinding.tvAmuletPrefix8);
                isPrefix8 = true;
            }
        });

        mBinding.tvAmuletPrefix9.setOnClickListener(v -> {
            if (isPrefix9) {
                rareHideAndShow.addPreFix(amuletOptionsPrefix, amuletPrefix, 8, mBinding.tvAmuletPrefix9);
                isPrefix9 = false;
            } else {
                rareHideAndShow.removePreFix(amuletOptionsPrefix, amuletPrefix, 8, mBinding.tvAmuletPrefix9);
                isPrefix9 = true;
            }
        });

        mBinding.tvAmuletPrefix10.setOnClickListener(v -> {
            if (isPrefix10) {
                rareHideAndShow.addPreFix(amuletOptionsPrefix, amuletPrefix, 9, mBinding.tvAmuletPrefix10);
                isPrefix10 = false;
            } else {
                rareHideAndShow.removePreFix(amuletOptionsPrefix, amuletPrefix, 9, mBinding.tvAmuletPrefix10);
                isPrefix10 = true;
            }
        });

        mBinding.tvAmuletPrefix11.setOnClickListener(v -> {
            if (isPrefix11) {
                rareHideAndShow.addPreFix(amuletOptionsPrefix, amuletPrefix, 10, mBinding.tvAmuletPrefix11);
                isPrefix11 = false;
            } else {
                rareHideAndShow.removePreFix(amuletOptionsPrefix, amuletPrefix, 10, mBinding.tvAmuletPrefix11);
                isPrefix11 = true;
            }
        });

        mBinding.tvAmuletPrefix12.setOnClickListener(v -> {
            if (isPrefix12) {
                rareHideAndShow.addPreFix(amuletOptionsPrefix, amuletPrefix, 11, mBinding.tvAmuletPrefix12);
                isPrefix12 = false;
            } else {
                rareHideAndShow.removePreFix(amuletOptionsPrefix, amuletPrefix, 11, mBinding.tvAmuletPrefix12);
                isPrefix12 = true;
            }
        });

        return mBinding.getRoot();
    }
}