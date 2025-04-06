package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.necromancer.summoning;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.cjmkeke.d2rbooks.chardatabase.tools.JsonModels;
import com.cjmkeke.d2rbooks.chardatabase.tools.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class NecromancerSummoning2 {

    static final String JSON_FILE_NAME = "summoning2.json";
    public static void skillUpdate(int value, TextView textView, Context context, SharedPreferences sharedPreferences) {
        Type listType = TypeToken.getParameterized(List.class, JsonModels.class).getType();
        List<JsonModels> skill = JsonUtil.loadJSONFromAsset(context, JSON_FILE_NAME, listType);
        Spanned spanned;

        if (skill != null) {

            if (value == 20) {
                spanned = Html.fromHtml(NecromancerSkillSummoning.summoningSkill2_end, Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);

            } else if (value >= 1 && value <= 2) {
                spanned = Html.fromHtml(NecromancerSummoningUpdate.summoningSkill2( // 공격력이 둘 다 없는 1~2레벨
                                String.valueOf(value),
                                skill.get(value - 1).getOption1(),
                                skill.get(value - 1).getOption2(),
                                skill.get(value - 1).getOption3(),
                                skill.get(value - 1).getOption4(),
                                skill.get(value - 1).getOption5(),
                                skill.get(value - 1).getOption6(),
                                skill.get(value).getOption2(),
                                skill.get(value).getOption3(),
                                skill.get(value).getOption4(),
                                skill.get(value).getOption5(),
                                skill.get(value).getOption6()),
                        Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);

            } else if (value == 3) {
                spanned = Html.fromHtml(NecromancerSummoningUpdate.summoningSkill2( // 밑에만 공격력 있는 3레벨
                                "3", // 레벨
                                skill.get(value - 1).getOption1(), // 상위 공격력
                                skill.get(value - 1).getOption2(), // 생명력
                                skill.get(value - 1).getOption3(), // 명중률
                                skill.get(value - 1).getOption4(), // 방어력
                                skill.get(value - 1).getOption5(), // 해골
                                skill.get(value - 1).getOption6(), // 마나
                                skill.get(value).getOption2(),
                                skill.get(value).getOption3(),
                                skill.get(value).getOption7(),
                                skill.get(value).getOption4(),
                                skill.get(value).getOption5(),
                                skill.get(value).getOption6()),
                        Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);

            } else if (value >= 4 && value < 20) {
                for (int i = 4; i < 20; i++) {
                    if (value == i) {
                        spanned = Html.fromHtml(NecromancerSummoningUpdate.summoningSkill2( // 공격력이 둘 다 있는 상태 4부터
                                        String.valueOf(i), // 레벨
                                        skill.get(i - 1).getOption1(), // 상위 공격력
                                        skill.get(i - 1).getOption2(), // 생명력
                                        skill.get(i - 1).getOption3(), // 명중률
                                        skill.get(i - 1).getOption7(), // 공격력
                                        skill.get(i - 1).getOption4(), // 방어력
                                        skill.get(i - 1).getOption5(), // 해골
                                        skill.get(i - 1).getOption6(), //
                                        skill.get(i).getOption2(),
                                        skill.get(i).getOption3(),
                                        skill.get(i).getOption7(),
                                        skill.get(i).getOption4(),
                                        skill.get(i).getOption5(),
                                        skill.get(i).getOption6()),
                                Html.FROM_HTML_MODE_LEGACY);
                        textView.setText(spanned);
                        break;
                    }
                }
            }
        }
    }


}
