package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.offensive;

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

public class Offensive1  {

    static final String JSON_FILE_NAME = "offensive1.json";

    public static void skillUpdate(int value, TextView textView, Context context, SharedPreferences sharedPreferences){
        Type listType = TypeToken.getParameterized(List.class, JsonModels.class).getType();
        List<JsonModels> skill = JsonUtil.loadJSONFromAsset(context, JSON_FILE_NAME, listType);
        Spanned spanned;

        if (skill != null){
            switch (value){
                case 1:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("1", skill.get(0).getDamage(), skill.get(1).getDamage(), skill.get(1).getRadius(), skill.get(0).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 2:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("2", skill.get(1).getDamage(), skill.get(2).getDamage(),  skill.get(2).getRadius(), skill.get(1).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 3:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("3", skill.get(2).getDamage(), skill.get(3).getDamage(),  skill.get(3).getRadius(), skill.get(2).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 4:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("4", skill.get(3).getDamage(), skill.get(4).getDamage(),  skill.get(4).getRadius(), skill.get(3).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 5:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("5", skill.get(4).getDamage(), skill.get(5).getDamage(),  skill.get(5).getRadius(), skill.get(4).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 6:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("6", skill.get(5).getDamage(), skill.get(6).getDamage(),  skill.get(6).getRadius(), skill.get(5).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 7:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("7", skill.get(6).getDamage(), skill.get(7).getDamage(),  skill.get(7).getRadius(), skill.get(6).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 8:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("8", skill.get(7).getDamage(), skill.get(8).getDamage(),  skill.get(8).getRadius(), skill.get(7).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 9:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("9", skill.get(8).getDamage(), skill.get(9).getDamage(),  skill.get(9).getRadius(), skill.get(8).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 10:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("10", skill.get(9).getDamage(), skill.get(10).getDamage(),  skill.get(10).getRadius(), skill.get(9).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 11:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("11", skill.get(10).getDamage(), skill.get(11).getDamage(),  skill.get(11).getRadius(), skill.get(10).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 12:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("12", skill.get(11).getDamage(), skill.get(12).getDamage(),  skill.get(12).getRadius(), skill.get(11).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 13:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("13", skill.get(12).getDamage(), skill.get(13).getDamage(),  skill.get(13).getRadius(), skill.get(12).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 14:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("14", skill.get(13).getDamage(), skill.get(14).getDamage(),  skill.get(14).getRadius(), skill.get(13).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 15:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("15", skill.get(14).getDamage(), skill.get(15).getDamage(),  skill.get(15).getRadius(), skill.get(14).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 16:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("16", skill.get(15).getDamage(), skill.get(16).getDamage(),  skill.get(16).getRadius(), skill.get(15).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 17:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("17", skill.get(16).getDamage(), skill.get(17).getDamage(),  skill.get(17).getRadius(), skill.get(16).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 18:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("18", skill.get(17).getDamage(), skill.get(18).getDamage(),  skill.get(18).getRadius(), skill.get(17).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 19:
                    spanned = Html.fromHtml(OffensiveUpdate.offensiveSkill1("19", skill.get(18).getDamage(), skill.get(19).getDamage(),  skill.get(19).getRadius(), skill.get(18).getRadius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 20:
                    spanned = Html.fromHtml(SkillOffensive.offensiveSkill1_end, Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;


            }
        }
    }

}
