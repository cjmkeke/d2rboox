package com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.cjmkeke.d2rbooks.chardatabase.tools.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class DefenseSkill5 {

    public static int updateData;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener;

    public static void defenseSkill_5(int defenseSkill, TextView textView, Context context) {
        Type listType = new TypeToken<List<PaladinsSkillData5>>() {}.getType();
        List<PaladinsSkillData5> paladinsSkillData = JsonUtil.loadJSONFromAsset(context, "paladins_skill5.json", listType);
        sharedPreferences = context.getSharedPreferences("defense_point", Context.MODE_PRIVATE);
        onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, @Nullable String key) {
                updateData = sharedPreferences.getInt("defense_skill_1", 0);
                if (paladinsSkillData != null) {
                    Spanned spanned;
                    switch (defenseSkill) {
                        case 1:
                            spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                            textView.setText(spanned);
                            break;
                        case 2:
                            if (updateData == 1) {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("3", paladinsSkillData.get(1).getLevel(), paladinsSkillData.get(1).getCurrent_duration(), paladinsSkillData.get(1).getRadius(), paladinsSkillData.get(1).getNext_duration(), paladinsSkillData.get(1).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;
                        case 3:
                            if (updateData == 2) {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("4", paladinsSkillData.get(2).getLevel(), paladinsSkillData.get(2).getCurrent_duration(), paladinsSkillData.get(2).getRadius(), paladinsSkillData.get(2).getNext_duration(), paladinsSkillData.get(2).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;
                        case 4:
                            if (updateData == 3) {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("5", paladinsSkillData.get(3).getLevel(), paladinsSkillData.get(3).getCurrent_duration(), paladinsSkillData.get(3).getRadius(), paladinsSkillData.get(3).getNext_duration(), paladinsSkillData.get(3).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;
                        case 5:
                            if (updateData == 4) {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("6", paladinsSkillData.get(4).getLevel(), paladinsSkillData.get(4).getCurrent_duration(), paladinsSkillData.get(4).getRadius(), paladinsSkillData.get(4).getNext_duration(), paladinsSkillData.get(4).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;
                        case 6:
                            if (updateData == 5) {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("7", paladinsSkillData.get(5).getLevel(), paladinsSkillData.get(5).getCurrent_duration(), paladinsSkillData.get(5).getRadius(), paladinsSkillData.get(5).getNext_duration(), paladinsSkillData.get(5).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;
                        case 7:
                            if (updateData == 6) {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("8", paladinsSkillData.get(6).getLevel(), paladinsSkillData.get(6).getCurrent_duration(), paladinsSkillData.get(6).getRadius(), paladinsSkillData.get(6).getNext_duration(), paladinsSkillData.get(6).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;
                        case 8:
                            if (updateData == 7) {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("9", paladinsSkillData.get(7).getLevel(), paladinsSkillData.get(7).getCurrent_duration(), paladinsSkillData.get(7).getRadius(), paladinsSkillData.get(7).getNext_duration(), paladinsSkillData.get(7).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;
                        case 9:
                            if (updateData == 8) {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("10", paladinsSkillData.get(8).getLevel(), paladinsSkillData.get(8).getCurrent_duration(), paladinsSkillData.get(8).getRadius(), paladinsSkillData.get(8).getNext_duration(), paladinsSkillData.get(8).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;
                        case 10:
                            if (updateData == 9) {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("11", paladinsSkillData.get(9).getLevel(), paladinsSkillData.get(9).getCurrent_duration(), paladinsSkillData.get(9).getRadius(), paladinsSkillData.get(9).getNext_duration(), paladinsSkillData.get(9).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;
                        case 11:
                            if (updateData == 10) {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("12", paladinsSkillData.get(10).getLevel(), paladinsSkillData.get(10).getCurrent_duration(), paladinsSkillData.get(10).getRadius(), paladinsSkillData.get(10).getNext_duration(), paladinsSkillData.get(10).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;
                        case 12:
                            if (updateData == 11) {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("13", paladinsSkillData.get(11).getLevel(), paladinsSkillData.get(11).getCurrent_duration(), paladinsSkillData.get(11).getRadius(), paladinsSkillData.get(11).getNext_duration(), paladinsSkillData.get(11).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;
                        case 13:
                            if (updateData == 12) {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("14", paladinsSkillData.get(12).getLevel(), paladinsSkillData.get(12).getCurrent_duration(), paladinsSkillData.get(12).getRadius(), paladinsSkillData.get(12).getNext_duration(), paladinsSkillData.get(12).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;
                        case 14:
                            if (updateData == 13) {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("15", paladinsSkillData.get(13).getLevel(), paladinsSkillData.get(13).getCurrent_duration(), paladinsSkillData.get(13).getRadius(), paladinsSkillData.get(13).getNext_duration(), paladinsSkillData.get(13).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;
                        case 15:
                            if (updateData == 14) {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("16", paladinsSkillData.get(14).getLevel(), paladinsSkillData.get(14).getCurrent_duration(), paladinsSkillData.get(14).getRadius(), paladinsSkillData.get(14).getNext_duration(), paladinsSkillData.get(14).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;
                        case 16:
                            if (updateData == 15) {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("17", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(15).getLevel(), paladinsSkillData.get(15).getCurrent_duration(), paladinsSkillData.get(15).getRadius(), paladinsSkillData.get(15).getNext_duration(), paladinsSkillData.get(15).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;
                        case 17:
                            if (updateData == 16) {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("18", paladinsSkillData.get(16).getLevel(), paladinsSkillData.get(16).getCurrent_duration(), paladinsSkillData.get(16).getRadius(), paladinsSkillData.get(16).getNext_duration(), paladinsSkillData.get(16).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;
                        case 18:
                            if (updateData == 17) {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("19", paladinsSkillData.get(17).getLevel(), paladinsSkillData.get(17).getCurrent_duration(), paladinsSkillData.get(17).getRadius(), paladinsSkillData.get(17).getNext_duration(), paladinsSkillData.get(17).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;
                        case 19:
                            if (updateData == 18) {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("20", paladinsSkillData.get(18).getLevel(), paladinsSkillData.get(18).getCurrent_duration(), paladinsSkillData.get(18).getRadius(), paladinsSkillData.get(18).getNext_duration(), paladinsSkillData.get(18).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(DefenseUpdate.PaladinsSkill_5("2", paladinsSkillData.get(0).getLevel(), paladinsSkillData.get(0).getCurrent_duration(), paladinsSkillData.get(0).getRadius(), paladinsSkillData.get(0).getNext_duration(), paladinsSkillData.get(0).getNext_radius()), Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;
                        case 20:
                            if (updateData == 19) {
                                spanned = Html.fromHtml(SkillDefense.defenseSkill5_end, Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            } else {
                                spanned = Html.fromHtml(SkillDefense.defenseSkill5_end, Html.FROM_HTML_MODE_LEGACY);
                                textView.setText(spanned);
                            }
                            break;


                    }
                }

            }
        };

        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);

    }

    public class PaladinsSkillData5 {
        private String level;
        private String radius;
        private String next_radius;
        private String current_duration;
        private String next_duration;
        private String vitality_healing;

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getRadius() {
            return radius;
        }

        public void setRadius(String radius) {
            this.radius = radius;
        }

        public String getNext_radius() {
            return next_radius;
        }

        public void setNext_radius(String next_radius) {
            this.next_radius = next_radius;
        }

        public String getCurrent_duration() {
            return current_duration;
        }

        public void setCurrent_duration(String current_duration) {
            this.current_duration = current_duration;
        }

        public String getNext_duration() {
            return next_duration;
        }

        public void setNext_duration(String next_duration) {
            this.next_duration = next_duration;
        }

        public String getVitality_healing() {
            return vitality_healing;
        }

        public void setVitality_healing(String vitality_healing) {
            this.vitality_healing = vitality_healing;
        }
    }

}
