package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.cjmkeke.d2rbooks.chardatabase.tools.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Defense8 {

    private static int defense_skill_1;

    public static void skillUpdate(int value, TextView textView, Context context, SharedPreferences sharedPreferences){
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

        Type listType = new TypeToken<List<Defense8.DefenseModel10>>() {}.getType();
        List<Defense8.DefenseModel10> skill = JsonUtil.loadJSONFromAsset(context, "defense8.json", listType);
        Spanned spanned;

        if (skill != null){
            if (value == 20) {
                spanned = Html.fromHtml(SkillDefense.defenseSkill8_end, Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
            } else if (value >= 1 && value < 21) {
                // Loop through values 0 to 19
                for (int i = 0; i < 21; i++) {
                    if (value == i) {
                        spanned = Html.fromHtml(DefenseUpdate.defenseSkill8(
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

    public class DefenseModel10{
        private String option1;
        private String option2;
        private String option3;
        private String option4;


        public String getOption1() {
            return option1;
        }

        public String getOption2() {
            return option2;
        }

        public String getOption3() {
            return option3;
        }

        public String getOption4() {
            return option4;
        }
    }

}
