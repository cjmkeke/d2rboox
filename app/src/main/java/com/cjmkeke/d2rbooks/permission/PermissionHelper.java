package com.cjmkeke.d2rbooks.permission;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.widget.Toast;

public class PermissionHelper {

    private static final int REQUEST_CODE_ALARM_PERMISSION = 1001;

    // 정확한 알람 권한 설정
    public static void requestAlarmPermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) { // Android 14(API 34) 이상
            AlarmManager alarmManager = (AlarmManager) activity.getSystemService(Context.ALARM_SERVICE);

            // 알람 권한이 이미 허용된 경우 메서드를 종료
            if (alarmManager != null && alarmManager.canScheduleExactAlarms()) {
                return;
            }

            // 알람 권한을 요청하는 인텐트 실행
            Intent intent = new Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM,
                    Uri.parse("package:" + activity.getPackageName()));
            activity.startActivityForResult(intent, REQUEST_CODE_ALARM_PERMISSION);
        }
    }

    // 배터리 최적화 예외 설정
    public static void requestBatteryOptimizationPermission(Activity activity) {
        PowerManager pm = (PowerManager) activity.getSystemService(Context.POWER_SERVICE);

        // 사용자가 이미 배터리 최적화 예외 설정을 했는지 확인
        if (pm != null && pm.isIgnoringBatteryOptimizations(activity.getPackageName())) {
            return; // 이미 설정되어 있다면 메서드를 종료
        }

        // Android R(API 30) 이상일 때만 실행
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // 배터리 최적화 예외 요청 인텐트
            Intent intent = new Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS,
                    Uri.parse("package:" + activity.getPackageName()));
            activity.startActivity(intent);
        } else {
            // 배터리 최적화 예외 요청을 지원하지 않는 버전일 경우 안내 메시지
            Toast.makeText(activity, "배터리 최적화 예외 설정이 필요합니다.", Toast.LENGTH_LONG).show();
        }
    }
}
