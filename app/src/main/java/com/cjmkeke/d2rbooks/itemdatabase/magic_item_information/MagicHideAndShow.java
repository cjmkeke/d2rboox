package com.cjmkeke.d2rbooks.itemdatabase.magic_item_information;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.cjmkeke.d2rbooks.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MagicHideAndShow {

    private static final String TAG = "HideAndShow";
    private Context context;
    private List<String> optionsSuffix = new ArrayList<>();
    private List<String> optionsPrefix = new ArrayList<>();
    private TextView textView;
    private String[] addOptionsSuffix;
    private String[] addOptionsPrefix;
    private String itemType = "";
    private Map<Integer, Drawable> initialBackgroundMap = new HashMap<>();
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;

    public MagicHideAndShow(Context context, List<String> optionsSuffix, List<String> optionsPrefix, String[] addOptionsPrefix, String[] addOptionsSuffix, TextView textView) {
        this.optionsSuffix.clear();
        this.optionsPrefix.clear();
        this.context = context;
        this.optionsSuffix = optionsSuffix;
        this.optionsPrefix = optionsPrefix;
        this.textView = textView;
        this.addOptionsPrefix = addOptionsPrefix;
        this.addOptionsSuffix = addOptionsSuffix;
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("item_data").child("high_level_item").child("small_charm");
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    private void saveInitialBackground(TextView textView) {
        int viewId = textView.getId(); // TextView의 ID 가져오기

        // 해당 ID의 초기 배경이 저장되어 있지 않으면 저장
        if (!initialBackgroundMap.containsKey(viewId)) {
            Drawable initialBackground = textView.getBackground(); // 현재 배경 저장
            initialBackgroundMap.put(viewId, initialBackground);  // Map에 저장
        }
    }

    public void addSuffix(List<String> optionsSuffix, String[] addOptionsSuffix, int num, TextView textView) {
        // 초기 배경 저장
        saveInitialBackground(textView);

        // 옵션 개수 검사
        if (optionsSuffix.size() == 1) {
            Toast.makeText(context, "접미사를 1개 이상 초과할수 없습니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        // 새로운 배경 설정
        int res = context.getResources().getIdentifier("dw_uber_6", "drawable", context.getPackageName());
        textView.setBackgroundResource(res); // 새로운 배경 적용

        // 옵션 추가
        optionsSuffix.add(addOptionsSuffix[num]);

        if (itemType.equals("large_charm")) {
            addLargeCharmViewOptions(optionsSuffix, optionsPrefix);
        } else if (itemType.equals("small_charm")) {
            addSmallCharmViewOptions(optionsSuffix, optionsPrefix);
        } else if (itemType.equals("grand_charm")) {
            addGrandCharmViewOptions(optionsSuffix, optionsPrefix);
        } else if (itemType.equals("jewel")) {
            addJewelViewOptions(optionsSuffix, optionsPrefix);
        }
    }

    public void addPreFix(List<String> optionsPrefix, String[] addOptionsPrefix, int num, TextView textView) {
        // 초기 배경 저장
        saveInitialBackground(textView);

        // 조건 검사
        if (optionsPrefix.size() >= 1) { // 조건 수정
            Toast.makeText(context, "접두사를 1개 이상 초과할수 없습니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        // 새로운 배경 설정
        int res = context.getResources().getIdentifier("dw_uber_6", "drawable", context.getPackageName());
        textView.setBackgroundResource(res); // 새로운 배경 적용

        // 접두사 추가
        optionsPrefix.add(addOptionsPrefix[num]);

        if (itemType.equals("large_charm")) {
            addLargeCharmViewOptions(optionsSuffix, optionsPrefix);
        } else if (itemType.equals("small_charm")) {
            addSmallCharmViewOptions(optionsSuffix, optionsPrefix);
        } else if (itemType.equals("grand_charm")) {
            addGrandCharmViewOptions(optionsSuffix, optionsPrefix);
        } else if (itemType.equals("jewel")) {
            addJewelViewOptions(optionsSuffix, optionsPrefix);
        }
    }

    public void removeSuffix(List<String> optionsSuffix, String[] addOptionsSuffix, int num, TextView textView) {
        // 초기 배경 저장
        saveInitialBackground(textView);

        // 초기 배경 복구
        int viewId = textView.getId(); // TextView ID 가져오기
        if (initialBackgroundMap.containsKey(viewId)) {
            textView.setBackground(initialBackgroundMap.get(viewId)); // 초기 배경으로 복구
        }

        // 옵션 제거
        optionsSuffix.remove(addOptionsSuffix[num]);

        if (itemType.equals("large_charm")) {
            addLargeCharmViewOptions(optionsSuffix, optionsPrefix);
        } else if (itemType.equals("small_charm")) {
            addSmallCharmViewOptions(optionsSuffix, optionsPrefix);
        } else if (itemType.equals("grand_charm")) {
            addGrandCharmViewOptions(optionsSuffix, optionsPrefix);
        } else if (itemType.equals("jewel")) {
            addJewelViewOptions(optionsSuffix, optionsPrefix);
        }
    }

    public void removePreFix(List<String> optionsPrefix, String[] addOptionsPrefix, int num, TextView textView) {
        // 초기 배경 저장
        saveInitialBackground(textView);

        // 옵션 제거
        optionsPrefix.remove(addOptionsPrefix[num]);

        // 초기 배경 복구
        int viewId = textView.getId(); // TextView ID 가져오기
        if (initialBackgroundMap.containsKey(viewId)) {
            textView.setBackground(initialBackgroundMap.get(viewId)); // 초기 배경으로 복구
        }

        if (itemType.equals("large_charm")) {
            addLargeCharmViewOptions(optionsSuffix, optionsPrefix);
        } else if (itemType.equals("small_charm")) {
            addSmallCharmViewOptions(optionsSuffix, optionsPrefix);
        } else if (itemType.equals("grand_charm")) {
            addGrandCharmViewOptions(optionsSuffix, optionsPrefix);
        } else if (itemType.equals("jewel")) {
            addJewelViewOptions(optionsSuffix, optionsPrefix);
        }
    }

    private void addSmallCharmViewOptions(List<String> itemOptionsSuffix, List<String> itemOptionsPrefix) {

        StringBuilder sb = new StringBuilder();

        // 리스트가 비어있지 않으면 해당 항목을 추가
        if (itemOptionsSuffix.size() != 0) {
            String str = itemOptionsSuffix.toString().trim();
            String str1 = str.replace("[", "\n");
            String str2 = str1.replace("]", "\n");
            String str3 = str2.replace(",", "\n");
            sb.append(str3);  // 첫 번째 리스트 항목 추가
        }

        if (itemOptionsPrefix.size() != 0) {
            String str = itemOptionsPrefix.toString().trim();
            String str1 = str.replace("[", "\n");
            String str2 = str1.replace("]", "\n");
            String str3 = str2.replace(",", "\n");
            sb.append(str3);  // 두 번째 리스트 항목 추가
        }

        // 중간에 줄바꿈 및 불필요한 공백을 제거
        String str = sb.toString().trim();

        boolean prefixPoison15_3 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_small_charm_46_prefix));
        boolean prefixPoison50_4 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_small_charm_47_prefix));
        boolean prefixPoison100_5 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_small_charm_48_prefix));
        boolean prefixPoison175_6 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_small_charm_49_prefix));

        boolean suffixPoison6_3 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_small_charm_26_suffix));
        boolean suffixPoison15_4 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_small_charm_27_suffix));
        boolean suffixPoison25_5 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_small_charm_28_suffix));
        boolean suffixPoison50_6 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_small_charm_29_suffix));

        boolean prefixMaxDamege1 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_small_charm_6_prefix));
        boolean suffixMaxDamege1 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_small_charm_1_suffix));

        if (prefixMaxDamege1 && suffixMaxDamege1) {
            str = "최대 피해 +2";
        }

        if (prefixPoison15_3 && suffixPoison6_3) {
            str = "독 피해 +49 (6초에 걸쳐)"; // Combination: 15/3 + 6/3
        } else if (prefixPoison15_3 && suffixPoison15_4) {
            str = "독 피해 +63 (7초에 걸쳐)"; // Combination: 15/3 + 15/4
        } else if (prefixPoison15_3 && suffixPoison25_5) {
            str = "독 피해 +83 (8초에 걸쳐)"; // Combination: 15/3 + 25/5
        } else if (prefixPoison15_3 && suffixPoison50_6) {
            str = "독 피해 +133 (9초에 걸쳐)"; // Combination: 15/3 + 50/6
        } else if (prefixPoison50_4 && suffixPoison6_3) {
            str = "독 피해 +68 (7초에 걸쳐)"; // Combination: 50/4 + 6/3
        } else if (prefixPoison50_4 && suffixPoison15_4) {
            str = "독 피해 +83 (8초에 걸쳐)"; // Combination: 50/4 + 15/4
        } else if (prefixPoison50_4 && suffixPoison25_5) {
            str = "독 피해 +113 (9초에 걸쳐)"; // Combination: 50/4 + 25/5
        } else if (prefixPoison50_4 && suffixPoison50_6) {
            str = "독 피해 +178 (10초에 걸쳐)"; // Combination: 50/4 + 50/6
        } else if (prefixPoison100_5 && suffixPoison6_3) {
            str = "독 피해 +197 (8초에 걸쳐)"; // Combination: 100/5 + 6/3
        } else if (prefixPoison100_5 && suffixPoison15_4) {
            str = "독 피해 +227 (9초에 걸쳐)"; // Combination: 100/5 + 15/4
        } else if (prefixPoison100_5 && suffixPoison25_5) {
            str = "독 피해 +277 (10초에 걸쳐)"; // Combination: 100/5 + 25/5
        } else if (prefixPoison100_5 && suffixPoison50_6) {
            str = "독 피해 +377 (11초에 걸쳐)"; // Combination: 100/5 + 50/6
        } else if (prefixPoison175_6 && suffixPoison6_3) {
            str = "독 피해 +265 (9초에 걸쳐)"; // Combination: 175/6 + 6/3
        } else if (prefixPoison175_6 && suffixPoison15_4) {
            str = "독 피해 +295 (10초에 걸쳐)"; // Combination: 175/6 + 15/4
        } else if (prefixPoison175_6 && suffixPoison25_5) {
            str = "독 피해 +345 (11초에 걸쳐)"; // Combination: 175/6 + 25/5
        } else if (prefixPoison175_6 && suffixPoison50_6) {
            str = "독 피해 +451 (12초에 걸쳐)"; // Combination: 175/6 + 50/6
        }


        // 공백 및 빈 줄 처리
        str = str.replaceAll("(?m)^[ \t]+", "")       // 각 줄의 앞 공백 제거
                .replaceAll("(?m)\\s+$", "")        // 각 줄의 끝 공백 제거
                .replaceAll("\n{2,}", "\n")         // 연속된 빈 줄을 하나로 변경
                .replaceAll("(?m)^\\s*$", "")       // 빈 줄 제거
                .trim();                            // 양 끝 공백 제거

        if (str == null || str.isEmpty() || str.equals("")) {
            textView.setText(context.getString(R.string.small_charm_title));
        } else {
            textView.setText(str);
        }
    }

    private void addLargeCharmViewOptions(List<String> itemOptionsSuffix, List<String> itemOptionsPrefix) {

        StringBuilder sb = new StringBuilder();

        if (itemOptionsSuffix.size() != 0) {
            String str = itemOptionsSuffix.toString().trim();
            String str1 = str.replace("[", "\n");
            String str2 = str1.replace("]", "\n");
            String str3 = str2.replace(",", "\n");
            sb.append(str3);  // 첫 번째 리스트 항목 추가
        }

        if (itemOptionsPrefix.size() != 0) {
            String str = itemOptionsPrefix.toString().trim();
            String str1 = str.replace("[", "\n");
            String str2 = str1.replace("]", "\n");
            String str3 = str2.replace(",", "\n");
            sb.append(str3);  // 두 번째 리스트 항목 추가
        }

        String str = sb.toString().trim();
        boolean prefixDamege1 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_large_charm_10_prefix));
        boolean suffixDamege1 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_large_charm_1_suffix));
        boolean prefixDamege2 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_large_charm_11_prefix));
        boolean suffixDamege2 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_large_charm_2_suffix));

        boolean prefixPoison10 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_large_charm_64_prefix));
        boolean prefixPoison30 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_large_charm_65_prefix));
        boolean prefixPoison90 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_large_charm_66_prefix));
        boolean prefixPoison175 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_large_charm_67_prefix));
        boolean suffixPoison6 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_large_charm_29_suffix));
        boolean suffixPoison15 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_large_charm_30_suffix));
        boolean suffixPoison25 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_large_charm_31_suffix));
        boolean suffixPoison50 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_large_charm_32_suffix));

        // 변경 맵 생성
        Map<String, String> replacements = new HashMap<>();

        if (prefixPoison10 && suffixPoison6) {
            str = "독 피해 +49 (6초에 걸쳐)";
        } else if (prefixPoison30 && suffixPoison15) {
            str = "독 피해 +68 (8초에 걸쳐)";
        } else if (prefixPoison90 && suffixPoison25) {
            str = "독 피해 +376 (10초에 걸쳐)";
        } else if (prefixPoison175 && suffixPoison50) {
            str = "독 피해 +451 (12초에 걸쳐)";
        } else if (prefixPoison10 && suffixPoison15) {
            str = "독 피해 +63 (7초에 걸쳐)";
        } else if (prefixPoison30 && suffixPoison25) {
            str = "독 피해 +68 (9초에 걸쳐)";
        } else if (prefixPoison90 && suffixPoison50) {
            str = "독 피해 +445 (11초에 걸쳐)";
        } else if (prefixPoison175 && suffixPoison6) {
            str = "독 피해 +265 (9초에 걸쳐)";
        } else if (prefixPoison175 && suffixPoison15) {
            str = "독 피해 +330 (10초에 걸쳐)";
        } else if (prefixPoison175 && suffixPoison25) {
            str = "독 피해 +378 (11초에 걸쳐)";
        } else if (prefixPoison10 && suffixPoison25) {
            str = "독 피해 +53 (8초에 걸쳐)";
        } else if (prefixPoison10 && suffixPoison50) {
            str = "독 피해 +87 (9초에 걸쳐)";
        } else if (prefixPoison30 && suffixPoison50) {
            str = "독 피해 +133 (10초에 걸쳐)";
        } else if (prefixPoison30 && suffixPoison6) {
            str = "독 피해 +68 (7초에 걸쳐)";
        } else if (prefixPoison90 && suffixPoison6) {
            str = "독 피해 +161 (8초에 걸쳐)";
        } else if (prefixPoison90 && suffixPoison15) {
            str = "독 피해 +197 (9초에 걸쳐)";
        }

        if (prefixDamege1 && suffixDamege1) {
            str = "최대 피해 +2";
        }

        if (prefixDamege2 && suffixDamege2) {
            str = "최대 피해 +4";
        }

        if (prefixDamege1 && suffixDamege2) {
            str = "최대 피해 +3";
        }

        if (prefixDamege2 && suffixDamege1) {
            str = "최대 피해 +3";
        }

        // 공백 및 빈 줄 처리
        str = str.replaceAll("(?m)^[ \t]+", "")       // 각 줄의 앞 공백 제거
                .replaceAll("(?m)\\s+$", "")        // 각 줄의 끝 공백 제거
                .replaceAll("\n{2,}", "\n")         // 연속된 빈 줄을 하나로 변경
                .replaceAll("(?m)^\\s*$", "")       // 빈 줄 제거
                .trim();                            // 양 끝 공백 제거

        if (str == null || str.isEmpty() || str.equals("")) {
            textView.setText(context.getString(R.string.large_charm_title));
        } else {
            textView.setText(str);
        }
    }

    private void addGrandCharmViewOptions(List<String> itemOptionsSuffix, List<String> itemOptionsPrefix) {
        StringBuilder sb = new StringBuilder();

        if (itemOptionsSuffix.size() != 0) {
            String str = itemOptionsSuffix.toString().trim();
            String str1 = str.replace("[", "\n");
            String str2 = str1.replace("]", "\n");
            String str3 = str2.replace(",", "\n");
            sb.append(str3);  // 첫 번째 리스트 항목 추가
        }

        if (itemOptionsPrefix.size() != 0) {
            String str = itemOptionsPrefix.toString().trim();
            String str1 = str.replace("[", "\n");
            String str2 = str1.replace("]", "\n");
            String str3 = str2.replace(",", "\n");
            sb.append(str3);  // 두 번째 리스트 항목 추가
        }

        String str = sb.toString().trim();
        boolean prefixPoison5_2 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_grand_charm_74_prefix));
        boolean prefixPoison15_2 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_grand_charm_75_prefix));
        boolean prefixPoison50_2 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_grand_charm_76_prefix));
        boolean prefixPoison100_2 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_grand_charm_77_prefix));
        boolean suffixPoison6_2 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_grand_charm_34_suffix));
        boolean suffixPoison15_2 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_grand_charm_35_suffix));
        boolean suffixPoison25_2 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_grand_charm_36_suffix));
        boolean suffixPoison50_2 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_grand_charm_37_suffix));

        boolean prefixMaxDamege1 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_grand_charm_13_prefix));
        boolean prefixMaxDamege2 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_grand_charm_14_prefix));
        boolean prefixMaxDamege3 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_grand_charm_15_prefix));

        boolean suffixMaxDamege1 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_grand_charm_1_suffix));
        boolean suffixMaxDamege2 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_grand_charm_2_suffix));
        boolean suffixMaxDamege3 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_grand_charm_3_suffix));

        if (prefixMaxDamege1 && suffixMaxDamege1) {
            str = "최대 피해 +2";
        } else if (prefixMaxDamege2 && suffixMaxDamege2) {
            str = "최대 피해 +3";
        } else if (prefixMaxDamege3 && suffixMaxDamege1) {
            str = "최대 피해 +4";
        } else if (prefixMaxDamege3 && suffixMaxDamege2) {
            str = "최대 피해 +5";
        }

        if (prefixPoison5_2 && suffixPoison6_2) {
            str = "독 피해 +17 (4초에 걸쳐)"; // Combination: 5/2 + 6/2
        } else if (prefixPoison5_2 && suffixPoison15_2) {
            str = "독 피해 +33 (5초에 걸쳐)"; // Combination: 5/2 + 15/2
        } else if (prefixPoison5_2 && suffixPoison25_2) {
            str = "독 피해 +58 (6초에 걸쳐)"; // Combination: 5/2 + 25/2
        } else if (prefixPoison5_2 && suffixPoison50_2) {
            str = "독 피해 +108 (7초에 걸쳐)"; // Combination: 5/2 + 50/2
        } else if (prefixPoison15_2 && suffixPoison6_2) {
            str = "독 피해 +51 (4초에 걸쳐)"; // Combination: 15/2 + 6/2
        } else if (prefixPoison15_2 && suffixPoison15_2) {
            str = "독 피해 +67 (5초에 걸쳐)"; // Combination: 15/2 + 15/2
        } else if (prefixPoison15_2 && suffixPoison25_2) {
            str = "독 피해 +92 (6초에 걸쳐)"; // Combination: 15/2 + 25/2
        } else if (prefixPoison15_2 && suffixPoison50_2) {
            str = "독 피해 +142 (7초에 걸쳐)"; // Combination: 15/2 + 50/2
        } else if (prefixPoison50_2 && suffixPoison6_2) {
            str = "독 피해 +134 (4초에 걸쳐)"; // Combination: 50/2 + 6/2
        } else if (prefixPoison50_2 && suffixPoison15_2) {
            str = "독 피해 +150 (5초에 걸쳐)"; // Combination: 50/2 + 15/2
        } else if (prefixPoison50_2 && suffixPoison25_2) {
            str = "독 피해 +175 (6초에 걸쳐)"; // Combination: 50/2 + 25/2
        } else if (prefixPoison50_2 && suffixPoison50_2) {
            str = "독 피해 +225 (7초에 걸쳐)"; // Combination: 50/2 + 50/2
        } else if (prefixPoison100_2 && suffixPoison6_2) {
            str = "독 피해 +267 (4초에 걸쳐)"; // Combination: 100/2 + 6/2
        } else if (prefixPoison100_2 && suffixPoison15_2) {
            str = "독 피해 +283 (5초에 걸쳐)"; // Combination: 100/2 + 15/2
        } else if (prefixPoison100_2 && suffixPoison25_2) {
            str = "독 피해 +308 (6초에 걸쳐)"; // Combination: 100/2 + 25/2
        } else if (prefixPoison100_2 && suffixPoison50_2) {
            str = "독 피해 +358 (7초에 걸쳐)"; // Combination: 100/2 + 50/2
        }

        // 공백 및 빈 줄 처리
        str = str.replaceAll("(?m)^[ \t]+", "")       // 각 줄의 앞 공백 제거
                .replaceAll("(?m)\\s+$", "")        // 각 줄의 끝 공백 제거
                .replaceAll("\n{2,}", "\n")         // 연속된 빈 줄을 하나로 변경
                .replaceAll("(?m)^\\s*$", "")       // 빈 줄 제거
                .trim();                            // 양 끝 공백 제거

        if (str == null || str.isEmpty() || str.equals("")) {
            textView.setText(context.getString(R.string.grand_charm_title));
        } else {
            textView.setText(str);
        }
    }

    private void addJewelViewOptions(List<String> itemOptionsSuffix, List<String> itemOptionsPrefix) {
        StringBuilder sb = new StringBuilder();

        if (itemOptionsSuffix.size() != 0) {
            String str = itemOptionsSuffix.toString().trim();
            String str1 = str.replace("[", "\n");
            String str2 = str1.replace("]", "\n");
            String str3 = str2.replace(",", "\n");
            sb.append(str3);  // 첫 번째 리스트 항목 추가
        }

        if (itemOptionsPrefix.size() != 0) {
            String str = itemOptionsPrefix.toString().trim();
            String str1 = str.replace("[", "\n");
            String str2 = str1.replace("]", "\n");
            String str3 = str2.replace(",", "\n");
            sb.append(str3);  // 두 번째 리스트 항목 추가
        }

        String str = sb.toString().trim();

        boolean prefixMaxDamege1_5 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_magic_jewel_7_prefix));
        boolean prefixMaxDamege6_9 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_magic_jewel_8_prefix));
        boolean prefixMaxDamege11_15 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_magic_jewel_9_prefix));
        boolean suffixMaxDamege2_5 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_magic_jewel_7_suffix));
        boolean suffixMaxDamege6_9 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_magic_jewel_8_suffix));
        boolean suffixMaxDamege11_15 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_magic_jewel_9_suffix));
        
        boolean prefixMinDamege1_4 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_magic_jewel_5_prefix));
        boolean prefixMinDamege5_8 = itemOptionsPrefix.toString().trim().contains(context.getString(R.string.item_options_magic_jewel_6_prefix));
        boolean suffixMinDamege1_4 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_magic_jewel_10_suffix));
        boolean suffixMinDamege5_10 = itemOptionsSuffix.toString().trim().contains(context.getString(R.string.item_options_magic_jewel_11_suffix));

        if (prefixMaxDamege1_5 && suffixMaxDamege2_5) {
            str = "최대 피해 +3-10";
        } else if (prefixMaxDamege1_5 && suffixMaxDamege6_9){
            str = "최대 피해 +7-14";
        } else if (prefixMaxDamege1_5 && suffixMaxDamege11_15) {
            str = "최대 피해 +12-20";
        } else if (prefixMaxDamege6_9 && suffixMaxDamege2_5) {
            str = "최대 피해 +8-14";
        } else if (prefixMaxDamege6_9 && suffixMaxDamege6_9) {
            str = "최대 피해 +12-18";
        } else if (prefixMaxDamege6_9 && suffixMaxDamege11_15) {
            str = "최대 피해 +17-24";
        } else if (prefixMaxDamege11_15 && suffixMaxDamege2_5) {
            str = "최대 피해 +13-20";
        } else if (prefixMaxDamege11_15 && suffixMaxDamege6_9) {
            str = "최대 피해 +17-24";
        } else if (prefixMaxDamege11_15 && suffixMaxDamege11_15) {
            str = "최대 피해 +22-30";
        } else if (prefixMinDamege1_4 && suffixMinDamege1_4) {
            str = "최소 피해 +2-8";
        } else if (prefixMinDamege1_4 && suffixMinDamege5_10) {
            str = "최소 피해 +6-14";
        } else if (prefixMinDamege5_8 && suffixMinDamege1_4) {
            str = "최소 피해 +6-12";
        } else if (prefixMinDamege5_8 && suffixMinDamege5_10) {
            str = "최소 피해 +10-18";
        }

        str = str.replaceAll("(?m)^[ \t]+", "")       // 각 줄의 앞 공백 제거
                .replaceAll("(?m)\\s+$", "")        // 각 줄의 끝 공백 제거
                .replaceAll("\n{2,}", "\n")         // 연속된 빈 줄을 하나로 변경
                .replaceAll("(?m)^\\s*$", "")       // 빈 줄 제거
                .trim();                            // 양 끝 공백 제거

        if (str == null || str.isEmpty() || str.equals("")) {
            textView.setText(context.getString(R.string.grand_charm_title));
        } else {
            textView.setText(str);
        }
    }
}
