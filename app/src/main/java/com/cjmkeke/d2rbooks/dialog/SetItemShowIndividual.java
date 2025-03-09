package com.cjmkeke.d2rbooks.dialog;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivitySetItemShowIndividualBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SetItemShowIndividual extends Activity {

    private static final String TAG = "SetItemShowIndividual";
    private SharedPreferences fontSharedPreferences;
    private String item_name;
    private String set_item_partial_effect;
    private String optionsAfter;
    private String optionsBefore;
    private String set_name;
    private String type;
    private String img;
    private Intent intent;
    private ActivitySetItemShowIndividualBinding mBinding;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.TransparentDialog);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setFinishOnTouchOutside(true);

        fontSharedPreferences = getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);

        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        adjustDialogSize();

        intent = getIntent();
        item_name = intent.getStringExtra("item_name");
        set_item_partial_effect = intent.getStringExtra("set_item_partial_effect");
        optionsAfter = intent.getStringExtra("options1");
        str = intent.getStringExtra("options1");
        optionsBefore = intent.getStringExtra("options2");
        set_name = intent.getStringExtra("set_name");
        type = intent.getStringExtra("type");
        img = intent.getStringExtra("img");

        mBinding = ActivitySetItemShowIndividualBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            if (firebaseUser.getEmail().equals("cjmkeke@gmail.com")) {
                mBinding.etItemOptionsIndividual1.setEnabled(true);
                mBinding.etItemOptionsIndividual2.setEnabled(true);
                Log.w(TAG, firebaseUser.getEmail());
            } else {
                mBinding.etItemOptionsIndividual1.setEnabled(false);
                mBinding.etItemOptionsIndividual2.setEnabled(false);
                Log.w(TAG, "로그인되지 않았습니다.");
            }
        } else {
            mBinding.etItemOptionsIndividual1.setEnabled(false);
            mBinding.etItemOptionsIndividual2.setEnabled(false);
            Log.w(TAG, "firebaseUser가 null 상태입니다.");
        }

        mBinding.etItemOptionsIndividual1.setText(optionsAfter);

        StringBuilder firstPart = new StringBuilder();
        StringBuilder secondPart = new StringBuilder();

        String[] lines = optionsBefore.split("\n");
        boolean secondPartStarted = false;

        for (String line : lines) {
            if (line.matches(".*\\(\\d+ 아이템\\).*")) {
                // 두 번째 구역 시작
                secondPartStarted = true;
            }

            if (secondPartStarted) {
                secondPart.append(line).append("\n");
            } else {
                firstPart.append(line).append("\n");
            }
        }


        SpannableStringBuilder spannableStringBuilder1 = new SpannableStringBuilder(secondPart);
        spannableStringBuilder1.setSpan(new ForegroundColorSpan(Color.parseColor("#3CD029")),
                0, secondPart.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(firstPart).append(spannableStringBuilder1);

        mBinding.etItemOptionsIndividual2.setText(spannableStringBuilder);

        mBinding.tvItemNameIndividual.setText(item_name);
        mBinding.ivImgIndividual.setImageResource(getResources().getIdentifier(img, "drawable", getPackageName()));
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