package com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.assassin;

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
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.martial.Martial1;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.martial.Martial10;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.martial.Martial2;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.martial.Martial3;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.martial.Martial4;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.martial.Martial5;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.martial.Martial6;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.martial.Martial7;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.martial.Martial8;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.martial.Martial9;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.martial.SkillMartial;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentMartialBinding;

public class Martial extends Fragment {

    private FragmentMartialBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    public int skillPoint;
    private int skillQuestCompletePoint;
    private final String SKILL_POINT_KEY = "skillPoint_assassin";
    private final String SKILL_POINT_QUEST_COMPLETE_KEY = "skillQuestCompletePoint_assassin";
    private final String[] SKILL_TABLE_ARRAY_1 = {"traps_skill_1", "traps_skill_2", "traps_skill_3", "traps_skill_4", "traps_skill_5", "traps_skill_6", "traps_skill_7", "traps_skill_8", "traps_skill_9", "traps_skill_10"};
    private final String[] SKILL_TABLE_ARRAY_2 = {"shadow_skill_1", "shadow_skill_2", "shadow_skill_3", "shadow_skill_4", "shadow_skill_5", "shadow_skill_6", "shadow_skill_7", "shadow_skill_8", "shadow_skill_9", "shadow_skill_10"};
    private final String[] SKILL_TABLE_ARRAY_3 = {"martial_skill_1", "martial_skill_2", "martial_skill_3", "martial_skill_4", "martial_skill_5", "martial_skill_6", "martial_skill_7", "martial_skill_8", "martial_skill_9", "martial_skill_10"};
    public int martialSkill_1;
    public int martialSkill_2;
    public int martialSkill_3;
    public int martialSkill_4;
    public int martialSkill_5;
    public int martialSkill_6;
    public int martialSkill_7;
    public int martialSkill_8;
    public int martialSkill_9;
    public int martialSkill_10;
    private String messagePremiseSkill = null;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentMartialBinding.inflate(inflater, container, false);

        sharedPreferences = getContext().getSharedPreferences("assassin_point", MODE_PRIVATE);
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

        if (!sharedPreferences.contains("martial_skill_1")) {
            editor.putInt("martial_skill_1", 0);
        } else {
            martialSkill_1 = sharedPreferences.getInt("martial_skill_1", 0);
        }

        if (!sharedPreferences.contains("martial_skill_2")) {
            editor.putInt("martial_skill_2", 0);
        } else {
            martialSkill_2 = sharedPreferences.getInt("martial_skill_2", 0);
        }

        if (!sharedPreferences.contains("martial_skill_3")) {
            editor.putInt("martial_skill_3", 0);
        } else {
            martialSkill_3 = sharedPreferences.getInt("martial_skill_3", 0);
        }

        if (!sharedPreferences.contains("martial_skill_4")) {
            editor.putInt("martial_skill_4", 0);
        } else {
            martialSkill_4 = sharedPreferences.getInt("martial_skill_4", 0);
        }

        if (!sharedPreferences.contains("martial_skill_5")) {
            editor.putInt("martial_skill_5", 0);
        } else {
            martialSkill_5 = sharedPreferences.getInt("martial_skill_5", 0);
        }

        if (!sharedPreferences.contains("martial_skill_6")) {
            editor.putInt("martial_skill_6", 0);
        } else {
            martialSkill_6 = sharedPreferences.getInt("martial_skill_6", 0);
        }

        if (!sharedPreferences.contains("martial_skill_7")) {
            editor.putInt("martial_skill_7", 0);
        } else {
            martialSkill_7 = sharedPreferences.getInt("martial_skill_7", 0);
        }

        if (!sharedPreferences.contains("martial_skill_8")) {
            editor.putInt("martial_skill_8", 0);
        } else {
            martialSkill_8 = sharedPreferences.getInt("martial_skill_8", 0);
        }
        if (!sharedPreferences.contains("martial_skill_9")) {
            editor.putInt("martial_skill_9", 0);
        } else {
            martialSkill_9 = sharedPreferences.getInt("martial_skill_9", 0);
        }

        if (!sharedPreferences.contains("martial_skill_10")) {
            editor.putInt("martial_skill_10", 0);
        } else {
            martialSkill_10 = sharedPreferences.getInt("martial_skill_10", 0);
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
                if ("martial_skill_1".equals(key)) {
                    martialSkill_1 = sharedPreferences.getInt("martial_skill_1", 0);
                }
                if ("martial_skill_2".equals(key)) {
                    martialSkill_2 = sharedPreferences.getInt("martial_skill_2", 0);
                }
                if ("martial_skill_3".equals(key)) {
                    martialSkill_3 = sharedPreferences.getInt("martial_skill_3", 0);
                }
                if ("martial_skill_4".equals(key)) {
                    martialSkill_4 = sharedPreferences.getInt("martial_skill_4", 0);
                }
                if ("martial_skill_5".equals(key)) {
                    martialSkill_5 = sharedPreferences.getInt("martial_skill_5", 0);
                }
                if ("martial_skill_6".equals(key)) {
                    martialSkill_6 = sharedPreferences.getInt("martial_skill_6", 0);
                }
                if ("martial_skill_7".equals(key)) {
                    martialSkill_7 = sharedPreferences.getInt("martial_skill_7", 0);
                }
                if ("martial_skill_8".equals(key)) {
                    martialSkill_8 = sharedPreferences.getInt("martial_skill_8", 0);
                }
                if ("martial_skill_9".equals(key)) {
                    martialSkill_9 = sharedPreferences.getInt("martial_skill_9", 0);
                }
                if ("martial_skill_10".equals(key)) {
                    martialSkill_10 = sharedPreferences.getInt("martial_skill_10", 0);
                }

            }
        });

        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);

        editor.apply();
        martialValue();

        skillImageUpdate();

        mBinding.skillClear.setOnClickListener(v -> resetSkillPoint());
        mBinding.tvAllSkillReset.setOnClickListener(v -> resetAllSkillPoint());

        mBinding.skillMartialAssassin1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_martial_assassin_1_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillMartial.martialSkill1, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillMartialAssassin2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_martial_assassin_2_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillMartial.martialSkill2, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillMartialAssassin3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_martial_assassin_3_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillMartial.martialSkill3, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillMartialAssassin4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_martial_assassin_4_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillMartial.martialSkill4, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillMartialAssassin5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_martial_assassin_5_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillMartial.martialSkill5, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillMartialAssassin6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_martial_assassin_6_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillMartial.martialSkill6, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillMartialAssassin7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_martial_assassin_7_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillMartial.martialSkill7, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillMartialAssassin8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_martial_assassin_8_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillMartial.martialSkill8, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillMartialAssassin9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_martial_assassin_9_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillMartial.martialSkill9, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillMartialAssassin10.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = getResources().getIdentifier("skill_martial_assassin_10_2", "drawable", getContext().getPackageName());
                Spanned spanned = Html.fromHtml(SkillMartial.martialSkill10, Html.FROM_HTML_MODE_LEGACY);
                skillPreviewDialog(spanned, id);
                return true;
            }
        });

        mBinding.skillMartialAssassin1.setOnClickListener(v -> hasSkillUp("1", mBinding.skillMartialAssassin1, mBinding.skillMartialAssassin1Value));
        mBinding.skillMartialAssassin2.setOnClickListener(v -> hasSkillUp("2", mBinding.skillMartialAssassin2, mBinding.skillMartialAssassin2Value));
        mBinding.skillMartialAssassin3.setOnClickListener(v -> hasSkillUp("3", mBinding.skillMartialAssassin3, mBinding.skillMartialAssassin3Value));
        mBinding.skillMartialAssassin4.setOnClickListener(v -> hasSkillUp("4", mBinding.skillMartialAssassin4, mBinding.skillMartialAssassin4Value));
        mBinding.skillMartialAssassin5.setOnClickListener(v -> hasSkillUp("5", mBinding.skillMartialAssassin5, mBinding.skillMartialAssassin5Value));
        mBinding.skillMartialAssassin6.setOnClickListener(v -> hasSkillUp("6", mBinding.skillMartialAssassin6, mBinding.skillMartialAssassin6Value));
        mBinding.skillMartialAssassin7.setOnClickListener(v -> hasSkillUp("7", mBinding.skillMartialAssassin7, mBinding.skillMartialAssassin7Value));
        mBinding.skillMartialAssassin8.setOnClickListener(v -> hasSkillUp("8", mBinding.skillMartialAssassin8, mBinding.skillMartialAssassin8Value));
        mBinding.skillMartialAssassin9.setOnClickListener(v -> hasSkillUp("9", mBinding.skillMartialAssassin9, mBinding.skillMartialAssassin9Value));
        mBinding.skillMartialAssassin10.setOnClickListener(v -> hasSkillUp("10", mBinding.skillMartialAssassin10, mBinding.skillMartialAssassin10Value));

        mBinding.skillMartialAssassin1ValueMinus.setOnClickListener(v -> hasSkillDown("1", mBinding.skillMartialAssassin1, mBinding.skillMartialAssassin1ValueMinus, mBinding.skillMartialAssassin1Value));
        mBinding.skillMartialAssassin2ValueMinus.setOnClickListener(v -> hasSkillDown("2", mBinding.skillMartialAssassin2, mBinding.skillMartialAssassin2ValueMinus, mBinding.skillMartialAssassin2Value));
        mBinding.skillMartialAssassin3ValueMinus.setOnClickListener(v -> hasSkillDown("3", mBinding.skillMartialAssassin3, mBinding.skillMartialAssassin3ValueMinus, mBinding.skillMartialAssassin3Value));
        mBinding.skillMartialAssassin4ValueMinus.setOnClickListener(v -> hasSkillDown("4", mBinding.skillMartialAssassin4, mBinding.skillMartialAssassin4ValueMinus, mBinding.skillMartialAssassin4Value));
        mBinding.skillMartialAssassin5ValueMinus.setOnClickListener(v -> hasSkillDown("5", mBinding.skillMartialAssassin5, mBinding.skillMartialAssassin5ValueMinus, mBinding.skillMartialAssassin5Value));
        mBinding.skillMartialAssassin6ValueMinus.setOnClickListener(v -> hasSkillDown("6", mBinding.skillMartialAssassin6, mBinding.skillMartialAssassin6ValueMinus, mBinding.skillMartialAssassin6Value));
        mBinding.skillMartialAssassin7ValueMinus.setOnClickListener(v -> hasSkillDown("7", mBinding.skillMartialAssassin7, mBinding.skillMartialAssassin7ValueMinus, mBinding.skillMartialAssassin7Value));
        mBinding.skillMartialAssassin8ValueMinus.setOnClickListener(v -> hasSkillDown("8", mBinding.skillMartialAssassin8, mBinding.skillMartialAssassin8ValueMinus, mBinding.skillMartialAssassin8Value));
        mBinding.skillMartialAssassin9ValueMinus.setOnClickListener(v -> hasSkillDown("9", mBinding.skillMartialAssassin9, mBinding.skillMartialAssassin9ValueMinus, mBinding.skillMartialAssassin9Value));
        mBinding.skillMartialAssassin10ValueMinus.setOnClickListener(v -> hasSkillDown("10", mBinding.skillMartialAssassin10, mBinding.skillMartialAssassin10ValueMinus, mBinding.skillMartialAssassin10Value));

        return mBinding.getRoot();
    }


    private void hasSkillUp(String imagesSkillNumber, ImageView imagesImageView, TextView valueTextView) {

        Spanned spanned;
        int resId = getResources().getIdentifier("skill_martial_assassin_" + imagesSkillNumber + "_2", "drawable", getContext().getPackageName());
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

        if (martialSkill_1 == 20) {
            if (clickId == R.id.skill_martial_assassin_1) {
                spanned = Html.fromHtml(SkillMartial.martialSkill1_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
                return;
            }
        }

        if (martialSkill_1 < 20) {
            if (clickId == R.id.skill_martial_assassin_1) {
                skillPoint--;
                martialSkill_1++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(martialSkill_1));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_1", martialSkill_1);
                editor.apply();
                Martial1.skillUpdate(martialSkill_1, mBinding.skillUpdate, getContext());
            }
        }

        if (martialSkill_2 == 20) {
            if (clickId == R.id.skill_martial_assassin_2) {
                spanned = Html.fromHtml(SkillMartial.martialSkill2_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
                return;
            }
        }

        if (martialSkill_2 < 20) {
            if (clickId == R.id.skill_martial_assassin_2) {
                skillPoint--;
                martialSkill_2++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(martialSkill_2));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_2", martialSkill_2);
                editor.apply();
                Martial2.skillUpdate(martialSkill_2, mBinding.skillUpdate, getContext());
            }
        }

        if (martialSkill_3 == 20) {
            if (clickId == R.id.skill_martial_assassin_3) {
                spanned = Html.fromHtml(SkillMartial.martialSkill3_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (martialSkill_3 < 20) {
            if (clickId == R.id.skill_martial_assassin_3) {
                skillPoint--;
                martialSkill_3++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(martialSkill_3));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_3", martialSkill_3);
                editor.apply();
                Martial3.skillUpdate(martialSkill_3, mBinding.skillUpdate, getContext());
            }
        }

        if (martialSkill_4 == 20) {
            if (clickId == R.id.skill_martial_assassin_4) {
                spanned = Html.fromHtml(SkillMartial.martialSkill4_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (martialSkill_4 < 20) {
            if (clickId == R.id.skill_martial_assassin_4) {
                skillPoint--;
                martialSkill_4++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(martialSkill_4));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_4", martialSkill_4);
                editor.apply();
                Martial4.skillUpdate(martialSkill_4, mBinding.skillUpdate, getContext());
            }
        }

        if (martialSkill_5 == 20) {
            if (clickId == R.id.skill_martial_assassin_5) {
                spanned = Html.fromHtml(SkillMartial.martialSkill5_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (martialSkill_5 < 20) {
            if (clickId == R.id.skill_martial_assassin_5) {
                skillPoint--;
                martialSkill_5++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(martialSkill_5));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_5", martialSkill_5);
                editor.apply();
                Martial5.skillUpdate(martialSkill_5, mBinding.skillUpdate, getContext());
            }
        }

        if (martialSkill_6 == 20) {
            if (clickId == R.id.skill_martial_assassin_6) {
                spanned = Html.fromHtml(SkillMartial.martialSkill6_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (martialSkill_6 < 20) {
            if (clickId == R.id.skill_martial_assassin_6) {
                skillPoint--;
                martialSkill_6++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(martialSkill_6));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_6", martialSkill_6);
                editor.apply();
                Martial6.skillUpdate(martialSkill_6, mBinding.skillUpdate, getContext());
            }
        }

        if (martialSkill_7 == 20) {
            if (clickId == R.id.skill_martial_assassin_7) {
                spanned = Html.fromHtml(SkillMartial.martialSkill7_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (martialSkill_7 < 20) {
            if (clickId == R.id.skill_martial_assassin_7) {
                skillPoint--;
                martialSkill_7++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(martialSkill_7));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_7", martialSkill_7);
                editor.apply();
                if (messagePremiseSkill == null) {
                    mBinding.skillUpdate.setText(SkillMartial.martialSkill7);
                }
                Martial7.skillUpdate(martialSkill_7, mBinding.skillUpdate, getContext());
            }
        }


        if (martialSkill_8 == 20) {
            if (clickId == R.id.skill_martial_assassin_8) {
                spanned = Html.fromHtml(SkillMartial.martialSkill8_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (martialSkill_8 < 20) {
            if (clickId == R.id.skill_martial_assassin_8) {
                skillPoint--;
                martialSkill_8++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(martialSkill_8));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_8", martialSkill_8);
                editor.apply();
                Martial8.skillUpdate(martialSkill_8, mBinding.skillUpdate, getContext());
            }
        }

        if (martialSkill_9 == 20) {
            if (clickId == R.id.skill_martial_assassin_9) {
                spanned = Html.fromHtml(SkillMartial.martialSkill9_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (martialSkill_9 < 20) {
            if (clickId == R.id.skill_martial_assassin_9) {
                skillPoint--;
                martialSkill_9++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(martialSkill_9));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_9", martialSkill_9);
                editor.apply();
                Martial9.skillUpdate(martialSkill_9, mBinding.skillUpdate, getContext());
            }
        }


        if (martialSkill_10 == 20) {
            if (clickId == R.id.skill_martial_assassin_10) {
                spanned = Html.fromHtml(SkillMartial.martialSkill10_end, Html.FROM_HTML_MODE_LEGACY);
                mBinding.skillUpdate.setText(spanned);
            }
        }

        if (martialSkill_10 < 20) {
            if (clickId == R.id.skill_martial_assassin_10) {
                skillPoint--;
                martialSkill_10++;
                imagesImageView.setImageResource(resId);
                valueTextView.setText(String.valueOf(martialSkill_10));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_10", martialSkill_10);
                editor.apply();
                Martial10.skillUpdate(martialSkill_10, mBinding.skillUpdate, getContext());
            }
        }
        martialValue();
    }

    private void hasSkillDown(String imagesSkillNumber, ImageView imagesImageView, TextView minusButton, TextView valueTextView) {
        String skillMessage = "스킬 업데이트를 해주세요";
        int resId = getResources().getIdentifier("skill_martial_assassin_" + imagesSkillNumber + "_1", "drawable", getContext().getPackageName());
        int clickId = minusButton.getId();

        if (isPremiseSkillDownButton(imagesImageView, R.id.skill_martial_assassin_1, martialSkill_1, martialSkill_5)
        || isPremiseSkillDownButton(imagesImageView, R.id.skill_martial_assassin_5, martialSkill_5, martialSkill_10)
        || isPremiseSkillDownButton(imagesImageView, R.id.skill_martial_assassin_3, martialSkill_3, martialSkill_6)
        || isPremiseSkillDownButton(imagesImageView, R.id.skill_martial_assassin_6, martialSkill_6, martialSkill_8)
        || isPremiseSkillDownButton(imagesImageView, R.id.skill_martial_assassin_8, martialSkill_8, martialSkill_10)
        || isPremiseSkillDownButton(imagesImageView, R.id.skill_martial_assassin_2, martialSkill_2, martialSkill_4)
        || isPremiseSkillDownButton(imagesImageView, R.id.skill_martial_assassin_4, martialSkill_4, martialSkill_7)
        || isPremiseSkillDownButton(imagesImageView, R.id.skill_martial_assassin_7, martialSkill_7, martialSkill_9)){
            return;
        }

        if (martialSkill_1 != 0) {
            if (clickId == R.id.skill_martial_assassin_1_value_minus) {
                skillPoint++;
                martialSkill_1--;
                valueTextView.setText(String.valueOf(martialSkill_1));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_1", martialSkill_1);
                editor.apply();
                if (martialSkill_1 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Martial1.skillUpdate(martialSkill_1, mBinding.skillUpdate, getContext());
            }
        }
        if (martialSkill_2 != 0) {
            if (clickId == R.id.skill_martial_assassin_2_value_minus) {
                skillPoint++;
                martialSkill_2--;
                valueTextView.setText(String.valueOf(martialSkill_2));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_2", martialSkill_2);
                editor.apply();
                if (martialSkill_2 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Martial2.skillUpdate(martialSkill_2, mBinding.skillUpdate, getContext());
            }
        }
        if (martialSkill_3 != 0) {
            if (clickId == R.id.skill_martial_assassin_3_value_minus) {
                skillPoint++;
                martialSkill_3--;
                valueTextView.setText(String.valueOf(martialSkill_3));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_3", martialSkill_3);
                editor.apply();
                if (martialSkill_3 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Martial3.skillUpdate(martialSkill_3, mBinding.skillUpdate, getContext());
            }
        }
        if (martialSkill_4 != 0) {
            if (clickId == R.id.skill_martial_assassin_4_value_minus) {
                skillPoint++;
                martialSkill_4--;
                valueTextView.setText(String.valueOf(martialSkill_4));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_4", martialSkill_4);
                editor.apply();
                if (martialSkill_4 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Martial4.skillUpdate(martialSkill_4, mBinding.skillUpdate, getContext());
            }
        }
        if (martialSkill_5 != 0) {
            if (clickId == R.id.skill_martial_assassin_5_value_minus) {
                skillPoint++;
                martialSkill_5--;
                valueTextView.setText(String.valueOf(martialSkill_5));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_5", martialSkill_5);
                editor.apply();
                if (martialSkill_5 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Martial5.skillUpdate(martialSkill_5, mBinding.skillUpdate, getContext());
            }
        }
        if (martialSkill_6 != 0) {
            if (clickId == R.id.skill_martial_assassin_6_value_minus) {
                skillPoint++;
                martialSkill_6--;
                valueTextView.setText(String.valueOf(martialSkill_6));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_6", martialSkill_6);
                editor.apply();
                if (martialSkill_6 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Martial6.skillUpdate(martialSkill_6, mBinding.skillUpdate, getContext());
            }
        }
        if (martialSkill_7 != 0) {
            if (clickId == R.id.skill_martial_assassin_7_value_minus) {
                skillPoint++;
                martialSkill_7--;
                valueTextView.setText(String.valueOf(martialSkill_7));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_7", martialSkill_7);
                editor.apply();
                if (martialSkill_7 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Martial7.skillUpdate(martialSkill_7, mBinding.skillUpdate, getContext());
            }
        }
        if (martialSkill_8 != 0) {
            if (clickId == R.id.skill_martial_assassin_8_value_minus) {
                skillPoint++;
                martialSkill_8--;
                valueTextView.setText(String.valueOf(martialSkill_8));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_8", martialSkill_8);
                editor.apply();
                if (martialSkill_8 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Martial8.skillUpdate(martialSkill_8, mBinding.skillUpdate, getContext());
            }
        }
        if (martialSkill_9 != 0) {
            if (clickId == R.id.skill_martial_assassin_9_value_minus) {
                skillPoint++;
                martialSkill_9--;
                valueTextView.setText(String.valueOf(martialSkill_9));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_9", martialSkill_9);
                editor.apply();
                if (martialSkill_9 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Martial9.skillUpdate(martialSkill_9, mBinding.skillUpdate, getContext());
            }
        }
        if (martialSkill_10 != 0) {
            if (clickId == R.id.skill_martial_assassin_10_value_minus) {
                skillPoint++;
                martialSkill_10--;
                valueTextView.setText(String.valueOf(martialSkill_10));
                editor.putInt(SKILL_POINT_KEY, skillPoint);
                editor.putInt("martial_skill_10", martialSkill_10);
                editor.apply();
                if (martialSkill_10 == 0) {
                    imagesImageView.setImageResource(resId);
                    mBinding.skillUpdate.setText(skillMessage);
                }
                Martial10.skillUpdate(martialSkill_10, mBinding.skillUpdate, getContext());
            }
        }
        martialValue();
    }

    // 모든 스킬의 스킬 초기화
    private void resetAllSkillPoint() {
        skillPoint = 98 ;
        martialSkill_1 = 0;
        martialSkill_2 = 0;
        martialSkill_3 = 0;
        martialSkill_4 = 0;
        martialSkill_5 = 0;
        martialSkill_6 = 0;
        martialSkill_7 = 0;
        martialSkill_8 = 0;
        martialSkill_9 = 0;
        martialSkill_10 = 0;
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
        editor.putInt("martial_skill_1", 0);
        editor.putInt("martial_skill_2", 0);
        editor.putInt("martial_skill_3", 0);
        editor.putInt("martial_skill_4", 0);
        editor.putInt("martial_skill_5", 0);
        editor.putInt("martial_skill_6", 0);
        editor.putInt("martial_skill_7", 0);
        editor.putInt("martial_skill_8", 0);
        editor.putInt("martial_skill_9", 0);
        editor.putInt("martial_skill_10", 0);
        editor.commit();

        mBinding.skillMartialAssassin1.setImageResource(R.drawable.skill_martial_assassin_1_1);
        mBinding.skillMartialAssassin2.setImageResource(R.drawable.skill_martial_assassin_2_1);
        mBinding.skillMartialAssassin3.setImageResource(R.drawable.skill_martial_assassin_3_1);
        mBinding.skillMartialAssassin4.setImageResource(R.drawable.skill_martial_assassin_4_1);
        mBinding.skillMartialAssassin5.setImageResource(R.drawable.skill_martial_assassin_5_1);
        mBinding.skillMartialAssassin6.setImageResource(R.drawable.skill_martial_assassin_6_1);
        mBinding.skillMartialAssassin7.setImageResource(R.drawable.skill_martial_assassin_7_1);
        mBinding.skillMartialAssassin8.setImageResource(R.drawable.skill_martial_assassin_8_1);
        mBinding.skillMartialAssassin9.setImageResource(R.drawable.skill_martial_assassin_9_1);
        mBinding.skillMartialAssassin10.setImageResource(R.drawable.skill_martial_assassin_10_1);
        mBinding.skillMartialAssassin1Value.setText("0");
        mBinding.skillMartialAssassin2Value.setText("0");
        mBinding.skillMartialAssassin3Value.setText("0");
        mBinding.skillMartialAssassin4Value.setText("0");
        mBinding.skillMartialAssassin5Value.setText("0");
        mBinding.skillMartialAssassin6Value.setText("0");
        mBinding.skillMartialAssassin7Value.setText("0");
        mBinding.skillMartialAssassin8Value.setText("0");
        mBinding.skillMartialAssassin9Value.setText("0");
        mBinding.skillMartialAssassin10Value.setText("0");
        martialValue();
    }

    public void resetSkillPoint() {
        int v1 = sharedPreferences.getInt("shadow_skill_1", 0);
        int v2 = sharedPreferences.getInt("shadow_skill_2", 0);
        int v3 = sharedPreferences.getInt("shadow_skill_3", 0);
        int v4 = sharedPreferences.getInt("shadow_skill_4", 0);
        int v5 = sharedPreferences.getInt("shadow_skill_5", 0);
        int v6 = sharedPreferences.getInt("shadow_skill_6", 0);
        int v7 = sharedPreferences.getInt("shadow_skill_7", 0);
        int v8 = sharedPreferences.getInt("shadow_skill_8", 0);
        int v9 = sharedPreferences.getInt("shadow_skill_9", 0);
        int v10 = sharedPreferences.getInt("shadow_skill_10", 0);

        int b1 = sharedPreferences.getInt("traps_skill_1", 0);
        int b2 = sharedPreferences.getInt("traps_skill_2", 0);
        int b3 = sharedPreferences.getInt("traps_skill_3", 0);
        int b4 = sharedPreferences.getInt("traps_skill_4", 0);
        int b5 = sharedPreferences.getInt("traps_skill_5", 0);
        int b6 = sharedPreferences.getInt("traps_skill_6", 0);
        int b7 = sharedPreferences.getInt("traps_skill_7", 0);
        int b8 = sharedPreferences.getInt("traps_skill_8", 0);
        int b9 = sharedPreferences.getInt("traps_skill_9", 0);
        int b10 = sharedPreferences.getInt("traps_skill_10", 0);

        int value1 = b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9 + b10;
        int value2 = v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9 + v10;

        System.out.println(value2);
        System.out.println(value1);

        int skill = 98;
        int totalValue = value1 + value2;

        skillPoint = skill - totalValue;

        martialSkill_1 = 0;
        martialSkill_2 = 0;
        martialSkill_3 = 0;
        martialSkill_4 = 0;
        martialSkill_5 = 0;
        martialSkill_6 = 0;
        martialSkill_7 = 0;
        martialSkill_8 = 0;
        martialSkill_9 = 0;
        martialSkill_10 = 0;

        editor.putInt(SKILL_POINT_KEY, skillPoint);
        editor.putInt("martial_skill_1", 0);
        editor.putInt("martial_skill_2", 0);
        editor.putInt("martial_skill_3", 0);
        editor.putInt("martial_skill_4", 0);
        editor.putInt("martial_skill_5", 0);
        editor.putInt("martial_skill_6", 0);
        editor.putInt("martial_skill_7", 0);
        editor.putInt("martial_skill_8", 0);
        editor.putInt("martial_skill_9", 0);
        editor.putInt("martial_skill_10", 0);
        editor.apply();

        mBinding.skillMartialAssassin1.setImageResource(R.drawable.skill_martial_assassin_1_1);
        mBinding.skillMartialAssassin2.setImageResource(R.drawable.skill_martial_assassin_2_1);
        mBinding.skillMartialAssassin3.setImageResource(R.drawable.skill_martial_assassin_3_1);
        mBinding.skillMartialAssassin4.setImageResource(R.drawable.skill_martial_assassin_4_1);
        mBinding.skillMartialAssassin5.setImageResource(R.drawable.skill_martial_assassin_5_1);
        mBinding.skillMartialAssassin6.setImageResource(R.drawable.skill_martial_assassin_6_1);
        mBinding.skillMartialAssassin7.setImageResource(R.drawable.skill_martial_assassin_7_1);
        mBinding.skillMartialAssassin8.setImageResource(R.drawable.skill_martial_assassin_8_1);
        mBinding.skillMartialAssassin9.setImageResource(R.drawable.skill_martial_assassin_9_1);
        mBinding.skillMartialAssassin10.setImageResource(R.drawable.skill_martial_assassin_10_1);
        mBinding.skillMartialAssassin1Value.setText("0");
        mBinding.skillMartialAssassin2Value.setText("0");
        mBinding.skillMartialAssassin3Value.setText("0");
        mBinding.skillMartialAssassin4Value.setText("0");
        mBinding.skillMartialAssassin5Value.setText("0");
        mBinding.skillMartialAssassin6Value.setText("0");
        mBinding.skillMartialAssassin7Value.setText("0");
        mBinding.skillMartialAssassin8Value.setText("0");
        mBinding.skillMartialAssassin9Value.setText("0");
        mBinding.skillMartialAssassin10Value.setText("0");
        martialValue();
    }

    private void martialValue() {
        mBinding.tvMartialValueView.setText("스킬 포인트 : " + sharedPreferences.getInt(SKILL_POINT_KEY, 98));
        mBinding.tvMartialQuest.setText("퀘스트 포인트 : " + sharedPreferences.getInt(SKILL_POINT_QUEST_COMPLETE_KEY, 98));
        mBinding.skillMartialAssassin1Value.setText(String.valueOf(sharedPreferences.getInt("martial_skill_1", 0)));
        mBinding.skillMartialAssassin2Value.setText(String.valueOf(sharedPreferences.getInt("martial_skill_2", 0)));
        mBinding.skillMartialAssassin3Value.setText(String.valueOf(sharedPreferences.getInt("martial_skill_3", 0)));
        mBinding.skillMartialAssassin4Value.setText(String.valueOf(sharedPreferences.getInt("martial_skill_4", 0)));
        mBinding.skillMartialAssassin5Value.setText(String.valueOf(sharedPreferences.getInt("martial_skill_5", 0)));
        mBinding.skillMartialAssassin6Value.setText(String.valueOf(sharedPreferences.getInt("martial_skill_6", 0)));
        mBinding.skillMartialAssassin7Value.setText(String.valueOf(sharedPreferences.getInt("martial_skill_7", 0)));
        mBinding.skillMartialAssassin8Value.setText(String.valueOf(sharedPreferences.getInt("martial_skill_8", 0)));
        mBinding.skillMartialAssassin9Value.setText(String.valueOf(sharedPreferences.getInt("martial_skill_9", 0)));
        mBinding.skillMartialAssassin10Value.setText(String.valueOf(sharedPreferences.getInt("martial_skill_10", 0)));
    }

    private void skillImageUpdate() {

        if (sharedPreferences.getInt("martial_skill_1", 0) != 0) {
            mBinding.skillMartialAssassin1.setImageResource(R.drawable.skill_martial_assassin_1_2);
        }

        if (sharedPreferences.getInt("martial_skill_2", 0) != 0) {
            mBinding.skillMartialAssassin2.setImageResource(R.drawable.skill_martial_assassin_2_2);
        }

        if (sharedPreferences.getInt("martial_skill_3", 0) != 0) {
            mBinding.skillMartialAssassin3.setImageResource(R.drawable.skill_martial_assassin_3_2);
        }

        if (sharedPreferences.getInt("martial_skill_4", 0) != 0) {
            mBinding.skillMartialAssassin4.setImageResource(R.drawable.skill_martial_assassin_4_2);
        }

        if (sharedPreferences.getInt("martial_skill_5", 0) != 0) {
            mBinding.skillMartialAssassin5.setImageResource(R.drawable.skill_martial_assassin_5_2);
        }

        if (sharedPreferences.getInt("martial_skill_6", 0) != 0) {
            mBinding.skillMartialAssassin6.setImageResource(R.drawable.skill_martial_assassin_6_2);
        }

        if (sharedPreferences.getInt("martial_skill_7", 0) != 0) {
            mBinding.skillMartialAssassin7.setImageResource(R.drawable.skill_martial_assassin_7_2);
        }

        if (sharedPreferences.getInt("martial_skill_8", 0) != 0) {
            mBinding.skillMartialAssassin8.setImageResource(R.drawable.skill_martial_assassin_8_2);
        }

        if (sharedPreferences.getInt("martial_skill_9", 0) != 0) {
            mBinding.skillMartialAssassin9.setImageResource(R.drawable.skill_martial_assassin_9_2);
        }

        if (sharedPreferences.getInt("martial_skill_10", 0) != 0) {
            mBinding.skillMartialAssassin10.setImageResource(R.drawable.skill_martial_assassin_10_2);
        }
    }

    private boolean isPremiseSkillUpButton(ImageView skillUp) {
        int id = skillUp.getId();
        String str = "선행 스킬을 먼저 선택해주세요.";

        if (id == R.id.skill_martial_assassin_8) {
            if (martialSkill_6 != 0) {
                return false;
            } else {
                messagePremiseSkill = getSkillName(str);
                return true;
            }
        }

        if (id == R.id.skill_martial_assassin_6) {
            if (martialSkill_3 != 0) {
                return false;
            } else {
                messagePremiseSkill = getSkillName(str);
                return true;
            }
        }

        if (id == R.id.skill_martial_assassin_5) {
            if (martialSkill_1 != 0) {
                return false;
            } else {
                messagePremiseSkill = getSkillName(str);
                return true;
            }
        }

        if (id == R.id.skill_martial_assassin_10) {
            if (martialSkill_5 != 0 && martialSkill_8 != 0) {
                return false;
            } else {
                messagePremiseSkill = getSkillName(str);
                return true;
            }
        }

        if (id == R.id.skill_martial_assassin_4) {
            if (martialSkill_2 != 0) {
                return false;
            } else {
                messagePremiseSkill = getSkillName(str);
                return true;
            }
        }

        if (id == R.id.skill_martial_assassin_7) {
            if (martialSkill_4 != 0) {
                return false;
            } else {
                messagePremiseSkill = getSkillName(str);
                return true;
            }
        }

        if (id == R.id.skill_martial_assassin_9) {
            if (martialSkill_7 != 0) {
                return false;
            } else {
                messagePremiseSkill = getSkillName(str);
                return true;
            }
        }


        return false;
    }

    private boolean isPremiseSkillDownButton (ImageView skillDown, int buttonId, int buttonSkill, int downSkill){
        // 눌러지면 안되는 버튼
        int id = skillDown.getId();
        boolean i = false;
        if (id == buttonId) {
            // 밑에 스킬이 1이라도 있으면,    위에 스킬이 1 밑으로 안내려가게.
            if (downSkill >= 1 && buttonSkill <= 1) {
                i = true;
            } else {
                i = false;
            }
        }
        return i;
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