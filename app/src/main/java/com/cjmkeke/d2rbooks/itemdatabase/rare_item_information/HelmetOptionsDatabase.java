package com.cjmkeke.d2rbooks.itemdatabase.rare_item_information;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentHelmetOptionsDatabaseBinding;

import java.util.ArrayList;
import java.util.List;

public class HelmetOptionsDatabase extends Fragment {

    private static final String TAG = "HelmetOptionsDatabase";
    private FragmentHelmetOptionsDatabaseBinding mBinding;
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
        mBinding = FragmentHelmetOptionsDatabaseBinding.inflate(inflater, container, false);

        listPrefix.clear();
        listSuffix.clear();

        // TODO 접미사
        String[] itemSuffix = new String[]{
                getString(R.string.item_options_helmet_1_suffix), getString(R.string.item_options_helmet_2_suffix), getString(R.string.item_options_helmet_3_suffix),
                getString(R.string.item_options_helmet_4_suffix), getString(R.string.item_options_helmet_5_suffix), getString(R.string.item_options_helmet_6_suffix),
                getString(R.string.item_options_helmet_7_suffix), getString(R.string.item_options_helmet_8_suffix), getString(R.string.item_options_helmet_9_suffix),
                getString(R.string.item_options_helmet_10_suffix), getString(R.string.item_options_helmet_11_suffix), getString(R.string.item_options_helmet_12_suffix),
                getString(R.string.item_options_helmet_13_suffix), getString(R.string.item_options_helmet_14_suffix), getString(R.string.item_options_helmet_15_suffix),
                getString(R.string.item_options_helmet_16_suffix), getString(R.string.item_options_helmet_17_suffix), getString(R.string.item_options_helmet_18_suffix),
                getString(R.string.item_options_helmet_19_suffix), getString(R.string.item_options_helmet_20_suffix)
        };

        // TODO 접두사
        String[] itemPrefix = new String[]{
                getString(R.string.item_options_helmet_1_prefix), getString(R.string.item_options_helmet_2_prefix), getString(R.string.item_options_helmet_3_prefix),
                getString(R.string.item_options_helmet_4_prefix), getString(R.string.item_options_helmet_5_prefix), getString(R.string.item_options_helmet_6_prefix),
                getString(R.string.item_options_helmet_7_prefix), getString(R.string.item_options_helmet_8_prefix), getString(R.string.item_options_helmet_9_prefix),
                getString(R.string.item_options_helmet_10_prefix), getString(R.string.item_options_helmet_11_prefix), getString(R.string.item_options_helmet_12_prefix),
                getString(R.string.item_options_helmet_13_prefix), getString(R.string.item_options_helmet_14_prefix), getString(R.string.item_options_helmet_15_prefix),
                getString(R.string.item_options_helmet_16_prefix), getString(R.string.item_options_helmet_17_prefix), getString(R.string.item_options_helmet_18_prefix),
                getString(R.string.item_options_helmet_19_prefix), getString(R.string.item_options_helmet_20_prefix), getString(R.string.item_options_helmet_21_prefix),
                getString(R.string.item_options_helmet_22_prefix), getString(R.string.item_options_helmet_23_prefix)
        };

        mBinding.tvHelmetPrefix2.setSingleLine(true);    // 한줄로 표시하기
        mBinding.tvHelmetPrefix2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        mBinding.tvHelmetPrefix2.setSelected(true);      // 선택하기

        RareHideAndShow rareHideAndShow = new RareHideAndShow(getContext(), listSuffix, listPrefix, itemPrefix, itemSuffix, mBinding.tvHelmetTitle);
        rareHideAndShow.setItemType("helmet");

        mBinding.tvHelmetPrefix1.setOnClickListener(v -> {
            if (isPrefix1) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 0, mBinding.tvHelmetPrefix1);
                isPrefix1 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 0, mBinding.tvHelmetPrefix1);
                isPrefix1 = true;
            }
        });

        mBinding.tvHelmetPrefix2.setOnClickListener(v -> {
            if (isPrefix2) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 1, mBinding.tvHelmetPrefix2);
                isPrefix2 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 1, mBinding.tvHelmetPrefix2);
                isPrefix2 = true;
            }

        });

        mBinding.tvHelmetPrefix3.setOnClickListener(v -> {
            if (isPrefix3) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 2, mBinding.tvHelmetPrefix3);
                isPrefix3 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 2, mBinding.tvHelmetPrefix3);
                isPrefix3 = true;
            }
        });

        mBinding.tvHelmetPrefix4.setOnClickListener(v -> {
            if (isPrefix4) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 3, mBinding.tvHelmetPrefix4);
                isPrefix4 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 3, mBinding.tvHelmetPrefix4);
                isPrefix4 = true;
            }
        });

        mBinding.tvHelmetPrefix5.setOnClickListener(v -> {
            if (isPrefix5) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 4, mBinding.tvHelmetPrefix5);
                isPrefix5 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 4, mBinding.tvHelmetPrefix5);
                isPrefix5 = true;
            }
        });

        mBinding.tvHelmetPrefix6.setOnClickListener(v -> {
            if (isPrefix6) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 5, mBinding.tvHelmetPrefix6);
                isPrefix6 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 5, mBinding.tvHelmetPrefix6);
                isPrefix6 = true;
            }
        });

        mBinding.tvHelmetPrefix7.setOnClickListener(v -> {
            if (isPrefix7) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 6, mBinding.tvHelmetPrefix7);
                isPrefix7 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 6, mBinding.tvHelmetPrefix7);
                isPrefix7 = true;
            }
        });

        mBinding.tvHelmetPrefix8.setOnClickListener(v -> {
            if (isPrefix8) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 7, mBinding.tvHelmetPrefix8);
                isPrefix8 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 7, mBinding.tvHelmetPrefix8);
                isPrefix8 = true;
            }
        });

        mBinding.tvHelmetPrefix9.setOnClickListener(v -> {
            if (isPrefix9) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 8, mBinding.tvHelmetPrefix9);
                isPrefix9 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 8, mBinding.tvHelmetPrefix9);
                isPrefix9 = true;
            }
        });

        mBinding.tvHelmetPrefix10.setOnClickListener(v -> {
            if (isPrefix10) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 9, mBinding.tvHelmetPrefix10);
                isPrefix10 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 9, mBinding.tvHelmetPrefix10);
                isPrefix10 = true;
            }
        });

        mBinding.tvHelmetPrefix11.setOnClickListener(v -> {
            if (isPrefix11) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 10, mBinding.tvHelmetPrefix11);
                isPrefix11 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 10, mBinding.tvHelmetPrefix11);
                isPrefix11 = true;
            }
        });

        mBinding.tvHelmetPrefix12.setOnClickListener(v -> {
            if (isPrefix12) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 11, mBinding.tvHelmetPrefix12);
                isPrefix12 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 11, mBinding.tvHelmetPrefix12);
                isPrefix12 = true;
            }
        });

        mBinding.tvHelmetPrefix13.setOnClickListener(v -> {
            if (isPrefix13) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 12, mBinding.tvHelmetPrefix13);
                isPrefix13 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 12, mBinding.tvHelmetPrefix13);
                isPrefix13 = true;
            }
        });

        mBinding.tvHelmetPrefix14.setOnClickListener(v -> {
            if (isPrefix14) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 13, mBinding.tvHelmetPrefix14);
                isPrefix14 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 13, mBinding.tvHelmetPrefix14);
                isPrefix14 = true;
            }
        });

        mBinding.tvHelmetPrefix15.setOnClickListener(v -> {
            if (isPrefix15) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 14, mBinding.tvHelmetPrefix15);
                isPrefix15 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 14, mBinding.tvHelmetPrefix15);
                isPrefix15 = true;
            }
        });

        mBinding.tvHelmetPrefix16.setOnClickListener(v -> {
            if (isPrefix16) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 15, mBinding.tvHelmetPrefix16);
                isPrefix16 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 15, mBinding.tvHelmetPrefix16);
                isPrefix16 = true;
            }
        });

        mBinding.tvHelmetPrefix17.setOnClickListener(v -> {
            if (isPrefix17) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 16, mBinding.tvHelmetPrefix17);
                isPrefix17 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 16, mBinding.tvHelmetPrefix17);
                isPrefix17 = true;
            }
        });

        mBinding.tvHelmetPrefix18.setOnClickListener(v -> {
            if (isPrefix18) {
                mBinding.tvHelmetPrefix19.setClickable(false);
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 17, mBinding.tvHelmetPrefix18);
                isPrefix18 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 17, mBinding.tvHelmetPrefix18);
                isPrefix18 = true;
                mBinding.tvHelmetPrefix19.setClickable(true);
            }
        });

        mBinding.tvHelmetPrefix19.setOnClickListener(v -> {
            if (isPrefix19) {
                mBinding.tvHelmetPrefix18.setClickable(false);
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 18, mBinding.tvHelmetPrefix19);
                isPrefix19 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 18, mBinding.tvHelmetPrefix19);
                isPrefix19 = true;
                mBinding.tvHelmetPrefix18.setClickable(true);
            }
        });

        mBinding.tvHelmetPrefix20.setOnClickListener(v -> {
            if (isPrefix20) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 19, mBinding.tvHelmetPrefix20);
                isPrefix20 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 19, mBinding.tvHelmetPrefix20);
                isPrefix20 = true;
            }
        });

        mBinding.tvHelmetPrefix21.setOnClickListener(v -> {
            if (isPrefix21) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 20, mBinding.tvHelmetPrefix21);
                isPrefix21 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 20, mBinding.tvHelmetPrefix21);
                isPrefix21 = true;
            }
        });

        mBinding.tvHelmetPrefix22.setOnClickListener(v -> {
            if (isPrefix22) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 21, mBinding.tvHelmetPrefix22);
                isPrefix22 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 21, mBinding.tvHelmetPrefix22);
                isPrefix22 = true;
            }
        });

        mBinding.tvHelmetPrefix23.setOnClickListener(v -> {
            if (isPrefix23) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 22, mBinding.tvHelmetPrefix23);
                isPrefix23 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 22, mBinding.tvHelmetPrefix23);
                isPrefix23 = true;
            }
        });

        // TODO SUFFIX
        mBinding.tvHelmetSuffix1.setOnClickListener(v -> {
            if (isSuffix1) {
                Log.w(TAG, itemSuffix[0]);
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 0, mBinding.tvHelmetSuffix1);
                isSuffix1 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 0, mBinding.tvHelmetSuffix1);
                isSuffix1 = true;
            }
        });

        mBinding.tvHelmetSuffix2.setOnClickListener(v -> {
            if (isSuffix2) {
                Log.w(TAG, itemSuffix[1]);
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 1, mBinding.tvHelmetSuffix2);
                isSuffix2 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 1, mBinding.tvHelmetSuffix2);
                isSuffix2 = true;
            }
        });

        mBinding.tvHelmetSuffix3.setOnClickListener(v -> {
            if (isSuffix3) {
                Log.w(TAG, itemSuffix[2]);
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 2, mBinding.tvHelmetSuffix3);
                isSuffix3 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 2, mBinding.tvHelmetSuffix3);
                isSuffix3 = true;
            }
        });

        mBinding.tvHelmetSuffix4.setOnClickListener(v -> {
            if (isSuffix4) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 3, mBinding.tvHelmetSuffix4);
                isSuffix4 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 3, mBinding.tvHelmetSuffix4);
                isSuffix4 = true;
            }
        });

        mBinding.tvHelmetSuffix5.setOnClickListener(v -> {
            if (isSuffix5) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 4, mBinding.tvHelmetSuffix5);
                isSuffix5 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 4, mBinding.tvHelmetSuffix5);
                isSuffix5 = true;
            }
        });

        mBinding.tvHelmetSuffix6.setOnClickListener(v -> {
            if (isSuffix6) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 5, mBinding.tvHelmetSuffix6);
                isSuffix6 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 5, mBinding.tvHelmetSuffix6);
                isSuffix6 = true;
            }
        });

        mBinding.tvHelmetSuffix7.setOnClickListener(v -> {
            if (isSuffix7) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 6, mBinding.tvHelmetSuffix7);
                isSuffix7 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 6, mBinding.tvHelmetSuffix7);
                isSuffix7 = true;
            }
        });

        mBinding.tvHelmetSuffix8.setOnClickListener(v -> {

            if (isSuffix8) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 7, mBinding.tvHelmetSuffix8);
                isSuffix8 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 7, mBinding.tvHelmetSuffix8);
                isSuffix8 = true;
            }
        });

        mBinding.tvHelmetSuffix9.setOnClickListener(v -> {

            if (isSuffix9) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 8, mBinding.tvHelmetSuffix9);
                isSuffix9 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 8, mBinding.tvHelmetSuffix9);
                isSuffix9 = true;
            }
        });

        mBinding.tvHelmetSuffix10.setOnClickListener(v -> {
            if (isSuffix10) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 9, mBinding.tvHelmetSuffix10);
                isSuffix10 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 9, mBinding.tvHelmetSuffix10);
                isSuffix10 = true;
            }
        });

        mBinding.tvHelmetSuffix11.setOnClickListener(v -> {
            if (isSuffix11) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 10, mBinding.tvHelmetSuffix11);
                isSuffix11 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 10, mBinding.tvHelmetSuffix11);
                isSuffix11 = true;
            }
        });

        mBinding.tvHelmetSuffix12.setOnClickListener(v -> {
            if (isSuffix12) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 11, mBinding.tvHelmetSuffix12);
                isSuffix12 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 11, mBinding.tvHelmetSuffix12);
                isSuffix12 = true;
            }
        });

        mBinding.tvHelmetSuffix13.setOnClickListener(v -> {
            if (isSuffix13) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 12, mBinding.tvHelmetSuffix13);
                isSuffix13 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 12, mBinding.tvHelmetSuffix13);
                isSuffix13 = true;
            }
        });

        mBinding.tvHelmetSuffix14.setOnClickListener(v -> {
            if (isSuffix14) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 13, mBinding.tvHelmetSuffix14);
                isSuffix14 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 13, mBinding.tvHelmetSuffix14);
                isSuffix14 = true;
            }
        });

        mBinding.tvHelmetSuffix15.setOnClickListener(v -> {
            if (isSuffix15) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 14, mBinding.tvHelmetSuffix15);
                isSuffix15 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 14, mBinding.tvHelmetSuffix15);
                isSuffix15 = true;
            }
        });

        mBinding.tvHelmetSuffix16.setOnClickListener(v -> {
            if (isSuffix16) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 15, mBinding.tvHelmetSuffix16);
                isSuffix16 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 15, mBinding.tvHelmetSuffix16);
                isSuffix16 = true;
            }
        });

        mBinding.tvHelmetSuffix17.setOnClickListener(v -> {
            if (isSuffix17) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 16, mBinding.tvHelmetSuffix17);
                isSuffix17 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 16, mBinding.tvHelmetSuffix17);
                isSuffix17 = true;
            }
        });

        mBinding.tvHelmetSuffix18.setOnClickListener(v -> {
            if (isSuffix18) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 17, mBinding.tvHelmetSuffix18);
                isSuffix18 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 17, mBinding.tvHelmetSuffix18);
                isSuffix18 = true;
            }
        });

        mBinding.tvHelmetSuffix19.setOnClickListener(v -> {
            if (isSuffix19) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 18, mBinding.tvHelmetSuffix19);
                isSuffix19 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 18, mBinding.tvHelmetSuffix19);
                isSuffix19 = true;
            }
        });

        mBinding.tvHelmetSuffix20.setOnClickListener(v -> {
            if (isSuffix20) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 19, mBinding.tvHelmetSuffix20);
                isSuffix20 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 19, mBinding.tvHelmetSuffix20);
                isSuffix20 = true;
            }
        });

//        mBinding.tvHelmetSuffix21.setOnClickListener(v -> {
//            if (isSuffix21) {
//                hideAndShow.addSuffix(listSuffix, itemSuffix, 20, mBinding.tvHelmetSuffix21);
//                isSuffix21 = false;
//            } else {
//                hideAndShow.removeSuffix(listSuffix, itemSuffix, 20, mBinding.tvHelmetSuffix21);
//                isSuffix21 = true;
//            }
//        });
//
//        mBinding.tvHelmetSuffix22.setOnClickListener(v -> {
//            if (isSuffix22) {
//                hideAndShow.addSuffix(listSuffix, itemSuffix, 21, mBinding.tvHelmetSuffix22);
//                isSuffix22 = false;
//            } else {
//                hideAndShow.addSuffix(listSuffix, itemSuffix, 21, mBinding.tvHelmetSuffix22);
//                isSuffix22 = true;
//            }
//        });


        return mBinding.getRoot();
    }

}