package com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.paladins;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.Defense1;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.Defense10;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.Defense2;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.Defense3;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.Defense4;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.Defense5;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.Defense6;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.Defense7;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.Defense8;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.Defense9;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.SkillDefense;
import com.cjmkeke.d2rbooks.chardatabase.tools.CharacterSkillUpdate;
import com.cjmkeke.d2rbooks.chardatabase.tools.CollectionValues;
import com.cjmkeke.d2rbooks.chardatabase.tools.ImageUpdate;
import com.cjmkeke.d2rbooks.chardatabase.tools.ProhibitionButton;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentDefenseBinding;

public class Defense extends Fragment {

    private static final String TAG = "Defense";
    private FragmentDefenseBinding mBinding;
    private final String CHARACTER_NAME = "paladins";
    private final String CLASS_NAME = "defenseSkill";
    private final String SKILL_TABLE_NAME = "defense";
    private final String CHARACTER_SKILL_STRING = "defense_paladins";
    private final String SKILL_POINT_KEY = "skillPoint_paladins";
    private final String SKILL_POINT_QUEST_COMPLETE_KEY = "skillQuestCompletePoint_paladins";

    private final String[] SKILL_TABLE_ARRAY_1 = {"defense_skill_1", "defense_skill_2", "defense_skill_3", "defense_skill_4", "defense_skill_5", "defense_skill_6", "defense_skill_7", "defense_skill_8", "defense_skill_9", "defense_skill_10"};
    private final String[] SKILL_TABLE_ARRAY_2 = {"offensive_skill_1", "offensive_skill_2", "offensive_skill_3", "offensive_skill_4", "offensive_skill_5", "offensive_skill_6", "offensive_skill_7", "offensive_skill_8", "offensive_skill_9", "offensive_skill_10"};
    private final String[] SKILL_TABLE_ARRAY_3 = {"combat_skill_1", "combat_skill_2", "combat_skill_3", "combat_skill_4", "combat_skill_5", "combat_skill_6", "combat_skill_7", "combat_skill_8", "combat_skill_9", "combat_skill_10"};

    private SharedPreferences fontSharedPreferences;
    private String messagePremiseSkill = "이 스킬을 사용하시려면 선행 스킬을 먼저 선택해주세요.";
    public int skillPoint;
    public int skillQuestCompletePoint;
    public int skill_point_1;
    public int skill_point_2;
    public int skill_point_3;
    public int skill_point_4;
    public int skill_point_5;
    public int skill_point_6;
    public int skill_point_7;
    public int skill_point_8;
    public int skill_point_9;
    public int skill_point_10;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener;
    private ProhibitionButton prohibitionButton = new ProhibitionButton();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentDefenseBinding.inflate(inflater, container, false);
        Log.w(TAG, "");

        sharedPreferences = getContext().getSharedPreferences(CHARACTER_NAME + "_point", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (!sharedPreferences.contains(SKILL_POINT_KEY)) {
            editor.putInt(SKILL_POINT_KEY, CollectionValues.DEFAULT_SKILL_VALUE);
        } else {
            skillPoint = sharedPreferences.getInt(SKILL_POINT_KEY, CollectionValues.DEFAULT_SKILL_VALUE);
        }

        if (!sharedPreferences.contains(SKILL_POINT_QUEST_COMPLETE_KEY)) {
            editor.putInt(SKILL_POINT_QUEST_COMPLETE_KEY, 110);
        } else {
            skillQuestCompletePoint = sharedPreferences.getInt(SKILL_POINT_QUEST_COMPLETE_KEY, 110);
        }

        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_1")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_1", CollectionValues.DEFAULT_SKILL_POINT);
        } else {
            skill_point_1 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_1", CollectionValues.DEFAULT_SKILL_POINT);
        }

        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_2")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_2", CollectionValues.DEFAULT_SKILL_POINT);
        } else {
            skill_point_2 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_2", CollectionValues.DEFAULT_SKILL_POINT);
        }

        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_3")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_3", CollectionValues.DEFAULT_SKILL_POINT);
        } else {
            skill_point_3 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_3", CollectionValues.DEFAULT_SKILL_POINT);
        }

        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_4")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_4", CollectionValues.DEFAULT_SKILL_POINT);
        } else {
            skill_point_4 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_4", CollectionValues.DEFAULT_SKILL_POINT);
        }

        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_5")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_5", CollectionValues.DEFAULT_SKILL_POINT);
        } else {
            skill_point_5 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_5", CollectionValues.DEFAULT_SKILL_POINT);
        }

        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_6")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_6", CollectionValues.DEFAULT_SKILL_POINT);
        } else {
            skill_point_6 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_6", CollectionValues.DEFAULT_SKILL_POINT);
        }

        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_7")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_7", CollectionValues.DEFAULT_SKILL_POINT);
        } else {
            skill_point_7 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_7", CollectionValues.DEFAULT_SKILL_POINT);
        }

        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_8")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_8", CollectionValues.DEFAULT_SKILL_POINT);
        } else {
            skill_point_8 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_8", CollectionValues.DEFAULT_SKILL_POINT);
        }
        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_9")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_9", CollectionValues.DEFAULT_SKILL_POINT);
        } else {
            skill_point_9 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_9", CollectionValues.DEFAULT_SKILL_POINT);
        }

        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_10")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_10", CollectionValues.DEFAULT_SKILL_POINT);
        } else {
            skill_point_10 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_10", CollectionValues.DEFAULT_SKILL_POINT);
        }

        sharedPreferences.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, @Nullable String key) {
                if (SKILL_POINT_KEY.equals(key)) {
                    skillPoint = sharedPreferences.getInt(SKILL_POINT_KEY, CollectionValues.DEFAULT_SKILL_VALUE);
                }
                if (SKILL_POINT_QUEST_COMPLETE_KEY.equals(key)) {
                    skillQuestCompletePoint = sharedPreferences.getInt(SKILL_POINT_QUEST_COMPLETE_KEY, 110);
                }
                if (SKILL_TABLE_ARRAY_1[0].equals(key)) {
                    skill_point_1 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_1", CollectionValues.DEFAULT_SKILL_POINT);
                }
                if (SKILL_TABLE_ARRAY_1[1].equals(key)) {
                    skill_point_2 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_2", CollectionValues.DEFAULT_SKILL_POINT);
                }
                if (SKILL_TABLE_ARRAY_1[2].equals(key)) {
                    skill_point_3 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_3", CollectionValues.DEFAULT_SKILL_POINT);
                }
                if (SKILL_TABLE_ARRAY_1[3].equals(key)) {
                    skill_point_4 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_4", CollectionValues.DEFAULT_SKILL_POINT);
                }
                if (SKILL_TABLE_ARRAY_1[4].equals(key)) {
                    skill_point_5 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_5", CollectionValues.DEFAULT_SKILL_POINT);
                }
                if (SKILL_TABLE_ARRAY_1[5].equals(key)) {
                    skill_point_6 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_6", CollectionValues.DEFAULT_SKILL_POINT);
                }
                if (SKILL_TABLE_ARRAY_1[6].equals(key)) {
                    skill_point_7 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_7", CollectionValues.DEFAULT_SKILL_POINT);
                }
                if (SKILL_TABLE_ARRAY_1[7].equals(key)) {
                    skill_point_8 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_8", CollectionValues.DEFAULT_SKILL_POINT);
                }
                if (SKILL_TABLE_ARRAY_1[8].equals(key)) {
                    skill_point_9 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_9", CollectionValues.DEFAULT_SKILL_POINT);
                }
                if (SKILL_TABLE_ARRAY_1[9].equals(key)) {
                    skill_point_10 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_10", CollectionValues.DEFAULT_SKILL_POINT);
                }

            }
        });

        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        editor.apply();

        CharacterSkillUpdate characterSkillUpdate = new CharacterSkillUpdate(getContext(), sharedPreferences, editor, onSharedPreferenceChangeListener, mBinding.tvView1Value, mBinding.tvView2Value, mBinding.tvView3Value, mBinding.tvView4Value, mBinding.tvView5Value, mBinding.tvView6Value, mBinding.tvView7Value, mBinding.tvView8Value, mBinding.tvView9Value, mBinding.tvView10Value);
        characterSkillUpdate.setSkillQuestCompletePoint(skillQuestCompletePoint);
        characterSkillUpdate.setSkillPoint(skillPoint, skill_point_1, skill_point_2, skill_point_3, skill_point_4, skill_point_5, skill_point_6, skill_point_7, skill_point_8, skill_point_9, skill_point_10);
        characterSkillUpdate.setSkillImageUpdate(mBinding.ivBtnSkillImage1, mBinding.ivBtnSkillImage2, mBinding.ivBtnSkillImage3, mBinding.ivBtnSkillImage4, mBinding.ivBtnSkillImage5, mBinding.ivBtnSkillImage6, mBinding.ivBtnSkillImage7, mBinding.ivBtnSkillImage8, mBinding.ivBtnSkillImage9, mBinding.ivBtnSkillImage10);
        characterSkillUpdate.setCHARACTER_SKILL_STRING(CHARACTER_SKILL_STRING);
        characterSkillUpdate.setSKILL_TABLE_NAME(SKILL_TABLE_NAME);
        characterSkillUpdate.setSKILL_POINT_KEY(SKILL_POINT_KEY);
        characterSkillUpdate.setSKILL_POINT_QUEST_COMPLETE_KEY(SKILL_POINT_QUEST_COMPLETE_KEY);
        characterSkillUpdate.setMessagePremiseSkill(messagePremiseSkill);
        characterSkillUpdate.setSkillValues(mBinding.tvPointValueView);
        characterSkillUpdate.setSkillValuesQuest(mBinding.tvQuestPointView);
        characterSkillUpdate.setSkillUpdate(mBinding.skillUpdate);
        characterSkillUpdate.skillPointView();

        ImageUpdate ImageUpdate = new ImageUpdate(getContext(), CHARACTER_SKILL_STRING, mBinding.ivBtnSkillImage1, mBinding.ivBtnSkillImage2, mBinding.ivBtnSkillImage3, mBinding.ivBtnSkillImage4, mBinding.ivBtnSkillImage5, mBinding.ivBtnSkillImage6, mBinding.ivBtnSkillImage7, mBinding.ivBtnSkillImage8, mBinding.ivBtnSkillImage9, mBinding.ivBtnSkillImage10);
        ImageUpdate.skillImageUpdate(sharedPreferences, SKILL_TABLE_NAME);

        mBinding.ivBtnSkillImage1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_1_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill1, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.ivBtnSkillImage2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_2_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill2, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.ivBtnSkillImage3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_3_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill3, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.ivBtnSkillImage4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_4_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill4, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.ivBtnSkillImage5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_5_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill5, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.ivBtnSkillImage6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_6_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill6, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.ivBtnSkillImage7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_7_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill7, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.ivBtnSkillImage8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_8_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill8, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.ivBtnSkillImage9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_9_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill9, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.ivBtnSkillImage10.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_10_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill10, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.skillClear.setOnClickListener(v -> characterSkillUpdate.resetSkillPoint(SKILL_TABLE_ARRAY_2, SKILL_TABLE_ARRAY_3 ));
        mBinding.tvAllSkillReset.setOnClickListener(v -> characterSkillUpdate.resetAllSkillPoint(SKILL_TABLE_ARRAY_1, SKILL_TABLE_ARRAY_2, SKILL_TABLE_ARRAY_3));
        mBinding.ivBtnSkillImage1.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("1", mBinding.ivBtnSkillImage1, mBinding.tvView1Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage1), SkillDefense.class, CLASS_NAME, Defense1.class));
        mBinding.ivBtnSkillImage2.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("2", mBinding.ivBtnSkillImage2, mBinding.tvView2Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage2), SkillDefense.class, CLASS_NAME, Defense2.class));
        mBinding.ivBtnSkillImage3.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("3", mBinding.ivBtnSkillImage3, mBinding.tvView3Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage3), SkillDefense.class, CLASS_NAME, Defense3.class));
        mBinding.ivBtnSkillImage4.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("4", mBinding.ivBtnSkillImage4, mBinding.tvView4Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage4), SkillDefense.class, CLASS_NAME, Defense4.class));
        mBinding.ivBtnSkillImage5.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("5", mBinding.ivBtnSkillImage5, mBinding.tvView5Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage5), SkillDefense.class, CLASS_NAME, Defense5.class));
        mBinding.ivBtnSkillImage6.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("6", mBinding.ivBtnSkillImage6, mBinding.tvView6Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage6), SkillDefense.class, CLASS_NAME, Defense6.class));
        mBinding.ivBtnSkillImage7.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("7", mBinding.ivBtnSkillImage7, mBinding.tvView7Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage7), SkillDefense.class, CLASS_NAME, Defense7.class));
        mBinding.ivBtnSkillImage8.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("8", mBinding.ivBtnSkillImage8, mBinding.tvView8Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage8), SkillDefense.class, CLASS_NAME, Defense8.class));
        mBinding.ivBtnSkillImage9.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("9", mBinding.ivBtnSkillImage9, mBinding.tvView9Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage9), SkillDefense.class, CLASS_NAME, Defense9.class));
        mBinding.ivBtnSkillImage10.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("10", mBinding.ivBtnSkillImage10, mBinding.tvView10Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage10), SkillDefense.class, CLASS_NAME, Defense10.class));

        mBinding.tvBtn1ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("1", mBinding.ivBtnSkillImage1, mBinding.tvBtn1ValueMinus, mBinding.tvView1Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage1), Defense1.class);
                return true;
            }
        });

        mBinding.tvBtn2ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("2", mBinding.ivBtnSkillImage2, mBinding.tvBtn2ValueMinus, mBinding.tvView2Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage2), Defense2.class);
                return true;
            }
        });

        mBinding.tvBtn3ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("3", mBinding.ivBtnSkillImage3, mBinding.tvBtn3ValueMinus, mBinding.tvView3Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage3), Defense3.class);
                return true;
            }
        });

        mBinding.tvBtn4ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("4", mBinding.ivBtnSkillImage4, mBinding.tvBtn4ValueMinus, mBinding.tvView4Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage4), Defense4.class);
                return true;
            }
        });

        mBinding.tvBtn5ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("5", mBinding.ivBtnSkillImage5, mBinding.tvBtn5ValueMinus, mBinding.tvView5Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage5), Defense5.class);
                return true;
            }
        });

        mBinding.tvBtn6ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("6", mBinding.ivBtnSkillImage6, mBinding.tvBtn6ValueMinus, mBinding.tvView6Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage6), Defense6.class);
                return true;
            }
        });

        mBinding.tvBtn7ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("7", mBinding.ivBtnSkillImage7, mBinding.tvBtn7ValueMinus, mBinding.tvView7Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage7), Defense7.class);
                return true;
            }
        });

        mBinding.tvBtn8ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("8", mBinding.ivBtnSkillImage8, mBinding.tvBtn8ValueMinus, mBinding.tvView8Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage8), Defense8.class);
                return true;
            }
        });

        mBinding.tvBtn9ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("9", mBinding.ivBtnSkillImage9, mBinding.tvBtn9ValueMinus, mBinding.tvView9Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage9), Defense9.class);
                return true;
            }
        });

        mBinding.tvBtn10ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("10", mBinding.ivBtnSkillImage10, mBinding.tvBtn10ValueMinus, mBinding.tvView10Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage10), Defense10.class);
                return true;
            }
        });


//        mBinding.tvView1Value.setOnLongClickListener(v -> {characterSkillUpdate.hasSkillLongClickUp("1", mBinding.ivBtnSkillImage1, mBinding.tvView1Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage1), SkillDefense.class, CLASS_NAME, Defense1.class); return true; });
//        mBinding.tvView2Value.setOnLongClickListener(v -> {characterSkillUpdate.hasSkillLongClickUp("2", mBinding.ivBtnSkillImage2, mBinding.tvView2Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage2), SkillDefense.class, CLASS_NAME, Defense2.class); return true; });
//        mBinding.tvView3Value.setOnLongClickListener(v -> {characterSkillUpdate.hasSkillLongClickUp("3", mBinding.ivBtnSkillImage3, mBinding.tvView3Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage3), SkillDefense.class, CLASS_NAME, Defense3.class); return true; });
//        mBinding.tvView4Value.setOnLongClickListener(v -> {characterSkillUpdate.hasSkillLongClickUp("4", mBinding.ivBtnSkillImage4, mBinding.tvView4Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage4), SkillDefense.class, CLASS_NAME, Defense4.class); return true; });
//        mBinding.tvView5Value.setOnLongClickListener(v -> {characterSkillUpdate.hasSkillLongClickUp("5", mBinding.ivBtnSkillImage5, mBinding.tvView5Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage5), SkillDefense.class, CLASS_NAME, Defense5.class); return true; });
//        mBinding.tvView6Value.setOnLongClickListener(v -> {characterSkillUpdate.hasSkillLongClickUp("6", mBinding.ivBtnSkillImage6, mBinding.tvView6Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage6), SkillDefense.class, CLASS_NAME, Defense6.class); return true; });
//        mBinding.tvView7Value.setOnLongClickListener(v -> {characterSkillUpdate.hasSkillLongClickUp("7", mBinding.ivBtnSkillImage7, mBinding.tvView7Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage7), SkillDefense.class, CLASS_NAME, Defense7.class); return true; });
//        mBinding.tvView8Value.setOnLongClickListener(v -> {characterSkillUpdate.hasSkillLongClickUp("8", mBinding.ivBtnSkillImage8, mBinding.tvView8Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage8), SkillDefense.class, CLASS_NAME, Defense8.class); return true; });
//        mBinding.tvView9Value.setOnLongClickListener(v -> {characterSkillUpdate.hasSkillLongClickUp("9", mBinding.ivBtnSkillImage9, mBinding.tvView9Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage9), SkillDefense.class, CLASS_NAME, Defense9.class); return true; });
//        mBinding.tvView10Value.setOnLongClickListener(v -> {characterSkillUpdate.hasSkillLongClickUp("10", mBinding.ivBtnSkillImage10, mBinding.tvView10Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage10), SkillDefense.class, CLASS_NAME, Defense10.class); return true; });

        mBinding.tvBtn1ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("1", mBinding.ivBtnSkillImage1, mBinding.tvBtn1ValueMinus, mBinding.tvView1Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage1), Defense1.class));
        mBinding.tvBtn2ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("2", mBinding.ivBtnSkillImage2, mBinding.tvBtn2ValueMinus, mBinding.tvView2Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage2), Defense2.class));
        mBinding.tvBtn3ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("3", mBinding.ivBtnSkillImage3, mBinding.tvBtn3ValueMinus, mBinding.tvView3Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage3), Defense3.class));
        mBinding.tvBtn4ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("4", mBinding.ivBtnSkillImage4, mBinding.tvBtn4ValueMinus, mBinding.tvView4Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage4), Defense4.class));
        mBinding.tvBtn5ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("5", mBinding.ivBtnSkillImage5, mBinding.tvBtn5ValueMinus, mBinding.tvView5Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage5), Defense5.class));
        mBinding.tvBtn6ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("6", mBinding.ivBtnSkillImage6, mBinding.tvBtn6ValueMinus, mBinding.tvView6Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage6), Defense6.class));
        mBinding.tvBtn7ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("7", mBinding.ivBtnSkillImage7, mBinding.tvBtn7ValueMinus, mBinding.tvView7Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage7), Defense7.class));
        mBinding.tvBtn8ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("8", mBinding.ivBtnSkillImage8, mBinding.tvBtn8ValueMinus, mBinding.tvView8Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage8), Defense8.class));
        mBinding.tvBtn9ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("9", mBinding.ivBtnSkillImage9, mBinding.tvBtn9ValueMinus, mBinding.tvView9Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage9), Defense9.class));
        mBinding.tvBtn10ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("10", mBinding.ivBtnSkillImage10, mBinding.tvBtn10ValueMinus, mBinding.tvView10Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage10), Defense10.class));

        return mBinding.getRoot();
    }

    private boolean checkSkillConditionsUp(ImageView imageView) {
        return prohibitionButton.upButton(imageView, R.id.iv_btn_skill_image_7, skill_point_1) ||
                prohibitionButton.upButton(imageView, R.id.iv_btn_skill_image_5, skill_point_1) ||
                prohibitionButton.upButton(imageView, R.id.iv_btn_skill_image_8, skill_point_5) ||
                prohibitionButton.upButton(imageView, R.id.iv_btn_skill_image_7, skill_point_3, skill_point_5) ||
                prohibitionButton.upButton(imageView, R.id.iv_btn_skill_image_9, skill_point_7)

                ;}

    private boolean checkSkillConditionsDown(ImageView imageView) {
        return prohibitionButton.downButton(imageView, R.id.iv_btn_skill_image_1, skill_point_1, skill_point_5) ||
                prohibitionButton.downButton(imageView, R.id.iv_btn_skill_image_5, skill_point_5, skill_point_8) ||
                prohibitionButton.downButton(imageView, R.id.iv_btn_skill_image_3, skill_point_3, skill_point_7) ||
                prohibitionButton.downButton(imageView, R.id.iv_btn_skill_image_5, skill_point_5, skill_point_7) ||
                prohibitionButton.downButton(imageView, R.id.iv_btn_skill_image_7, skill_point_7, skill_point_9)

                ;}

    private void ssss(Context context){

    }

}