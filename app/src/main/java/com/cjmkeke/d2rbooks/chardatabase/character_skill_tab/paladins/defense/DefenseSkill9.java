package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.cjmkeke.d2rbooks.chardatabase.tools.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class DefenseSkill9 {

    public static void defenseSkill_9(int defenseSkill_9, TextView textView, Context context){
        Type listType = new TypeToken<List<DefenseSkill9.PaladinsSkillData9>>() {}.getType();
        List<DefenseSkill9.PaladinsSkillData9> skill = JsonUtil.loadJSONFromAsset(context, "paladins_skill9.json", listType);
        Spanned spanned;
        if (skill != null){
            switch (defenseSkill_9){
                case 1:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","1",skill.get(0).getChance_redeem_corpse(), skill.get(0).getRecovery_per_corpse(),skill.get(1).getChance_redeem_corpse(),skill.get(1).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 2:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","2",skill.get(1).getChance_redeem_corpse(), skill.get(1).getRecovery_per_corpse(),skill.get(2).getChance_redeem_corpse(),skill.get(2).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 3:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","3",skill.get(2).getChance_redeem_corpse(), skill.get(2).getRecovery_per_corpse(),skill.get(3).getChance_redeem_corpse(),skill.get(3).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 4:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","4",skill.get(3).getChance_redeem_corpse(), skill.get(3).getRecovery_per_corpse(),skill.get(4).getChance_redeem_corpse(),skill.get(4).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 5:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","5",skill.get(4).getChance_redeem_corpse(), skill.get(4).getRecovery_per_corpse(),skill.get(5).getChance_redeem_corpse(),skill.get(5).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 6:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","6",skill.get(5).getChance_redeem_corpse(), skill.get(5).getRecovery_per_corpse(),skill.get(6).getChance_redeem_corpse(),skill.get(6).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 7:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","7",skill.get(6).getChance_redeem_corpse(), skill.get(6).getRecovery_per_corpse(),skill.get(7).getChance_redeem_corpse(),skill.get(7).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 8:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","8",skill.get(7).getChance_redeem_corpse(), skill.get(7).getRecovery_per_corpse(),skill.get(8).getChance_redeem_corpse(),skill.get(8).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 9:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","9",skill.get(8).getChance_redeem_corpse(), skill.get(8).getRecovery_per_corpse(),skill.get(9).getChance_redeem_corpse(),skill.get(9).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 10:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","10",skill.get(9).getChance_redeem_corpse(), skill.get(9).getRecovery_per_corpse(),skill.get(10).getChance_redeem_corpse(),skill.get(10).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 11:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","11",skill.get(10).getChance_redeem_corpse(), skill.get(10).getRecovery_per_corpse(),skill.get(11).getChance_redeem_corpse(),skill.get(11).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 12:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","12",skill.get(11).getChance_redeem_corpse(), skill.get(11).getRecovery_per_corpse(),skill.get(12).getChance_redeem_corpse(),skill.get(12).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 13:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","13",skill.get(12).getChance_redeem_corpse(), skill.get(12).getRecovery_per_corpse(),skill.get(13).getChance_redeem_corpse(),skill.get(13).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 14:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","14",skill.get(13).getChance_redeem_corpse(), skill.get(13).getRecovery_per_corpse(),skill.get(14).getChance_redeem_corpse(),skill.get(14).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 15:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","15",skill.get(14).getChance_redeem_corpse(), skill.get(14).getRecovery_per_corpse(),skill.get(15).getChance_redeem_corpse(),skill.get(15).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 16:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","16",skill.get(15).getChance_redeem_corpse(), skill.get(15).getRecovery_per_corpse(),skill.get(16).getChance_redeem_corpse(),skill.get(16).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 17:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","17",skill.get(16).getChance_redeem_corpse(), skill.get(16).getRecovery_per_corpse(),skill.get(17).getChance_redeem_corpse(),skill.get(17).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 18:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","18",skill.get(17).getChance_redeem_corpse(), skill.get(17).getRecovery_per_corpse(),skill.get(18).getChance_redeem_corpse(),skill.get(18).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 19:
                    spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_9("10.6","19",skill.get(18).getChance_redeem_corpse(), skill.get(18).getRecovery_per_corpse(),skill.get(19).getChance_redeem_corpse(),skill.get(19).getRecovery_per_corpse()), Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;
                case 20:
                    spanned = Html.fromHtml(SkillDefense.defenseSkill9_end, Html.FROM_HTML_MODE_LEGACY);
                    textView.setText(spanned);
                    break;


            }
        }
    }

    public class PaladinsSkillData9{
        private String chance_redeem_corpse;
        private String recovery_per_corpse;

        public String getChance_redeem_corpse() {
            return chance_redeem_corpse;
        }

        public String getRecovery_per_corpse() {
            return recovery_per_corpse;
        }
    }

}
