package com.cjmkeke.d2rbooks.permission;

public interface PermissionCallback {
    void onPermissionGranted();
    void onPermissionDenied();
}
