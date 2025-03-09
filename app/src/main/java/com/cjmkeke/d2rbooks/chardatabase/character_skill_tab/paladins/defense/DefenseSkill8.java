package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.cjmkeke.d2rbooks.chardatabase.tools.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class DefenseSkill8 {

    public static void defenseSkill_8(int defenseSkill_8, TextView textView, Context context){
        Type listType = new TypeToken<List<DefenseSkill8.PaladinsSkillData8>>() {}.getType();
        List<DefenseSkill8.PaladinsSkillData8> skill = JsonUtil.loadJSONFromAsset(context, "paladins_skill8.json", listType);
        Spanned spanned;
        if (skill != null){
            switch (defenseSkill_8){
                case 1:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("1",skill.get(0).getMana_recovery(),skill.get(0).getRadius(), skill.get(1).getMana_recovery(),skill.get(1).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 2:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("2",skill.get(1).getMana_recovery(),skill.get(1).getRadius(), skill.get(2).getMana_recovery(),skill.get(2).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 3:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("3",skill.get(2).getMana_recovery(),skill.get(2).getRadius(), skill.get(3).getMana_recovery(),skill.get(3).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 4:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("4",skill.get(3).getMana_recovery(),skill.get(3).getRadius(), skill.get(4).getMana_recovery(),skill.get(4).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 5:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("5",skill.get(4).getMana_recovery(),skill.get(4).getRadius(), skill.get(5).getMana_recovery(),skill.get(5).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 6:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("6",skill.get(5).getMana_recovery(),skill.get(5).getRadius(), skill.get(6).getMana_recovery(),skill.get(6).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 7:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("7",skill.get(6).getMana_recovery(),skill.get(6).getRadius(), skill.get(7).getMana_recovery(),skill.get(7).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 8:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("8",skill.get(7).getMana_recovery(),skill.get(7).getRadius(), skill.get(8).getMana_recovery(),skill.get(8).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 9:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("9",skill.get(8).getMana_recovery(),skill.get(8).getRadius(), skill.get(9).getMana_recovery(),skill.get(9).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 10:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("10",skill.get(9).getMana_recovery(),skill.get(9).getRadius(), skill.get(10).getMana_recovery(),skill.get(10).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 11:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("11",skill.get(10).getMana_recovery(),skill.get(10).getRadius(), skill.get(11).getMana_recovery(),skill.get(11).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 12:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("12",skill.get(11).getMana_recovery(),skill.get(11).getRadius(), skill.get(12).getMana_recovery(),skill.get(12).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 13:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("13",skill.get(12).getMana_recovery(),skill.get(12).getRadius(), skill.get(13).getMana_recovery(),skill.get(13).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 14:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("14",skill.get(13).getMana_recovery(),skill.get(13).getRadius(), skill.get(14).getMana_recovery(),skill.get(14).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 15:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("15",skill.get(14).getMana_recovery(),skill.get(14).getRadius(), skill.get(15).getMana_recovery(),skill.get(15).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 16:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("16",skill.get(15).getMana_recovery(),skill.get(15).getRadius(), skill.get(16).getMana_recovery(),skill.get(16).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 17:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("17",skill.get(16).getMana_recovery(),skill.get(16).getRadius(), skill.get(17).getMana_recovery(),skill.get(17).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 18:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("18",skill.get(17).getMana_recovery(),skill.get(17).getRadius(), skill.get(18).getMana_recovery(),skill.get(18).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 19:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_8("19",skill.get(18).getMana_recovery(),skill.get(18).getRadius(), skill.get(19).getMana_recovery(),skill.get(19).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 20:
                    spanned = Html.fromHtml(SkillDefense.defenseSkill8_end, Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;


            }
        }
    }

    public class PaladinsSkillData8{
        private String radius;
        private String mana_recovery ;

        public String getRadius() {
            return radius;
        }

        public String getMana_recovery() {
            return mana_recovery;
        }
    }

}
