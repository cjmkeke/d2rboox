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

public class NecromancerSummoning1 {

    static final String JSON_FILE_NAME = "summoning1.json";
    public static void skillUpdate(int value, TextView textView, Context context, SharedPreferences sharedPreferences){
        Type listType = TypeToken.getParameterized(List.class, JsonModels.class).getType();
        List<JsonModels> skill = JsonUtil.loadJSONFromAsset(context, JSON_FILE_NAME, listType);
        Spanned spanned;

        if (skill != null){
            if (value == 20){
                spanned = Html.fromHtml(NecromancerSkillSummoning.summoningSkill1_end, Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
            }

            if (value == 1) {
                spanned = Html.fromHtml(NecromancerSummoningUpdate.summoningSkill_1lv1(
                                String.valueOf("1"),
                                skill.get(1).getOption1(), // 피해
                                skill.get(1).getOption2(), //  명중
                                skill.get(1).getOption1(), //  명중
                                skill.get(1).getOption3(), //  명중
                                skill.get( 1).getOption4(), //  명중
                                skill.get(1).getOption1(),
                                skill.get(1).getOption2(),
                                skill.get(1).getOption1(),
                                skill.get(1).getOption3(),
                                skill.get(1).getOption4()), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
            }

            if (value >= 1 && value < 20) {
                for (int i = 2; i < 20; i++) {
                    if (value == i) {
                        spanned = Html.fromHtml(NecromancerSummoningUpdate.summoningSkill_1lv2(
                                        String.valueOf(i),
                                        skill.get(i - 1).getOption1(), // 피해
                                        skill.get(i - 1).getOption2(), //  명중
                                        skill.get(i - 1).getOption1(), //  명중
                                        skill.get(i - 1).getOption3(), //  명중
                                        skill.get(i - 1).getOption4(), //  명중
                                        skill.get(i).getOption1(),
                                        skill.get(i).getOption2(),
                                        skill.get(i).getOption1(),
                                        skill.get(i).getOption3(),
                                        skill.get(i).getOption4()), Html.FROM_HTML_MODE_LEGACY);
                        textView.setText(spanned);
                        break;  // Exit loop after handling the correct value.
                    }
                }
            }
        }

    }


}
