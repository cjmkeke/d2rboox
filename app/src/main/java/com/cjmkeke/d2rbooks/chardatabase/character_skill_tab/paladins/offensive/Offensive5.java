package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.offensive;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.cjmkeke.d2rbooks.chardatabase.tools.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Offensive5 {

    public static void skillUpdate(int value, TextView textView, Context context, SharedPreferences sharedPreferences){
        Type listType = new TypeToken<List<Offensive5.OffensiveModel5>>() {}.getType();
        List<Offensive5.OffensiveModel5> skill = JsonUtil.loadJSONFromAsset(context, "offensive5.json", listType);
        Spanned spanned;
        if (skill != null){
            if (value == 20) {
                spanned = Html.fromHtml(SkillOffensive.offensiveSkill5_end, Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
            } else if (value >= 1 && value < 21) {
                // Loop through values 0 to 19
                for (int i = 0; i < 21; i++) {
                    if (value == i) {
                        spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill5(
                                        String.valueOf(i),
                                        "20",
                                        skill.get(i - 1).getDamage1(),
                                        skill.get(i - 1).getRadius(),
                                        skill.get(i).getDamage1(),
                                        skill.get(i).getRadius()),
                                Html.FROM_HTML_MODE_LEGACY);
                        textView.setText(spanned);
                        break;  // Exit loop after handling the correct value.
                    }
                }
            }        }
    }

    public class OffensiveModel5{

        private String radius;
        private String damage1;

        public String getRadius() {
            return radius;
        }

        public String getDamage1() {
            return damage1;
        }
    }

}
