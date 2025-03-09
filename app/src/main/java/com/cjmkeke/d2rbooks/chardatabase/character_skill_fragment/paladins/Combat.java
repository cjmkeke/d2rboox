package com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.paladins;

import static android.content.Context.MODE_PRIVATE;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.combat.Combat1;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.combat.Combat10;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.combat.Combat2;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.combat.Combat3;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.combat.Combat4;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.combat.Combat5;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.combat.Combat6;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.combat.Combat7;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.combat.Combat8;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.combat.Combat9;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.combat.SkillCombat;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentCombatBinding;


public class Combat extends Fragment {

    private static final String TAG = "Battle";
    private FragmentCombatBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    private final String SKILL_POINT_KEY = "skillPoint_Paladins";
    private final String SKILL_POINT_QUEST_COMPLETE_KEY = "skillQuestCompletePoint_Paladins";
    public int skillPoint;
    private int skillQuestCompletePoint;
    public int combatSkill_1;
    public int combatSkill_2;
    public int combatSkill_3;
    public int combatSkill_4;
    public int combatSkill_5;
    public int combatSkill_6;
    public int combatSkill_7;
    public int combatSkill_8;
    public int combatSkill_9;
    public int combatSkill_10;
    private String messagePremiseSkill = null;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener;
    private SharedPreferences skillSharedPreferences;
    private SharedPreferences.Editor skillEditor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentCombatBinding.inflate(inflater, container, false);

        sharedPreferences = getContext().getSharedPreferences("paladins_point", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        SkillPaladinsSharedPreferences.setPaladinSkillInitialValue(getContext());
        skillSharedPreferences = getContext().getSharedPreferences(SkillPaladinsSharedPreferences.SKILL_TO_DEFENSE, MODE_PRIVATE);
        skillEditor = skillSharedPreferences.edit();

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

        if (!sharedPreferences.contains("combat_skill_1")) {
            editor.putInt("combat_skill_1", 0);
        } else {
            combatSkill_1 = sharedPreferences.getInt("combat_skill_1", 0);
        }

        if (!sharedPreferences.contains("combat_skill_2")) {
            editor.putInt("combat_skill_2", 0);
        } else {
            combatSkill_2 = sharedPreferences.getInt("combat_skill_2", 0);
        }

        if (!sharedPreferences.contains("combat_skill_3")) {
            editor.putInt("combat_skill_3", 0);
        } else {
            combatSkill_3 = sharedPreferences.getInt("combat_skill_3", 0);
        }

        if (!sharedPreferences.contains("combat_skill_4")) {
            editor.putInt("combat_skill_4", 0);
        } else {
            combatSkill_4 = sharedPreferences.getInt("combat_skill_4", 0);
        }

        if (!sharedPreferences.contains("combat_skill_5")) {
            editor.putInt("combat_skill_5", 0);
        } else {
            combatSkill_5 = sharedPreferences.getInt("combat_skill_5", 0);
        }

        if (!sharedPreferences.contains("combat_skill_6")) {
            editor.putInt("combat_skill_6", 0);
        } else {
            combatSkill_6 = sharedPreferences.getInt("combat_skill_6", 0);
        }

        if (!sharedPreferences.contains("combat_skill_7")) {
            editor.putInt("combat_skill_7", 0);
        } else {
            combatSkill_7 = sharedPreferences.getInt("combat_skill_7", 0);
        }

        if (!sharedPreferences.contains("combat_skill_8")) {
            editor.putInt("combat_skill_8", 0);
        } else {
            combatSkill_8 = sharedPreferences.getInt("combat_skill_8", 0);
        }
        if (!sharedPreferences.contains("combat_skill_9")) {
            editor.putInt("combat_skill_9", 0);
        } else {
            combatSkill_9 = sharedPreferences.getInt("combat_skill_9", 0);
        }

        if (!sharedPreferences.contains("combat_skill_10")) {
            editor.putInt("combat_skill_10", 0);
        } else {
            combatSkill_10 = sharedPreferences.getInt("combat_skill_10", 0);
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
                if ("combat_skill_1".equals(key)) {
                    combatSkill_1 = sharedPreferences.getInt("combat_skill_1", 0);
                }
                if ("combat_skill_2".equals(key)) {
                    combatSkill_2 = sharedPreferences.getInt("combat_skill_2", 0);
                }
                if ("combat_skill_3".equals(key)) {
                    combatSkill_3 = sharedPreferences.getInt("combat_skill_3", 0);
                }
                if ("combat_skill_4".equals(key)) {
                    combatSkill_4 = sharedPreferences.getInt("combat_skill_4", 0);
                }
                if ("combat_skill_5".equals(key)) {
                    combatSkill_5 = sharedPreferences.getInt("combat_skill_5", 0);
                }
                if ("combat_skill_6".equals(key)) {
                    combatSkill_6 = sharedPreferences.getInt("combat_skill_6", 0);
                }
                if ("combat_skill_7".equals(key)) {
                    combatSkill_7 = sharedPreferences.getInt("combat_skill_7", 0);
                }
                if ("combat_skill_8".equals(key)) {
                    combatSkill_8 = sharedPreferences.getInt("combat_skill_8", 0);
                }
                if ("combat_skill_9".equals(key)) {
                    combatSkill_9 = sharedPreferences.getInt("combat_skill_9", 0);
                }
                if ("combat_skill_10".equals(key)) {
                    combatSkill_10 = sharedPreferences.getInt("combat_skill_10", 0);
                }

            }
        });

        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);

        editor.apply();
        combatValue();
        skillImageUpdate();

        mBinding.skillClear.setOnClickListener(v -> resetSkillPoint());
        mBinding.tvAllSkillReset.setOnClickListener(v -> resetAllSkillPoint());

        mBinding.skillCombatPaladins1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_combat_paladins_1_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillCombat.combatSkill1, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillCombatPaladins2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_combat_paladins_2_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillCombat.combatSkill2, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillCombatPaladins3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_combat_paladins_3_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillCombat.combatSkill3, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillCombatPaladins4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_combat_paladins_4_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillCombat.combatSkill4, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillCombatPaladins5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_combat_paladins_5_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillCombat.combatSkill5, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillCombatPaladins6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_combat_paladins_6_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillCombat.combatSkill6, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillCombatPaladins7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_combat_paladins_7_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillCombat.combatSkill7, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillCombatPaladins8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_combat_paladins_8_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillCombat.combatSkill8, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillCombatPaladins9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_combat_paladins_9_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillCombat.combatSkill9, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillCombatPaladins10.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_combat_paladins_10_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillCombat.combatSkill10, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillCombatPaladins1.setOnClickListener(v -> hasSkillUp("1", mBinding.skillCombatPaladins1, mBinding.skillCombatPaladins1Value));
        mBinding.skillCombatPaladins2.setOnClickListener(v -> hasSkillUp("2", mBinding.skillCombatPaladins2, mBinding.skillCombatPaladins2Value));
        mBinding.skillCombatPaladins3.setOnClickListener(v -> hasSkillUp("3", mBinding.skillCombatPaladins3, mBinding.skillCombatPaladins3Value));
        mBinding.skillCombatPaladins4.setOnClickListener(v -> hasSkillUp("4", mBinding.skillCombatPaladins4, mBinding.skillCombatPaladins4Value));
        mBinding.skillCombatPaladins5.setOnClickListener(v -> hasSkillUp("5", mBinding.skillCombatPaladins5, mBinding.skillCombatPaladins5Value));
        mBinding.skillCombatPaladins6.setOnClickListener(v -> hasSkillUp("6", mBinding.skillCombatPaladins6, mBinding.skillCombatPaladins6Value));
        mBinding.skillCombatPaladins7.setOnClickListener(v -> hasSkillUp("7", mBinding.skillCombatPaladins7, mBinding.skillCombatPaladins7Value));
        mBinding.skillCombatPaladins8.setOnClickListener(v -> hasSkillUp("8", mBinding.skillCombatPaladins8, mBinding.skillCombatPaladins8Value));
        mBinding.skillCombatPaladins9.setOnClickListener(v -> hasSkillUp("9", mBinding.skillCombatPaladins9, mBinding.skillCombatPaladins9Value));
        mBinding.skillCombatPaladins10.setOnClickListener(v -> hasSkillUp("10", mBinding.skillCombatPaladins10, mBinding.skillCombatPaladins10Value));

        mBinding.skillCombatPaladins1ValueMinus.setOnClickListener(v -> hasSkillDown("1", mBinding.skillCombatPaladins1, mBinding.skillCombatPaladins1ValueMinus, mBinding.skillCombatPaladins1Value));
        mBinding.skillCombatPaladins2ValueMinus.setOnClickListener(v -> hasSkillDown("2", mBinding.skillCombatPaladins2, mBinding.skillCombatPaladins2ValueMinus, mBinding.skillCombatPaladins2Value));
        mBinding.skillCombatPaladins3ValueMinus.setOnClickListener(v -> hasSkillDown("3", mBinding.skillCombatPaladins3, mBinding.skillCombatPaladins3ValueMinus, mBinding.skillCombatPaladins3Value));
        mBinding.skillCombatPaladins4ValueMinus.setOnClickListener(v -> hasSkillDown("4", mBinding.skillCombatPaladins4, mBinding.skillCombatPaladins4ValueMinus, mBinding.skillCombatPaladins4Value));
        mBinding.skillCombatPaladins5ValueMinus.setOnClickListener(v -> hasSkillDown("5", mBinding.skillCombatPaladins5, mBinding.skillCombatPaladins5ValueMinus, mBinding.skillCombatPaladins5Value));
        mBinding.skillCombatPaladins6ValueMinus.setOnClickListener(v -> hasSkillDown("6", mBinding.skillCombatPaladins6, mBinding.skillCombatPaladins6ValueMinus, mBinding.skillCombatPaladins6Value));
        mBinding.skillCombatPaladins7ValueMinus.setOnClickListener(v -> hasSkillDown("7", mBinding.skillCombatPaladins7, mBinding.skillCombatPaladins7ValueMinus, mBinding.skillCombatPaladins7Value));
        mBinding.skillCombatPaladins8ValueMinus.setOnClickListener(v -> hasSkillDown("8", mBinding.skillCombatPaladins8, mBinding.skillCombatPaladins8ValueMinus, mBinding.skillCombatPaladins8Value));
        mBinding.skillCombatPaladins9ValueMinus.setOnClickListener(v -> hasSkillDown("9", mBinding.skillCombatPaladins9, mBinding.skillCombatPaladins9ValueMinus, mBinding.skillCombatPaladins9Value));
        mBinding.skillCombatPaladins10ValueMinus.setOnClickListener(v -> hasSkillDown("10", mBinding.skillCombatPaladins10, mBinding.skillCombatPaladins10ValueMinus, mBinding.skillCombatPaladins10Value));

        return mBinding.getRoot();
    }


    private void hasSkillUp(String imagesSkillNumber, ImageView imagesImageView, TextView valueTextView) {

        Spanned spanned;
        int resId = getResources().getIdentifier("skill_combat_paladins_" + imagesSkillNumber + "_2", "drawable", getContext().getPackageName());
        int clickId = imagesImageView.getId();

        if (skillPoint == 0) {
            System.out.println("스킬 포인트를 다 썼습니다.");
            return;
        }

        if (isPremiseSkillUpButton(imagesImageView)) {
            if (messagePremiseSkill != null) {
                mBinding.skillUpdate.setText(messagePremiseSkill);
                messagePremiseSkill = null;
            }
            return;
        }

        if (combatSkill_1 == 20) {
            if (clickId == R.id.skill_combat_paladins_1) {
                spanned = Html.fromHtml(SkillCombat.combatSkill1_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
                return;
            }
        }

        if (combatSkill_1 < 20) {
            if (clickId == R.id.skill_combat_paladins_1) {
                skillPoint--;
                combatSkill_1++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(combatSkill_1));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_1", combatSkill_1);
                editor.apply();
                Combat1.skillUpdate(combatSkill_1, mBinding.skillUpdate, getContext());
            }
        }

        if (combatSkill_2 == 20) {
            if (clickId == R.id.skill_combat_paladins_2) {
                spanned = Html.fromHtml(SkillCombat.combatSkill2_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
                return;
            }
        }

        if (combatSkill_2 < 20) {
            if (clickId == R.id.skill_combat_paladins_2) {
                skillPoint--;
                combatSkill_2++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(combatSkill_2));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_2", combatSkill_2);
                editor.apply();
                Combat2.skillUpdate(combatSkill_2, mBinding.skillUpdate, getContext());
            }
        }

        if (combatSkill_3 == 20) {
            if (clickId == R.id.skill_combat_paladins_3) {
                spanned = Html.fromHtml(SkillCombat.combatSkill3_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (combatSkill_3 < 20) {
            if (clickId == R.id.skill_combat_paladins_3) {
                skillPoint--;
                combatSkill_3++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(combatSkill_3));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_3", combatSkill_3);
                editor.apply();
                Combat3.skillUpdate(combatSkill_3, mBinding.skillUpdate, getContext());
            }
        }

        if (combatSkill_4 == 20) {
            if (clickId == R.id.skill_combat_paladins_4) {
                spanned = Html.fromHtml(SkillCombat.combatSkill4_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (combatSkill_4 < 20) {
            if (clickId == R.id.skill_combat_paladins_4) {
                skillPoint--;
                combatSkill_4++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(combatSkill_4));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_4", combatSkill_4);
                editor.apply();
                Combat4.skillUpdate(combatSkill_4, mBinding.skillUpdate, getContext());
            }
        }

        if (combatSkill_5 == 20) {
            if (clickId == R.id.skill_combat_paladins_5) {
                spanned = Html.fromHtml(SkillCombat.combatSkill5_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (combatSkill_5 < 20) {
            if (clickId == R.id.skill_combat_paladins_5) {
                skillPoint--;
                combatSkill_5++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(combatSkill_5));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_5", combatSkill_5);
                editor.apply();
                Combat5.skillUpdate(combatSkill_5, mBinding.skillUpdate, getContext());
            }
        }

        if (combatSkill_6 == 20) {
            if (clickId == R.id.skill_combat_paladins_6) {
                spanned = Html.fromHtml(SkillCombat.combatSkill6_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (combatSkill_6 < 20) {
            if (clickId == R.id.skill_combat_paladins_6) {
                skillPoint--;
                combatSkill_6++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(combatSkill_6));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_6", combatSkill_6);
                editor.apply();
                Combat6.skillUpdate(combatSkill_6, mBinding.skillUpdate, getContext());
            }
        }

        if (combatSkill_7 == 20) {
            if (clickId == R.id.skill_combat_paladins_7) {
                spanned = Html.fromHtml(SkillCombat.combatSkill7_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (combatSkill_7 < 20) {
            if (clickId == R.id.skill_combat_paladins_7) {
                skillPoint--;
                combatSkill_7++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(combatSkill_7));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_7", combatSkill_7);
                editor.apply();
                if (messagePremiseSkill == null) {
                    mBinding.skillUpdate.setText(SkillCombat.combatSkill7);
                }
                Combat7.skillUpdate(combatSkill_7, mBinding.skillUpdate, getContext());
            }
        }


        if (combatSkill_8 == 20) {
            if (clickId == R.id.skill_combat_paladins_8) {
                spanned = Html.fromHtml(SkillCombat.combatSkill8_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (combatSkill_8 < 20) {
            if (clickId == R.id.skill_combat_paladins_8) {
                skillPoint--;
                combatSkill_8++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(combatSkill_8));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_8", combatSkill_8);
                editor.apply();
                Combat8.skillUpdate(combatSkill_8, mBinding.skillUpdate, getContext());
            }
        }

        if (combatSkill_9 == 20) {
            if (clickId == R.id.skill_combat_paladins_9) {
                spanned = Html.fromHtml(SkillCombat.combatSkill9_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (combatSkill_9 < 20) {
            if (clickId == R.id.skill_combat_paladins_9) {
                skillPoint--;
                combatSkill_9++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(combatSkill_9));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_9", combatSkill_9);
                editor.apply();
                Combat9.skillUpdate(combatSkill_9, mBinding.skillUpdate, getContext());
            }
        }


        if (combatSkill_10 == 20) {
            if (clickId == R.id.skill_combat_paladins_10) {
                spanned = Html.fromHtml(SkillCombat.combatSkill10_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (combatSkill_10 < 20) {
            if (clickId == R.id.skill_combat_paladins_10) {
                skillPoint--;
                combatSkill_10++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(combatSkill_10));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_10", combatSkill_10);
                editor.apply();
                Combat10.skillUpdate(combatSkill_10, mBinding.skillUpdate, getContext());
            }
        }
        combatValue();
    }

    private void hasSkillDown(String imagesSkillNumber, ImageView imagesImageView, TextView minusButton, TextView valueTextView) {
        String skillMessage = "스킬 업데이트를 해주세요";
        int resId = getResources().getIdentifier("skill_combat_paladins_" + imagesSkillNumber + "_1", "drawable", getContext().getPackageName());
        int clickId = minusButton.getId();

        if (isPremiseSkillDownButton(imagesImageView)) {
            return;
        }

        if (combatSkill_1 != 0) {
            if (clickId == R.id.skill_combat_paladins_1_value_minus) {
                skillPoint++;
                combatSkill_1--;
                valueTextView.setText(String.valueOf(combatSkill_1));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_1", combatSkill_1);
                editor.apply();
                if (combatSkill_1 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Combat1.skillUpdate(combatSkill_1, mBinding.skillUpdate, getContext());
            }
        }
        if (combatSkill_2 != 0) {
            if (clickId == R.id.skill_combat_paladins_2_value_minus) {
                skillPoint++;
                combatSkill_2--;
                valueTextView.setText(String.valueOf(combatSkill_2));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_2", combatSkill_2);
                editor.apply();
                if (combatSkill_2 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Combat2.skillUpdate(combatSkill_2, mBinding.skillUpdate, getContext());
            }
        }
        if (combatSkill_3 != 0) {
            if (clickId == R.id.skill_combat_paladins_3_value_minus) {
                skillPoint++;
                combatSkill_3--;
                valueTextView.setText(String.valueOf(combatSkill_3));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_3", combatSkill_3);
                editor.apply();
                if (combatSkill_3 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Combat3.skillUpdate(combatSkill_3, mBinding.skillUpdate, getContext());
            }
        }
        if (combatSkill_4 != 0) {
            if (clickId == R.id.skill_combat_paladins_4_value_minus) {
                skillPoint++;
                combatSkill_4--;
                valueTextView.setText(String.valueOf(combatSkill_4));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_4", combatSkill_4);
                editor.apply();
                if (combatSkill_4 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Combat4.skillUpdate(combatSkill_4, mBinding.skillUpdate, getContext());
            }
        }
        if (combatSkill_5 != 0) {
            if (clickId == R.id.skill_combat_paladins_5_value_minus) {
                skillPoint++;
                combatSkill_5--;
                valueTextView.setText(String.valueOf(combatSkill_5));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_5", combatSkill_5);
                editor.apply();
                if (combatSkill_5 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Combat5.skillUpdate(combatSkill_5, mBinding.skillUpdate, getContext());
            }
        }
        if (combatSkill_6 != 0) {
            if (clickId == R.id.skill_combat_paladins_6_value_minus) {
                skillPoint++;
                combatSkill_6--;
                valueTextView.setText(String.valueOf(combatSkill_6));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_6", combatSkill_6);
                editor.apply();
                if (combatSkill_6 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Combat6.skillUpdate(combatSkill_6, mBinding.skillUpdate, getContext());
            }
        }
        if (combatSkill_7 != 0) {
            if (clickId == R.id.skill_combat_paladins_7_value_minus) {
                skillPoint++;
                combatSkill_7--;
                valueTextView.setText(String.valueOf(combatSkill_7));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_7", combatSkill_7);
                editor.apply();
                if (combatSkill_7 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Combat7.skillUpdate(combatSkill_7, mBinding.skillUpdate, getContext());
            }
        }
        if (combatSkill_8 != 0) {
            if (clickId == R.id.skill_combat_paladins_8_value_minus) {
                skillPoint++;
                combatSkill_8--;
                valueTextView.setText(String.valueOf(combatSkill_8));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_8", combatSkill_8);
                editor.apply();
                if (combatSkill_8 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Combat8.skillUpdate(combatSkill_8, mBinding.skillUpdate, getContext());
            }
        }
        if (combatSkill_9 != 0) {
            if (clickId == R.id.skill_combat_paladins_9_value_minus) {
                skillPoint++;
                combatSkill_9--;
                valueTextView.setText(String.valueOf(combatSkill_9));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_9", combatSkill_9);
                editor.apply();
                if (combatSkill_9 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Combat9.skillUpdate(combatSkill_9, mBinding.skillUpdate, getContext());
            }
        }
        if (combatSkill_10 != 0) {
            if (clickId == R.id.skill_combat_paladins_10_value_minus) {
                skillPoint++;
                combatSkill_10--;
                valueTextView.setText(String.valueOf(combatSkill_10));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("combat_skill_10", combatSkill_10);
                editor.apply();
                if (combatSkill_10 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Combat10.skillUpdate(combatSkill_10, mBinding.skillUpdate, getContext());
            }
        }
        combatValue();
    }

    // 모든 스킬의 스킬 초기화
    private void resetAllSkillPoint() {
        skillPoint = 98;
        combatSkill_1 = 0;
        combatSkill_2 = 0;
        combatSkill_3 = 0;
        combatSkill_4 = 0;
        combatSkill_5 = 0;
        combatSkill_6 = 0;
        combatSkill_7 = 0;
        combatSkill_8 = 0;
        combatSkill_9 = 0;
        combatSkill_10 = 0;
        editor.putInt(SKILL_POINT_KEY, skillPoint);
        editor.putInt("defense_skill_1", 0);
        editor.putInt("defense_skill_2", 0);
        editor.putInt("defense_skill_3", 0);
        editor.putInt("defense_skill_4", 0);
        editor.putInt("defense_skill_5", 0);
        editor.putInt("defense_skill_6", 0);
        editor.putInt("defense_skill_7", 0);
        editor.putInt("defense_skill_8", 0);
        editor.putInt("defense_skill_9", 0);
        editor.putInt("defense_skill_10", 0);
        editor.putInt("combat_skill_1", 0);
        editor.putInt("combat_skill_2", 0);
        editor.putInt("combat_skill_3", 0);
        editor.putInt("combat_skill_4", 0);
        editor.putInt("combat_skill_5", 0);
        editor.putInt("combat_skill_6", 0);
        editor.putInt("combat_skill_7", 0);
        editor.putInt("combat_skill_8", 0);
        editor.putInt("combat_skill_9", 0);
        editor.putInt("combat_skill_10", 0);
        editor.putInt("offensive_skill_1", 0);
        editor.putInt("offensive_skill_2", 0);
        editor.putInt("offensive_skill_3", 0);
        editor.putInt("offensive_skill_4", 0);
        editor.putInt("offensive_skill_5", 0);
        editor.putInt("offensive_skill_6", 0);
        editor.putInt("offensive_skill_7", 0);
        editor.putInt("offensive_skill_8", 0);
        editor.putInt("offensive_skill_9", 0);
        editor.putInt("offensive_skill_10", 0);
        editor.commit();
        skillEditor.clear();

        mBinding.skillCombatPaladins1.setImageResource(R.drawable.skill_combat_paladins_1_1);
        mBinding.skillCombatPaladins2.setImageResource(R.drawable.skill_combat_paladins_2_1);
        mBinding.skillCombatPaladins3.setImageResource(R.drawable.skill_combat_paladins_3_1);
        mBinding.skillCombatPaladins4.setImageResource(R.drawable.skill_combat_paladins_4_1);
        mBinding.skillCombatPaladins5.setImageResource(R.drawable.skill_combat_paladins_5_1);
        mBinding.skillCombatPaladins6.setImageResource(R.drawable.skill_combat_paladins_6_1);
        mBinding.skillCombatPaladins7.setImageResource(R.drawable.skill_combat_paladins_7_1);
        mBinding.skillCombatPaladins8.setImageResource(R.drawable.skill_combat_paladins_8_1);
        mBinding.skillCombatPaladins9.setImageResource(R.drawable.skill_combat_paladins_9_1);
        mBinding.skillCombatPaladins10.setImageResource(R.drawable.skill_combat_paladins_10_1);
        mBinding.skillCombatPaladins1Value.setText("0");
        mBinding.skillCombatPaladins2Value.setText("0");
        mBinding.skillCombatPaladins3Value.setText("0");
        mBinding.skillCombatPaladins4Value.setText("0");
        mBinding.skillCombatPaladins5Value.setText("0");
        mBinding.skillCombatPaladins6Value.setText("0");
        mBinding.skillCombatPaladins7Value.setText("0");
        mBinding.skillCombatPaladins8Value.setText("0");
        mBinding.skillCombatPaladins9Value.setText("0");
        mBinding.skillCombatPaladins10Value.setText("0");
        combatValue();
    }

    private void resetSkillPoint() {
        int b1 = sharedPreferences.getInt("defense_skill_1", 0);
        int b2 = sharedPreferences.getInt("defense_skill_2", 0);
        int b3 = sharedPreferences.getInt("defense_skill_3", 0);
        int b4 = sharedPreferences.getInt("defense_skill_4", 0);
        int b5 = sharedPreferences.getInt("defense_skill_5", 0);
        int b6 = sharedPreferences.getInt("defense_skill_6", 0);
        int b7 = sharedPreferences.getInt("defense_skill_7", 0);
        int b8 = sharedPreferences.getInt("defense_skill_8", 0);
        int b9 = sharedPreferences.getInt("defense_skill_9", 0);
        int b10 = sharedPreferences.getInt("defense_skill_10", 0);

        int v1 = sharedPreferences.getInt("offensive_skill_1", 0);
        int v2 = sharedPreferences.getInt("offensive_skill_2", 0);
        int v3 = sharedPreferences.getInt("offensive_skill_3", 0);
        int v4 = sharedPreferences.getInt("offensive_skill_4", 0);
        int v5 = sharedPreferences.getInt("offensive_skill_5", 0);
        int v6 = sharedPreferences.getInt("offensive_skill_6", 0);
        int v7 = sharedPreferences.getInt("offensive_skill_7", 0);
        int v8 = sharedPreferences.getInt("offensive_skill_8", 0);
        int v9 = sharedPreferences.getInt("offensive_skill_9", 0);
        int v10 = sharedPreferences.getInt("offensive_skill_10", 0);

        int value1 = b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9 + b10;
        int value2 = v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9 + v10;

        int skill = 98;
        int totalValue = value1 + value2;

        skillPoint = skill - totalValue;

        combatSkill_1 = 0;
        combatSkill_2 = 0;
        combatSkill_3 = 0;
        combatSkill_4 = 0;
        combatSkill_5 = 0;
        combatSkill_6 = 0;
        combatSkill_7 = 0;
        combatSkill_8 = 0;
        combatSkill_9 = 0;
        combatSkill_10 = 0;

        editor.putInt(SKILL_POINT_KEY, skillPoint);
        editor.putInt("combat_skill_1", 0);
        editor.putInt("combat_skill_2", 0);
        editor.putInt("combat_skill_3", 0);
        editor.putInt("combat_skill_4", 0);
        editor.putInt("combat_skill_5", 0);
        editor.putInt("combat_skill_6", 0);
        editor.putInt("combat_skill_7", 0);
        editor.putInt("combat_skill_8", 0);
        editor.putInt("combat_skill_9", 0);
        editor.putInt("combat_skill_10", 0);
        editor.apply();
        skillEditor.clear();

        mBinding.skillCombatPaladins1.setImageResource(R.drawable.skill_combat_paladins_1_1);
        mBinding.skillCombatPaladins2.setImageResource(R.drawable.skill_combat_paladins_2_1);
        mBinding.skillCombatPaladins3.setImageResource(R.drawable.skill_combat_paladins_3_1);
        mBinding.skillCombatPaladins4.setImageResource(R.drawable.skill_combat_paladins_4_1);
        mBinding.skillCombatPaladins5.setImageResource(R.drawable.skill_combat_paladins_5_1);
        mBinding.skillCombatPaladins6.setImageResource(R.drawable.skill_combat_paladins_6_1);
        mBinding.skillCombatPaladins7.setImageResource(R.drawable.skill_combat_paladins_7_1);
        mBinding.skillCombatPaladins8.setImageResource(R.drawable.skill_combat_paladins_8_1);
        mBinding.skillCombatPaladins9.setImageResource(R.drawable.skill_combat_paladins_9_1);
        mBinding.skillCombatPaladins10.setImageResource(R.drawable.skill_combat_paladins_10_1);
        mBinding.skillCombatPaladins1Value.setText("0");
        mBinding.skillCombatPaladins2Value.setText("0");
        mBinding.skillCombatPaladins3Value.setText("0");
        mBinding.skillCombatPaladins4Value.setText("0");
        mBinding.skillCombatPaladins5Value.setText("0");
        mBinding.skillCombatPaladins6Value.setText("0");
        mBinding.skillCombatPaladins7Value.setText("0");
        mBinding.skillCombatPaladins8Value.setText("0");
        mBinding.skillCombatPaladins9Value.setText("0");
        mBinding.skillCombatPaladins10Value.setText("0");
        combatValue();
    }

    private void combatValue() {
        mBinding.tvCombatValueView.setText("스킬 포인트 : " + sharedPreferences.getInt(SKILL_POINT_KEY, 98));
        mBinding.tvCombatQuest.setText("퀘스트 포인트 : " + sharedPreferences.getInt(SKILL_POINT_QUEST_COMPLETE_KEY, 98));
        mBinding.skillCombatPaladins1Value.setText(String.valueOf(sharedPreferences.getInt("combat_skill_1", 0)));
        mBinding.skillCombatPaladins2Value.setText(String.valueOf(sharedPreferences.getInt("combat_skill_2", 0)));
        mBinding.skillCombatPaladins3Value.setText(String.valueOf(sharedPreferences.getInt("combat_skill_3", 0)));
        mBinding.skillCombatPaladins4Value.setText(String.valueOf(sharedPreferences.getInt("combat_skill_4", 0)));
        mBinding.skillCombatPaladins5Value.setText(String.valueOf(sharedPreferences.getInt("combat_skill_5", 0)));
        mBinding.skillCombatPaladins6Value.setText(String.valueOf(sharedPreferences.getInt("combat_skill_6", 0)));
        mBinding.skillCombatPaladins7Value.setText(String.valueOf(sharedPreferences.getInt("combat_skill_7", 0)));
        mBinding.skillCombatPaladins8Value.setText(String.valueOf(sharedPreferences.getInt("combat_skill_8", 0)));
        mBinding.skillCombatPaladins9Value.setText(String.valueOf(sharedPreferences.getInt("combat_skill_9", 0)));
        mBinding.skillCombatPaladins10Value.setText(String.valueOf(sharedPreferences.getInt("combat_skill_10", 0)));
    }

    private void skillImageUpdate() {

        if (sharedPreferences.getInt("combat_skill_1", 0) != 0) {
            mBinding.skillCombatPaladins1.setImageResource(R.drawable.skill_combat_paladins_1_2);
        }

        if (sharedPreferences.getInt("combat_skill_2", 0) != 0) {
            mBinding.skillCombatPaladins2.setImageResource(R.drawable.skill_combat_paladins_2_2);
        }

        if (sharedPreferences.getInt("combat_skill_3", 0) != 0) {
            mBinding.skillCombatPaladins3.setImageResource(R.drawable.skill_combat_paladins_3_2);
        }

        if (sharedPreferences.getInt("combat_skill_4", 0) != 0) {
            mBinding.skillCombatPaladins4.setImageResource(R.drawable.skill_combat_paladins_4_2);
        }

        if (sharedPreferences.getInt("combat_skill_5", 0) != 0) {
            mBinding.skillCombatPaladins5.setImageResource(R.drawable.skill_combat_paladins_5_2);
        }

        if (sharedPreferences.getInt("combat_skill_6", 0) != 0) {
            mBinding.skillCombatPaladins6.setImageResource(R.drawable.skill_combat_paladins_6_2);
        }

        if (sharedPreferences.getInt("combat_skill_7", 0) != 0) {
            mBinding.skillCombatPaladins7.setImageResource(R.drawable.skill_combat_paladins_7_2);
        }

        if (sharedPreferences.getInt("combat_skill_8", 0) != 0) {
            mBinding.skillCombatPaladins8.setImageResource(R.drawable.skill_combat_paladins_8_2);
        }

        if (sharedPreferences.getInt("combat_skill_9", 0) != 0) {
            mBinding.skillCombatPaladins9.setImageResource(R.drawable.skill_combat_paladins_9_2);
        }

        if (sharedPreferences.getInt("combat_skill_10", 0) != 0) {
            mBinding.skillCombatPaladins10.setImageResource(R.drawable.skill_combat_paladins_10_2);
        }
    }

    private boolean isPremiseSkillUpButton(ImageView skillUp) {
        int id = skillUp.getId();
        String str = "선행 스킬을 먼저 선택해주세요.";

        if (id == R.id.skill_combat_paladins_4) {
            if (combatSkill_1 != 0) {
                return false;
            } else {
                messagePremiseSkill = str;
                return true;
            }
        }

        if (id == R.id.skill_combat_paladins_6) {
            if (combatSkill_4 != 0 && combatSkill_1 != 0) {
                return false;
            } else {
                messagePremiseSkill = str;
                return true;
            }
        }

        if (id == R.id.skill_combat_paladins_8) {
            if (combatSkill_4 != 0 && combatSkill_1 != 0 && combatSkill_6 != 0) {
                return false;
            } else {
                messagePremiseSkill = str;
                return true;
            }
        }

        if (id == R.id.skill_combat_paladins_7) {
            if (combatSkill_3 != 0) {
                return false;
            } else {
                messagePremiseSkill = str;
                return true;
            }
        }

        if (id == R.id.skill_combat_paladins_10) {
            if (combatSkill_3 != 0 && combatSkill_7 != 0 && combatSkill_1 != 0 && combatSkill_4 != 0 && combatSkill_6 != 0 && combatSkill_8 != 0) {
                return false;
            } else {
                messagePremiseSkill = str;
                return true;
            }
        }

        if (id == R.id.skill_combat_paladins_4) {
            if (combatSkill_2 != 0) {
                return false;
            } else {
                messagePremiseSkill = str;
                return true;
            }
        }

        if (id == R.id.skill_combat_paladins_9) {
            if (combatSkill_2 != 0 && combatSkill_3 != 0 && combatSkill_5 != 0 && combatSkill_7 != 0) {
                return false;
            } else {
                messagePremiseSkill = str;
                return true;
            }
        }

        if (id == R.id.skill_combat_paladins_5) {
            if (combatSkill_2 != 0) {
                return false;
            } else {
                messagePremiseSkill = str;
                return true;
            }
        }

        return false;
    }

    private boolean isPremiseSkillDownButton(ImageView skillDown) {
        int id = skillDown.getId();

        if (id == R.id.skill_combat_paladins_1) {
            if (combatSkill_4 >= 1 && combatSkill_1 <= 1) {
                return true;
            } else {
                return false;
            }
        }

        if (id == R.id.skill_combat_paladins_4) {
            if (combatSkill_6 >= 1 && combatSkill_4 <= 1) {
                return true;
            } else {
                return false;
            }
        }

        if (id == R.id.skill_combat_paladins_6) {
            if (combatSkill_8 >= 1 && combatSkill_6 <= 1) {
                return true;
            } else {
                return false;
            }
        }

        // 3번 버튼 안눌러지게
        if (id == R.id.skill_combat_paladins_3) {
            if (combatSkill_7 >= 1 && combatSkill_3 <= 1) {
                return true;
            } else {
                return false;
            }
        }

        // 10번 스킬이 1 이상이면, 7번 버튼 안눌러지게
        if (id == R.id.skill_combat_paladins_7) {
            if (combatSkill_10 >= 1 && combatSkill_7 <= 1) {
                return true;
            } else {
                return false;
            }
        }

        // 5번 스킬이 1 이상이면 2번 스킬이 안눌러지게
        if (id == R.id.skill_combat_paladins_2) {
            if (combatSkill_5 >= 1 && combatSkill_2 <= 1) {
                return true;
            } else {
                return false;
            }
        }

        if (id == R.id.skill_combat_paladins_5) {
            if (combatSkill_9 >= 1 && combatSkill_5 <= 1) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    /** 스킬을 LONG 클릭 했을때 나오는 화면 **/
    private void skillPreviewDialog(Spanned spanned, int id) {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.skill_preview_paladins_defense);
        TextView skillPreview = dialog.findViewById(R.id.tv_preview);
        ImageView imageView = dialog.findViewById(R.id.iv_skill_preview);
        imageView.setBackgroundResource(id);
        skillPreview.setText(spanned);

        // 다이얼로그 크기 조정
        Window window = dialog.getWindow();
        if (window != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
            int width = displayMetrics.widthPixels;

            window.setLayout((int) (width * 0.9), WindowManager.LayoutParams.WRAP_CONTENT); // 화면 폭의 90% 사용
            window.setGravity(Gravity.CENTER);
        }

        dialog.show();
    }

}