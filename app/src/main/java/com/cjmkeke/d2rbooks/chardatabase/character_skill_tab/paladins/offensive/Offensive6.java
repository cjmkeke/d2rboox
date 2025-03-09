package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.offensive;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.cjmkeke.d2rbooks.chardatabase.tools.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Offensive6 {

    public static void skillUpdate(int value, TextView textView, Context context){
        Type listType = new TypeToken<List<Offensive6.OffensiveModel6>>() {}.getType();
        List<Offensive6.OffensiveModel6> skill = JsonUtil.loadJSONFromAsset(context, "offensive6.json", listType);
        Spanned spanned;
        if (skill != null){
            if (value == 20) {
                spanned = Html.fromHtml(SkillOffensive.offensiveSkill6_end, Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
            } else if (value >= 1 && value < 21) {
                // Loop through values 0 to 19
                for (int i = 0; i < 21; i++) {
                    if (value == i) {
                        spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill6(
                                        String.valueOf(i),
                                        skill.get(i - 1).getCold_damage_added_to_player(),
                                        skill.get(i - 1).getAura_cold_damage(),
                                        skill.get(i - 1).getEmemies_slowed(),
                                        skill.get(i - 1).getRadius(),
                                        skill.get(i).getCold_damage_added_to_player(),
                                        skill.get(i).getAura_cold_damage(),
                                        skill.get(i).getEmemies_slowed(),
                                        skill.get(i).getRadius(),
                                        "15",
                                        "7"),
                                Html.FROM_HTML_MODE_LEGACY);
                        textView.setText(spanned);
                        break;  // Exit loop after handling the correct value.
                    }
                }
            }        }
    }

    public class OffensiveModel6{

        private String radius;
        private String aura_cold_damage;
        private String cold_damage_added_to_player;
        private String ememies_slowed;

        public String getRadius() {
            return radius;
        }

        public String getAura_cold_damage() {
            return aura_cold_damage;
        }

        public String getCold_damage_added_to_player() {
            return cold_damage_added_to_player;
        }

        public String getEmemies_slowed() {
            return ememies_slowed;
        }
    }

}
