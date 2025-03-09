package com.cjmkeke.d2rbooks.itemdatabase.rare_item_information;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentBootsOptionsDatabaseBinding;

import java.util.ArrayList;
import java.util.List;

public class BootsOptionsDatabase extends Fragment {

    private static final String TAG = "BootsOptionsDatabase";
    private FragmentBootsOptionsDatabaseBinding mBinding;
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
        mBinding = FragmentBootsOptionsDatabaseBinding.inflate(inflater, container, false);

        listPrefix.clear();
        listSuffix.clear();

        // TODO 접미사
        String[] itemSuffix = new String[]{
                getString(R.string.item_options_boots_1_suffix), getString(R.string.item_options_boots_2_suffix), getString(R.string.item_options_boots_3_suffix),
                getString(R.string.item_options_boots_4_suffix), getString(R.string.item_options_boots_5_suffix), getString(R.string.item_options_boots_6_suffix),
                getString(R.string.item_options_boots_7_suffix), getString(R.string.item_options_boots_8_suffix), getString(R.string.item_options_boots_9_suffix),
                getString(R.string.item_options_boots_10_suffix), getString(R.string.item_options_boots_11_suffix), getString(R.string.item_options_boots_12_suffix),
                getString(R.string.item_options_boots_13_suffix), getString(R.string.item_options_boots_14_suffix), getString(R.string.item_options_boots_15_suffix),
                getString(R.string.item_options_boots_16_suffix), getString(R.string.item_options_boots_17_suffix), getString(R.string.item_options_boots_18_suffix),
                getString(R.string.item_options_boots_19_suffix), getString(R.string.item_options_boots_20_suffix), getString(R.string.item_options_boots_21_suffix),
                getString(R.string.item_options_boots_22_suffix)
        };

        // TODO 접두사
        String[] itemPrefix = new String[]{
                getString(R.string.item_options_boots_1_prefix), getString(R.string.item_options_boots_2_prefix), getString(R.string.item_options_boots_3_prefix),
                getString(R.string.item_options_boots_4_prefix), getString(R.string.item_options_boots_5_prefix), getString(R.string.item_options_boots_6_prefix),
                getString(R.string.item_options_boots_7_prefix), getString(R.string.item_options_boots_8_prefix), getString(R.string.item_options_boots_9_prefix),
                getString(R.string.item_options_boots_10_prefix), getString(R.string.item_options_boots_11_prefix), getString(R.string.item_options_boots_12_prefix),
                getString(R.string.item_options_boots_13_prefix), getString(R.string.item_options_boots_14_prefix), getString(R.string.item_options_boots_15_prefix),
                getString(R.string.item_options_boots_16_prefix), getString(R.string.item_options_boots_17_prefix), getString(R.string.item_options_boots_18_prefix),
                getString(R.string.item_options_boots_19_prefix), getString(R.string.item_options_boots_20_prefix), getString(R.string.item_options_boots_21_prefix)
        };

        RareHideAndShow rareHideAndShow = new RareHideAndShow(getContext(), listSuffix, listPrefix, itemPrefix, itemSuffix, mBinding.tvBootsTitle);
        rareHideAndShow.setItemType("boots");

        mBinding.tvBootsPrefix1.setOnClickListener(v -> {
            if (isPrefix1) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 0, mBinding.tvBootsPrefix1);
                isPrefix1 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 0, mBinding.tvBootsPrefix1);
                isPrefix1 = true;
            }
        });

        mBinding.tvBootsPrefix2.setOnClickListener(v -> {
            if (isPrefix2) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 1, mBinding.tvBootsPrefix2);
                isPrefix2 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 1, mBinding.tvBootsPrefix2);
                isPrefix2 = true;
            }

        });

        mBinding.tvBootsPrefix3.setOnClickListener(v -> {
            if (isPrefix3) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 2, mBinding.tvBootsPrefix3);
                isPrefix3 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 2, mBinding.tvBootsPrefix3);
                isPrefix3 = true;
            }
        });

        mBinding.tvBootsPrefix4.setOnClickListener(v -> {
            if (isPrefix4) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 3, mBinding.tvBootsPrefix4);
                isPrefix4 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 3, mBinding.tvBootsPrefix4);
                isPrefix4 = true;
            }
        });

        mBinding.tvBootsPrefix5.setOnClickListener(v -> {
            if (isPrefix5) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 4, mBinding.tvBootsPrefix5);
                isPrefix5 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 4, mBinding.tvBootsPrefix5);
                isPrefix5 = true;
            }
        });

        mBinding.tvBootsPrefix6.setOnClickListener(v -> {
            if (isPrefix6) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 5, mBinding.tvBootsPrefix6);
                isPrefix6 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 5, mBinding.tvBootsPrefix6);
                isPrefix6 = true;
            }
        });

        mBinding.tvBootsPrefix7.setOnClickListener(v -> {
            if (isPrefix7) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 6, mBinding.tvBootsPrefix7);
                isPrefix7 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 6, mBinding.tvBootsPrefix7);
                isPrefix7 = true;
            }
        });

        mBinding.tvBootsPrefix8.setOnClickListener(v -> {
            if (isPrefix8) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 7, mBinding.tvBootsPrefix8);
                isPrefix8 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 7, mBinding.tvBootsPrefix8);
                isPrefix8 = true;
            }
        });

        mBinding.tvBootsPrefix9.setOnClickListener(v -> {
            if (isPrefix9) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 8, mBinding.tvBootsPrefix9);
                isPrefix9 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 8, mBinding.tvBootsPrefix9);
                isPrefix9 = true;
            }
        });

        mBinding.tvBootsPrefix10.setOnClickListener(v -> {
            if (isPrefix10) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 9, mBinding.tvBootsPrefix10);
                isPrefix10 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 9, mBinding.tvBootsPrefix10);
                isPrefix10 = true;
            }
        });

//        mBinding.tvBootsPrefix11.setOnClickListener(v -> {
//            if (isPrefix11) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 10, mBinding.tvBootsPrefix11);
//                isPrefix11 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 10, mBinding.tvBootsPrefix11);
//                isPrefix11 = true;
//            }
//        });
//
//        mBinding.tvBootsPrefix12.setOnClickListener(v -> {
//            if (isPrefix12) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 11, mBinding.tvBootsPrefix12);
//                isPrefix12 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 11, mBinding.tvBootsPrefix12);
//                isPrefix12 = true;
//            }
//        });
//
//        mBinding.tvBootsPrefix13.setOnClickListener(v -> {
//            if (isPrefix13) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 12, mBinding.tvBootsPrefix13);
//                isPrefix13 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 12, mBinding.tvBootsPrefix13);
//                isPrefix13 = true;
//            }
//        });
//
//        mBinding.tvBootsPrefix14.setOnClickListener(v -> {
//            if (isPrefix14) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 13, mBinding.tvBootsPrefix14);
//                isPrefix14 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 13, mBinding.tvBootsPrefix14);
//                isPrefix14 = true;
//            }
//        });
//
//        mBinding.tvBootsPrefix15.setOnClickListener(v -> {
//            if (isPrefix15) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 14, mBinding.tvBootsPrefix15);
//                isPrefix15 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 14, mBinding.tvBootsPrefix15);
//                isPrefix15 = true;
//            }
//        });
//
//        mBinding.tvBootsPrefix16.setOnClickListener(v -> {
//            if (isPrefix16) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 15, mBinding.tvBootsPrefix16);
//                isPrefix16 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 15, mBinding.tvBootsPrefix16);
//                isPrefix16 = true;
//            }
//        });
//
//        mBinding.tvBootsPrefix17.setOnClickListener(v -> {
//            if (isPrefix17) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 16, mBinding.tvBootsPrefix17);
//                isPrefix17 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 16, mBinding.tvBootsPrefix17);
//                isPrefix17 = true;
//            }
//        });
//
//        mBinding.tvBootsPrefix18.setOnClickListener(v -> {
//            if (isPrefix18) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 17, mBinding.tvBootsPrefix18);
//                isPrefix18 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 17, mBinding.tvBootsPrefix18);
//                isPrefix18 = true;
//            }
//        });
//
//        mBinding.tvBootsPrefix19.setOnClickListener(v -> {
//            if (isPrefix19) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 18, mBinding.tvBootsPrefix19);
//                isPrefix19 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 18, mBinding.tvBootsPrefix19);
//                isPrefix19 = true;
//            }
//        });
//
//        mBinding.tvBootsPrefix20.setOnClickListener(v -> {
//            if (isPrefix20) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 19, mBinding.tvBootsPrefix20);
//                isPrefix20 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 19, mBinding.tvBootsPrefix20);
//                isPrefix20 = true;
//            }
//        });
//
//        mBinding.tvBootsPrefix21.setOnClickListener(v -> {
//            if (isPrefix21) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 20, mBinding.tvBootsPrefix21);
//                isPrefix21 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 20, mBinding.tvBootsPrefix21);
//                isPrefix21 = true;
//            }
//        });
//
//        mBinding.tvBootsPrefix22.setOnClickListener(v -> {
//            if (isPrefix22) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 21, mBinding.tvBootsPrefix22);
//                isPrefix22 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 21, mBinding.tvBootsPrefix22);
//                isPrefix22 = true;
//            }
//        });
//
//        mBinding.tvBootsPrefix23.setOnClickListener(v -> {
//            if (isPrefix23) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 22, mBinding.tvBootsPrefix23);
//                isPrefix23 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 22, mBinding.tvBootsPrefix23);
//                isPrefix23 = true;
//            }
//        });

        // TODO SUFFIX
        mBinding.tvBootsSuffix1.setOnClickListener(v -> {
            if (isSuffix1) {
                Log.w(TAG, itemSuffix[0]);
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 0, mBinding.tvBootsSuffix1);
                isSuffix1 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 0, mBinding.tvBootsSuffix1);
                isSuffix1 = true;
            }
        });

        mBinding.tvBootsSuffix2.setOnClickListener(v -> {
            if (isSuffix2) {
                Log.w(TAG, itemSuffix[1]);
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 1, mBinding.tvBootsSuffix2);
                isSuffix2 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 1, mBinding.tvBootsSuffix2);
                isSuffix2 = true;
            }
        });

        mBinding.tvBootsSuffix3.setOnClickListener(v -> {
            if (isSuffix3) {
                Log.w(TAG, itemSuffix[2]);
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 2, mBinding.tvBootsSuffix3);
                isSuffix3 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 2, mBinding.tvBootsSuffix3);
                isSuffix3 = true;
            }
        });

        mBinding.tvBootsSuffix4.setOnClickListener(v -> {
            if (isSuffix4) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 3, mBinding.tvBootsSuffix4);
                isSuffix4 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 3, mBinding.tvBootsSuffix4);
                isSuffix4 = true;
            }
        });

        mBinding.tvBootsSuffix5.setOnClickListener(v -> {
            if (isSuffix5) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 4, mBinding.tvBootsSuffix5);
                isSuffix5 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 4, mBinding.tvBootsSuffix5);
                isSuffix5 = true;
            }
        });

        mBinding.tvBootsSuffix6.setOnClickListener(v -> {
            if (isSuffix6) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 5, mBinding.tvBootsSuffix6);
                isSuffix6 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 5, mBinding.tvBootsSuffix6);
                isSuffix6 = true;
            }
        });

        mBinding.tvBootsSuffix7.setOnClickListener(v -> {
            if (isSuffix7) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 6, mBinding.tvBootsSuffix7);
                isSuffix7 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 6, mBinding.tvBootsSuffix7);
                isSuffix7 = true;
            }
        });

        mBinding.tvBootsSuffix8.setOnClickListener(v -> {

            if (isSuffix8) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 7, mBinding.tvBootsSuffix8);
                isSuffix8 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 7, mBinding.tvBootsSuffix8);
                isSuffix8 = true;
            }
        });

        mBinding.tvBootsSuffix9.setOnClickListener(v -> {

            if (isSuffix9) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 8, mBinding.tvBootsSuffix9);
                isSuffix9 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 8, mBinding.tvBootsSuffix9);
                isSuffix9 = true;
            }
        });

        mBinding.tvBootsSuffix10.setOnClickListener(v -> {
            if (isSuffix10) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 9, mBinding.tvBootsSuffix10);
                isSuffix10 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 9, mBinding.tvBootsSuffix10);
                isSuffix10 = true;
            }
        });

//        mBinding.tvBootsSuffix11.setOnClickListener(v -> {
//            if (isSuffix11) {
//                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 10, mBinding.tvBootsSuffix11);
//                isSuffix11 = false;
//            } else {
//                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 10, mBinding.tvBootsSuffix11);
//                isSuffix11 = true;
//            }
//        });
//
//        mBinding.tvBootsSuffix12.setOnClickListener(v -> {
//            if (isSuffix12) {
//                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 11, mBinding.tvBootsSuffix12);
//                isSuffix12 = false;
//            } else {
//                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 11, mBinding.tvBootsSuffix12);
//                isSuffix12 = true;
//            }
//        });
//
//        mBinding.tvBootsSuffix13.setOnClickListener(v -> {
//            if (isSuffix13) {
//                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 12, mBinding.tvBootsSuffix13);
//                isSuffix13 = false;
//            } else {
//                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 12, mBinding.tvBootsSuffix13);
//                isSuffix13 = true;
//            }
//        });
//
//        mBinding.tvBootsSuffix14.setOnClickListener(v -> {
//            if (isSuffix14) {
//                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 13, mBinding.tvBootsSuffix14);
//                isSuffix14 = false;
//            } else {
//                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 13, mBinding.tvBootsSuffix14);
//                isSuffix14 = true;
//            }
//        });
//
//        mBinding.tvBootsSuffix15.setOnClickListener(v -> {
//            if (isSuffix15) {
//                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 14, mBinding.tvBootsSuffix15);
//                isSuffix15 = false;
//            } else {
//                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 14, mBinding.tvBootsSuffix15);
//                isSuffix15 = true;
//            }
//        });
//
//        mBinding.tvBootsSuffix16.setOnClickListener(v -> {
//            if (isSuffix16) {
//                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 15, mBinding.tvBootsSuffix16);
//                isSuffix16 = false;
//            } else {
//                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 15, mBinding.tvBootsSuffix16);
//                isSuffix16 = true;
//            }
//        });
//
//        mBinding.tvBootsSuffix17.setOnClickListener(v -> {
//            if (isSuffix17) {
//                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 16, mBinding.tvBootsSuffix17);
//                isSuffix17 = false;
//            } else {
//                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 16, mBinding.tvBootsSuffix17);
//                isSuffix17 = true;
//            }
//        });
//
//        mBinding.tvBootsSuffix18.setOnClickListener(v -> {
//            if (isSuffix18) {
//                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 17, mBinding.tvBootsSuffix18);
//                isSuffix18 = false;
//            } else {
//                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 17, mBinding.tvBootsSuffix18);
//                isSuffix18 = true;
//            }
//        });
//
//        mBinding.tvBootsSuffix19.setOnClickListener(v -> {
//            if (isSuffix19) {
//                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 18, mBinding.tvBootsSuffix19);
//                isSuffix19 = false;
//            } else {
//                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 18, mBinding.tvBootsSuffix19);
//                isSuffix19 = true;
//            }
//        });
//
//        mBinding.tvBootsSuffix20.setOnClickListener(v -> {
//            if (isSuffix20) {
//                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 19, mBinding.tvBootsSuffix20);
//                isSuffix20 = false;
//            } else {
//                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 19, mBinding.tvBootsSuffix20);
//                isSuffix20 = true;
//            }
//        });
//
//        mBinding.tvBootsSuffix21.setOnClickListener(v -> {
//            if (isSuffix21) {
//                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 20, mBinding.tvBootsSuffix21);
//                isSuffix21 = false;
//            } else {
//                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 20, mBinding.tvBootsSuffix21);
//                isSuffix21 = true;
//            }
//        });
//
//        mBinding.tvBootsSuffix22.setOnClickListener(v -> {
//            if (isSuffix22) {
//                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 21, mBinding.tvBootsSuffix22);
//                isSuffix22 = false;
//            } else {
//                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 21, mBinding.tvBootsSuffix22);
//                isSuffix22 = true;
//            }
//        });

        return mBinding.getRoot();
    }
}