package com.cjmkeke.d2rbooks.service.background;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UberAlarmManager {

    private static final String TAG = "UberAlarmManager";

    public static void setRepeatingAlarms(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, UberAlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context, 1, intent, PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT);

        long triggerTimeMillis = getNextTriggerTime();

        try {
            alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    triggerTimeMillis,
                    pendingIntent
            );

            Date date = new Date(triggerTimeMillis);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat.format(date);
        } catch (SecurityException e) {
            Log.e(TAG, "SecurityException: Cannot schedule exact alarms.", e);
        }
    }

    /**
     * 다음 알람이 실행될 시간을 계산하는 메서드
     **/
    private static long getNextTriggerTime() {
        Calendar calendar = Calendar.getInstance();
        int currentMinute = calendar.get(Calendar.MINUTE);

        // 다음 1분 단위로 설정
        int nextMinute = currentMinute + 1;

        if (nextMinute >= 60) {
            calendar.add(Calendar.HOUR_OF_DAY, 1); // 한 시간 추가
            nextMinute = 0; // 분을 0으로 초기화
        }

        calendar.set(Calendar.MINUTE, nextMinute);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTimeInMillis();
    }

}
