package com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.druid;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.druid.elemental.Elemental1;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.druid.elemental.Elemental10;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.druid.elemental.Elemental2;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.druid.elemental.Elemental3;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.druid.elemental.Elemental4;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.druid.elemental.Elemental5;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.druid.elemental.Elemental6;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.druid.elemental.Elemental7;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.druid.elemental.Elemental8;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.druid.elemental.Elemental9;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.druid.elemental.SkillElemental;
import com.cjmkeke.d2rbooks.chardatabase.tools.ImageUpdate;
import com.cjmkeke.d2rbooks.chardatabase.tools.NewCharacterSkillUpdate;
import com.cjmkeke.d2rbooks.chardatabase.tools.ProhibitionButton;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentElementalBinding;

public class Elemental extends Fragment {

    private FragmentElementalBinding mBinding;
    private final String CHARACTER_NAME = "druid";
    private final String CLASS_NAME = "elementalSkill";
    private final String SKILL_TABLE_NAME = "elemental";
    private final String CHARACTER_SKILL_STRING = "elemental_druid";

    private final String[] SKILL_TABLE_ARRAY_1 = {"elemental_skill_1", "elemental_skill_2", "elemental_skill_3", "elemental_skill_4", "elemental_skill_5", "elemental_skill_6", "elemental_skill_7", "elemental_skill_8", "elemental_skill_9", "elemental_skill_10"};
    private final String[] SKILL_TABLE_ARRAY_2 = {"summoning_skill_1", "summoning_skill_2", "summoning_skill_3", "summoning_skill_4", "summoning_skill_5", "summoning_skill_6", "summoning_skill_7", "summoning_skill_8", "summoning_skill_9", "summoning_skill_10"};
    private final String[] SKILL_TABLE_ARRAY_3 = {"shape_skill_1", "shape_skill_2", "shape_skill_3", "shape_skill_4", "shape_skill_5", "shape_skill_6", "shape_skill_7", "shape_skill_8", "shape_skill_9", "shape_skill_10"};

    private final String SKILL_POINT_KEY = "skillPoint_druid";
    private final String SKILL_POINT_QUEST_COMPLETE_KEY = "skillQuestCompletePoint_druid";

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
        mBinding = FragmentElementalBinding.inflate(inflater, container, false);

        sharedPreferences = getContext().getSharedPreferences(CHARACTER_NAME + "_point", MODE_PRIVATE);
        editor = sharedPreferences.edit();


        if (!sharedPreferences.contains(SKILL_POINT_KEY)) {
            editor.putInt(SKILL_POINT_KEY, 98);
        } else {
            skillPoint = sharedPreferences.getInt(SKILL_POINT_KEY, 98);
        }

        if (!sharedPreferences.contains(SKILL_POINT_QUEST_COMPLETE_KEY)) {
            editor.putInt(SKILL_POINT_QUEST_COMPLETE_KEY, 110);
        } else {
            skillQuestCompletePoint = sharedPreferences.getInt(SKILL_POINT_QUEST_COMPLETE_KEY, 110);
        }

        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_1")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_1", 0);
        } else {
            skill_point_1 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_1", 0);
        }

        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_2")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_2", 0);
        } else {
            skill_point_2 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_2", 0);
        }

        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_3")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_3", 0);
        } else {
            skill_point_3 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_3", 0);
        }

        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_4")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_4", 0);
        } else {
            skill_point_4 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_4", 0);
        }

        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_5")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_5", 0);
        } else {
            skill_point_5 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_5", 0);
        }

        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_6")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_6", 0);
        } else {
            skill_point_6 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_6", 0);
        }

        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_7")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_7", 0);
        } else {
            skill_point_7 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_7", 0);
        }

        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_8")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_8", 0);
        } else {
            skill_point_8 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_8", 0);
        }
        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_9")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_9", 0);
        } else {
            skill_point_9 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_9", 0);
        }

        if (!sharedPreferences.contains(SKILL_TABLE_NAME + "_skill_10")) {
            editor.putInt(SKILL_TABLE_NAME + "_skill_10", 0);
        } else {
            skill_point_10 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_10", 0);
        }

        sharedPreferences.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, @Nullable String key) {
                if (SKILL_POINT_KEY.equals(key)) {
                    skillPoint = sharedPreferences.getInt(SKILL_POINT_KEY, 98);
                }
                if (SKILL_POINT_QUEST_COMPLETE_KEY.equals(key)) {
                    skillQuestCompletePoint = sharedPreferences.getInt(SKILL_POINT_QUEST_COMPLETE_KEY, 110);
                }
                if (SKILL_TABLE_ARRAY_1[0].equals(key)) {
                    skill_point_1 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_1", 0);
                }
                if (SKILL_TABLE_ARRAY_1[1].equals(key)) {
                    skill_point_2 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_2", 0);
                }
                if (SKILL_TABLE_ARRAY_1[2].equals(key)) {
                    skill_point_3 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_3", 0);
                }
                if (SKILL_TABLE_ARRAY_1[3].equals(key)) {
                    skill_point_4 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_4", 0);
                }
                if (SKILL_TABLE_ARRAY_1[4].equals(key)) {
                    skill_point_5 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_5", 0);
                }
                if (SKILL_TABLE_ARRAY_1[5].equals(key)) {
                    skill_point_6 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_6", 0);
                }
                if (SKILL_TABLE_ARRAY_1[6].equals(key)) {
                    skill_point_7 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_7", 0);
                }
                if (SKILL_TABLE_ARRAY_1[7].equals(key)) {
                    skill_point_8 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_8", 0);
                }
                if (SKILL_TABLE_ARRAY_1[8].equals(key)) {
                    skill_point_9 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_9", 0);
                }
                if (SKILL_TABLE_ARRAY_1[9].equals(key)) {
                    skill_point_10 = sharedPreferences.getInt(SKILL_TABLE_NAME + "_skill_10", 0);
                }

            }
        });

        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        editor.apply();

        NewCharacterSkillUpdate characterSkillUpdate = new NewCharacterSkillUpdate(getContext(), sharedPreferences, editor, onSharedPreferenceChangeListener, mBinding.tvView1Value, mBinding.tvView2Value, mBinding.tvView3Value, mBinding.tvView4Value, mBinding.tvView5Value, mBinding.tvView6Value, mBinding.tvView7Value, mBinding.tvView8Value, mBinding.tvView9Value, mBinding.tvView10Value);
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
                Spanned spanned = Html.fromHtml(SkillElemental.elementalSkill1, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.ivBtnSkillImage2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_2_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillElemental.elementalSkill2, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.ivBtnSkillImage3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_3_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillElemental.elementalSkill3, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.ivBtnSkillImage4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_4_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillElemental.elementalSkill4, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.ivBtnSkillImage5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_5_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillElemental.elementalSkill5, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.ivBtnSkillImage6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_6_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillElemental.elementalSkill6, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.ivBtnSkillImage7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_7_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillElemental.elementalSkill7, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.ivBtnSkillImage8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_8_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillElemental.elementalSkill8, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.ivBtnSkillImage9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_9_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillElemental.elementalSkill9, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });

        mBinding.ivBtnSkillImage10.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_" + CHARACTER_SKILL_STRING + "_10_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillElemental.elementalSkill10, Html.FROM_HTML_MODE_LEGACY);
                ImageUpdate.skillPreviewDialog(getContext(), spanned, id);
                return true;
            }
        });


        mBinding.tvBtn1ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("1", mBinding.ivBtnSkillImage1, mBinding.tvBtn1ValueMinus, mBinding.tvView1Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage1), Elemental1.class);
                return true;
            }
        });

        mBinding.tvBtn2ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("2", mBinding.ivBtnSkillImage2, mBinding.tvBtn2ValueMinus, mBinding.tvView2Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage2), Elemental2.class);
                return true;
            }
        });

        mBinding.tvBtn3ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("3", mBinding.ivBtnSkillImage3, mBinding.tvBtn3ValueMinus, mBinding.tvView3Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage3), Elemental3.class);
                return true;
            }
        });

        mBinding.tvBtn4ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("4", mBinding.ivBtnSkillImage4, mBinding.tvBtn4ValueMinus, mBinding.tvView4Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage4), Elemental4.class);
                return true;
            }
        });

        mBinding.tvBtn5ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("5", mBinding.ivBtnSkillImage5, mBinding.tvBtn5ValueMinus, mBinding.tvView5Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage5), Elemental5.class);
                return true;
            }
        });

        mBinding.tvBtn6ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("6", mBinding.ivBtnSkillImage6, mBinding.tvBtn6ValueMinus, mBinding.tvView6Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage6), Elemental6.class);
                return true;
            }
        });

        mBinding.tvBtn7ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("7", mBinding.ivBtnSkillImage7, mBinding.tvBtn7ValueMinus, mBinding.tvView7Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage7), Elemental7.class);
                return true;
            }
        });

        mBinding.tvBtn8ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("8", mBinding.ivBtnSkillImage8, mBinding.tvBtn8ValueMinus, mBinding.tvView8Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage8), Elemental8.class);
                return true;
            }
        });

        mBinding.tvBtn9ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("9", mBinding.ivBtnSkillImage9, mBinding.tvBtn9ValueMinus, mBinding.tvView9Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage9), Elemental9.class);
                return true;
            }
        });

        mBinding.tvBtn10ValueMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                characterSkillUpdate.hasSkillLongClickDown("10", mBinding.ivBtnSkillImage10, mBinding.tvBtn10ValueMinus, mBinding.tvView10Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage10), Elemental10.class);
                return true;
            }
        });


        mBinding.skillClear.setOnClickListener(v -> characterSkillUpdate.resetSkillPoint(SKILL_TABLE_ARRAY_2, SKILL_TABLE_ARRAY_3));
        mBinding.tvAllSkillReset.setOnClickListener(v -> characterSkillUpdate.resetAllSkillPoint(SKILL_TABLE_ARRAY_1, SKILL_TABLE_ARRAY_2, SKILL_TABLE_ARRAY_3));

        mBinding.ivBtnSkillImage1.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("1", mBinding.ivBtnSkillImage1, mBinding.tvView1Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage1), SkillElemental.class, CLASS_NAME, Elemental1.class));
        mBinding.ivBtnSkillImage2.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("2", mBinding.ivBtnSkillImage2, mBinding.tvView2Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage2), SkillElemental.class, CLASS_NAME, Elemental2.class));
        mBinding.ivBtnSkillImage3.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("3", mBinding.ivBtnSkillImage3, mBinding.tvView3Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage3), SkillElemental.class, CLASS_NAME, Elemental3.class));
        mBinding.ivBtnSkillImage4.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("4", mBinding.ivBtnSkillImage4, mBinding.tvView4Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage4), SkillElemental.class, CLASS_NAME, Elemental4.class));
        mBinding.ivBtnSkillImage5.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("5", mBinding.ivBtnSkillImage5, mBinding.tvView5Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage5), SkillElemental.class, CLASS_NAME, Elemental5.class));
        mBinding.ivBtnSkillImage6.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("6", mBinding.ivBtnSkillImage6, mBinding.tvView6Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage6), SkillElemental.class, CLASS_NAME, Elemental6.class));
        mBinding.ivBtnSkillImage7.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("7", mBinding.ivBtnSkillImage7, mBinding.tvView7Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage7), SkillElemental.class, CLASS_NAME, Elemental7.class));
        mBinding.ivBtnSkillImage8.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("8", mBinding.ivBtnSkillImage8, mBinding.tvView8Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage8), SkillElemental.class, CLASS_NAME, Elemental8.class));
        mBinding.ivBtnSkillImage9.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("9", mBinding.ivBtnSkillImage9, mBinding.tvView9Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage9), SkillElemental.class, CLASS_NAME, Elemental9.class));
        mBinding.ivBtnSkillImage10.setOnClickListener(v -> characterSkillUpdate.hasSkillUp("10", mBinding.ivBtnSkillImage10, mBinding.tvView10Value, checkSkillConditionsUp(mBinding.ivBtnSkillImage10), SkillElemental.class, CLASS_NAME, Elemental10.class));
        mBinding.tvBtn1ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("1", mBinding.ivBtnSkillImage1, mBinding.tvBtn1ValueMinus, mBinding.tvView1Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage1), Elemental1.class));
        mBinding.tvBtn2ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("2", mBinding.ivBtnSkillImage2, mBinding.tvBtn2ValueMinus, mBinding.tvView2Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage2), Elemental2.class));
        mBinding.tvBtn3ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("3", mBinding.ivBtnSkillImage3, mBinding.tvBtn3ValueMinus, mBinding.tvView3Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage3), Elemental3.class));
        mBinding.tvBtn4ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("4", mBinding.ivBtnSkillImage4, mBinding.tvBtn4ValueMinus, mBinding.tvView4Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage4), Elemental4.class));
        mBinding.tvBtn5ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("5", mBinding.ivBtnSkillImage5, mBinding.tvBtn5ValueMinus, mBinding.tvView5Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage5), Elemental5.class));
        mBinding.tvBtn6ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("6", mBinding.ivBtnSkillImage6, mBinding.tvBtn6ValueMinus, mBinding.tvView6Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage6), Elemental6.class));
        mBinding.tvBtn7ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("7", mBinding.ivBtnSkillImage7, mBinding.tvBtn7ValueMinus, mBinding.tvView7Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage7), Elemental7.class));
        mBinding.tvBtn8ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("8", mBinding.ivBtnSkillImage8, mBinding.tvBtn8ValueMinus, mBinding.tvView8Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage8), Elemental8.class));
        mBinding.tvBtn9ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("9", mBinding.ivBtnSkillImage9, mBinding.tvBtn9ValueMinus, mBinding.tvView9Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage9), Elemental9.class));
        mBinding.tvBtn10ValueMinus.setOnClickListener(v -> characterSkillUpdate.hasSkillDown("10", mBinding.ivBtnSkillImage10, mBinding.tvBtn10ValueMinus, mBinding.tvView10Value, checkSkillConditionsDown(mBinding.ivBtnSkillImage10), Elemental10.class));

        return mBinding.getRoot();
    }

    /**
     * prohibitionButton.upButton(imageView, R.id.iv_btn_skill_image_6, skill_point_3)
     * iv_btn_skill_image_6 버튼을 클릭하려면 skill_point_3 이 1 이상이어야함
     **/
    private boolean checkSkillConditionsUp(ImageView imageView) {
        return
                prohibitionButton.upButton(imageView, R.id.iv_btn_skill_image_2, skill_point_1) ||
                prohibitionButton.upButton(imageView, R.id.iv_btn_skill_image_4, skill_point_2) ||
                prohibitionButton.upButton(imageView, R.id.iv_btn_skill_image_7, skill_point_4) ||
                prohibitionButton.upButton(imageView, R.id.iv_btn_skill_image_9, skill_point_7) ||
                prohibitionButton.upButton(imageView, R.id.iv_btn_skill_image_5, skill_point_3) ||
                prohibitionButton.upButton(imageView, R.id.iv_btn_skill_image_6, skill_point_5) ||
                prohibitionButton.upButton(imageView, R.id.iv_btn_skill_image_8, skill_point_6) ||
                prohibitionButton.upButton(imageView, R.id.iv_btn_skill_image_10, skill_point_8)

                ;}

    /**
     * prohibitionButton.downButton(imageView, R.id.iv_btn_skill_image_1, skill_point_1, skill_point_4)
     * iv_btn_skill_image_1, skill_point_1 상위 스킬을 0 값으로 만들려면 하위 스킬 포인트(skill_point_4)가 0 이어야함
     **/
    private boolean checkSkillConditionsDown(ImageView imageView) {
        return
                false
//                prohibitionButton.downButton(imageView, R.id.iv_btn_skill_image_2, skill_point_2, skill_point_1) ||
//                        prohibitionButton.downButton(imageView, R.id.iv_btn_skill_image_5, skill_point_5, skill_point_10) ||
//                        prohibitionButton.downButton(imageView, R.id.iv_btn_skill_image_2, skill_point_2, skill_point_5) ||
//                        prohibitionButton.downButton(imageView, R.id.iv_btn_skill_image_6, skill_point_6, skill_point_8) ||
//                        prohibitionButton.downButton(imageView, R.id.iv_btn_skill_image_3, skill_point_3, skill_point_4) ||
//                        prohibitionButton.downButton(imageView, R.id.iv_btn_skill_image_3, skill_point_3, skill_point_6) ||
//                        prohibitionButton.downButton(imageView, R.id.iv_btn_skill_image_8, skill_point_8, skill_point_9) ||
//                        prohibitionButton.downButton(imageView, R.id.iv_btn_skill_image_8, skill_point_8, skill_point_10) ||
//                        prohibitionButton.downButton(imageView, R.id.iv_btn_skill_image_4, skill_point_4, skill_point_7)

                ;
    }

}