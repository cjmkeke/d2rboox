package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense;

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

public class Defense5 {

    private static int defense_skill_1;
    static final String JSON_FILE_NAME = "defense5.json";
    public static void skillUpdate(int value, TextView textView, Context context, SharedPreferences sharedPreferences) {
        String[] passiveSkill1 = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "19", "21", "23", "25"};
        int finalI = 0;
        sharedPreferences = context.getSharedPreferences("paladins_point", Context.MODE_PRIVATE);
        defense_skill_1 = sharedPreferences.getInt("defense_skill_1", 0);

        for (int i = 0; i < 21; i++) {
            if (defense_skill_1 == i) {
                finalI = i- 1;
                break;
            }
        }

        Type listType = TypeToken.getParameterized(List.class, JsonModels.class).getType();
        List<JsonModels> skill = JsonUtil.loadJSONFromAsset(context, JSON_FILE_NAME, listType);
        Spanned spanned;

        if (skill != null) {
            if (value == 20) {
                spanned = Html.fromHtml(SkillDefense.defenseSkill5_end, Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
            } else if (value >= 1 && value < 21) {
                // Loop through values 0 to 19
                for (int i = 0; i < 21; i++) {
                    if (value == i) {
                        System.out.println(finalI);
                        System.out.println(passiveSkill1[finalI]);

                        spanned = Html.fromHtml(DefenseUpdate.defenseSkill5(
                                        String.valueOf(i),
                                        passiveSkill1[finalI],
                                        skill.get(i - 1).getOption2(),
                                        skill.get(i - 1).getOption1(),
                                        skill.get(i).getOption2(),
                                        skill.get(i).getOption1()),
                                Html.FROM_HTML_MODE_LEGACY);
                        textView.setText(spanned);
                        break;  // Exit loop after handling the correct value.
                    }
                }
            }
        }

    }

}
