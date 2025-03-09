package com.cjmkeke.d2rbooks.chardatabase.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.shadow.Shadow1;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.shadow.Shadow10;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.shadow.Shadow2;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.shadow.Shadow3;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.shadow.Shadow4;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.shadow.Shadow5;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.shadow.Shadow6;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.shadow.Shadow7;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.shadow.Shadow8;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.shadow.Shadow9;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.shadow.SkillShadow;

public class CharacterSkillUpdate {

    private Context context;
    private int skillPoint;
    private int skillQuestCompletePoint;
    private int skill_point_1, skill_point_2, skill_point_3, skill_point_4, skill_point_5, skill_point_6, skill_point_7, skill_point_8, skill_point_9, skill_point_10;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener;

    private String CHARACTER_SKILL_STRING;
    private String SKILL_POINT_QUEST_COMPLETE_KEY;
    private String SKILL_POINT_KEY;
    private String SKILL_TABLE_NAME;
    private String messagePremiseSkill;
    private TextView skillValues, skillValuesQuest;
    private TextView skillUpdate;
    private TextView skillLossedValue1, skillLossedValue2, skillLossedValue3, skillLossedValue4, skillLossedValue5, skillLossedValue6, skillLossedValue7, skillLossedValue8, skillLossedValue9, skillLossedValue10;
    private ImageView skillImageView1, skillImageView2, skillImageView3, skillImageView4, skillImageView5, skillImageView6, skillImageView7, skillImageView8, skillImageView9, skillImageView10;

    public CharacterSkillUpdate(Context context, SharedPreferences sharedPreferences, SharedPreferences.Editor editor, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener, TextView skillLossedValue1, TextView skillLossedValue2, TextView skillLossedValue3, TextView skillLossedValue4, TextView skillLossedValue5, TextView skillLossedValue6, TextView skillLossedValue7, TextView skillLossedValue8, TextView skillLossedValue9, TextView skillLossedValue10) {
        this.onSharedPreferenceChangeListener = onSharedPreferenceChangeListener;
        this.sharedPreferences = sharedPreferences;
        this.editor = editor;
        this.context = context;
        this.skillLossedValue1 = skillLossedValue1;
        this.skillLossedValue2 = skillLossedValue2;
        this.skillLossedValue3 = skillLossedValue3;
        this.skillLossedValue4 = skillLossedValue4;
        this.skillLossedValue5 = skillLossedValue5;
        this.skillLossedValue6 = skillLossedValue6;
        this.skillLossedValue7 = skillLossedValue7;
        this.skillLossedValue8 = skillLossedValue8;
        this.skillLossedValue9 = skillLossedValue9;
        this.skillLossedValue10 = skillLossedValue10;
    }

    public void setSkillPoint(int skillPoint, int skill_point_1, int skill_point_2, int skill_point_3, int skill_point_4, int skill_point_5, int skill_point_6, int skill_point_7, int skill_point_8, int skill_point_9, int skill_point_10) {
        this.skillPoint = skillPoint;
        this.skill_point_1 = skill_point_1;
        this.skill_point_2 = skill_point_2;
        this.skill_point_3 = skill_point_3;
        this.skill_point_4 = skill_point_4;
        this.skill_point_5 = skill_point_5;
        this.skill_point_6 = skill_point_6;
        this.skill_point_7 = skill_point_7;
        this.skill_point_8 = skill_point_8;
        this.skill_point_9 = skill_point_9;
        this.skill_point_10 = skill_point_10;
    }

    public void setSkillImageUpdate(ImageView skillImageView1, ImageView skillImageView2, ImageView skillImageView3, ImageView skillImageView4, ImageView skillImageView5, ImageView skillImageView6, ImageView skillImageView7, ImageView skillImageView8, ImageView skillImageView9, ImageView skillImageView10) {
        this.skillImageView1 = skillImageView1;
        this.skillImageView2 = skillImageView2;
        this.skillImageView3 = skillImageView3;
        this.skillImageView4 = skillImageView4;
        this.skillImageView5 = skillImageView5;
        this.skillImageView6 = skillImageView6;
        this.skillImageView7 = skillImageView7;
        this.skillImageView8 = skillImageView8;
        this.skillImageView9 = skillImageView9;
        this.skillImageView10 = skillImageView10;
    }

    public void hasSkillUp(String imagesSkillNumber, ImageView imagesImageView, TextView valueTextView, boolean conditionProvider) {
        Spanned spanned;
        int resId = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_" + imagesSkillNumber + "_2", "drawable", context.getPackageName());
        int clickId = imagesImageView.getId();

        if (skillPoint == 0) {
            Toast.makeText(context, "스킬 포인트가 없습니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (conditionProvider) {
            skillUpdate.setText(messagePremiseSkill);
            return;
        }

        int skillId1 = context.getResources().getIdentifier("iv_btn_skill_image_1", "id", context.getPackageName());
        int skillId2 = context.getResources().getIdentifier("iv_btn_skill_image_2", "id", context.getPackageName());
        int skillId3 = context.getResources().getIdentifier("iv_btn_skill_image_3", "id", context.getPackageName());
        int skillId4 = context.getResources().getIdentifier("iv_btn_skill_image_4", "id", context.getPackageName());
        int skillId5 = context.getResources().getIdentifier("iv_btn_skill_image_5", "id", context.getPackageName());
        int skillId6 = context.getResources().getIdentifier("iv_btn_skill_image_6", "id", context.getPackageName());
        int skillId7 = context.getResources().getIdentifier("iv_btn_skill_image_7", "id", context.getPackageName());
        int skillId8 = context.getResources().getIdentifier("iv_btn_skill_image_8", "id", context.getPackageName());
        int skillId9 = context.getResources().getIdentifier("iv_btn_skill_image_9", "id", context.getPackageName());
        int skillId10 = context.getResources().getIdentifier("iv_btn_skill_image_10", "id", context.getPackageName());

        if (skill_point_1 == 20) {
            if (skillId1 != 0) {
                if (clickId == skillId1) {
                    spanned = Html.fromHtml(SkillShadow.shadowSkill1_end, Html.FROM_HTML_MODE_LEGACY);
                    skillUpdate.setText(spanned);
                    return;
                }
            }
        }

        if (skill_point_1 < 20) {
            if (skillId1 != 0) {
                if (clickId == skillId1) {
                    System.out.println("1 번 스킬");
                    skillPoint--;
                    skill_point_1++;
                    imagesImageView.setImageResource(resId);
                    valueTextView.setText(String.valueOf(skill_point_1));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_1", skill_point_1);
                    editor.apply();
                    Shadow1.skillUpdate(skill_point_1, skillUpdate, context);
                }
            }
        }

        if (skill_point_2 == 20) {
            if (skillId2 != 0) {
                if (clickId == skillId2) {
                    spanned = Html.fromHtml(SkillShadow.shadowSkill2_end, Html.FROM_HTML_MODE_LEGACY);
                    skillUpdate.setText(spanned);
                    return;
                }
            }

        }

        if (skill_point_2 < 20) {
            if (skillId2 != 0) {
                if (clickId == skillId2) {
                    System.out.println("2 번 스킬");
                    skillPoint--;
                    skill_point_2++;
                    imagesImageView.setImageResource(resId);
                    valueTextView.setText(String.valueOf(skill_point_2));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_2", skill_point_2);
                    editor.apply();
                    Shadow2.skillUpdate(skill_point_2, skillUpdate, context);
                }
            }

        }

        if (skill_point_3 == 20) {
            if (skillId3 != 0) {
                if (clickId == skillId3) {
                    spanned = Html.fromHtml(SkillShadow.shadowSkill3_end, Html.FROM_HTML_MODE_LEGACY);
                    skillUpdate.setText(spanned);
                }
            }

        }

        if (skill_point_3 < 20) {
            if (skillId3 != 0) {
                if (clickId == skillId3) {
                    System.out.println("3 번 스킬");
                    skillPoint--;
                    skill_point_3++;
                    imagesImageView.setImageResource(resId);
                    valueTextView.setText(String.valueOf(skill_point_3));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_3", skill_point_3);
                    editor.apply();
                    Shadow3.skillUpdate(skill_point_3, skillUpdate, context);
                }
            }

        }

        if (skill_point_4 == 20) {
            if (skillId4 != 0) {
                if (clickId == skillId4) {
                    spanned = Html.fromHtml(SkillShadow.shadowSkill4_end, Html.FROM_HTML_MODE_LEGACY);
                    skillUpdate.setText(spanned);
                }
            }

        }

        if (skill_point_4 < 20) {
            if (skillId4 != 0) {
                if (clickId == skillId4) {
                    System.out.println("4 번 스킬");
                    skillPoint--;
                    skill_point_4++;
                    imagesImageView.setImageResource(resId);
                    valueTextView.setText(String.valueOf(skill_point_4));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_4", skill_point_4);
                    editor.apply();
                    Shadow4.skillUpdate(skill_point_4, skillUpdate, context);
                }
            }
        }

        if (skill_point_5 == 20) {
            if (skillId5 != 0) {
                if (clickId == skillId5) {
                    spanned = Html.fromHtml(SkillShadow.shadowSkill5_end, Html.FROM_HTML_MODE_LEGACY);
                    skillUpdate.setText(spanned);
                }
            }

        }

        if (skill_point_5 < 20) {
            if (skillId5 != 0) {
                if (clickId == skillId5) {
                    System.out.println("5 번 스킬");
                    skillPoint--;
                    skill_point_5++;
                    imagesImageView.setImageResource(resId);
                    valueTextView.setText(String.valueOf(skill_point_5));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_5", skill_point_5);
                    editor.apply();
                    Shadow5.skillUpdate(skill_point_5, skillUpdate, context);
                }
            }
        }

        if (skill_point_6 == 20) {
            if (skillId6 != 0) {
                if (clickId == skillId6) {
                    spanned = Html.fromHtml(SkillShadow.shadowSkill6_end, Html.FROM_HTML_MODE_LEGACY);
                    skillUpdate.setText(spanned);
                }
            }
        }

        if (skill_point_6 < 20) {
            if (skillId6 != 0) {
                if (clickId == skillId6) {
                    System.out.println("6 번 스킬");
                    skillPoint--;
                    skill_point_6++;
                    imagesImageView.setImageResource(resId);
                    valueTextView.setText(String.valueOf(skill_point_6));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_6", skill_point_6);
                    editor.apply();
                    Shadow6.skillUpdate(skill_point_6, skillUpdate, context);
                }
            }
        }

        if (skill_point_7 == 20) {
            if (skillId7 != 0) {
                if (clickId == skillId7) {
                    spanned = Html.fromHtml(SkillShadow.shadowSkill7_end, Html.FROM_HTML_MODE_LEGACY);
                    skillUpdate.setText(spanned);
                }
            }
        }

        if (skill_point_7 < 20) {
            if (skillId7 != 0) {
                if (clickId == skillId7) {
                    System.out.println("7 번 스킬");
                    skillPoint--;
                    skill_point_7++;
                    imagesImageView.setImageResource(resId);
                    valueTextView.setText(String.valueOf(skill_point_7));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_7", skill_point_7);
                    editor.apply();
                    if (messagePremiseSkill == null) {
                        skillUpdate.setText(SkillShadow.shadowSkill7);
                    }
                    Shadow7.skillUpdate(skill_point_7, skillUpdate, context);
                }
            }
        }

        if (skill_point_8 == 20) {
            if (skillId8 != 0) {
                if (clickId == skillId8) {
                    spanned = Html.fromHtml(SkillShadow.shadowSkill8_end, Html.FROM_HTML_MODE_LEGACY);
                    skillUpdate.setText(spanned);
                }
            }
        }

        if (skill_point_8 < 20) {
            if (skillId8 != 0) {
                if (clickId == skillId8) {
                    System.out.println("8 번 스킬");
                    skillPoint--;
                    skill_point_8++;
                    imagesImageView.setImageResource(resId);
                    valueTextView.setText(String.valueOf(skill_point_8));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_8", skill_point_8);
                    editor.apply();
                    Shadow8.skillUpdate(skill_point_8, skillUpdate, context);
                }
            }
        }

        if (skill_point_9 == 20) {
            if (skillId9 != 0) {
                if (clickId == skillId9) {
                    spanned = Html.fromHtml(SkillShadow.shadowSkill9_end, Html.FROM_HTML_MODE_LEGACY);
                    skillUpdate.setText(spanned);
                }
            }
        }

        if (skill_point_9 < 20) {
            if (skillId9 != 0) {
                if (clickId == skillId9) {
                    System.out.println("9 번 스킬");
                    skillPoint--;
                    skill_point_9++;
                    imagesImageView.setImageResource(resId);
                    valueTextView.setText(String.valueOf(skill_point_9));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_9", skill_point_9);
                    editor.apply();
                    Shadow9.skillUpdate(skill_point_9, skillUpdate, context);
                }
            }
        }

        if (skill_point_10 == 20) {
            if (skillId10 != 0) {
                if (clickId == skillId10) {
                    spanned = Html.fromHtml(SkillShadow.shadowSkill10_end, Html.FROM_HTML_MODE_LEGACY);
                    skillUpdate.setText(spanned);
                }
            }
        }

        if (skill_point_10 < 20) {
            if (skillId10 != 0) {
                if (clickId == skillId10) {
                    System.out.println("10 번 스킬");
                    skillPoint--;
                    skill_point_10++;
                    imagesImageView.setImageResource(resId);
                    valueTextView.setText(String.valueOf(skill_point_10));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_10", skill_point_10);
                    editor.apply();
                    Shadow10.skillUpdate(skill_point_10, skillUpdate, context);
                }
            }
        }

        skillPointView();

    }

    public void hasSkillDown(String imagesSkillNumber, ImageView imagesImageView, TextView minusButton, TextView valueTextView, boolean conditionProvider) {
        String skillMessage = "스킬 업데이트를 해주세요";
        int resId = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_" + imagesSkillNumber + "_1", "drawable", context.getPackageName());
        int clickId = minusButton.getId();

        if (conditionProvider) {
            return;
        }

        int skillId1 = context.getResources().getIdentifier("tv_btn_1_value_minus", "id", context.getPackageName());
        int skillId2 = context.getResources().getIdentifier("tv_btn_2_value_minus", "id", context.getPackageName());
        int skillId3 = context.getResources().getIdentifier("tv_btn_3_value_minus", "id", context.getPackageName());
        int skillId4 = context.getResources().getIdentifier("tv_btn_4_value_minus", "id", context.getPackageName());
        int skillId5 = context.getResources().getIdentifier("tv_btn_5_value_minus", "id", context.getPackageName());
        int skillId6 = context.getResources().getIdentifier("tv_btn_6_value_minus", "id", context.getPackageName());
        int skillId7 = context.getResources().getIdentifier("tv_btn_7_value_minus", "id", context.getPackageName());
        int skillId8 = context.getResources().getIdentifier("tv_btn_8_value_minus", "id", context.getPackageName());
        int skillId9 = context.getResources().getIdentifier("tv_btn_9_value_minus", "id", context.getPackageName());
        int skillId10 = context.getResources().getIdentifier("tv_btn_10_value_minus", "id", context.getPackageName());

        if (skill_point_1 != 0) {
            if (skillId1 != 0) {
                if (clickId == skillId1) {
                    Log.w("마이너스 스킬", ": 1 번");
                    skillPoint++;
                    skill_point_1--;
                    valueTextView.setText(String.valueOf(skill_point_1));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_1", skill_point_1);
                    editor.apply();
                    if (skill_point_1 == 0) {
                        imagesImageView.setImageResource(resId);
                        skillUpdate.setText(skillMessage);
                    }
                    Shadow1.skillUpdate(skill_point_1, skillUpdate, context);
                }
            }
        }

        if (skill_point_2 != 0) {
            if (skillId2 != 0) {
                if (clickId == skillId2) {
                    Log.w("마이너스 스킬", ": 2 번");
                    skillPoint++;
                    skill_point_2--;
                    valueTextView.setText(String.valueOf(skill_point_2));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_2", skill_point_2);
                    editor.apply();
                    if (skill_point_2 == 0) {
                        imagesImageView.setImageResource(resId);
                        skillUpdate.setText(skillMessage);
                    }
                    Shadow2.skillUpdate(skill_point_2, skillUpdate, context);
                }
            }
        }

        if (skill_point_3 != 0) {
            if (skillId3 != 0) {
                if (clickId == skillId3) {
                    Log.w("마이너스 스킬", ": 3 번");
                    skillPoint++;
                    skill_point_3--;
                    valueTextView.setText(String.valueOf(skill_point_3));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_3", skill_point_3);
                    editor.apply();
                    if (skill_point_3 == 0) {
                        imagesImageView.setImageResource(resId);
                        skillUpdate.setText(skillMessage);
                    }
                    Shadow3.skillUpdate(skill_point_3, skillUpdate, context);
                }
            }
        }

        if (skill_point_4 != 0) {
            if (skillId4 != 0) {
                if (clickId == skillId4) {
                    Log.w("마이너스 스킬", ": 4 번");
                    skillPoint++;
                    skill_point_4--;
                    valueTextView.setText(String.valueOf(skill_point_4));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_4", skill_point_4);
                    editor.apply();
                    if (skill_point_4 == 0) {
                        imagesImageView.setImageResource(resId);
                        skillUpdate.setText(skillMessage);
                    }
                    Shadow4.skillUpdate(skill_point_4, skillUpdate, context);
                }
            }
        }

        if (skill_point_5 != 0) {
            if (skillId5 != 0) {
                if (clickId == skillId5) {
                    Log.w("마이너스 스킬", ": 5 번");
                    skillPoint++;
                    skill_point_5--;
                    valueTextView.setText(String.valueOf(skill_point_5));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_5", skill_point_5);
                    editor.apply();
                    if (skill_point_5 == 0) {
                        imagesImageView.setImageResource(resId);
                        skillUpdate.setText(skillMessage);
                    }
                    Shadow5.skillUpdate(skill_point_5, skillUpdate, context);
                }
            }
        }

        if (skill_point_6 != 0) {
            if (skillId6 != 0) {
                if (clickId == skillId6) {
                    Log.w("마이너스 스킬", ": 6 번");
                    skillPoint++;
                    skill_point_6--;
                    valueTextView.setText(String.valueOf(skill_point_6));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_6", skill_point_6);
                    editor.apply();
                    if (skill_point_6 == 0) {
                        imagesImageView.setImageResource(resId);
                        skillUpdate.setText(skillMessage);
                    }
                    Shadow6.skillUpdate(skill_point_6, skillUpdate, context);
                }
            }
        }

        if (skill_point_7 != 0) {
            if (skillId7 != 0) {
                if (clickId == skillId7) {
                    Log.w("마이너스 스킬", ": 7 번");
                    skillPoint++;
                    skill_point_7--;
                    valueTextView.setText(String.valueOf(skill_point_7));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_7", skill_point_7);
                    editor.apply();
                    if (skill_point_7 == 0) {
                        imagesImageView.setImageResource(resId);
                        skillUpdate.setText(skillMessage);
                    }
                    Shadow7.skillUpdate(skill_point_7, skillUpdate, context);
                }
            }
        }

        if (skill_point_8 != 0) {
            if (skillId8 != 0) {
                if (clickId == skillId8) {
                    Log.w("마이너스 스킬", ": 8 번");
                    skillPoint++;
                    skill_point_8--;
                    valueTextView.setText(String.valueOf(skill_point_8));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_8", skill_point_8);
                    editor.apply();
                    if (skill_point_8 == 0) {
                        imagesImageView.setImageResource(resId);
                        skillUpdate.setText(skillMessage);
                    }
                    Shadow8.skillUpdate(skill_point_8, skillUpdate, context);
                }
            }
        }

        if (skill_point_9 != 0) {
            if (skillId9 != 0) {
                if (clickId == skillId9) {
                    Log.w("마이너스 스킬", ": 9 번");
                    skillPoint++;
                    skill_point_9--;
                    valueTextView.setText(String.valueOf(skill_point_9));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_9", skill_point_9);
                    editor.apply();
                    if (skill_point_9 == 0) {
                        imagesImageView.setImageResource(resId);
                        skillUpdate.setText(skillMessage);
                    }
                    Shadow9.skillUpdate(skill_point_9, skillUpdate, context);
                }
            }
        }

        if (skill_point_10 != 0) {
            if (skillId10 != 0) {
                if (clickId == skillId10) {
                    Log.w("마이너스 스킬", ": 10 번");
                    skillPoint++;
                    skill_point_10--;
                    valueTextView.setText(String.valueOf(skill_point_10));
                    editor.putInt(SKILL_POINT_KEY, skillPoint);
                    editor.putInt(SKILL_TABLE_NAME + "_skill_10", skill_point_10);
                    editor.apply();
                    if (skill_point_10 == 0) {
                        imagesImageView.setImageResource(resId);
                        skillUpdate.setText(skillMessage);
                    }
                    Shadow10.skillUpdate(skill_point_10, skillUpdate, context);
                }
            }
        }

        skillPointView();

    }

    public void resetAllSkillPoint(String[] array1, String[] array2, String[] array3) {
        skillPoint = 98;
        skill_point_1 = 0;
        skill_point_2 = 0;
        skill_point_3 = 0;
        skill_point_4 = 0;
        skill_point_5 = 0;
        skill_point_6 = 0;
        skill_point_7 = 0;
        skill_point_8 = 0;
        skill_point_9 = 0;
        skill_point_10 = 0;
        editor.putInt(SKILL_POINT_KEY, skillPoint);
        editor.putInt(array1[0], 0);
        editor.putInt(array1[1], 0);
        editor.putInt(array1[2], 0);
        editor.putInt(array1[3], 0);
        editor.putInt(array1[4], 0);
        editor.putInt(array1[5], 0);
        editor.putInt(array1[6], 0);
        editor.putInt(array1[7], 0);
        editor.putInt(array1[8], 0);
        editor.putInt(array1[9], 0);

        editor.putInt(array2[0], 0);
        editor.putInt(array2[1], 0);
        editor.putInt(array2[2], 0);
        editor.putInt(array2[3], 0);
        editor.putInt(array2[4], 0);
        editor.putInt(array2[5], 0);
        editor.putInt(array2[6], 0);
        editor.putInt(array2[7], 0);
        editor.putInt(array2[8], 0);
        editor.putInt(array2[9], 0);

        editor.putInt(array3[0], 0);
        editor.putInt(array3[1], 0);
        editor.putInt(array3[2], 0);
        editor.putInt(array3[3], 0);
        editor.putInt(array3[4], 0);
        editor.putInt(array3[5], 0);
        editor.putInt(array3[6], 0);
        editor.putInt(array3[7], 0);
        editor.putInt(array3[8], 0);
        editor.putInt(array3[9], 0);
        editor.commit();

        int skillId1 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_1_1", "drawable", context.getPackageName());
        int skillId2 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_2_1", "drawable", context.getPackageName());
        int skillId3 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_3_1", "drawable", context.getPackageName());
        int skillId4 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_4_1", "drawable", context.getPackageName());
        int skillId5 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_5_1", "drawable", context.getPackageName());
        int skillId6 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_6_1", "drawable", context.getPackageName());
        int skillId7 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_7_1", "drawable", context.getPackageName());
        int skillId8 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_8_1", "drawable", context.getPackageName());
        int skillId9 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_9_1", "drawable", context.getPackageName());
        int skillId10 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_10_1", "drawable", context.getPackageName());

        skillImageView1.setImageResource(skillId1);
        skillImageView2.setImageResource(skillId2);
        skillImageView3.setImageResource(skillId3);
        skillImageView4.setImageResource(skillId4);
        skillImageView5.setImageResource(skillId5);
        skillImageView6.setImageResource(skillId6);
        skillImageView7.setImageResource(skillId7);
        skillImageView8.setImageResource(skillId8);
        skillImageView9.setImageResource(skillId9);
        skillImageView10.setImageResource(skillId10);
        skillLossedValue1.setText("0");
        skillLossedValue2.setText("0");
        skillLossedValue3.setText("0");
        skillLossedValue4.setText("0");
        skillLossedValue5.setText("0");
        skillLossedValue6.setText("0");
        skillLossedValue7.setText("0");
        skillLossedValue8.setText("0");
        skillLossedValue9.setText("0");
        skillLossedValue10.setText("0");
        skillPointView();
    }

    public void resetSkillPoint(String[] array1, String[] array2) {

        int skillId1 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_1_1", "drawable", context.getPackageName());
        int skillId2 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_2_1", "drawable", context.getPackageName());
        int skillId3 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_3_1", "drawable", context.getPackageName());
        int skillId4 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_4_1", "drawable", context.getPackageName());
        int skillId5 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_5_1", "drawable", context.getPackageName());
        int skillId6 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_6_1", "drawable", context.getPackageName());
        int skillId7 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_7_1", "drawable", context.getPackageName());
        int skillId8 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_8_1", "drawable", context.getPackageName());
        int skillId9 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_9_1", "drawable", context.getPackageName());
        int skillId10 = context.getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_10_1", "drawable", context.getPackageName());

        int v1 = sharedPreferences.getInt(array1[0], 0);
        int v2 = sharedPreferences.getInt(array1[1], 0);
        int v3 = sharedPreferences.getInt(array1[2], 0);
        int v4 = sharedPreferences.getInt(array1[3], 0);
        int v5 = sharedPreferences.getInt(array1[4], 0);
        int v6 = sharedPreferences.getInt(array1[5], 0);
        int v7 = sharedPreferences.getInt(array1[6], 0);
        int v8 = sharedPreferences.getInt(array1[7], 0);
        int v9 = sharedPreferences.getInt(array1[8], 0);
        int v10 = sharedPreferences.getInt(array1[9], 0);

        int b1 = sharedPreferences.getInt(array2[0], 0);
        int b2 = sharedPreferences.getInt(array2[1], 0);
        int b3 = sharedPreferences.getInt(array2[2], 0);
        int b4 = sharedPreferences.getInt(array2[3], 0);
        int b5 = sharedPreferences.getInt(array2[4], 0);
        int b6 = sharedPreferences.getInt(array2[5], 0);
        int b7 = sharedPreferences.getInt(array2[6], 0);
        int b8 = sharedPreferences.getInt(array2[7], 0);
        int b9 = sharedPreferences.getInt(array2[8], 0);
        int b10 = sharedPreferences.getInt(array2[9], 0);

        int value1 = b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9 + b10;
        int value2 = v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9 + v10;

        int skill = 98;
        int totalValue = value1 + value2;

        skillPoint = skill - totalValue;

        skill_point_1 = 0;
        skill_point_2 = 0;
        skill_point_3 = 0;
        skill_point_4 = 0;
        skill_point_5 = 0;
        skill_point_6 = 0;
        skill_point_7 = 0;
        skill_point_8 = 0;
        skill_point_9 = 0;
        skill_point_10 = 0;

        editor.putInt(SKILL_POINT_KEY, skillPoint);
        editor.putInt(SKILL_TABLE_NAME + "_skill_1", 0);
        editor.putInt(SKILL_TABLE_NAME + "_skill_2", 0);
        editor.putInt(SKILL_TABLE_NAME + "_skill_3", 0);
        editor.putInt(SKILL_TABLE_NAME + "_skill_4", 0);
        editor.putInt(SKILL_TABLE_NAME + "_skill_5", 0);
        editor.putInt(SKILL_TABLE_NAME + "_skill_6", 0);
        editor.putInt(SKILL_TABLE_NAME + "_skill_7", 0);
        editor.putInt(SKILL_TABLE_NAME + "_skill_8", 0);
        editor.putInt(SKILL_TABLE_NAME + "_skill_9", 0);
        editor.putInt(SKILL_TABLE_NAME + "_skill_10", 0);
        editor.apply();

        skillImageView1.setImageResource(skillId1);
        skillImageView2.setImageResource(skillId2);
        skillImageView3.setImageResource(skillId3);
        skillImageView4.setImageResource(skillId4);
        skillImageView5.setImageResource(skillId5);
        skillImageView6.setImageResource(skillId6);
        skillImageView7.setImageResource(skillId7);
        skillImageView8.setImageResource(skillId8);
        skillImageView9.setImageResource(skillId9);
        skillImageView10.setImageResource(skillId10);
        skillLossedValue1.setText("0");
        skillLossedValue2.setText("0");
        skillLossedValue3.setText("0");
        skillLossedValue4.setText("0");
        skillLossedValue5.setText("0");
        skillLossedValue6.setText("0");
        skillLossedValue7.setText("0");
        skillLossedValue8.setText("0");
        skillLossedValue9.setText("0");
        skillLossedValue10.setText("0");
        skillPointView();
    }

    public void skillPointView() {
        skillValues.setText("스킬 포인트 : " + sharedPreferences.getInt(SKILL_POINT_KEY, 98));
        skillValuesQuest.setText("퀘스트 포인트 : " + sharedPreferences.getInt(SKILL_POINT_QUEST_COMPLETE_KEY, 98));
        skillLossedValue1.setText(String.valueOf(sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_1", 0)));
        skillLossedValue2.setText(String.valueOf(sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_2", 0)));
        skillLossedValue3.setText(String.valueOf(sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_3", 0)));
        skillLossedValue4.setText(String.valueOf(sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_4", 0)));
        skillLossedValue5.setText(String.valueOf(sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_5", 0)));
        skillLossedValue6.setText(String.valueOf(sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_6", 0)));
        skillLossedValue7.setText(String.valueOf(sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_7", 0)));
        skillLossedValue8.setText(String.valueOf(sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_8", 0)));
        skillLossedValue9.setText(String.valueOf(sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_9", 0)));
        skillLossedValue10.setText(String.valueOf(sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_10", 0)));
    }

    public void setSkillQuestCompletePoint(int skillQuestCompletePoint) {
        this.skillQuestCompletePoint = skillQuestCompletePoint;
    }

    public void setSkillUpdate(TextView skillUpdate) {
        this.skillUpdate = skillUpdate;
    }

    public void setSkillValues(TextView skillValues) {
        this.skillValues = skillValues;
    }

    public void setSkillValuesQuest(TextView skillValuesQuest) {
        this.skillValuesQuest = skillValuesQuest;
    }

    public void setMessagePremiseSkill(String messagePremiseSkill) {
        this.messagePremiseSkill = messagePremiseSkill;
    }

    public void setSKILL_TABLE_NAME(String SKILL_TABLE_NAME) {
        this.SKILL_TABLE_NAME = SKILL_TABLE_NAME;
    }

    public void setSKILL_POINT_KEY(String SKILL_POINT_KEY) {
        this.SKILL_POINT_KEY = SKILL_POINT_KEY;
    }

    public void setSKILL_POINT_QUEST_COMPLETE_KEY(String SKILL_POINT_QUEST_COMPLETE_KEY) {
        this.SKILL_POINT_QUEST_COMPLETE_KEY = SKILL_POINT_QUEST_COMPLETE_KEY;
    }

    public void setCHARACTER_SKILL_STRING(String CHARACTER_SKILL_STRING) {
        this.CHARACTER_SKILL_STRING = CHARACTER_SKILL_STRING;
    }

}
