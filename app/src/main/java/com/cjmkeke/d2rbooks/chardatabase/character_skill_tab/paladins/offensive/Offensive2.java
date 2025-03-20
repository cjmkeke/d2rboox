package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.offensive;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.SkillDefense;
import com.cjmkeke.d2rbooks.chardatabase.tools.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Offensive2 {

    public static void skillUpdate(int value, TextView textView, Context context, SharedPreferences sharedPreferences){
        Type listType = new TypeToken<List<Offensive2.OffensiveModel2>>() {}.getType();
        List<Offensive2.OffensiveModel2> skill = JsonUtil.loadJSONFromAsset(context, "offensive2.json", listType);
        Spanned spanned;
        if (skill != null){
            switch (value){
                case 1:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("1", skill.get(0).getDamage1(), skill.get(0).getDamage2(), skill.get(0).getRadius(),skill.get(1).getDamage1(),skill.get(1).getDamage2(),skill.get(1).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 2:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("2", skill.get(1).getDamage1(), skill.get(1).getDamage2(), skill.get(1).getRadius(),skill.get(2).getDamage1(),skill.get(2).getDamage2(),skill.get(2).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 3:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("3", skill.get(2).getDamage1(), skill.get(2).getDamage2(), skill.get(2).getRadius(),skill.get(3).getDamage1(),skill.get(3).getDamage2(),skill.get(3).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 4:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("4", skill.get(3).getDamage1(), skill.get(3).getDamage2(), skill.get(3).getRadius(),skill.get(4).getDamage1(),skill.get(4).getDamage2(),skill.get(4).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 5:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("5", skill.get(4).getDamage1(), skill.get(4).getDamage2(), skill.get(4).getRadius(),skill.get(5).getDamage1(),skill.get(5).getDamage2(),skill.get(5).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 6:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("6", skill.get(5).getDamage1(), skill.get(5).getDamage2(), skill.get(5).getRadius(),skill.get(6).getDamage1(),skill.get(6).getDamage2(),skill.get(6).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 7:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("7", skill.get(6).getDamage1(), skill.get(6).getDamage2(), skill.get(6).getRadius(),skill.get(7).getDamage1(),skill.get(7).getDamage2(),skill.get(7).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 8:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("8", skill.get(7).getDamage1(), skill.get(7).getDamage2(), skill.get(7).getRadius(),skill.get(8).getDamage1(),skill.get(8).getDamage2(),skill.get(8).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 9:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("9", skill.get(8).getDamage1(), skill.get(8).getDamage2(), skill.get(8).getRadius(),skill.get(9).getDamage1(),skill.get(9).getDamage2(),skill.get(9).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 10:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("10", skill.get(9).getDamage1(), skill.get(9).getDamage2(), skill.get(9).getRadius(),skill.get(10).getDamage1(),skill.get(10).getDamage2(),skill.get(10).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 11:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("11", skill.get(10).getDamage1(), skill.get(10).getDamage2(), skill.get(10).getRadius(),skill.get(11).getDamage1(),skill.get(11).getDamage2(),skill.get(11).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 12:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("12", skill.get(11).getDamage1(), skill.get(11).getDamage2(), skill.get(11).getRadius(),skill.get(12).getDamage1(),skill.get(12).getDamage2(),skill.get(12).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 13:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("13", skill.get(12).getDamage1(), skill.get(12).getDamage2(), skill.get(12).getRadius(),skill.get(13).getDamage1(),skill.get(13).getDamage2(),skill.get(13).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 14:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("14", skill.get(13).getDamage1(), skill.get(13).getDamage2(), skill.get(13).getRadius(),skill.get(14).getDamage1(),skill.get(14).getDamage2(),skill.get(14).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 15:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("15", skill.get(14).getDamage1(), skill.get(14).getDamage2(), skill.get(14).getRadius(),skill.get(15).getDamage1(),skill.get(15).getDamage2(),skill.get(15).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 16:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("16", skill.get(15).getDamage1(), skill.get(15).getDamage2(), skill.get(15).getRadius(),skill.get(16).getDamage1(),skill.get(16).getDamage2(),skill.get(16).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 17:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("17", skill.get(16).getDamage1(), skill.get(16).getDamage2(), skill.get(16).getRadius(),skill.get(17).getDamage1(),skill.get(17).getDamage2(),skill.get(17).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 18:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("18", skill.get(17).getDamage1(), skill.get(17).getDamage2(), skill.get(17).getRadius(),skill.get(18).getDamage1(),skill.get(18).getDamage2(),skill.get(18).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 19:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill2("19", skill.get(18).getDamage1(), skill.get(18).getDamage2(), skill.get(18).getRadius(),skill.get(19).getDamage1(),skill.get(19).getDamage2(),skill.get(19).getRadius(),"21","10"), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 20:
                    spanned = Html.fromHtml(SkillDefense.defenseSkill8_end, Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;


            }
        }
    }

    public class OffensiveModel2{
       private String radius;
       private String damage1;
       private String damage2;

        public String getRadius() {
            return radius;
        }

        public String getDamage1() {
            return damage1;
        }

        public String getDamage2() {
            return damage2;
        }
    }

}
