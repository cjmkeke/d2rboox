package com.cjmkeke.d2rbooks.itemdatabase.magic_item_information;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentJewelMagicOptionsDatabaseBinding;

import java.util.ArrayList;
import java.util.List;

public class JewelMagicOptionsDatabase extends Fragment {

    private FragmentJewelMagicOptionsDatabaseBinding mBinding;
    private static final String TAG = "JewelMagicOptionsDatabase";
    private SharedPreferences fontSharedPreferences;
    private MagicHideAndShow magicHideAndShow;
    boolean isPrefix[] = new boolean[100];
    boolean isSuffix[] = new boolean[100];
    private List<String> listSuffix = new ArrayList<>();
    private List<String> listPrefix = new ArrayList<>();
    private String[] itemPrefix;
    private String[] itemSuffix;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentJewelMagicOptionsDatabaseBinding.inflate(inflater, container, false);

        listPrefix.clear();
        listSuffix.clear();

        for (int i = 0; i < isPrefix.length; i++) {
            isPrefix[i] = true;
            isSuffix[i] = true;
        }

        magicHideAndShow = new MagicHideAndShow(getContext(), listSuffix, listPrefix, itemPrefix, itemSuffix, mBinding.tvMagicJewelTitle);
        magicHideAndShow.setItemType("jewel");

        // TODO 접두사
        itemPrefix = new String[]{
                getString(R.string.item_options_magic_jewel_1_prefix), getString(R.string.item_options_magic_jewel_2_prefix), getString(R.string.item_options_magic_jewel_3_prefix),
                getString(R.string.item_options_magic_jewel_4_prefix), getString(R.string.item_options_magic_jewel_5_prefix), getString(R.string.item_options_magic_jewel_6_prefix),
                getString(R.string.item_options_magic_jewel_7_prefix), getString(R.string.item_options_magic_jewel_8_prefix), getString(R.string.item_options_magic_jewel_9_prefix),
                getString(R.string.item_options_magic_jewel_10_prefix), getString(R.string.item_options_magic_jewel_11_prefix), getString(R.string.item_options_magic_jewel_12_prefix),
                getString(R.string.item_options_magic_jewel_13_prefix), getString(R.string.item_options_magic_jewel_14_prefix), getString(R.string.item_options_magic_jewel_15_prefix),
                getString(R.string.item_options_magic_jewel_16_prefix), getString(R.string.item_options_magic_jewel_17_prefix), getString(R.string.item_options_magic_jewel_18_prefix),
                getString(R.string.item_options_magic_jewel_19_prefix), getString(R.string.item_options_magic_jewel_20_prefix), getString(R.string.item_options_magic_jewel_21_prefix),
                getString(R.string.item_options_magic_jewel_22_prefix), getString(R.string.item_options_magic_jewel_23_prefix), getString(R.string.item_options_magic_jewel_24_prefix),
                getString(R.string.item_options_magic_jewel_25_prefix), getString(R.string.item_options_magic_jewel_26_prefix), getString(R.string.item_options_magic_jewel_27_prefix),
                getString(R.string.item_options_magic_jewel_28_prefix), getString(R.string.item_options_magic_jewel_29_prefix), getString(R.string.item_options_magic_jewel_30_prefix),
                getString(R.string.item_options_magic_jewel_31_prefix), getString(R.string.item_options_magic_jewel_32_prefix), getString(R.string.item_options_magic_jewel_33_prefix),
                getString(R.string.item_options_magic_jewel_34_prefix), getString(R.string.item_options_magic_jewel_35_prefix), getString(R.string.item_options_magic_jewel_36_prefix),
                getString(R.string.item_options_magic_jewel_37_prefix), getString(R.string.item_options_magic_jewel_38_prefix), getString(R.string.item_options_magic_jewel_39_prefix)
        };

        // TODO 접미사
        itemSuffix = new String[]{
                getString(R.string.item_options_magic_jewel_1_suffix), getString(R.string.item_options_magic_jewel_2_suffix), getString(R.string.item_options_magic_jewel_3_suffix),
                getString(R.string.item_options_magic_jewel_4_suffix), getString(R.string.item_options_magic_jewel_5_suffix), getString(R.string.item_options_magic_jewel_6_suffix),
                getString(R.string.item_options_magic_jewel_7_suffix), getString(R.string.item_options_magic_jewel_8_suffix), getString(R.string.item_options_magic_jewel_9_suffix),
                getString(R.string.item_options_magic_jewel_10_suffix), getString(R.string.item_options_magic_jewel_11_suffix), getString(R.string.item_options_magic_jewel_12_suffix),
                getString(R.string.item_options_magic_jewel_13_suffix), getString(R.string.item_options_magic_jewel_14_suffix), getString(R.string.item_options_magic_jewel_15_suffix),
                getString(R.string.item_options_magic_jewel_16_suffix), getString(R.string.item_options_magic_jewel_17_suffix), getString(R.string.item_options_magic_jewel_18_suffix),
                getString(R.string.item_options_magic_jewel_19_suffix), getString(R.string.item_options_magic_jewel_20_suffix), getString(R.string.item_options_magic_jewel_21_suffix),
                getString(R.string.item_options_magic_jewel_22_suffix), getString(R.string.item_options_magic_jewel_23_suffix), getString(R.string.item_options_magic_jewel_24_suffix),
                getString(R.string.item_options_magic_jewel_25_suffix), getString(R.string.item_options_magic_jewel_26_suffix), getString(R.string.item_options_magic_jewel_27_suffix)
        };

        for (int i = 0; i < 50; i++) {
            int prefixId = getResources().getIdentifier("tv_magic_jewel_prefix_" + (i + 1), "id", getContext().getPackageName());
            int suffixId = getResources().getIdentifier("tv_magic_jewel_suffix_" + (i + 1), "id", getContext().getPackageName());
            TextView prefix = mBinding.getRoot().findViewById(prefixId);
            TextView suffix = mBinding.getRoot().findViewById(suffixId);

            if (prefix != null){
                prefix.setSingleLine(true);    // 한줄로 표시하기
                prefix.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                prefix.setSelected(true);      // 선택하기
                prefix.setPadding(5,0,5,0);
            }

            if (suffix != null){
                suffix.setSingleLine(true);    // 한줄로 표시하기
                suffix.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                suffix.setSelected(true);      // 선택하기
                suffix.setPadding(5,0,5,0);
            }
        }

        mBinding.tvMagicJewelPrefix1.setOnClickListener(v -> handlePrefixClick(0, mBinding.tvMagicJewelPrefix1));
        mBinding.tvMagicJewelPrefix2.setOnClickListener(v -> handlePrefixClick(1, mBinding.tvMagicJewelPrefix2));
        mBinding.tvMagicJewelPrefix3.setOnClickListener(v -> handlePrefixClick(2, mBinding.tvMagicJewelPrefix3));
        mBinding.tvMagicJewelPrefix4.setOnClickListener(v -> handlePrefixClick(3, mBinding.tvMagicJewelPrefix4));
        mBinding.tvMagicJewelPrefix5.setOnClickListener(v -> handlePrefixClick(4, mBinding.tvMagicJewelPrefix5));
        mBinding.tvMagicJewelPrefix6.setOnClickListener(v -> handlePrefixClick(5, mBinding.tvMagicJewelPrefix6));
        mBinding.tvMagicJewelPrefix7.setOnClickListener(v -> handlePrefixClick(6, mBinding.tvMagicJewelPrefix7));
        mBinding.tvMagicJewelPrefix8.setOnClickListener(v -> handlePrefixClick(7, mBinding.tvMagicJewelPrefix8));
        mBinding.tvMagicJewelPrefix9.setOnClickListener(v -> handlePrefixClick(8, mBinding.tvMagicJewelPrefix9));
        mBinding.tvMagicJewelPrefix10.setOnClickListener(v -> handlePrefixClick(9, mBinding.tvMagicJewelPrefix10));
        mBinding.tvMagicJewelPrefix11.setOnClickListener(v -> handlePrefixClick(10, mBinding.tvMagicJewelPrefix11));
        mBinding.tvMagicJewelPrefix12.setOnClickListener(v -> handlePrefixClick(11, mBinding.tvMagicJewelPrefix12));
        mBinding.tvMagicJewelPrefix13.setOnClickListener(v -> handlePrefixClick(12, mBinding.tvMagicJewelPrefix13));
        mBinding.tvMagicJewelPrefix14.setOnClickListener(v -> handlePrefixClick(13, mBinding.tvMagicJewelPrefix14));
        mBinding.tvMagicJewelPrefix15.setOnClickListener(v -> handlePrefixClick(14, mBinding.tvMagicJewelPrefix15));
        mBinding.tvMagicJewelPrefix16.setOnClickListener(v -> handlePrefixClick(15, mBinding.tvMagicJewelPrefix16));
        mBinding.tvMagicJewelPrefix17.setOnClickListener(v -> handlePrefixClick(16, mBinding.tvMagicJewelPrefix17));
        mBinding.tvMagicJewelPrefix18.setOnClickListener(v -> handlePrefixClick(17, mBinding.tvMagicJewelPrefix18));
        mBinding.tvMagicJewelPrefix19.setOnClickListener(v -> handlePrefixClick(18, mBinding.tvMagicJewelPrefix19));
        mBinding.tvMagicJewelPrefix20.setOnClickListener(v -> handlePrefixClick(19, mBinding.tvMagicJewelPrefix20));
        mBinding.tvMagicJewelPrefix21.setOnClickListener(v -> handlePrefixClick(20, mBinding.tvMagicJewelPrefix21));
        mBinding.tvMagicJewelPrefix22.setOnClickListener(v -> handlePrefixClick(21, mBinding.tvMagicJewelPrefix22));
        mBinding.tvMagicJewelPrefix23.setOnClickListener(v -> handlePrefixClick(22, mBinding.tvMagicJewelPrefix23));
        mBinding.tvMagicJewelPrefix24.setOnClickListener(v -> handlePrefixClick(23, mBinding.tvMagicJewelPrefix24));
        mBinding.tvMagicJewelPrefix25.setOnClickListener(v -> handlePrefixClick(24, mBinding.tvMagicJewelPrefix25));
        mBinding.tvMagicJewelPrefix26.setOnClickListener(v -> handlePrefixClick(25, mBinding.tvMagicJewelPrefix26));
        mBinding.tvMagicJewelPrefix27.setOnClickListener(v -> handlePrefixClick(26, mBinding.tvMagicJewelPrefix27));
        mBinding.tvMagicJewelPrefix28.setOnClickListener(v -> handlePrefixClick(27, mBinding.tvMagicJewelPrefix28));
        mBinding.tvMagicJewelPrefix29.setOnClickListener(v -> handlePrefixClick(28, mBinding.tvMagicJewelPrefix29));
        mBinding.tvMagicJewelPrefix30.setOnClickListener(v -> handlePrefixClick(29, mBinding.tvMagicJewelPrefix30));
        mBinding.tvMagicJewelPrefix31.setOnClickListener(v -> handlePrefixClick(30, mBinding.tvMagicJewelPrefix31));
        mBinding.tvMagicJewelPrefix32.setOnClickListener(v -> handlePrefixClick(31, mBinding.tvMagicJewelPrefix32));
        mBinding.tvMagicJewelPrefix33.setOnClickListener(v -> handlePrefixClick(32, mBinding.tvMagicJewelPrefix33));
        mBinding.tvMagicJewelPrefix34.setOnClickListener(v -> handlePrefixClick(33, mBinding.tvMagicJewelPrefix34));
        mBinding.tvMagicJewelPrefix35.setOnClickListener(v -> handlePrefixClick(34, mBinding.tvMagicJewelPrefix35));
        mBinding.tvMagicJewelPrefix36.setOnClickListener(v -> handlePrefixClick(35, mBinding.tvMagicJewelPrefix36));
        mBinding.tvMagicJewelPrefix37.setOnClickListener(v -> handlePrefixClick(36, mBinding.tvMagicJewelPrefix37));
        mBinding.tvMagicJewelPrefix38.setOnClickListener(v -> handlePrefixClick(37, mBinding.tvMagicJewelPrefix38));
        mBinding.tvMagicJewelPrefix39.setOnClickListener(v -> handlePrefixClick(38, mBinding.tvMagicJewelPrefix39));

        // TODO SUFFIX
        mBinding.tvMagicJewelSuffix1.setOnClickListener(v -> handleSuffixClick(0, mBinding.tvMagicJewelSuffix1));
        mBinding.tvMagicJewelSuffix2.setOnClickListener(v -> handleSuffixClick(1, mBinding.tvMagicJewelSuffix2));
        mBinding.tvMagicJewelSuffix3.setOnClickListener(v -> handleSuffixClick(2, mBinding.tvMagicJewelSuffix3));
        mBinding.tvMagicJewelSuffix4.setOnClickListener(v -> handleSuffixClick(3, mBinding.tvMagicJewelSuffix4));
        mBinding.tvMagicJewelSuffix5.setOnClickListener(v -> handleSuffixClick(4, mBinding.tvMagicJewelSuffix5));
        mBinding.tvMagicJewelSuffix6.setOnClickListener(v -> handleSuffixClick(5, mBinding.tvMagicJewelSuffix6));
        mBinding.tvMagicJewelSuffix7.setOnClickListener(v -> handleSuffixClick(6, mBinding.tvMagicJewelSuffix7));
        mBinding.tvMagicJewelSuffix8.setOnClickListener(v -> handleSuffixClick(7, mBinding.tvMagicJewelSuffix8));
        mBinding.tvMagicJewelSuffix9.setOnClickListener(v -> handleSuffixClick(8, mBinding.tvMagicJewelSuffix9));
        mBinding.tvMagicJewelSuffix10.setOnClickListener(v -> handleSuffixClick(9, mBinding.tvMagicJewelSuffix10));
        mBinding.tvMagicJewelSuffix11.setOnClickListener(v -> handleSuffixClick(10, mBinding.tvMagicJewelSuffix11));
        mBinding.tvMagicJewelSuffix12.setOnClickListener(v -> handleSuffixClick(11, mBinding.tvMagicJewelSuffix12));
        mBinding.tvMagicJewelSuffix13.setOnClickListener(v -> handleSuffixClick(12, mBinding.tvMagicJewelSuffix13));
        mBinding.tvMagicJewelSuffix14.setOnClickListener(v -> handleSuffixClick(13, mBinding.tvMagicJewelSuffix14));
        mBinding.tvMagicJewelSuffix15.setOnClickListener(v -> handleSuffixClick(14, mBinding.tvMagicJewelSuffix15));
        mBinding.tvMagicJewelSuffix16.setOnClickListener(v -> handleSuffixClick(15, mBinding.tvMagicJewelSuffix16));
        mBinding.tvMagicJewelSuffix17.setOnClickListener(v -> handleSuffixClick(16, mBinding.tvMagicJewelSuffix17));
        mBinding.tvMagicJewelSuffix18.setOnClickListener(v -> handleSuffixClick(17, mBinding.tvMagicJewelSuffix18));
        mBinding.tvMagicJewelSuffix19.setOnClickListener(v -> handleSuffixClick(18, mBinding.tvMagicJewelSuffix19));
        mBinding.tvMagicJewelSuffix20.setOnClickListener(v -> handleSuffixClick(19, mBinding.tvMagicJewelSuffix20));
        mBinding.tvMagicJewelSuffix21.setOnClickListener(v -> handleSuffixClick(20, mBinding.tvMagicJewelSuffix21));
        mBinding.tvMagicJewelSuffix22.setOnClickListener(v -> handleSuffixClick(21, mBinding.tvMagicJewelSuffix22));
        mBinding.tvMagicJewelSuffix23.setOnClickListener(v -> handleSuffixClick(22, mBinding.tvMagicJewelSuffix23));
        mBinding.tvMagicJewelSuffix24.setOnClickListener(v -> handleSuffixClick(23, mBinding.tvMagicJewelSuffix24));
        mBinding.tvMagicJewelSuffix25.setOnClickListener(v -> handleSuffixClick(24, mBinding.tvMagicJewelSuffix25));
        mBinding.tvMagicJewelSuffix26.setOnClickListener(v -> handleSuffixClick(25, mBinding.tvMagicJewelSuffix26));
        mBinding.tvMagicJewelSuffix27.setOnClickListener(v -> handleSuffixClick(26, mBinding.tvMagicJewelSuffix27));

        return mBinding.getRoot();
    }


    private void handlePrefixClick(int prefixIndex, TextView textView) {
        if (isPrefix[prefixIndex]) {
            magicHideAndShow.addPreFix(listPrefix, itemPrefix, prefixIndex, textView);
            isPrefix[prefixIndex] = false;
        } else {
            magicHideAndShow.removePreFix(listPrefix, itemPrefix, prefixIndex, textView);
            isPrefix[prefixIndex] = true;
        }
    }

    private void handleSuffixClick(int prefixIndex, TextView textView) {
        if (isSuffix[prefixIndex]) {
            magicHideAndShow.addSuffix(listSuffix, itemSuffix, prefixIndex, textView);
            isSuffix[prefixIndex] = false;
        } else {
            magicHideAndShow.removeSuffix(listSuffix, itemSuffix, prefixIndex, textView);
            isSuffix[prefixIndex] = true;
        }
    }
}