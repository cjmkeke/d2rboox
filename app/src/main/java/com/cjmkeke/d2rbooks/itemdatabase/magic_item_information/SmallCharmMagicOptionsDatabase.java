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
import com.cjmkeke.d2rbooks.databinding.FragmentSmallCharmMagicOptionsDatabaseBinding;

import java.util.ArrayList;
import java.util.List;

public class SmallCharmMagicOptionsDatabase extends Fragment {

    private FragmentSmallCharmMagicOptionsDatabaseBinding mBinding;
    private static final String TAG = "SmallCharmMagicOptionsDatabase";
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
        mBinding = FragmentSmallCharmMagicOptionsDatabaseBinding.inflate(inflater, container, false);

        listPrefix.clear();
        listSuffix.clear();

        for (int i = 0; i < isPrefix.length; i++) {
            isPrefix[i] = true;
            isSuffix[i] = true;
        }

        // TODO 접두사
        itemPrefix = new String[]{
                getString(R.string.item_options_small_charm_1_prefix), getString(R.string.item_options_small_charm_2_prefix), getString(R.string.item_options_small_charm_3_prefix),
                getString(R.string.item_options_small_charm_4_prefix), getString(R.string.item_options_small_charm_5_prefix), getString(R.string.item_options_small_charm_6_prefix),
                getString(R.string.item_options_small_charm_7_prefix), getString(R.string.item_options_small_charm_8_prefix), getString(R.string.item_options_small_charm_9_prefix),
                getString(R.string.item_options_small_charm_10_prefix), getString(R.string.item_options_small_charm_11_prefix), getString(R.string.item_options_small_charm_12_prefix),
                getString(R.string.item_options_small_charm_13_prefix), getString(R.string.item_options_small_charm_14_prefix), getString(R.string.item_options_small_charm_15_prefix),
                getString(R.string.item_options_small_charm_16_prefix), getString(R.string.item_options_small_charm_17_prefix), getString(R.string.item_options_small_charm_18_prefix),
                getString(R.string.item_options_small_charm_19_prefix), getString(R.string.item_options_small_charm_20_prefix), getString(R.string.item_options_small_charm_21_prefix),
                getString(R.string.item_options_small_charm_22_prefix), getString(R.string.item_options_small_charm_23_prefix), getString(R.string.item_options_small_charm_24_prefix),
                getString(R.string.item_options_small_charm_25_prefix), getString(R.string.item_options_small_charm_26_prefix), getString(R.string.item_options_small_charm_27_prefix),
                getString(R.string.item_options_small_charm_28_prefix), getString(R.string.item_options_small_charm_29_prefix), getString(R.string.item_options_small_charm_30_prefix),
                getString(R.string.item_options_small_charm_31_prefix), getString(R.string.item_options_small_charm_32_prefix), getString(R.string.item_options_small_charm_33_prefix),
                getString(R.string.item_options_small_charm_34_prefix), getString(R.string.item_options_small_charm_35_prefix), getString(R.string.item_options_small_charm_36_prefix),
                getString(R.string.item_options_small_charm_37_prefix), getString(R.string.item_options_small_charm_38_prefix), getString(R.string.item_options_small_charm_39_prefix),
                getString(R.string.item_options_small_charm_40_prefix), getString(R.string.item_options_small_charm_41_prefix), getString(R.string.item_options_small_charm_42_prefix),
                getString(R.string.item_options_small_charm_43_prefix), getString(R.string.item_options_small_charm_44_prefix), getString(R.string.item_options_small_charm_45_prefix),
                getString(R.string.item_options_small_charm_46_prefix), getString(R.string.item_options_small_charm_47_prefix), getString(R.string.item_options_small_charm_48_prefix),
                getString(R.string.item_options_small_charm_49_prefix)

        };

        // TODO 접미사
        itemSuffix = new String[]{
                getString(R.string.item_options_small_charm_1_suffix), getString(R.string.item_options_small_charm_2_suffix), getString(R.string.item_options_small_charm_3_suffix),
                getString(R.string.item_options_small_charm_4_suffix), getString(R.string.item_options_small_charm_5_suffix), getString(R.string.item_options_small_charm_6_suffix),
                getString(R.string.item_options_small_charm_7_suffix), getString(R.string.item_options_small_charm_8_suffix), getString(R.string.item_options_small_charm_9_suffix),
                getString(R.string.item_options_small_charm_10_suffix), getString(R.string.item_options_small_charm_11_suffix), getString(R.string.item_options_small_charm_12_suffix),
                getString(R.string.item_options_small_charm_13_suffix), getString(R.string.item_options_small_charm_14_suffix), getString(R.string.item_options_small_charm_15_suffix),
                getString(R.string.item_options_small_charm_16_suffix), getString(R.string.item_options_small_charm_17_suffix), getString(R.string.item_options_small_charm_18_suffix),
                getString(R.string.item_options_small_charm_19_suffix), getString(R.string.item_options_small_charm_20_suffix), getString(R.string.item_options_small_charm_21_suffix),
                getString(R.string.item_options_small_charm_22_suffix), getString(R.string.item_options_small_charm_23_suffix), getString(R.string.item_options_small_charm_24_suffix),
                getString(R.string.item_options_small_charm_25_suffix), getString(R.string.item_options_small_charm_26_suffix), getString(R.string.item_options_small_charm_27_suffix),
                getString(R.string.item_options_small_charm_28_suffix), getString(R.string.item_options_small_charm_29_suffix)
        };

        magicHideAndShow = new MagicHideAndShow(getContext(), listSuffix, listPrefix, itemPrefix, itemSuffix, mBinding.tvSmallCharmTitle);
        magicHideAndShow.setItemType("small_charm");

        for (int i = 1; i < 46; i++) {
            int prefixId = getResources().getIdentifier("tv_small_charm_prefix_" + i, "id", getContext().getPackageName());
            int suffixId = getResources().getIdentifier("tv_small_charm_suffix_" + i, "id", getContext().getPackageName());
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

        mBinding.tvSmallCharmPrefix1.setOnClickListener(v -> handlePrefixClick(0, mBinding.tvSmallCharmPrefix1));
        mBinding.tvSmallCharmPrefix2.setOnClickListener(v -> handlePrefixClick(1, mBinding.tvSmallCharmPrefix2));
        mBinding.tvSmallCharmPrefix3.setOnClickListener(v -> handlePrefixClick(2, mBinding.tvSmallCharmPrefix3));
        mBinding.tvSmallCharmPrefix4.setOnClickListener(v -> handlePrefixClick(3, mBinding.tvSmallCharmPrefix4));
        mBinding.tvSmallCharmPrefix5.setOnClickListener(v -> handlePrefixClick(4, mBinding.tvSmallCharmPrefix5));
        mBinding.tvSmallCharmPrefix6.setOnClickListener(v -> handlePrefixClick(5, mBinding.tvSmallCharmPrefix6));
        mBinding.tvSmallCharmPrefix7.setOnClickListener(v -> handlePrefixClick(6, mBinding.tvSmallCharmPrefix7));
        mBinding.tvSmallCharmPrefix8.setOnClickListener(v -> handlePrefixClick(7, mBinding.tvSmallCharmPrefix8));
        mBinding.tvSmallCharmPrefix9.setOnClickListener(v -> handlePrefixClick(8, mBinding.tvSmallCharmPrefix9));
        mBinding.tvSmallCharmPrefix10.setOnClickListener(v -> handlePrefixClick(9, mBinding.tvSmallCharmPrefix10));
        mBinding.tvSmallCharmPrefix11.setOnClickListener(v -> handlePrefixClick(10, mBinding.tvSmallCharmPrefix11));
        mBinding.tvSmallCharmPrefix12.setOnClickListener(v -> handlePrefixClick(11, mBinding.tvSmallCharmPrefix12));
        mBinding.tvSmallCharmPrefix13.setOnClickListener(v -> handlePrefixClick(12, mBinding.tvSmallCharmPrefix13));
        mBinding.tvSmallCharmPrefix14.setOnClickListener(v -> handlePrefixClick(13, mBinding.tvSmallCharmPrefix14));
        mBinding.tvSmallCharmPrefix15.setOnClickListener(v -> handlePrefixClick(14, mBinding.tvSmallCharmPrefix15));
        mBinding.tvSmallCharmPrefix16.setOnClickListener(v -> handlePrefixClick(15, mBinding.tvSmallCharmPrefix16));
        mBinding.tvSmallCharmPrefix17.setOnClickListener(v -> handlePrefixClick(16, mBinding.tvSmallCharmPrefix17));
        mBinding.tvSmallCharmPrefix18.setOnClickListener(v -> handlePrefixClick(17, mBinding.tvSmallCharmPrefix18));
        mBinding.tvSmallCharmPrefix19.setOnClickListener(v -> handlePrefixClick(18, mBinding.tvSmallCharmPrefix19));
        mBinding.tvSmallCharmPrefix20.setOnClickListener(v -> handlePrefixClick(19, mBinding.tvSmallCharmPrefix20));
        mBinding.tvSmallCharmPrefix21.setOnClickListener(v -> handlePrefixClick(20, mBinding.tvSmallCharmPrefix21));
        mBinding.tvSmallCharmPrefix22.setOnClickListener(v -> handlePrefixClick(21, mBinding.tvSmallCharmPrefix22));
        mBinding.tvSmallCharmPrefix23.setOnClickListener(v -> handlePrefixClick(22, mBinding.tvSmallCharmPrefix23));
        mBinding.tvSmallCharmPrefix24.setOnClickListener(v -> handlePrefixClick(23, mBinding.tvSmallCharmPrefix24));
        mBinding.tvSmallCharmPrefix25.setOnClickListener(v -> handlePrefixClick(24, mBinding.tvSmallCharmPrefix25));
        mBinding.tvSmallCharmPrefix26.setOnClickListener(v -> handlePrefixClick(25, mBinding.tvSmallCharmPrefix26));
        mBinding.tvSmallCharmPrefix27.setOnClickListener(v -> handlePrefixClick(26, mBinding.tvSmallCharmPrefix27));
        mBinding.tvSmallCharmPrefix28.setOnClickListener(v -> handlePrefixClick(27, mBinding.tvSmallCharmPrefix28));
        mBinding.tvSmallCharmPrefix29.setOnClickListener(v -> handlePrefixClick(28, mBinding.tvSmallCharmPrefix29));
        mBinding.tvSmallCharmPrefix30.setOnClickListener(v -> handlePrefixClick(29, mBinding.tvSmallCharmPrefix30));
        mBinding.tvSmallCharmPrefix31.setOnClickListener(v -> handlePrefixClick(30, mBinding.tvSmallCharmPrefix31));
        mBinding.tvSmallCharmPrefix32.setOnClickListener(v -> handlePrefixClick(31, mBinding.tvSmallCharmPrefix32));
        mBinding.tvSmallCharmPrefix33.setOnClickListener(v -> handlePrefixClick(32, mBinding.tvSmallCharmPrefix33));
        mBinding.tvSmallCharmPrefix34.setOnClickListener(v -> handlePrefixClick(33, mBinding.tvSmallCharmPrefix34));
        mBinding.tvSmallCharmPrefix35.setOnClickListener(v -> handlePrefixClick(34, mBinding.tvSmallCharmPrefix35));
        mBinding.tvSmallCharmPrefix36.setOnClickListener(v -> handlePrefixClick(35, mBinding.tvSmallCharmPrefix36));
        mBinding.tvSmallCharmPrefix37.setOnClickListener(v -> handlePrefixClick(36, mBinding.tvSmallCharmPrefix37));
        mBinding.tvSmallCharmPrefix38.setOnClickListener(v -> handlePrefixClick(37, mBinding.tvSmallCharmPrefix38));
        mBinding.tvSmallCharmPrefix39.setOnClickListener(v -> handlePrefixClick(38, mBinding.tvSmallCharmPrefix39));
        mBinding.tvSmallCharmPrefix40.setOnClickListener(v -> handlePrefixClick(39, mBinding.tvSmallCharmPrefix40));
        mBinding.tvSmallCharmPrefix41.setOnClickListener(v -> handlePrefixClick(40, mBinding.tvSmallCharmPrefix41));
        mBinding.tvSmallCharmPrefix42.setOnClickListener(v -> handlePrefixClick(41, mBinding.tvSmallCharmPrefix42));
        mBinding.tvSmallCharmPrefix43.setOnClickListener(v -> handlePrefixClick(42, mBinding.tvSmallCharmPrefix43));
        mBinding.tvSmallCharmPrefix44.setOnClickListener(v -> handlePrefixClick(43, mBinding.tvSmallCharmPrefix44));
        mBinding.tvSmallCharmPrefix45.setOnClickListener(v -> handlePrefixClick(44, mBinding.tvSmallCharmPrefix45));
        mBinding.tvSmallCharmPrefix46.setOnClickListener(v -> handlePrefixClick(45, mBinding.tvSmallCharmPrefix46));
        mBinding.tvSmallCharmPrefix47.setOnClickListener(v -> handlePrefixClick(46, mBinding.tvSmallCharmPrefix47));
        mBinding.tvSmallCharmPrefix48.setOnClickListener(v -> handlePrefixClick(47, mBinding.tvSmallCharmPrefix48));
        mBinding.tvSmallCharmPrefix49.setOnClickListener(v -> handlePrefixClick(48, mBinding.tvSmallCharmPrefix49));

        // TODO SUFFIX
        mBinding.tvSmallCharmSuffix1.setOnClickListener(v -> handleSuffixClick(0, mBinding.tvSmallCharmSuffix1));
        mBinding.tvSmallCharmSuffix2.setOnClickListener(v -> handleSuffixClick(1, mBinding.tvSmallCharmSuffix2));
        mBinding.tvSmallCharmSuffix3.setOnClickListener(v -> handleSuffixClick(2, mBinding.tvSmallCharmSuffix3));
        mBinding.tvSmallCharmSuffix4.setOnClickListener(v -> handleSuffixClick(3, mBinding.tvSmallCharmSuffix4));
        mBinding.tvSmallCharmSuffix5.setOnClickListener(v -> handleSuffixClick(4, mBinding.tvSmallCharmSuffix5));
        mBinding.tvSmallCharmSuffix6.setOnClickListener(v -> handleSuffixClick(5, mBinding.tvSmallCharmSuffix6));
        mBinding.tvSmallCharmSuffix7.setOnClickListener(v -> handleSuffixClick(6, mBinding.tvSmallCharmSuffix7));
        mBinding.tvSmallCharmSuffix8.setOnClickListener(v -> handleSuffixClick(7, mBinding.tvSmallCharmSuffix8));
        mBinding.tvSmallCharmSuffix9.setOnClickListener(v -> handleSuffixClick(8, mBinding.tvSmallCharmSuffix9));
        mBinding.tvSmallCharmSuffix10.setOnClickListener(v -> handleSuffixClick(9, mBinding.tvSmallCharmSuffix10));
        mBinding.tvSmallCharmSuffix11.setOnClickListener(v -> handleSuffixClick(10, mBinding.tvSmallCharmSuffix11));
        mBinding.tvSmallCharmSuffix12.setOnClickListener(v -> handleSuffixClick(11, mBinding.tvSmallCharmSuffix12));
        mBinding.tvSmallCharmSuffix13.setOnClickListener(v -> handleSuffixClick(12, mBinding.tvSmallCharmSuffix13));
        mBinding.tvSmallCharmSuffix14.setOnClickListener(v -> handleSuffixClick(13, mBinding.tvSmallCharmSuffix14));
        mBinding.tvSmallCharmSuffix15.setOnClickListener(v -> handleSuffixClick(14, mBinding.tvSmallCharmSuffix15));
        mBinding.tvSmallCharmSuffix16.setOnClickListener(v -> handleSuffixClick(15, mBinding.tvSmallCharmSuffix16));
        mBinding.tvSmallCharmSuffix17.setOnClickListener(v -> handleSuffixClick(16, mBinding.tvSmallCharmSuffix17));
        mBinding.tvSmallCharmSuffix18.setOnClickListener(v -> handleSuffixClick(17, mBinding.tvSmallCharmSuffix18));
        mBinding.tvSmallCharmSuffix19.setOnClickListener(v -> handleSuffixClick(18, mBinding.tvSmallCharmSuffix19));
        mBinding.tvSmallCharmSuffix20.setOnClickListener(v -> handleSuffixClick(19, mBinding.tvSmallCharmSuffix20));
        mBinding.tvSmallCharmSuffix21.setOnClickListener(v -> handleSuffixClick(20, mBinding.tvSmallCharmSuffix21));
        mBinding.tvSmallCharmSuffix22.setOnClickListener(v -> handleSuffixClick(21, mBinding.tvSmallCharmSuffix22));
        mBinding.tvSmallCharmSuffix23.setOnClickListener(v -> handleSuffixClick(22, mBinding.tvSmallCharmSuffix23));
        mBinding.tvSmallCharmSuffix24.setOnClickListener(v -> handleSuffixClick(23, mBinding.tvSmallCharmSuffix24));
        mBinding.tvSmallCharmSuffix25.setOnClickListener(v -> handleSuffixClick(24, mBinding.tvSmallCharmSuffix25));
        mBinding.tvSmallCharmSuffix26.setOnClickListener(v -> handleSuffixClick(25, mBinding.tvSmallCharmSuffix26));
        mBinding.tvSmallCharmSuffix27.setOnClickListener(v -> handleSuffixClick(26, mBinding.tvSmallCharmSuffix27));
        mBinding.tvSmallCharmSuffix28.setOnClickListener(v -> handleSuffixClick(27, mBinding.tvSmallCharmSuffix28));
        mBinding.tvSmallCharmSuffix29.setOnClickListener(v -> handleSuffixClick(28, mBinding.tvSmallCharmSuffix29));

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