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
import com.cjmkeke.d2rbooks.databinding.FragmentGloveOptionsDatabaseBinding;

import java.util.ArrayList;
import java.util.List;

public class GloveOptionsDatabase extends Fragment {

    private FragmentGloveOptionsDatabaseBinding mBinding;
    private static final String TAG = "GloveOptionsDatabase";
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
        mBinding = FragmentGloveOptionsDatabaseBinding.inflate(inflater, container, false);

        listPrefix.clear();
        listSuffix.clear();

        // TODO 접미사
        String[] itemSuffix = new String[]{
                getString(R.string.item_options_glove_1_suffix), getString(R.string.item_options_glove_2_suffix), getString(R.string.item_options_glove_3_suffix),
                getString(R.string.item_options_glove_4_suffix), getString(R.string.item_options_glove_5_suffix), getString(R.string.item_options_glove_6_suffix),
                getString(R.string.item_options_glove_7_suffix), getString(R.string.item_options_glove_8_suffix), getString(R.string.item_options_glove_9_suffix),
                getString(R.string.item_options_glove_10_suffix), getString(R.string.item_options_glove_11_suffix), getString(R.string.item_options_glove_12_suffix),
                getString(R.string.item_options_glove_13_suffix), getString(R.string.item_options_glove_14_suffix), getString(R.string.item_options_glove_15_suffix),
                getString(R.string.item_options_glove_16_suffix), getString(R.string.item_options_glove_17_suffix), getString(R.string.item_options_glove_18_suffix),
                getString(R.string.item_options_glove_19_suffix), getString(R.string.item_options_glove_20_suffix), getString(R.string.item_options_glove_21_suffix),
                getString(R.string.item_options_glove_22_suffix)
        };

        // TODO 접두사
        String[] itemPrefix = new String[]{
                getString(R.string.item_options_glove_1_prefix), getString(R.string.item_options_glove_2_prefix), getString(R.string.item_options_glove_3_prefix),
                getString(R.string.item_options_glove_4_prefix), getString(R.string.item_options_glove_5_prefix), getString(R.string.item_options_glove_6_prefix),
                getString(R.string.item_options_glove_7_prefix), getString(R.string.item_options_glove_8_prefix), getString(R.string.item_options_glove_9_prefix),
                getString(R.string.item_options_glove_10_prefix), getString(R.string.item_options_glove_11_prefix), getString(R.string.item_options_glove_12_prefix),
                getString(R.string.item_options_glove_13_prefix), getString(R.string.item_options_glove_14_prefix), getString(R.string.item_options_glove_15_prefix),
                getString(R.string.item_options_glove_16_prefix), getString(R.string.item_options_glove_17_prefix), getString(R.string.item_options_glove_18_prefix),
                getString(R.string.item_options_glove_19_prefix), getString(R.string.item_options_glove_20_prefix), getString(R.string.item_options_glove_21_prefix),
                getString(R.string.item_options_glove_22_prefix), getString(R.string.item_options_glove_23_prefix)
        };

        RareHideAndShow rareHideAndShow = new RareHideAndShow(getContext(), listSuffix, listPrefix, itemPrefix, itemSuffix, mBinding.tvGloveTitle);
        rareHideAndShow.setItemType("glove");

        mBinding.tvGlovePrefix1.setOnClickListener(v -> {
            if (isPrefix1) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 0, mBinding.tvGlovePrefix1);
                isPrefix1 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 0, mBinding.tvGlovePrefix1);
                isPrefix1 = true;
            }
        });

        mBinding.tvGlovePrefix2.setOnClickListener(v -> {
            if (isPrefix2) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 1, mBinding.tvGlovePrefix2);
                isPrefix2 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 1, mBinding.tvGlovePrefix2);
                isPrefix2 = true;
            }

        });

        mBinding.tvGlovePrefix3.setOnClickListener(v -> {
            if (isPrefix3) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 2, mBinding.tvGlovePrefix3);
                isPrefix3 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 2, mBinding.tvGlovePrefix3);
                isPrefix3 = true;
            }
        });

        mBinding.tvGlovePrefix4.setOnClickListener(v -> {
            if (isPrefix4) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 3, mBinding.tvGlovePrefix4);
                isPrefix4 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 3, mBinding.tvGlovePrefix4);
                isPrefix4 = true;
            }
        });

        mBinding.tvGlovePrefix5.setOnClickListener(v -> {
            if (isPrefix5) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 4, mBinding.tvGlovePrefix5);
                isPrefix5 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 4, mBinding.tvGlovePrefix5);
                isPrefix5 = true;
            }
        });

        mBinding.tvGlovePrefix6.setOnClickListener(v -> {
            if (isPrefix6) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 5, mBinding.tvGlovePrefix6);
                isPrefix6 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 5, mBinding.tvGlovePrefix6);
                isPrefix6 = true;
            }
        });

        mBinding.tvGlovePrefix7.setOnClickListener(v -> {
            if (isPrefix7) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 6, mBinding.tvGlovePrefix7);
                isPrefix7 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 6, mBinding.tvGlovePrefix7);
                isPrefix7 = true;
            }
        });

        mBinding.tvGlovePrefix8.setOnClickListener(v -> {
            if (isPrefix8) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 7, mBinding.tvGlovePrefix8);
                isPrefix8 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 7, mBinding.tvGlovePrefix8);
                isPrefix8 = true;
            }
        });

        mBinding.tvGlovePrefix9.setOnClickListener(v -> {
            if (isPrefix9) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 8, mBinding.tvGlovePrefix9);
                isPrefix9 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 8, mBinding.tvGlovePrefix9);
                isPrefix9 = true;
            }
        });

        mBinding.tvGlovePrefix10.setOnClickListener(v -> {
            if (isPrefix10) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 9, mBinding.tvGlovePrefix10);
                isPrefix10 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 9, mBinding.tvGlovePrefix10);
                isPrefix10 = true;
            }
        });

        mBinding.tvGlovePrefix11.setOnClickListener(v -> {
            if (isPrefix11) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 10, mBinding.tvGlovePrefix11);
                isPrefix11 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 10, mBinding.tvGlovePrefix11);
                isPrefix11 = true;
            }
        });

        mBinding.tvGlovePrefix12.setOnClickListener(v -> {
            if (isPrefix12) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 11, mBinding.tvGlovePrefix12);
                isPrefix12 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 11, mBinding.tvGlovePrefix12);
                isPrefix12 = true;
            }
        });

//        mBinding.tvGlovePrefix13.setOnClickListener(v -> {
//            if (isPrefix13) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 12, mBinding.tvGlovePrefix13);
//                isPrefix13 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 12, mBinding.tvGlovePrefix13);
//                isPrefix13 = true;
//            }
//        });

//        mBinding.tvGlovePrefix14.setOnClickListener(v -> {
//            if (isPrefix14) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 13, mBinding.tvGlovePrefix14);
//                isPrefix14 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 13, mBinding.tvGlovePrefix14);
//                isPrefix14 = true;
//            }
//        });
//
//        mBinding.tvGlovePrefix15.setOnClickListener(v -> {
//            if (isPrefix15) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 14, mBinding.tvGlovePrefix15);
//                isPrefix15 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 14, mBinding.tvGlovePrefix15);
//                isPrefix15 = true;
//            }
//        });
//
//        mBinding.tvGlovePrefix16.setOnClickListener(v -> {
//            if (isPrefix16) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 15, mBinding.tvGlovePrefix16);
//                isPrefix16 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 15, mBinding.tvGlovePrefix16);
//                isPrefix16 = true;
//            }
//        });
//
//        mBinding.tvGlovePrefix17.setOnClickListener(v -> {
//            if (isPrefix17) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 16, mBinding.tvGlovePrefix17);
//                isPrefix17 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 16, mBinding.tvGlovePrefix17);
//                isPrefix17 = true;
//            }
//        });
//
//        mBinding.tvGlovePrefix18.setOnClickListener(v -> {
//            if (isPrefix18) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 17, mBinding.tvGlovePrefix18);
//                isPrefix18 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 17, mBinding.tvGlovePrefix18);
//                isPrefix18 = true;
//            }
//        });
//
//        mBinding.tvGlovePrefix19.setOnClickListener(v -> {
//            if (isPrefix19) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 18, mBinding.tvGlovePrefix19);
//                isPrefix19 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 18, mBinding.tvGlovePrefix19);
//                isPrefix19 = true;
//            }
//        });
//
//        mBinding.tvGlovePrefix20.setOnClickListener(v -> {
//            if (isPrefix20) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 19, mBinding.tvGlovePrefix20);
//                isPrefix20 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 19, mBinding.tvGlovePrefix20);
//                isPrefix20 = true;
//            }
//        });
//
//        mBinding.tvGlovePrefix21.setOnClickListener(v -> {
//            if (isPrefix21) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 20, mBinding.tvGlovePrefix21);
//                isPrefix21 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 20, mBinding.tvGlovePrefix21);
//                isPrefix21 = true;
//            }
//        });
//
//        mBinding.tvGlovePrefix22.setOnClickListener(v -> {
//            if (isPrefix22) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 21, mBinding.tvGlovePrefix22);
//                isPrefix22 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 21, mBinding.tvGlovePrefix22);
//                isPrefix22 = true;
//            }
//        });
//
//        mBinding.tvGlovePrefix23.setOnClickListener(v -> {
//            if (isPrefix23) {
//                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 22, mBinding.tvGlovePrefix23);
//                isPrefix23 = false;
//            } else {
//                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 22, mBinding.tvGlovePrefix23);
//                isPrefix23 = true;
//            }
//        });

        // TODO SUFFIX
        mBinding.tvGloveSuffix1.setOnClickListener(v -> {
            if (isSuffix1) {
                Log.w(TAG, itemSuffix[0]);
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 0, mBinding.tvGloveSuffix1);
                isSuffix1 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 0, mBinding.tvGloveSuffix1);
                isSuffix1 = true;
            }
        });

        mBinding.tvGloveSuffix2.setOnClickListener(v -> {
            if (isSuffix2) {
                Log.w(TAG, itemSuffix[1]);
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 1, mBinding.tvGloveSuffix2);
                isSuffix2 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 1, mBinding.tvGloveSuffix2);
                isSuffix2 = true;
            }
        });

        mBinding.tvGloveSuffix3.setOnClickListener(v -> {
            if (isSuffix3) {
                Log.w(TAG, itemSuffix[2]);
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 2, mBinding.tvGloveSuffix3);
                isSuffix3 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 2, mBinding.tvGloveSuffix3);
                isSuffix3 = true;
            }
        });

        mBinding.tvGloveSuffix4.setOnClickListener(v -> {
            if (isSuffix4) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 3, mBinding.tvGloveSuffix4);
                isSuffix4 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 3, mBinding.tvGloveSuffix4);
                isSuffix4 = true;
            }
        });

        mBinding.tvGloveSuffix5.setOnClickListener(v -> {
            if (isSuffix5) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 4, mBinding.tvGloveSuffix5);
                isSuffix5 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 4, mBinding.tvGloveSuffix5);
                isSuffix5 = true;
            }
        });

        mBinding.tvGloveSuffix6.setOnClickListener(v -> {
            if (isSuffix6) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 5, mBinding.tvGloveSuffix6);
                isSuffix6 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 5, mBinding.tvGloveSuffix6);
                isSuffix6 = true;
            }
        });

        mBinding.tvGloveSuffix7.setOnClickListener(v -> {
            if (isSuffix7) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 6, mBinding.tvGloveSuffix7);
                isSuffix7 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 6, mBinding.tvGloveSuffix7);
                isSuffix7 = true;
            }
        });

        mBinding.tvGloveSuffix8.setOnClickListener(v -> {

            if (isSuffix8) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 7, mBinding.tvGloveSuffix8);
                isSuffix8 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 7, mBinding.tvGloveSuffix8);
                isSuffix8 = true;
            }
        });

        mBinding.tvGloveSuffix9.setOnClickListener(v -> {

            if (isSuffix9) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 8, mBinding.tvGloveSuffix9);
                isSuffix9 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 8, mBinding.tvGloveSuffix9);
                isSuffix9 = true;
            }
        });

        mBinding.tvGloveSuffix10.setOnClickListener(v -> {
            if (isSuffix10) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 9, mBinding.tvGloveSuffix10);
                isSuffix10 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 9, mBinding.tvGloveSuffix10);
                isSuffix10 = true;
            }
        });

        mBinding.tvGloveSuffix11.setOnClickListener(v -> {
            if (isSuffix11) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 10, mBinding.tvGloveSuffix11);
                isSuffix11 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 10, mBinding.tvGloveSuffix11);
                isSuffix11 = true;
            }
        });

        mBinding.tvGloveSuffix12.setOnClickListener(v -> {
            if (isSuffix12) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 11, mBinding.tvGloveSuffix12);
                isSuffix12 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 11, mBinding.tvGloveSuffix12);
                isSuffix12 = true;
            }
        });

        mBinding.tvGloveSuffix13.setOnClickListener(v -> {
            if (isSuffix13) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 12, mBinding.tvGloveSuffix13);
                isSuffix13 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 12, mBinding.tvGloveSuffix13);
                isSuffix13 = true;
            }
        });

        mBinding.tvGloveSuffix14.setOnClickListener(v -> {
            if (isSuffix14) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 13, mBinding.tvGloveSuffix14);
                isSuffix14 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 13, mBinding.tvGloveSuffix14);
                isSuffix14 = true;
            }
        });

        return mBinding.getRoot();
    }
}