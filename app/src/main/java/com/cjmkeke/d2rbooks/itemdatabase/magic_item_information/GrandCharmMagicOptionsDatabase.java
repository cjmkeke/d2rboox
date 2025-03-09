package com.cjmkeke.d2rbooks.itemdatabase.magic_item_information;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentGrandCharmMagicOptionsDatabaseBinding;

import java.util.ArrayList;
import java.util.List;

public class GrandCharmMagicOptionsDatabase extends Fragment {

    private FragmentGrandCharmMagicOptionsDatabaseBinding mBinding;
    private static final String TAG = "GrandCharmMagicOptionsDatabase";
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
        mBinding = FragmentGrandCharmMagicOptionsDatabaseBinding.inflate(inflater, container, false);

        for (int i = 0; i < isPrefix.length; i++) {
            isPrefix[i] = true;
            isSuffix[i] = true;
        }

        listPrefix.clear();
        listSuffix.clear();

        magicHideAndShow = new MagicHideAndShow(getContext(), listSuffix, listPrefix, itemPrefix, itemSuffix, mBinding.tvGrandCharmTitle);
        magicHideAndShow.setItemType("grand_charm");

        itemPrefix = new String[98];
        for (int i = 1; i <= 98; i++) {
            // 리소스 이름 동적 생성
            String resourceName = "item_options_grand_charm_" + i + "_prefix";
            // 'string' 타입에서 resourceName 에 해당하는 리소스 ID 찾기
            int resId = getResources().getIdentifier(resourceName, "string", getContext().getPackageName());
            // 유효한 리소스면 getString(...)으로 가져오고, 아니면 빈 문자열 처리
            itemPrefix[i - 1] = (resId != 0) ? getString(resId) : "";
        }

        itemSuffix = new String[37];
        for (int i = 1; i <= 37; i++) {
            // 리소스 이름 동적 생성
            String resourceName = "item_options_grand_charm_" + i + "_suffix";
            // 'string' 타입에서 resourceName 에 해당하는 리소스 ID 찾기
            int resId = getResources().getIdentifier(resourceName, "string", getContext().getPackageName());
            // 유효한 리소스면 getString(...)으로 가져오고, 아니면 빈 문자열 처리
            itemSuffix[i - 1] = (resId != 0) ? getString(resId) : "";
        }

        for (int i = 1; i < 98; i++) {
            int prefixId = getResources().getIdentifier("tv_grand_charm_prefix_" + i, "id", getContext().getPackageName());
            int suffixId = getResources().getIdentifier("tv_grand_charm_suffix_" + i, "id", getContext().getPackageName());
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

        mBinding.tvGrandCharmPrefix1.setOnClickListener(v -> handlePrefixClick(0, mBinding.tvGrandCharmPrefix1));
        mBinding.tvGrandCharmPrefix2.setOnClickListener(v -> handlePrefixClick(1, mBinding.tvGrandCharmPrefix2));
        mBinding.tvGrandCharmPrefix3.setOnClickListener(v -> handlePrefixClick(2, mBinding.tvGrandCharmPrefix3));
        mBinding.tvGrandCharmPrefix4.setOnClickListener(v -> handlePrefixClick(3, mBinding.tvGrandCharmPrefix4));
        mBinding.tvGrandCharmPrefix5.setOnClickListener(v -> handlePrefixClick(4, mBinding.tvGrandCharmPrefix5));
        mBinding.tvGrandCharmPrefix6.setOnClickListener(v -> handlePrefixClick(5, mBinding.tvGrandCharmPrefix6));
        mBinding.tvGrandCharmPrefix7.setOnClickListener(v -> handlePrefixClick(6, mBinding.tvGrandCharmPrefix7));
        mBinding.tvGrandCharmPrefix8.setOnClickListener(v -> handlePrefixClick(7, mBinding.tvGrandCharmPrefix8));
        mBinding.tvGrandCharmPrefix9.setOnClickListener(v -> handlePrefixClick(8, mBinding.tvGrandCharmPrefix9));
        mBinding.tvGrandCharmPrefix10.setOnClickListener(v -> handlePrefixClick(9, mBinding.tvGrandCharmPrefix10));
        mBinding.tvGrandCharmPrefix11.setOnClickListener(v -> handlePrefixClick(10, mBinding.tvGrandCharmPrefix11));
        mBinding.tvGrandCharmPrefix12.setOnClickListener(v -> handlePrefixClick(11, mBinding.tvGrandCharmPrefix12));
        mBinding.tvGrandCharmPrefix13.setOnClickListener(v -> handlePrefixClick(12, mBinding.tvGrandCharmPrefix13));
        mBinding.tvGrandCharmPrefix14.setOnClickListener(v -> handlePrefixClick(13, mBinding.tvGrandCharmPrefix14));
        mBinding.tvGrandCharmPrefix15.setOnClickListener(v -> handlePrefixClick(14, mBinding.tvGrandCharmPrefix15));
        mBinding.tvGrandCharmPrefix16.setOnClickListener(v -> handlePrefixClick(15, mBinding.tvGrandCharmPrefix16));
        mBinding.tvGrandCharmPrefix17.setOnClickListener(v -> handlePrefixClick(16, mBinding.tvGrandCharmPrefix17));
        mBinding.tvGrandCharmPrefix18.setOnClickListener(v -> handlePrefixClick(17, mBinding.tvGrandCharmPrefix18));
        mBinding.tvGrandCharmPrefix19.setOnClickListener(v -> handlePrefixClick(18, mBinding.tvGrandCharmPrefix19));
        mBinding.tvGrandCharmPrefix20.setOnClickListener(v -> handlePrefixClick(19, mBinding.tvGrandCharmPrefix20));
        mBinding.tvGrandCharmPrefix21.setOnClickListener(v -> handlePrefixClick(20, mBinding.tvGrandCharmPrefix21));
        mBinding.tvGrandCharmPrefix22.setOnClickListener(v -> handlePrefixClick(21, mBinding.tvGrandCharmPrefix22));
        mBinding.tvGrandCharmPrefix23.setOnClickListener(v -> handlePrefixClick(22, mBinding.tvGrandCharmPrefix23));
        mBinding.tvGrandCharmPrefix24.setOnClickListener(v -> handlePrefixClick(23, mBinding.tvGrandCharmPrefix24));
        mBinding.tvGrandCharmPrefix25.setOnClickListener(v -> handlePrefixClick(24, mBinding.tvGrandCharmPrefix25));
        mBinding.tvGrandCharmPrefix26.setOnClickListener(v -> handlePrefixClick(25, mBinding.tvGrandCharmPrefix26));
        mBinding.tvGrandCharmPrefix27.setOnClickListener(v -> handlePrefixClick(26, mBinding.tvGrandCharmPrefix27));
        mBinding.tvGrandCharmPrefix28.setOnClickListener(v -> handlePrefixClick(27, mBinding.tvGrandCharmPrefix28));
        mBinding.tvGrandCharmPrefix29.setOnClickListener(v -> handlePrefixClick(28, mBinding.tvGrandCharmPrefix29));
        mBinding.tvGrandCharmPrefix30.setOnClickListener(v -> handlePrefixClick(29, mBinding.tvGrandCharmPrefix30));
        mBinding.tvGrandCharmPrefix31.setOnClickListener(v -> handlePrefixClick(30, mBinding.tvGrandCharmPrefix31));
        mBinding.tvGrandCharmPrefix32.setOnClickListener(v -> handlePrefixClick(31, mBinding.tvGrandCharmPrefix32));
        mBinding.tvGrandCharmPrefix33.setOnClickListener(v -> handlePrefixClick(32, mBinding.tvGrandCharmPrefix33));
        mBinding.tvGrandCharmPrefix34.setOnClickListener(v -> handlePrefixClick(33, mBinding.tvGrandCharmPrefix34));
        mBinding.tvGrandCharmPrefix35.setOnClickListener(v -> handlePrefixClick(34, mBinding.tvGrandCharmPrefix35));
        mBinding.tvGrandCharmPrefix36.setOnClickListener(v -> handlePrefixClick(35, mBinding.tvGrandCharmPrefix36));
        mBinding.tvGrandCharmPrefix37.setOnClickListener(v -> handlePrefixClick(36, mBinding.tvGrandCharmPrefix37));
        mBinding.tvGrandCharmPrefix38.setOnClickListener(v -> handlePrefixClick(37, mBinding.tvGrandCharmPrefix38));
        mBinding.tvGrandCharmPrefix39.setOnClickListener(v -> handlePrefixClick(38, mBinding.tvGrandCharmPrefix39));
        mBinding.tvGrandCharmPrefix40.setOnClickListener(v -> handlePrefixClick(39, mBinding.tvGrandCharmPrefix40));
        mBinding.tvGrandCharmPrefix41.setOnClickListener(v -> handlePrefixClick(40, mBinding.tvGrandCharmPrefix41));
        mBinding.tvGrandCharmPrefix42.setOnClickListener(v -> handlePrefixClick(41, mBinding.tvGrandCharmPrefix42));
        mBinding.tvGrandCharmPrefix43.setOnClickListener(v -> handlePrefixClick(42, mBinding.tvGrandCharmPrefix43));
        mBinding.tvGrandCharmPrefix44.setOnClickListener(v -> handlePrefixClick(43, mBinding.tvGrandCharmPrefix44));
        mBinding.tvGrandCharmPrefix45.setOnClickListener(v -> handlePrefixClick(44, mBinding.tvGrandCharmPrefix45));
        mBinding.tvGrandCharmPrefix46.setOnClickListener(v -> handlePrefixClick(45, mBinding.tvGrandCharmPrefix46));
        mBinding.tvGrandCharmPrefix47.setOnClickListener(v -> handlePrefixClick(46, mBinding.tvGrandCharmPrefix47));
        mBinding.tvGrandCharmPrefix48.setOnClickListener(v -> handlePrefixClick(47, mBinding.tvGrandCharmPrefix48));
        mBinding.tvGrandCharmPrefix49.setOnClickListener(v -> handlePrefixClick(48, mBinding.tvGrandCharmPrefix49));
        mBinding.tvGrandCharmPrefix50.setOnClickListener(v -> handlePrefixClick(49, mBinding.tvGrandCharmPrefix50));
        mBinding.tvGrandCharmPrefix51.setOnClickListener(v -> handlePrefixClick(50, mBinding.tvGrandCharmPrefix51));
        mBinding.tvGrandCharmPrefix52.setOnClickListener(v -> handlePrefixClick(51, mBinding.tvGrandCharmPrefix52));
        mBinding.tvGrandCharmPrefix53.setOnClickListener(v -> handlePrefixClick(52, mBinding.tvGrandCharmPrefix53));
        mBinding.tvGrandCharmPrefix54.setOnClickListener(v -> handlePrefixClick(53, mBinding.tvGrandCharmPrefix54));
        mBinding.tvGrandCharmPrefix55.setOnClickListener(v -> handlePrefixClick(54, mBinding.tvGrandCharmPrefix55));
        mBinding.tvGrandCharmPrefix56.setOnClickListener(v -> handlePrefixClick(55, mBinding.tvGrandCharmPrefix56));
        mBinding.tvGrandCharmPrefix57.setOnClickListener(v -> handlePrefixClick(56, mBinding.tvGrandCharmPrefix57));
        mBinding.tvGrandCharmPrefix58.setOnClickListener(v -> handlePrefixClick(57, mBinding.tvGrandCharmPrefix58));
        mBinding.tvGrandCharmPrefix59.setOnClickListener(v -> handlePrefixClick(58, mBinding.tvGrandCharmPrefix59));
        mBinding.tvGrandCharmPrefix60.setOnClickListener(v -> handlePrefixClick(59, mBinding.tvGrandCharmPrefix60));
        mBinding.tvGrandCharmPrefix61.setOnClickListener(v -> handlePrefixClick(60, mBinding.tvGrandCharmPrefix61));
        mBinding.tvGrandCharmPrefix62.setOnClickListener(v -> handlePrefixClick(61, mBinding.tvGrandCharmPrefix62));
        mBinding.tvGrandCharmPrefix63.setOnClickListener(v -> handlePrefixClick(62, mBinding.tvGrandCharmPrefix63));
        mBinding.tvGrandCharmPrefix64.setOnClickListener(v -> handlePrefixClick(63, mBinding.tvGrandCharmPrefix64));
        mBinding.tvGrandCharmPrefix65.setOnClickListener(v -> handlePrefixClick(64, mBinding.tvGrandCharmPrefix65));
        mBinding.tvGrandCharmPrefix66.setOnClickListener(v -> handlePrefixClick(65, mBinding.tvGrandCharmPrefix66));
        mBinding.tvGrandCharmPrefix67.setOnClickListener(v -> handlePrefixClick(66, mBinding.tvGrandCharmPrefix67));
        mBinding.tvGrandCharmPrefix68.setOnClickListener(v -> handlePrefixClick(67, mBinding.tvGrandCharmPrefix68));
        mBinding.tvGrandCharmPrefix69.setOnClickListener(v -> handlePrefixClick(68, mBinding.tvGrandCharmPrefix69));
        mBinding.tvGrandCharmPrefix70.setOnClickListener(v -> handlePrefixClick(69, mBinding.tvGrandCharmPrefix70));
        mBinding.tvGrandCharmPrefix71.setOnClickListener(v -> handlePrefixClick(70, mBinding.tvGrandCharmPrefix71));
        mBinding.tvGrandCharmPrefix72.setOnClickListener(v -> handlePrefixClick(71, mBinding.tvGrandCharmPrefix72));
        mBinding.tvGrandCharmPrefix73.setOnClickListener(v -> handlePrefixClick(72, mBinding.tvGrandCharmPrefix73));
        mBinding.tvGrandCharmPrefix74.setOnClickListener(v -> handlePrefixClick(73, mBinding.tvGrandCharmPrefix74));
        mBinding.tvGrandCharmPrefix75.setOnClickListener(v -> handlePrefixClick(74, mBinding.tvGrandCharmPrefix75));
        mBinding.tvGrandCharmPrefix76.setOnClickListener(v -> handlePrefixClick(75, mBinding.tvGrandCharmPrefix76));
        mBinding.tvGrandCharmPrefix77.setOnClickListener(v -> handlePrefixClick(76, mBinding.tvGrandCharmPrefix77));
        mBinding.tvGrandCharmPrefix78.setOnClickListener(v -> handlePrefixClick(77, mBinding.tvGrandCharmPrefix78));
        mBinding.tvGrandCharmPrefix79.setOnClickListener(v -> handlePrefixClick(78, mBinding.tvGrandCharmPrefix79));
        mBinding.tvGrandCharmPrefix80.setOnClickListener(v -> handlePrefixClick(79, mBinding.tvGrandCharmPrefix80));
        mBinding.tvGrandCharmPrefix81.setOnClickListener(v -> handlePrefixClick(80, mBinding.tvGrandCharmPrefix81));
        mBinding.tvGrandCharmPrefix82.setOnClickListener(v -> handlePrefixClick(81, mBinding.tvGrandCharmPrefix82));
        mBinding.tvGrandCharmPrefix83.setOnClickListener(v -> handlePrefixClick(82, mBinding.tvGrandCharmPrefix83));
        mBinding.tvGrandCharmPrefix84.setOnClickListener(v -> handlePrefixClick(83, mBinding.tvGrandCharmPrefix84));
        mBinding.tvGrandCharmPrefix85.setOnClickListener(v -> handlePrefixClick(84, mBinding.tvGrandCharmPrefix85));
        mBinding.tvGrandCharmPrefix86.setOnClickListener(v -> handlePrefixClick(85, mBinding.tvGrandCharmPrefix86));
        mBinding.tvGrandCharmPrefix87.setOnClickListener(v -> handlePrefixClick(86, mBinding.tvGrandCharmPrefix87));
        mBinding.tvGrandCharmPrefix88.setOnClickListener(v -> handlePrefixClick(87, mBinding.tvGrandCharmPrefix88));
        mBinding.tvGrandCharmPrefix89.setOnClickListener(v -> handlePrefixClick(88, mBinding.tvGrandCharmPrefix89));
        mBinding.tvGrandCharmPrefix90.setOnClickListener(v -> handlePrefixClick(89, mBinding.tvGrandCharmPrefix90));
        mBinding.tvGrandCharmPrefix91.setOnClickListener(v -> handlePrefixClick(90, mBinding.tvGrandCharmPrefix91));
        mBinding.tvGrandCharmPrefix92.setOnClickListener(v -> handlePrefixClick(91, mBinding.tvGrandCharmPrefix92));
        mBinding.tvGrandCharmPrefix93.setOnClickListener(v -> handlePrefixClick(92, mBinding.tvGrandCharmPrefix93));
        mBinding.tvGrandCharmPrefix94.setOnClickListener(v -> handlePrefixClick(93, mBinding.tvGrandCharmPrefix94));
        mBinding.tvGrandCharmPrefix95.setOnClickListener(v -> handlePrefixClick(94, mBinding.tvGrandCharmPrefix95));
        mBinding.tvGrandCharmPrefix96.setOnClickListener(v -> handlePrefixClick(95, mBinding.tvGrandCharmPrefix96));
        mBinding.tvGrandCharmPrefix97.setOnClickListener(v -> handlePrefixClick(96, mBinding.tvGrandCharmPrefix97));
        mBinding.tvGrandCharmPrefix98.setOnClickListener(v -> handlePrefixClick(97, mBinding.tvGrandCharmPrefix98));


        // TODO SUFFIX
        mBinding.tvGrandCharmSuffix1.setOnClickListener(v -> handleSuffixClick(0, mBinding.tvGrandCharmSuffix1));
        mBinding.tvGrandCharmSuffix2.setOnClickListener(v -> handleSuffixClick(1, mBinding.tvGrandCharmSuffix2));
        mBinding.tvGrandCharmSuffix3.setOnClickListener(v -> handleSuffixClick(2, mBinding.tvGrandCharmSuffix3));
        mBinding.tvGrandCharmSuffix4.setOnClickListener(v -> handleSuffixClick(3, mBinding.tvGrandCharmSuffix4));
        mBinding.tvGrandCharmSuffix5.setOnClickListener(v -> handleSuffixClick(4, mBinding.tvGrandCharmSuffix5));
        mBinding.tvGrandCharmSuffix6.setOnClickListener(v -> handleSuffixClick(5, mBinding.tvGrandCharmSuffix6));
        mBinding.tvGrandCharmSuffix7.setOnClickListener(v -> handleSuffixClick(6, mBinding.tvGrandCharmSuffix7));
        mBinding.tvGrandCharmSuffix8.setOnClickListener(v -> handleSuffixClick(7, mBinding.tvGrandCharmSuffix8));
        mBinding.tvGrandCharmSuffix9.setOnClickListener(v -> handleSuffixClick(8, mBinding.tvGrandCharmSuffix9));
        mBinding.tvGrandCharmSuffix10.setOnClickListener(v -> handleSuffixClick(9, mBinding.tvGrandCharmSuffix10));
        mBinding.tvGrandCharmSuffix11.setOnClickListener(v -> handleSuffixClick(10, mBinding.tvGrandCharmSuffix11));
        mBinding.tvGrandCharmSuffix12.setOnClickListener(v -> {
            handleSuffixClick(11, mBinding.tvGrandCharmSuffix12);
            Toast.makeText(getContext(), "혼돈계  및 이벤트 보스에서 나오는 접미사, 가능성은 제로", Toast.LENGTH_SHORT).show();
        });
        mBinding.tvGrandCharmSuffix13.setOnClickListener(v -> handleSuffixClick(12, mBinding.tvGrandCharmSuffix13));
        mBinding.tvGrandCharmSuffix14.setOnClickListener(v -> handleSuffixClick(13, mBinding.tvGrandCharmSuffix14));
        mBinding.tvGrandCharmSuffix15.setOnClickListener(v -> handleSuffixClick(14, mBinding.tvGrandCharmSuffix15));
        mBinding.tvGrandCharmSuffix16.setOnClickListener(v -> handleSuffixClick(15, mBinding.tvGrandCharmSuffix16));
        mBinding.tvGrandCharmSuffix17.setOnClickListener(v -> handleSuffixClick(16, mBinding.tvGrandCharmSuffix17));
        mBinding.tvGrandCharmSuffix18.setOnClickListener(v -> handleSuffixClick(17, mBinding.tvGrandCharmSuffix18));
        mBinding.tvGrandCharmSuffix19.setOnClickListener(v -> handleSuffixClick(18, mBinding.tvGrandCharmSuffix19));
        mBinding.tvGrandCharmSuffix20.setOnClickListener(v -> handleSuffixClick(19, mBinding.tvGrandCharmSuffix20));
        mBinding.tvGrandCharmSuffix21.setOnClickListener(v -> handleSuffixClick(20, mBinding.tvGrandCharmSuffix21));
        mBinding.tvGrandCharmSuffix22.setOnClickListener(v -> handleSuffixClick(21, mBinding.tvGrandCharmSuffix22));
        mBinding.tvGrandCharmSuffix23.setOnClickListener(v -> handleSuffixClick(22, mBinding.tvGrandCharmSuffix23));
        mBinding.tvGrandCharmSuffix24.setOnClickListener(v -> handleSuffixClick(23, mBinding.tvGrandCharmSuffix24));
        mBinding.tvGrandCharmSuffix25.setOnClickListener(v -> handleSuffixClick(24, mBinding.tvGrandCharmSuffix25));
        mBinding.tvGrandCharmSuffix26.setOnClickListener(v -> handleSuffixClick(25, mBinding.tvGrandCharmSuffix26));
        mBinding.tvGrandCharmSuffix27.setOnClickListener(v -> handleSuffixClick(26, mBinding.tvGrandCharmSuffix27));
        mBinding.tvGrandCharmSuffix28.setOnClickListener(v -> handleSuffixClick(27, mBinding.tvGrandCharmSuffix28));
        mBinding.tvGrandCharmSuffix29.setOnClickListener(v -> handleSuffixClick(28, mBinding.tvGrandCharmSuffix29));
        mBinding.tvGrandCharmSuffix30.setOnClickListener(v -> handleSuffixClick(29, mBinding.tvGrandCharmSuffix30));
        mBinding.tvGrandCharmSuffix31.setOnClickListener(v -> handleSuffixClick(30, mBinding.tvGrandCharmSuffix31));
        mBinding.tvGrandCharmSuffix32.setOnClickListener(v -> handleSuffixClick(31, mBinding.tvGrandCharmSuffix32));
        mBinding.tvGrandCharmSuffix33.setOnClickListener(v -> handleSuffixClick(32, mBinding.tvGrandCharmSuffix33));
        mBinding.tvGrandCharmSuffix34.setOnClickListener(v -> handleSuffixClick(33, mBinding.tvGrandCharmSuffix34));
        mBinding.tvGrandCharmSuffix35.setOnClickListener(v -> handleSuffixClick(34, mBinding.tvGrandCharmSuffix35));
        mBinding.tvGrandCharmSuffix36.setOnClickListener(v -> handleSuffixClick(35, mBinding.tvGrandCharmSuffix36));
        mBinding.tvGrandCharmSuffix37.setOnClickListener(v -> handleSuffixClick(36, mBinding.tvGrandCharmSuffix37));

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