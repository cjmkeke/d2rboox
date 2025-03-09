package com.cjmkeke.d2rbooks.service.background;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.service.background.constants.TerrorZoneConstantsKor;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TerrorZone extends Service {

    private static final String CHANNEL_ID = "공포의 영역 알림";
    private static String TAG = "TerrorZone";
    private String currentTerrorZone;
    private String nextTerrorZone;
    private SharedPreferences sharedPreferences;
    private String message = "기본 메시지";  // 기본 메시지로 초기화
    private SharedPreferences terrorZoneSharedPerrferences;
    private SharedPreferences.OnSharedPreferenceChangeListener onTerrorZoneSharedPreferenceChangeListener;
    private static String TITLE_MESSAGE = "다음 테러존 : ";
    private static boolean notificationTriggeredByWebView = true; // Flag to prevent duplicate notifications
    private static final String API_KEY = "https://d2emu.com/api/v1/tz";
    private static final int TERROR_NOTIFICATION_ID = 10; // 고유 알림 ID
    private static SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener;
    private static boolean isAlarmEnabled;
    private static SharedPreferences toggleButtonSharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
        startForeground(TERROR_NOTIFICATION_ID, getNotification()); // 고유 알림 ID

    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID, // TerrorZone에 고유한 채널 ID
                    "테러존 서비스 실행중",
                    NotificationManager.IMPORTANCE_LOW
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
    }

    private Notification getNotification() {
        return new Notification.Builder(this, CHANNEL_ID) // 고유 채널 ID 사용
                .setContentTitle("테러존 서비스 실행중")
                .setSmallIcon(R.drawable.icons_terror_on) // 적절한 아이콘 추가
                .build();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Firebase Database 참조 초기화
        sharedPreferences = getSharedPreferences("terror_zone", Context.MODE_PRIVATE);

        toggleButtonSharedPreferences = getSharedPreferences(SharedValue.TOGGLE_BUTTON_SETTINGS, MODE_PRIVATE);
        isAlarmEnabled = toggleButtonSharedPreferences.getBoolean("toggle_button_terror_zone", true); // 초기화
        onSharedPreferenceChangeListener = (sharedPreferences, key) -> {
            if ("toggle_button_terror_zone".equals(key)) {
                isAlarmEnabled = toggleButtonSharedPreferences.getBoolean("toggle_button_terror_zone", true);
                Log.d(TAG, "알람 상태 변경 TerrorZoneAlarmManager : " + isAlarmEnabled);
            }
        };

        toggleButtonSharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);

        if (isAlarmEnabled) {
            if (notificationTriggeredByWebView) { // Check if notification was already triggered by WebView
                updateNotification("공포의 영역", "공포의 영역을 설정해주세요.");
            }
            notificationTriggeredByWebView = false;

            addDatabaseListener();
        }


        return START_NOT_STICKY;
    }

    private void addDatabaseListener() {

        try {
            FirebaseCrashlytics.getInstance().log("TerrorZone Background started");
            FirebaseCrashlytics.getInstance().setCustomKey("Fragment", "Background TerrorZone");

            Map<String, String> terrorZoneMap = new HashMap<>();
            terrorZoneMap.put("2", TerrorZoneConstantsKor.ACT1_1);
            terrorZoneMap.put("3", TerrorZoneConstantsKor.ACT1_2);
            terrorZoneMap.put("17", TerrorZoneConstantsKor.ACT1_3);
            terrorZoneMap.put("4", TerrorZoneConstantsKor.ACT1_4);
            terrorZoneMap.put("38", TerrorZoneConstantsKor.ACT1_5);
            terrorZoneMap.put("5", TerrorZoneConstantsKor.ACT1_6);
            terrorZoneMap.put("6", TerrorZoneConstantsKor.ACT1_7);
            terrorZoneMap.put("20", TerrorZoneConstantsKor.ACT1_8);
            terrorZoneMap.put("12", TerrorZoneConstantsKor.ACT1_9);
            terrorZoneMap.put("28", TerrorZoneConstantsKor.ACT1_10);
            terrorZoneMap.put("33", TerrorZoneConstantsKor.ACT1_11);
            terrorZoneMap.put("39", TerrorZoneConstantsKor.ACT1_12);
            terrorZoneMap.put("47", TerrorZoneConstantsKor.ACT2_1);
            terrorZoneMap.put("41", TerrorZoneConstantsKor.ACT2_2);
            terrorZoneMap.put("42", TerrorZoneConstantsKor.ACT2_3);
            terrorZoneMap.put("43", TerrorZoneConstantsKor.ACT2_4);
            terrorZoneMap.put("44", TerrorZoneConstantsKor.ACT2_5);
            terrorZoneMap.put("65", TerrorZoneConstantsKor.ACT2_6);
            terrorZoneMap.put("74", TerrorZoneConstantsKor.ACT2_7);
            terrorZoneMap.put("66", TerrorZoneConstantsKor.ACT2_8);
            terrorZoneMap.put("76", TerrorZoneConstantsKor.ACT3_1);
            terrorZoneMap.put("77", TerrorZoneConstantsKor.ACT3_2);
            terrorZoneMap.put("78", TerrorZoneConstantsKor.ACT3_3);
            terrorZoneMap.put("80", TerrorZoneConstantsKor.ACT3_4);
            terrorZoneMap.put("83", TerrorZoneConstantsKor.ACT3_5);
            terrorZoneMap.put("100", TerrorZoneConstantsKor.ACT3_6);
            terrorZoneMap.put("104", TerrorZoneConstantsKor.ACT4_1);
            terrorZoneMap.put("106", TerrorZoneConstantsKor.ACT4_2);
            terrorZoneMap.put("108", TerrorZoneConstantsKor.ACT4_3);
            terrorZoneMap.put("110", TerrorZoneConstantsKor.ACT5_1);
            terrorZoneMap.put("112", TerrorZoneConstantsKor.ACT5_2);
            terrorZoneMap.put("113", TerrorZoneConstantsKor.ACT5_3);
            terrorZoneMap.put("115", TerrorZoneConstantsKor.ACT5_4);
            terrorZoneMap.put("121", TerrorZoneConstantsKor.ACT5_5);
            terrorZoneMap.put("118", TerrorZoneConstantsKor.ACT5_6);
            terrorZoneMap.put("128", TerrorZoneConstantsKor.ACT5_7);
            terrorZoneMap.put("ERROR", TerrorZoneConstantsKor.ERROR_MESSAGE_1);
            terrorZoneMap.put("EMPTY", TerrorZoneConstantsKor.ERROR_MESSAGE_EMPTY);

            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(API_KEY)
                    .addHeader("x-emu-username", "hello_84582")
                    .addHeader("x-emu-token", "d4571711a24bbce2")
                    .build();

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
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                    if (response.isSuccessful()) {
                        String responseBody = response.body().string();
                        JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();

                        if (jsonObject.has("ERROR")) {
                            updateNotification("데이터를 받아올수 없습니다.", terrorZoneMap.get("ERROR"));
                        }


                        if (jsonObject.has("next")) {
                            JsonArray nextArray = jsonObject.getAsJsonArray("next");
                            if (nextArray.size() == 0) {
                                nextTerrorZone = terrorZoneMap.get("EMPTY");
                            } else {
                                for (int i = 0; i < nextArray.size(); i++) {
                                    String value = nextArray.get(i).getAsString();
                                    if (terrorZoneMap.containsKey(value)) {
                                        nextTerrorZone = terrorZoneMap.get(value);
                                    }
                                }
                            }
                        }

                        if (jsonObject.has("current")) {
                            JsonArray currentArray = jsonObject.getAsJsonArray("current");

                            for (int i = 0; i < currentArray.size(); i++) {
                                String value = currentArray.get(i).getAsString();
                                if (terrorZoneMap.containsKey(value)) {
                                    currentTerrorZone = terrorZoneMap.get(value);
                                    // Act 1
                                    if (TerrorZoneConstantsKor.ACT1_1.equals(currentTerrorZone) && sharedPreferences.getBoolean("act1_1", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT1_1, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT1_2.equals(currentTerrorZone) && sharedPreferences.getBoolean("act1_2", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT1_2, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT1_3.equals(currentTerrorZone) && sharedPreferences.getBoolean("act1_3", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT1_3, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT1_4.equals(currentTerrorZone) && sharedPreferences.getBoolean("act1_4", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT1_4, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT1_5.equals(currentTerrorZone) && sharedPreferences.getBoolean("act1_5", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT1_5, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT1_6.equals(currentTerrorZone) && sharedPreferences.getBoolean("act1_6", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT1_6, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT1_7.equals(currentTerrorZone) && sharedPreferences.getBoolean("act1_7", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT1_7, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT1_8.equals(currentTerrorZone) && sharedPreferences.getBoolean("act1_8", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT1_8, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT1_9.equals(currentTerrorZone) && sharedPreferences.getBoolean("act1_9", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT1_9, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT1_10.equals(currentTerrorZone) && sharedPreferences.getBoolean("act1_10", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT1_10, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT1_11.equals(currentTerrorZone) && sharedPreferences.getBoolean("act1_11", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT1_11, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT1_12.equals(currentTerrorZone) && sharedPreferences.getBoolean("act1_12", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT1_12, TITLE_MESSAGE + nextTerrorZone);
                                    }

                                    // Act 2
                                    else if (TerrorZoneConstantsKor.ACT2_1.equals(currentTerrorZone) && sharedPreferences.getBoolean("act2_1", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT2_1, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT2_2.equals(currentTerrorZone) && sharedPreferences.getBoolean("act2_2", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT2_2, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT2_3.equals(currentTerrorZone) && sharedPreferences.getBoolean("act2_3", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT2_3, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT2_4.equals(currentTerrorZone) && sharedPreferences.getBoolean("act2_4", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT2_4, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT2_5.equals(currentTerrorZone) && sharedPreferences.getBoolean("act2_5", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT2_5, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT2_6.equals(currentTerrorZone) && sharedPreferences.getBoolean("act2_6", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT2_6, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT2_7.equals(currentTerrorZone) && sharedPreferences.getBoolean("act2_7", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT2_7, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT2_8.equals(currentTerrorZone) && sharedPreferences.getBoolean("act2_8", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT2_8, TITLE_MESSAGE + nextTerrorZone);
                                    }

                                    // Act 3
                                    else if (TerrorZoneConstantsKor.ACT3_1.equals(currentTerrorZone) && sharedPreferences.getBoolean("act3_1", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT3_1, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT3_2.equals(currentTerrorZone) && sharedPreferences.getBoolean("act3_2", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT3_2, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT3_3.equals(currentTerrorZone) && sharedPreferences.getBoolean("act3_3", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT3_3, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT3_4.equals(currentTerrorZone) && sharedPreferences.getBoolean("act3_4", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT3_4, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT3_5.equals(currentTerrorZone) && sharedPreferences.getBoolean("act3_5", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT3_5, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT3_6.equals(currentTerrorZone) && sharedPreferences.getBoolean("act3_6", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT3_6, TITLE_MESSAGE + nextTerrorZone);
                                    }

                                    // Act 4
                                    else if (TerrorZoneConstantsKor.ACT4_1.equals(currentTerrorZone) && sharedPreferences.getBoolean("act4_1", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT4_1, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT4_2.equals(currentTerrorZone) && sharedPreferences.getBoolean("act4_2", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT4_2, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT4_3.equals(currentTerrorZone) && sharedPreferences.getBoolean("act4_3", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT4_3, TITLE_MESSAGE + nextTerrorZone);
                                    }

                                    // Act 5
                                    else if (TerrorZoneConstantsKor.ACT5_1.equals(currentTerrorZone) && sharedPreferences.getBoolean("act5_1", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT5_1, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT5_2.equals(currentTerrorZone) && sharedPreferences.getBoolean("act5_2", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT5_2, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT5_3.equals(currentTerrorZone) && sharedPreferences.getBoolean("act5_3", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT5_3, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT5_4.equals(currentTerrorZone) && sharedPreferences.getBoolean("act5_4", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT5_4, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT5_5.equals(currentTerrorZone) && sharedPreferences.getBoolean("act5_5", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT5_5, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT5_6.equals(currentTerrorZone) && sharedPreferences.getBoolean("act5_6", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT5_6, TITLE_MESSAGE + nextTerrorZone);
                                    } else if (TerrorZoneConstantsKor.ACT5_7.equals(currentTerrorZone) && sharedPreferences.getBoolean("act5_7", false)) {
                                        updateNotification(TerrorZoneConstantsKor.ACT5_7, TITLE_MESSAGE + nextTerrorZone);
                                    } else {
                                        updateNotification("공포의 영역 데이터 수집중", null);
                                    }

                                    notificationTriggeredByWebView = true;

                                }
                            }
                        }

                    }
                }
            });

        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }


    private void updateNotification(String title, String message) {
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.icons_terror_on)
                .build();

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.notify(TERROR_NOTIFICATION_ID, notification);  // 알림 갱신
        }
        startForeground(TERROR_NOTIFICATION_ID, notification); // Foreground Service로 알림 유지
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
