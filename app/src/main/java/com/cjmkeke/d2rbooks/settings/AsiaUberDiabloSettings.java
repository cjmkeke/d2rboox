package com.cjmkeke.d2rbooks.settings;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivityAsiaUberDiabloSettingsBinding;

public class AsiaUberDiabloSettings extends AppCompatActivity {

    private static final String TAG = "UberDiabloSettings";
    private ActivityAsiaUberDiabloSettingsBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    private SharedPreferences uberSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fontSharedPreferences = getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);

        uberSharedPreferences = getSharedPreferences(SharedValue.UBER_DIABLO_SETTINGS, MODE_PRIVATE);
        SharedPreferences.Editor uberEditor = uberSharedPreferences.edit();

        mBinding = ActivityAsiaUberDiabloSettingsBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        int color = android.R.color.transparent;
        mBinding.cbLadderHardcore3.setChecked(uberSharedPreferences.getBoolean(SharedValue.LADDER_HARD_CORE_3, false));
        mBinding.cbLadderHardcore3.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.cbLadderHardcore3.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));
        mBinding.cbLadderHardcore3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applySettings(isChecked, uberEditor, SharedValue.LADDER_HARD_CORE_3);
            }
        });

        mBinding.cbLadderHardcore4.setChecked(uberSharedPreferences.getBoolean(SharedValue.LADDER_HARD_CORE_4, false));
        mBinding.cbLadderHardcore4.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.cbLadderHardcore4.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));
        mBinding.cbLadderHardcore4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applySettings(isChecked, uberEditor, SharedValue.LADDER_HARD_CORE_4);
            }
        });

        mBinding.cbLadderHardcore5.setChecked(uberSharedPreferences.getBoolean(SharedValue.LADDER_HARD_CORE_5, false));
        mBinding.cbLadderHardcore5.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.cbLadderHardcore5.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));
        mBinding.cbLadderHardcore5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applySettings(isChecked, uberEditor, SharedValue.LADDER_HARD_CORE_5);
            }
        });

        mBinding.cbLadderHardcore6.setChecked(uberSharedPreferences.getBoolean(SharedValue.LADDER_HARD_CORE_6, false));
        mBinding.cbLadderHardcore6.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.cbLadderHardcore6.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));
        mBinding.cbLadderHardcore6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applySettings(isChecked, uberEditor, SharedValue.LADDER_HARD_CORE_6);
            }
        });

        mBinding.cbLadderSoftcore3.setChecked(uberSharedPreferences.getBoolean(SharedValue.LADDER_SOFT_CORE_3, false));
        mBinding.cbLadderSoftcore3.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.cbLadderSoftcore3.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));
        mBinding.cbLadderSoftcore3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applySettings(isChecked, uberEditor, SharedValue.LADDER_SOFT_CORE_3);
            }
        });

        mBinding.cbLadderSoftcore4.setChecked(uberSharedPreferences.getBoolean(SharedValue.LADDER_SOFT_CORE_4, false));
        mBinding.cbLadderSoftcore4.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.cbLadderSoftcore4.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));
        mBinding.cbLadderSoftcore4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applySettings(isChecked, uberEditor, SharedValue.LADDER_SOFT_CORE_4);
            }
        });

        mBinding.cbLadderSoftcore5.setChecked(uberSharedPreferences.getBoolean(SharedValue.LADDER_SOFT_CORE_5, false));
        mBinding.cbLadderSoftcore5.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.cbLadderSoftcore5.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));
        mBinding.cbLadderSoftcore5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applySettings(isChecked, uberEditor, SharedValue.LADDER_SOFT_CORE_5);
            }
        });

        mBinding.cbLadderSoftcore6.setChecked(uberSharedPreferences.getBoolean(SharedValue.LADDER_SOFT_CORE_6, false));
        mBinding.cbLadderSoftcore6.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.cbLadderSoftcore6.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));
        mBinding.cbLadderSoftcore6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applySettings(isChecked, uberEditor, SharedValue.LADDER_SOFT_CORE_6);
            }
        });

        mBinding.cbNoneLadderHardcore3.setChecked(uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_HARD_CORE_3, false));
        mBinding.cbNoneLadderHardcore3.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.cbNoneLadderHardcore3.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));
        mBinding.cbNoneLadderHardcore3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applySettings(isChecked, uberEditor, SharedValue.NONE_LADDER_HARD_CORE_3);
            }
        });

        mBinding.cbNoneLadderHardcore4.setChecked(uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_HARD_CORE_4, false));
        mBinding.cbNoneLadderHardcore4.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.cbNoneLadderHardcore4.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));
        mBinding.cbNoneLadderHardcore4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applySettings(isChecked, uberEditor, SharedValue.NONE_LADDER_HARD_CORE_4);
            }
        });

        mBinding.cbNoneLadderHardcore5.setChecked(uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_HARD_CORE_5, false));
        mBinding.cbNoneLadderHardcore5.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.cbNoneLadderHardcore5.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));
        mBinding.cbNoneLadderHardcore5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applySettings(isChecked, uberEditor, SharedValue.NONE_LADDER_HARD_CORE_5);
            }
        });

        mBinding.cbNoneLadderHardcore6.setChecked(uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_HARD_CORE_6, false));
        mBinding.cbNoneLadderHardcore6.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.cbNoneLadderHardcore6.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));
        mBinding.cbNoneLadderHardcore6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applySettings(isChecked, uberEditor, SharedValue.NONE_LADDER_HARD_CORE_6);
            }
        });

        mBinding.cbNoneLadderSoftcore3.setChecked(uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_SOFT_CORE_3, false));
        mBinding.cbNoneLadderSoftcore3.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.cbNoneLadderSoftcore3.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));
        mBinding.cbNoneLadderSoftcore3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applySettings(isChecked, uberEditor, SharedValue.NONE_LADDER_SOFT_CORE_3);
            }
        });

        mBinding.cbNoneLadderSoftcore4.setChecked(uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_SOFT_CORE_4, false));
        mBinding.cbNoneLadderSoftcore4.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.cbNoneLadderSoftcore4.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));
        mBinding.cbNoneLadderSoftcore4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applySettings(isChecked, uberEditor, SharedValue.NONE_LADDER_SOFT_CORE_4);
            }
        });

        mBinding.cbNoneLadderSoftcore5.setChecked(uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_SOFT_CORE_5, false));
        mBinding.cbNoneLadderSoftcore5.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.cbNoneLadderSoftcore5.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));
        mBinding.cbNoneLadderSoftcore5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applySettings(isChecked, uberEditor, SharedValue.NONE_LADDER_SOFT_CORE_5);
            }
        });

        mBinding.cbNoneLadderSoftcore6.setChecked(uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_SOFT_CORE_6, false));
        mBinding.cbNoneLadderSoftcore6.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.cbNoneLadderSoftcore6.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));
        mBinding.cbNoneLadderSoftcore6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applySettings(isChecked, uberEditor, SharedValue.NONE_LADDER_SOFT_CORE_6);
            }
        });
    }

    /**
     * @param isChecked 블리언 값을 넣는다.
     * @param uberEditor SharedPreferences 에디터 값을 넣는다.
     * @param state SharedValue에서 적용할 곳을 찾는다 **/
    private void applySettings(boolean isChecked, SharedPreferences.Editor uberEditor, String state) {
        if (isChecked){
            uberEditor.putBoolean(state, true);
            uberEditor.apply();
        } else {
            uberEditor.putBoolean(state, false);
            uberEditor.apply();
        }
    }

}