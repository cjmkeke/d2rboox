package com.cjmkeke.d2rbooks.settings;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivityTerrorZoneSettingsBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TerrorZoneSettings extends AppCompatActivity {

    private static final String TAG = "TerrorZoneSettings";
    private ActivityTerrorZoneSettingsBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private SharedPreferences terrorZoneSharedPreferences;
    private boolean isTerrorZoneAllow = false;
    private boolean isBatteryOptimizationAllow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fontSharedPreferences = getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);

        mBinding = ActivityTerrorZoneSettingsBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        terrorZoneSharedPreferences = getSharedPreferences("terror_zone", MODE_PRIVATE);
        SharedPreferences.Editor editor = terrorZoneSharedPreferences.edit();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("terror_zone");

        int color = android.R.color.transparent;

        // Act 1 checkboxes
        mBinding.act11Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act11Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act12Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act12Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act13Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act13Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act14Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act14Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act15Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act15Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act16Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act16Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act17Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act17Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act18Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act18Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act19Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act19Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act110Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act110Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act111Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act111Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act112Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act112Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

// Act 2 checkboxes
        mBinding.act21Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act21Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act22Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act22Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act23Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act23Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act24Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act24Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act25Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act25Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act26Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act26Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act27Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act27Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act28Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act28Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

// Act 3 checkboxes
        mBinding.act31Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act31Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act32Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act32Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act33Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act33Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act34Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act34Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act35Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act35Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act36Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act36Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

// Act 4 checkboxes
        mBinding.act41Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act41Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act42Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act42Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act43Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act43Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

// Act 5 checkboxes
        mBinding.act51Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act51Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act52Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act52Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act53Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act53Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act54Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act54Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act55Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act55Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act56Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act56Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        mBinding.act57Checkbox.setBackgroundResource(R.drawable.checked_box_selector);
        mBinding.act57Checkbox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(color)));

        // Act 1 checkboxes
        mBinding.act11Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act1_1", false));
        mBinding.act12Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act1_2", false));
        mBinding.act13Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act1_3", false));
        mBinding.act14Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act1_4", false));
        mBinding.act15Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act1_5", false));
        mBinding.act16Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act1_6", false));
        mBinding.act17Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act1_7", false));
        mBinding.act18Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act1_8", false));
        mBinding.act19Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act1_9", false));
        mBinding.act110Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act1_10", false));
        mBinding.act111Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act1_11", false));
        mBinding.act112Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act1_12", false));

        // Act 2 checkboxes
        mBinding.act21Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act2_1", false));
        mBinding.act22Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act2_2", false));
        mBinding.act23Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act2_3", false));
        mBinding.act24Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act2_4", false));
        mBinding.act25Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act2_5", false));
        mBinding.act26Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act2_6", false));
        mBinding.act27Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act2_7", false));
        mBinding.act28Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act2_8", false));

        // Act 3 checkboxes
        mBinding.act31Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act3_1", false));
        mBinding.act32Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act3_2", false));
        mBinding.act33Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act3_3", false));
        mBinding.act34Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act3_4", false));
        mBinding.act35Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act3_5", false));
        mBinding.act36Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act3_6", false));

        // Act 4 checkboxes
        mBinding.act41Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act4_1", false));
        mBinding.act42Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act4_2", false));
        mBinding.act43Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act4_3", false));

        // Act 5 checkboxes
        mBinding.act51Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act5_1", false));
        mBinding.act52Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act5_2", false));
        mBinding.act53Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act5_3", false));
        mBinding.act54Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act5_4", false));
        mBinding.act55Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act5_5", false));
        mBinding.act56Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act5_6", false));
        mBinding.act57Checkbox.setChecked(terrorZoneSharedPreferences.getBoolean("act5_7", false));

        // Act 1 checkboxes
        mBinding.act11Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act1_1");
            }
        });

        mBinding.act12Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act1_2");
            }
        });

        mBinding.act13Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act1_3");
            }
        });

        mBinding.act14Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act1_4");
            }
        });

        mBinding.act15Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act1_5");
            }
        });

        mBinding.act16Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act1_6");
            }
        });

        mBinding.act17Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act1_7");
            }
        });

        mBinding.act18Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act1_8");
            }
        });

        mBinding.act19Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act1_9");
            }
        });

        mBinding.act110Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act1_10");
            }
        });

        mBinding.act111Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act1_11");
            }
        });

        mBinding.act112Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act1_12");
            }
        });

        // Act 2 checkboxes
        mBinding.act21Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act2_1");
            }
        });

        mBinding.act22Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act2_2");
            }
        });

        mBinding.act23Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act2_3");
            }
        });

        mBinding.act24Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act2_4");
            }
        });

        mBinding.act25Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act2_5");
            }
        });

        mBinding.act26Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act2_6");
            }
        });

        mBinding.act27Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act2_7");
            }
        });

        mBinding.act28Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act2_8");
            }
        });

// Act 3 checkboxes
        mBinding.act31Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act3_1");
            }
        });

        mBinding.act32Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act3_2");
            }
        });

        mBinding.act33Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act3_3");
            }
        });

        mBinding.act34Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act3_4");
            }
        });

        mBinding.act35Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act3_5");
            }
        });

        mBinding.act36Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act3_6");
            }
        });

// Act 4 checkboxes
        mBinding.act41Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act4_1");
            }
        });

        mBinding.act42Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act4_2");
            }
        });

        mBinding.act43Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act4_3");
            }
        });

// Act 5 checkboxes
        mBinding.act51Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act5_1");
            }
        });

        mBinding.act52Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act5_2");
            }
        });

        mBinding.act53Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act5_3");
            }
        });

        mBinding.act54Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act5_4");
            }
        });

        mBinding.act55Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act5_5");
            }
        });

        mBinding.act56Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act5_6");
            }
        });

        mBinding.act57Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                applyTerrorZone(isChecked, editor, "act5_7");
            }
        });
    }

    private void applyTerrorZone(boolean isChecked, SharedPreferences.Editor editor, String actNumber) {
        if (isChecked) {
            editor.putBoolean(actNumber, true);
            editor.apply();
        } else {
            editor.putBoolean(actNumber, false);
            editor.apply();
        }
    }
}