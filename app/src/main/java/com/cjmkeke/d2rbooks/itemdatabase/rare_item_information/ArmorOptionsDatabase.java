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
import com.cjmkeke.d2rbooks.databinding.FragmentArmorOptionsDatabaseBinding;

import java.util.ArrayList;
import java.util.List;

public class ArmorOptionsDatabase extends Fragment {

    private FragmentArmorOptionsDatabaseBinding mBinding;
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
    boolean isPrefix13 = true;
    boolean isPrefix14 = true;
    boolean isPrefix15 = true;
    boolean isPrefix16 = true;
    boolean isPrefix17 = true;
    boolean isPrefix18 = true;
    boolean isPrefix19 = true;
    boolean isPrefix20 = true;
    boolean isPrefix21 = true;
    boolean isPrefix22 = true;
    boolean isPrefix23 = true;
    boolean isPrefix24 = true;
    boolean isPrefix25 = true;
    boolean isPrefix26 = true;
    boolean isPrefix27 = true;
    boolean isPrefix28 = true;
    boolean isPrefix29 = true;
    boolean isPrefix30 = true;

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
    boolean isSuffix23 = true;
    boolean isSuffix24 = true;
    boolean isSuffix25 = true;
    boolean isSuffix26 = true;
    boolean isSuffix27 = true;
    boolean isSuffix28 = true;
    boolean isSuffix29 = true;
    boolean isSuffix30 = true;
    private List<String> listSuffix = new ArrayList<>();
    private List<String> listPrefix = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentArmorOptionsDatabaseBinding.inflate(inflater, container, false);

        listPrefix.clear();
        listSuffix.clear();

        // TODO 접미사
        String[] itemSuffix = new String[]{
                getString(R.string.item_options_armor_1_suffix), getString(R.string.item_options_armor_2_suffix), getString(R.string.item_options_armor_3_suffix),
                getString(R.string.item_options_armor_4_suffix), getString(R.string.item_options_armor_5_suffix), getString(R.string.item_options_armor_6_suffix),
                getString(R.string.item_options_armor_7_suffix), getString(R.string.item_options_armor_8_suffix), getString(R.string.item_options_armor_9_suffix),
                getString(R.string.item_options_armor_10_suffix), getString(R.string.item_options_armor_11_suffix), getString(R.string.item_options_armor_12_suffix),
                getString(R.string.item_options_armor_13_suffix), getString(R.string.item_options_armor_14_suffix), getString(R.string.item_options_armor_15_suffix),
                getString(R.string.item_options_armor_16_suffix), getString(R.string.item_options_armor_17_suffix), getString(R.string.item_options_armor_18_suffix),
                getString(R.string.item_options_armor_19_suffix), getString(R.string.item_options_armor_20_suffix)
        };

        // TODO 접두사
        String[] itemPrefix = new String[]{
                getString(R.string.item_options_armor_1_prefix), getString(R.string.item_options_armor_2_prefix), getString(R.string.item_options_armor_3_prefix),
                getString(R.string.item_options_armor_4_prefix), getString(R.string.item_options_armor_5_prefix), getString(R.string.item_options_armor_6_prefix),
                getString(R.string.item_options_armor_7_prefix), getString(R.string.item_options_armor_8_prefix), getString(R.string.item_options_armor_9_prefix),
                getString(R.string.item_options_armor_10_prefix), getString(R.string.item_options_armor_11_prefix), getString(R.string.item_options_armor_12_prefix),
                getString(R.string.item_options_armor_13_prefix), getString(R.string.item_options_armor_14_prefix), getString(R.string.item_options_armor_15_prefix),
                getString(R.string.item_options_armor_16_prefix), getString(R.string.item_options_armor_17_prefix), getString(R.string.item_options_armor_18_prefix),
                getString(R.string.item_options_armor_19_prefix), getString(R.string.item_options_armor_20_prefix), getString(R.string.item_options_armor_21_prefix),
                getString(R.string.item_options_armor_22_prefix), getString(R.string.item_options_armor_23_prefix)
        };

        RareHideAndShow rareHideAndShow = new RareHideAndShow(getContext(), listSuffix, listPrefix, itemPrefix, itemSuffix, mBinding.tvArmorTitle);
        rareHideAndShow.setItemType("armor");

        mBinding.tvArmorPrefix1.setOnClickListener(v -> {
            if (isPrefix1) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 0, mBinding.tvArmorPrefix1);
                isPrefix1 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 0, mBinding.tvArmorPrefix1);
                isPrefix1 = true;
            }
        });

        mBinding.tvArmorPrefix2.setOnClickListener(v -> {
            if (isPrefix2) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 1, mBinding.tvArmorPrefix2);
                isPrefix2 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 1, mBinding.tvArmorPrefix2);
                isPrefix2 = true;
            }

        });

        mBinding.tvArmorPrefix3.setOnClickListener(v -> {
            if (isPrefix3) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 2, mBinding.tvArmorPrefix3);
                isPrefix3 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 2, mBinding.tvArmorPrefix3);
                isPrefix3 = true;
            }
        });

        mBinding.tvArmorPrefix4.setOnClickListener(v -> {
            if (isPrefix4) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 3, mBinding.tvArmorPrefix4);
                isPrefix4 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 3, mBinding.tvArmorPrefix4);
                isPrefix4 = true;
            }
        });

        mBinding.tvArmorPrefix5.setOnClickListener(v -> {
            if (isPrefix5) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 4, mBinding.tvArmorPrefix5);
                isPrefix5 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 4, mBinding.tvArmorPrefix5);
                isPrefix5 = true;
            }
        });

        mBinding.tvArmorPrefix6.setOnClickListener(v -> {
            if (isPrefix6) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 5, mBinding.tvArmorPrefix6);
                isPrefix6 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 5, mBinding.tvArmorPrefix6);
                isPrefix6 = true;
            }
        });

        mBinding.tvArmorPrefix7.setOnClickListener(v -> {
            if (isPrefix7) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 6, mBinding.tvArmorPrefix7);
                isPrefix7 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 6, mBinding.tvArmorPrefix7);
                isPrefix7 = true;
            }
        });

        mBinding.tvArmorPrefix8.setOnClickListener(v -> {
            if (isPrefix8) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 7, mBinding.tvArmorPrefix8);
                isPrefix8 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 7, mBinding.tvArmorPrefix8);
                isPrefix8 = true;
            }
        });

        mBinding.tvArmorPrefix9.setOnClickListener(v -> {
            if (isPrefix9) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 8, mBinding.tvArmorPrefix9);
                isPrefix9 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 8, mBinding.tvArmorPrefix9);
                isPrefix9 = true;
            }
        });

        mBinding.tvArmorPrefix10.setOnClickListener(v -> {
            if (isPrefix10) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 9, mBinding.tvArmorPrefix10);
                isPrefix10 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 9, mBinding.tvArmorPrefix10);
                isPrefix10 = true;
            }
        });

        mBinding.tvArmorPrefix11.setOnClickListener(v -> {
            if (isPrefix11) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 10, mBinding.tvArmorPrefix11);
                isPrefix11 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 10, mBinding.tvArmorPrefix11);
                isPrefix11 = true;
            }
        });

        mBinding.tvArmorPrefix12.setOnClickListener(v -> {
            if (isPrefix12) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 11, mBinding.tvArmorPrefix12);
                isPrefix12 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 11, mBinding.tvArmorPrefix12);
                isPrefix12 = true;
            }
        });

        mBinding.tvArmorPrefix13.setOnClickListener(v -> {
            if (isPrefix13) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 12, mBinding.tvArmorPrefix13);
                isPrefix13 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 12, mBinding.tvArmorPrefix13);
                isPrefix13 = true;
            }
        });

        mBinding.tvArmorPrefix14.setOnClickListener(v -> {
            if (isPrefix14) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 13, mBinding.tvArmorPrefix14);
                isPrefix14 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 13, mBinding.tvArmorPrefix14);
                isPrefix14 = true;
            }
        });

        mBinding.tvArmorPrefix15.setOnClickListener(v -> {
            if (isPrefix15) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 14, mBinding.tvArmorPrefix15);
                isPrefix15 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 14, mBinding.tvArmorPrefix15);
                isPrefix15 = true;
            }
        });

        mBinding.tvArmorPrefix16.setOnClickListener(v -> {
            if (isPrefix16) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 15, mBinding.tvArmorPrefix16);
                isPrefix16 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 15, mBinding.tvArmorPrefix16);
                isPrefix16 = true;
            }
        });

        mBinding.tvArmorPrefix17.setOnClickListener(v -> {
            if (isPrefix17) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 16, mBinding.tvArmorPrefix17);
                isPrefix17 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 16, mBinding.tvArmorPrefix17);
                isPrefix17 = true;
            }
        });

        mBinding.tvArmorPrefix18.setOnClickListener(v -> {
            if (isPrefix18) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 17, mBinding.tvArmorPrefix18);
                isPrefix18 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 17, mBinding.tvArmorPrefix18);
                isPrefix18 = true;
            }
        });

        mBinding.tvArmorPrefix19.setOnClickListener(v -> {
            if (isPrefix19) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 18, mBinding.tvArmorPrefix19);
                isPrefix19 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 18, mBinding.tvArmorPrefix19);
                isPrefix19 = true;
            }
        });

        mBinding.tvArmorPrefix20.setOnClickListener(v -> {
            if (isPrefix20) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 19, mBinding.tvArmorPrefix20);
                isPrefix20 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 19, mBinding.tvArmorPrefix20);
                isPrefix20 = true;
            }
        });

        mBinding.tvArmorPrefix21.setOnClickListener(v -> {
            if (isPrefix21) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 20, mBinding.tvArmorPrefix21);
                isPrefix21 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 20, mBinding.tvArmorPrefix21);
                isPrefix21 = true;
            }
        });

        mBinding.tvArmorPrefix22.setOnClickListener(v -> {
            if (isPrefix22) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 21, mBinding.tvArmorPrefix22);
                isPrefix22 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 21, mBinding.tvArmorPrefix22);
                isPrefix22 = true;
            }
        });

        mBinding.tvArmorPrefix23.setOnClickListener(v -> {
            if (isPrefix23) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 22, mBinding.tvArmorPrefix23);
                isPrefix23 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 22, mBinding.tvArmorPrefix23);
                isPrefix23 = true;
            }
        });

        // TODO SUFFIX
        mBinding.tvArmorSuffix1.setOnClickListener(v -> {
            if (isSuffix1) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 0, mBinding.tvArmorSuffix1);
                isSuffix1 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 0, mBinding.tvArmorSuffix1);
                isSuffix1 = true;
            }
        });

        mBinding.tvArmorSuffix2.setOnClickListener(v -> {
            if (isSuffix2) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 1, mBinding.tvArmorSuffix2);
                isSuffix2 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 1, mBinding.tvArmorSuffix2);
                isSuffix2 = true;
            }
        });

        mBinding.tvArmorSuffix3.setOnClickListener(v -> {
            if (isSuffix3) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 2, mBinding.tvArmorSuffix3);
                isSuffix3 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 2, mBinding.tvArmorSuffix3);
                isSuffix3 = true;
            }
        });

        mBinding.tvArmorSuffix4.setOnClickListener(v -> {
            if (isSuffix4) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 3, mBinding.tvArmorSuffix4);
                isSuffix4 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 3, mBinding.tvArmorSuffix4);
                isSuffix4 = true;
            }
        });

        mBinding.tvArmorSuffix5.setOnClickListener(v -> {
            if (isSuffix5) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 4, mBinding.tvArmorSuffix5);
                isSuffix5 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 4, mBinding.tvArmorSuffix5);
                isSuffix5 = true;
            }
        });

        mBinding.tvArmorSuffix6.setOnClickListener(v -> {
            if (isSuffix6) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 5, mBinding.tvArmorSuffix6);
                isSuffix6 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 5, mBinding.tvArmorSuffix6);
                isSuffix6 = true;
            }
        });

        mBinding.tvArmorSuffix7.setOnClickListener(v -> {
            if (isSuffix7) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 6, mBinding.tvArmorSuffix7);
                isSuffix7 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 6, mBinding.tvArmorSuffix7);
                isSuffix7 = true;
            }
        });

        mBinding.tvArmorSuffix8.setOnClickListener(v -> {

            if (isSuffix8) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 7, mBinding.tvArmorSuffix8);
                isSuffix8 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 7, mBinding.tvArmorSuffix8);
                isSuffix8 = true;
            }
        });

        mBinding.tvArmorSuffix9.setOnClickListener(v -> {

            if (isSuffix9) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 8, mBinding.tvArmorSuffix9);
                isSuffix9 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 8, mBinding.tvArmorSuffix9);
                isSuffix9 = true;
            }
        });

        mBinding.tvArmorSuffix10.setOnClickListener(v -> {
            if (isSuffix10) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 9, mBinding.tvArmorSuffix10);
                isSuffix10 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 9, mBinding.tvArmorSuffix10);
                isSuffix10 = true;
            }
        });

        mBinding.tvArmorSuffix11.setOnClickListener(v -> {
            if (isSuffix11) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 10, mBinding.tvArmorSuffix11);
                isSuffix11 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 10, mBinding.tvArmorSuffix11);
                isSuffix11 = true;
            }
        });

        mBinding.tvArmorSuffix12.setOnClickListener(v -> {
            if (isSuffix12) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 11, mBinding.tvArmorSuffix12);
                isSuffix12 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 11, mBinding.tvArmorSuffix12);
                isSuffix12 = true;
            }
        });

        mBinding.tvArmorSuffix13.setOnClickListener(v -> {
            if (isSuffix13) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 12, mBinding.tvArmorSuffix13);
                isSuffix13 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 12, mBinding.tvArmorSuffix13);
                isSuffix13 = true;
            }
        });

        mBinding.tvArmorSuffix14.setOnClickListener(v -> {
            if (isSuffix14) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 13, mBinding.tvArmorSuffix14);
                isSuffix14 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 13, mBinding.tvArmorSuffix14);
                isSuffix14 = true;
            }
        });

        mBinding.tvArmorSuffix15.setOnClickListener(v -> {
            if (isSuffix15) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 14, mBinding.tvArmorSuffix15);
                isSuffix15 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 14, mBinding.tvArmorSuffix15);
                isSuffix15 = true;
            }
        });

        mBinding.tvArmorSuffix16.setOnClickListener(v -> {
            if (isSuffix16) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 15, mBinding.tvArmorSuffix16);
                isSuffix16 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 15, mBinding.tvArmorSuffix16);
                isSuffix16 = true;
            }
        });

        mBinding.tvArmorSuffix17.setOnClickListener(v -> {
            if (isSuffix17) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 16, mBinding.tvArmorSuffix17);
                isSuffix17 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 16, mBinding.tvArmorSuffix17);
                isSuffix17 = true;
            }
        });

        mBinding.tvArmorSuffix18.setOnClickListener(v -> {
            if (isSuffix18) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 17, mBinding.tvArmorSuffix18);
                isSuffix18 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 17, mBinding.tvArmorSuffix18);
                isSuffix18 = true;
            }
        });

        mBinding.tvArmorSuffix19.setOnClickListener(v -> {
            if (isSuffix19) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 18, mBinding.tvArmorSuffix19);
                isSuffix19 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 18, mBinding.tvArmorSuffix19);
                isSuffix19 = true;
            }
        });

        mBinding.tvArmorSuffix20.setOnClickListener(v -> {
            if (isSuffix20) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 19, mBinding.tvArmorSuffix20);
                isSuffix20 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 19, mBinding.tvArmorSuffix20);
                isSuffix20 = true;
            }
        });

//        mBinding.tvArmorSuffix21.setOnClickListener(v -> {
//            if (isSuffix21) {
//                hideAndShow.addSuffix(listSuffix, itemSuffix, 20, mBinding.tvArmorSuffix21);
//                isSuffix21 = false;
//            } else {
//                hideAndShow.removeSuffix(listSuffix, itemSuffix, 20, mBinding.tvArmorSuffix21);
//                isSuffix21 = true;
//            }
//        });
//
//        mBinding.tvArmorSuffix22.setOnClickListener(v -> {
//            if (isSuffix22) {
//                hideAndShow.addSuffix(listSuffix, itemSuffix, 21, mBinding.tvArmorSuffix22);
//                isSuffix22 = false;
//            } else {
//                hideAndShow.addSuffix(listSuffix, itemSuffix, 21, mBinding.tvArmorSuffix22);
//                isSuffix22 = true;
//            }
//        });



        return mBinding.getRoot();
    }
}