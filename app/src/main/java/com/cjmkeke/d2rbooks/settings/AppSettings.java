package com.cjmkeke.d2rbooks.settings;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AppSettings extends AppCompatActivity {

    private Context context;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private static final String TAG = "AppSettings";
    private String kodia = "kodia";
    private String nanum = "nanum";

    public AppSettings(Context context) {
        this.context = context;
    }

    public void setAppVersion() throws PackageManager.NameNotFoundException {
        // 업데이트
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        int packageVersion = packageInfo.versionCode;
        Log.w(TAG, "packageVersion : " + packageVersion);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        databaseReference.child("app_settings").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int updateVersion = snapshot.child("version").getValue(Integer.class);
                Log.w(TAG, "updateVersion : " + updateVersion);
                // 패키지 버전이랑 데이터베이스 버전이랑 같으면 리턴
                if (updateVersion != packageVersion) {
                    Intent intent = new Intent(context, UpdateDialog.class);
                    context.startActivity(intent);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
