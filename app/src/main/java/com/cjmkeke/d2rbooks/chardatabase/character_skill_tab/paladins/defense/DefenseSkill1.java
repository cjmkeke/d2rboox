package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense;

import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

public class DefenseSkill1 {


    public static void defenseSkill_1(int defenseSkill_1, TextView textView) {
        Spanned spanned;
        switch (defenseSkill_1) {
            case 1:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("1", "1", "2", "10.6", "1.1", "3", "12"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 2:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("2", "1.1", "3", "12", "1.3", "4", "13.3"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 3:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("3", "1.3", "4", "13.3", "1.5", "5", "14.6"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 4:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("4", "1.5", "5", "14.6", "1.7", "6", "16"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 5:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("5", "1.7", "6", "16", "1.9", "7", "17.3"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 6:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("6", "1.9", "7", "17.3", "2.1", "8", "18.6"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 7:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("7", "2.1", "8", "18.6", "2.3", "9", "20"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 8:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("8", "2.3", "9", "20", "2.5", "10", "21.3"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 9:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("9", "2.5", "10", "21.3", "2.6", "11", "22.5"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 10:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("10", "2.6", "11", "22.6", "2.8", "12", "24"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 11:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("11", "2.8", "12", "24", "3", "13", "25.3"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 12:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("12", "3", "13", "25.3", "3.2", "14", "26.6"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 13:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("13", "3.2", "14", "26.6", "3.4", "15", "28"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 14:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("14", "3.4", "15", "28", "3.6", "16", "29.3"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 15:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("15", "3.6", "16", "29.3", "3.8", "17", "30.6"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 16:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("16", "3.8", "17", "30.6", "4", "19", "32"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 17:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("17", "4", "19", "32", "4.1", "21", "33.3"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 18:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("18", "4.1", "21", "33.3", "4.3", "23", "34.6"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 19:
                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_1("19", "4.3", "23", "34.6", "4.5", "25", "36"), Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
            case 20:
                spanned = Html.fromHtml(SkillDefense.defenseSkill1_end, Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
                break;
        }
    }

}
