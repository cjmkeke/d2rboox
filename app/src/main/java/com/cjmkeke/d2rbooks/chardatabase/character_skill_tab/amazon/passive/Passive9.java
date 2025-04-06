package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.amazon.passive;

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

public class Passive9 {

    public static void skillUpdate(int value, TextView textView, Context context, SharedPreferences sharedPreferences){
        Type listType = TypeToken.getParameterized(List.class, JsonModels.class).getType();
        List<JsonModels> skill = JsonUtil.loadJSONFromAsset(context, "passive9.json", listType);
        Spanned spanned;

        if (skill != null){
            if (value == 20) {
                spanned = Html.fromHtml(SkillPassive.passiveSkill9_end, Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
            } else if (value >= 1 && value < 21) {
                // Loop through values 0 to 19
                for (int i = 0; i < 21; i++) {
                    if (value == i) {
                        spanned = Html.fromHtml(PassiveUpdate.passiveSkill9(
                                        String.valueOf(i),
                                        skill.get(i - 1).getOption1(), // ok
                                        skill.get(i - 1).getOption2(),
                                        skill.get(i - 1).getOption3(),
                                        skill.get(i - 1).getOption4(), // ok
                                        skill.get(i - 1).getOption5(), // ok
                                        skill.get(i).getOption1(),
                                        skill.get(i).getOption2(),
                                        skill.get(i).getOption3(),
                                        skill.get(i).getOption4(),
                                        skill.get(i).getOption5()),
                                Html.FROM_HTML_MODE_LEGACY);
                        textView.setText(spanned);
                        break;  // Exit loop after handling the correct value.
                    }
                }
            }
        }

    }

}
