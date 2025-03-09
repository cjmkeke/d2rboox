package com.cjmkeke.d2rbooks.permission;

import android.Manifest;
import android.util.Log;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

import java.util.List;

public class AlarmPermissionHelper {

    private static final String TAG = "AlarmPermissionHelper";

    public static void requestExactAlarmPermission(PermissionCallback callback) {
        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                if (callback != null) {
                    callback.onPermissionGranted();
                }
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Log.w(TAG, deniedPermissions.toString());
                if (callback != null) {
                    callback.onPermissionDenied();
                }
            }
        };

        TedPermission.create()
                .setPermissions(Manifest.permission.POST_NOTIFICATIONS)
                .setDeniedMessage("앱을 정상적으로 사용하기 위해서는 알람을 허용해주세요.")
                .setPermissionListener(permissionListener)
                .check();
    }
}
