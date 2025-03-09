package com.cjmkeke.d2rbooks.itemdatabase.rare_item_information;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentJewelOptionsDatabaseBinding;

import java.util.ArrayList;
import java.util.List;

public class JewelOptionsDatabase extends Fragment {

    private FragmentJewelOptionsDatabaseBinding mBinding;
    private static final String TAG = "JewelOptionsDatabase";
    private SharedPreferences fontSharedPreferences;
    private boolean[] isPrefix;
    private boolean[] isSuffix;
    private RareJewelHideAndShow rareJewelHideAndShow;
    private List<String> listSuffix = new ArrayList<>();
    private List<String> listPrefix = new ArrayList<>();
    private String[] itemSuffix;
    private String[] itemPrefix;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentJewelOptionsDatabaseBinding.inflate(inflater, container, false);

        isPrefix = new boolean[31];
        isSuffix = new boolean[31];
        for (int i = 0; i < 31; i++) {
            isPrefix[i] = true;
            isSuffix[i] = true;
        }

        listPrefix.clear();
        listSuffix.clear();

        // TODO 접미사
        itemSuffix = new String[]{
                getString(R.string.item_options_jewel_1_suffix), getString(R.string.item_options_jewel_2_suffix), getString(R.string.item_options_jewel_3_suffix),
                getString(R.string.item_options_jewel_4_suffix), getString(R.string.item_options_jewel_5_suffix), getString(R.string.item_options_jewel_6_suffix),
                getString(R.string.item_options_jewel_7_suffix), getString(R.string.item_options_jewel_8_suffix), getString(R.string.item_options_jewel_9_suffix),
                getString(R.string.item_options_jewel_10_suffix), getString(R.string.item_options_jewel_11_suffix), getString(R.string.item_options_jewel_12_suffix),
                getString(R.string.item_options_jewel_13_suffix), getString(R.string.item_options_jewel_14_suffix), getString(R.string.item_options_jewel_15_suffix),
                getString(R.string.item_options_jewel_16_suffix), getString(R.string.item_options_jewel_17_suffix), getString(R.string.item_options_jewel_18_suffix),
                getString(R.string.item_options_jewel_19_suffix), getString(R.string.item_options_jewel_20_suffix), getString(R.string.item_options_jewel_21_suffix),
                getString(R.string.item_options_jewel_22_suffix)
        };

        // TODO 접두사
        itemPrefix = new String[]{
                getString(R.string.item_options_jewel_1_prefix), getString(R.string.item_options_jewel_2_prefix), getString(R.string.item_options_jewel_3_prefix),
                getString(R.string.item_options_jewel_4_prefix), getString(R.string.item_options_jewel_5_prefix), getString(R.string.item_options_jewel_6_prefix),
                getString(R.string.item_options_jewel_7_prefix), getString(R.string.item_options_jewel_8_prefix), getString(R.string.item_options_jewel_9_prefix),
                getString(R.string.item_options_jewel_10_prefix), getString(R.string.item_options_jewel_11_prefix), getString(R.string.item_options_jewel_12_prefix),
                getString(R.string.item_options_jewel_13_prefix), getString(R.string.item_options_jewel_14_prefix), getString(R.string.item_options_jewel_15_prefix),
                getString(R.string.item_options_jewel_16_prefix), getString(R.string.item_options_jewel_17_prefix), getString(R.string.item_options_jewel_18_prefix),
                getString(R.string.item_options_jewel_19_prefix), getString(R.string.item_options_jewel_20_prefix), getString(R.string.item_options_jewel_21_prefix)
        };

        rareJewelHideAndShow = new RareJewelHideAndShow(getContext(), listSuffix, listPrefix, itemPrefix, itemSuffix, mBinding.tvJewelTitle);
        rareJewelHideAndShow.setItemType("jewel");

        mBinding.tvJewelPrefix1.setOnClickListener(v -> addPrefix(isPrefix, 0, mBinding.tvJewelPrefix1));
        mBinding.tvJewelPrefix2.setOnClickListener(v -> addPrefix(isPrefix, 1, mBinding.tvJewelPrefix2));
        mBinding.tvJewelPrefix3.setOnClickListener(v -> addPrefix(isPrefix, 2, mBinding.tvJewelPrefix3));
        mBinding.tvJewelPrefix4.setOnClickListener(v -> addPrefix(isPrefix, 3, mBinding.tvJewelPrefix4));
        mBinding.tvJewelPrefix5.setOnClickListener(v -> addPrefix(isPrefix, 4, mBinding.tvJewelPrefix5));
        mBinding.tvJewelPrefix6.setOnClickListener(v -> addPrefix(isPrefix, 5, mBinding.tvJewelPrefix6));
        mBinding.tvJewelPrefix7.setOnClickListener(v -> addPrefix(isPrefix, 6, mBinding.tvJewelPrefix7));
        mBinding.tvJewelPrefix8.setOnClickListener(v -> addPrefix(isPrefix, 7, mBinding.tvJewelPrefix8));
        mBinding.tvJewelPrefix9.setOnClickListener(v -> addPrefix(isPrefix, 8, mBinding.tvJewelPrefix9));
        mBinding.tvJewelPrefix10.setOnClickListener(v -> addPrefix(isPrefix, 9, mBinding.tvJewelPrefix10));
        mBinding.tvJewelPrefix11.setOnClickListener(v -> addPrefix(isPrefix, 10, mBinding.tvJewelPrefix11));
        mBinding.tvJewelPrefix12.setOnClickListener(v -> addPrefix(isPrefix, 11, mBinding.tvJewelPrefix12));
        mBinding.tvJewelPrefix13.setOnClickListener(v -> addPrefix(isPrefix, 12, mBinding.tvJewelPrefix13));
        mBinding.tvJewelPrefix14.setOnClickListener(v -> addPrefix(isPrefix, 13, mBinding.tvJewelPrefix14));
        mBinding.tvJewelPrefix15.setOnClickListener(v -> addPrefix(isPrefix, 14, mBinding.tvJewelPrefix15));
        mBinding.tvJewelPrefix16.setOnClickListener(v -> addPrefix(isPrefix, 15, mBinding.tvJewelPrefix16));
        mBinding.tvJewelPrefix17.setOnClickListener(v -> addPrefix(isPrefix, 16, mBinding.tvJewelPrefix17));
        mBinding.tvJewelPrefix18.setOnClickListener(v -> addPrefix(isPrefix, 17, mBinding.tvJewelPrefix18));
        mBinding.tvJewelPrefix19.setOnClickListener(v -> addPrefix(isPrefix, 18, mBinding.tvJewelPrefix19));
        mBinding.tvJewelPrefix20.setOnClickListener(v -> addPrefix(isPrefix, 19, mBinding.tvJewelPrefix20));
        mBinding.tvJewelPrefix21.setOnClickListener(v -> addPrefix(isPrefix, 20, mBinding.tvJewelPrefix21));

        // TODO SUFFIX
        mBinding.tvJewelSuffix1.setOnClickListener(v -> addSuffix(isSuffix, 0, mBinding.tvJewelSuffix1));
        mBinding.tvJewelSuffix2.setOnClickListener(v -> addSuffix(isSuffix, 1, mBinding.tvJewelSuffix2));
        mBinding.tvJewelSuffix3.setOnClickListener(v -> addSuffix(isSuffix, 2, mBinding.tvJewelSuffix3));
        mBinding.tvJewelSuffix4.setOnClickListener(v -> addSuffix(isSuffix, 3, mBinding.tvJewelSuffix4));
        mBinding.tvJewelSuffix5.setOnClickListener(v -> addSuffix(isSuffix, 4, mBinding.tvJewelSuffix5));
        mBinding.tvJewelSuffix6.setOnClickListener(v -> addSuffix(isSuffix, 5, mBinding.tvJewelSuffix6));
        mBinding.tvJewelSuffix7.setOnClickListener(v -> addSuffix(isSuffix, 6, mBinding.tvJewelSuffix7));
        mBinding.tvJewelSuffix8.setOnClickListener(v -> addSuffix(isSuffix, 7, mBinding.tvJewelSuffix8));
        mBinding.tvJewelSuffix9.setOnClickListener(v -> addSuffix(isSuffix, 8, mBinding.tvJewelSuffix9));
        mBinding.tvJewelSuffix10.setOnClickListener(v -> addSuffix(isSuffix, 9, mBinding.tvJewelSuffix10));
        mBinding.tvJewelSuffix11.setOnClickListener(v -> addSuffix(isSuffix, 10, mBinding.tvJewelSuffix11));
        mBinding.tvJewelSuffix12.setOnClickListener(v -> addSuffix(isSuffix, 11, mBinding.tvJewelSuffix12));
        mBinding.tvJewelSuffix13.setOnClickListener(v -> addSuffix(isSuffix, 12, mBinding.tvJewelSuffix13));
        mBinding.tvJewelSuffix14.setOnClickListener(v -> addSuffix(isSuffix, 13, mBinding.tvJewelSuffix14));
        mBinding.tvJewelSuffix15.setOnClickListener(v -> addSuffix(isSuffix, 14, mBinding.tvJewelSuffix15));
        mBinding.tvJewelSuffix16.setOnClickListener(v -> addSuffix(isSuffix, 15, mBinding.tvJewelSuffix16));
        mBinding.tvJewelSuffix17.setOnClickListener(v -> addSuffix(isSuffix, 16, mBinding.tvJewelSuffix17));
        mBinding.tvJewelSuffix18.setOnClickListener(v -> addSuffix(isSuffix, 17, mBinding.tvJewelSuffix18));
        mBinding.tvJewelSuffix19.setOnClickListener(v -> addSuffix(isSuffix, 18, mBinding.tvJewelSuffix19));

        return mBinding.getRoot();
    }

    private void addSuffix(boolean[] isSuffix, int itemNumber, TextView textView){
        if (isSuffix[itemNumber]){
            rareJewelHideAndShow.addSuffix(listSuffix, listPrefix, itemSuffix, itemNumber, textView);
            isSuffix[itemNumber] = false;
        } else {
            rareJewelHideAndShow.removeSuffix(listSuffix, listPrefix, itemSuffix, itemNumber, textView);
            isSuffix[itemNumber] = true;
        }
    }

    private void addPrefix(boolean[] isPrefix, int itemNumber, TextView textView){
        if (isPrefix[itemNumber]){
            rareJewelHideAndShow.addPreFix(listSuffix, listPrefix, itemSuffix, itemNumber, textView);
            isPrefix[itemNumber] = false;
        } else {
            rareJewelHideAndShow.removePreFix(listSuffix, listPrefix, itemSuffix, itemNumber, textView);
            isPrefix[itemNumber] = true;
        }
    }

}