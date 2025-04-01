package com.cjmkeke.d2rbooks.settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cjmkeke.d2rbooks.BuildConfig;
import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivitySettingsBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Settings extends AppCompatActivity {

    private static final String TAG = "Settings";
    private ActivitySettingsBinding mBinding;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private SharedPreferences fontSharedPreferences;
    private SharedPreferences settingsSharedPreferences;
    private SharedPreferences toggleButtonSharedPreferences;
    private SharedPreferences.Editor toggleEditor;
    private SharedPreferences.Editor notificationEditor;
    private boolean checked = true;
    private boolean isTerrorZoneEnabled;
    private boolean isUberDiaEnabled;
    private SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fontSharedPreferences = getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);

        mBinding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        settingsSharedPreferences = getSharedPreferences("settings_preferences", MODE_PRIVATE);
        toggleButtonSharedPreferences = getSharedPreferences(SharedValue.TOGGLE_BUTTON_SETTINGS, MODE_PRIVATE);
        toggleEditor = toggleButtonSharedPreferences.edit();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("app_settings");
        int buildVersion = BuildConfig.VERSION_CODE;
        mBinding.tvVersion.setText("버전 : " + buildVersion);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int version = snapshot.child("version").getValue(Integer.class);
                if (version == buildVersion) {
                    mBinding.tvVersionMessage.setVisibility(View.GONE);
                } else {
                    mBinding.tvVersionMessage.setVisibility(View.VISIBLE);
                    mBinding.tvVersionMessage.setText("새로운 버전이 업데이트 되었습니다. 서버 버전 : " + version);
                    mBinding.tvVersionMessage.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.cjmkeke.d2rbooks"));
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        boolean isVibrationEnabled = toggleButtonSharedPreferences.getBoolean("toggle_button_vibration", false);
        // ToggleSwitch 초기화
        mBinding.tbTerrorZoneVibration.setOnCheckedChangeListener(null); // 리스너 비활성화
        mBinding.tbTerrorZoneVibration.setChecked(isVibrationEnabled); // 저장된 값으로 초기화
        updateVibrationBackground(isVibrationEnabled); // 배경 리소스 동기화
        mBinding.tbTerrorZoneVibration.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 상태 저장
                toggleEditor.putBoolean("toggle_button_vibration", isChecked);
                toggleEditor.apply();
                updateVibrationBackground(isChecked);
            }
        });

        boolean isAlarmSoundEnabled = toggleButtonSharedPreferences.getBoolean("toggle_button_alarm_sound", false);
        updateAlarmSoundBackground(isAlarmSoundEnabled);
        mBinding.tbTerrorZoneAlarmSound.setChecked(isAlarmSoundEnabled);
        mBinding.tbTerrorZoneAlarmSound.setOnCheckedChangeListener(null);
        mBinding.tbTerrorZoneAlarmSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleEditor.putBoolean("toggle_button_alarm_sound", isChecked);
                toggleEditor.apply();
                updateAlarmSoundBackground(isChecked);
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("app_settings_preferences", MODE_PRIVATE);
        boolean isShow = sharedPreferences.getBoolean("a", true);

        SharedPreferences notificationSharedPreferences = getSharedPreferences(SharedValue.NOTIFICATION_TERROR_ZONE_ALARM_SETTINGS, MODE_PRIVATE);
        notificationEditor = notificationSharedPreferences.edit();

        boolean isFontEnabled = toggleButtonSharedPreferences.getBoolean("toggle_button_font", false);
        updateBackground(isFontEnabled, mBinding.tbFontChange);
        mBinding.tbFontChange.setChecked(isFontEnabled);
        mBinding.tbFontChange.setOnCheckedChangeListener(null);
        mBinding.tbFontChange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleEditor.putBoolean("toggle_button_font", isChecked);
                toggleEditor.apply();
                updateBackground(isChecked, mBinding.tbFontChange);
                toggleFont();
            }
        });

        // SharedPreferences에서 값 가져오기 및 초기 UI 설정
        isUberDiaEnabled = toggleButtonSharedPreferences.getBoolean("toggle_button_uber_dia", false);
        isTerrorZoneEnabled = toggleButtonSharedPreferences.getBoolean("toggle_button_terror_zone", false);

        // UI 업데이트 메서드 호출
        updateUi("toggle_button_uber_dia", isUberDiaEnabled);
        updateUi("toggle_button_terror_zone", isTerrorZoneEnabled);

        // SharedPreferences 변경 리스너 정의
        SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, @Nullable String key) {
                if (key == null) return;
                boolean isEnabled = sharedPreferences.getBoolean(key, false);
                updateUi(key, isEnabled);
            }
        };

        // 리스너 등록
        toggleButtonSharedPreferences.registerOnSharedPreferenceChangeListener(preferenceChangeListener);


        updateBackground(isTerrorZoneEnabled, mBinding.tbTerrorZoneChange);
        mBinding.tbTerrorZoneChange.setChecked(isTerrorZoneEnabled);
        mBinding.tbTerrorZoneChange.setOnCheckedChangeListener(null);
        mBinding.tbTerrorZoneChange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleEditor.putBoolean("toggle_button_terror_zone", isChecked);
                toggleEditor.apply();
                updateBackground(isChecked, mBinding.tbTerrorZoneChange);
            }
        });

        updateBackground(isUberDiaEnabled, mBinding.tbUberDiaChange);
        mBinding.tbUberDiaChange.setChecked(isUberDiaEnabled);
        mBinding.tbUberDiaChange.setOnCheckedChangeListener(null);
        mBinding.tbUberDiaChange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleEditor.putBoolean("toggle_button_uber_dia", isChecked);
                toggleEditor.apply();
                updateBackground(isChecked, mBinding.tbUberDiaChange);
            }
        });

        final String Minute15SettingsMessage = "테러존 알림을 15분 단위로 알림을 받습니다." +
                "\n예) 정각 01분, 16분 31분 46분 마다 반복";
        final String Minute30SettingsMessage = "테러존 알림을 30분 단위로 알림을 받습니다." +
                "\n예) 정각 31분, 01분 마다 반복";
        final String HourSettingsMessage = "테러존 알림을 1시간 단위로 알림을 받습니다." +
                "\n예) 정각 01분 마다 반복";

        String[] triggerTimeString = new String[]{"15분", "30분", "1시간"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, R.layout.spinner_dropdown_item2, triggerTimeString);
        mBinding.spTerrorZoneSpinner.setAdapter(spinnerAdapter);
        mBinding.spTerrorZoneSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                switch (selectedItem) {
                    case "15분":
                        notificationEditor.putInt("time_15", 15);
                        notificationEditor.putInt("time_30", 0);
                        notificationEditor.putInt("time_1_hour", 0);
                        notificationEditor.apply();
                        mBinding.tvTerrorZoneTextShow.setText(Minute15SettingsMessage);
                        Log.w(TAG, "15분으로 설정했습니다");
                        break;
                    case "30분":
                        notificationEditor.putInt("time_15", 0);
                        notificationEditor.putInt("time_30", 30);
                        notificationEditor.putInt("time_1_hour", 0);
                        notificationEditor.apply();
                        mBinding.tvTerrorZoneTextShow.setText(Minute30SettingsMessage);
                        Log.w(TAG, "30분으로 설정했습니다");
                        break;
                    case "1시간":
                        notificationEditor.putInt("time_15", 0);
                        notificationEditor.putInt("time_30", 0);
                        notificationEditor.putInt("time_1_hour", 1);
                        notificationEditor.apply();
                        mBinding.tvTerrorZoneTextShow.setText(HourSettingsMessage);
                        Log.w(TAG, "1시간으로 설정했습니다");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.w(TAG, "아무 항목도 선택되지 않았습니다.");
            }
        });

        if (notificationSharedPreferences.getInt("time_15", 0) != 0) {
            mBinding.spTerrorZoneSpinner.setSelection(triggerTimeString.length - 3);
        } else if (notificationSharedPreferences.getInt("time_30", 0) != 0) {
            mBinding.spTerrorZoneSpinner.setSelection(triggerTimeString.length - 2);
        } else if (notificationSharedPreferences.getInt("time_1_hour", 0) != 0) {
            mBinding.spTerrorZoneSpinner.setSelection(triggerTimeString.length - 1);
        }

        mBinding.tvTerrorZoneMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, TerrorZoneSettings.class);
                startActivity(intent);
            }
        });

        mBinding.tvUberDiaMessageAsia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, AsiaUberDiabloSettings.class);
                startActivity(intent);
            }
        });


        mBinding.tvUberDiaMessageAmerica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, AmericaUberDiabloSettings.class);
                startActivity(intent);
            }
        });

        mBinding.tvUberDiaMessageEurope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, EuropeUberDiabloSettings.class);
                startActivity(intent);
            }
        });

        if (isShow) {
            mBinding.llMainTerrorZone.setVisibility(View.GONE);
            mBinding.llMainUber.setVisibility(View.GONE);
        } else {
            mBinding.llMainTerrorZone.setVisibility(View.VISIBLE);
            mBinding.llMainUber.setVisibility(View.VISIBLE);
        }

        mBinding.tvTerrorZoneQuestion.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, QDialog.class);
            intent.putExtra("terror", "terror");
            startActivity(intent);
        });

        mBinding.tvUberDiaQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, QDialog.class);
                intent.putExtra("uber_dia", "uber_dia");
                startActivity(intent);
            }
        });

    }

    private void updateBackground(boolean isChecked, ToggleButton toggleButton) {
        if (isChecked) {
            toggleButton.setBackgroundResource(R.drawable.icons_checkbox_on);
        } else {
            toggleButton.setBackgroundResource(R.drawable.icons_checkbox_off);
        }
    }

    private void updateAlarmSoundBackground(boolean isChecked) {
        if (isChecked) {
            mBinding.tbTerrorZoneAlarmSound.setBackgroundResource(R.drawable.icons_checkbox_on);
        } else {
            mBinding.tbTerrorZoneAlarmSound.setBackgroundResource(R.drawable.icons_checkbox_off);
        }
    }

    private void updateVibrationBackground(boolean isChecked) {
        if (isChecked) {
            mBinding.tbTerrorZoneVibration.setBackgroundResource(R.drawable.icons_checkbox_on);
        } else {
            mBinding.tbTerrorZoneVibration.setBackgroundResource(R.drawable.icons_checkbox_off);
        }
    }

    private void toggleFont() {
        SharedPreferences.Editor editor = fontSharedPreferences.edit();
        SharedPreferences.Editor toggleEditor = toggleButtonSharedPreferences.edit();

        // 현재 저장된 폰트 확인 후 변경
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum");
        if (currentFont.equals("nanum")) {
            toggleEditor.putBoolean("toggle_button_font", true);
            editor.putString("selectedFont", "kodia");
            setTheme(R.style.kodia);
        } else {
            toggleEditor.putBoolean("toggle_button_font", false);
            editor.putString("selectedFont", "nanum");
            setTheme(R.style.nanum);
        }

        toggleEditor.apply();
        editor.apply();

        // 화면 재시작하여 변경된 폰트 적용
        recreate();
    }

    // UI 업데이트 메서드
    private void updateUi(String key, boolean isEnabled) {
        if ("toggle_button_uber_dia".equals(key)) {
            mBinding.tvUberDiaOnOff.setText(isEnabled ? "우버 디아블로 알람을 ON 했습니다." : "우버 디아블로 알람을 OFF 했습니다.");
        } else if ("toggle_button_terror_zone".equals(key)) {
            mBinding.tvTerrorZoneOnOff.setText(isEnabled ? "테러존 알람을 ON 했습니다." : "테러존 알람을 OFF 했습니다.");
        }
    }

}