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

public class NecromancerSummoning3 {

    static final String JSON_FILE_NAME = "summoning3.json";
    public static void skillUpdate(int value, TextView textView, Context context, SharedPreferences sharedPreferences) {
        Type listType = TypeToken.getParameterized(List.class, JsonModels.class).getType();
        List<JsonModels> skill = JsonUtil.loadJSONFromAsset(context, JSON_FILE_NAME, listType);
        Spanned spanned;

        if (skill != null) {
            if (value == 20) {
                spanned = Html.fromHtml(NecromancerSkillSummoning.summoningSkill3_end, Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
            } else if (value >= 1 && value < 21) {
                // Loop through values 0 to 19
                for (int i = 0; i < 21; i++) {
                    if (value == i) {
                        spanned = Html.fromHtml(NecromancerSummoningUpdate.summoningSkill3(
                                        String.valueOf(i),
                                        skill.get(i - 1).getOption1(), // 공격력
                                        skill.get(i - 1).getOption2(), // 지속시간
                                        skill.get(i - 1).getOption3(), // 지속시간
                                        skill.get(i - 1).getOption4(), // 지속시간
                                        skill.get(i - 1).getOption5(), // 반경
                                        skill.get(i - 1).getOption6(), // 반경
                                        skill.get(i).getOption2(),
                                        skill.get(i).getOption3(),
                                        skill.get(i).getOption4(),
                                        skill.get(i).getOption5(),
                                        skill.get(i).getOption6()),
                                Html.FROM_HTML_MODE_LEGACY);
                        textView.setText(spanned);
                        break;  // Exit loop after handling the correct value.
                    }
                }
            }
        }

    }


}
