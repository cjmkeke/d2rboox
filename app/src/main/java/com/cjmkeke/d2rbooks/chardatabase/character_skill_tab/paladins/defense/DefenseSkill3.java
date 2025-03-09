package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense;

import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

public class DefenseSkill3 {

    public static void defenseSkill_3(int defenseSkill_3, TextView textView){
        Spanned spanned;
        switch (defenseSkill_3){
            case 1:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("1","70%"," 10.6", "80%","12"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 2:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("2","80%"," 12", "90%","13.3"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 3:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("3","90%","13.3", "100%","14.6"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 4:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("4","100%","14.6", "110%","16"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 5:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("5","110%","16", "120%","17.3"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 6:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("6","120%","17.3", "130%","18.6"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 7:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("7","130%","18.6", "140%","20"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 8:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("8","140%","20", "150%","21.3"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 9:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("9","150%","21.3", "160%","22.6"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 10:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("10","160%","22.6", "170%","24"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 11:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("11","170%","24", "180%","25.3"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 12:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("12","180%","25.3", "190%","26.6"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 13:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("13","190%","26.6", "200%","28"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 14:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("14","200%","28", "210%","29.3"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 15:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("15","210%","29.3", "220%","30.6"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 16:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("16","220%","30.6", "230%","32"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 17:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("17","230%","32", "240%","33.3"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 18:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("18","240%","33.3", "250%","34.6"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 19:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_3("19","250%","34.6", "260%","36"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 20:
                spanned = Html.fromHtml(SkillDefense.defenseSkill3_end, Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;


        }
    }


}
