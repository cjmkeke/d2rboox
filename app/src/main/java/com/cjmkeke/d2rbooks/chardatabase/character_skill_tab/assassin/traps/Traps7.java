package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.traps;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.cjmkeke.d2rbooks.chardatabase.tools.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Traps7 {

    public static void skillUpdate(int value, TextView textView, Context context){
        Type listType = new TypeToken<List<Traps7.TrapsModel10>>() {}.getType();
        List<Traps7.TrapsModel10> skill = JsonUtil.loadJSONFromAsset(context, "traps7.json", listType);
        Spanned spanned;

        if (skill != null){
            if (value == 20) {
                spanned = Html.fromHtml(SkillTraps.trapsSkill7_end, Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
            } else if (value >= 1 && value < 21) {
                // Loop through values 0 to 19
                for (int i = 0; i < 21; i++) {
                    if (value == i) {
                        spanned = Html.fromHtml(TrapsUpdate.trapsSkill7(
                                        String.valueOf(i),
                                        skill.get(i - 1).getOption1(),
                                        skill.get(i).getOption1()),
                                Html.FROM_HTML_MODE_LEGACY);
                        textView.setText(spanned);
                        break;  // Exit loop after handling the correct value.
                    }
                }
            }
        }

    }

    public class TrapsModel10{
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
