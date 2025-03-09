package com.cjmkeke.d2rbooks.itemdatabase.rare_item_information;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import android.widget.Toast;

import com.cjmkeke.d2rbooks.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RareJewelHideAndShow {

    private static final String TAG = "HideAndShow";
    private Context context;
    private List<String> optionsSuffix = new ArrayList<>();
    private List<String> optionsPrefix = new ArrayList<>();
    private TextView textView;
    private String[] addOptionsSuffix;
    private String[] addOptionsPrefix;
    private String itemType = "";
    private Map<Integer, Drawable> initialBackgroundMap = new HashMap<>();

    public RareJewelHideAndShow(Context context, List<String> optionsSuffix, List<String> optionsPrefix, String[] addOptionsPrefix, String[] addOptionsSuffix, TextView textView) {
        this.optionsSuffix.clear();
        this.optionsPrefix.clear();
        this.context = context;
        this.optionsSuffix = optionsSuffix;
        this.optionsPrefix = optionsPrefix;
        this.textView = textView;
        this.addOptionsPrefix = addOptionsPrefix;
        this.addOptionsSuffix = addOptionsSuffix;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }


    // 초기 상태 저장 메서드
    private void saveInitialBackground(TextView textView) {
        int viewId = textView.getId(); // TextView의 ID 가져오기

        // 해당 ID의 초기 배경이 저장되어 있지 않으면 저장
        if (!initialBackgroundMap.containsKey(viewId)) {
            Drawable initialBackground = textView.getBackground(); // 현재 배경 저장
            initialBackgroundMap.put(viewId, initialBackground);  // Map에 저장
        }
    }

    // addSuffix 메서드
    public void addSuffix(List<String> optionsSuffix, List<String> optionsPrefix, String[] addOptionsSuffix, int num, TextView textView) {
        // 초기 배경 저장
        saveInitialBackground(textView);

        if (optionsSuffix.size() == 3){
            if (optionsPrefix.size() == 1){
                Toast.makeText(context, "옵션이 초과되었습니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(context, "옵션이 초과되었습니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (optionsPrefix.size() == 3 && optionsSuffix.size() == 1){
            Toast.makeText(context, "옵션이 초과되었습니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (optionsPrefix.size() == 1 && optionsSuffix.size() == 3){
            Toast.makeText(context, "옵션이 초과되었습니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        // 조건 검사
        if (optionsPrefix.size() == 2 && optionsSuffix.size() == 2){
            Toast.makeText(context, "옵션이 초과되었습니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        // 새로운 배경 설정
        int res = context.getResources().getIdentifier("dw_uber_6", "drawable", context.getPackageName());
        textView.setBackgroundResource(res); // 새로운 배경 적용

        // 옵션 추가
        optionsSuffix.add(addOptionsSuffix[num]);

        if (itemType.equals("jewel")) {
            addJewelViewOptions(optionsSuffix, optionsPrefix);
        }
    }

    // addPreFix 메서드
    public void addPreFix(List<String> optionsSuffix, List<String> optionsPrefix, String[] addOptionsSuffix, int num, TextView textView) {
        // 초기 배경 저장
        saveInitialBackground(textView);

        if (optionsPrefix.size() == 3){
            if (optionsSuffix.size() == 1){
                Toast.makeText(context, "옵션이 초과되었습니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(context, "옵션이 초과되었습니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (optionsPrefix.size() == 3 && optionsSuffix.size() == 1){
            Toast.makeText(context, "옵션이 초과되었습니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (optionsPrefix.size() == 1 && optionsSuffix.size() == 3){
            Toast.makeText(context, "옵션이 초과되었습니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        // 조건 검사
        if (optionsPrefix.size() == 2 && optionsSuffix.size() == 2){
            Toast.makeText(context, "옵션이 초과되었습니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        // 새로운 배경 설정
        int res = context.getResources().getIdentifier("dw_uber_6", "drawable", context.getPackageName());
        textView.setBackgroundResource(res); // 새로운 배경 적용

        // 접두사 추가
        optionsPrefix.add(addOptionsPrefix[num]);

        if (itemType.equals("jewel")) {
            addJewelViewOptions(optionsSuffix, optionsPrefix);
        }
    }

    // removeSuffix 메서드
    public void removeSuffix(List<String> optionsSuffix, List<String> optionsPrefix, String[] addOptionsSuffix, int num, TextView textView) {
        // 초기 배경 저장
        saveInitialBackground(textView);

        // 초기 배경 복구
        int viewId = textView.getId(); // TextView ID 가져오기
        if (initialBackgroundMap.containsKey(viewId)) {
            textView.setBackground(initialBackgroundMap.get(viewId)); // 초기 배경으로 복구
        }

        // 옵션 제거
        optionsSuffix.remove(addOptionsSuffix[num]);

        // 아이템 유형별 옵션 처리
        if (itemType.equals("jewel")) {
            addJewelViewOptions(optionsSuffix, optionsPrefix);
        }
    }

    // removePreFix 메서드
    public void removePreFix(List<String> optionsSuffix, List<String> optionsPrefix, String[] addOptionsSuffix, int num, TextView textView) {
        // 초기 배경 저장
        saveInitialBackground(textView);

        // 옵션 제거
        optionsPrefix.remove(addOptionsPrefix[num]);

        // 초기 배경 복구
        int viewId = textView.getId(); // TextView ID 가져오기
        if (initialBackgroundMap.containsKey(viewId)) {
            textView.setBackground(initialBackgroundMap.get(viewId)); // 초기 배경으로 복구
        }

        if (itemType.equals("jewel")) {
            addJewelViewOptions(optionsSuffix, optionsPrefix);
        }

    }

    private void addJewelViewOptions(List<String> amuletOptionsSuffix, List<String> amuletOptionsPrefix) {
        StringBuilder sb = new StringBuilder();

        final String res3_20 = " +3-20";
        final String res_8_60 = " +8-60";
        // 리스트가 비어있지 않으면 해당 항목을 추가
        if (amuletOptionsSuffix.size() != 0) {
            String str = amuletOptionsSuffix.toString().trim();
            String str1 = str.replace("[", "\n");
            String str2 = str1.replace("]", "\n");
            String str3 = str2.replace(",", "\n");
            sb.append(str3);  // 첫 번째 리스트 항목 추가
        }

        if (amuletOptionsPrefix.size() != 0) {
            String str = amuletOptionsPrefix.toString().trim();
            String str1 = str.replace("[", "\n");
            String str2 = str1.replace("]", "\n");
            String str3 = str2.replace(",", "\n");
            sb.append(str3);  // 두 번째 리스트 항목 추가
        }

        // 중간에 줄바꿈 및 불필요한 공백을 제거
        String str = sb.toString().trim();

        // 조건 상태 저장
        boolean hasAllResistance = str.contains("모든 저항력 +3-20");
        boolean hasFire = str.contains("화염 저항력 +5-40");
        boolean hasCold = str.contains("냉기 저항력 +5-40");
        boolean hasLightning = str.contains("번개 저항력 +5-40");
        boolean hasPoison = str.contains("독 저항력 +5-40");

        // 변경 맵 생성
        Map<String, String> replacements = new HashMap<>();

        // 구체적인 조건 (3개 조합) 먼저 처리
        if (hasAllResistance && hasFire && hasCold) {
            replacements.put("화염 저항력 +5-40", "");
            replacements.put("냉기 저항력 +5-40", "");
            replacements.put("모든 저항력 +3-20",
                    "화염 저항력" + res_8_60 + "\n" +
                            "냉기 저항력" + res_8_60 + "\n" +
                            "번개 저항력" + res3_20 + "\n" +
                            "독 저항력" + res3_20);
        } else if (hasAllResistance && hasFire && hasLightning) {
            replacements.put("화염 저항력 +5-40", "");
            replacements.put("번개 저항력 +5-40", "");
            replacements.put("모든 저항력 +3-20",
                    "화염 저항력" + res_8_60 + "\n" +
                            "냉기 저항력" + res3_20 + "\n" +
                            "번개 저항력" + res_8_60 + "\n" +
                            "독 저항력" + res3_20);
        } else if (hasAllResistance && hasCold && hasPoison) {
            replacements.put("독 저항력 +5-40", "");
            replacements.put("냉기 저항력 +5-40", "");
            replacements.put("모든 저항력 +3-20",
                    "화염 저항력" + res3_20 + "\n" +
                            "냉기 저항력" + res_8_60 + "\n" +
                            "번개 저항력" + res3_20 + "\n" +
                            "독 저항력" + res_8_60);
        } else if (hasAllResistance && hasCold && hasLightning) {
            replacements.put("번개 저항력 +5-40", "");
            replacements.put("냉기 저항력 +5-40", "");
            replacements.put("모든 저항력 +3-20",
                    "화염 저항력" + res3_20 + "\n" +
                            "냉기 저항력" + res_8_60 + "\n" +
                            "번개 저항력" + res_8_60 + "\n" +
                            "독 저항력" + res3_20);
        } else if (hasAllResistance && hasPoison && hasLightning) {
            replacements.put("독 저항력 +5-40", "");
            replacements.put("번개 저항력 +5-40", "");
            replacements.put("모든 저항력 +3-20",
                    "화염 저항력" + res3_20 + "\n" +
                            "냉기 저항력" + res3_20 + "\n" +
                            "번개 저항력" + res_8_60 + "\n" +
                            "독 저항력" + res_8_60);
        } else if (hasAllResistance && hasPoison && hasFire) {
            replacements.put("독 저항력 +5-40", "");
            replacements.put("화염 저항력 +5-40", "");
            replacements.put("모든 저항력 +3-20",
                    "화염 저항력" + res_8_60 + "\n" +
                            "냉기 저항력" + res3_20 + "\n" +
                            "번개 저항력" + res3_20 + "\n" +
                            "독 저항력" + res_8_60);
        }

        // 덜 구체적인 조건 (2개 조합) 처리
        else if (hasAllResistance && hasFire) {
            replacements.put("화염 저항력 +5-40", "");
            replacements.put("모든 저항력 +3-20",
                    "화염 저항력" + res_8_60 + "\n" +
                            "냉기 저항력" + res3_20 + "\n" +
                            "번개 저항력" + res3_20 + "\n" +
                            "독 저항력" + res3_20);
        } else if (hasAllResistance && hasCold) {
            replacements.put("냉기 저항력 +5-40", "");
            replacements.put("모든 저항력 +3-20",
                    "화염 저항력" + res3_20 + "\n" +
                            "냉기 저항력" + res_8_60 + "\n" +
                            "번개 저항력" + res3_20 + "\n" +
                            "독 저항력" + res3_20);
        } else if (hasAllResistance && hasPoison) {
            replacements.put("독 저항력 +5-40", "");
            replacements.put("모든 저항력 +3-20",
                    "화염 저항력" + res3_20 + "\n" +
                            "냉기 저항력" + res3_20 + "\n" +
                            "번개 저항력" + res3_20 + "\n" +
                            "독 저항력" + res_8_60);
        } else if (hasAllResistance && hasLightning) {
            replacements.put("번개 저항력 +5-40", "");
            replacements.put("모든 저항력 +3-20",
                    "화염 저항력" + res3_20 + "\n" +
                            "냉기 저항력" + res3_20 + "\n" +
                            "번개 저항력" + res_8_60 + "\n" +
                            "독 저항력" + res3_20);
        }

        // 문자열 변경 적용
        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            str = str.replace(entry.getKey(), entry.getValue());
        }

        // 조건에 따라 텍스트 수정
        if (str.contains("매직 아이템 얻을 확률 증가 +5-25") && str.contains("매직 아이템 얻을 확률 증가 +5-10")) {
            // "매직 아이템 얻을 확률 증가 +5-25" 텍스트 삭제
            str = str.replace("매직 아이템 얻을 확률 증가 +5-25", "");

            // "매직 아이템 얻을 확률 증가 +5-10" 텍스트 수정
            str = str.replace("매직 아이템 얻을 확률 증가 +5-10", "매직 아이템 얻을 확률 증가 +10-35");
        }

        // 공백 및 빈 줄 처리
        str = str.replaceAll("(?m)^[ \t]+", "")       // 각 줄의 앞 공백 제거
                .replaceAll("(?m)\\s+$", "")        // 각 줄의 끝 공백 제거
                .replaceAll("\n{2,}", "\n")         // 연속된 빈 줄을 하나로 변경
                .replaceAll("(?m)^\\s*$", "")       // 빈 줄 제거
                .trim();                            // 양 끝 공백 제거

        if (str == null || str.isEmpty() || str.equals("")) {
            textView.setText(context.getString(R.string.jewel_title));
        } else {
            textView.setText(str);
        }

    }



}
