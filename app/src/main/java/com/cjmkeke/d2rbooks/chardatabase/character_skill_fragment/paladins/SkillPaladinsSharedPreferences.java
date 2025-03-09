package com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.paladins;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SkillPaladinsSharedPreferences {

    public static final String SKILL_TO_DEFENSE = "skill_to_defense";
    private static SharedPreferences skillPaladinsSharedPreferences;

    static void setPaladinSkillInitialValue(Context context) {
        skillPaladinsSharedPreferences = context.getSharedPreferences(SKILL_TO_DEFENSE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = skillPaladinsSharedPreferences.edit();

        String[] skill1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        String[] skill2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        String[] skill3 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        String[] skill4 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        String[] skill5 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        String[] skill6 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        String[] skill7 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        Gson gson = new Gson();
        String json1 = gson.toJson(skill1);
        String json2 = gson.toJson(skill2);
        String json3 = gson.toJson(skill3);
        String json4 = gson.toJson(skill4);
        String json5 = gson.toJson(skill5);
        String json6 = gson.toJson(skill6);
        String json7 = gson.toJson(skill7);

        if (!skillPaladinsSharedPreferences.contains("defense_skill_current_1")){
            editor.putString("defense_skill_current_1", "");
        }
        if (!skillPaladinsSharedPreferences.contains("defense_skill_current_2")){
            editor.putString("defense_skill_current_2", "");
        }
        if (!skillPaladinsSharedPreferences.contains("defense_skill_current_3")){
            editor.putString("defense_skill_current_3", "");
        }
        if (!skillPaladinsSharedPreferences.contains("defense_skill_current_4")){
            editor.putString("defense_skill_current_4", "");
        }
        if (!skillPaladinsSharedPreferences.contains("defense_skill_next_1")){
            editor.putString("defense_skill_next_1", "");
        }
        if (!skillPaladinsSharedPreferences.contains("defense_skill_next_2")){
            editor.putString("defense_skill_next_2", "");
        }
        if (!skillPaladinsSharedPreferences.contains("defense_skill_next_3")){
            editor.putString("defense_skill_next_3", "");
        }

        editor.putString("defense_skill_current_1", json1);
        editor.putString("defense_skill_current_2", json2);
        editor.putString("defense_skill_current_3", json3);
        editor.putString("defense_skill_current_4", json4);
        editor.putString("defense_skill_next_1", json5);
        editor.putString("defense_skill_next_2", json6);
        editor.putString("defense_skill_next_3", json7);
        editor.apply();
    }

}
