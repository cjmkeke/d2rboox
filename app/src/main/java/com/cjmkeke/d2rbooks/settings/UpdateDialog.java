package com.cjmkeke.d2rbooks.settings;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivityUpdateDialogBinding;

public class UpdateDialog extends Activity {

    private ActivityUpdateDialogBinding mBinding;
    private SharedPreferences fontSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.TransparentDialog);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setFinishOnTouchOutside(false);

        fontSharedPreferences = getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);

        mBinding = ActivityUpdateDialogBinding.inflate(getLayoutInflater());
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        adjustDialogSize();
        setContentView(mBinding.getRoot());

        mBinding.llUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.cjmkeke.diablorune&hl=ko"));
                startActivity(intent);
                finish();
            }
        });

    }

    private void adjustDialogSize() {
        // 화면 크기 가져오기
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;

        // 좌우 10dp 남기는 크기로 설정
        int marginInDp = 20;
        float density = getResources().getDisplayMetrics().density;
        int marginInPx = (int) (marginInDp * density);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = screenWidth - (2 * marginInPx); // 좌우 10dp씩 남기기
        getWindow().setAttributes(params);
    }

}