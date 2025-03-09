package com.cjmkeke.d2rbooks.service.background;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;

import com.cjmkeke.d2rbooks.constants.SharedValue;

import java.util.Calendar;
import java.util.Date;

public class TerrorZoneAlarmReceiver extends BroadcastReceiver {

    private static SharedPreferences sharedPreferences;
    private static final String TAG = "TerrorZoneAlarmReceiver";
    private static final int TIME_IS_1HOUR = 1;
    private static final int TIME_IS_15MINUTE = 15;
    private static final int TIME_IS_30MINUTE = 30;

    @Override
    public void onReceive(Context context, Intent intent) {
        // 서비스 실행
        Intent serviceIntent = new Intent(context, TerrorZone.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(serviceIntent);
        } else {
            context.startService(serviceIntent);
        }

        Log.d(TAG, "TerrorZoneAlarmReceiver : Alarm triggered and service started.");

        // SharedPreferences 초기화
        sharedPreferences = context.getSharedPreferences(SharedValue.NOTIFICATION_TERROR_ZONE_ALARM_SETTINGS, Context.MODE_PRIVATE);

        // 초기 값 확인 및 알람 예약
        int time1Hour = sharedPreferences.getInt("time_1_hour", 0);
        int time15 = sharedPreferences.getInt("time_15", 0);
        int time30 = sharedPreferences.getInt("time_30", 0);

        if (time1Hour == TIME_IS_1HOUR) {
            scheduleNextAlarmHourly(context);
            Log.w(TAG, "초기화: 1시간 알람 예약됨.");
        } else if (time15 == TIME_IS_15MINUTE) {
            scheduleNextAlarm16Minute(context);
            Log.w(TAG, "초기화: 16분 알람 예약됨.");
        } else if (time30 == TIME_IS_30MINUTE) {
            scheduleNextAlarm30Minute(context);
            Log.w(TAG, "초기화: 30분 알람 예약됨.");
        } else {
            Log.w(TAG, "초기화: 예약 조건이 충족되지 않음.");
        }

        // 리스너는 필요할 경우만 등록
        registerSharedPreferenceChangeListener(context);
    }

    // SharedPreferences 리스너 등록 메서드
    private void registerSharedPreferenceChangeListener(Context context) {
        if (sharedPreferences == null) return;

        SharedPreferences.OnSharedPreferenceChangeListener listener =
                new SharedPreferences.OnSharedPreferenceChangeListener() {
                    @Override
                    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, @Nullable String key) {
                        if (key == null) {
                            Log.w(TAG, "변경된 키가 null입니다.");
                            return;
                        }

                        switch (key) {
                            case "time_1_hour":
                                if (sharedPreferences.getInt(key, 0) == TIME_IS_1HOUR) {
                                    scheduleNextAlarmHourly(context);
                                    Log.w(TAG, "time_1_hour 변경됨. 1시간 알람 예약.");
                                } else {
                                    Log.w(TAG, "time_1_hour 변경됨, 하지만 조건 불충족.");
                                }
                                break;

                            case "time_15":
                                if (sharedPreferences.getInt(key, 0) == TIME_IS_15MINUTE) {
                                    scheduleNextAlarm16Minute(context);
                                    Log.w(TAG, "time_15 변경됨. 16분 알람 예약.");
                                } else {
                                    Log.w(TAG, "time_15 변경됨, 하지만 조건 불충족.");
                                }
                                break;

                            case "time_30":
                                if (sharedPreferences.getInt(key, 0) == TIME_IS_30MINUTE) {
                                    scheduleNextAlarm30Minute(context);
                                    Log.w(TAG, "time_30 변경됨. 30분 알람 예약.");
                                } else {
                                    Log.w(TAG, "time_30 변경됨, 하지만 조건 불충족.");
                                }
                                break;

                            default:
                                Log.w(TAG, "알 수 없는 키 변경. Key: " + key);
                                break;
                        }
                    }
                };

        sharedPreferences.registerOnSharedPreferenceChangeListener(listener);
    }

    private void scheduleNextAlarm16Minute(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (!alarmManager.canScheduleExactAlarms()) {
                // 권한이 없으면 설정 화면으로 안내
                Intent intent = new Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM);
                context.startActivity(intent);
                Log.e(TAG, "Cannot schedule exact alarms. Requesting permission.");
                return;
            }
        }

        // 알람 시간 계산
        Calendar calendar = Calendar.getInstance();
        int currentMinute = calendar.get(Calendar.MINUTE);

        // 다음 01, 16, 31, 46분 계산
        int[] triggerMinutes = {1, 16, 31, 46};
        int nextMinute = 0;
        boolean foundNext = false;

        for (int minute : triggerMinutes) {
            if (currentMinute < minute) {
                nextMinute = minute;
                foundNext = true;
                break;
            }
        }

        // 현재 시간이 46분 이후라면 다음 시간의 01분으로 설정
        if (!foundNext) {
            nextMinute = triggerMinutes[0];
            calendar.add(Calendar.HOUR_OF_DAY, 1);
        }

        calendar.set(Calendar.MINUTE, nextMinute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        long triggerTime = calendar.getTimeInMillis();

        // 알람 예약
        Intent alarmIntent = new Intent(context, TerrorZoneAlarmReceiver.class);
        alarmIntent.setAction("ACTION_SCHEDULE_ALARM");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context,
                0, // requestCode를 고정
                alarmIntent,
                PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT
        );

        alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                triggerTime,
                pendingIntent
        );

        Log.d(TAG, "01, 16, 31, 46분에 실행 TerrorZoneAlarmReceiver : Next alarm scheduled for: " + new Date(triggerTime));
    }

    private void scheduleNextAlarm30Minute(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (!alarmManager.canScheduleExactAlarms()) {
                // 권한이 없으면 설정 화면으로 안내
                Intent intent = new Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM);
                context.startActivity(intent);
                Log.e(TAG, "Cannot schedule exact alarms. Requesting permission.");
                return;
            }
        }

        // 알람 시간 계산
        Calendar calendar = Calendar.getInstance();
        int currentMinute = calendar.get(Calendar.MINUTE);

        if (currentMinute <= 30) {
            calendar.set(Calendar.MINUTE, 31);
        } else {
            calendar.set(Calendar.MINUTE, 1);
            calendar.add(Calendar.HOUR_OF_DAY, 1);
        }

        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        long triggerTime = calendar.getTimeInMillis();

        // 알람 예약
        Intent alarmIntent = new Intent(context, TerrorZoneAlarmReceiver.class);
        alarmIntent.setAction("ACTION_SCHEDULE_ALARM");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context,
                (int) triggerTime, // 고유 requestCode 사용
                alarmIntent,
                PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT
        );

        alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                triggerTime,
                pendingIntent
        );

        Log.d(TAG, "30분 마다 실행 TerrorZoneAlarmReceiver : Next alarm scheduled for: " + new Date(triggerTime));
    }

    private void scheduleNextAlarmHourly(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (!alarmManager.canScheduleExactAlarms()) {
                // 권한이 없으면 설정 화면으로 안내
                Intent intent = new Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM);
                context.startActivity(intent);
                Log.e(TAG, "Cannot schedule exact alarms. Requesting permission.");
                return;
            }
        }

        // 알람 시간 계산
        Calendar calendar = Calendar.getInstance();

        // 현재 시간 기준으로 다음 시간의 01분으로 설정
        if (calendar.get(Calendar.MINUTE) >= 1) {
            calendar.add(Calendar.HOUR_OF_DAY, 1);
        }
        calendar.set(Calendar.MINUTE, 1);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        long triggerTime = calendar.getTimeInMillis();

        // 알람 예약
        Intent alarmIntent = new Intent(context, TerrorZoneAlarmReceiver.class);
        alarmIntent.setAction("ACTION_SCHEDULE_ALARM");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context,
                0, // 고유 requestCode가 필요 없는 경우 0으로 고정
                alarmIntent,
                PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT
        );

        alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                triggerTime,
                pendingIntent
        );
        Log.d(TAG, "01분마다 실행 TerrorZoneAlarmReceiver : Next alarm scheduled for: " + new Date(triggerTime));
    }


}
