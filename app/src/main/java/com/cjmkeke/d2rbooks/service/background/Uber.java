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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Uber extends Service {

    private static final String TAG = "Uber";
    private static final String TITLE = "우버 디아블로 알림";
    private final String ApiUrl = "https://d2emu.com/api/v1/dclone";
    private SharedPreferences.OnSharedPreferenceChangeListener onUberSharedPreferenceChangeListener;
    private SharedPreferences uberSharedPreferences;

    private static String CHANNEL_ID = "우버 디아블로 알람";
    private static String ASIA_CHANNEL_ID = "아시아 우버 디아블로 알람";
    private static String EUROPE_CHANNEL_ID = "유럽 우버 디아블로 알람";
    private static String AMERICA_CHANNEL_ID = "아메리카 우버 디아블로 알람";

    private static int NOTIFICATION_ID = 1; // 고유 알림 ID
    private static int ASIA_UBER_NOTIFICATION_ID = 2; // 고유 알림 ID
    private static int EUROPE_UBER_NOTIFICATION_ID = 3; // 고유 알림 ID
    private static int AMERICA_UBER_NOTIFICATION_ID = 4; // 고유 알림 ID
    private static SharedPreferences toggleButtonSharedPreferences;
    private static SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener;
    private static boolean isAlarmEnabled;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
        startForeground(NOTIFICATION_ID, getNotification());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        toggleButtonSharedPreferences = getSharedPreferences(SharedValue.TOGGLE_BUTTON_SETTINGS, MODE_PRIVATE);
        isAlarmEnabled = toggleButtonSharedPreferences.getBoolean("toggle_button_uber_dia", true); // 초기화
        onSharedPreferenceChangeListener = (sharedPreferences, key) -> {
            if ("toggle_button_uber_dia".equals(key)) {
                isAlarmEnabled = toggleButtonSharedPreferences.getBoolean("toggle_button_uber_dia", true);
                Log.d(TAG, "알람 상태 변경 UberAlarmManager : " + isAlarmEnabled);
            }
        };
        toggleButtonSharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);

        if (isAlarmEnabled) {
            startServiceUberAlarm();
        }

        return START_NOT_STICKY;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager manager = getSystemService(NotificationManager.class);

            // 기본 채널
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    TITLE,
                    NotificationManager.IMPORTANCE_LOW
            );
            manager.createNotificationChannel(channel);

            // 아시아 채널
            NotificationChannel asiaChannel = new NotificationChannel(
                    ASIA_CHANNEL_ID,
                    "아시아 알람",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            manager.createNotificationChannel(asiaChannel);

            // 유럽 채널
            NotificationChannel europeChannel = new NotificationChannel(
                    EUROPE_CHANNEL_ID,
                    "유럽 알람",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            manager.createNotificationChannel(europeChannel);

            // 아메리카 채널
            NotificationChannel americaChannel = new NotificationChannel(
                    AMERICA_CHANNEL_ID,
                    "아메리카 알람",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            manager.createNotificationChannel(americaChannel);
        }
    }


    private Notification getNotification() {
        return new Notification.Builder(this, CHANNEL_ID)
                .setContentTitle("우버 디아블로 데이터 수집중")
                .setSmallIcon(R.drawable.icons_diablo) // 적절한 아이콘 추가
                .build();
    }

    private void startServiceUberAlarm() {
        uberSharedPreferences = getSharedPreferences(SharedValue.UBER_DIABLO_SETTINGS, MODE_PRIVATE);
        SharedPreferences.Editor editor = uberSharedPreferences.edit();
        // 리스너 등록
        onUberSharedPreferenceChangeListener = (sharedPreferences, key) -> {
            // 변경된 키에 대한 처리
            if (key.equals(SharedValue.LADDER_SOFT_CORE_3)) {
                boolean isLadderSoftCore3 = uberSharedPreferences.getBoolean(SharedValue.LADDER_SOFT_CORE_3, false);
                editor.putBoolean(SharedValue.LADDER_SOFT_CORE_3, isLadderSoftCore3);
            } else if (key.equals(SharedValue.LADDER_SOFT_CORE_4)) {
                boolean isLadderSoftCore4 = uberSharedPreferences.getBoolean(SharedValue.LADDER_SOFT_CORE_4, false);
                editor.putBoolean(SharedValue.LADDER_SOFT_CORE_4, isLadderSoftCore4);
            } else if (key.equals(SharedValue.LADDER_SOFT_CORE_5)) {
                boolean isLadderSoftCore5 = uberSharedPreferences.getBoolean(SharedValue.LADDER_SOFT_CORE_5, false);
                editor.putBoolean(SharedValue.LADDER_SOFT_CORE_5, isLadderSoftCore5);
            } else if (key.equals(SharedValue.LADDER_SOFT_CORE_6)) {
                boolean isLadderSoftCore6 = uberSharedPreferences.getBoolean(SharedValue.LADDER_SOFT_CORE_6, false);
                editor.putBoolean(SharedValue.LADDER_SOFT_CORE_6, isLadderSoftCore6);
            } else if (key.equals(SharedValue.LADDER_HARD_CORE_3)) {
                boolean isLadderHardCore3 = uberSharedPreferences.getBoolean(SharedValue.LADDER_HARD_CORE_3, false);
                editor.putBoolean(SharedValue.LADDER_HARD_CORE_3, isLadderHardCore3);
            } else if (key.equals(SharedValue.LADDER_HARD_CORE_4)) {
                boolean isLadderHardCore4 = uberSharedPreferences.getBoolean(SharedValue.LADDER_HARD_CORE_4, false);
                editor.putBoolean(SharedValue.LADDER_HARD_CORE_4, isLadderHardCore4);
            } else if (key.equals(SharedValue.LADDER_HARD_CORE_5)) {
                boolean isLadderHardCore5 = uberSharedPreferences.getBoolean(SharedValue.LADDER_HARD_CORE_5, false);
                editor.putBoolean(SharedValue.LADDER_HARD_CORE_5, isLadderHardCore5);
            } else if (key.equals(SharedValue.LADDER_HARD_CORE_6)) {
                boolean isLadderHardCore6 = uberSharedPreferences.getBoolean(SharedValue.LADDER_HARD_CORE_6, false);
                editor.putBoolean(SharedValue.LADDER_HARD_CORE_6, isLadderHardCore6);
            } else if (key.equals(SharedValue.NONE_LADDER_SOFT_CORE_3)) {
                boolean isNoneLadderSoftCore3 = uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_SOFT_CORE_3, false);
                editor.putBoolean(SharedValue.NONE_LADDER_SOFT_CORE_3, isNoneLadderSoftCore3);
            } else if (key.equals(SharedValue.NONE_LADDER_SOFT_CORE_4)) {
                boolean isNoneLadderSoftCore4 = uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_SOFT_CORE_4, false);
                editor.putBoolean(SharedValue.NONE_LADDER_SOFT_CORE_4, isNoneLadderSoftCore4);
            } else if (key.equals(SharedValue.NONE_LADDER_SOFT_CORE_5)) {
                boolean isNoneLadderSoftCore5 = uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_SOFT_CORE_5, false);
                editor.putBoolean(SharedValue.NONE_LADDER_SOFT_CORE_5, isNoneLadderSoftCore5);
            } else if (key.equals(SharedValue.NONE_LADDER_SOFT_CORE_6)) {
                boolean isNoneLadderSoftCore6 = uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_SOFT_CORE_6, false);
                editor.putBoolean(SharedValue.NONE_LADDER_SOFT_CORE_6, isNoneLadderSoftCore6);
            } else if (key.equals(SharedValue.NONE_LADDER_HARD_CORE_3)) {
                boolean isNoneLadderHardCore3 = uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_HARD_CORE_3, false);
                editor.putBoolean(SharedValue.NONE_LADDER_HARD_CORE_3, isNoneLadderHardCore3);
            } else if (key.equals(SharedValue.NONE_LADDER_HARD_CORE_4)) {
                boolean isNoneLadderHardCore4 = uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_HARD_CORE_4, false);
                editor.putBoolean(SharedValue.NONE_LADDER_HARD_CORE_4, isNoneLadderHardCore4);
            } else if (key.equals(SharedValue.NONE_LADDER_HARD_CORE_5)) {
                boolean isNoneLadderHardCore5 = uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_HARD_CORE_5, false);
                editor.putBoolean(SharedValue.NONE_LADDER_HARD_CORE_5, isNoneLadderHardCore5);
            } else if (key.equals(SharedValue.NONE_LADDER_HARD_CORE_6)) {
                boolean isNoneLadderHardCore6 = uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_HARD_CORE_6, false);
                editor.putBoolean(SharedValue.NONE_LADDER_HARD_CORE_6, isNoneLadderHardCore6);
            } else if (key.equals(SharedValue.AMERICA_LADDER_SOFT_CORE_3)) {
                boolean isAmericaLadderSoftCore3 = uberSharedPreferences.getBoolean(SharedValue.AMERICA_LADDER_SOFT_CORE_3, false);
                editor.putBoolean(SharedValue.AMERICA_LADDER_SOFT_CORE_3, isAmericaLadderSoftCore3);
            } else if (key.equals(SharedValue.AMERICA_LADDER_SOFT_CORE_4)) {
                boolean isAmericaLadderSoftCore4 = uberSharedPreferences.getBoolean(SharedValue.AMERICA_LADDER_SOFT_CORE_4, false);
                editor.putBoolean(SharedValue.AMERICA_LADDER_SOFT_CORE_4, isAmericaLadderSoftCore4);
            } else if (key.equals(SharedValue.AMERICA_LADDER_SOFT_CORE_5)) {
                boolean isAmericaLadderSoftCore5 = uberSharedPreferences.getBoolean(SharedValue.AMERICA_LADDER_SOFT_CORE_5, false);
                editor.putBoolean(SharedValue.AMERICA_LADDER_SOFT_CORE_5, isAmericaLadderSoftCore5);
            } else if (key.equals(SharedValue.AMERICA_LADDER_SOFT_CORE_6)) {
                boolean isAmericaLadderSoftCore6 = uberSharedPreferences.getBoolean(SharedValue.AMERICA_LADDER_SOFT_CORE_6, false);
                editor.putBoolean(SharedValue.AMERICA_LADDER_SOFT_CORE_6, isAmericaLadderSoftCore6);
            } else if (key.equals(SharedValue.AMERICA_LADDER_HARD_CORE_3)) {
                boolean isAmericaLadderSoftCore3 = uberSharedPreferences.getBoolean(SharedValue.AMERICA_LADDER_HARD_CORE_3, false);
                editor.putBoolean(SharedValue.AMERICA_LADDER_HARD_CORE_3, isAmericaLadderSoftCore3);
            } else if (key.equals(SharedValue.AMERICA_LADDER_HARD_CORE_4)) {
                boolean isAmericaLadderSoftCore4 = uberSharedPreferences.getBoolean(SharedValue.AMERICA_LADDER_HARD_CORE_4, false);
                editor.putBoolean(SharedValue.AMERICA_LADDER_HARD_CORE_4, isAmericaLadderSoftCore4);
            } else if (key.equals(SharedValue.AMERICA_LADDER_HARD_CORE_5)) {
                boolean isAmericaLadderSoftCore5 = uberSharedPreferences.getBoolean(SharedValue.AMERICA_LADDER_HARD_CORE_5, false);
                editor.putBoolean(SharedValue.AMERICA_LADDER_HARD_CORE_5, isAmericaLadderSoftCore5);
            } else if (key.equals(SharedValue.AMERICA_LADDER_HARD_CORE_6)) {
                boolean isAmericaLadderSoftCore6 = uberSharedPreferences.getBoolean(SharedValue.AMERICA_LADDER_HARD_CORE_6, false);
                editor.putBoolean(SharedValue.AMERICA_LADDER_HARD_CORE_6, isAmericaLadderSoftCore6);
            } else if (key.equals(SharedValue.AMERICA_NONE_LADDER_SOFT_CORE_3)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.AMERICA_NONE_LADDER_SOFT_CORE_3, false);
                editor.putBoolean(SharedValue.AMERICA_NONE_LADDER_SOFT_CORE_3, value);
            } else if (key.equals(SharedValue.AMERICA_NONE_LADDER_SOFT_CORE_4)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.AMERICA_NONE_LADDER_SOFT_CORE_4, false);
                editor.putBoolean(SharedValue.AMERICA_NONE_LADDER_SOFT_CORE_4, value);
            } else if (key.equals(SharedValue.AMERICA_NONE_LADDER_SOFT_CORE_5)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.AMERICA_NONE_LADDER_SOFT_CORE_5, false);
                editor.putBoolean(SharedValue.AMERICA_NONE_LADDER_SOFT_CORE_5, value);
            } else if (key.equals(SharedValue.AMERICA_NONE_LADDER_SOFT_CORE_6)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.AMERICA_NONE_LADDER_SOFT_CORE_6, false);
                editor.putBoolean(SharedValue.AMERICA_NONE_LADDER_SOFT_CORE_6, value);
            } else if (key.equals(SharedValue.AMERICA_NONE_LADDER_HARD_CORE_3)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.AMERICA_NONE_LADDER_HARD_CORE_3, false);
                editor.putBoolean(SharedValue.AMERICA_NONE_LADDER_HARD_CORE_3, value);
            } else if (key.equals(SharedValue.AMERICA_NONE_LADDER_HARD_CORE_4)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.AMERICA_NONE_LADDER_HARD_CORE_4, false);
                editor.putBoolean(SharedValue.AMERICA_NONE_LADDER_HARD_CORE_4, value);
            } else if (key.equals(SharedValue.AMERICA_NONE_LADDER_HARD_CORE_5)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.AMERICA_NONE_LADDER_HARD_CORE_5, false);
                editor.putBoolean(SharedValue.AMERICA_NONE_LADDER_HARD_CORE_5, value);
            } else if (key.equals(SharedValue.AMERICA_NONE_LADDER_HARD_CORE_6)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.AMERICA_NONE_LADDER_HARD_CORE_6, false);
                editor.putBoolean(SharedValue.AMERICA_NONE_LADDER_HARD_CORE_6, value);
            } else if (key.equals(SharedValue.EUROPE_LADDER_SOFT_CORE_3)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.EUROPE_LADDER_SOFT_CORE_3, false);
                editor.putBoolean(SharedValue.EUROPE_LADDER_SOFT_CORE_3, value);
            } else if (key.equals(SharedValue.EUROPE_LADDER_SOFT_CORE_4)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.EUROPE_LADDER_SOFT_CORE_4, false);
                editor.putBoolean(SharedValue.EUROPE_LADDER_SOFT_CORE_4, value);
            } else if (key.equals(SharedValue.EUROPE_LADDER_SOFT_CORE_5)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.EUROPE_LADDER_SOFT_CORE_5, false);
                editor.putBoolean(SharedValue.EUROPE_LADDER_SOFT_CORE_5, value);
            } else if (key.equals(SharedValue.EUROPE_LADDER_SOFT_CORE_6)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.EUROPE_LADDER_SOFT_CORE_6, false);
                editor.putBoolean(SharedValue.EUROPE_LADDER_SOFT_CORE_6, value);
            } else if (key.equals(SharedValue.EUROPE_LADDER_HARD_CORE_3)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.EUROPE_LADDER_HARD_CORE_3, false);
                editor.putBoolean(SharedValue.EUROPE_LADDER_HARD_CORE_3, value);
            } else if (key.equals(SharedValue.EUROPE_LADDER_HARD_CORE_4)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.EUROPE_LADDER_HARD_CORE_4, false);
                editor.putBoolean(SharedValue.EUROPE_LADDER_HARD_CORE_4, value);
            } else if (key.equals(SharedValue.EUROPE_LADDER_HARD_CORE_5)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.EUROPE_LADDER_HARD_CORE_5, false);
                editor.putBoolean(SharedValue.EUROPE_LADDER_HARD_CORE_5, value);
            } else if (key.equals(SharedValue.EUROPE_LADDER_HARD_CORE_6)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.EUROPE_LADDER_HARD_CORE_6, false);
                editor.putBoolean(SharedValue.EUROPE_LADDER_HARD_CORE_6, value);
            } else if (key.equals(SharedValue.EUROPE_NONE_LADDER_SOFT_CORE_3)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.EUROPE_NONE_LADDER_SOFT_CORE_3, false);
                editor.putBoolean(SharedValue.EUROPE_NONE_LADDER_SOFT_CORE_3, value);
            } else if (key.equals(SharedValue.EUROPE_NONE_LADDER_SOFT_CORE_4)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.EUROPE_NONE_LADDER_SOFT_CORE_4, false);
                editor.putBoolean(SharedValue.EUROPE_NONE_LADDER_SOFT_CORE_4, value);
            } else if (key.equals(SharedValue.EUROPE_NONE_LADDER_SOFT_CORE_5)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.EUROPE_NONE_LADDER_SOFT_CORE_5, false);
                editor.putBoolean(SharedValue.EUROPE_NONE_LADDER_SOFT_CORE_5, value);
            } else if (key.equals(SharedValue.EUROPE_NONE_LADDER_SOFT_CORE_6)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.EUROPE_NONE_LADDER_SOFT_CORE_6, false);
                editor.putBoolean(SharedValue.EUROPE_NONE_LADDER_SOFT_CORE_6, value);
            } else if (key.equals(SharedValue.EUROPE_NONE_LADDER_HARD_CORE_3)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.EUROPE_NONE_LADDER_HARD_CORE_3, false);
                editor.putBoolean(SharedValue.EUROPE_NONE_LADDER_HARD_CORE_3, value);
            } else if (key.equals(SharedValue.EUROPE_NONE_LADDER_HARD_CORE_4)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.EUROPE_NONE_LADDER_HARD_CORE_4, false);
                editor.putBoolean(SharedValue.EUROPE_NONE_LADDER_HARD_CORE_4, value);
            } else if (key.equals(SharedValue.EUROPE_NONE_LADDER_HARD_CORE_5)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.EUROPE_NONE_LADDER_HARD_CORE_5, false);
                editor.putBoolean(SharedValue.EUROPE_NONE_LADDER_HARD_CORE_5, value);
            } else if (key.equals(SharedValue.EUROPE_NONE_LADDER_HARD_CORE_6)) {
                boolean value = uberSharedPreferences.getBoolean(SharedValue.EUROPE_NONE_LADDER_HARD_CORE_6, false);
                editor.putBoolean(SharedValue.EUROPE_NONE_LADDER_HARD_CORE_6, value);
            }


        };

        uberSharedPreferences.registerOnSharedPreferenceChangeListener(onUberSharedPreferenceChangeListener);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("error_log");

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiUrl)
                .addHeader("x-emu-username", "hello_84582")
                .addHeader("x-emu-token", "d4571711a24bbce2")
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String responseData = response.body().string();

                final String step3 = "성역 안에 공포가 형성되기 시작합니다.";
                final String step4 = "성역 곳곳에 공포가 퍼집니다.";
                final String step5 = "성역에 공포가 풀려나려 합니다.";
                final String step6 = "디아블로가 성역을 침공했습니다!";

                final String ASIA_LADDER_HARD_CORE_MESSAGE = "아시아 래더 하드코어 ";
                final String ASIA_LADDER_SOFT_CORE_MESSAGE = "아시아 래더 소프트코어 ";
                final String ASIA_STANDARD_SOFT_CORE_MESSAGE = "아시아 스탠다드 소프트코어 ";
                final String ASIA_STANDARD_HARD_CORE_MESSAGE = "아시아 스탠다드 하드코어 ";

                final String AMERICA_LADDER_SOFT_CORE_MESSAGE = "아메리카 래더 소프트코어 ";
                final String AMERICA_LADDER_HARD_CORE_MESSAGE = "아메리카 래더 하드코어 ";
                final String AMERICA_STANDARD_SOFT_CORE_MESSAGE = "아메리카 스탠다드 소프트코어 ";
                final String AMERICA_STANDARD_HARD_CORE_MESSAGE = "아메리카 스탠다드 하드코어 ";

                final String EUROPE_LADDER_SOFT_CORE_MESSAGE = "유럽 래더 소프트코어 ";
                final String EUROPE_LADDER_HARD_CORE_MESSAGE = "유럽 래더 하드코어 ";
                final String EUROPE_STANDARD_SOFT_CORE_MESSAGE = "유럽 스탠다드 소프트코어 ";
                final String EUROPE_STANDARD_HARD_CORE_MESSAGE = "유럽 스탠다드 하드코어 ";

                try {
                    JsonObject jsonObject = JsonParser.parseString(responseData).getAsJsonObject();
                    if (jsonObject.has("krLadderHardcore")) {
                        JsonObject krLadderHardcore = jsonObject.getAsJsonObject("krLadderHardcore");
                        if (krLadderHardcore.has("status")) {
                            int status = krLadderHardcore.get("status").getAsInt();
                            switch (status) {
                                case 2:
                                    if (uberSharedPreferences.getBoolean(SharedValue.LADDER_HARD_CORE_3, false)) {
                                        updateNotificationAsia(ASIA_LADDER_HARD_CORE_MESSAGE + "3단계", step3);
                                    }
                                    break;
                                case 3:
                                    if (uberSharedPreferences.getBoolean(SharedValue.LADDER_HARD_CORE_4, false)) {
                                        updateNotificationAsia(ASIA_LADDER_HARD_CORE_MESSAGE + "4단계", step4);
                                    }
                                    break;
                                case 4:
                                    if (uberSharedPreferences.getBoolean(SharedValue.LADDER_HARD_CORE_5, false)) {
                                        updateNotificationAsia(ASIA_LADDER_HARD_CORE_MESSAGE + "5단계", step5);
                                    }
                                    break;
                                case 5:
                                    if (uberSharedPreferences.getBoolean(SharedValue.LADDER_HARD_CORE_6, false)) {
                                        updateNotificationAsia(ASIA_LADDER_HARD_CORE_MESSAGE + "6단계", step6);
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                    }

                    if (jsonObject.has("krLadder")) {
                        JsonObject krLadder = jsonObject.getAsJsonObject("krLadder");
                        if (krLadder.has("status")) {
                            int status = krLadder.get("status").getAsInt();
                            switch (status) {
                                case 2:
                                    if (uberSharedPreferences.getBoolean(SharedValue.LADDER_SOFT_CORE_3, false)) {
                                        updateNotificationAsia(ASIA_LADDER_SOFT_CORE_MESSAGE + "3단계", step3);
                                    }
                                    break;
                                case 3:
                                    if (uberSharedPreferences.getBoolean(SharedValue.LADDER_SOFT_CORE_4, false)) {
                                        updateNotificationAsia(ASIA_LADDER_SOFT_CORE_MESSAGE + "4단계", step4);
                                    }
                                    break;
                                case 4:
                                    if (uberSharedPreferences.getBoolean(SharedValue.LADDER_SOFT_CORE_5, false)) {
                                        updateNotificationAsia(ASIA_LADDER_SOFT_CORE_MESSAGE + "5단계", step5);
                                    }
                                    break;
                                case 5:
                                    if (uberSharedPreferences.getBoolean(SharedValue.LADDER_SOFT_CORE_6, false)) {
                                        updateNotificationAsia(ASIA_LADDER_SOFT_CORE_MESSAGE + "6단계", step6);
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                    }

                    if (jsonObject.has("krNonLadder")) {
                        JsonObject krNonLadder = jsonObject.getAsJsonObject("krNonLadder");
                        if (krNonLadder.has("status")) {
                            int status = krNonLadder.get("status").getAsInt();
                            switch (status) {
                                case 2:
                                    if (uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_SOFT_CORE_3, false)) {
                                        updateNotificationAsia(ASIA_STANDARD_SOFT_CORE_MESSAGE + "3단계", step3);
                                    }
                                    break;
                                case 3:
                                    if (uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_SOFT_CORE_4, false)) {
                                        updateNotificationAsia(ASIA_STANDARD_SOFT_CORE_MESSAGE + "4단계", step4);
                                    }
                                    break;
                                case 4:
                                    if (uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_SOFT_CORE_5, false)) {
                                        updateNotificationAsia(ASIA_STANDARD_SOFT_CORE_MESSAGE + "5단계", step5);
                                    }
                                    break;
                                case 5:
                                    if (uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_SOFT_CORE_6, false)) {
                                        updateNotificationAsia(ASIA_STANDARD_SOFT_CORE_MESSAGE + "6단계", step6);
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                    }

                    if (jsonObject.has("krNonLadderHardcore")) {
                        JsonObject krNonLadderHardcore = jsonObject.getAsJsonObject("krNonLadderHardcore");
                        if (krNonLadderHardcore.has("status")) {
                            int status = krNonLadderHardcore.get("status").getAsInt();
                            switch (status) {
                                case 2:
                                    if (uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_HARD_CORE_3, false)) {
                                        updateNotificationAsia(ASIA_STANDARD_HARD_CORE_MESSAGE + "3단계", step3);
                                    }
                                    break;
                                case 3:
                                    if (uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_HARD_CORE_4, false)) {
                                        updateNotificationAsia(ASIA_STANDARD_HARD_CORE_MESSAGE + "4단계", step4);
                                    }
                                    break;
                                case 4:
                                    if (uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_HARD_CORE_5, false)) {
                                        updateNotificationAsia(ASIA_STANDARD_HARD_CORE_MESSAGE + "5단계", step5);
                                    }
                                    break;
                                case 5:
                                    if (uberSharedPreferences.getBoolean(SharedValue.NONE_LADDER_HARD_CORE_6, false)) {
                                        updateNotificationAsia(ASIA_STANDARD_HARD_CORE_MESSAGE + "6단계", step6);
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                    }

                    if (jsonObject.has("usLadder")) {
                        JsonObject usLadder = jsonObject.getAsJsonObject("usLadder");
                        if (usLadder.has("status")) {
                            int status = usLadder.get("status").getAsInt();
                            switch (status) {
                                case 2:
                                    if (uberSharedPreferences.getBoolean(SharedValue.AMERICA_LADDER_SOFT_CORE_3, false)) {
                                        updateNotificationAmerica(AMERICA_LADDER_SOFT_CORE_MESSAGE + "3단계", step3);
                                    }
                                    break;
                                case 3:
                                    if (uberSharedPreferences.getBoolean(SharedValue.AMERICA_LADDER_SOFT_CORE_4, false)) {
                                        updateNotificationAmerica(AMERICA_LADDER_SOFT_CORE_MESSAGE + "4단계", step4);
                                    }
                                    break;
                                case 4:
                                    if (uberSharedPreferences.getBoolean(SharedValue.AMERICA_LADDER_SOFT_CORE_5, false)) {
                                        updateNotificationAmerica(AMERICA_LADDER_SOFT_CORE_MESSAGE + "5단계", step5);
                                    }
                                    break;
                                case 5:
                                    if (uberSharedPreferences.getBoolean(SharedValue.AMERICA_LADDER_SOFT_CORE_6, false)) {
                                        updateNotificationAmerica(AMERICA_LADDER_SOFT_CORE_MESSAGE + "6단계", step6);
                                    }
                                    break;
                                default:
                                    // No action needed for other statuses
                                    break;
                            }
                        }
                    }

                    if (jsonObject.has("usLadderHardcore")) {
                        JsonObject usLadderHardcore = jsonObject.getAsJsonObject("usLadderHardcore");
                        if (usLadderHardcore.has("status")) {
                            int status = usLadderHardcore.get("status").getAsInt();
                            switch (status) {
                                case 2:
                                    if (uberSharedPreferences.getBoolean(SharedValue.AMERICA_LADDER_HARD_CORE_3, false)) {
                                        updateNotificationAmerica(AMERICA_LADDER_HARD_CORE_MESSAGE + "3단계", step3);
                                    }
                                    break;
                                case 3:
                                    if (uberSharedPreferences.getBoolean(SharedValue.AMERICA_LADDER_HARD_CORE_4, false)) {
                                        updateNotificationAmerica(AMERICA_LADDER_HARD_CORE_MESSAGE + "4단계", step4);
                                    }
                                    break;
                                case 4:
                                    if (uberSharedPreferences.getBoolean(SharedValue.AMERICA_LADDER_HARD_CORE_5, false)) {
                                        updateNotificationAmerica(AMERICA_LADDER_HARD_CORE_MESSAGE + "5단계", step5);
                                    }
                                    break;
                                case 5:
                                    if (uberSharedPreferences.getBoolean(SharedValue.AMERICA_LADDER_HARD_CORE_6, false)) {
                                        updateNotificationAmerica(AMERICA_LADDER_HARD_CORE_MESSAGE + "6단계", step6);
                                    }
                                    break;
                                default:
                                    // No action needed for other statuses
                                    break;
                            }
                        }
                    }

                    if (jsonObject.has("usNonLadder")) {
                        JsonObject usNonLadder = jsonObject.getAsJsonObject("usNonLadder");
                        if (usNonLadder.has("status")) {
                            int status = usNonLadder.get("status").getAsInt();
                            switch (status) {
                                case 2:
                                    if (uberSharedPreferences.getBoolean(SharedValue.AMERICA_NONE_LADDER_SOFT_CORE_3, false)) {
                                        updateNotificationAmerica(AMERICA_STANDARD_SOFT_CORE_MESSAGE + "3단계", step3);
                                    }
                                    break;
                                case 3:
                                    if (uberSharedPreferences.getBoolean(SharedValue.AMERICA_NONE_LADDER_SOFT_CORE_4, false)) {
                                        updateNotificationAmerica(AMERICA_STANDARD_SOFT_CORE_MESSAGE + "4단계", step4);
                                    }
                                    break;
                                case 4:
                                    if (uberSharedPreferences.getBoolean(SharedValue.AMERICA_NONE_LADDER_SOFT_CORE_5, false)) {
                                        updateNotificationAmerica(AMERICA_STANDARD_SOFT_CORE_MESSAGE + "5단계", step5);
                                    }
                                    break;
                                case 5:
                                    if (uberSharedPreferences.getBoolean(SharedValue.AMERICA_NONE_LADDER_SOFT_CORE_6, false)) {
                                        updateNotificationAmerica(AMERICA_STANDARD_SOFT_CORE_MESSAGE + "6단계", step6);
                                    }
                                    break;
                                default:
                                    // No action needed for other statuses
                                    break;
                            }
                        }
                    }

                    if (jsonObject.has("usNonLadderHardcore")) {
                        JsonObject usNonLadderHardcore = jsonObject.getAsJsonObject("usNonLadderHardcore");
                        if (usNonLadderHardcore.has("status")) {
                            int status = usNonLadderHardcore.get("status").getAsInt();
                            switch (status) {
                                case 2:
                                    if (uberSharedPreferences.getBoolean(SharedValue.AMERICA_NONE_LADDER_HARD_CORE_3, false)) {
                                        updateNotificationAmerica(AMERICA_STANDARD_HARD_CORE_MESSAGE + "3단계", step3);
                                    }
                                    break;
                                case 3:
                                    if (uberSharedPreferences.getBoolean(SharedValue.AMERICA_NONE_LADDER_HARD_CORE_4, false)) {
                                        updateNotificationAmerica(AMERICA_STANDARD_HARD_CORE_MESSAGE + "4단계", step4);
                                    }
                                    break;
                                case 4:
                                    if (uberSharedPreferences.getBoolean(SharedValue.AMERICA_NONE_LADDER_HARD_CORE_5, false)) {
                                        updateNotificationAmerica(AMERICA_STANDARD_HARD_CORE_MESSAGE + "5단계", step5);
                                    }
                                    break;
                                case 5:
                                    if (uberSharedPreferences.getBoolean(SharedValue.AMERICA_NONE_LADDER_HARD_CORE_6, false)) {
                                        updateNotificationAmerica(AMERICA_STANDARD_HARD_CORE_MESSAGE + "6단계", step6);
                                    }
                                    break;
                                default:
                                    // No action needed for other statuses
                                    break;
                            }
                        }
                    }

                    if (jsonObject.has("euLadder")) {
                        JsonObject euLadder = jsonObject.getAsJsonObject("euLadder");
                        if (euLadder.has("status")) {
                            int status = euLadder.get("status").getAsInt();
                            switch (status) {
                                case 2:
                                    if (uberSharedPreferences.getBoolean(SharedValue.EUROPE_LADDER_SOFT_CORE_3, false)) {
                                        updateNotificationEurope(EUROPE_LADDER_SOFT_CORE_MESSAGE + "3단계", step3);
                                    }
                                    break;
                                case 3:
                                    if (uberSharedPreferences.getBoolean(SharedValue.EUROPE_LADDER_SOFT_CORE_4, false)) {
                                        updateNotificationEurope(EUROPE_LADDER_SOFT_CORE_MESSAGE + "4단계", step4);
                                    }
                                    break;
                                case 4:
                                    if (uberSharedPreferences.getBoolean(SharedValue.EUROPE_LADDER_SOFT_CORE_5, false)) {
                                        updateNotificationEurope(EUROPE_LADDER_SOFT_CORE_MESSAGE + "5단계", step5);
                                    }
                                    break;
                                case 5:
                                    if (uberSharedPreferences.getBoolean(SharedValue.EUROPE_LADDER_SOFT_CORE_6, false)) {
                                        updateNotificationEurope(EUROPE_LADDER_SOFT_CORE_MESSAGE + "6단계", step6);
                                    }
                                    break;
                                default:
                                    // No action needed for other statuses
                                    break;
                            }
                        }
                    }

                    if (jsonObject.has("euLadderHardcore")) {
                        JsonObject euLadderHardcore = jsonObject.getAsJsonObject("euLadderHardcore");
                        if (euLadderHardcore.has("status")) {
                            int status = euLadderHardcore.get("status").getAsInt();
                            switch (status) {
                                case 2:
                                    if (uberSharedPreferences.getBoolean(SharedValue.EUROPE_LADDER_HARD_CORE_3, false)) {
                                        updateNotificationEurope(EUROPE_LADDER_HARD_CORE_MESSAGE + "3단계", step3);
                                    }
                                    break;
                                case 3:
                                    if (uberSharedPreferences.getBoolean(SharedValue.EUROPE_LADDER_HARD_CORE_4, false)) {
                                        updateNotificationEurope(EUROPE_LADDER_HARD_CORE_MESSAGE + "4단계", step4);
                                    }
                                    break;
                                case 4:
                                    if (uberSharedPreferences.getBoolean(SharedValue.EUROPE_LADDER_HARD_CORE_5, false)) {
                                        updateNotificationEurope(EUROPE_LADDER_HARD_CORE_MESSAGE + "5단계", step5);
                                    }
                                    break;
                                case 5:
                                    if (uberSharedPreferences.getBoolean(SharedValue.EUROPE_LADDER_HARD_CORE_6, false)) {
                                        updateNotificationEurope(EUROPE_LADDER_HARD_CORE_MESSAGE + "6단계", step6);
                                    }
                                    break;
                                default:
                                    // No action needed for other statuses
                                    break;
                            }
                        }
                    }

                    if (jsonObject.has("euNonLadder")) {
                        JsonObject euNonLadder = jsonObject.getAsJsonObject("euNonLadder");
                        if (euNonLadder.has("status")) {
                            int status = euNonLadder.get("status").getAsInt();
                            switch (status) {
                                case 2:
                                    if (uberSharedPreferences.getBoolean(SharedValue.EUROPE_NONE_LADDER_SOFT_CORE_3, false)) {
                                        updateNotificationEurope(EUROPE_STANDARD_SOFT_CORE_MESSAGE + "3단계", step3);
                                    }
                                    break;
                                case 3:
                                    if (uberSharedPreferences.getBoolean(SharedValue.EUROPE_NONE_LADDER_SOFT_CORE_4, false)) {
                                        updateNotificationEurope(EUROPE_STANDARD_SOFT_CORE_MESSAGE + "4단계", step4);
                                    }
                                    break;
                                case 4:
                                    if (uberSharedPreferences.getBoolean(SharedValue.EUROPE_NONE_LADDER_SOFT_CORE_5, false)) {
                                        updateNotificationEurope(EUROPE_STANDARD_SOFT_CORE_MESSAGE + "5단계", step5);
                                    }
                                    break;
                                case 5:
                                    if (uberSharedPreferences.getBoolean(SharedValue.EUROPE_NONE_LADDER_SOFT_CORE_6, false)) {
                                        updateNotificationEurope(EUROPE_STANDARD_SOFT_CORE_MESSAGE + "6단계", step6);
                                    }
                                    break;
                                default:
                                    // No action needed for other statuses
                                    break;
                            }
                        }
                    }

                    if (jsonObject.has("euNonLadderHardcore")) {
                        JsonObject euNonLadderHardcore = jsonObject.getAsJsonObject("euNonLadderHardcore");
                        if (euNonLadderHardcore.has("status")) {
                            int status = euNonLadderHardcore.get("status").getAsInt(); // 정수로 처리
                            switch (status) {
                                case 2:
                                    if (uberSharedPreferences.getBoolean(SharedValue.EUROPE_NONE_LADDER_HARD_CORE_3, false)) {
                                        updateNotificationEurope(EUROPE_STANDARD_HARD_CORE_MESSAGE + "3단계", step3);
                                    }
                                    break;
                                case 3:
                                    if (uberSharedPreferences.getBoolean(SharedValue.EUROPE_NONE_LADDER_HARD_CORE_4, false)) {
                                        updateNotificationEurope(EUROPE_STANDARD_HARD_CORE_MESSAGE + "4단계", step4);
                                    }
                                    break;
                                case 4:
                                    if (uberSharedPreferences.getBoolean(SharedValue.EUROPE_NONE_LADDER_HARD_CORE_5, false)) {
                                        updateNotificationEurope(EUROPE_STANDARD_HARD_CORE_MESSAGE + "5단계", step5);
                                    }
                                    break;
                                case 5:
                                    if (uberSharedPreferences.getBoolean(SharedValue.EUROPE_NONE_LADDER_HARD_CORE_6, false)) {
                                        updateNotificationEurope(EUROPE_STANDARD_HARD_CORE_MESSAGE + "6단계", step6);
                                    }
                                    break;
                                default:
                                    // Handle unexpected status values if necessary
                                    break;
                            }
                        }
                    }
                } catch (JsonSyntaxException e) {
                    logErrorToFirebase(e);
                } catch (Exception e){
                    logErrorToFirebase(e);
                }


            }
        });

    }

    private void logErrorToFirebase(Exception e) {
        long getTime = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
        String time = simpleDateFormat.format(getTime);
        String errorMessage = e.toString() + "\n" + Log.getStackTraceString(e);
        databaseReference.child("errors").child(time).setValue(errorMessage);
    }

    private void checkedSharedPreferences(String value) {
        boolean isChecked = uberSharedPreferences.getBoolean(value, false);
    }

    private void updateNotification(String title, String message) {
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.icons_diablo)
                .build();

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.notify(NOTIFICATION_ID, notification);  // 알림 갱신
        }

        startForeground(NOTIFICATION_ID, notification); // Foreground Service로 알림 유지
    }

    private void updateNotificationAsia(String title, String message) {

        ASIA_CHANNEL_ID = CHANNEL_ID;

        Notification notification = new NotificationCompat.Builder(this, ASIA_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.icons_diablo)
                .build();

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.notify(ASIA_UBER_NOTIFICATION_ID, notification);  // 알림 갱신
        }
//        startForeground(NOTIFICATION_ID, notification); // Foreground Service로 알림 유지
    }

    private void updateNotificationAmerica(String title, String message) {

        AMERICA_CHANNEL_ID = CHANNEL_ID;

        Notification notification = new NotificationCompat.Builder(this, AMERICA_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.icons_diablo)
                .build();

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.notify(AMERICA_UBER_NOTIFICATION_ID, notification);  // 알림 갱신
        }
//        startForeground(NOTIFICATION_ID, notification); // Foreground Service로 알림 유지
    }

    private void updateNotificationEurope(String title, String message) {

        EUROPE_CHANNEL_ID = CHANNEL_ID;

        Notification notification = new NotificationCompat.Builder(this, EUROPE_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.icons_diablo)
                .build();

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.notify(EUROPE_UBER_NOTIFICATION_ID, notification);  // 알림 갱신
        }
//        startForeground(NOTIFICATION_ID, notification); // Foreground Service로 알림 유지
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
