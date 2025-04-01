package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.barbarian.warcries;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.cjmkeke.d2rbooks.chardatabase.tools.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Warcries1 {

    static final String JSON_FILE_NAME = "warcries1.json";


    public static void skillUpdate(int value, TextView textView, Context context, SharedPreferences sharedPreferences) {
        Type listType = new TypeToken<List<Models>>() {
        }.getType();
        List<Models> skill = JsonUtil.loadJSONFromAsset(context, JSON_FILE_NAME, listType);
        Spanned spanned;

        if (skill != null) {
            if (value == 20) {
                if (value == 20) {
                    spanned = Html.fromHtml(WarcriesUpdate.warcriesSkill1_end(
                            "20",
                            skill.get(19).getOption1(),
                            skill.get(19).getOption2(),
                            skill.get(19).getOption3(),
                            null,
                            null,
                            null,
                            null,
                            null,
                            null
                            ),
                    Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                }
            } else if (value >= 1 && value < 21) {
                // Loop through values 0 to 19
                for (int i = 0; i < 21; i++) {
                    if (value == i) {
                        spanned = Html.fromHtml(WarcriesUpdate.warcriesSkill1(
                                        String.valueOf(i),
                                        skill.get(i - 1).getOption1(),
                                        skill.get(i - 1).getOption2(),
                                        skill.get(i - 1).getOption3(),
                                        skill.get(i).getOption1(),
                                        skill.get(i).getOption2(),
                                        skill.get(i).getOption3()
                                ),
                                Html.FROM_HTML_MODE_LEGACY);
                        textView.setText(spanned);
                        break;  // Exit loop after handling the correct value.
                    }
                }
            }
        }

    }

    public class Models {
        private String option1;
        private String option2;
        private String option3;
        private String option4;
        private String option5;
        private String option6;
        private String option7;
        private String option8;
        private String option9;
        private String option10;


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

        public String getOption5() {
            return option5;
        }

        public String getOption6() {
            return option6;
        }

        public String getOption7() {
            return option7;
        }

        public String getOption8() {
            return option8;
        }

        public String getOption9() {
            return option9;
        }

        public String getOption10() {
            return option10;
        }
    }

}
