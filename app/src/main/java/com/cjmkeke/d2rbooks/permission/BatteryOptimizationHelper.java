package com.cjmkeke.d2rbooks.permission;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

import java.util.List;

public class BatteryOptimizationHelper {

    public static void requestBatteryOptimization(Context context, PermissionCallback callback) {
        TedPermission.create()
                .setPermissionListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            String packageName = context.getPackageName();
                            PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
                            if (powerManager != null && !powerManager.isIgnoringBatteryOptimizations(packageName)) {
                                Intent intent = new Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                                intent.setData(Uri.parse("package:" + packageName));
                                context.startActivity(intent);
                            }
                        }
                        if (callback != null) {
                            callback.onPermissionGranted();
                        }
                    }

                    @Override
                    public void onPermissionDenied(List<String> deniedPermissions) {
                        Toast.makeText(context, "권한이 거부되었습니다.", Toast.LENGTH_SHORT).show();
                        if (callback != null) {
                            callback.onPermissionDenied();
                        }
                    }
                })
                .setDeniedMessage("배터리 최적화 해제를 허용해야 앱이 정상적으로 작동합니다.")
                .setPermissions("android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS")
                .check();
    }
}
