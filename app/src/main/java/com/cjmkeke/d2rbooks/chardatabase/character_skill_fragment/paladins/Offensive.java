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
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.offensive.Offensive1;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.offensive.Offensive10;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.offensive.Offensive2;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.offensive.Offensive3;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.offensive.Offensive4;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.offensive.Offensive5;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.offensive.Offensive6;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.offensive.Offensive7;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.offensive.Offensive8;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.offensive.Offensive9;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.offensive.SkillOffensive;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentOffensiveBinding;


public class Offensive extends Fragment {

    private static final String TAG = "Attack";
    private FragmentOffensiveBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    private final String SKILL_POINT_KEY = "skillPoint_Paladins";
    private final String SKILL_POINT_QUEST_COMPLETE_KEY = "skillQuestCompletePoint_Paladins";
    public int skillPoint;
    private int skillQuestCompletePoint;
    public int offensiveSkill_1;
    public int offensiveSkill_2;
    public int offensiveSkill_3;
    public int offensiveSkill_4;
    public int offensiveSkill_5;
    public int offensiveSkill_6;
    public int offensiveSkill_7;
    public int offensiveSkill_8;
    public int offensiveSkill_9;
    public int offensiveSkill_10;
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
        mBinding = FragmentOffensiveBinding.inflate(inflater, container, false);

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

        if (!sharedPreferences.contains("offensive_skill_1")) {
            editor.putInt("offensive_skill_1", 0);
        } else {
            offensiveSkill_1 = sharedPreferences.getInt("offensive_skill_1", 0);
        }

        if (!sharedPreferences.contains("offensive_skill_2")) {
            editor.putInt("offensive_skill_2", 0);
        } else {
            offensiveSkill_2 = sharedPreferences.getInt("offensive_skill_2", 0);
        }

        if (!sharedPreferences.contains("offensive_skill_3")) {
            editor.putInt("offensive_skill_3", 0);
        } else {
            offensiveSkill_3 = sharedPreferences.getInt("offensive_skill_3", 0);
        }

        if (!sharedPreferences.contains("offensive_skill_4")) {
            editor.putInt("offensive_skill_4", 0);
        } else {
            offensiveSkill_4 = sharedPreferences.getInt("offensive_skill_4", 0);
        }

        if (!sharedPreferences.contains("offensive_skill_5")) {
            editor.putInt("offensive_skill_5", 0);
        } else {
            offensiveSkill_5 = sharedPreferences.getInt("offensive_skill_5", 0);
        }

        if (!sharedPreferences.contains("offensive_skill_6")) {
            editor.putInt("offensive_skill_6", 0);
        } else {
            offensiveSkill_6 = sharedPreferences.getInt("offensive_skill_6", 0);
        }

        if (!sharedPreferences.contains("offensive_skill_7")) {
            editor.putInt("offensive_skill_7", 0);
        } else {
            offensiveSkill_7 = sharedPreferences.getInt("offensive_skill_7", 0);
        }

        if (!sharedPreferences.contains("offensive_skill_8")) {
            editor.putInt("offensive_skill_8", 0);
        } else {
            offensiveSkill_8 = sharedPreferences.getInt("offensive_skill_8", 0);
        }
        if (!sharedPreferences.contains("offensive_skill_9")) {
            editor.putInt("offensive_skill_9", 0);
        } else {
            offensiveSkill_9 = sharedPreferences.getInt("offensive_skill_9", 0);
        }

        if (!sharedPreferences.contains("offensive_skill_10")) {
            editor.putInt("offensive_skill_10", 0);
        } else {
            offensiveSkill_10 = sharedPreferences.getInt("offensive_skill_10", 0);
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
                if ("offensive_skill_1".equals(key)) {
                    offensiveSkill_1 = sharedPreferences.getInt("offensive_skill_1", 0);
                }
                if ("offensive_skill_2".equals(key)) {
                    offensiveSkill_2 = sharedPreferences.getInt("offensive_skill_2", 0);
                }
                if ("offensive_skill_3".equals(key)) {
                    offensiveSkill_3 = sharedPreferences.getInt("offensive_skill_3", 0);
                }
                if ("offensive_skill_4".equals(key)) {
                    offensiveSkill_4 = sharedPreferences.getInt("offensive_skill_4", 0);
                }
                if ("offensive_skill_5".equals(key)) {
                    offensiveSkill_5 = sharedPreferences.getInt("offensive_skill_5", 0);
                }
                if ("offensive_skill_6".equals(key)) {
                    offensiveSkill_6 = sharedPreferences.getInt("offensive_skill_6", 0);
                }
                if ("offensive_skill_7".equals(key)) {
                    offensiveSkill_7 = sharedPreferences.getInt("offensive_skill_7", 0);
                }
                if ("offensive_skill_8".equals(key)) {
                    offensiveSkill_8 = sharedPreferences.getInt("offensive_skill_8", 0);
                }
                if ("offensive_skill_9".equals(key)) {
                    offensiveSkill_9 = sharedPreferences.getInt("offensive_skill_9", 0);
                }
                if ("offensive_skill_10".equals(key)) {
                    offensiveSkill_10 = sharedPreferences.getInt("offensive_skill_10", 0);
                }

            }
        });

        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);

        editor.apply();
        offensiveValue();
        skillImageUpdate();

        mBinding.skillClear.setOnClickListener(v -> resetSkillPoint());
        mBinding.tvAllSkillReset.setOnClickListener(v -> resetAllSkillPoint());

        mBinding.skillOffensivePaladins1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_offensive_paladins_1_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillOffensive.offensiveSkill1, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillOffensivePaladins2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_offensive_paladins_2_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillOffensive.offensiveSkill2, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillOffensivePaladins3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_offensive_paladins_3_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillOffensive.offensiveSkill3, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillOffensivePaladins4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_offensive_paladins_4_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillOffensive.offensiveSkill4, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillOffensivePaladins5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_offensive_paladins_5_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillOffensive.offensiveSkill5, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillOffensivePaladins6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_offensive_paladins_6_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillOffensive.offensiveSkill6, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillOffensivePaladins7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_offensive_paladins_7_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillOffensive.offensiveSkill7, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillOffensivePaladins8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_offensive_paladins_8_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillOffensive.offensiveSkill8, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillOffensivePaladins9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_offensive_paladins_9_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillOffensive.offensiveSkill9, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillOffensivePaladins10.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_offensive_paladins_10_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillOffensive.offensiveSkill10, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillOffensivePaladins1.setOnClickListener(v -> hasSkillUp("1", mBinding.skillOffensivePaladins1, mBinding.skillOffensivePaladins1Value));
        mBinding.skillOffensivePaladins2.setOnClickListener(v -> hasSkillUp("2", mBinding.skillOffensivePaladins2, mBinding.skillOffensivePaladins2Value));
        mBinding.skillOffensivePaladins3.setOnClickListener(v -> hasSkillUp("3", mBinding.skillOffensivePaladins3, mBinding.skillOffensivePaladins3Value));
        mBinding.skillOffensivePaladins4.setOnClickListener(v -> hasSkillUp("4", mBinding.skillOffensivePaladins4, mBinding.skillOffensivePaladins4Value));
        mBinding.skillOffensivePaladins5.setOnClickListener(v -> hasSkillUp("5", mBinding.skillOffensivePaladins5, mBinding.skillOffensivePaladins5Value));
        mBinding.skillOffensivePaladins6.setOnClickListener(v -> hasSkillUp("6", mBinding.skillOffensivePaladins6, mBinding.skillOffensivePaladins6Value));
        mBinding.skillOffensivePaladins7.setOnClickListener(v -> hasSkillUp("7", mBinding.skillOffensivePaladins7, mBinding.skillOffensivePaladins7Value));
        mBinding.skillOffensivePaladins8.setOnClickListener(v -> hasSkillUp("8", mBinding.skillOffensivePaladins8, mBinding.skillOffensivePaladins8Value));
        mBinding.skillOffensivePaladins9.setOnClickListener(v -> hasSkillUp("9", mBinding.skillOffensivePaladins9, mBinding.skillOffensivePaladins9Value));
        mBinding.skillOffensivePaladins10.setOnClickListener(v -> hasSkillUp("10", mBinding.skillOffensivePaladins10, mBinding.skillOffensivePaladins10Value));

        mBinding.skillOffensivePaladins1ValueMinus.setOnClickListener(v -> hasSkillDown("1", mBinding.skillOffensivePaladins1, mBinding.skillOffensivePaladins1ValueMinus, mBinding.skillOffensivePaladins1Value));
        mBinding.skillOffensivePaladins2ValueMinus.setOnClickListener(v -> hasSkillDown("2", mBinding.skillOffensivePaladins2, mBinding.skillOffensivePaladins2ValueMinus, mBinding.skillOffensivePaladins2Value));
        mBinding.skillOffensivePaladins3ValueMinus.setOnClickListener(v -> hasSkillDown("3", mBinding.skillOffensivePaladins3, mBinding.skillOffensivePaladins3ValueMinus, mBinding.skillOffensivePaladins3Value));
        mBinding.skillOffensivePaladins4ValueMinus.setOnClickListener(v -> hasSkillDown("4", mBinding.skillOffensivePaladins4, mBinding.skillOffensivePaladins4ValueMinus, mBinding.skillOffensivePaladins4Value));
        mBinding.skillOffensivePaladins5ValueMinus.setOnClickListener(v -> hasSkillDown("5", mBinding.skillOffensivePaladins5, mBinding.skillOffensivePaladins5ValueMinus, mBinding.skillOffensivePaladins5Value));
        mBinding.skillOffensivePaladins6ValueMinus.setOnClickListener(v -> hasSkillDown("6", mBinding.skillOffensivePaladins6, mBinding.skillOffensivePaladins6ValueMinus, mBinding.skillOffensivePaladins6Value));
        mBinding.skillOffensivePaladins7ValueMinus.setOnClickListener(v -> hasSkillDown("7", mBinding.skillOffensivePaladins7, mBinding.skillOffensivePaladins7ValueMinus, mBinding.skillOffensivePaladins7Value));
        mBinding.skillOffensivePaladins8ValueMinus.setOnClickListener(v -> hasSkillDown("8", mBinding.skillOffensivePaladins8, mBinding.skillOffensivePaladins8ValueMinus, mBinding.skillOffensivePaladins8Value));
        mBinding.skillOffensivePaladins9ValueMinus.setOnClickListener(v -> hasSkillDown("9", mBinding.skillOffensivePaladins9, mBinding.skillOffensivePaladins9ValueMinus, mBinding.skillOffensivePaladins9Value));
        mBinding.skillOffensivePaladins10ValueMinus.setOnClickListener(v -> hasSkillDown("10", mBinding.skillOffensivePaladins10, mBinding.skillOffensivePaladins10ValueMinus, mBinding.skillOffensivePaladins10Value));

        return mBinding.getRoot();
    }


    private void hasSkillUp(String imagesSkillNumber, ImageView imagesImageView, TextView valueTextView) {

        Spanned spanned;
        int resId = getResources().getIdentifier("skill_offensive_paladins_" + imagesSkillNumber + "_2", "drawable", getContext().getPackageName());
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

        if (offensiveSkill_1 == 20) {
            if (clickId == R.id.skill_offensive_paladins_1) {
                spanned = Html.fromHtml(SkillOffensive.offensiveSkill1_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
                return;
            }
        }

        if (offensiveSkill_1 < 20) {
            if (clickId == R.id.skill_offensive_paladins_1) {
                skillPoint--;
                offensiveSkill_1++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(offensiveSkill_1));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_1", offensiveSkill_1);
                editor.apply();
                Offensive1.skillUpdate(offensiveSkill_1, mBinding.skillUpdate, getContext());
            }
        }

        if (offensiveSkill_2 == 20) {
            if (clickId == R.id.skill_offensive_paladins_2) {
                spanned = Html.fromHtml(SkillOffensive.offensiveSkill2_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
                return;
            }
        }

        if (offensiveSkill_2 < 20) {
            if (clickId == R.id.skill_offensive_paladins_2) {
                skillPoint--;
                offensiveSkill_2++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(offensiveSkill_2));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_2", offensiveSkill_2);
                editor.apply();
                Offensive2.skillUpdate(offensiveSkill_2, mBinding.skillUpdate, getContext());
            }
        }

        if (offensiveSkill_3 == 20) {
            if (clickId == R.id.skill_offensive_paladins_3) {
                spanned = Html.fromHtml(SkillOffensive.offensiveSkill3_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (offensiveSkill_3 < 20) {
            if (clickId == R.id.skill_offensive_paladins_3) {
                skillPoint--;
                offensiveSkill_3++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(offensiveSkill_3));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_3", offensiveSkill_3);
                editor.apply();
                Offensive3.skillUpdate(offensiveSkill_3, mBinding.skillUpdate, getContext());
            }
        }

        if (offensiveSkill_4 == 20) {
            if (clickId == R.id.skill_offensive_paladins_4) {
                spanned = Html.fromHtml(SkillOffensive.offensiveSkill4_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (offensiveSkill_4 < 20) {
            if (clickId == R.id.skill_offensive_paladins_4) {
                skillPoint--;
                offensiveSkill_4++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(offensiveSkill_4));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_4", offensiveSkill_4);
                editor.apply();
                Offensive4.skillUpdate(offensiveSkill_4, mBinding.skillUpdate, getContext());
            }
        }

        if (offensiveSkill_5 == 20) {
            if (clickId == R.id.skill_offensive_paladins_5) {
                spanned = Html.fromHtml(SkillOffensive.offensiveSkill5_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (offensiveSkill_5 < 20) {
            if (clickId == R.id.skill_offensive_paladins_5) {
                skillPoint--;
                offensiveSkill_5++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(offensiveSkill_5));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_5", offensiveSkill_5);
                editor.apply();
                Offensive5.skillUpdate(offensiveSkill_5, mBinding.skillUpdate, getContext());
            }
        }

        if (offensiveSkill_6 == 20) {
            if (clickId == R.id.skill_offensive_paladins_6) {
                spanned = Html.fromHtml(SkillOffensive.offensiveSkill6_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (offensiveSkill_6 < 20) {
            if (clickId == R.id.skill_offensive_paladins_6) {
                skillPoint--;
                offensiveSkill_6++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(offensiveSkill_6));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_6", offensiveSkill_6);
                editor.apply();
                Offensive6.skillUpdate(offensiveSkill_6, mBinding.skillUpdate, getContext());
            }
        }

        if (offensiveSkill_7 == 20) {
            if (clickId == R.id.skill_offensive_paladins_7) {
                spanned = Html.fromHtml(SkillOffensive.offensiveSkill7_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (offensiveSkill_7 < 20) {
            if (clickId == R.id.skill_offensive_paladins_7) {
                skillPoint--;
                offensiveSkill_7++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(offensiveSkill_7));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_7", offensiveSkill_7);
                editor.apply();
                if (messagePremiseSkill == null) {
                    mBinding.skillUpdate.setText(SkillOffensive.offensiveSkill7);
                }
                Offensive7.skillUpdate(offensiveSkill_7, mBinding.skillUpdate, getContext());
            }
        }


        if (offensiveSkill_8 == 20) {
            if (clickId == R.id.skill_offensive_paladins_8) {
                spanned = Html.fromHtml(SkillOffensive.offensiveSkill8_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (offensiveSkill_8 < 20) {
            if (clickId == R.id.skill_offensive_paladins_8) {
                skillPoint--;
                offensiveSkill_8++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(offensiveSkill_8));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_8", offensiveSkill_8);
                editor.apply();
                Offensive8.skillUpdate(offensiveSkill_8, mBinding.skillUpdate, getContext());
            }
        }

        if (offensiveSkill_9 == 20) {
            if (clickId == R.id.skill_offensive_paladins_9) {
                spanned = Html.fromHtml(SkillOffensive.offensiveSkill9_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (offensiveSkill_9 < 20) {
            if (clickId == R.id.skill_offensive_paladins_9) {
                skillPoint--;
                offensiveSkill_9++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(offensiveSkill_9));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_9", offensiveSkill_9);
                editor.apply();
                Offensive9.skillUpdate(offensiveSkill_9, mBinding.skillUpdate, getContext());
            }
        }


        if (offensiveSkill_10 == 20) {
            if (clickId == R.id.skill_offensive_paladins_10) {
                spanned = Html.fromHtml(SkillOffensive.offensiveSkill10_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (offensiveSkill_10 < 20) {
            if (clickId == R.id.skill_offensive_paladins_10) {
                skillPoint--;
                offensiveSkill_10++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(offensiveSkill_10));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_10", offensiveSkill_10);
                editor.apply();
                Offensive10.skillUpdate(offensiveSkill_10, mBinding.skillUpdate, getContext());
            }
        }
        offensiveValue();
    }

    private void hasSkillDown(String imagesSkillNumber, ImageView imagesImageView, TextView minusButton, TextView valueTextView) {
        String skillMessage = "스킬 업데이트를 해주세요";
        int resId = getResources().getIdentifier("skill_offensive_paladins_" + imagesSkillNumber + "_1", "drawable", getContext().getPackageName());
        int clickId = minusButton.getId();

        if (isPremiseSkillDownButton(imagesImageView)) {
            return;
        }

        if (offensiveSkill_1 != 0) {
            if (clickId == R.id.skill_offensive_paladins_1_value_minus) {
                skillPoint++;
                offensiveSkill_1--;
                valueTextView.setText(String.valueOf(offensiveSkill_1));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_1", offensiveSkill_1);
                editor.apply();
                if (offensiveSkill_1 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Offensive1.skillUpdate(offensiveSkill_1, mBinding.skillUpdate, getContext());
            }
        }
        if (offensiveSkill_2 != 0) {
            if (clickId == R.id.skill_offensive_paladins_2_value_minus) {
                skillPoint++;
                offensiveSkill_2--;
                valueTextView.setText(String.valueOf(offensiveSkill_2));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_2", offensiveSkill_2);
                editor.apply();
                if (offensiveSkill_2 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Offensive2.skillUpdate(offensiveSkill_2, mBinding.skillUpdate, getContext());
            }
        }
        if (offensiveSkill_3 != 0) {
            if (clickId == R.id.skill_offensive_paladins_3_value_minus) {
                skillPoint++;
                offensiveSkill_3--;
                valueTextView.setText(String.valueOf(offensiveSkill_3));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_3", offensiveSkill_3);
                editor.apply();
                if (offensiveSkill_3 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Offensive3.skillUpdate(offensiveSkill_3, mBinding.skillUpdate, getContext());
            }
        }
        if (offensiveSkill_4 != 0) {
            if (clickId == R.id.skill_offensive_paladins_4_value_minus) {
                skillPoint++;
                offensiveSkill_4--;
                valueTextView.setText(String.valueOf(offensiveSkill_4));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_4", offensiveSkill_4);
                editor.apply();
                if (offensiveSkill_4 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Offensive4.skillUpdate(offensiveSkill_4, mBinding.skillUpdate, getContext());
            }
        }
        if (offensiveSkill_5 != 0) {
            if (clickId == R.id.skill_offensive_paladins_5_value_minus) {
                skillPoint++;
                offensiveSkill_5--;
                valueTextView.setText(String.valueOf(offensiveSkill_5));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_5", offensiveSkill_5);
                editor.apply();
                if (offensiveSkill_5 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Offensive5.skillUpdate(offensiveSkill_5, mBinding.skillUpdate, getContext());
            }
        }
        if (offensiveSkill_6 != 0) {
            if (clickId == R.id.skill_offensive_paladins_6_value_minus) {
                skillPoint++;
                offensiveSkill_6--;
                valueTextView.setText(String.valueOf(offensiveSkill_6));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_6", offensiveSkill_6);
                editor.apply();
                if (offensiveSkill_6 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Offensive6.skillUpdate(offensiveSkill_6, mBinding.skillUpdate, getContext());
            }
        }
        if (offensiveSkill_7 != 0) {
            if (clickId == R.id.skill_offensive_paladins_7_value_minus) {
                skillPoint++;
                offensiveSkill_7--;
                valueTextView.setText(String.valueOf(offensiveSkill_7));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_7", offensiveSkill_7);
                editor.apply();
                if (offensiveSkill_7 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Offensive7.skillUpdate(offensiveSkill_7, mBinding.skillUpdate, getContext());
            }
        }
        if (offensiveSkill_8 != 0) {
            if (clickId == R.id.skill_offensive_paladins_8_value_minus) {
                skillPoint++;
                offensiveSkill_8--;
                valueTextView.setText(String.valueOf(offensiveSkill_8));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_8", offensiveSkill_8);
                editor.apply();
                if (offensiveSkill_8 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Offensive8.skillUpdate(offensiveSkill_8, mBinding.skillUpdate, getContext());
            }
        }
        if (offensiveSkill_9 != 0) {
            if (clickId == R.id.skill_offensive_paladins_9_value_minus) {
                skillPoint++;
                offensiveSkill_9--;
                valueTextView.setText(String.valueOf(offensiveSkill_9));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_9", offensiveSkill_9);
                editor.apply();
                if (offensiveSkill_9 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Offensive9.skillUpdate(offensiveSkill_9, mBinding.skillUpdate, getContext());
            }
        }
        if (offensiveSkill_10 != 0) {
            if (clickId == R.id.skill_offensive_paladins_10_value_minus) {
                skillPoint++;
                offensiveSkill_10--;
                valueTextView.setText(String.valueOf(offensiveSkill_10));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("offensive_skill_10", offensiveSkill_10);
                editor.apply();
                if (offensiveSkill_10 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Offensive10.skillUpdate(offensiveSkill_10, mBinding.skillUpdate, getContext());
            }
        }
        offensiveValue();
    }

    // 모든 스킬의 스킬 초기화
    private void resetAllSkillPoint() {
        skillPoint = 98 ;
        offensiveSkill_1 = 0;
        offensiveSkill_2 = 0;
        offensiveSkill_3 = 0;
        offensiveSkill_4 = 0;
        offensiveSkill_5 = 0;
        offensiveSkill_6 = 0;
        offensiveSkill_7 = 0;
        offensiveSkill_8 = 0;
        offensiveSkill_9 = 0;
        offensiveSkill_10 = 0;
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

        mBinding.skillOffensivePaladins1.setImageResource(R.drawable.skill_offensive_paladins_1_1);
        mBinding.skillOffensivePaladins2.setImageResource(R.drawable.skill_offensive_paladins_2_1);
        mBinding.skillOffensivePaladins3.setImageResource(R.drawable.skill_offensive_paladins_3_1);
        mBinding.skillOffensivePaladins4.setImageResource(R.drawable.skill_offensive_paladins_4_1);
        mBinding.skillOffensivePaladins5.setImageResource(R.drawable.skill_offensive_paladins_5_1);
        mBinding.skillOffensivePaladins6.setImageResource(R.drawable.skill_offensive_paladins_6_1);
        mBinding.skillOffensivePaladins7.setImageResource(R.drawable.skill_offensive_paladins_7_1);
        mBinding.skillOffensivePaladins8.setImageResource(R.drawable.skill_offensive_paladins_8_1);
        mBinding.skillOffensivePaladins9.setImageResource(R.drawable.skill_offensive_paladins_9_1);
        mBinding.skillOffensivePaladins10.setImageResource(R.drawable.skill_offensive_paladins_10_1);
        mBinding.skillOffensivePaladins1Value.setText("0");
        mBinding.skillOffensivePaladins2Value.setText("0");
        mBinding.skillOffensivePaladins3Value.setText("0");
        mBinding.skillOffensivePaladins4Value.setText("0");
        mBinding.skillOffensivePaladins5Value.setText("0");
        mBinding.skillOffensivePaladins6Value.setText("0");
        mBinding.skillOffensivePaladins7Value.setText("0");
        mBinding.skillOffensivePaladins8Value.setText("0");
        mBinding.skillOffensivePaladins9Value.setText("0");
        mBinding.skillOffensivePaladins10Value.setText("0");
        offensiveValue();
    }

    public void resetSkillPoint() {
        int v1 = sharedPreferences.getInt("defense_skill_1", 0);
        int v2 = sharedPreferences.getInt("defense_skill_2", 0);
        int v3 = sharedPreferences.getInt("defense_skill_3", 0);
        int v4 = sharedPreferences.getInt("defense_skill_4", 0);
        int v5 = sharedPreferences.getInt("defense_skill_5", 0);
        int v6 = sharedPreferences.getInt("defense_skill_6", 0);
        int v7 = sharedPreferences.getInt("defense_skill_7", 0);
        int v8 = sharedPreferences.getInt("defense_skill_8", 0);
        int v9 = sharedPreferences.getInt("defense_skill_9", 0);
        int v10 = sharedPreferences.getInt("defense_skill_10", 0);

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

        System.out.println(value2);
        System.out.println(value1);

        int skill = 98;
        int totalValue = value1 + value2;

        skillPoint = skill - totalValue;

        offensiveSkill_1 = 0;
        offensiveSkill_2 = 0;
        offensiveSkill_3 = 0;
        offensiveSkill_4 = 0;
        offensiveSkill_5 = 0;
        offensiveSkill_6 = 0;
        offensiveSkill_7 = 0;
        offensiveSkill_8 = 0;
        offensiveSkill_9 = 0;
        offensiveSkill_10 = 0;

        editor.putInt(SKILL_POINT_KEY, skillPoint);
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
        editor.apply();
        skillEditor.clear();

        mBinding.skillOffensivePaladins1.setImageResource(R.drawable.skill_offensive_paladins_1_1);
        mBinding.skillOffensivePaladins2.setImageResource(R.drawable.skill_offensive_paladins_2_1);
        mBinding.skillOffensivePaladins3.setImageResource(R.drawable.skill_offensive_paladins_3_1);
        mBinding.skillOffensivePaladins4.setImageResource(R.drawable.skill_offensive_paladins_4_1);
        mBinding.skillOffensivePaladins5.setImageResource(R.drawable.skill_offensive_paladins_5_1);
        mBinding.skillOffensivePaladins6.setImageResource(R.drawable.skill_offensive_paladins_6_1);
        mBinding.skillOffensivePaladins7.setImageResource(R.drawable.skill_offensive_paladins_7_1);
        mBinding.skillOffensivePaladins8.setImageResource(R.drawable.skill_offensive_paladins_8_1);
        mBinding.skillOffensivePaladins9.setImageResource(R.drawable.skill_offensive_paladins_9_1);
        mBinding.skillOffensivePaladins10.setImageResource(R.drawable.skill_offensive_paladins_10_1);
        mBinding.skillOffensivePaladins1Value.setText("0");
        mBinding.skillOffensivePaladins2Value.setText("0");
        mBinding.skillOffensivePaladins3Value.setText("0");
        mBinding.skillOffensivePaladins4Value.setText("0");
        mBinding.skillOffensivePaladins5Value.setText("0");
        mBinding.skillOffensivePaladins6Value.setText("0");
        mBinding.skillOffensivePaladins7Value.setText("0");
        mBinding.skillOffensivePaladins8Value.setText("0");
        mBinding.skillOffensivePaladins9Value.setText("0");
        mBinding.skillOffensivePaladins10Value.setText("0");
        offensiveValue();
    }

    private void offensiveValue() {
        mBinding.tvOffensiveValueView.setText("스킬 포인트 : " + sharedPreferences.getInt(SKILL_POINT_KEY, 98));
        mBinding.tvOffensiveQuest.setText("퀘스트 포인트 : " + sharedPreferences.getInt(SKILL_POINT_QUEST_COMPLETE_KEY, 98));
        mBinding.skillOffensivePaladins1Value.setText(String.valueOf(sharedPreferences.getInt("offensive_skill_1", 0)));
        mBinding.skillOffensivePaladins2Value.setText(String.valueOf(sharedPreferences.getInt("offensive_skill_2", 0)));
        mBinding.skillOffensivePaladins3Value.setText(String.valueOf(sharedPreferences.getInt("offensive_skill_3", 0)));
        mBinding.skillOffensivePaladins4Value.setText(String.valueOf(sharedPreferences.getInt("offensive_skill_4", 0)));
        mBinding.skillOffensivePaladins5Value.setText(String.valueOf(sharedPreferences.getInt("offensive_skill_5", 0)));
        mBinding.skillOffensivePaladins6Value.setText(String.valueOf(sharedPreferences.getInt("offensive_skill_6", 0)));
        mBinding.skillOffensivePaladins7Value.setText(String.valueOf(sharedPreferences.getInt("offensive_skill_7", 0)));
        mBinding.skillOffensivePaladins8Value.setText(String.valueOf(sharedPreferences.getInt("offensive_skill_8", 0)));
        mBinding.skillOffensivePaladins9Value.setText(String.valueOf(sharedPreferences.getInt("offensive_skill_9", 0)));
        mBinding.skillOffensivePaladins10Value.setText(String.valueOf(sharedPreferences.getInt("offensive_skill_10", 0)));
    }

    private void skillImageUpdate() {

        if (sharedPreferences.getInt("offensive_skill_1", 0) != 0) {
            mBinding.skillOffensivePaladins1.setImageResource(R.drawable.skill_offensive_paladins_1_2);
        }

        if (sharedPreferences.getInt("offensive_skill_2", 0) != 0) {
            mBinding.skillOffensivePaladins2.setImageResource(R.drawable.skill_offensive_paladins_2_2);
        }

        if (sharedPreferences.getInt("offensive_skill_3", 0) != 0) {
            mBinding.skillOffensivePaladins3.setImageResource(R.drawable.skill_offensive_paladins_3_2);
        }

        if (sharedPreferences.getInt("offensive_skill_4", 0) != 0) {
            mBinding.skillOffensivePaladins4.setImageResource(R.drawable.skill_offensive_paladins_4_2);
        }

        if (sharedPreferences.getInt("offensive_skill_5", 0) != 0) {
            mBinding.skillOffensivePaladins5.setImageResource(R.drawable.skill_offensive_paladins_5_2);
        }

        if (sharedPreferences.getInt("offensive_skill_6", 0) != 0) {
            mBinding.skillOffensivePaladins6.setImageResource(R.drawable.skill_offensive_paladins_6_2);
        }

        if (sharedPreferences.getInt("offensive_skill_7", 0) != 0) {
            mBinding.skillOffensivePaladins7.setImageResource(R.drawable.skill_offensive_paladins_7_2);
        }

        if (sharedPreferences.getInt("offensive_skill_8", 0) != 0) {
            mBinding.skillOffensivePaladins8.setImageResource(R.drawable.skill_offensive_paladins_8_2);
        }

        if (sharedPreferences.getInt("offensive_skill_9", 0) != 0) {
            mBinding.skillOffensivePaladins9.setImageResource(R.drawable.skill_offensive_paladins_9_2);
        }

        if (sharedPreferences.getInt("offensive_skill_10", 0) != 0) {
            mBinding.skillOffensivePaladins10.setImageResource(R.drawable.skill_offensive_paladins_10_2);
        }
    }

    private boolean isPremiseSkillUpButton(ImageView skillUp) {
        int id = skillUp.getId();
        String str1 = "위세";
        String str2 = "위세, 신성한 불꽃";
        String str3 = "위세, 신성한 불꽃, 신성한 충격";
        String str4 = "위세, 축복밭은 조준";
        String str5 = "위세, 축복밭은 조준, 집중";
        String str6 = "위세, 신성한 불꽃, 신성한 빙결, 가시";
        String str7 = "위세, 신성한 불꽃, 신성한 빙결, 가시, 성역";

        if (id == R.id.skill_offensive_paladins_8) {
            if (offensiveSkill_3 != 0 && offensiveSkill_1 != 0 && offensiveSkill_2 != 0 && offensiveSkill_6 != 0) {
                return false;
            } else {
                messagePremiseSkill = getSkillName(str6);
                return true;
            }
        }

        if (id == R.id.skill_offensive_paladins_10) {
            if (offensiveSkill_3 != 0 && offensiveSkill_1 != 0 && offensiveSkill_2 != 0 && offensiveSkill_6 != 0 && offensiveSkill_8 != 0) {
                return false;
            } else {
                messagePremiseSkill = getSkillName(str7);
                return true;
            }
        }

        if (id == R.id.skill_offensive_paladins_9) {
            if (offensiveSkill_1 != 0 && offensiveSkill_4 != 0 && offensiveSkill_5 != 0) {
                return false;
            } else {
                messagePremiseSkill = getSkillName(str5);
                return true;
            }
        }

        if (id == R.id.skill_offensive_paladins_4 || id == R.id.skill_offensive_paladins_2) {
            if (offensiveSkill_1 != 0) {
                return false;
            } else {
                messagePremiseSkill = getSkillName(str1);
                return true;
            }
        }

        if (id == R.id.skill_offensive_paladins_5) {
            if (offensiveSkill_1 != 0 && offensiveSkill_4 != 0) {
                return false;
            } else {
                messagePremiseSkill = getSkillName(str4);
                return true;
            }
        }

        if (id == R.id.skill_offensive_paladins_6) {
            if (offensiveSkill_1 != 0 && offensiveSkill_2 != 0) {
                return false;
            } else {
                messagePremiseSkill = getSkillName(str2);
                return true;
            }
        }

        if (id == R.id.skill_offensive_paladins_7) {
            if (offensiveSkill_1 != 0 && offensiveSkill_2 != 0 && offensiveSkill_6 != 0) {
                return false;
            } else {
                messagePremiseSkill = getSkillName(str3);
                return true;
            }
        }

        return false;
    }

    private boolean isPremiseSkillDownButton(ImageView skillDown) {
        int id = skillDown.getId();

        if (id == R.id.skill_offensive_paladins_1) {
            if (offensiveSkill_4 >= 1 && offensiveSkill_1 <= 1 || offensiveSkill_2 >= 1 && offensiveSkill_1 <= 1) {
                return true;
            } else {
                return false;
            }
        }

        if (id == R.id.skill_offensive_paladins_2) {
            if (offensiveSkill_6 >= 1 && offensiveSkill_2 <= 1) {
                return true;
            } else {
                return false;
            }
        }

        if (id == R.id.skill_offensive_paladins_3) {
            if (offensiveSkill_8 >= 1 && offensiveSkill_3 <= 1) {
                return true;
            } else {
                return false;
            }
        }


        if (id == R.id.skill_offensive_paladins_4) {
            if (offensiveSkill_5 >= 1 && offensiveSkill_4 <= 1) {
                return true;
            } else {
                return false;
            }
        }

        if (id == R.id.skill_offensive_paladins_5) {
            if (offensiveSkill_9 >= 1 && offensiveSkill_5 <= 1) {
                return true;
            } else {
                return false;
            }
        }

        if (id == R.id.skill_offensive_paladins_6) {
            if (offensiveSkill_8 >= 1 && offensiveSkill_6 <= 1 || offensiveSkill_7 >= 1 && offensiveSkill_6 <= 1) {
                return true;
            } else {
                return false;
            }
        }

        // 눌러지면 안되는 버튼
        if (id == R.id.skill_offensive_paladins_8) {
            // 밑에 스킬이 1이라도 있으면,    위에 스킬이 1 밑으로 안내려가게.
            if (offensiveSkill_10 >= 1 && offensiveSkill_8 <= 1) {
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