package com.cjmkeke.d2rbooks;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cjmkeke.d2rbooks.call.DataCallBack;
import com.cjmkeke.d2rbooks.constants.Rune;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivityMainBinding;
import com.cjmkeke.d2rbooks.dialog.PriceShow;
import com.cjmkeke.d2rbooks.dialog.PriceWrite;
import com.cjmkeke.d2rbooks.dialog.ShowDialog;
import com.cjmkeke.d2rbooks.dialog.ShowRune;
import com.cjmkeke.d2rbooks.permission.AlarmPermissionHelper;
import com.cjmkeke.d2rbooks.permission.BatteryOptimizationHelper;
import com.cjmkeke.d2rbooks.permission.PermissionCallback;
import com.cjmkeke.d2rbooks.service.background.TerrorZoneAlarmManager;
import com.cjmkeke.d2rbooks.service.background.UberAlarmManager;
import com.cjmkeke.d2rbooks.settings.LoginPage;
import com.cjmkeke.d2rbooks.settings.Settings;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";
    private static final String CHANNEL_ID = "공포의 영역 알림";
    private ActivityMainBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    private SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.OnSharedPreferenceChangeListener onTerrorZoneSharedPreferenceChangeListener;
    private SharedPreferences terrorZoneSharedPerrferences;
    private SharedPreferences settingsSharedPreferences;
    private boolean isAlarmPermissionGranted = false;
    private boolean isBatteryOptimizationDisabled = false;
    private SharedPreferences toggleButtonSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fontSharedPreferences = getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);

        sharedPreferences = getSharedPreferences("terror_zone", MODE_PRIVATE);
        // 기본값 초기화
        initializeDefaultPreferences();

        // 리스너 초기화
        onSharedPreferenceChangeListener = (sharedPreferences, key) -> {
            if ("selectedFont".equals(key)) {
                restartActivity(); // 변경 시 강제 재시작
            }
        };

        // 변경 감지 리스너 정의
        terrorZoneSharedPerrferences = getSharedPreferences("terror_zone", MODE_PRIVATE);
        SharedPreferences.Editor editor = terrorZoneSharedPerrferences.edit();
        onTerrorZoneSharedPreferenceChangeListener = (sharedPreferences, key) -> {
            // Act 1
            if ("act1_1".equals(key)) {
                boolean act1_1_value = sharedPreferences.getBoolean("act1_1", false);
                editor.putBoolean("act1_1", act1_1_value);
                editor.apply();
            } else if ("act1_2".equals(key)) {
                boolean act1_2_value = sharedPreferences.getBoolean("act1_2", false);
                editor.putBoolean("act1_2", act1_2_value);
                editor.apply();
            } else if ("act1_3".equals(key)) {
                boolean act1_3_value = sharedPreferences.getBoolean("act1_3", false);
                editor.putBoolean("act1_3", act1_3_value);
                editor.apply();
            } else if ("act1_4".equals(key)) {
                boolean act1_4_value = sharedPreferences.getBoolean("act1_4", false);
                editor.putBoolean("act1_4", act1_4_value);
                editor.apply();
            } else if ("act1_5".equals(key)) {
                boolean act1_5_value = sharedPreferences.getBoolean("act1_5", false);
                editor.putBoolean("act1_5", act1_5_value);
                editor.apply();
            } else if ("act1_6".equals(key)) {
                boolean act1_6_value = sharedPreferences.getBoolean("act1_6", false);
                editor.putBoolean("act1_6", act1_6_value);
                editor.apply();
            } else if ("act1_7".equals(key)) {
                boolean act1_7_value = sharedPreferences.getBoolean("act1_7", false);
                editor.putBoolean("act1_7", act1_7_value);
                editor.apply();
            } else if ("act1_8".equals(key)) {
                boolean act1_8_value = sharedPreferences.getBoolean("act1_8", false);
                editor.putBoolean("act1_8", act1_8_value);
                editor.apply();
            } else if ("act1_9".equals(key)) {
                boolean act1_9_value = sharedPreferences.getBoolean("act1_9", false);
                editor.putBoolean("act1_9", act1_9_value);
                editor.apply();
            } else if ("act1_10".equals(key)) {
                boolean act1_10_value = sharedPreferences.getBoolean("act1_10", false);
                editor.putBoolean("act1_10", act1_10_value);
                editor.apply();
            } else if ("act1_11".equals(key)) {
                boolean act1_11_value = sharedPreferences.getBoolean("act1_11", false);
                editor.putBoolean("act1_11", act1_11_value);
                editor.apply();
            } else if ("act1_12".equals(key)) {
                boolean act1_12_value = sharedPreferences.getBoolean("act1_12", false);
                editor.putBoolean("act1_12", act1_12_value);
                editor.apply();
            }

// Act 2
            else if ("act2_1".equals(key)) {
                boolean act2_1_value = sharedPreferences.getBoolean("act2_1", false);
                editor.putBoolean("act2_1", act2_1_value);
                editor.apply();
            } else if ("act2_2".equals(key)) {
                boolean act2_2_value = sharedPreferences.getBoolean("act2_2", false);
                editor.putBoolean("act2_2", act2_2_value);
                editor.apply();
            } else if ("act2_3".equals(key)) {
                boolean act2_3_value = sharedPreferences.getBoolean("act2_3", false);
                editor.putBoolean("act2_3", act2_3_value);
                editor.apply();
            } else if ("act2_4".equals(key)) {
                boolean act2_4_value = sharedPreferences.getBoolean("act2_4", false);
                editor.putBoolean("act2_4", act2_4_value);
                editor.apply();
            } else if ("act2_5".equals(key)) {
                boolean act2_5_value = sharedPreferences.getBoolean("act2_5", false);
                editor.putBoolean("act2_5", act2_5_value);
                editor.apply();
            } else if ("act2_6".equals(key)) {
                boolean act2_6_value = sharedPreferences.getBoolean("act2_6", false);
                editor.putBoolean("act2_6", act2_6_value);
                editor.apply();
            } else if ("act2_7".equals(key)) {
                boolean act2_7_value = sharedPreferences.getBoolean("act2_7", false);
                editor.putBoolean("act2_7", act2_7_value);
                editor.apply();
            } else if ("act2_8".equals(key)) {
                boolean act2_8_value = sharedPreferences.getBoolean("act2_8", false);
                editor.putBoolean("act2_8", act2_8_value);
                editor.apply();
            }

// Act 3
            else if ("act3_1".equals(key)) {
                boolean act3_1_value = sharedPreferences.getBoolean("act3_1", false);
                editor.putBoolean("act3_1", act3_1_value);
                editor.apply();
            } else if ("act3_2".equals(key)) {
                boolean act3_2_value = sharedPreferences.getBoolean("act3_2", false);
                editor.putBoolean("act3_2", act3_2_value);
                editor.apply();
            } else if ("act3_3".equals(key)) {
                boolean act3_3_value = sharedPreferences.getBoolean("act3_3", false);
                editor.putBoolean("act3_3", act3_3_value);
                editor.apply();
            } else if ("act3_4".equals(key)) {
                boolean act3_4_value = sharedPreferences.getBoolean("act3_4", false);
                editor.putBoolean("act3_4", act3_4_value);
                editor.apply();
            } else if ("act3_5".equals(key)) {
                boolean act3_5_value = sharedPreferences.getBoolean("act3_5", false);
                editor.putBoolean("act3_5", act3_5_value);
                editor.apply();
            } else if ("act3_6".equals(key)) {
                boolean act3_6_value = sharedPreferences.getBoolean("act3_6", false);
                editor.putBoolean("act3_6", act3_6_value);
                editor.apply();
            }

// Act 4
            else if ("act4_1".equals(key)) {
                boolean act4_1_value = sharedPreferences.getBoolean("act4_1", false);
                editor.putBoolean("act4_1", act4_1_value);
                editor.apply();
            } else if ("act4_2".equals(key)) {
                boolean act4_2_value = sharedPreferences.getBoolean("act4_2", false);
                editor.putBoolean("act4_2", act4_2_value);
                editor.apply();
            } else if ("act4_3".equals(key)) {
                boolean act4_3_value = sharedPreferences.getBoolean("act4_3", false);
                editor.putBoolean("act4_3", act4_3_value);
                editor.apply();
            }

// Act 5
            else if ("act5_1".equals(key)) {
                boolean act5_1_value = sharedPreferences.getBoolean("act5_1", false);
                editor.putBoolean("act5_1", act5_1_value);
                editor.apply();
            } else if ("act5_2".equals(key)) {
                boolean act5_2_value = sharedPreferences.getBoolean("act5_2", false);
                editor.putBoolean("act5_2", act5_2_value);
                editor.apply();
            } else if ("act5_3".equals(key)) {
                boolean act5_3_value = sharedPreferences.getBoolean("act5_3", false);
                editor.putBoolean("act5_3", act5_3_value);
                editor.apply();
            } else if ("act5_4".equals(key)) {
                boolean act5_4_value = sharedPreferences.getBoolean("act5_4", false);
                editor.putBoolean("act5_4", act5_4_value);
                editor.apply();
            } else if ("act5_5".equals(key)) {
                boolean act5_5_value = sharedPreferences.getBoolean("act5_5", false);
                editor.putBoolean("act5_5", act5_5_value);
                editor.apply();
            } else if ("act5_6".equals(key)) {
                boolean act5_6_value = sharedPreferences.getBoolean("act5_6", false);
                editor.putBoolean("act5_6", act5_6_value);
                editor.apply();
            } else if ("act5_7".equals(key)) {
                boolean act5_7_value = sharedPreferences.getBoolean("act5_7", false);
                editor.putBoolean("act5_7", act5_7_value);
                editor.apply();
            }
        };

        // 리스너를 등록하여 변경 사항을 수신합니다.
        terrorZoneSharedPerrferences.registerOnSharedPreferenceChangeListener(onTerrorZoneSharedPreferenceChangeListener);

        // 리스너 등록
        fontSharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);

        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        FirebaseApp.initializeApp(this); // Firebase 초기화

//        AppSettings appSettings = new AppSettings(this);
//        try {
//            appSettings.setAppVersion();
//        } catch (PackageManager.NameNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        // 알람 권한 요청
        AlarmPermissionHelper.requestExactAlarmPermission(new PermissionCallback() {
            @Override
            public void onPermissionGranted() {
                isAlarmPermissionGranted = true;
                checkAndStartAlarms();
            }

            @Override
            public void onPermissionDenied() {
                isAlarmPermissionGranted = false;
                Toast.makeText(MainActivity.this, "알람 권한이 필요합니다.", Toast.LENGTH_SHORT).show();
            }
        });

        // 배터리 최적화 해제 요청
        BatteryOptimizationHelper.requestBatteryOptimization(this, new PermissionCallback() {
            @Override
            public void onPermissionGranted() {
                isBatteryOptimizationDisabled = true;
                checkAndStartAlarms();
            }

            @Override
            public void onPermissionDenied() {
                isBatteryOptimizationDisabled = false;
                Toast.makeText(MainActivity.this, "배터리 최적화 해제가 필요합니다.", Toast.LENGTH_SHORT).show();
            }
        });

        toggleButtonSharedPreferences = getSharedPreferences(SharedValue.TOGGLE_BUTTON_SETTINGS, MODE_PRIVATE);
        SharedPreferences.Editor toggleEditor = toggleButtonSharedPreferences.edit();
        // 키가 없을 경우 기본값으로 true 반환
        if (!toggleButtonSharedPreferences.contains("toggle_button_font")) {
            toggleEditor.putBoolean("toggle_button_font", false);
            toggleEditor.apply();
        }

        if (!toggleButtonSharedPreferences.contains("toggle_button_alarm_sound")) {
            toggleEditor.putBoolean("toggle_button_alarm_sound", false);
            toggleEditor.apply();
        }

        if (!toggleButtonSharedPreferences.contains("toggle_button_vibration")) {
            toggleEditor.putBoolean("toggle_button_vibration", false);
            toggleEditor.apply();
        }

        if (!toggleButtonSharedPreferences.contains("toggle_button_font")) {
            toggleEditor.putBoolean("toggle_button_font", false);
            toggleEditor.apply();
        }

        if (!toggleButtonSharedPreferences.contains("toggle_button_uber_dia")) {
            toggleEditor.putBoolean("toggle_button_uber_dia", true);
            toggleEditor.apply();
        }


        if (!toggleButtonSharedPreferences.contains("toggle_button_terror_zone")) {
            toggleEditor.putBoolean("toggle_button_terror_zone", true);
            toggleEditor.apply();
        }

        SharedPreferences sharedPreferences1 = getSharedPreferences("app_settings_preferences", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferences1Editor = sharedPreferences1.edit();

        SharedPreferences terrorZoneSharedPreferences = getSharedPreferences(
                SharedValue.NOTIFICATION_TERROR_ZONE_ALARM_SETTINGS, MODE_PRIVATE);
        SharedPreferences.Editor terrorZoneSharedPreferencesEditor = terrorZoneSharedPreferences.edit();

        // 현재 저장된 값 확인
        int time1Hour = terrorZoneSharedPreferences.getInt("time_1_hour", 0);
        int time15 = terrorZoneSharedPreferences.getInt("time_15", 0);
        int time30 = terrorZoneSharedPreferences.getInt("time_30", 0);

        // 조건 처리
        if (time1Hour == 1) {
            Log.d(TAG, "time_1_hour 값이 이미 설정됨: " + time1Hour);
        } else if (time15 == 15) {
            Log.d(TAG, "time_15 값이 이미 설정됨: " + time15);
        } else if (time30 == 30) {
            Log.d(TAG, "time_30 값이 이미 설정됨: " + time30);
        } else {
            // time_1_hour 값을 1로 설정
            terrorZoneSharedPreferencesEditor.putInt("time_1_hour", 1);
            terrorZoneSharedPreferencesEditor.apply(); // 비동기적으로 저장
            Log.d(TAG, "time_1_hour 값이 1로 설정됨.");
        }

        sharedPreferences1Editor.putBoolean("a", false); // true 하면 가리기 false 하면 보이기 <테스트 단계에 있는 것들>
        sharedPreferences1Editor.putBoolean("b", true); // true 하면 보이기 false 하면 안보이기 <AD VIEW>
        sharedPreferences1Editor.putBoolean("c", false); // true 하면 로그인 창 보이기 false 하면 로그인창 보이지 않기.
        sharedPreferences1Editor.apply();

        mBinding.tvLogin.setVisibility(View.GONE);

        boolean isLogin = sharedPreferences1.getBoolean("c", true);

        if (isLogin) {
            mBinding.tvLogin.setVisibility(View.VISIBLE);
        } else {
            mBinding.tvLogin.setVisibility(View.GONE);
        }

        final String app_version = "6";
        mBinding.tvNotice.setVisibility(View.INVISIBLE);
        mBinding.llNotices.setVisibility(View.INVISIBLE);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference("app_settings");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String keyVersion = snapshot.child("new_app_version").getValue(String.class);
                Log.w(TAG, keyVersion);

                ArrayList<Boolean> booleans = new ArrayList<>();
                if (snapshot.child("keys").exists()) {
                    booleans.clear(); // 기존 데이터를 초기화합니다.

                    // "keys" 하위 데이터를 동적으로 탐색
                    for (DataSnapshot childSnapshot : snapshot.child("keys").getChildren()) {
                        Boolean value = childSnapshot.getValue(Boolean.class);
                        if (value != null) { // null 체크를 통해 안전하게 추가
                            booleans.add(value);
                        }
                    }
                    for (int i = 0; i < booleans.size(); i++) {
                        if (booleans.get(0) == true && !app_version.equals(keyVersion)) {
                            mBinding.llNotices.setVisibility(View.VISIBLE);
                            mBinding.tvNotice.setVisibility(View.VISIBLE);
                            mBinding.tvNotice.setText(snapshot.child("message1").getValue(String.class));
                            mBinding.tvNotice.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(snapshot.child("link1").getValue(String.class)));
                                    startActivity(intent);
                                }
                            });
                        } else if (booleans.get(1) == true) {
                            mBinding.llNotices.setVisibility(View.VISIBLE);
                            mBinding.tvNotice.setVisibility(View.VISIBLE);
                            mBinding.tvNotice.setText(snapshot.child("message2").getValue(String.class));
                            mBinding.tvNotice.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(snapshot.child("link2").getValue(String.class)));
                                    startActivity(intent);
                                }
                            });
                        } else if (booleans.get(2) == true) {
                            mBinding.llNotices.setVisibility(View.VISIBLE);
                            mBinding.tvNotice.setVisibility(View.VISIBLE);
                            mBinding.tvNotice.setText(snapshot.child("message3").getValue(String.class));
                            mBinding.tvNotice.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(snapshot.child("link3").getValue(String.class)));
                                    startActivity(intent);
                                }
                            });
                        } else if (booleans.get(3) == true) {
                            mBinding.llNotices.setVisibility(View.VISIBLE);
                            mBinding.tvNotice.setVisibility(View.VISIBLE);
                            mBinding.tvNotice.setText(snapshot.child("message4").getValue(String.class));
                            mBinding.tvNotice.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(snapshot.child("link4").getValue(String.class)));
                                    startActivity(intent);
                                }
                            });
                        } else if (booleans.get(4) == true) {
                            mBinding.llNotices.setVisibility(View.VISIBLE);
                            mBinding.tvNotice.setVisibility(View.VISIBLE);
                            mBinding.tvNotice.setText(snapshot.child("message5").getValue(String.class));
                            mBinding.tvNotice.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(snapshot.child("link5").getValue(String.class)));
                                    startActivity(intent);
                                }
                            });
                        } else {
                            mBinding.tvNotice.setVisibility(View.GONE);
                            mBinding.llNotices.setVisibility(View.GONE);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mBinding.tvNotice.setSingleLine(true);    // 한줄로 표시하기
        mBinding.tvNotice.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        mBinding.tvNotice.setSelected(true);      // 선택하기

        SharedPreferences elShared = getSharedPreferences(Rune.EL, MODE_PRIVATE);
        SharedPreferences.Editor elEditor = elShared.edit();
        SharedPreferences eldShared = getSharedPreferences(Rune.ELD, MODE_PRIVATE);
        SharedPreferences.Editor eldEditor = eldShared.edit();
        SharedPreferences tirShared = getSharedPreferences(Rune.TIR, MODE_PRIVATE);
        SharedPreferences.Editor tirEditor = tirShared.edit();
        SharedPreferences nefShared = getSharedPreferences(Rune.NEF, MODE_PRIVATE);
        SharedPreferences.Editor nefEditor = nefShared.edit();
        SharedPreferences ethShared = getSharedPreferences(Rune.ETH, MODE_PRIVATE);
        SharedPreferences.Editor ethEditor = ethShared.edit();
        SharedPreferences ithShared = getSharedPreferences(Rune.ITH, MODE_PRIVATE);
        SharedPreferences.Editor ithEditor = ithShared.edit();
        SharedPreferences talShared = getSharedPreferences(Rune.TAL, MODE_PRIVATE);
        SharedPreferences.Editor talEditor = talShared.edit();
        SharedPreferences ralShared = getSharedPreferences(Rune.RAL, MODE_PRIVATE);
        SharedPreferences.Editor ralEditor = ralShared.edit();
        SharedPreferences ortShared = getSharedPreferences(Rune.ORT, MODE_PRIVATE);
        SharedPreferences.Editor ortEditor = ortShared.edit();
        SharedPreferences thulShared = getSharedPreferences(Rune.THUL, MODE_PRIVATE);
        SharedPreferences.Editor thulEditor = thulShared.edit();
        SharedPreferences amnShared = getSharedPreferences(Rune.AMN, MODE_PRIVATE);
        SharedPreferences.Editor amnEditor = amnShared.edit();
        SharedPreferences solShared = getSharedPreferences(Rune.SOL, MODE_PRIVATE);
        SharedPreferences.Editor solEditor = solShared.edit();
        SharedPreferences shaelShared = getSharedPreferences(Rune.SHAEL, MODE_PRIVATE);
        SharedPreferences.Editor shaelEditor = shaelShared.edit();
        SharedPreferences dolShared = getSharedPreferences(Rune.DOL, MODE_PRIVATE);
        SharedPreferences.Editor dolEditor = dolShared.edit();
        SharedPreferences helShared = getSharedPreferences(Rune.HEL, MODE_PRIVATE);
        SharedPreferences.Editor helEditor = helShared.edit();
        SharedPreferences ioShared = getSharedPreferences(Rune.IO, MODE_PRIVATE);
        SharedPreferences.Editor ioEditor = ioShared.edit();
        SharedPreferences lumShared = getSharedPreferences(Rune.LUM, MODE_PRIVATE);
        SharedPreferences.Editor lumEditor = lumShared.edit();
        SharedPreferences koShared = getSharedPreferences(Rune.KO, MODE_PRIVATE);
        SharedPreferences.Editor koEditor = koShared.edit();
        SharedPreferences falShared = getSharedPreferences(Rune.FAL, MODE_PRIVATE);
        SharedPreferences.Editor falEditor = falShared.edit();
        SharedPreferences lemShared = getSharedPreferences(Rune.LEM, MODE_PRIVATE);
        SharedPreferences.Editor lemEditor = lemShared.edit();
        SharedPreferences pulShared = getSharedPreferences(Rune.PUL, MODE_PRIVATE);
        SharedPreferences.Editor pulEditor = pulShared.edit();
        SharedPreferences umShared = getSharedPreferences(Rune.UM, MODE_PRIVATE);
        SharedPreferences.Editor umEditor = umShared.edit();
        SharedPreferences malShared = getSharedPreferences(Rune.MAL, MODE_PRIVATE);
        SharedPreferences.Editor malEditor = malShared.edit();
        SharedPreferences istShared = getSharedPreferences(Rune.IST, MODE_PRIVATE);
        SharedPreferences.Editor istEditor = istShared.edit();
        SharedPreferences gulShared = getSharedPreferences(Rune.GUL, MODE_PRIVATE);
        SharedPreferences.Editor gulEditor = gulShared.edit();
        SharedPreferences vexShared = getSharedPreferences(Rune.VEX, MODE_PRIVATE);
        SharedPreferences.Editor vexEditor = vexShared.edit();
        SharedPreferences ohmShared = getSharedPreferences(Rune.OHM, MODE_PRIVATE);
        SharedPreferences.Editor ohmEditor = ohmShared.edit();
        SharedPreferences loShared = getSharedPreferences(Rune.LO, MODE_PRIVATE);
        SharedPreferences.Editor loEditor = loShared.edit();
        SharedPreferences surShared = getSharedPreferences(Rune.SUR, MODE_PRIVATE);
        SharedPreferences.Editor surEditor = surShared.edit();
        SharedPreferences berShared = getSharedPreferences(Rune.BER, MODE_PRIVATE);
        SharedPreferences.Editor berEditor = berShared.edit();
        SharedPreferences jahShared = getSharedPreferences(Rune.JAH, MODE_PRIVATE);
        SharedPreferences.Editor jahEditor = jahShared.edit();
        SharedPreferences chamShared = getSharedPreferences(Rune.CHAM, MODE_PRIVATE);
        SharedPreferences.Editor chamEditor = chamShared.edit();
        SharedPreferences zodShared = getSharedPreferences(Rune.ZOD, MODE_PRIVATE);
        SharedPreferences.Editor zodEditor = zodShared.edit();

        int el = elShared.getInt(Rune.EL, 0);
        int eld = eldShared.getInt(Rune.ELD, 0);
        int tir = tirShared.getInt(Rune.TIR, 0);
        int nef = nefShared.getInt(Rune.NEF, 0);
        int eth = ethShared.getInt(Rune.ETH, 0);
        int ith = ithShared.getInt(Rune.ITH, 0);
        int tal = talShared.getInt(Rune.TAL, 0);
        int ral = ralShared.getInt(Rune.RAL, 0);
        int ort = ortShared.getInt(Rune.ORT, 0);
        int thul = thulShared.getInt(Rune.THUL, 0);
        int shael = shaelShared.getInt(Rune.SHAEL, 0);
        int dol = dolShared.getInt(Rune.DOL, 0);
        int hel = helShared.getInt(Rune.HEL, 0);
        int io = ioShared.getInt(Rune.IO, 0);
        int lum = lumShared.getInt(Rune.LUM, 0);
        int ko = koShared.getInt(Rune.KO, 0);
        int fal = falShared.getInt(Rune.FAL, 0);
        int lem = lemShared.getInt(Rune.LEM, 0);
        int pul = pulShared.getInt(Rune.PUL, 0);
        int um = umShared.getInt(Rune.UM, 0);
        int mal = malShared.getInt(Rune.MAL, 0);
        int ist = istShared.getInt(Rune.IST, 0);
        int vex = vexShared.getInt(Rune.VEX, 0);
        int ohm = ohmShared.getInt(Rune.OHM, 0);
        int lo = loShared.getInt(Rune.LO, 0);
        int sur = surShared.getInt(Rune.SUR, 0);
        int ber = berShared.getInt(Rune.BER, 0);
        int jah = jahShared.getInt(Rune.JAH, 0);
        int cham = chamShared.getInt(Rune.CHAM, 0);
        int zod = zodShared.getInt(Rune.ZOD, 0);

        // TODO EL 룬
        mBinding.tvElUpdateView.setText("[ 보유 수량 : " + elShared.getInt(Rune.EL, 0) + " 개 ]");
        mBinding.tvElUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.EL, elShared, elEditor, mBinding.tvElUpdateView, mBinding.elBackground);
            }
        });

        mBinding.tvElDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.EL, elShared, elEditor, mBinding.tvElUpdateView, mBinding.elBackground);
            }
        });

        mBinding.tvEldUpdateView.setText("[ 보유 수량 : " + eldShared.getInt(Rune.ELD, 0) + " 개 ]");
        mBinding.tvEldUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.ELD, eldShared, eldEditor, mBinding.tvEldUpdateView, mBinding.eldBackground);
            }
        });

        mBinding.tvEldDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.ELD, eldShared, eldEditor, mBinding.tvEldUpdateView, mBinding.eldBackground);
            }
        });

        mBinding.tvTirUpdateView.setText("[ 보유 수량 : " + tirShared.getInt(Rune.TIR, 0) + " 개 ]");
        mBinding.tvTirUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.TIR, tirShared, tirEditor, mBinding.tvTirUpdateView, mBinding.tirBackground);
            }
        });

        mBinding.tvTirDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.TIR, tirShared, tirEditor, mBinding.tvTirUpdateView, mBinding.tirBackground);
            }
        });

        mBinding.tvNefUpdateView.setText("[ 보유 수량 : " + nefShared.getInt(Rune.NEF, 0) + " 개 ]");
        mBinding.tvNefUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.NEF, nefShared, nefEditor, mBinding.tvNefUpdateView, mBinding.nefBackground);
            }
        });

        mBinding.tvNefDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.NEF, nefShared, nefEditor, mBinding.tvNefUpdateView, mBinding.nefBackground);
            }
        });

        mBinding.tvEthUpdateView.setText("[ 보유 수량 : " + ethShared.getInt(Rune.ETH, 0) + " 개 ]");
        mBinding.tvEthUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.ETH, ethShared, ethEditor, mBinding.tvEthUpdateView, mBinding.ethBackground);
            }
        });

        mBinding.tvEthDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.ETH, ethShared, ethEditor, mBinding.tvEthUpdateView, mBinding.ethBackground);
            }
        });

        mBinding.tvIthUpdateView.setText("[ 보유 수량 : " + ithShared.getInt(Rune.ITH, 0) + " 개 ]");
        mBinding.tvIthUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.ITH, ithShared, ithEditor, mBinding.tvIthUpdateView, mBinding.ithBackground);
            }
        });

        mBinding.tvIthDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.ITH, ithShared, ithEditor, mBinding.tvIthUpdateView, mBinding.ithBackground);
            }
        });

        mBinding.tvTalUpdateView.setText("[ 보유 수량 : " + talShared.getInt(Rune.TAL, 0) + " 개 ]");
        mBinding.tvTalUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.TAL, talShared, talEditor, mBinding.tvTalUpdateView, mBinding.talBackground);
            }
        });

        mBinding.tvTalDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.TAL, talShared, talEditor, mBinding.tvTalUpdateView, mBinding.talBackground);
            }
        });

        // Ral 룬
        mBinding.tvRalUpdateView.setText("[ 보유 수량 : " + ralShared.getInt(Rune.RAL, 0) + " 개 ]");
        mBinding.tvRalUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.RAL, ralShared, ralEditor, mBinding.tvRalUpdateView, mBinding.ralBackground);
            }
        });
        mBinding.tvRalDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.RAL, ralShared, ralEditor, mBinding.tvRalUpdateView, mBinding.ralBackground);
            }
        });

// Ort 룬
        mBinding.tvOrtUpdateView.setText("[ 보유 수량 : " + ortShared.getInt(Rune.ORT, 0) + " 개 ]");
        mBinding.tvOrtUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.ORT, ortShared, ortEditor, mBinding.tvOrtUpdateView, mBinding.ortBackground);
            }
        });

        mBinding.tvOrtDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.ORT, ortShared, ortEditor, mBinding.tvOrtUpdateView, mBinding.ortBackground);
            }
        });

// Thul 룬
        mBinding.tvThulUpdateView.setText("[ 보유 수량 : " + thulShared.getInt(Rune.THUL, 0) + " 개 ]");
        mBinding.tvThulUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.THUL, thulShared, thulEditor, mBinding.tvThulUpdateView, mBinding.thulBackground);
            }
        });
        mBinding.tvThulDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.THUL, thulShared, thulEditor, mBinding.tvThulUpdateView, mBinding.thulBackground);
            }
        });

// Amn 룬
        mBinding.tvAmnUpdateView.setText("[ 보유 수량 : " + amnShared.getInt(Rune.AMN, 0) + " 개 ]");
        mBinding.tvAmnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.AMN, amnShared, amnEditor, mBinding.tvAmnUpdateView, mBinding.amnBackground);
            }
        });
        mBinding.tvAmnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.AMN, amnShared, amnEditor, mBinding.tvAmnUpdateView, mBinding.amnBackground);
            }
        });

// Sol 룬
        mBinding.tvSolUpdateView.setText("[ 보유 수량 : " + solShared.getInt(Rune.SOL, 0) + " 개 ]");
        mBinding.tvSolUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.SOL, solShared, solEditor, mBinding.tvSolUpdateView, mBinding.solBackground);
            }
        });
        mBinding.tvSolDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.SOL, solShared, solEditor, mBinding.tvSolUpdateView, mBinding.solBackground);
            }
        });

// Shael 룬
        mBinding.tvShaelUpdateView.setText("[ 보유 수량 : " + shaelShared.getInt(Rune.SHAEL, 0) + " 개 ]");
        mBinding.tvShaelUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.SHAEL, shaelShared, shaelEditor, mBinding.tvShaelUpdateView, mBinding.shaelBackground);
            }
        });
        mBinding.tvShaelDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.SHAEL, shaelShared, shaelEditor, mBinding.tvShaelUpdateView, mBinding.shaelBackground);
            }
        });

// Dol 룬
        mBinding.tvDolUpdateView.setText("[ 보유 수량 : " + dolShared.getInt(Rune.DOL, 0) + " 개 ]");
        mBinding.tvDolUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.DOL, dolShared, dolEditor, mBinding.tvDolUpdateView, mBinding.dolBackground);
            }
        });
        mBinding.tvDolDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.DOL, dolShared, dolEditor, mBinding.tvDolUpdateView, mBinding.dolBackground);
            }
        });

// Hel 룬
        mBinding.tvHelUpdateView.setText("[ 보유 수량 : " + helShared.getInt(Rune.HEL, 0) + " 개 ]");
        mBinding.tvHelUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.HEL, helShared, helEditor, mBinding.tvHelUpdateView, mBinding.helBackground);
            }
        });
        mBinding.tvHelDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.HEL, helShared, helEditor, mBinding.tvHelUpdateView, mBinding.helBackground);
            }
        });

// Io 룬
        mBinding.tvIoUpdateView.setText("[ 보유 수량 : " + ioShared.getInt(Rune.IO, 0) + " 개 ]");
        mBinding.tvIoUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.IO, ioShared, ioEditor, mBinding.tvIoUpdateView, mBinding.ioBackground);
            }
        });
        mBinding.tvIoDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.IO, ioShared, ioEditor, mBinding.tvIoUpdateView, mBinding.ioBackground);
            }
        });

// Lum 룬
        mBinding.tvLumUpdateView.setText("[ 보유 수량 : " + lumShared.getInt(Rune.LUM, 0) + " 개 ]");
        mBinding.tvLumUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.LUM, lumShared, lumEditor, mBinding.tvLumUpdateView, mBinding.lumBackground);
            }
        });
        mBinding.tvLumDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.LUM, lumShared, lumEditor, mBinding.tvLumUpdateView, mBinding.lumBackground);
            }
        });

        mBinding.tvKoUpdateView.setText("[ 보유 수량 : " + koShared.getInt(Rune.KO, 0) + " 개 ]");
        mBinding.tvKoUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.KO, koShared, koEditor, mBinding.tvKoUpdateView, mBinding.koBackground);
            }
        });
        mBinding.tvKoDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.KO, koShared, koEditor, mBinding.tvKoUpdateView, mBinding.koBackground);
            }
        });

        mBinding.tvFalUpdateView.setText("[ 보유 수량 : " + falShared.getInt(Rune.FAL, 0) + " 개 ]");
        mBinding.tvFalUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.FAL, falShared, falEditor, mBinding.tvFalUpdateView, mBinding.falBackground);
            }
        });
        mBinding.tvFalDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.FAL, falShared, falEditor, mBinding.tvFalUpdateView, mBinding.falBackground);
            }
        });

        mBinding.tvLemUpdateView.setText("[ 보유 수량 : " + lemShared.getInt(Rune.LEM, 0) + " 개 ]");
        mBinding.tvLemUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.LEM, lemShared, lemEditor, mBinding.tvLemUpdateView, mBinding.lemBackground);
            }
        });
        mBinding.tvLemDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.LEM, lemShared, lemEditor, mBinding.tvLemUpdateView, mBinding.lemBackground);
            }
        });

        mBinding.tvPulUpdateView.setText("[ 보유 수량 : " + pulShared.getInt(Rune.PUL, 0) + " 개 ]");
        mBinding.tvPulUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.PUL, pulShared, pulEditor, mBinding.tvPulUpdateView, mBinding.pulBackground);
            }
        });
        mBinding.tvPulDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.PUL, pulShared, pulEditor, mBinding.tvPulUpdateView, mBinding.pulBackground);
            }
        });

        mBinding.tvUmUpdateView.setText("[ 보유 수량 : " + umShared.getInt(Rune.UM, 0) + " 개 ]");
        mBinding.tvUmUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.UM, umShared, umEditor, mBinding.tvUmUpdateView, mBinding.umBackground);
            }
        });
        mBinding.tvUmDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.UM, umShared, umEditor, mBinding.tvUmUpdateView, mBinding.umBackground);
            }
        });

// Mal 룬
        mBinding.tvMalUpdateView.setText("[ 보유 수량 : " + malShared.getInt(Rune.MAL, 0) + " 개 ]");
        mBinding.tvMalUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.MAL, malShared, malEditor, mBinding.tvMalUpdateView, mBinding.malBackground);
            }
        });
        mBinding.tvMalDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.MAL, malShared, malEditor, mBinding.tvMalUpdateView, mBinding.malBackground);
            }
        });

// Ist 룬

        mBinding.tvIstUpdateView.setText("[ 보유 수량 : " + istShared.getInt(Rune.IST, 0) + " 개 ]");
        mBinding.tvIstUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.IST, istShared, istEditor, mBinding.tvIstUpdateView, mBinding.istBackground);
            }
        });
        mBinding.tvIstDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.IST, istShared, istEditor, mBinding.tvIstUpdateView, mBinding.istBackground);
            }
        });

// Gul 룬

        mBinding.tvGulUpdateView.setText("[ 보유 수량 : " + gulShared.getInt(Rune.GUL, 0) + " 개 ]");
        mBinding.tvGulUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.GUL, gulShared, gulEditor, mBinding.tvGulUpdateView, mBinding.gulBackground);
            }
        });
        mBinding.tvGulDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.GUL, gulShared, gulEditor, mBinding.tvGulUpdateView, mBinding.gulBackground);
            }
        });


        mBinding.tvVexUpdateView.setText("[ 보유 수량 : " + vexShared.getInt(Rune.VEX, 0) + " 개 ]");
        mBinding.tvVexUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.VEX, vexShared, vexEditor, mBinding.tvVexUpdateView, mBinding.vexBackground);
            }
        });
        mBinding.tvVexDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.VEX, vexShared, vexEditor, mBinding.tvVexUpdateView, mBinding.vexBackground);
            }
        });


        mBinding.tvOhmUpdateView.setText("[ 보유 수량 : " + ohmShared.getInt(Rune.OHM, 0) + " 개 ]");
        mBinding.tvOhmUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.OHM, ohmShared, ohmEditor, mBinding.tvOhmUpdateView, mBinding.ohmBackground);
            }
        });
        mBinding.tvOhmDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.OHM, ohmShared, ohmEditor, mBinding.tvOhmUpdateView, mBinding.ohmBackground);
            }
        });

// Lo 룬

        mBinding.tvLoUpdateView.setText("[ 보유 수량 : " + loShared.getInt(Rune.LO, 0) + " 개 ]");
        mBinding.tvLoUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.LO, loShared, loEditor, mBinding.tvLoUpdateView, mBinding.loBackground);
            }
        });
        mBinding.tvLoDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.LO, loShared, loEditor, mBinding.tvLoUpdateView, mBinding.loBackground);
            }
        });

        mBinding.tvSurUpdateView.setText("[ 보유 수량 : " + surShared.getInt(Rune.SUR, 0) + " 개 ]");
        mBinding.tvSurUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.SUR, surShared, surEditor, mBinding.tvSurUpdateView, mBinding.surBackground);
            }
        });

        mBinding.tvSurDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.SUR, surShared, surEditor, mBinding.tvSurUpdateView, mBinding.surBackground);
            }
        });

        mBinding.tvBerUpdateView.setText("[ 보유 수량 : " + berShared.getInt(Rune.BER, 0) + " 개 ]");
        mBinding.tvBerUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.BER, berShared, berEditor, mBinding.tvBerUpdateView, mBinding.berBackground);
            }
        });
        mBinding.tvBerDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.BER, berShared, berEditor, mBinding.tvBerUpdateView, mBinding.berBackground);
            }
        });

        mBinding.tvJahUpdateView.setText("[ 보유 수량 : " + jahShared.getInt(Rune.JAH, 0) + " 개 ]");
        mBinding.tvJahUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.JAH, jahShared, jahEditor, mBinding.tvJahUpdateView, mBinding.jahBackground);
            }
        });
        mBinding.tvJahDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.JAH, jahShared, jahEditor, mBinding.tvJahUpdateView, mBinding.jahBackground);
            }
        });

        mBinding.tvChamUpdateView.setText("[ 보유 수량 : " + chamShared.getInt(Rune.CHAM, 0) + " 개 ]");
        mBinding.tvChamUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.CHAM, chamShared, chamEditor, mBinding.tvChamUpdateView, mBinding.chamBackground);
            }
        });
        mBinding.tvChamDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.CHAM, chamShared, chamEditor, mBinding.tvChamUpdateView, mBinding.chamBackground);
            }
        });

        mBinding.tvZodUpdateView.setText("[ 보유 수량 : " + zodShared.getInt(Rune.ZOD, 0) + " 개 ]");
        mBinding.tvZodUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.ZOD, zodShared, zodEditor, mBinding.tvZodUpdateView, mBinding.zodBackground);
            }
        });

        mBinding.tvZodDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.ZOD, zodShared, zodEditor, mBinding.tvZodUpdateView, mBinding.zodBackground);
            }
        });

        mBinding.tvRuneMixture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MixtureRune.class);
                startActivity(intent);
            }
        });

        mBinding.tvRuneClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog showDialog = new ShowDialog();
                showDialog.ss(MainActivity.this, "확인 버튼을 누르면 현재 소지하고 있는\n룬들이 모두 초기화 됩니다.", new DataCallBack() {
                    @Override
                    public void call() {
                        clearRuneUpdate();
                    }
                });
            }
        });

        if (el > 0) {
            mBinding.elBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.elBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (eld > 0) {
            mBinding.eldBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.eldBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (tir > 0) {
            mBinding.tirBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.tirBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (nef > 0) {
            mBinding.nefBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.nefBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (eth > 0) {
            mBinding.ethBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.ethBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (ith > 0) {
            mBinding.ithBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.ithBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (tal > 0) {
            mBinding.talBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.talBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (ral > 0) {
            mBinding.ralBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.ralBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (ort > 0) {
            mBinding.ortBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.ortBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (thul > 0) {
            mBinding.thulBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.thulBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        int amn = amnShared.getInt(Rune.AMN, 0);
        if (amn > 0) {
            mBinding.amnBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.amnBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        int sol = solShared.getInt(Rune.SOL, 0);
        if (sol > 0) {
            mBinding.solBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.solBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (shael > 0) {
            mBinding.shaelBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.shaelBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (dol > 0) {
            mBinding.dolBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.dolBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (hel > 0) {
            mBinding.helBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.helBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (io > 0) {
            mBinding.ioBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.ioBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (lum > 0) {
            mBinding.lumBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.lumBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (ko > 0) {
            mBinding.koBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.koBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (fal > 0) {
            mBinding.falBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.falBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (lem > 0) {
            mBinding.lemBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.lemBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (pul > 0) {
            mBinding.pulBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.pulBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (um > 0) {
            mBinding.umBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.umBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (mal > 0) {
            mBinding.malBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.malBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (ist > 0) {
            mBinding.istBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.istBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        int gul = gulShared.getInt(Rune.GUL, 0);
        if (gul > 0) {
            mBinding.gulBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.gulBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (vex > 0) {
            mBinding.vexBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.vexBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (ohm > 0) {
            mBinding.ohmBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.ohmBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (lo > 0) {
            mBinding.loBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.loBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (sur > 0) {
            mBinding.surBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.surBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (ber > 0) {
            mBinding.berBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.berBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (jah > 0) {
            mBinding.jahBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.jahBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (cham > 0) {
            mBinding.chamBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.chamBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        if (zod > 0) {
            mBinding.zodBackground.setBackgroundResource(R.drawable.back_give_item);
        } else {
            mBinding.zodBackground.setBackgroundResource(R.drawable.back_none_item);
        }

        mBinding.elBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("el", "el");
                startActivity(intent);
            }
        });

        mBinding.eldBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("eld", "eld");
                startActivity(intent);
            }
        });

        mBinding.tirBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("tir", "tir");
                startActivity(intent);
            }
        });

        mBinding.nefBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("nef", "nef");
                startActivity(intent);
            }
        });

        mBinding.ethBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("eth", "eth");
                startActivity(intent);
            }
        });

        mBinding.ithBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("ith", "ith");
                startActivity(intent);
            }
        });

        mBinding.talBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("tal", "tal");
                startActivity(intent);
            }
        });

        mBinding.ralBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("ral", "ral");
                startActivity(intent);
            }
        });

        mBinding.ortBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("ort", "ort");
                startActivity(intent);
            }
        });

        mBinding.thulBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("thul", "thul");
                startActivity(intent);
            }
        });

        mBinding.amnBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("amn", "amn");
                startActivity(intent);
            }
        });

        mBinding.solBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("sol", "sol");
                startActivity(intent);
            }
        });

        mBinding.shaelBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("shael", "shael");
                startActivity(intent);
            }
        });

        mBinding.dolBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("dol", "dol");
                startActivity(intent);
            }
        });

        mBinding.helBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("hel", "hel");
                startActivity(intent);
            }
        });

        mBinding.ioBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("io", "io");
                startActivity(intent);
            }
        });

        mBinding.lumBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("lum", "lum");
                startActivity(intent);
            }
        });

        mBinding.koBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("ko", "ko");
                startActivity(intent);
            }
        });

        mBinding.falBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("fal", "fal");
                startActivity(intent);
            }
        });

        mBinding.lemBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("lem", "lem");
                startActivity(intent);
            }
        });

        mBinding.pulBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("pul", "pul");
                startActivity(intent);
            }
        });

        mBinding.umBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("um", "um");
                startActivity(intent);
            }
        });

        mBinding.malBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("mal", "mal");
                startActivity(intent);
            }
        });

        mBinding.istBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("ist", "ist");
                startActivity(intent);
            }
        });

        mBinding.gulBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("gul", "gul");
                startActivity(intent);
            }
        });

        mBinding.vexBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("vex", "vex");
                startActivity(intent);
            }
        });

        mBinding.ohmBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("ohm", "ohm");
                startActivity(intent);
            }
        });

        mBinding.loBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("lo", "lo");
                startActivity(intent);
            }
        });

        mBinding.surBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("sur", "sur");
                startActivity(intent);
            }
        });

        mBinding.berBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("ber", "ber");
                startActivity(intent);
            }
        });

        mBinding.jahBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("jah", "jah");
                startActivity(intent);
            }
        });

        mBinding.chamBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("cham", "cham");
                startActivity(intent);
            }
        });

        mBinding.zodBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRune.class);
                intent.putExtra("zod", "zod");
                startActivity(intent);
            }
        });

        // 초기설정
        setBackgroundSettings(elShared, Rune.EL, mBinding.tvRuneEl, mBinding.tvElUpdateView);
        setBackgroundSettings(eldShared, Rune.ELD, mBinding.tvRuneEld, mBinding.tvEldUpdateView);
        setBackgroundSettings(tirShared, Rune.TIR, mBinding.tvRuneTir, mBinding.tvTirUpdateView);
        setBackgroundSettings(nefShared, Rune.NEF, mBinding.tvRuneNef, mBinding.tvNefUpdateView);
        setBackgroundSettings(ethShared, Rune.ETH, mBinding.tvRuneEth, mBinding.tvEthUpdateView);
        setBackgroundSettings(ithShared, Rune.ITH, mBinding.tvRuneIth, mBinding.tvIthUpdateView);
        setBackgroundSettings(talShared, Rune.TAL, mBinding.tvRuneTal, mBinding.tvTalUpdateView);
        setBackgroundSettings(ralShared, Rune.RAL, mBinding.tvRuneRal, mBinding.tvRalUpdateView);
        setBackgroundSettings(ortShared, Rune.ORT, mBinding.tvRuneOrt, mBinding.tvOrtUpdateView);
        setBackgroundSettings(thulShared, Rune.THUL, mBinding.tvRuneThul, mBinding.tvThulUpdateView);
        setBackgroundSettings(amnShared, Rune.AMN, mBinding.tvRuneAmn, mBinding.tvAmnUpdateView);
        setBackgroundSettings(solShared, Rune.SOL, mBinding.tvRuneSol, mBinding.tvSolUpdateView);
        setBackgroundSettings(shaelShared, Rune.SHAEL, mBinding.tvRuneShael, mBinding.tvShaelUpdateView);
        setBackgroundSettings(dolShared, Rune.DOL, mBinding.tvRuneDol, mBinding.tvDolUpdateView);
        setBackgroundSettings(helShared, Rune.HEL, mBinding.tvRuneHel, mBinding.tvHelUpdateView);
        setBackgroundSettings(ioShared, Rune.IO, mBinding.tvRuneIo, mBinding.tvIoUpdateView);
        setBackgroundSettings(lumShared, Rune.LUM, mBinding.tvRuneLum, mBinding.tvLumUpdateView);
        setBackgroundSettings(koShared, Rune.KO, mBinding.tvRuneKo, mBinding.tvKoUpdateView);
        setBackgroundSettings(falShared, Rune.FAL, mBinding.tvRuneFal, mBinding.tvFalUpdateView);
        setBackgroundSettings(lemShared, Rune.LEM, mBinding.tvRuneLem, mBinding.tvLemUpdateView);
        setBackgroundSettings(pulShared, Rune.PUL, mBinding.tvRunePul, mBinding.tvPulUpdateView);
        setBackgroundSettings(umShared, Rune.UM, mBinding.tvRuneUm, mBinding.tvUmUpdateView);
        setBackgroundSettings(malShared, Rune.MAL, mBinding.tvRuneMal, mBinding.tvMalUpdateView);
        setBackgroundSettings(istShared, Rune.IST, mBinding.tvRuneIst, mBinding.tvIstUpdateView);
        setBackgroundSettings(gulShared, Rune.GUL, mBinding.tvRuneGul, mBinding.tvGulUpdateView);
        setBackgroundSettings(vexShared, Rune.VEX, mBinding.tvRuneVex, mBinding.tvVexUpdateView);
        setBackgroundSettings(ohmShared, Rune.OHM, mBinding.tvRuneOhm, mBinding.tvOhmUpdateView);
        setBackgroundSettings(loShared, Rune.LO, mBinding.tvRuneLo, mBinding.tvLoUpdateView);
        setBackgroundSettings(surShared, Rune.SUR, mBinding.tvRuneSur, mBinding.tvSurUpdateView);
        setBackgroundSettings(berShared, Rune.BER, mBinding.tvRuneBer, mBinding.tvBerUpdateView);
        setBackgroundSettings(jahShared, Rune.JAH, mBinding.tvRuneJah, mBinding.tvJahUpdateView);
        setBackgroundSettings(chamShared, Rune.CHAM, mBinding.tvRuneCham, mBinding.tvChamUpdateView);
        setBackgroundSettings(zodShared, Rune.ZOD, mBinding.tvRuneZod, mBinding.tvZodUpdateView);
        onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, @Nullable String key) {

                if (key != null) {
                    if (key.equals(Rune.EL)) {
                        setBackgroundSettings(elShared, Rune.EL, mBinding.tvRuneEl, mBinding.tvElUpdateView);
                    } else if (key.equals(Rune.ELD)) {
                        setBackgroundSettings(eldShared, Rune.ELD, mBinding.tvRuneEld, mBinding.tvEldUpdateView);
                    } else if (key.equals(Rune.TIR)) {
                        setBackgroundSettings(tirShared, Rune.TIR, mBinding.tvRuneTir, mBinding.tvTirUpdateView);
                    } else if (key.equals(Rune.NEF)) {
                        setBackgroundSettings(nefShared, Rune.NEF, mBinding.tvRuneNef, mBinding.tvNefUpdateView);
                    } else if (key.equals(Rune.ETH)) {
                        setBackgroundSettings(ethShared, Rune.ETH, mBinding.tvRuneEth, mBinding.tvEthUpdateView);
                    } else if (key.equals(Rune.ITH)) {
                        setBackgroundSettings(ithShared, Rune.ITH, mBinding.tvRuneIth, mBinding.tvIthUpdateView);
                    } else if (key.equals(Rune.TAL)) {
                        setBackgroundSettings(talShared, Rune.TAL, mBinding.tvRuneTal, mBinding.tvTalUpdateView);
                    } else if (key.equals(Rune.RAL)) {
                        setBackgroundSettings(ralShared, Rune.RAL, mBinding.tvRuneRal, mBinding.tvRalUpdateView);
                    } else if (key.equals(Rune.ORT)) {
                        setBackgroundSettings(ortShared, Rune.ORT, mBinding.tvRuneOrt, mBinding.tvOrtUpdateView);
                    } else if (key.equals(Rune.THUL)) {
                        setBackgroundSettings(thulShared, Rune.THUL, mBinding.tvRuneThul, mBinding.tvThulUpdateView);
                    } else if (key.equals(Rune.AMN)) {
                        setBackgroundSettings(amnShared, Rune.AMN, mBinding.tvRuneAmn, mBinding.tvAmnUpdateView);
                    } else if (key.equals(Rune.SOL)) {
                        setBackgroundSettings(solShared, Rune.SOL, mBinding.tvRuneSol, mBinding.tvSolUpdateView);
                    } else if (key.equals(Rune.SHAEL)) {
                        setBackgroundSettings(shaelShared, Rune.SHAEL, mBinding.tvRuneShael, mBinding.tvShaelUpdateView);
                    } else if (key.equals(Rune.DOL)) {
                        setBackgroundSettings(dolShared, Rune.DOL, mBinding.tvRuneDol, mBinding.tvDolUpdateView);
                    } else if (key.equals(Rune.HEL)) {
                        setBackgroundSettings(helShared, Rune.HEL, mBinding.tvRuneHel, mBinding.tvHelUpdateView);
                    } else if (key.equals(Rune.IO)) {
                        setBackgroundSettings(ioShared, Rune.IO, mBinding.tvRuneIo, mBinding.tvIoUpdateView);
                    } else if (key.equals(Rune.LUM)) {
                        setBackgroundSettings(lumShared, Rune.LUM, mBinding.tvRuneLum, mBinding.tvLumUpdateView);
                    } else if (key.equals(Rune.KO)) {
                        setBackgroundSettings(koShared, Rune.KO, mBinding.tvRuneKo, mBinding.tvKoUpdateView);
                    } else if (key.equals(Rune.FAL)) {
                        setBackgroundSettings(falShared, Rune.FAL, mBinding.tvRuneFal, mBinding.tvFalUpdateView);
                    } else if (key.equals(Rune.LEM)) {
                        setBackgroundSettings(lemShared, Rune.LEM, mBinding.tvRuneLem, mBinding.tvLemUpdateView);
                    } else if (key.equals(Rune.PUL)) {
                        setBackgroundSettings(pulShared, Rune.PUL, mBinding.tvRunePul, mBinding.tvPulUpdateView);
                    } else if (key.equals(Rune.UM)) {
                        setBackgroundSettings(umShared, Rune.UM, mBinding.tvRuneUm, mBinding.tvUmUpdateView);
                    } else if (key.equals(Rune.MAL)) {
                        setBackgroundSettings(malShared, Rune.MAL, mBinding.tvRuneMal, mBinding.tvMalUpdateView);
                    } else if (key.equals(Rune.IST)) {
                        setBackgroundSettings(istShared, Rune.IST, mBinding.tvRuneIst, mBinding.tvIstUpdateView);
                    } else if (key.equals(Rune.GUL)) {
                        setBackgroundSettings(gulShared, Rune.GUL, mBinding.tvRuneGul, mBinding.tvGulUpdateView);
                    } else if (key.equals(Rune.VEX)) {
                        setBackgroundSettings(vexShared, Rune.VEX, mBinding.tvRuneVex, mBinding.tvVexUpdateView);
                    } else if (key.equals(Rune.OHM)) {
                        setBackgroundSettings(ohmShared, Rune.OHM, mBinding.tvRuneOhm, mBinding.tvOhmUpdateView);
                    } else if (key.equals(Rune.LO)) {
                        setBackgroundSettings(loShared, Rune.LO, mBinding.tvRuneLo, mBinding.tvLoUpdateView);
                    } else if (key.equals(Rune.SUR)) {
                        setBackgroundSettings(surShared, Rune.SUR, mBinding.tvRuneSur, mBinding.tvSurUpdateView);
                    } else if (key.equals(Rune.BER)) {
                        setBackgroundSettings(berShared, Rune.BER, mBinding.tvRuneBer, mBinding.tvBerUpdateView);
                    } else if (key.equals(Rune.JAH)) {
                        setBackgroundSettings(jahShared, Rune.JAH, mBinding.tvRuneJah, mBinding.tvJahUpdateView);
                    } else if (key.equals(Rune.CHAM)) {
                        setBackgroundSettings(chamShared, Rune.CHAM, mBinding.tvRuneCham, mBinding.tvChamUpdateView);
                    } else if (key.equals(Rune.ZOD)) {
                        setBackgroundSettings(zodShared, Rune.ZOD, mBinding.tvRuneZod, mBinding.tvZodUpdateView);
                    }
                }

            }
        };

        elShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        eldShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        tirShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        nefShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        ethShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        ithShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        talShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        ralShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        ortShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        thulShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        amnShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        solShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        shaelShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        dolShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        helShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        ioShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        lumShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        koShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        falShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        lemShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        pulShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        umShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        malShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        istShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        gulShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        vexShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        ohmShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        loShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        surShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        berShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        jahShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        chamShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        zodShared.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);


        mBinding.ivPointP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRunePlus(Rune.EL, elShared, elEditor, mBinding.tvElUpdateView, mBinding.elBackground);
                updateRunePlus(Rune.ELD, eldShared, eldEditor, mBinding.tvEldUpdateView, mBinding.eldBackground);
                updateRunePlus(Rune.TIR, tirShared, tirEditor, mBinding.tvTirUpdateView, mBinding.tirBackground);
                updateRunePlus(Rune.NEF, nefShared, nefEditor, mBinding.tvNefUpdateView, mBinding.nefBackground);
                updateRunePlus(Rune.ETH, ethShared, ethEditor, mBinding.tvEthUpdateView, mBinding.ethBackground);
                updateRunePlus(Rune.ITH, ithShared, ithEditor, mBinding.tvIthUpdateView, mBinding.ithBackground);
                updateRunePlus(Rune.TAL, talShared, talEditor, mBinding.tvTalUpdateView, mBinding.talBackground);
                updateRunePlus(Rune.RAL, ralShared, ralEditor, mBinding.tvRalUpdateView, mBinding.ralBackground);
                updateRunePlus(Rune.ORT, ortShared, ortEditor, mBinding.tvOrtUpdateView, mBinding.ortBackground);
                updateRunePlus(Rune.THUL, thulShared, thulEditor, mBinding.tvThulUpdateView, mBinding.thulBackground);
                updateRunePlus(Rune.AMN, amnShared, amnEditor, mBinding.tvAmnUpdateView, mBinding.amnBackground);
                updateRunePlus(Rune.SOL, solShared, solEditor, mBinding.tvSolUpdateView, mBinding.solBackground);
                updateRunePlus(Rune.SHAEL, shaelShared, shaelEditor, mBinding.tvShaelUpdateView, mBinding.shaelBackground);
                updateRunePlus(Rune.DOL, dolShared, dolEditor, mBinding.tvDolUpdateView, mBinding.dolBackground);
                updateRunePlus(Rune.HEL, helShared, helEditor, mBinding.tvHelUpdateView, mBinding.helBackground);
                updateRunePlus(Rune.IO, ioShared, ioEditor, mBinding.tvIoUpdateView, mBinding.ioBackground);
                updateRunePlus(Rune.LUM, lumShared, lumEditor, mBinding.tvLumUpdateView, mBinding.lumBackground);
                updateRunePlus(Rune.KO, koShared, koEditor, mBinding.tvKoUpdateView, mBinding.koBackground);
                updateRunePlus(Rune.FAL, falShared, falEditor, mBinding.tvFalUpdateView, mBinding.falBackground);
                updateRunePlus(Rune.LEM, lemShared, lemEditor, mBinding.tvLemUpdateView, mBinding.lemBackground);
                updateRunePlus(Rune.PUL, pulShared, pulEditor, mBinding.tvPulUpdateView, mBinding.pulBackground);
                updateRunePlus(Rune.UM, umShared, umEditor, mBinding.tvUmUpdateView, mBinding.umBackground);
                updateRunePlus(Rune.MAL, malShared, malEditor, mBinding.tvMalUpdateView, mBinding.malBackground);
                updateRunePlus(Rune.IST, istShared, istEditor, mBinding.tvIstUpdateView, mBinding.istBackground);
                updateRunePlus(Rune.GUL, gulShared, gulEditor, mBinding.tvGulUpdateView, mBinding.gulBackground);
                updateRunePlus(Rune.VEX, vexShared, vexEditor, mBinding.tvVexUpdateView, mBinding.vexBackground);
                updateRunePlus(Rune.OHM, ohmShared, ohmEditor, mBinding.tvOhmUpdateView, mBinding.ohmBackground);
                updateRunePlus(Rune.LO, loShared, loEditor, mBinding.tvLoUpdateView, mBinding.loBackground);
                updateRunePlus(Rune.SUR, surShared, surEditor, mBinding.tvSurUpdateView, mBinding.surBackground);
                updateRunePlus(Rune.BER, berShared, berEditor, mBinding.tvBerUpdateView, mBinding.berBackground);
                updateRunePlus(Rune.JAH, jahShared, jahEditor, mBinding.tvJahUpdateView, mBinding.jahBackground);
                updateRunePlus(Rune.CHAM, chamShared, chamEditor, mBinding.tvChamUpdateView, mBinding.chamBackground);
                updateRunePlus(Rune.ZOD, zodShared, zodEditor, mBinding.tvZodUpdateView, mBinding.zodBackground);

            }
        });

        mBinding.ivPointM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRuneMinus(Rune.EL, elShared, elEditor, mBinding.tvElUpdateView, mBinding.elBackground);
                updateRuneMinus(Rune.ELD, eldShared, eldEditor, mBinding.tvEldUpdateView, mBinding.eldBackground);
                updateRuneMinus(Rune.TIR, tirShared, tirEditor, mBinding.tvTirUpdateView, mBinding.tirBackground);
                updateRuneMinus(Rune.NEF, nefShared, nefEditor, mBinding.tvNefUpdateView, mBinding.nefBackground);
                updateRuneMinus(Rune.ETH, ethShared, ethEditor, mBinding.tvEthUpdateView, mBinding.ethBackground);
                updateRuneMinus(Rune.ITH, ithShared, ithEditor, mBinding.tvIthUpdateView, mBinding.ithBackground);
                updateRuneMinus(Rune.TAL, talShared, talEditor, mBinding.tvTalUpdateView, mBinding.talBackground);
                updateRuneMinus(Rune.RAL, ralShared, ralEditor, mBinding.tvRalUpdateView, mBinding.ralBackground);
                updateRuneMinus(Rune.ORT, ortShared, ortEditor, mBinding.tvOrtUpdateView, mBinding.ortBackground);
                updateRuneMinus(Rune.THUL, thulShared, thulEditor, mBinding.tvThulUpdateView, mBinding.thulBackground);
                updateRuneMinus(Rune.AMN, amnShared, amnEditor, mBinding.tvAmnUpdateView, mBinding.amnBackground);
                updateRuneMinus(Rune.SOL, solShared, solEditor, mBinding.tvSolUpdateView, mBinding.solBackground);
                updateRuneMinus(Rune.SHAEL, shaelShared, shaelEditor, mBinding.tvShaelUpdateView, mBinding.shaelBackground);
                updateRuneMinus(Rune.DOL, dolShared, dolEditor, mBinding.tvDolUpdateView, mBinding.dolBackground);
                updateRuneMinus(Rune.HEL, helShared, helEditor, mBinding.tvHelUpdateView, mBinding.helBackground);
                updateRuneMinus(Rune.IO, ioShared, ioEditor, mBinding.tvIoUpdateView, mBinding.ioBackground);
                updateRuneMinus(Rune.LUM, lumShared, lumEditor, mBinding.tvLumUpdateView, mBinding.lumBackground);
                updateRuneMinus(Rune.KO, koShared, koEditor, mBinding.tvKoUpdateView, mBinding.koBackground);
                updateRuneMinus(Rune.FAL, falShared, falEditor, mBinding.tvFalUpdateView, mBinding.falBackground);
                updateRuneMinus(Rune.LEM, lemShared, lemEditor, mBinding.tvLemUpdateView, mBinding.lemBackground);
                updateRuneMinus(Rune.PUL, pulShared, pulEditor, mBinding.tvPulUpdateView, mBinding.pulBackground);
                updateRuneMinus(Rune.UM, umShared, umEditor, mBinding.tvUmUpdateView, mBinding.umBackground);
                updateRuneMinus(Rune.MAL, malShared, malEditor, mBinding.tvMalUpdateView, mBinding.malBackground);
                updateRuneMinus(Rune.IST, istShared, istEditor, mBinding.tvIstUpdateView, mBinding.istBackground);
                updateRuneMinus(Rune.GUL, gulShared, gulEditor, mBinding.tvGulUpdateView, mBinding.gulBackground);
                updateRuneMinus(Rune.VEX, vexShared, vexEditor, mBinding.tvVexUpdateView, mBinding.vexBackground);
                updateRuneMinus(Rune.OHM, ohmShared, ohmEditor, mBinding.tvOhmUpdateView, mBinding.ohmBackground);
                updateRuneMinus(Rune.LO, loShared, loEditor, mBinding.tvLoUpdateView, mBinding.loBackground);
                updateRuneMinus(Rune.SUR, surShared, surEditor, mBinding.tvSurUpdateView, mBinding.surBackground);
                updateRuneMinus(Rune.BER, berShared, berEditor, mBinding.tvBerUpdateView, mBinding.berBackground);
                updateRuneMinus(Rune.JAH, jahShared, jahEditor, mBinding.tvJahUpdateView, mBinding.jahBackground);
                updateRuneMinus(Rune.CHAM, chamShared, chamEditor, mBinding.tvChamUpdateView, mBinding.chamBackground);
                updateRuneMinus(Rune.ZOD, zodShared, zodEditor, mBinding.tvZodUpdateView, mBinding.zodBackground);

            }
        });

        String str = "aseraser";
        mBinding.tvHoradricCube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ItemDatabaseDrawerLayout.class);
                startActivity(intent);
            }
        });

        mBinding.tvCharacterDevelopment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CharacterDevelopmentDrawerLayout.class);
                startActivity(intent);
            }
        });

        mBinding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginPage.class);
                startActivity(intent);
            }
        });

        mBinding.ivSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
            }
        });

        mBinding.tvJahPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PriceShow.class);
                intent.putExtra("jah", "jah");
                startActivity(intent);
            }
        });

        mBinding.tvBerPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PriceShow.class);
                intent.putExtra("ber", "ber");
                startActivity(intent);
            }
        });

        mBinding.tvPriceWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PriceWrite.class);
                startActivity(intent);
            }
        });

    }

    private void updateRunePlus(String runeValue, SharedPreferences runeShared, SharedPreferences.Editor editor, TextView viewCount, LinearLayout background) {
        int value = runeShared.getInt(runeValue, 0);
        value = ++value;
        editor.putInt(runeValue, value);
        editor.commit();

        if (value > 0) {
            background.setBackgroundResource(R.drawable.back_give_item);
        } else {
            background.setBackgroundResource(R.drawable.back_none_item);
        }

        int viewValue = runeShared.getInt(runeValue, 0);
        String str = String.valueOf(viewValue);
        viewCount.setText("[ 보유 수량 : " + str + " 개 ]");
    }

    private void updateRuneMinus(String runeValue, SharedPreferences runeShared, SharedPreferences.Editor editor, TextView viewCount, LinearLayout background) {
        int value = runeShared.getInt(runeValue, 1);
        if (value > 0) {
            value = --value;  // 0 이상일 때만 감소
            editor.putInt(runeValue, value);
            editor.commit();
        }

        if (value > 0) {
            background.setBackgroundResource(R.drawable.back_give_item);
        } else {
            background.setBackgroundResource(R.drawable.back_none_item);
        }

        int viewValue = runeShared.getInt(runeValue, 0);
        String str = String.valueOf(viewValue);
        viewCount.setText("[ 보유 수량 : " + str + " 개 ]");
    }

    private void clearRuneUpdate() {
        mBinding.elBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.eldBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.tirBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.nefBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.ethBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.ithBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.talBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.ralBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.ortBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.thulBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.amnBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.solBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.shaelBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.dolBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.helBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.ioBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.lumBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.koBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.falBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.lemBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.pulBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.umBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.malBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.istBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.gulBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.vexBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.ohmBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.loBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.surBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.berBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.jahBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.chamBackground.setBackgroundResource(R.drawable.back_none_item);
        mBinding.zodBackground.setBackgroundResource(R.drawable.back_none_item);

        // El 룬
        SharedPreferences elShared = getSharedPreferences(Rune.EL, MODE_PRIVATE);
        SharedPreferences.Editor elEditor = elShared.edit();
        elEditor.clear();
        elEditor.apply();
        int elValue = 0;
        mBinding.tvElUpdateView.setText("[ 보유 수량 : " + elValue + " 개 ]");

// Eld 룬
        SharedPreferences eldShared = getSharedPreferences(Rune.ELD, MODE_PRIVATE);
        SharedPreferences.Editor eldEditor = eldShared.edit();
        eldEditor.clear();
        eldEditor.apply();
        int eldValue = 0;
        mBinding.tvEldUpdateView.setText("[ 보유 수량 : " + eldValue + " 개 ]");

// Tir 룬
        SharedPreferences tirShared = getSharedPreferences(Rune.TIR, MODE_PRIVATE);
        SharedPreferences.Editor tirEditor = tirShared.edit();
        tirEditor.clear();
        tirEditor.apply();
        int tirValue = 0;
        mBinding.tvTirUpdateView.setText("[ 보유 수량 : " + tirValue + " 개 ]");

// Nef 룬
        SharedPreferences nefShared = getSharedPreferences(Rune.NEF, MODE_PRIVATE);
        SharedPreferences.Editor nefEditor = nefShared.edit();
        nefEditor.clear();
        nefEditor.apply();
        int nefValue = 0;
        mBinding.tvNefUpdateView.setText("[ 보유 수량 : " + nefValue + " 개 ]");

// Eth 룬
        SharedPreferences ethShared = getSharedPreferences(Rune.ETH, MODE_PRIVATE);
        SharedPreferences.Editor ethEditor = ethShared.edit();
        ethEditor.clear();
        ethEditor.apply();
        int ethValue = 0;
        mBinding.tvEthUpdateView.setText("[ 보유 수량 : " + ethValue + " 개 ]");

// Ith 룬
        SharedPreferences ithShared = getSharedPreferences(Rune.ITH, MODE_PRIVATE);
        SharedPreferences.Editor ithEditor = ithShared.edit();
        ithEditor.clear();
        ithEditor.apply();
        int ithValue = 0;
        mBinding.tvIthUpdateView.setText("[ 보유 수량 : " + ithValue + " 개 ]");

// Tal 룬
        SharedPreferences talShared = getSharedPreferences(Rune.TAL, MODE_PRIVATE);
        SharedPreferences.Editor talEditor = talShared.edit();
        talEditor.clear();
        talEditor.apply();
        int talValue = 0;
        mBinding.tvTalUpdateView.setText("[ 보유 수량 : " + talValue + " 개 ]");

// Ral 룬
        SharedPreferences ralShared = getSharedPreferences(Rune.RAL, MODE_PRIVATE);
        SharedPreferences.Editor ralEditor = ralShared.edit();
        ralEditor.clear();
        ralEditor.apply();
        int ralValue = 0;
        mBinding.tvRalUpdateView.setText("[ 보유 수량 : " + ralValue + " 개 ]");

// Ort 룬
        SharedPreferences ortShared = getSharedPreferences(Rune.ORT, MODE_PRIVATE);
        SharedPreferences.Editor ortEditor = ortShared.edit();
        ortEditor.clear();
        ortEditor.apply();
        int ortValue = 0;
        mBinding.tvOrtUpdateView.setText("[ 보유 수량 : " + ortValue + " 개 ]");

// Thul 룬
        SharedPreferences thulShared = getSharedPreferences(Rune.THUL, MODE_PRIVATE);
        SharedPreferences.Editor thulEditor = thulShared.edit();
        thulEditor.clear();
        thulEditor.apply();
        int thulValue = 0;
        mBinding.tvThulUpdateView.setText("[ 보유 수량 : " + thulValue + " 개 ]");

// Amn 룬
        SharedPreferences amnShared = getSharedPreferences(Rune.AMN, MODE_PRIVATE);
        SharedPreferences.Editor amnEditor = amnShared.edit();
        amnEditor.clear();
        amnEditor.apply();
        int amnValue = 0;
        mBinding.tvAmnUpdateView.setText("[ 보유 수량 : " + amnValue + " 개 ]");

// Sol 룬
        SharedPreferences solShared = getSharedPreferences(Rune.SOL, MODE_PRIVATE);
        SharedPreferences.Editor solEditor = solShared.edit();
        solEditor.clear();
        solEditor.apply();
        int solValue = 0;
        mBinding.tvSolUpdateView.setText("[ 보유 수량 : " + solValue + " 개 ]");

// Shael 룬
        SharedPreferences shaelShared = getSharedPreferences(Rune.SHAEL, MODE_PRIVATE);
        SharedPreferences.Editor shaelEditor = shaelShared.edit();
        shaelEditor.clear();
        shaelEditor.apply();
        int shaelValue = 0;
        mBinding.tvShaelUpdateView.setText("[ 보유 수량 : " + shaelValue + " 개 ]");

// Dol 룬
        SharedPreferences dolShared = getSharedPreferences(Rune.DOL, MODE_PRIVATE);
        SharedPreferences.Editor dolEditor = dolShared.edit();
        dolEditor.clear();
        dolEditor.apply();
        int dolValue = 0;
        mBinding.tvDolUpdateView.setText("[ 보유 수량 : " + dolValue + " 개 ]");

// Hel 룬
        SharedPreferences helShared = getSharedPreferences(Rune.HEL, MODE_PRIVATE);
        SharedPreferences.Editor helEditor = helShared.edit();
        helEditor.clear();
        helEditor.apply();
        int helValue = 0;
        mBinding.tvHelUpdateView.setText("[ 보유 수량 : " + helValue + " 개 ]");

// Io 룬
        SharedPreferences ioShared = getSharedPreferences(Rune.IO, MODE_PRIVATE);
        SharedPreferences.Editor ioEditor = ioShared.edit();
        ioEditor.clear();
        ioEditor.apply();
        int ioValue = 0;
        mBinding.tvIoUpdateView.setText("[ 보유 수량 : " + ioValue + " 개 ]");

// Lum 룬
        SharedPreferences lumShared = getSharedPreferences(Rune.LUM, MODE_PRIVATE);
        SharedPreferences.Editor lumEditor = lumShared.edit();
        lumEditor.clear();
        lumEditor.apply();
        int lumValue = 0;
        mBinding.tvLumUpdateView.setText("[ 보유 수량 : " + lumValue + " 개 ]");

// Ko 룬
        SharedPreferences koShared = getSharedPreferences(Rune.KO, MODE_PRIVATE);
        SharedPreferences.Editor koEditor = koShared.edit();
        koEditor.clear();
        koEditor.apply();
        int koValue = 0;
        mBinding.tvKoUpdateView.setText("[ 보유 수량 : " + koValue + " 개 ]");

// Fal 룬
        SharedPreferences falShared = getSharedPreferences(Rune.FAL, MODE_PRIVATE);
        SharedPreferences.Editor falEditor = falShared.edit();
        falEditor.clear();
        falEditor.apply();
        int falValue = 0;
        mBinding.tvFalUpdateView.setText("[ 보유 수량 : " + falValue + " 개 ]");

// Lem 룬
        SharedPreferences lemShared = getSharedPreferences(Rune.LEM, MODE_PRIVATE);
        SharedPreferences.Editor lemEditor = lemShared.edit();
        lemEditor.clear();
        lemEditor.apply();
        int lemValue = 0;
        mBinding.tvLemUpdateView.setText("[ 보유 수량 : " + lemValue + " 개 ]");

// Pul 룬
        SharedPreferences pulShared = getSharedPreferences(Rune.PUL, MODE_PRIVATE);
        SharedPreferences.Editor pulEditor = pulShared.edit();
        pulEditor.clear();
        pulEditor.apply();
        int pulValue = 0;
        mBinding.tvPulUpdateView.setText("[ 보유 수량 : " + pulValue + " 개 ]");

// Um 룬
        SharedPreferences umShared = getSharedPreferences(Rune.UM, MODE_PRIVATE);
        SharedPreferences.Editor umEditor = umShared.edit();
        umEditor.clear();
        umEditor.apply();
        int umValue = 0;
        mBinding.tvUmUpdateView.setText("[ 보유 수량 : " + umValue + " 개 ]");

// Mal 룬
        SharedPreferences malShared = getSharedPreferences(Rune.MAL, MODE_PRIVATE);
        SharedPreferences.Editor malEditor = malShared.edit();
        malEditor.clear();
        malEditor.apply();
        int malValue = 0;
        mBinding.tvMalUpdateView.setText("[ 보유 수량 : " + malValue + " 개 ]");

// Ist 룬
        SharedPreferences istShared = getSharedPreferences(Rune.IST, MODE_PRIVATE);
        SharedPreferences.Editor istEditor = istShared.edit();
        istEditor.clear();
        istEditor.apply();
        int istValue = 0;
        mBinding.tvIstUpdateView.setText("[ 보유 수량 : " + istValue + " 개 ]");

// Gul 룬
        SharedPreferences gulShared = getSharedPreferences(Rune.GUL, MODE_PRIVATE);
        SharedPreferences.Editor gulEditor = gulShared.edit();
        gulEditor.clear();
        gulEditor.apply();
        int gulValue = 0;
        mBinding.tvGulUpdateView.setText("[ 보유 수량 : " + gulValue + " 개 ]");

// Vex 룬
        SharedPreferences vexShared = getSharedPreferences(Rune.VEX, MODE_PRIVATE);
        SharedPreferences.Editor vexEditor = vexShared.edit();
        vexEditor.clear();
        vexEditor.apply();
        int vexValue = 0;
        mBinding.tvVexUpdateView.setText("[ 보유 수량 : " + vexValue + " 개 ]");

// Ohm 룬
        SharedPreferences ohmShared = getSharedPreferences(Rune.OHM, MODE_PRIVATE);
        SharedPreferences.Editor ohmEditor = ohmShared.edit();
        ohmEditor.clear();
        ohmEditor.apply();
        int ohmValue = 0;
        mBinding.tvOhmUpdateView.setText("[ 보유 수량 : " + ohmValue + " 개 ]");

// Lo 룬
        SharedPreferences loShared = getSharedPreferences(Rune.LO, MODE_PRIVATE);
        SharedPreferences.Editor loEditor = loShared.edit();
        loEditor.clear();
        loEditor.apply();
        int loValue = 0;
        mBinding.tvLoUpdateView.setText("[ 보유 수량 : " + loValue + " 개 ]");

// Sur 룬
        SharedPreferences surShared = getSharedPreferences(Rune.SUR, MODE_PRIVATE);
        SharedPreferences.Editor surEditor = surShared.edit();
        surEditor.clear();
        surEditor.apply();
        int surValue = 0;
        mBinding.tvSurUpdateView.setText("[ 보유 수량 : " + surValue + " 개 ]");

// Ber 룬
        SharedPreferences berShared = getSharedPreferences(Rune.BER, MODE_PRIVATE);
        SharedPreferences.Editor berEditor = berShared.edit();
        berEditor.clear();
        berEditor.apply();
        int berValue = 0;
        mBinding.tvBerUpdateView.setText("[ 보유 수량 : " + berValue + " 개 ]");

// Jah 룬
        SharedPreferences jahShared = getSharedPreferences(Rune.JAH, MODE_PRIVATE);
        SharedPreferences.Editor jahEditor = jahShared.edit();
        jahEditor.clear();
        jahEditor.apply();
        int jahValue = 0;
        mBinding.tvJahUpdateView.setText("[ 보유 수량 : " + jahValue + " 개 ]");

// Cham 룬
        SharedPreferences chamShared = getSharedPreferences(Rune.CHAM, MODE_PRIVATE);
        SharedPreferences.Editor chamEditor = chamShared.edit();
        chamEditor.clear();
        chamEditor.apply();
        int chamValue = 0;
        mBinding.tvChamUpdateView.setText("[ 보유 수량 : " + chamValue + " 개 ]");

// Zod 룬
        SharedPreferences zodShared = getSharedPreferences(Rune.ZOD, MODE_PRIVATE);
        SharedPreferences.Editor zodEditor = zodShared.edit();
        zodEditor.clear();
        zodEditor.apply();
        int zodValue = 0;
        mBinding.tvZodUpdateView.setText("[ 보유 수량 : " + zodValue + " 개 ]");
        setBackgroundSettings(elShared, Rune.EL, mBinding.tvRuneEl, mBinding.tvElUpdateView);
        setBackgroundSettings(eldShared, Rune.ELD, mBinding.tvRuneEld, mBinding.tvEldUpdateView);
        setBackgroundSettings(tirShared, Rune.TIR, mBinding.tvRuneTir, mBinding.tvTirUpdateView);
        setBackgroundSettings(nefShared, Rune.NEF, mBinding.tvRuneNef, mBinding.tvNefUpdateView);
        setBackgroundSettings(ethShared, Rune.ETH, mBinding.tvRuneEth, mBinding.tvEthUpdateView);
        setBackgroundSettings(ithShared, Rune.ITH, mBinding.tvRuneIth, mBinding.tvIthUpdateView);
        setBackgroundSettings(talShared, Rune.TAL, mBinding.tvRuneTal, mBinding.tvTalUpdateView);
        setBackgroundSettings(ralShared, Rune.RAL, mBinding.tvRuneRal, mBinding.tvRalUpdateView);
        setBackgroundSettings(ortShared, Rune.ORT, mBinding.tvRuneOrt, mBinding.tvOrtUpdateView);
        setBackgroundSettings(thulShared, Rune.THUL, mBinding.tvRuneThul, mBinding.tvThulUpdateView);
        setBackgroundSettings(amnShared, Rune.AMN, mBinding.tvRuneAmn, mBinding.tvAmnUpdateView);
        setBackgroundSettings(solShared, Rune.SOL, mBinding.tvRuneSol, mBinding.tvSolUpdateView);
        setBackgroundSettings(shaelShared, Rune.SHAEL, mBinding.tvRuneShael, mBinding.tvShaelUpdateView);
        setBackgroundSettings(dolShared, Rune.DOL, mBinding.tvRuneDol, mBinding.tvDolUpdateView);
        setBackgroundSettings(helShared, Rune.HEL, mBinding.tvRuneHel, mBinding.tvHelUpdateView);
        setBackgroundSettings(ioShared, Rune.IO, mBinding.tvRuneIo, mBinding.tvIoUpdateView);
        setBackgroundSettings(lumShared, Rune.LUM, mBinding.tvRuneLum, mBinding.tvLumUpdateView);
        setBackgroundSettings(koShared, Rune.KO, mBinding.tvRuneKo, mBinding.tvKoUpdateView);
        setBackgroundSettings(falShared, Rune.FAL, mBinding.tvRuneFal, mBinding.tvFalUpdateView);
        setBackgroundSettings(lemShared, Rune.LEM, mBinding.tvRuneLem, mBinding.tvLemUpdateView);
        setBackgroundSettings(pulShared, Rune.PUL, mBinding.tvRunePul, mBinding.tvPulUpdateView);
        setBackgroundSettings(umShared, Rune.UM, mBinding.tvRuneUm, mBinding.tvUmUpdateView);
        setBackgroundSettings(malShared, Rune.MAL, mBinding.tvRuneMal, mBinding.tvMalUpdateView);
        setBackgroundSettings(istShared, Rune.IST, mBinding.tvRuneIst, mBinding.tvIstUpdateView);
        setBackgroundSettings(gulShared, Rune.GUL, mBinding.tvRuneGul, mBinding.tvGulUpdateView);
        setBackgroundSettings(vexShared, Rune.VEX, mBinding.tvRuneVex, mBinding.tvVexUpdateView);
        setBackgroundSettings(ohmShared, Rune.OHM, mBinding.tvRuneOhm, mBinding.tvOhmUpdateView);
        setBackgroundSettings(loShared, Rune.LO, mBinding.tvRuneLo, mBinding.tvLoUpdateView);
        setBackgroundSettings(surShared, Rune.SUR, mBinding.tvRuneSur, mBinding.tvSurUpdateView);
        setBackgroundSettings(berShared, Rune.BER, mBinding.tvRuneBer, mBinding.tvBerUpdateView);
        setBackgroundSettings(jahShared, Rune.JAH, mBinding.tvRuneJah, mBinding.tvJahUpdateView);
        setBackgroundSettings(chamShared, Rune.CHAM, mBinding.tvRuneCham, mBinding.tvChamUpdateView);
        setBackgroundSettings(zodShared, Rune.ZOD, mBinding.tvRuneZod, mBinding.tvZodUpdateView);
    }

    private void setBackgroundSettings(SharedPreferences editor, String rune, TextView runeName, TextView runeUpdate) {
        int value = editor.getInt(rune, 0);
        if (value == 0) {
            runeName.setTextColor(getResources().getColor(R.color.dia_color_none, getTheme()));
            runeUpdate.setTextColor(getResources().getColor(R.color.dia_color_none, getTheme()));
        } else {
            runeName.setTextColor(getResources().getColor(R.color.dia_color, getTheme()));
            runeUpdate.setTextColor(getResources().getColor(R.color.dia_color, getTheme()));
        }
    }

    // 액티비티 강제 재시작 메서드
    private void restartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (onSharedPreferenceChangeListener != null) {
            fontSharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }

        SharedPreferences elShared = getSharedPreferences(Rune.EL, MODE_PRIVATE);
        SharedPreferences eldShared = getSharedPreferences(Rune.ELD, MODE_PRIVATE);
        SharedPreferences tirShared = getSharedPreferences(Rune.TIR, MODE_PRIVATE);
        SharedPreferences nefShared = getSharedPreferences(Rune.NEF, MODE_PRIVATE);
        SharedPreferences ethShared = getSharedPreferences(Rune.ETH, MODE_PRIVATE);
        SharedPreferences ithShared = getSharedPreferences(Rune.ITH, MODE_PRIVATE);
        SharedPreferences talShared = getSharedPreferences(Rune.TAL, MODE_PRIVATE);
        SharedPreferences ralShared = getSharedPreferences(Rune.RAL, MODE_PRIVATE);
        SharedPreferences ortShared = getSharedPreferences(Rune.ORT, MODE_PRIVATE);
        SharedPreferences thulShared = getSharedPreferences(Rune.THUL, MODE_PRIVATE);
        SharedPreferences amnShared = getSharedPreferences(Rune.AMN, MODE_PRIVATE);
        SharedPreferences solShared = getSharedPreferences(Rune.SOL, MODE_PRIVATE);
        SharedPreferences shaelShared = getSharedPreferences(Rune.SHAEL, MODE_PRIVATE);
        SharedPreferences dolShared = getSharedPreferences(Rune.DOL, MODE_PRIVATE);
        SharedPreferences helShared = getSharedPreferences(Rune.HEL, MODE_PRIVATE);
        SharedPreferences ioShared = getSharedPreferences(Rune.IO, MODE_PRIVATE);
        SharedPreferences lumShared = getSharedPreferences(Rune.LUM, MODE_PRIVATE);
        SharedPreferences koShared = getSharedPreferences(Rune.KO, MODE_PRIVATE);
        SharedPreferences falShared = getSharedPreferences(Rune.FAL, MODE_PRIVATE);
        SharedPreferences lemShared = getSharedPreferences(Rune.LEM, MODE_PRIVATE);
        SharedPreferences pulShared = getSharedPreferences(Rune.PUL, MODE_PRIVATE);
        SharedPreferences umShared = getSharedPreferences(Rune.UM, MODE_PRIVATE);
        SharedPreferences malShared = getSharedPreferences(Rune.MAL, MODE_PRIVATE);
        SharedPreferences istShared = getSharedPreferences(Rune.IST, MODE_PRIVATE);
        SharedPreferences gulShared = getSharedPreferences(Rune.GUL, MODE_PRIVATE);
        SharedPreferences vexShared = getSharedPreferences(Rune.VEX, MODE_PRIVATE);
        SharedPreferences ohmShared = getSharedPreferences(Rune.OHM, MODE_PRIVATE);
        SharedPreferences loShared = getSharedPreferences(Rune.LO, MODE_PRIVATE);
        SharedPreferences surShared = getSharedPreferences(Rune.SUR, MODE_PRIVATE);
        SharedPreferences berShared = getSharedPreferences(Rune.BER, MODE_PRIVATE);
        SharedPreferences jahShared = getSharedPreferences(Rune.JAH, MODE_PRIVATE);
        SharedPreferences chamShared = getSharedPreferences(Rune.CHAM, MODE_PRIVATE);
        SharedPreferences zodShared = getSharedPreferences(Rune.ZOD, MODE_PRIVATE);

        elShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        eldShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        tirShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        nefShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        ethShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        ithShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        talShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        ralShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        ortShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        thulShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        amnShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        solShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        shaelShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        dolShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        helShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        ioShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        lumShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        koShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        falShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        lemShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        pulShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        umShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        malShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        istShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        gulShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        vexShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        ohmShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        loShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        surShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        berShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        jahShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        chamShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        zodShared.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_ID,
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(serviceChannel);
            }
        }
    }

    private void initializeDefaultPreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Act 1 기본값 설정
        editor.putBoolean("act1_1", sharedPreferences.getBoolean("act1_1", false));
        editor.putBoolean("act1_2", sharedPreferences.getBoolean("act1_2", false));
        editor.putBoolean("act1_3", sharedPreferences.getBoolean("act1_3", false));
        editor.putBoolean("act1_4", sharedPreferences.getBoolean("act1_4", false));
        editor.putBoolean("act1_5", sharedPreferences.getBoolean("act1_5", false));
        editor.putBoolean("act1_6", sharedPreferences.getBoolean("act1_6", false));
        editor.putBoolean("act1_7", sharedPreferences.getBoolean("act1_7", false));
        editor.putBoolean("act1_8", sharedPreferences.getBoolean("act1_8", false));
        editor.putBoolean("act1_9", sharedPreferences.getBoolean("act1_9", false));
        editor.putBoolean("act1_10", sharedPreferences.getBoolean("act1_10", false));
        editor.putBoolean("act1_11", sharedPreferences.getBoolean("act1_11", false));
        editor.putBoolean("act1_12", sharedPreferences.getBoolean("act1_12", false));

        // Act 2 기본값 설정
        editor.putBoolean("act2_1", sharedPreferences.getBoolean("act2_1", false));
        editor.putBoolean("act2_2", sharedPreferences.getBoolean("act2_2", false));
        editor.putBoolean("act2_3", sharedPreferences.getBoolean("act2_3", false));
        editor.putBoolean("act2_4", sharedPreferences.getBoolean("act2_4", false));
        editor.putBoolean("act2_5", sharedPreferences.getBoolean("act2_5", false));
        editor.putBoolean("act2_6", sharedPreferences.getBoolean("act2_6", false));
        editor.putBoolean("act2_7", sharedPreferences.getBoolean("act2_7", false));
        editor.putBoolean("act2_8", sharedPreferences.getBoolean("act2_8", false));

        // Act 3 기본값 설정
        editor.putBoolean("act3_1", sharedPreferences.getBoolean("act3_1", false));
        editor.putBoolean("act3_2", sharedPreferences.getBoolean("act3_2", false));
        editor.putBoolean("act3_3", sharedPreferences.getBoolean("act3_3", false));
        editor.putBoolean("act3_4", sharedPreferences.getBoolean("act3_4", false));
        editor.putBoolean("act3_5", sharedPreferences.getBoolean("act3_5", false));
        editor.putBoolean("act3_6", sharedPreferences.getBoolean("act3_6", false));

        // Act 4 기본값 설정
        editor.putBoolean("act4_1", sharedPreferences.getBoolean("act4_1", false));
        editor.putBoolean("act4_2", sharedPreferences.getBoolean("act4_2", false));
        editor.putBoolean("act4_3", sharedPreferences.getBoolean("act4_3", false));

        // Act 5 기본값 설정
        editor.putBoolean("act5_1", sharedPreferences.getBoolean("act5_1", false));
        editor.putBoolean("act5_2", sharedPreferences.getBoolean("act5_2", false));
        editor.putBoolean("act5_3", sharedPreferences.getBoolean("act5_3", false));
        editor.putBoolean("act5_4", sharedPreferences.getBoolean("act5_4", false));
        editor.putBoolean("act5_5", sharedPreferences.getBoolean("act5_5", false));
        editor.putBoolean("act5_6", sharedPreferences.getBoolean("act5_6", false));
        editor.putBoolean("act5_7", sharedPreferences.getBoolean("act5_7", false));

        // 변경사항 적용
        editor.apply();
    }

    private void checkAndStartAlarms() {
        if (isAlarmPermissionGranted && isBatteryOptimizationDisabled) {
            UberAlarmManager.setRepeatingAlarms(this);
            TerrorZoneAlarmManager.setRepeatingAlarms(this);
        }


    }
}