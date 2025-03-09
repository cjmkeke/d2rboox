package com.cjmkeke.d2rbooks.service.background;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import java.util.Calendar;

public class UberAlarmReceiver extends BroadcastReceiver {

    /**
     * 다음 알람을 예약하는 클래스
     **/
    private static final String TAG = "UberAlarmReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // 서비스 실행
        Intent serviceIntent = new Intent(context, Uber.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(serviceIntent);
        } else {
            context.startService(serviceIntent);
        }

        // 다음 알람 예약
        scheduleNextAlarm(context);

    }

    private void scheduleNextAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (!alarmManager.canScheduleExactAlarms()) {
                // 권한 요청
                Intent intent = new Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM);
                context.startActivity(intent);
                Log.e(TAG, "Cannot schedule exact alarms. Requesting permission.");
                return;
            }
        }

// 알람 시간 계산
//        Calendar calendar = Calendar.getInstance();
//        int currentMinute = calendar.get(Calendar.MINUTE);
//
//// 다음 5분 단위 계산
//        int nextMinute = ((currentMinute / 5) + 1) * 5;
//
//        if (nextMinute >= 60) { // 60분 이상이면 한 시간 추가
//            calendar.add(Calendar.HOUR_OF_DAY, 1);
//            nextMinute = 0; // 분을 0으로 설정
//        }
//
//        calendar.set(Calendar.MINUTE, nextMinute);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//
//        long triggerTime = calendar.getTimeInMillis();

        Calendar calendar = Calendar.getInstance();
        int currentMinute = calendar.get(Calendar.MINUTE);

// 다음 1분 단위 계산
        int nextMinute = currentMinute + 1;

        if (nextMinute >= 60) { // 60분 이상이면 한 시간 추가
            calendar.add(Calendar.HOUR_OF_DAY, 1);
            nextMinute = 0; // 분을 0으로 설정
        }

        calendar.set(Calendar.MINUTE, nextMinute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        long triggerTime = calendar.getTimeInMillis();


        // 고유 PendingIntent 생성
        Intent alarmIntent = new Intent(context, UberAlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context,
                1, // 고정된 requestCode 사용
                alarmIntent,
                PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_CANCEL_CURRENT // 기존 알람 무효화
        );

        alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                triggerTime,
                pendingIntent
        );

//        Log.d(TAG, "UberAlarmReceiver : Next alarm scheduled for: " + new Date(triggerTime));
    }
}
