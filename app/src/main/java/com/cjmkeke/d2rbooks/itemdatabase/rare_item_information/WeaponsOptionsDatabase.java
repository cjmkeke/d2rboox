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
import com.cjmkeke.d2rbooks.databinding.FragmentWeaponsOptionsDatabaseBinding;

import java.util.ArrayList;
import java.util.List;

public class WeaponsOptionsDatabase extends Fragment {

    private FragmentWeaponsOptionsDatabaseBinding mBinding;
    private static final String TAG = "WeaponsOptionsDatabase";
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
        mBinding = FragmentWeaponsOptionsDatabaseBinding.inflate(inflater, container, false);

        listPrefix.clear();
        listSuffix.clear();

        // TODO 접미사
        String[] itemSuffix = new String[]{
                getString(R.string.item_options_weapons_1_suffix), getString(R.string.item_options_weapons_2_suffix), getString(R.string.item_options_weapons_3_suffix),
                getString(R.string.item_options_weapons_4_suffix), getString(R.string.item_options_weapons_5_suffix), getString(R.string.item_options_weapons_6_suffix),
                getString(R.string.item_options_weapons_7_suffix), getString(R.string.item_options_weapons_8_suffix), getString(R.string.item_options_weapons_9_suffix),
                getString(R.string.item_options_weapons_10_suffix), getString(R.string.item_options_weapons_11_suffix), getString(R.string.item_options_weapons_12_suffix),
                getString(R.string.item_options_weapons_13_suffix), getString(R.string.item_options_weapons_14_suffix), getString(R.string.item_options_weapons_15_suffix),
                getString(R.string.item_options_weapons_16_suffix), getString(R.string.item_options_weapons_17_suffix), getString(R.string.item_options_weapons_18_suffix),
                getString(R.string.item_options_weapons_19_suffix), getString(R.string.item_options_weapons_20_suffix), getString(R.string.item_options_weapons_21_suffix),
                getString(R.string.item_options_weapons_22_suffix)
        };

        // TODO 접두사
        String[] itemPrefix = new String[]{
                getString(R.string.item_options_weapons_1_prefix), getString(R.string.item_options_weapons_2_prefix), getString(R.string.item_options_weapons_3_prefix),
                getString(R.string.item_options_weapons_4_prefix), getString(R.string.item_options_weapons_5_prefix), getString(R.string.item_options_weapons_6_prefix),
                getString(R.string.item_options_weapons_7_prefix), getString(R.string.item_options_weapons_8_prefix), getString(R.string.item_options_weapons_9_prefix),
                getString(R.string.item_options_weapons_10_prefix), getString(R.string.item_options_weapons_11_prefix), getString(R.string.item_options_weapons_12_prefix),
                getString(R.string.item_options_weapons_13_prefix), getString(R.string.item_options_weapons_14_prefix), getString(R.string.item_options_weapons_15_prefix),
                getString(R.string.item_options_weapons_16_prefix), getString(R.string.item_options_weapons_17_prefix), getString(R.string.item_options_weapons_18_prefix),
                getString(R.string.item_options_weapons_19_prefix), getString(R.string.item_options_weapons_20_prefix), getString(R.string.item_options_weapons_21_prefix),
                getString(R.string.item_options_weapons_22_prefix), getString(R.string.item_options_weapons_23_prefix)
        };

        RareHideAndShow rareHideAndShow = new RareHideAndShow(getContext(), listSuffix, listPrefix, itemPrefix, itemSuffix, mBinding.tvWeaponsTitle);
        rareHideAndShow.setItemType("weapons");

        mBinding.tvWeaponsPrefix1.setOnClickListener(v -> {
            if (isPrefix1) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 0, mBinding.tvWeaponsPrefix1);
                isPrefix1 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 0, mBinding.tvWeaponsPrefix1);
                isPrefix1 = true;
            }
        });

        mBinding.tvWeaponsPrefix2.setOnClickListener(v -> {
            if (isPrefix2) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 1, mBinding.tvWeaponsPrefix2);
                isPrefix2 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 1, mBinding.tvWeaponsPrefix2);
                isPrefix2 = true;
            }

        });

        mBinding.tvWeaponsPrefix3.setOnClickListener(v -> {
            if (isPrefix3) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 2, mBinding.tvWeaponsPrefix3);
                isPrefix3 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 2, mBinding.tvWeaponsPrefix3);
                isPrefix3 = true;
            }
        });

        mBinding.tvWeaponsPrefix4.setOnClickListener(v -> {
            if (isPrefix4) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 3, mBinding.tvWeaponsPrefix4);
                isPrefix4 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 3, mBinding.tvWeaponsPrefix4);
                isPrefix4 = true;
            }
        });

        mBinding.tvWeaponsPrefix5.setOnClickListener(v -> {
            if (isPrefix5) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 4, mBinding.tvWeaponsPrefix5);
                isPrefix5 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 4, mBinding.tvWeaponsPrefix5);
                isPrefix5 = true;
            }
        });

        mBinding.tvWeaponsPrefix6.setOnClickListener(v -> {
            if (isPrefix6) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 5, mBinding.tvWeaponsPrefix6);
                isPrefix6 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 5, mBinding.tvWeaponsPrefix6);
                isPrefix6 = true;
            }
        });

        mBinding.tvWeaponsPrefix7.setOnClickListener(v -> {
            if (isPrefix7) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 6, mBinding.tvWeaponsPrefix7);
                isPrefix7 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 6, mBinding.tvWeaponsPrefix7);
                isPrefix7 = true;
            }
        });

        mBinding.tvWeaponsPrefix8.setOnClickListener(v -> {
            if (isPrefix8) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 7, mBinding.tvWeaponsPrefix8);
                isPrefix8 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 7, mBinding.tvWeaponsPrefix8);
                isPrefix8 = true;
            }
        });

        mBinding.tvWeaponsPrefix9.setOnClickListener(v -> {
            if (isPrefix9) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 8, mBinding.tvWeaponsPrefix9);
                isPrefix9 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 8, mBinding.tvWeaponsPrefix9);
                isPrefix9 = true;
            }
        });

        mBinding.tvWeaponsPrefix10.setOnClickListener(v -> {
            if (isPrefix10) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 9, mBinding.tvWeaponsPrefix10);
                isPrefix10 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 9, mBinding.tvWeaponsPrefix10);
                isPrefix10 = true;
            }
        });

        mBinding.tvWeaponsPrefix11.setOnClickListener(v -> {
            if (isPrefix11) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 10, mBinding.tvWeaponsPrefix11);
                isPrefix11 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 10, mBinding.tvWeaponsPrefix11);
                isPrefix11 = true;
            }
        });

        mBinding.tvWeaponsPrefix12.setOnClickListener(v -> {
            if (isPrefix12) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 11, mBinding.tvWeaponsPrefix12);
                isPrefix12 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 11, mBinding.tvWeaponsPrefix12);
                isPrefix12 = true;
            }
        });

        mBinding.tvWeaponsPrefix13.setOnClickListener(v -> {
            if (isPrefix13) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 12, mBinding.tvWeaponsPrefix13);
                isPrefix13 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 12, mBinding.tvWeaponsPrefix13);
                isPrefix13 = true;
            }
        });

        mBinding.tvWeaponsPrefix14.setOnClickListener(v -> {
            if (isPrefix14) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 13, mBinding.tvWeaponsPrefix14);
                isPrefix14 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 13, mBinding.tvWeaponsPrefix14);
                isPrefix14 = true;
            }
        });

        mBinding.tvWeaponsPrefix15.setOnClickListener(v -> {
            if (isPrefix15) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 14, mBinding.tvWeaponsPrefix15);
                isPrefix15 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 14, mBinding.tvWeaponsPrefix15);
                isPrefix15 = true;
            }
        });

        mBinding.tvWeaponsPrefix16.setOnClickListener(v -> {
            if (isPrefix16) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 15, mBinding.tvWeaponsPrefix16);
                isPrefix16 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 15, mBinding.tvWeaponsPrefix16);
                isPrefix16 = true;
            }
        });

        mBinding.tvWeaponsPrefix17.setOnClickListener(v -> {
            if (isPrefix17) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 16, mBinding.tvWeaponsPrefix17);
                isPrefix17 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 16, mBinding.tvWeaponsPrefix17);
                isPrefix17 = true;
            }
        });

        mBinding.tvWeaponsPrefix18.setOnClickListener(v -> {
            if (isPrefix18) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 17, mBinding.tvWeaponsPrefix18);
                isPrefix18 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 17, mBinding.tvWeaponsPrefix18);
                isPrefix18 = true;
            }
        });

        mBinding.tvWeaponsPrefix19.setOnClickListener(v -> {
            if (isPrefix19) {
                mBinding.tvWeaponsPrefix20.setClickable(false);
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 18, mBinding.tvWeaponsPrefix19);
                isPrefix19 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 18, mBinding.tvWeaponsPrefix19);
                isPrefix19 = true;
                mBinding.tvWeaponsPrefix20.setClickable(true);
            }
        });

        mBinding.tvWeaponsPrefix20.setOnClickListener(v -> {
            if (isPrefix20) {
                mBinding.tvWeaponsPrefix19.setClickable(false);
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 19, mBinding.tvWeaponsPrefix20);
                isPrefix20 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 19, mBinding.tvWeaponsPrefix20);
                isPrefix20 = true;
                mBinding.tvWeaponsPrefix19.setClickable(true);
            }
        });

        mBinding.tvWeaponsPrefix21.setOnClickListener(v -> {
            if (isPrefix21) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 20, mBinding.tvWeaponsPrefix21);
                isPrefix21 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 20, mBinding.tvWeaponsPrefix21);
                isPrefix21 = true;
            }
        });

        mBinding.tvWeaponsPrefix22.setOnClickListener(v -> {
            if (isPrefix22) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 21, mBinding.tvWeaponsPrefix22);
                isPrefix22 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 21, mBinding.tvWeaponsPrefix22);
                isPrefix22 = true;
            }
        });

        mBinding.tvWeaponsPrefix23.setOnClickListener(v -> {
            if (isPrefix23) {
                rareHideAndShow.addPreFix(listPrefix, itemPrefix, 22, mBinding.tvWeaponsPrefix23);
                isPrefix23 = false;
            } else {
                rareHideAndShow.removePreFix(listPrefix, itemPrefix, 22, mBinding.tvWeaponsPrefix23);
                isPrefix23 = true;
            }
        });

        // TODO SUFFIX
        mBinding.tvWeaponsSuffix1.setOnClickListener(v -> {
            if (isSuffix1) {
                Log.w(TAG, itemSuffix[0]);
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 0, mBinding.tvWeaponsSuffix1);
                isSuffix1 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 0, mBinding.tvWeaponsSuffix1);
                isSuffix1 = true;
            }
        });

        mBinding.tvWeaponsSuffix2.setOnClickListener(v -> {
            if (isSuffix2) {
                Log.w(TAG, itemSuffix[1]);
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 1, mBinding.tvWeaponsSuffix2);
                isSuffix2 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 1, mBinding.tvWeaponsSuffix2);
                isSuffix2 = true;
            }
        });

        mBinding.tvWeaponsSuffix3.setOnClickListener(v -> {
            if (isSuffix3) {
                Log.w(TAG, itemSuffix[2]);
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 2, mBinding.tvWeaponsSuffix3);
                isSuffix3 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 2, mBinding.tvWeaponsSuffix3);
                isSuffix3 = true;
            }
        });

        mBinding.tvWeaponsSuffix4.setOnClickListener(v -> {
            if (isSuffix4) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 3, mBinding.tvWeaponsSuffix4);
                isSuffix4 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 3, mBinding.tvWeaponsSuffix4);
                isSuffix4 = true;
            }
        });

        mBinding.tvWeaponsSuffix5.setOnClickListener(v -> {
            if (isSuffix5) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 4, mBinding.tvWeaponsSuffix5);
                isSuffix5 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 4, mBinding.tvWeaponsSuffix5);
                isSuffix5 = true;
            }
        });

        mBinding.tvWeaponsSuffix6.setOnClickListener(v -> {
            if (isSuffix6) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 5, mBinding.tvWeaponsSuffix6);
                isSuffix6 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 5, mBinding.tvWeaponsSuffix6);
                isSuffix6 = true;
            }
        });

        mBinding.tvWeaponsSuffix7.setOnClickListener(v -> {
            if (isSuffix7) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 6, mBinding.tvWeaponsSuffix7);
                isSuffix7 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 6, mBinding.tvWeaponsSuffix7);
                isSuffix7 = true;
            }
        });

        mBinding.tvWeaponsSuffix8.setOnClickListener(v -> {

            if (isSuffix8) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 7, mBinding.tvWeaponsSuffix8);
                isSuffix8 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 7, mBinding.tvWeaponsSuffix8);
                isSuffix8 = true;
            }
        });

        mBinding.tvWeaponsSuffix9.setOnClickListener(v -> {

            if (isSuffix9) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 8, mBinding.tvWeaponsSuffix9);
                isSuffix9 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 8, mBinding.tvWeaponsSuffix9);
                isSuffix9 = true;
            }
        });

        mBinding.tvWeaponsSuffix10.setOnClickListener(v -> {
            if (isSuffix10) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 9, mBinding.tvWeaponsSuffix10);
                isSuffix10 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 9, mBinding.tvWeaponsSuffix10);
                isSuffix10 = true;
            }
        });

        mBinding.tvWeaponsSuffix11.setOnClickListener(v -> {
            if (isSuffix11) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 10, mBinding.tvWeaponsSuffix11);
                isSuffix11 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 10, mBinding.tvWeaponsSuffix11);
                isSuffix11 = true;
            }
        });

        mBinding.tvWeaponsSuffix12.setOnClickListener(v -> {
            if (isSuffix12) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 11, mBinding.tvWeaponsSuffix12);
                isSuffix12 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 11, mBinding.tvWeaponsSuffix12);
                isSuffix12 = true;
            }
        });

        mBinding.tvWeaponsSuffix13.setOnClickListener(v -> {
            if (isSuffix13) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 12, mBinding.tvWeaponsSuffix13);
                isSuffix13 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 12, mBinding.tvWeaponsSuffix13);
                isSuffix13 = true;
            }
        });

        mBinding.tvWeaponsSuffix14.setOnClickListener(v -> {
            if (isSuffix14) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 13, mBinding.tvWeaponsSuffix14);
                isSuffix14 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 13, mBinding.tvWeaponsSuffix14);
                isSuffix14 = true;
            }
        });

        mBinding.tvWeaponsSuffix15.setOnClickListener(v -> {
            if (isSuffix15) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 14, mBinding.tvWeaponsSuffix15);
                isSuffix15 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 14, mBinding.tvWeaponsSuffix15);
                isSuffix15 = true;
            }
        });

        mBinding.tvWeaponsSuffix16.setOnClickListener(v -> {
            if (isSuffix16) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 15, mBinding.tvWeaponsSuffix16);
                isSuffix16 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 15, mBinding.tvWeaponsSuffix16);
                isSuffix16 = true;
            }
        });

        mBinding.tvWeaponsSuffix17.setOnClickListener(v -> {
            if (isSuffix17) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 16, mBinding.tvWeaponsSuffix17);
                isSuffix17 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 16, mBinding.tvWeaponsSuffix17);
                isSuffix17 = true;
            }
        });

        mBinding.tvWeaponsSuffix18.setOnClickListener(v -> {
            if (isSuffix18) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 17, mBinding.tvWeaponsSuffix18);
                isSuffix18 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 17, mBinding.tvWeaponsSuffix18);
                isSuffix18 = true;
            }
        });

        mBinding.tvWeaponsSuffix19.setOnClickListener(v -> {
            if (isSuffix19) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 18, mBinding.tvWeaponsSuffix19);
                isSuffix19 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 18, mBinding.tvWeaponsSuffix19);
                isSuffix19 = true;
            }
        });

        mBinding.tvWeaponsSuffix20.setOnClickListener(v -> {
            if (isSuffix20) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 19, mBinding.tvWeaponsSuffix20);
                isSuffix20 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 19, mBinding.tvWeaponsSuffix20);
                isSuffix20 = true;
            }
        });

        mBinding.tvWeaponsSuffix21.setOnClickListener(v -> {
            if (isSuffix21) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 20, mBinding.tvWeaponsSuffix21);
                isSuffix21 = false;
            } else {
                rareHideAndShow.removeSuffix(listSuffix, itemSuffix, 20, mBinding.tvWeaponsSuffix21);
                isSuffix21 = true;
            }
        });

        mBinding.tvWeaponsSuffix22.setOnClickListener(v -> {
            if (isSuffix22) {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 21, mBinding.tvWeaponsSuffix22);
                isSuffix22 = false;
            } else {
                rareHideAndShow.addSuffix(listSuffix, itemSuffix, 21, mBinding.tvWeaponsSuffix22);
                isSuffix22 = true;
            }
        });


        return mBinding.getRoot();
    }
}