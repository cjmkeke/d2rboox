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
import com.cjmkeke.d2rbooks.databinding.FragmentLargeCharmMagicOptionsDatabaseBinding;

import java.util.ArrayList;
import java.util.List;

public class LargeCharmMagicOptionsDatabase extends Fragment {

    private FragmentLargeCharmMagicOptionsDatabaseBinding mBinding;
    private static final String TAG = "LargeCharmMagicOptionsDatabase";
    private SharedPreferences fontSharedPreferences;
    private MagicHideAndShow addMagicHideAndShow;
    private MagicHideAndShow removeMagicHideAndShow;
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
        mBinding = FragmentLargeCharmMagicOptionsDatabaseBinding.inflate(inflater, container, false);

        for (int i = 0; i < isPrefix.length; i++) {
            isPrefix[i] = true;
            isSuffix[i] = true;
        }

        listPrefix.clear();
        listSuffix.clear();

        // TODO 접두사
        itemPrefix = new String[]{
                getString(R.string.item_options_large_charm_1_prefix), getString(R.string.item_options_large_charm_2_prefix), getString(R.string.item_options_large_charm_3_prefix),
                getString(R.string.item_options_large_charm_4_prefix), getString(R.string.item_options_large_charm_5_prefix), getString(R.string.item_options_large_charm_6_prefix),
                getString(R.string.item_options_large_charm_7_prefix), getString(R.string.item_options_large_charm_8_prefix), getString(R.string.item_options_large_charm_9_prefix),
                getString(R.string.item_options_large_charm_10_prefix), getString(R.string.item_options_large_charm_11_prefix), getString(R.string.item_options_large_charm_12_prefix),
                getString(R.string.item_options_large_charm_13_prefix), getString(R.string.item_options_large_charm_14_prefix), getString(R.string.item_options_large_charm_15_prefix),
                getString(R.string.item_options_large_charm_16_prefix), getString(R.string.item_options_large_charm_17_prefix), getString(R.string.item_options_large_charm_18_prefix),
                getString(R.string.item_options_large_charm_19_prefix), getString(R.string.item_options_large_charm_20_prefix), getString(R.string.item_options_large_charm_21_prefix),
                getString(R.string.item_options_large_charm_22_prefix), getString(R.string.item_options_large_charm_23_prefix), getString(R.string.item_options_large_charm_24_prefix),
                getString(R.string.item_options_large_charm_25_prefix), getString(R.string.item_options_large_charm_26_prefix), getString(R.string.item_options_large_charm_27_prefix),
                getString(R.string.item_options_large_charm_28_prefix), getString(R.string.item_options_large_charm_29_prefix), getString(R.string.item_options_large_charm_30_prefix),
                getString(R.string.item_options_large_charm_31_prefix), getString(R.string.item_options_large_charm_32_prefix), getString(R.string.item_options_large_charm_33_prefix),
                getString(R.string.item_options_large_charm_34_prefix), getString(R.string.item_options_large_charm_35_prefix), getString(R.string.item_options_large_charm_36_prefix),
                getString(R.string.item_options_large_charm_37_prefix), getString(R.string.item_options_large_charm_38_prefix), getString(R.string.item_options_large_charm_39_prefix),
                getString(R.string.item_options_large_charm_40_prefix), getString(R.string.item_options_large_charm_41_prefix), getString(R.string.item_options_large_charm_42_prefix),
                getString(R.string.item_options_large_charm_43_prefix), getString(R.string.item_options_large_charm_44_prefix), getString(R.string.item_options_large_charm_45_prefix),
                getString(R.string.item_options_large_charm_46_prefix), getString(R.string.item_options_large_charm_47_prefix), getString(R.string.item_options_large_charm_48_prefix),
                getString(R.string.item_options_large_charm_49_prefix), getString(R.string.item_options_large_charm_50_prefix), getString(R.string.item_options_large_charm_51_prefix),
                getString(R.string.item_options_large_charm_52_prefix), getString(R.string.item_options_large_charm_53_prefix), getString(R.string.item_options_large_charm_54_prefix),
                getString(R.string.item_options_large_charm_55_prefix), getString(R.string.item_options_large_charm_56_prefix), getString(R.string.item_options_large_charm_57_prefix),
                getString(R.string.item_options_large_charm_58_prefix), getString(R.string.item_options_large_charm_59_prefix), getString(R.string.item_options_large_charm_60_prefix),
                getString(R.string.item_options_large_charm_61_prefix), getString(R.string.item_options_large_charm_62_prefix), getString(R.string.item_options_large_charm_63_prefix),
                getString(R.string.item_options_large_charm_64_prefix), getString(R.string.item_options_large_charm_65_prefix), getString(R.string.item_options_large_charm_66_prefix),
                getString(R.string.item_options_large_charm_67_prefix)
        };

        // TODO 접미사
        itemSuffix = new String[]{
                getString(R.string.item_options_large_charm_1_suffix), getString(R.string.item_options_large_charm_2_suffix), getString(R.string.item_options_large_charm_3_suffix),
                getString(R.string.item_options_large_charm_4_suffix), getString(R.string.item_options_large_charm_5_suffix), getString(R.string.item_options_large_charm_6_suffix),
                getString(R.string.item_options_large_charm_7_suffix), getString(R.string.item_options_large_charm_8_suffix), getString(R.string.item_options_large_charm_9_suffix),
                getString(R.string.item_options_large_charm_10_suffix), getString(R.string.item_options_large_charm_11_suffix), getString(R.string.item_options_large_charm_12_suffix),
                getString(R.string.item_options_large_charm_13_suffix), getString(R.string.item_options_large_charm_14_suffix), getString(R.string.item_options_large_charm_15_suffix),
                getString(R.string.item_options_large_charm_16_suffix), getString(R.string.item_options_large_charm_17_suffix), getString(R.string.item_options_large_charm_18_suffix),
                getString(R.string.item_options_large_charm_19_suffix), getString(R.string.item_options_large_charm_20_suffix), getString(R.string.item_options_large_charm_21_suffix),
                getString(R.string.item_options_large_charm_22_suffix), getString(R.string.item_options_large_charm_23_suffix), getString(R.string.item_options_large_charm_24_suffix),
                getString(R.string.item_options_large_charm_25_suffix), getString(R.string.item_options_large_charm_26_suffix), getString(R.string.item_options_large_charm_27_suffix),
                getString(R.string.item_options_large_charm_28_suffix), getString(R.string.item_options_large_charm_29_suffix), getString(R.string.item_options_large_charm_30_suffix),
                getString(R.string.item_options_large_charm_31_suffix), getString(R.string.item_options_large_charm_32_suffix)
        };

        addMagicHideAndShow = new MagicHideAndShow(getContext(), listSuffix, listPrefix, itemPrefix, itemSuffix, mBinding.tvLargeCharmTitle);
        removeMagicHideAndShow = new MagicHideAndShow(getContext(), listSuffix, listPrefix, itemPrefix, itemSuffix, mBinding.tvLargeCharmTitle);
        addMagicHideAndShow.setItemType("large_charm");
        removeMagicHideAndShow.setItemType("large_charm");

        for (int i = 1; i < 98; i++) {
            int prefixId = getResources().getIdentifier("tv_large_charm_prefix_" + i, "id", getContext().getPackageName());
            int suffixId = getResources().getIdentifier("tv_large_charm_suffix_" + i, "id", getContext().getPackageName());
            TextView prefix = mBinding.getRoot().findViewById(prefixId);
            TextView suffix = mBinding.getRoot().findViewById(suffixId);
            if (prefix != null) {
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

        mBinding.tvLargeCharmPrefix1.setOnClickListener(v -> handlePrefixClick(0, mBinding.tvLargeCharmPrefix1));
        mBinding.tvLargeCharmPrefix2.setOnClickListener(v -> handlePrefixClick(1, mBinding.tvLargeCharmPrefix2));
        mBinding.tvLargeCharmPrefix3.setOnClickListener(v -> handlePrefixClick(2, mBinding.tvLargeCharmPrefix3));
        mBinding.tvLargeCharmPrefix4.setOnClickListener(v -> handlePrefixClick(3, mBinding.tvLargeCharmPrefix4));
        mBinding.tvLargeCharmPrefix5.setOnClickListener(v -> handlePrefixClick(4, mBinding.tvLargeCharmPrefix5));
        mBinding.tvLargeCharmPrefix6.setOnClickListener(v -> handlePrefixClick(5, mBinding.tvLargeCharmPrefix6));
        mBinding.tvLargeCharmPrefix7.setOnClickListener(v -> handlePrefixClick(6, mBinding.tvLargeCharmPrefix7));
        mBinding.tvLargeCharmPrefix8.setOnClickListener(v -> handlePrefixClick(7, mBinding.tvLargeCharmPrefix8));
        mBinding.tvLargeCharmPrefix9.setOnClickListener(v -> handlePrefixClick(8, mBinding.tvLargeCharmPrefix9));
        mBinding.tvLargeCharmPrefix10.setOnClickListener(v -> handlePrefixClick(9, mBinding.tvLargeCharmPrefix10));
        mBinding.tvLargeCharmPrefix11.setOnClickListener(v -> handlePrefixClick(10, mBinding.tvLargeCharmPrefix11));
        mBinding.tvLargeCharmPrefix12.setOnClickListener(v -> handlePrefixClick(11, mBinding.tvLargeCharmPrefix12));
        mBinding.tvLargeCharmPrefix13.setOnClickListener(v -> handlePrefixClick(12, mBinding.tvLargeCharmPrefix13));
        mBinding.tvLargeCharmPrefix14.setOnClickListener(v -> handlePrefixClick(13, mBinding.tvLargeCharmPrefix14));
        mBinding.tvLargeCharmPrefix15.setOnClickListener(v -> handlePrefixClick(14, mBinding.tvLargeCharmPrefix15));
        mBinding.tvLargeCharmPrefix16.setOnClickListener(v -> handlePrefixClick(15, mBinding.tvLargeCharmPrefix16));
        mBinding.tvLargeCharmPrefix17.setOnClickListener(v -> handlePrefixClick(16, mBinding.tvLargeCharmPrefix17));
        mBinding.tvLargeCharmPrefix18.setOnClickListener(v -> handlePrefixClick(17, mBinding.tvLargeCharmPrefix18));
        mBinding.tvLargeCharmPrefix19.setOnClickListener(v -> handlePrefixClick(18, mBinding.tvLargeCharmPrefix19));
        mBinding.tvLargeCharmPrefix20.setOnClickListener(v -> handlePrefixClick(19, mBinding.tvLargeCharmPrefix20));
        mBinding.tvLargeCharmPrefix21.setOnClickListener(v -> handlePrefixClick(20, mBinding.tvLargeCharmPrefix21));
        mBinding.tvLargeCharmPrefix22.setOnClickListener(v -> handlePrefixClick(21, mBinding.tvLargeCharmPrefix22));
        mBinding.tvLargeCharmPrefix23.setOnClickListener(v -> handlePrefixClick(22, mBinding.tvLargeCharmPrefix23));
        mBinding.tvLargeCharmPrefix24.setOnClickListener(v -> handlePrefixClick(23, mBinding.tvLargeCharmPrefix24));
        mBinding.tvLargeCharmPrefix25.setOnClickListener(v -> handlePrefixClick(24, mBinding.tvLargeCharmPrefix25));
        mBinding.tvLargeCharmPrefix26.setOnClickListener(v -> handlePrefixClick(25, mBinding.tvLargeCharmPrefix26));
        mBinding.tvLargeCharmPrefix27.setOnClickListener(v -> handlePrefixClick(26, mBinding.tvLargeCharmPrefix27));
        mBinding.tvLargeCharmPrefix28.setOnClickListener(v -> handlePrefixClick(27, mBinding.tvLargeCharmPrefix28));
        mBinding.tvLargeCharmPrefix29.setOnClickListener(v -> handlePrefixClick(28, mBinding.tvLargeCharmPrefix29));
        mBinding.tvLargeCharmPrefix30.setOnClickListener(v -> handlePrefixClick(29, mBinding.tvLargeCharmPrefix30));
        mBinding.tvLargeCharmPrefix31.setOnClickListener(v -> handlePrefixClick(30, mBinding.tvLargeCharmPrefix31));
        mBinding.tvLargeCharmPrefix32.setOnClickListener(v -> handlePrefixClick(31, mBinding.tvLargeCharmPrefix32));
        mBinding.tvLargeCharmPrefix33.setOnClickListener(v -> handlePrefixClick(32, mBinding.tvLargeCharmPrefix33));
        mBinding.tvLargeCharmPrefix34.setOnClickListener(v -> handlePrefixClick(33, mBinding.tvLargeCharmPrefix34));
        mBinding.tvLargeCharmPrefix35.setOnClickListener(v -> handlePrefixClick(34, mBinding.tvLargeCharmPrefix35));
        mBinding.tvLargeCharmPrefix36.setOnClickListener(v -> handlePrefixClick(35, mBinding.tvLargeCharmPrefix36));
        mBinding.tvLargeCharmPrefix37.setOnClickListener(v -> handlePrefixClick(36, mBinding.tvLargeCharmPrefix37));
        mBinding.tvLargeCharmPrefix38.setOnClickListener(v -> handlePrefixClick(37, mBinding.tvLargeCharmPrefix38));
        mBinding.tvLargeCharmPrefix39.setOnClickListener(v -> handlePrefixClick(38, mBinding.tvLargeCharmPrefix39));
        mBinding.tvLargeCharmPrefix40.setOnClickListener(v -> handlePrefixClick(39, mBinding.tvLargeCharmPrefix40));
        mBinding.tvLargeCharmPrefix41.setOnClickListener(v -> handlePrefixClick(40, mBinding.tvLargeCharmPrefix41));
        mBinding.tvLargeCharmPrefix42.setOnClickListener(v -> handlePrefixClick(41, mBinding.tvLargeCharmPrefix42));
        mBinding.tvLargeCharmPrefix43.setOnClickListener(v -> handlePrefixClick(42, mBinding.tvLargeCharmPrefix43));
        mBinding.tvLargeCharmPrefix44.setOnClickListener(v -> handlePrefixClick(43, mBinding.tvLargeCharmPrefix44));
        mBinding.tvLargeCharmPrefix45.setOnClickListener(v -> handlePrefixClick(44, mBinding.tvLargeCharmPrefix45));
        mBinding.tvLargeCharmPrefix46.setOnClickListener(v -> handlePrefixClick(45, mBinding.tvLargeCharmPrefix46));
        mBinding.tvLargeCharmPrefix47.setOnClickListener(v -> handlePrefixClick(46, mBinding.tvLargeCharmPrefix47));
        mBinding.tvLargeCharmPrefix48.setOnClickListener(v -> handlePrefixClick(47, mBinding.tvLargeCharmPrefix48));
        mBinding.tvLargeCharmPrefix49.setOnClickListener(v -> handlePrefixClick(48, mBinding.tvLargeCharmPrefix49));
        mBinding.tvLargeCharmPrefix50.setOnClickListener(v -> handlePrefixClick(49, mBinding.tvLargeCharmPrefix50));
        mBinding.tvLargeCharmPrefix51.setOnClickListener(v -> handlePrefixClick(50, mBinding.tvLargeCharmPrefix51));
        mBinding.tvLargeCharmPrefix52.setOnClickListener(v -> handlePrefixClick(51, mBinding.tvLargeCharmPrefix52));
        mBinding.tvLargeCharmPrefix53.setOnClickListener(v -> handlePrefixClick(52, mBinding.tvLargeCharmPrefix53));
        mBinding.tvLargeCharmPrefix54.setOnClickListener(v -> handlePrefixClick(53, mBinding.tvLargeCharmPrefix54));
        mBinding.tvLargeCharmPrefix55.setOnClickListener(v -> handlePrefixClick(54, mBinding.tvLargeCharmPrefix55));
        mBinding.tvLargeCharmPrefix56.setOnClickListener(v -> handlePrefixClick(55, mBinding.tvLargeCharmPrefix56));
        mBinding.tvLargeCharmPrefix57.setOnClickListener(v -> handlePrefixClick(56, mBinding.tvLargeCharmPrefix57));
        mBinding.tvLargeCharmPrefix58.setOnClickListener(v -> handlePrefixClick(57, mBinding.tvLargeCharmPrefix58));
        mBinding.tvLargeCharmPrefix59.setOnClickListener(v -> handlePrefixClick(58, mBinding.tvLargeCharmPrefix59));
        mBinding.tvLargeCharmPrefix60.setOnClickListener(v -> handlePrefixClick(59, mBinding.tvLargeCharmPrefix60));
        mBinding.tvLargeCharmPrefix61.setOnClickListener(v -> handlePrefixClick(60, mBinding.tvLargeCharmPrefix61));
        mBinding.tvLargeCharmPrefix62.setOnClickListener(v -> handlePrefixClick(61, mBinding.tvLargeCharmPrefix62));
        mBinding.tvLargeCharmPrefix63.setOnClickListener(v -> handlePrefixClick(62, mBinding.tvLargeCharmPrefix63));
        mBinding.tvLargeCharmPrefix64.setOnClickListener(v -> handlePrefixClick(63, mBinding.tvLargeCharmPrefix64));
        mBinding.tvLargeCharmPrefix65.setOnClickListener(v -> handlePrefixClick(64, mBinding.tvLargeCharmPrefix65));
        mBinding.tvLargeCharmPrefix66.setOnClickListener(v -> handlePrefixClick(65, mBinding.tvLargeCharmPrefix66));
        mBinding.tvLargeCharmPrefix67.setOnClickListener(v -> handlePrefixClick(66, mBinding.tvLargeCharmPrefix67));


        // TODO SUFFIX
        mBinding.tvLargeCharmSuffix1.setOnClickListener(v -> handleSuffixClick(0, mBinding.tvLargeCharmSuffix1));
        mBinding.tvLargeCharmSuffix2.setOnClickListener(v -> handleSuffixClick(1, mBinding.tvLargeCharmSuffix2));
        mBinding.tvLargeCharmSuffix3.setOnClickListener(v -> handleSuffixClick(2, mBinding.tvLargeCharmSuffix3));
        mBinding.tvLargeCharmSuffix4.setOnClickListener(v -> handleSuffixClick(3, mBinding.tvLargeCharmSuffix4));
        mBinding.tvLargeCharmSuffix5.setOnClickListener(v -> handleSuffixClick(4, mBinding.tvLargeCharmSuffix5));
        mBinding.tvLargeCharmSuffix6.setOnClickListener(v -> handleSuffixClick(5, mBinding.tvLargeCharmSuffix6));
        mBinding.tvLargeCharmSuffix7.setOnClickListener(v -> handleSuffixClick(6, mBinding.tvLargeCharmSuffix7));
        mBinding.tvLargeCharmSuffix8.setOnClickListener(v -> handleSuffixClick(7, mBinding.tvLargeCharmSuffix8));
        mBinding.tvLargeCharmSuffix9.setOnClickListener(v -> handleSuffixClick(8, mBinding.tvLargeCharmSuffix9));
        mBinding.tvLargeCharmSuffix10.setOnClickListener(v -> handleSuffixClick(9, mBinding.tvLargeCharmSuffix10));
        mBinding.tvLargeCharmSuffix11.setOnClickListener(v -> handleSuffixClick(10, mBinding.tvLargeCharmSuffix11));
        mBinding.tvLargeCharmSuffix12.setOnClickListener(v -> handleSuffixClick(11, mBinding.tvLargeCharmSuffix12));
        mBinding.tvLargeCharmSuffix13.setOnClickListener(v -> handleSuffixClick(12, mBinding.tvLargeCharmSuffix13));
        mBinding.tvLargeCharmSuffix14.setOnClickListener(v -> handleSuffixClick(13, mBinding.tvLargeCharmSuffix14));
        mBinding.tvLargeCharmSuffix15.setOnClickListener(v -> handleSuffixClick(14, mBinding.tvLargeCharmSuffix15));
        mBinding.tvLargeCharmSuffix16.setOnClickListener(v -> handleSuffixClick(15, mBinding.tvLargeCharmSuffix16));
        mBinding.tvLargeCharmSuffix17.setOnClickListener(v -> handleSuffixClick(16, mBinding.tvLargeCharmSuffix17));
        mBinding.tvLargeCharmSuffix18.setOnClickListener(v -> handleSuffixClick(17, mBinding.tvLargeCharmSuffix18));
        mBinding.tvLargeCharmSuffix19.setOnClickListener(v -> handleSuffixClick(18, mBinding.tvLargeCharmSuffix19));
        mBinding.tvLargeCharmSuffix20.setOnClickListener(v -> handleSuffixClick(19, mBinding.tvLargeCharmSuffix20));
        mBinding.tvLargeCharmSuffix21.setOnClickListener(v -> handleSuffixClick(20, mBinding.tvLargeCharmSuffix21));
        mBinding.tvLargeCharmSuffix22.setOnClickListener(v -> handleSuffixClick(21, mBinding.tvLargeCharmSuffix22));
        mBinding.tvLargeCharmSuffix23.setOnClickListener(v -> handleSuffixClick(22, mBinding.tvLargeCharmSuffix23));
        mBinding.tvLargeCharmSuffix24.setOnClickListener(v -> handleSuffixClick(23, mBinding.tvLargeCharmSuffix24));
        mBinding.tvLargeCharmSuffix25.setOnClickListener(v -> handleSuffixClick(24, mBinding.tvLargeCharmSuffix25));
        mBinding.tvLargeCharmSuffix26.setOnClickListener(v -> handleSuffixClick(25, mBinding.tvLargeCharmSuffix26));
        mBinding.tvLargeCharmSuffix27.setOnClickListener(v -> handleSuffixClick(26, mBinding.tvLargeCharmSuffix27));
        mBinding.tvLargeCharmSuffix28.setOnClickListener(v -> handleSuffixClick(27, mBinding.tvLargeCharmSuffix28));
        mBinding.tvLargeCharmSuffix29.setOnClickListener(v -> handleSuffixClick(28, mBinding.tvLargeCharmSuffix29));
        mBinding.tvLargeCharmSuffix30.setOnClickListener(v -> handleSuffixClick(29, mBinding.tvLargeCharmSuffix30));
        mBinding.tvLargeCharmSuffix31.setOnClickListener(v -> handleSuffixClick(30, mBinding.tvLargeCharmSuffix31));
        mBinding.tvLargeCharmSuffix32.setOnClickListener(v -> handleSuffixClick(31, mBinding.tvLargeCharmSuffix32));

        return mBinding.getRoot();
    }


    private void handlePrefixClick(int prefixIndex, TextView textView) {
        if (isPrefix[prefixIndex]) {
            addMagicHideAndShow.addPreFix(listPrefix, itemPrefix, prefixIndex, textView);
            isPrefix[prefixIndex] = false;
        } else {
            addMagicHideAndShow.removePreFix(listPrefix, itemPrefix, prefixIndex, textView);
            isPrefix[prefixIndex] = true;
        }
    }

    private void handleSuffixClick(int prefixIndex, TextView textView) {
        if (isSuffix[prefixIndex]) {
            removeMagicHideAndShow.addSuffix(listSuffix, itemSuffix, prefixIndex, textView);
            isSuffix[prefixIndex] = false;
        } else {
            removeMagicHideAndShow.removeSuffix(listSuffix, itemSuffix, prefixIndex, textView);
            isSuffix[prefixIndex] = true;
        }
    }
}