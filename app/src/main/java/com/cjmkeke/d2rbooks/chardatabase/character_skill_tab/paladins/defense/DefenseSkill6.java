package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.cjmkeke.d2rbooks.chardatabase.tools.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class DefenseSkill6 {

    public static void defenseSkill_6(int defenseSkill, TextView textView, Context context){
        Type listType = new TypeToken<List<DefenseSkill6.PaladinsSkillData6>>() {}.getType();
        List<DefenseSkill6.PaladinsSkillData6> paladinsSkillData = JsonUtil.loadJSONFromAsset(context, "paladins_skill6.json", listType);
        Spanned spanned;
        if (paladinsSkillData != null) {
            switch (defenseSkill){
                case 1:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(0).getLevel(),paladinsSkillData.get(0).getLightning_resist(),paladinsSkillData.get(0).getActivate(), paladinsSkillData.get(0).getLasting_effect(),paladinsSkillData.get(0).getRadius(),paladinsSkillData.get(0).getNext_lightning_resist(),paladinsSkillData.get(0).getNext_activate(),paladinsSkillData.get(0).getNext_lasting_effect(),paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 2:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(1).getLevel(),paladinsSkillData.get(1).getLightning_resist(),paladinsSkillData.get(1).getActivate(), paladinsSkillData.get(1).getLasting_effect(),paladinsSkillData.get(1).getRadius(),paladinsSkillData.get(1).getNext_lightning_resist(),paladinsSkillData.get(1).getNext_activate(),paladinsSkillData.get(1).getNext_lasting_effect(),paladinsSkillData.get(1).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 3:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(2).getLevel(),paladinsSkillData.get(2).getLightning_resist(),paladinsSkillData.get(2).getActivate(), paladinsSkillData.get(2).getLasting_effect(),paladinsSkillData.get(2).getRadius(),paladinsSkillData.get(2).getNext_lightning_resist(),paladinsSkillData.get(2).getNext_activate(),paladinsSkillData.get(2).getNext_lasting_effect(),paladinsSkillData.get(2).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 4:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(3).getLevel(),paladinsSkillData.get(3).getLightning_resist(),paladinsSkillData.get(3).getActivate(), paladinsSkillData.get(3).getLasting_effect(),paladinsSkillData.get(3).getRadius(),paladinsSkillData.get(3).getNext_lightning_resist(),paladinsSkillData.get(3).getNext_activate(),paladinsSkillData.get(3).getNext_lasting_effect(),paladinsSkillData.get(3).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 5:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(4).getLevel(),paladinsSkillData.get(4).getLightning_resist(),paladinsSkillData.get(4).getActivate(), paladinsSkillData.get(4).getLasting_effect(),paladinsSkillData.get(4).getRadius(),paladinsSkillData.get(4).getNext_lightning_resist(),paladinsSkillData.get(4).getNext_activate(),paladinsSkillData.get(4).getNext_lasting_effect(),paladinsSkillData.get(4).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 6:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(5).getLevel(),paladinsSkillData.get(5).getLightning_resist(),paladinsSkillData.get(5).getActivate(), paladinsSkillData.get(5).getLasting_effect(),paladinsSkillData.get(5).getRadius(),paladinsSkillData.get(5).getNext_lightning_resist(),paladinsSkillData.get(5).getNext_activate(),paladinsSkillData.get(5).getNext_lasting_effect(),paladinsSkillData.get(5).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 7:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(6).getLevel(),paladinsSkillData.get(6).getLightning_resist(),paladinsSkillData.get(6).getActivate(), paladinsSkillData.get(6).getLasting_effect(),paladinsSkillData.get(6).getRadius(),paladinsSkillData.get(6).getNext_lightning_resist(),paladinsSkillData.get(6).getNext_activate(),paladinsSkillData.get(6).getNext_lasting_effect(),paladinsSkillData.get(6).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 8:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(7).getLevel(),paladinsSkillData.get(7).getLightning_resist(),paladinsSkillData.get(7).getActivate(), paladinsSkillData.get(7).getLasting_effect(),paladinsSkillData.get(7).getRadius(),paladinsSkillData.get(7).getNext_lightning_resist(),paladinsSkillData.get(7).getNext_activate(),paladinsSkillData.get(7).getNext_lasting_effect(),paladinsSkillData.get(7).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 9:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(8).getLevel(),paladinsSkillData.get(8).getLightning_resist(),paladinsSkillData.get(8).getActivate(), paladinsSkillData.get(8).getLasting_effect(),paladinsSkillData.get(8).getRadius(),paladinsSkillData.get(8).getNext_lightning_resist(),paladinsSkillData.get(8).getNext_activate(),paladinsSkillData.get(8).getNext_lasting_effect(),paladinsSkillData.get(8).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 10:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(9).getLevel(),paladinsSkillData.get(9).getLightning_resist(),paladinsSkillData.get(9).getActivate(), paladinsSkillData.get(9).getLasting_effect(),paladinsSkillData.get(9).getRadius(),paladinsSkillData.get(9).getNext_lightning_resist(),paladinsSkillData.get(9).getNext_activate(),paladinsSkillData.get(9).getNext_lasting_effect(),paladinsSkillData.get(9).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 11:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(10).getLevel(),paladinsSkillData.get(10).getLightning_resist(),paladinsSkillData.get(10).getActivate(), paladinsSkillData.get(10).getLasting_effect(),paladinsSkillData.get(10).getRadius(),paladinsSkillData.get(10).getNext_lightning_resist(),paladinsSkillData.get(10).getNext_activate(),paladinsSkillData.get(10).getNext_lasting_effect(),paladinsSkillData.get(10).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 12:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(11).getLevel(),paladinsSkillData.get(11).getLightning_resist(),paladinsSkillData.get(11).getActivate(), paladinsSkillData.get(11).getLasting_effect(),paladinsSkillData.get(11).getRadius(),paladinsSkillData.get(11).getNext_lightning_resist(),paladinsSkillData.get(11).getNext_activate(),paladinsSkillData.get(11).getNext_lasting_effect(),paladinsSkillData.get(11).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 13:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(12).getLevel(),paladinsSkillData.get(12).getLightning_resist(),paladinsSkillData.get(12).getActivate(), paladinsSkillData.get(12).getLasting_effect(),paladinsSkillData.get(12).getRadius(),paladinsSkillData.get(12).getNext_lightning_resist(),paladinsSkillData.get(12).getNext_activate(),paladinsSkillData.get(12).getNext_lasting_effect(),paladinsSkillData.get(12).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 14:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(13).getLevel(),paladinsSkillData.get(13).getLightning_resist(),paladinsSkillData.get(13).getActivate(), paladinsSkillData.get(13).getLasting_effect(),paladinsSkillData.get(13).getRadius(),paladinsSkillData.get(13).getNext_lightning_resist(),paladinsSkillData.get(13).getNext_activate(),paladinsSkillData.get(13).getNext_lasting_effect(),paladinsSkillData.get(13).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 15:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(14).getLevel(),paladinsSkillData.get(14).getLightning_resist(),paladinsSkillData.get(14).getActivate(), paladinsSkillData.get(14).getLasting_effect(),paladinsSkillData.get(14).getRadius(),paladinsSkillData.get(14).getNext_lightning_resist(),paladinsSkillData.get(14).getNext_activate(),paladinsSkillData.get(14).getNext_lasting_effect(),paladinsSkillData.get(14).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 16:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(15).getLevel(),paladinsSkillData.get(15).getLightning_resist(),paladinsSkillData.get(15).getActivate(), paladinsSkillData.get(15).getLasting_effect(),paladinsSkillData.get(15).getRadius(),paladinsSkillData.get(15).getNext_lightning_resist(),paladinsSkillData.get(15).getNext_activate(),paladinsSkillData.get(15).getNext_lasting_effect(),paladinsSkillData.get(15).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 17:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(16).getLevel(),paladinsSkillData.get(16).getLightning_resist(),paladinsSkillData.get(16).getActivate(), paladinsSkillData.get(16).getLasting_effect(),paladinsSkillData.get(16).getRadius(),paladinsSkillData.get(16).getNext_lightning_resist(),paladinsSkillData.get(16).getNext_activate(),paladinsSkillData.get(16).getNext_lasting_effect(),paladinsSkillData.get(16).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 18:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(17).getLevel(),paladinsSkillData.get(17).getLightning_resist(),paladinsSkillData.get(17).getActivate(), paladinsSkillData.get(17).getLasting_effect(),paladinsSkillData.get(17).getRadius(),paladinsSkillData.get(17).getNext_lightning_resist(),paladinsSkillData.get(17).getNext_activate(),paladinsSkillData.get(17).getNext_lasting_effect(),paladinsSkillData.get(17).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 19:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_6(paladinsSkillData.get(18).getLevel(),paladinsSkillData.get(18).getLightning_resist(),paladinsSkillData.get(18).getActivate(), paladinsSkillData.get(18).getLasting_effect(),paladinsSkillData.get(18).getRadius(),paladinsSkillData.get(18).getNext_lightning_resist(),paladinsSkillData.get(18).getNext_activate(),paladinsSkillData.get(18).getNext_lasting_effect(),paladinsSkillData.get(18).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 20:
                    spanned = Html.fromHtml(SkillDefense.defenseSkill6_end, Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;


            }

        }
    }

    public class PaladinsSkillData6{
        private String level;
        private String radius;
        private String lightning_resist;
        private String activate;
        private String lasting_effect;
        private String next_lightning_resist;
        private String next_activate;
        private String next_lasting_effect;
        private String next_radius;

        public String getLevel() {
            return level;
        }

        public String getRadius() {
            return radius;
        }

        public String getLightning_resist() {
            return lightning_resist;
        }

        public String getActivate() {
            return activate;
        }

        public String getLasting_effect() {
            return lasting_effect;
        }

        public String getNext_lightning_resist() {
            return next_lightning_resist;
        }

        public String getNext_activate() {
            return next_activate;
        }

        public String getNext_lasting_effect() {
            return next_lasting_effect;
        }

        public String getNext_radius() {
            return next_radius;
        }
    }

}
