package com.cjmkeke.d2rbooks.itemdatabase.rare_item_information;

import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 테스트 {

    private TextView textView;

    private void addRingViewOptions(List<String> amuletOptionsSuffix, List<String> amuletOptionsPrefix) {
        System.out.println("링 뷰");
        StringBuilder sb = new StringBuilder();

        final String res3_20 = " +3-11";
        final String res_8_60 = " +8-41";
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
        boolean hasAllResistance = str.contains("모든 저항력 +3-11");
        boolean hasFire = str.contains("화염 저항력 +5-40");
        boolean hasCold = str.contains("냉기 저항력 +5-30");
        boolean hasLightning = str.contains("번개 저항력 +5-30");
        boolean hasPoison = str.contains("독 저항력 +5-30");

        // 변경 맵 생성
        Map<String, String> replacements = new HashMap<>();

        // 구체적인 조건 (3개 조합) 먼저 처리
        if (hasAllResistance && hasFire && hasCold) {
            replacements.put("화염 저항력 +5-40", "");
            replacements.put("냉기 저항력 +5-30", "");
            replacements.put("모든 저항력 +3-11",
                    "화염 저항력" + res_8_60 + "\n" +
                            "냉기 저항력" + res_8_60 + "\n" +
                            "번개 저항력" + res3_20 + "\n" +
                            "독 저항력" + res3_20);
        }

        else if (hasAllResistance && hasFire && hasLightning) {
            replacements.put("화염 저항력 +5-40", "");
            replacements.put("번개 저항력 +5-30", "");
            replacements.put("모든 저항력 +3-11",
                    "화염 저항력" + res_8_60 + "\n" +
                            "냉기 저항력" + res3_20 + "\n" +
                            "번개 저항력" + res_8_60 + "\n" +
                            "독 저항력" + res3_20);
        }

        else if (hasAllResistance && hasCold && hasPoison) {
            replacements.put("독 저항력 +5-30", "");
            replacements.put("냉기 저항력 +5-30", "");
            replacements.put("모든 저항력 +3-11",
                    "화염 저항력" + res3_20 + "\n" +
                            "냉기 저항력" + res_8_60 + "\n" +
                            "번개 저항력" + res3_20 + "\n" +
                            "독 저항력" + res_8_60);
        }


        else if (hasAllResistance && hasCold && hasLightning) {
            replacements.put("번개 저항력 +5-30", "");
            replacements.put("냉기 저항력 +5-30", "");
            replacements.put("모든 저항력 +3-11",
                    "화염 저항력" + res3_20 + "\n" +
                            "냉기 저항력" + res_8_60 + "\n" +
                            "번개 저항력" + res_8_60 + "\n" +
                            "독 저항력" + res3_20);
        }

        else if (hasAllResistance && hasPoison && hasLightning) {
            replacements.put("독 저항력 +5-30", "");
            replacements.put("번개 저항력 +5-30", "");
            replacements.put("모든 저항력 +3-11",
                    "화염 저항력" + res3_20 + "\n" +
                            "냉기 저항력" + res3_20 + "\n" +
                            "번개 저항력" + res_8_60 + "\n" +
                            "독 저항력" + res_8_60);
        }


        else if (hasAllResistance && hasPoison && hasFire) {
            replacements.put("독 저항력 +5-30", "");
            replacements.put("화염 저항력 +5-40", "");
            replacements.put("모든 저항력 +3-11",
                    "화염 저항력" + res_8_60 + "\n" +
                            "냉기 저항력" + res3_20 + "\n" +
                            "번개 저항력" + res3_20 + "\n" +
                            "독 저항력" + res_8_60);
        }

        // 덜 구체적인 조건 (2개 조합) 처리
        else if (hasAllResistance && hasFire) {
            replacements.put("화염 저항력 +5-40", "");
            replacements.put("모든 저항력 +3-11",
                    "화염 저항력" + res_8_60 + "\n" +
                            "냉기 저항력" + res3_20 + "\n" +
                            "번개 저항력" + res3_20 + "\n" +
                            "독 저항력" + res3_20);
        }

        else if (hasAllResistance && hasCold) {
            replacements.put("냉기 저항력 +5-30", "");
            replacements.put("모든 저항력 +3-11",
                    "화염 저항력" + res3_20 + "\n" +
                            "냉기 저항력" + res_8_60 + "\n" +
                            "번개 저항력" + res3_20 + "\n" +
                            "독 저항력" + res3_20);
        }


        else if (hasAllResistance && hasPoison) {
            replacements.put("독 저항력 +5-30", "");
            replacements.put("모든 저항력 +3-11",
                    "화염 저항력" + res3_20 + "\n" +
                            "냉기 저항력" + res3_20 + "\n" +
                            "번개 저항력" + res3_20 + "\n" +
                            "독 저항력" + res_8_60);
        }


        else if (hasAllResistance && hasLightning) {
            replacements.put("번개 저항력 +5-30", "");
            replacements.put("모든 저항력 +3-11",
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
        if (str.contains("매직 아이템 얻을 확률 증가 +5-15") && str.contains("매직 아이템 얻을 확률 증가 +5-10")) {
            // "매직 아이템 얻을 확률 증가 +5-25" 텍스트 삭제
            // 접미사
            str = str.replace("매직 아이템 얻을 확률 증가 +5-15", "");

            // "매직 아이템 얻을 확률 증가 +5-10" 텍스트 수정
            // 접두사
            str = str.replace("매직 아이템 얻을 확률 증가 +5-10", "매직 아이템 얻을 확률 증가 +10-25");
        }

        // 공백 및 빈 줄 처리
        str = str.replaceAll("(?m)^[ \t]+", "")       // 각 줄의 앞 공백 제거
                .replaceAll("(?m)\\s+$", "")        // 각 줄의 끝 공백 제거
                .replaceAll("\n{2,}", "\n")         // 연속된 빈 줄을 하나로 변경
                .replaceAll("(?m)^\\s*$", "")       // 빈 줄 제거
                .trim();                            // 양 끝 공백 제거

        textView.setText(str);

    }

}
