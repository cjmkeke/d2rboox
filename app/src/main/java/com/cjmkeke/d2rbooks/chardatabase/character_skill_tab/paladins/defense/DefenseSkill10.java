package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.cjmkeke.d2rbooks.chardatabase.tools.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class DefenseSkill10 {

    public static void defenseSkill_10(int defenseSkill_10, TextView textView, Context context){
        Type listType = new TypeToken<List<DefenseSkill10.PaladinsSkillData10>>() {}.getType();
        List<DefenseSkill10.PaladinsSkillData10> skill = JsonUtil.loadJSONFromAsset(context, "paladins_skill10.json", listType);

        Spanned spanned;
        if (skill != null){
            switch (defenseSkill_10){
                case 1:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("1",skill.get(0).getResist(),skill.get(0).getRadius(), skill.get(1).getResist(),skill.get(1).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 2:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("2",skill.get(1).getResist(),skill.get(1).getRadius(), skill.get(2).getResist(),skill.get(2).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 3:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("3",skill.get(2).getResist(),skill.get(2).getRadius(), skill.get(3).getResist(),skill.get(3).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 4:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("4",skill.get(3).getResist(),skill.get(3).getRadius(), skill.get(4).getResist(),skill.get(4).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 5:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("5",skill.get(4).getResist(),skill.get(4).getRadius(), skill.get(5).getResist(),skill.get(5).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 6:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("6",skill.get(5).getResist(),skill.get(5).getRadius(), skill.get(6).getResist(),skill.get(6).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 7:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("7",skill.get(6).getResist(),skill.get(6).getRadius(), skill.get(7).getResist(),skill.get(7).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 8:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("8",skill.get(7).getResist(),skill.get(7).getRadius(), skill.get(8).getResist(),skill.get(8).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 9:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("9",skill.get(8).getResist(),skill.get(8).getRadius(), skill.get(9).getResist(),skill.get(9).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 10:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("10",skill.get(9).getResist(),skill.get(9).getRadius(), skill.get(10).getResist(),skill.get(10).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 11:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("11",skill.get(10).getResist(),skill.get(10).getRadius(), skill.get(11).getResist(),skill.get(11).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 12:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("12",skill.get(11).getResist(),skill.get(11).getRadius(), skill.get(12).getResist(),skill.get(12).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 13:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("13",skill.get(12).getResist(),skill.get(12).getRadius(), skill.get(13).getResist(),skill.get(13).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 14:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("14",skill.get(14).getResist(),skill.get(13).getRadius(), skill.get(14).getResist(),skill.get(14).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 15:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("15",skill.get(15).getResist(),skill.get(14).getRadius(), skill.get(15).getResist(),skill.get(15).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 16:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("16",skill.get(16).getResist(),skill.get(15).getRadius(), skill.get(16).getResist(),skill.get(16).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 17:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("17",skill.get(17).getResist(),skill.get(16).getRadius(), skill.get(17).getResist(),skill.get(17).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 18:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("18",skill.get(18).getResist(),skill.get(17).getRadius(), skill.get(18).getResist(),skill.get(18).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 19:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_10("19",skill.get(19).getResist(),skill.get(19).getRadius(), skill.get(19).getResist(),skill.get(19).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 20:
                    spanned = Html.fromHtml(SkillDefense.defenseSkill10_end, Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;


            }
        }
    }

    public class PaladinsSkillData10 {
        private String radius;
        private String resist;

        public String getRadius() {
            return radius;
        }

        public String getResist() {
            return resist;
        }
    }

}
