package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.cjmkeke.d2rbooks.chardatabase.tools.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class DefenseSkill4 {

    public static void defenseSkill_4(int defenseSkill, TextView textView, Context context){
        Spanned spanned;

        Type listType = new TypeToken<List<DefenseSkill4.PaladinsSkillData4>>(){}.getType();
        List<PaladinsSkillData4> paladinsSkillData4s = JsonUtil.loadJSONFromAsset(context, "paladins_skill4.json", listType);
        if (paladinsSkillData4s != null) {
            switch (defenseSkill){
                case 1:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(0).getLevel(), paladinsSkillData4s.get(0).getCold_resist(), paladinsSkillData4s.get(0).getActivate(), paladinsSkillData4s.get(0).getLasting_effect(), paladinsSkillData4s.get(0).getRadius(), paladinsSkillData4s.get(0).getNext_cold_resist(), paladinsSkillData4s.get(0).getNext_activate(), paladinsSkillData4s.get(0).getNext_lasting_effect(), paladinsSkillData4s.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 2:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(1).getLevel(), paladinsSkillData4s.get(1).getCold_resist(), paladinsSkillData4s.get(1).getActivate(), paladinsSkillData4s.get(1).getLasting_effect(), paladinsSkillData4s.get(1).getRadius(), paladinsSkillData4s.get(1).getNext_cold_resist(), paladinsSkillData4s.get(1).getNext_activate(), paladinsSkillData4s.get(1).getNext_lasting_effect(), paladinsSkillData4s.get(1).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 3:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(2).getLevel(), paladinsSkillData4s.get(2).getCold_resist(), paladinsSkillData4s.get(2).getActivate(), paladinsSkillData4s.get(2).getLasting_effect(), paladinsSkillData4s.get(2).getRadius(), paladinsSkillData4s.get(2).getNext_cold_resist(), paladinsSkillData4s.get(2).getNext_activate(), paladinsSkillData4s.get(2).getNext_lasting_effect(), paladinsSkillData4s.get(2).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 4:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(3).getLevel(), paladinsSkillData4s.get(3).getCold_resist(), paladinsSkillData4s.get(3).getActivate(), paladinsSkillData4s.get(3).getLasting_effect(), paladinsSkillData4s.get(3).getRadius(), paladinsSkillData4s.get(3).getNext_cold_resist(), paladinsSkillData4s.get(3).getNext_activate(), paladinsSkillData4s.get(3).getNext_lasting_effect(), paladinsSkillData4s.get(3).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 5:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(4).getLevel(), paladinsSkillData4s.get(4).getCold_resist(), paladinsSkillData4s.get(4).getActivate(), paladinsSkillData4s.get(4).getLasting_effect(), paladinsSkillData4s.get(4).getRadius(), paladinsSkillData4s.get(4).getNext_cold_resist(), paladinsSkillData4s.get(4).getNext_activate(), paladinsSkillData4s.get(4).getNext_lasting_effect(), paladinsSkillData4s.get(4).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 6:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(5).getLevel(), paladinsSkillData4s.get(5).getCold_resist(), paladinsSkillData4s.get(5).getActivate(), paladinsSkillData4s.get(5).getLasting_effect(), paladinsSkillData4s.get(5).getRadius(), paladinsSkillData4s.get(5).getNext_cold_resist(), paladinsSkillData4s.get(5).getNext_activate(), paladinsSkillData4s.get(5).getNext_lasting_effect(), paladinsSkillData4s.get(5).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 7:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(6).getLevel(), paladinsSkillData4s.get(6).getCold_resist(), paladinsSkillData4s.get(6).getActivate(), paladinsSkillData4s.get(6).getLasting_effect(), paladinsSkillData4s.get(6).getRadius(), paladinsSkillData4s.get(6).getNext_cold_resist(), paladinsSkillData4s.get(6).getNext_activate(), paladinsSkillData4s.get(6).getNext_lasting_effect(), paladinsSkillData4s.get(6).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 8:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(7).getLevel(), paladinsSkillData4s.get(7).getCold_resist(), paladinsSkillData4s.get(7).getActivate(), paladinsSkillData4s.get(7).getLasting_effect(), paladinsSkillData4s.get(7).getRadius(), paladinsSkillData4s.get(7).getNext_cold_resist(), paladinsSkillData4s.get(7).getNext_activate(), paladinsSkillData4s.get(7).getNext_lasting_effect(), paladinsSkillData4s.get(7).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 9:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(8).getLevel(), paladinsSkillData4s.get(8).getCold_resist(), paladinsSkillData4s.get(8).getActivate(), paladinsSkillData4s.get(8).getLasting_effect(), paladinsSkillData4s.get(8).getRadius(), paladinsSkillData4s.get(8).getNext_cold_resist(), paladinsSkillData4s.get(8).getNext_activate(), paladinsSkillData4s.get(8).getNext_lasting_effect(), paladinsSkillData4s.get(8).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 10:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(9).getLevel(), paladinsSkillData4s.get(9).getCold_resist(), paladinsSkillData4s.get(9).getActivate(), paladinsSkillData4s.get(9).getLasting_effect(), paladinsSkillData4s.get(9).getRadius(), paladinsSkillData4s.get(9).getNext_cold_resist(), paladinsSkillData4s.get(9).getNext_activate(), paladinsSkillData4s.get(9).getNext_lasting_effect(), paladinsSkillData4s.get(9).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 11:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(10).getLevel(), paladinsSkillData4s.get(10).getCold_resist(), paladinsSkillData4s.get(10).getActivate(), paladinsSkillData4s.get(10).getLasting_effect(), paladinsSkillData4s.get(10).getRadius(), paladinsSkillData4s.get(10).getNext_cold_resist(), paladinsSkillData4s.get(10).getNext_activate(), paladinsSkillData4s.get(10).getNext_lasting_effect(), paladinsSkillData4s.get(10).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 12:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(11).getLevel(), paladinsSkillData4s.get(11).getCold_resist(), paladinsSkillData4s.get(11).getActivate(), paladinsSkillData4s.get(11).getLasting_effect(), paladinsSkillData4s.get(11).getRadius(), paladinsSkillData4s.get(11).getNext_cold_resist(), paladinsSkillData4s.get(11).getNext_activate(), paladinsSkillData4s.get(11).getNext_lasting_effect(), paladinsSkillData4s.get(11).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 13:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(12).getLevel(), paladinsSkillData4s.get(12).getCold_resist(), paladinsSkillData4s.get(12).getActivate(), paladinsSkillData4s.get(12).getLasting_effect(), paladinsSkillData4s.get(12).getRadius(), paladinsSkillData4s.get(12).getNext_cold_resist(), paladinsSkillData4s.get(12).getNext_activate(), paladinsSkillData4s.get(12).getNext_lasting_effect(), paladinsSkillData4s.get(12).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 14:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(13).getLevel(), paladinsSkillData4s.get(13).getCold_resist(), paladinsSkillData4s.get(13).getActivate(), paladinsSkillData4s.get(13).getLasting_effect(), paladinsSkillData4s.get(13).getRadius(), paladinsSkillData4s.get(13).getNext_cold_resist(), paladinsSkillData4s.get(13).getNext_activate(), paladinsSkillData4s.get(13).getNext_lasting_effect(), paladinsSkillData4s.get(13).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 15:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(14).getLevel(), paladinsSkillData4s.get(14).getCold_resist(), paladinsSkillData4s.get(14).getActivate(), paladinsSkillData4s.get(14).getLasting_effect(), paladinsSkillData4s.get(14).getRadius(), paladinsSkillData4s.get(14).getNext_cold_resist(), paladinsSkillData4s.get(14).getNext_activate(), paladinsSkillData4s.get(14).getNext_lasting_effect(), paladinsSkillData4s.get(14).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 16:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(15).getLevel(), paladinsSkillData4s.get(15).getCold_resist(), paladinsSkillData4s.get(15).getActivate(), paladinsSkillData4s.get(15).getLasting_effect(), paladinsSkillData4s.get(15).getRadius(), paladinsSkillData4s.get(15).getNext_cold_resist(), paladinsSkillData4s.get(15).getNext_activate(), paladinsSkillData4s.get(15).getNext_lasting_effect(), paladinsSkillData4s.get(15).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 17:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(16).getLevel(), paladinsSkillData4s.get(16).getCold_resist(), paladinsSkillData4s.get(16).getActivate(), paladinsSkillData4s.get(16).getLasting_effect(), paladinsSkillData4s.get(16).getRadius(), paladinsSkillData4s.get(16).getNext_cold_resist(), paladinsSkillData4s.get(16).getNext_activate(), paladinsSkillData4s.get(16).getNext_lasting_effect(), paladinsSkillData4s.get(16).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 18:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(17).getLevel(), paladinsSkillData4s.get(17).getCold_resist(), paladinsSkillData4s.get(17).getActivate(), paladinsSkillData4s.get(17).getLasting_effect(), paladinsSkillData4s.get(17).getRadius(), paladinsSkillData4s.get(17).getNext_cold_resist(), paladinsSkillData4s.get(17).getNext_activate(), paladinsSkillData4s.get(17).getNext_lasting_effect(), paladinsSkillData4s.get(17).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 19:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_4(paladinsSkillData4s.get(19).getLevel(), paladinsSkillData4s.get(18).getCold_resist(), paladinsSkillData4s.get(18).getActivate(), paladinsSkillData4s.get(18).getLasting_effect(), paladinsSkillData4s.get(18).getRadius(), paladinsSkillData4s.get(18).getNext_cold_resist(), paladinsSkillData4s.get(18).getNext_activate(), paladinsSkillData4s.get(18).getNext_lasting_effect(), paladinsSkillData4s.get(18).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 20:
                    spanned = Html.fromHtml(SkillDefense.defenseSkill3_end, Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;


            }
        }

    }

    public class PaladinsSkillData4{
        private String level;
        private String radius;
        private String cold_resist;
        private String activate;
        private String lasting_effect;
        private String next_cold_resist;
        private String next_activate;
        private String next_lasting_effect;
        private String next_radius;

        public String getLevel() {
            return level;
        }

        public String getRadius() {
            return radius;
        }

        public String getCold_resist() {
            return cold_resist;
        }

        public String getActivate() {
            return activate;
        }

        public String getLasting_effect() {
            return lasting_effect;
        }

        public String getNext_cold_resist() {
            return next_cold_resist;
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
