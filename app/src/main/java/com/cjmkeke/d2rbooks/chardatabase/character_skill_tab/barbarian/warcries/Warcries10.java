package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.barbarian.warcries;

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

public class Warcries10 {

    static final String JSON_FILE_NAME = "warcries10.json";

    public static void skillUpdate(int value, TextView textView, Context context, SharedPreferences sharedPreferences){
        Type listType = TypeToken.getParameterized(List.class, JsonModels.class).getType();
        List<JsonModels> skill = JsonUtil.loadJSONFromAsset(context, JSON_FILE_NAME, listType);
        Spanned spanned;

        if (skill != null){
            if (value == 20) {
                if (value == 20) {
                    spanned = Html.fromHtml(WarcriesUpdate.warcriesSkill10_end(
                                    "20",
                                    skill.get(19).getOption1(),
                                    null,
                                    null,
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
                for (int i = 0; i < 21; i++) {
                    if (value == i) {
                        spanned = Html.fromHtml(WarcriesUpdate.warcriesSkill10(
                                        String.valueOf(i),
                                        skill.get(i - 1).getOption1(),
                                        skill.get(i).getOption1())

                                ,
                                Html.FROM_HTML_MODE_LEGACY);
                        textView.setText(spanned);
                        break;  // Exit loop after handling the correct value.
                    }
                }
            }
        }

    }


}
