package com.cjmkeke.d2rbooks;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.cjmkeke.d2rbooks.databinding.ActivityLauncherBinding;

public class LauncherActivity extends AppCompatActivity {

    private ActivityLauncherBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityLauncherBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // VideoView 설정
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/logo");
        mBinding.launcherVideo.setVideoURI(uri);
        mBinding.launcherVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // 3초 후에 MainActivity로 이동
                Intent intent = new Intent(LauncherActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                finish(); // 현재 액티비티 종료
            }
        }, 3000); // 3초 후 실행


    }
}
