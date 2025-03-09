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
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.DefenseSkill1;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.DefenseSkill10;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.DefenseSkill2;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.DefenseSkill3;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.DefenseSkill4;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.DefenseSkill5;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.DefenseSkill6;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.DefenseSkill7;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.DefenseSkill8;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.DefenseSkill9;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.defense.SkillDefense;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentDefenseBinding;

public class Defense extends Fragment {

    private static final String TAG = "Defense";
    private FragmentDefenseBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    private final String SKILL_POINT_KEY = "skillPoint_Paladins";
    private final String SKILL_POINT_QUEST_COMPLETE_KEY = "skillQuestCompletePoint_Paladins";
    public int skillPoint;
    private int skillQuestCompletePoint;
    public int defenseSkill_1;
    public int defenseSkill_2;
    public int defenseSkill_3;
    public int defenseSkill_4;
    public int defenseSkill_5;
    public int defenseSkill_6;
    public int defenseSkill_7;
    public int defenseSkill_8;
    public int defenseSkill_9;
    public int defenseSkill_10;
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
        mBinding = FragmentDefenseBinding.inflate(inflater, container, false);

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

        if (!sharedPreferences.contains("defense_skill_1")) {
            editor.putInt("defense_skill_1", 0);
        } else {
            defenseSkill_1 = sharedPreferences.getInt("defense_skill_1", 0);
        }

        if (!sharedPreferences.contains("defense_skill_2")) {
            editor.putInt("defense_skill_2", 0);
        } else {
            defenseSkill_2 = sharedPreferences.getInt("defense_skill_2", 0);
        }

        if (!sharedPreferences.contains("defense_skill_3")) {
            editor.putInt("defense_skill_3", 0);
        } else {
            defenseSkill_3 = sharedPreferences.getInt("defense_skill_3", 0);
        }

        if (!sharedPreferences.contains("defense_skill_4")) {
            editor.putInt("defense_skill_4", 0);
        } else {
            defenseSkill_4 = sharedPreferences.getInt("defense_skill_4", 0);
        }

        if (!sharedPreferences.contains("defense_skill_5")) {
            editor.putInt("defense_skill_5", 0);
        } else {
            defenseSkill_5 = sharedPreferences.getInt("defense_skill_5", 0);
        }

        if (!sharedPreferences.contains("defense_skill_6")) {
            editor.putInt("defense_skill_6", 0);
        } else {
            defenseSkill_6 = sharedPreferences.getInt("defense_skill_6", 0);
        }

        if (!sharedPreferences.contains("defense_skill_7")) {
            editor.putInt("defense_skill_7", 0);
        } else {
            defenseSkill_7 = sharedPreferences.getInt("defense_skill_7", 0);
        }

        if (!sharedPreferences.contains("defense_skill_8")) {
            editor.putInt("defense_skill_8", 0);
        } else {
            defenseSkill_8 = sharedPreferences.getInt("defense_skill_8", 0);
        }
        if (!sharedPreferences.contains("defense_skill_9")) {
            editor.putInt("defense_skill_9", 0);
        } else {
            defenseSkill_9 = sharedPreferences.getInt("defense_skill_9", 0);
        }

        if (!sharedPreferences.contains("defense_skill_10")) {
            editor.putInt("defense_skill_10", 0);
        } else {
            defenseSkill_10 = sharedPreferences.getInt("defense_skill_10", 0);
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
                if ("defense_skill_1".equals(key)) {
                    defenseSkill_1 = sharedPreferences.getInt("defense_skill_1", 0);
                }
                if ("defense_skill_2".equals(key)) {
                    defenseSkill_2 = sharedPreferences.getInt("defense_skill_2", 0);
                }
                if ("defense_skill_3".equals(key)) {
                    defenseSkill_3 = sharedPreferences.getInt("defense_skill_3", 0);
                }
                if ("defense_skill_4".equals(key)) {
                    defenseSkill_4 = sharedPreferences.getInt("defense_skill_4", 0);
                }
                if ("defense_skill_5".equals(key)) {
                    defenseSkill_5 = sharedPreferences.getInt("defense_skill_5", 0);
                }
                if ("defense_skill_6".equals(key)) {
                    defenseSkill_6 = sharedPreferences.getInt("defense_skill_6", 0);
                }
                if ("defense_skill_7".equals(key)) {
                    defenseSkill_7 = sharedPreferences.getInt("defense_skill_7", 0);
                }
                if ("defense_skill_8".equals(key)) {
                    defenseSkill_8 = sharedPreferences.getInt("defense_skill_8", 0);
                }
                if ("defense_skill_9".equals(key)) {
                    defenseSkill_9 = sharedPreferences.getInt("defense_skill_9", 0);
                }
                if ("defense_skill_10".equals(key)) {
                    defenseSkill_10 = sharedPreferences.getInt("defense_skill_10", 0);
                }

            }
        });

        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);

        editor.apply();
        defenseValue();
        skillImageUpdate();

        mBinding.skillClear.setOnClickListener(v -> resetSkillPoint());
        mBinding.tvAllSkillReset.setOnClickListener(v -> resetAllSkillPoint());

        mBinding.skillDefensePaladins1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_defense_paladins_1_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill1, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillDefensePaladins2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_defense_paladins_2_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill2, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillDefensePaladins3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_defense_paladins_3_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill3, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillDefensePaladins4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_defense_paladins_4_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill4, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillDefensePaladins5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_defense_paladins_5_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill5, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillDefensePaladins6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_defense_paladins_6_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill6, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillDefensePaladins7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_defense_paladins_7_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill7, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillDefensePaladins8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_defense_paladins_8_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill8, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillDefensePaladins9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_defense_paladins_9_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill9, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillDefensePaladins10.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_defense_paladins_10_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillDefense.defenseSkill10, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillDefensePaladins1.setOnClickListener(v -> hasSkillUp("1", mBinding.skillDefensePaladins1, mBinding.skillDefensePaladins1Value));
        mBinding.skillDefensePaladins2.setOnClickListener(v -> hasSkillUp("2", mBinding.skillDefensePaladins2, mBinding.skillDefensePaladins2Value));
        mBinding.skillDefensePaladins3.setOnClickListener(v -> hasSkillUp("3", mBinding.skillDefensePaladins3, mBinding.skillDefensePaladins3Value));
        mBinding.skillDefensePaladins4.setOnClickListener(v -> hasSkillUp("4", mBinding.skillDefensePaladins4, mBinding.skillDefensePaladins4Value));
        mBinding.skillDefensePaladins5.setOnClickListener(v -> hasSkillUp("5", mBinding.skillDefensePaladins5, mBinding.skillDefensePaladins5Value));
        mBinding.skillDefensePaladins6.setOnClickListener(v -> hasSkillUp("6", mBinding.skillDefensePaladins6, mBinding.skillDefensePaladins6Value));
        mBinding.skillDefensePaladins7.setOnClickListener(v -> hasSkillUp("7", mBinding.skillDefensePaladins7, mBinding.skillDefensePaladins7Value));
        mBinding.skillDefensePaladins8.setOnClickListener(v -> hasSkillUp("8", mBinding.skillDefensePaladins8, mBinding.skillDefensePaladins8Value));
        mBinding.skillDefensePaladins9.setOnClickListener(v -> hasSkillUp("9", mBinding.skillDefensePaladins9, mBinding.skillDefensePaladins9Value));
        mBinding.skillDefensePaladins10.setOnClickListener(v -> hasSkillUp("10", mBinding.skillDefensePaladins10, mBinding.skillDefensePaladins10Value));

        mBinding.skillDefensePaladins1ValueMinus.setOnClickListener(v -> hasSkillDown("1", mBinding.skillDefensePaladins1, mBinding.skillDefensePaladins1ValueMinus, mBinding.skillDefensePaladins1Value));
        mBinding.skillDefensePaladins2ValueMinus.setOnClickListener(v -> hasSkillDown("2", mBinding.skillDefensePaladins2, mBinding.skillDefensePaladins2ValueMinus, mBinding.skillDefensePaladins2Value));
        mBinding.skillDefensePaladins3ValueMinus.setOnClickListener(v -> hasSkillDown("3", mBinding.skillDefensePaladins3, mBinding.skillDefensePaladins3ValueMinus, mBinding.skillDefensePaladins3Value));
        mBinding.skillDefensePaladins4ValueMinus.setOnClickListener(v -> hasSkillDown("4", mBinding.skillDefensePaladins4, mBinding.skillDefensePaladins4ValueMinus, mBinding.skillDefensePaladins4Value));
        mBinding.skillDefensePaladins5ValueMinus.setOnClickListener(v -> hasSkillDown("5", mBinding.skillDefensePaladins5, mBinding.skillDefensePaladins5ValueMinus, mBinding.skillDefensePaladins5Value));
        mBinding.skillDefensePaladins6ValueMinus.setOnClickListener(v -> hasSkillDown("6", mBinding.skillDefensePaladins6, mBinding.skillDefensePaladins6ValueMinus, mBinding.skillDefensePaladins6Value));
        mBinding.skillDefensePaladins7ValueMinus.setOnClickListener(v -> hasSkillDown("7", mBinding.skillDefensePaladins7, mBinding.skillDefensePaladins7ValueMinus, mBinding.skillDefensePaladins7Value));
        mBinding.skillDefensePaladins8ValueMinus.setOnClickListener(v -> hasSkillDown("8", mBinding.skillDefensePaladins8, mBinding.skillDefensePaladins8ValueMinus, mBinding.skillDefensePaladins8Value));
        mBinding.skillDefensePaladins9ValueMinus.setOnClickListener(v -> hasSkillDown("9", mBinding.skillDefensePaladins9, mBinding.skillDefensePaladins9ValueMinus, mBinding.skillDefensePaladins9Value));
        mBinding.skillDefensePaladins10ValueMinus.setOnClickListener(v -> hasSkillDown("10", mBinding.skillDefensePaladins10, mBinding.skillDefensePaladins10ValueMinus, mBinding.skillDefensePaladins10Value));

        return mBinding.getRoot();
    }

    private void hasSkillUp(String imagesSkillNumber, ImageView imagesImageView, TextView valueTextView) {

        Spanned spanned;
        int resId = getResources().getIdentifier("skill_defense_paladins_" + imagesSkillNumber + "_2", "drawable", getContext().getPackageName());
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

        if (defenseSkill_1 == 20) {
            if (clickId == R.id.skill_defense_paladins_1) {
                spanned = Html.fromHtml(SkillDefense.defenseSkill1_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
                return;
            }
        }

        if (defenseSkill_1 < 20) {
            if (clickId == R.id.skill_defense_paladins_1) {
                skillPoint--;
                defenseSkill_1++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(defenseSkill_1));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_1", defenseSkill_1);
                editor.apply();

                DefenseSkill1.defenseSkill_1(defenseSkill_1, mBinding.skillUpdate);
            }
        }

        if (defenseSkill_2 == 20) {
            if (clickId == R.id.skill_defense_paladins_2) {
                spanned = Html.fromHtml(SkillDefense.defenseSkill2_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
                return;
            }
        }

        if (defenseSkill_2 < 20) {
            if (clickId == R.id.skill_defense_paladins_2) {
                skillPoint--;
                defenseSkill_2++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(defenseSkill_2));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_2", defenseSkill_2);
                editor.apply();
                DefenseSkill2.defenseSkill_2(defenseSkill_2, mBinding.skillUpdate);
            }
        }

        if (defenseSkill_3 == 20) {
            if (clickId == R.id.skill_defense_paladins_3) {
                spanned = Html.fromHtml(SkillDefense.defenseSkill3_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (defenseSkill_3 < 20) {
            if (clickId == R.id.skill_defense_paladins_3) {
                skillPoint--;
                defenseSkill_3++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(defenseSkill_3));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_3", defenseSkill_3);
                editor.apply();
                DefenseSkill3.defenseSkill_3(defenseSkill_3, mBinding.skillUpdate);
            }
        }

        if (defenseSkill_4 == 20) {
            if (clickId == R.id.skill_defense_paladins_4) {
                spanned = Html.fromHtml(SkillDefense.defenseSkill4_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (defenseSkill_4 < 20) {
            if (clickId == R.id.skill_defense_paladins_4) {
                skillPoint--;
                defenseSkill_4++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(defenseSkill_4));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_4", defenseSkill_4);
                editor.apply();
                DefenseSkill4.defenseSkill_4(defenseSkill_4, mBinding.skillUpdate, getContext());
            }
        }

        if (defenseSkill_5 == 20) {
            if (clickId == R.id.skill_defense_paladins_5) {
                spanned = Html.fromHtml(SkillDefense.defenseSkill5_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (defenseSkill_5 < 20) {
            if (clickId == R.id.skill_defense_paladins_5) {
                skillPoint--;
                defenseSkill_5++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(defenseSkill_5));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_5", defenseSkill_5);
                editor.apply();
                DefenseSkill5.defenseSkill_5(defenseSkill_5, mBinding.skillUpdate, getContext());
            }
        }

        if (defenseSkill_6 == 20) {
            if (clickId == R.id.skill_defense_paladins_6) {
                spanned = Html.fromHtml(SkillDefense.defenseSkill6_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (defenseSkill_6 < 20) {
            if (clickId == R.id.skill_defense_paladins_6) {
                skillPoint--;
                defenseSkill_6++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(defenseSkill_6));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_6", defenseSkill_6);
                editor.apply();
                DefenseSkill6.defenseSkill_6(defenseSkill_6, mBinding.skillUpdate, getContext());
            }
        }

        if (defenseSkill_7 == 20) {
            if (clickId == R.id.skill_defense_paladins_7) {
                spanned = Html.fromHtml(SkillDefense.defenseSkill7_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (defenseSkill_7 < 20) {
            if (clickId == R.id.skill_defense_paladins_7) {
                skillPoint--;
                defenseSkill_7++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(defenseSkill_7));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_7", defenseSkill_7);
                editor.apply();
                if (messagePremiseSkill == null) {
                    mBinding.skillUpdate.setText(SkillDefense.defenseSkill7);
                }
                DefenseSkill7.defenseSkill_7(defenseSkill_7, mBinding.skillUpdate, getContext());
            }
        }


        if (defenseSkill_8 == 20) {
            if (clickId == R.id.skill_defense_paladins_8) {
                spanned = Html.fromHtml(SkillDefense.defenseSkill8_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (defenseSkill_8 < 20) {
            if (clickId == R.id.skill_defense_paladins_8) {
                skillPoint--;
                defenseSkill_8++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(defenseSkill_8));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_8", defenseSkill_8);
                editor.apply();
                DefenseSkill8.defenseSkill_8(defenseSkill_8, mBinding.skillUpdate, getContext());
            }
        }

        if (defenseSkill_9 == 20) {
            if (clickId == R.id.skill_defense_paladins_9) {
                spanned = Html.fromHtml(SkillDefense.defenseSkill9_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (defenseSkill_9 < 20) {
            if (clickId == R.id.skill_defense_paladins_9) {
                skillPoint--;
                defenseSkill_9++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(defenseSkill_9));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_9", defenseSkill_9);
                editor.apply();
                DefenseSkill9.defenseSkill_9(defenseSkill_9, mBinding.skillUpdate, getContext());
            }
        }


        if (defenseSkill_10 == 20) {
            if (clickId == R.id.skill_defense_paladins_10) {
                spanned = Html.fromHtml(SkillDefense.defenseSkill10_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (defenseSkill_10 < 20) {
            if (clickId == R.id.skill_defense_paladins_10) {
                skillPoint--;
                defenseSkill_10++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(defenseSkill_10));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_10", defenseSkill_10);
                editor.apply();
                DefenseSkill10.defenseSkill_10(defenseSkill_10, mBinding.skillUpdate, getContext());
            }
        }
        defenseValue();
    }

    private void hasSkillDown(String imagesSkillNumber, ImageView imagesImageView, TextView minusButton, TextView valueTextView) {
        String skillMessage = "스킬 업데이트를 해주세요";
        int resId = getResources().getIdentifier("skill_defense_paladins_" + imagesSkillNumber + "_1", "drawable", getContext().getPackageName());
        int clickId = minusButton.getId();

        if (isPremiseSkillDownButton(imagesImageView)) {
            return;
        }

        if (defenseSkill_1 != 0) {
            if (clickId == R.id.skill_defense_paladins_1_value_minus) {
                skillPoint++;
                defenseSkill_1--;
                valueTextView.setText(String.valueOf(defenseSkill_1));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_1", defenseSkill_1);
                editor.apply();

                if (defenseSkill_1 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }

                DefenseSkill1.defenseSkill_1(defenseSkill_1, mBinding.skillUpdate);

            }
        }
        if (defenseSkill_2 != 0) {
            if (clickId == R.id.skill_defense_paladins_2_value_minus) {
                skillPoint++;
                defenseSkill_2--;
                valueTextView.setText(String.valueOf(defenseSkill_2));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_2", defenseSkill_2);
                editor.apply();

                if (defenseSkill_2 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }

                DefenseSkill2.defenseSkill_2(defenseSkill_2, mBinding.skillUpdate);

            }
        }
        if (defenseSkill_3 != 0) {
            if (clickId == R.id.skill_defense_paladins_3_value_minus) {
                skillPoint++;
                defenseSkill_3--;
                valueTextView.setText(String.valueOf(defenseSkill_3));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_3", defenseSkill_3);
                editor.apply();

                if (defenseSkill_3 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }

                DefenseSkill3.defenseSkill_3(defenseSkill_3, mBinding.skillUpdate);

            }
        }
        if (defenseSkill_4 != 0) {
            if (clickId == R.id.skill_defense_paladins_4_value_minus) {
                skillPoint++;
                defenseSkill_4--;
                valueTextView.setText(String.valueOf(defenseSkill_4));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_4", defenseSkill_4);
                editor.apply();

                if (defenseSkill_4 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }

                DefenseSkill4.defenseSkill_4(defenseSkill_4, mBinding.skillUpdate, getContext());


            }
        }
        if (defenseSkill_5 != 0) {
            if (clickId == R.id.skill_defense_paladins_5_value_minus) {
                skillPoint++;
                defenseSkill_5--;
                valueTextView.setText(String.valueOf(defenseSkill_5));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_5", defenseSkill_5);
                editor.apply();

                if (defenseSkill_5 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }

                DefenseSkill5.defenseSkill_5(defenseSkill_5, mBinding.skillUpdate, getContext());


            }
        }
        if (defenseSkill_6 != 0) {
            if (clickId == R.id.skill_defense_paladins_6_value_minus) {
                skillPoint++;
                defenseSkill_6--;
                valueTextView.setText(String.valueOf(defenseSkill_6));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_6", defenseSkill_6);
                editor.apply();

                if (defenseSkill_6 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }

                DefenseSkill6.defenseSkill_6(defenseSkill_6, mBinding.skillUpdate, getContext());

            }
        }
        if (defenseSkill_7 != 0) {
            if (clickId == R.id.skill_defense_paladins_7_value_minus) {
                skillPoint++;
                defenseSkill_7--;
                valueTextView.setText(String.valueOf(defenseSkill_7));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_7", defenseSkill_7);
                editor.apply();

                if (defenseSkill_7 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }

                DefenseSkill7.defenseSkill_7(defenseSkill_7, mBinding.skillUpdate, getContext());

            }
        }
        if (defenseSkill_8 != 0) {
            if (clickId == R.id.skill_defense_paladins_8_value_minus) {
                skillPoint++;
                defenseSkill_8--;
                valueTextView.setText(String.valueOf(defenseSkill_8));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_8", defenseSkill_8);
                editor.apply();

                if (defenseSkill_8 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }

                DefenseSkill8.defenseSkill_8(defenseSkill_8, mBinding.skillUpdate, getContext());

            }
        }
        if (defenseSkill_9 != 0) {
            if (clickId == R.id.skill_defense_paladins_9_value_minus) {
                skillPoint++;
                defenseSkill_9--;
                valueTextView.setText(String.valueOf(defenseSkill_9));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_9", defenseSkill_9);
                editor.apply();

                if (defenseSkill_9 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }

                DefenseSkill9.defenseSkill_9(defenseSkill_9, mBinding.skillUpdate, getContext());

            }
        }
        if (defenseSkill_10 != 0) {
            if (clickId == R.id.skill_defense_paladins_10_value_minus) {
                skillPoint++;
                defenseSkill_10--;
                valueTextView.setText(String.valueOf(defenseSkill_10));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("defense_skill_10", defenseSkill_10);
                editor.apply();

                if (defenseSkill_10 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }

                DefenseSkill10.defenseSkill_10(defenseSkill_10, mBinding.skillUpdate, getContext());

            }
        }
        defenseValue();
    }

    // 모든 스킬의 스킬 초기화
    private void resetAllSkillPoint() {
        skillPoint = 98 ;
        defenseSkill_1 = 0;
        defenseSkill_2 = 0;
        defenseSkill_3 = 0;
        defenseSkill_4 = 0;
        defenseSkill_5 = 0;
        defenseSkill_6 = 0;
        defenseSkill_7 = 0;
        defenseSkill_8 = 0;
        defenseSkill_9 = 0;
        defenseSkill_10 = 0;
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

        mBinding.skillDefensePaladins1.setImageResource(R.drawable.skill_defense_paladins_1_1);
        mBinding.skillDefensePaladins2.setImageResource(R.drawable.skill_defense_paladins_2_1);
        mBinding.skillDefensePaladins3.setImageResource(R.drawable.skill_defense_paladins_3_1);
        mBinding.skillDefensePaladins4.setImageResource(R.drawable.skill_defense_paladins_4_1);
        mBinding.skillDefensePaladins5.setImageResource(R.drawable.skill_defense_paladins_5_1);
        mBinding.skillDefensePaladins6.setImageResource(R.drawable.skill_defense_paladins_6_1);
        mBinding.skillDefensePaladins7.setImageResource(R.drawable.skill_defense_paladins_7_1);
        mBinding.skillDefensePaladins8.setImageResource(R.drawable.skill_defense_paladins_8_1);
        mBinding.skillDefensePaladins9.setImageResource(R.drawable.skill_defense_paladins_9_1);
        mBinding.skillDefensePaladins10.setImageResource(R.drawable.skill_defense_paladins_10_1);
        mBinding.skillDefensePaladins1Value.setText("0");
        mBinding.skillDefensePaladins2Value.setText("0");
        mBinding.skillDefensePaladins3Value.setText("0");
        mBinding.skillDefensePaladins4Value.setText("0");
        mBinding.skillDefensePaladins5Value.setText("0");
        mBinding.skillDefensePaladins6Value.setText("0");
        mBinding.skillDefensePaladins7Value.setText("0");
        mBinding.skillDefensePaladins8Value.setText("0");
        mBinding.skillDefensePaladins9Value.setText("0");
        mBinding.skillDefensePaladins10Value.setText("0");
        defenseValue();
    }

    private void resetSkillPoint() {
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

        int b1 = sharedPreferences.getInt("combat_skill_1", 0);
        int b2 = sharedPreferences.getInt("combat_skill_2", 0);
        int b3 = sharedPreferences.getInt("combat_skill_3", 0);
        int b4 = sharedPreferences.getInt("combat_skill_4", 0);
        int b5 = sharedPreferences.getInt("combat_skill_5", 0);
        int b6 = sharedPreferences.getInt("combat_skill_6", 0);
        int b7 = sharedPreferences.getInt("combat_skill_7", 0);
        int b8 = sharedPreferences.getInt("combat_skill_8", 0);
        int b9 = sharedPreferences.getInt("combat_skill_9", 0);
        int b10 = sharedPreferences.getInt("combat_skill_10", 0);

        int value1 = b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9 + b10;
        int value2 = v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9 + v10;

        int skill = 98;
        int totalValue = value1 + value2;

        skillPoint = skill - totalValue;

        defenseSkill_1 = 0;
        defenseSkill_2 = 0;
        defenseSkill_3 = 0;
        defenseSkill_4 = 0;
        defenseSkill_5 = 0;
        defenseSkill_6 = 0;
        defenseSkill_7 = 0;
        defenseSkill_8 = 0;
        defenseSkill_9 = 0;
        defenseSkill_10 = 0;

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
        editor.apply();
        skillEditor.clear();

        mBinding.skillDefensePaladins1.setImageResource(R.drawable.skill_defense_paladins_1_1);
        mBinding.skillDefensePaladins2.setImageResource(R.drawable.skill_defense_paladins_2_1);
        mBinding.skillDefensePaladins3.setImageResource(R.drawable.skill_defense_paladins_3_1);
        mBinding.skillDefensePaladins4.setImageResource(R.drawable.skill_defense_paladins_4_1);
        mBinding.skillDefensePaladins5.setImageResource(R.drawable.skill_defense_paladins_5_1);
        mBinding.skillDefensePaladins6.setImageResource(R.drawable.skill_defense_paladins_6_1);
        mBinding.skillDefensePaladins7.setImageResource(R.drawable.skill_defense_paladins_7_1);
        mBinding.skillDefensePaladins8.setImageResource(R.drawable.skill_defense_paladins_8_1);
        mBinding.skillDefensePaladins9.setImageResource(R.drawable.skill_defense_paladins_9_1);
        mBinding.skillDefensePaladins10.setImageResource(R.drawable.skill_defense_paladins_10_1);
        mBinding.skillDefensePaladins1Value.setText("0");
        mBinding.skillDefensePaladins2Value.setText("0");
        mBinding.skillDefensePaladins3Value.setText("0");
        mBinding.skillDefensePaladins4Value.setText("0");
        mBinding.skillDefensePaladins5Value.setText("0");
        mBinding.skillDefensePaladins6Value.setText("0");
        mBinding.skillDefensePaladins7Value.setText("0");
        mBinding.skillDefensePaladins8Value.setText("0");
        mBinding.skillDefensePaladins9Value.setText("0");
        mBinding.skillDefensePaladins10Value.setText("0");
        defenseValue();
    }

    private void defenseValue() {
        mBinding.tvDefenseValueView.setText("스킬 포인트 : " + sharedPreferences.getInt(SKILL_POINT_KEY, 98));
        mBinding.tvDefenseQuest.setText("퀘스트 포인트 : " + sharedPreferences.getInt(SKILL_POINT_QUEST_COMPLETE_KEY, 98));
        mBinding.skillDefensePaladins1Value.setText(String.valueOf(sharedPreferences.getInt("defense_skill_1", 0)));
        mBinding.skillDefensePaladins2Value.setText(String.valueOf(sharedPreferences.getInt("defense_skill_2", 0)));
        mBinding.skillDefensePaladins3Value.setText(String.valueOf(sharedPreferences.getInt("defense_skill_3", 0)));
        mBinding.skillDefensePaladins4Value.setText(String.valueOf(sharedPreferences.getInt("defense_skill_4", 0)));
        mBinding.skillDefensePaladins5Value.setText(String.valueOf(sharedPreferences.getInt("defense_skill_5", 0)));
        mBinding.skillDefensePaladins6Value.setText(String.valueOf(sharedPreferences.getInt("defense_skill_6", 0)));
        mBinding.skillDefensePaladins7Value.setText(String.valueOf(sharedPreferences.getInt("defense_skill_7", 0)));
        mBinding.skillDefensePaladins8Value.setText(String.valueOf(sharedPreferences.getInt("defense_skill_8", 0)));
        mBinding.skillDefensePaladins9Value.setText(String.valueOf(sharedPreferences.getInt("defense_skill_9", 0)));
        mBinding.skillDefensePaladins10Value.setText(String.valueOf(sharedPreferences.getInt("defense_skill_10", 0)));
    }

    private void skillImageUpdate() {

        if (sharedPreferences.getInt("defense_skill_1", 0) != 0) {
            mBinding.skillDefensePaladins1.setImageResource(R.drawable.skill_defense_paladins_1_2);
        }

        if (sharedPreferences.getInt("defense_skill_2", 0) != 0) {
            mBinding.skillDefensePaladins2.setImageResource(R.drawable.skill_defense_paladins_2_2);
        }

        if (sharedPreferences.getInt("defense_skill_3", 0) != 0) {
            mBinding.skillDefensePaladins3.setImageResource(R.drawable.skill_defense_paladins_3_2);
        }

        if (sharedPreferences.getInt("defense_skill_4", 0) != 0) {
            mBinding.skillDefensePaladins4.setImageResource(R.drawable.skill_defense_paladins_4_2);
        }

        if (sharedPreferences.getInt("defense_skill_5", 0) != 0) {
            mBinding.skillDefensePaladins5.setImageResource(R.drawable.skill_defense_paladins_5_2);
        }

        if (sharedPreferences.getInt("defense_skill_6", 0) != 0) {
            mBinding.skillDefensePaladins6.setImageResource(R.drawable.skill_defense_paladins_6_2);
        }

        if (sharedPreferences.getInt("defense_skill_7", 0) != 0) {
            mBinding.skillDefensePaladins7.setImageResource(R.drawable.skill_defense_paladins_7_2);
        }

        if (sharedPreferences.getInt("defense_skill_8", 0) != 0) {
            mBinding.skillDefensePaladins8.setImageResource(R.drawable.skill_defense_paladins_8_2);
        }

        if (sharedPreferences.getInt("defense_skill_9", 0) != 0) {
            mBinding.skillDefensePaladins9.setImageResource(R.drawable.skill_defense_paladins_9_2);
        }

        if (sharedPreferences.getInt("defense_skill_10", 0) != 0) {
            mBinding.skillDefensePaladins10.setImageResource(R.drawable.skill_defense_paladins_10_2);
        }
    }

    private boolean isPremiseSkillUpButton(ImageView skillUp) {
        int id = skillUp.getId();
        String str1 = "기도";
        String str2 = "기도, 인내, 정화";
        String str3 = "기도, 정화";
        String str4 = "기도, 인내, 정화, 원기";

        if (id == R.id.skill_defense_paladins_5) {
            if (defenseSkill_1 != 0) {
                return false;
            } else {
                messagePremiseSkill = getSkillName(str1);
                return true;
            }
        }

        if (id == R.id.skill_defense_paladins_7) {
            if (defenseSkill_1 != 0 && defenseSkill_3 != 0 && defenseSkill_5 != 0) {
                return false;
            } else {
                messagePremiseSkill = getSkillName(str2);
                return true;
            }
        }

        if (id == R.id.skill_defense_paladins_8) {
            if (defenseSkill_1 != 0 && defenseSkill_5 != 0) {
                return false;
            } else {
                messagePremiseSkill = getSkillName(str3);
                return true;
            }
        }

        if (id == R.id.skill_defense_paladins_9) {
            if (defenseSkill_1 != 0 && defenseSkill_3 != 0 && defenseSkill_5 != 0 && defenseSkill_7 != 0) {
                return false;
            } else {
                messagePremiseSkill = getSkillName(str4);
                return true;
            }
        }

        return false;
    }

    private boolean isPremiseSkillDownButton(ImageView skillDown) {
        int id = skillDown.getId();
        // 5번 스킬이 1보다 높으면 스킬1번이 안눌러짐
        if (id == R.id.skill_defense_paladins_1) {
            if (defenseSkill_5 >= 1 && defenseSkill_1 <= 1) {
                return true;
            } else {
                return false;
            }
        }

        // 7번 스킬이 1보다 높으면 3번 스킬이 안눌러짐
        if (id == R.id.skill_defense_paladins_3) {
            if (defenseSkill_7 >= 1 && defenseSkill_3 <= 1) {
                return true;
            } else {
                return false;
            }
        }

        if (id == R.id.skill_defense_paladins_5) {
            if (defenseSkill_8 >= 1 && defenseSkill_5 <= 1 || defenseSkill_7 >= 1 && defenseSkill_5 <= 1) {
                return true;
            } else {
                return false;
            }

        }

        // 9번 스킬이 1보다 높으면 7번 스킬이 안눌러짐
        if (id == R.id.skill_defense_paladins_7) {
            if (defenseSkill_9 >= 1 && defenseSkill_7 <= 1) {
                return true;
            } else {
                return false;
            }
        }


        return false;
    }

    private String getSkillName(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("이 스킬을 사용하시려면 ").append(str).append(" 스킬이 필요합니다.");
        return stringBuilder.toString();
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