package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.cjmkeke.d2rbooks.chardatabase.tools.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class DefenseSkill7 {

    public static void defenseSkill_7(int defenseSkill_7, TextView textView, Context context){
        Type listType = new TypeToken<List<DefenseSkill7.PaladinsSkillData7>>() {}.getType();
        List<DefenseSkill7.PaladinsSkillData7> skill = JsonUtil.loadJSONFromAsset(context, "paladins_skill7.json", listType);
        Spanned spanned;
        if (skill != null) {
            switch (defenseSkill_7){
                case 1:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("1",skill.get(0).getSpeed(),skill.get(0).getRecovery(), skill.get(0).getRecovery(),skill.get(0).getRadius(),skill.get(1).getSpeed(),skill.get(1).getRecovery(),skill.get(1).getRecovery(),skill.get(1).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 2:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("2",skill.get(1).getSpeed(),skill.get(1).getRecovery(), skill.get(1).getRecovery(),skill.get(1).getRadius(),skill.get(2).getSpeed(),skill.get(2).getRecovery(),skill.get(2).getRecovery(),skill.get(2).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 3:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("3",skill.get(2).getSpeed(),skill.get(2).getRecovery(), skill.get(2).getRecovery(),skill.get(2).getRadius(),skill.get(3).getSpeed(),skill.get(3).getRecovery(),skill.get(3).getRecovery(),skill.get(3).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 4:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("4",skill.get(3).getSpeed(),skill.get(3).getRecovery(), skill.get(3).getRecovery(),skill.get(3).getRadius(),skill.get(4).getSpeed(),skill.get(4).getRecovery(),skill.get(4).getRecovery(),skill.get(4).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 5:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("5",skill.get(4).getSpeed(),skill.get(4).getRecovery(), skill.get(4).getRecovery(),skill.get(4).getRadius(),skill.get(5).getSpeed(),skill.get(5).getRecovery(),skill.get(5).getRecovery(),skill.get(5).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 6:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("6",skill.get(5).getSpeed(),skill.get(5).getRecovery(), skill.get(5).getRecovery(),skill.get(5).getRadius(),skill.get(6).getSpeed(),skill.get(6).getRecovery(),skill.get(6).getRecovery(),skill.get(6).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 7:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("7",skill.get(6).getSpeed(),skill.get(6).getRecovery(), skill.get(6).getRecovery(),skill.get(6).getRadius(),skill.get(7).getSpeed(),skill.get(7).getRecovery(),skill.get(7).getRecovery(),skill.get(7).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 8:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("8",skill.get(7).getSpeed(),skill.get(7).getRecovery(), skill.get(7).getRecovery(),skill.get(7).getRadius(),skill.get(8).getSpeed(),skill.get(8).getRecovery(),skill.get(8).getRecovery(),skill.get(8).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 9:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("9",skill.get(8).getSpeed(),skill.get(8).getRecovery(), skill.get(8).getRecovery(),skill.get(8).getRadius(),skill.get(9).getSpeed(),skill.get(9).getRecovery(),skill.get(9).getRecovery(),skill.get(9).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 10:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("10",skill.get(9).getSpeed(),skill.get(9).getRecovery(), skill.get(9).getRecovery(),skill.get(9).getRadius(),skill.get(10).getSpeed(),skill.get(10).getRecovery(),skill.get(10).getRecovery(),skill.get(10).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 11:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("11",skill.get(10).getSpeed(),skill.get(10).getRecovery(), skill.get(10).getRecovery(),skill.get(10).getRadius(),skill.get(11).getSpeed(),skill.get(11).getRecovery(),skill.get(11).getRecovery(),skill.get(11).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 12:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("12",skill.get(11).getSpeed(),skill.get(11).getRecovery(), skill.get(11).getRecovery(),skill.get(11).getRadius(),skill.get(12).getSpeed(),skill.get(12).getRecovery(),skill.get(12).getRecovery(),skill.get(12).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 13:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("13",skill.get(12).getSpeed(),skill.get(12).getRecovery(), skill.get(12).getRecovery(),skill.get(12).getRadius(),skill.get(13).getSpeed(),skill.get(13).getRecovery(),skill.get(13).getRecovery(),skill.get(14).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 14:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("14",skill.get(13).getSpeed(),skill.get(13).getRecovery(), skill.get(13).getRecovery(),skill.get(13).getRadius(),skill.get(14).getSpeed(),skill.get(14).getRecovery(),skill.get(14).getRecovery(),skill.get(15).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 15:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("15",skill.get(14).getSpeed(),skill.get(14).getRecovery(), skill.get(14).getRecovery(),skill.get(14).getRadius(),skill.get(15).getSpeed(),skill.get(15).getRecovery(),skill.get(15).getRecovery(),skill.get(16).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 16:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("16",skill.get(15).getSpeed(),skill.get(15).getRecovery(), skill.get(15).getRecovery(),skill.get(15).getRadius(),skill.get(16).getSpeed(),skill.get(16).getRecovery(),skill.get(16).getRecovery(),skill.get(17).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 17:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("17",skill.get(16).getSpeed(),skill.get(16).getRecovery(), skill.get(16).getRecovery(),skill.get(16).getRadius(),skill.get(17).getSpeed(),skill.get(17).getRecovery(),skill.get(17).getRecovery(),skill.get(18).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 18:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("18",skill.get(17).getSpeed(),skill.get(17).getRecovery(), skill.get(17).getRecovery(),skill.get(17).getRadius(),skill.get(18).getSpeed(),skill.get(18).getRecovery(),skill.get(18).getRecovery(),skill.get(19).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 19:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_7("19",skill.get(18).getSpeed(),skill.get(18).getRecovery(), skill.get(18).getRecovery(),skill.get(18).getRadius(),skill.get(19).getSpeed(),skill.get(19).getRecovery(),skill.get(19).getRecovery(),skill.get(1).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 20:
                    spanned = Html.fromHtml(SkillDefense.defenseSkill7_end, Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;


            }
        }
    }

    public class PaladinsSkillData7{
        private String level;
        private String radius;
        private String speed;
        private String recovery;

        public String getLevel() {
            return level;
        }

        public String getRadius() {
            return radius;
        }

        public String getSpeed() {
            return speed;
        }

        public String getRecovery() {
            return recovery;
        }
    }

}
