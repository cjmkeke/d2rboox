package com.cjmkeke.d2rbooks.dialog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivityShowUniqueBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniqueItemShow extends AppCompatActivity {

    private ActivityShowUniqueBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    private Intent intent;
    private FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private String itemName;
    private String drop_name;
    private String img;
    private String options;
    private String type;
    private String databaseIndex;
    private SpannableString spannableString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityShowUniqueBinding.inflate(getLayoutInflater());

        fontSharedPreferences = getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);

        setContentView(mBinding.getRoot());

        intent = getIntent();
        if (intent != null) {
            itemName = intent.getStringExtra("item_name");
            drop_name = intent.getStringExtra("drop_name");
            img = intent.getStringExtra("img");
            options = intent.getStringExtra("options");
            type = intent.getStringExtra("type");
            img = intent.getStringExtra("img");
            databaseIndex = String.valueOf(intent.getIntExtra("index",0));
        }

        mBinding.etItemOptions.setEnabled(false);

        mBinding.tvItemName.setText(itemName);
        mBinding.tvDropName.setText(drop_name);
        mBinding.tvType.setText(type);

        // "한손"과 "사냥터" 위치 찾기
        int valueStartIndex[] = {options.length()};
        int endIndex = options.indexOf("사냥터");

        if (endIndex != -1) {
            endIndex = options.indexOf("\n", endIndex);
            if (endIndex == -1) {
                // 개행이 없으면 텍스트 끝까지 설정
                endIndex = options.length();
            }
        }

        try {
            if (valueStartIndex.length != -1) {
                // 텍스트 분리
                String beforeBracket = options.substring(0, valueStartIndex.length).trim();
                String insideBracket = options.substring(0, endIndex).trim();
                String afterBracket = options.substring(endIndex).trim(); // 개행 이후 텍스트

                // 전체 텍스트를 결합 후 SpannableString 생성
                String fullText = insideBracket + "\n\n" + afterBracket;
                spannableString = new SpannableString(fullText);

                // "한손"부터 "사냥터"까지 텍스트를 흰색으로 설정
                int colorStart = beforeBracket.length() - 1;
                int colorEnd = colorStart + insideBracket.length();

                spannableString.setSpan(
                        new ForegroundColorSpan(Color.WHITE),
                        colorStart,
                        colorEnd,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );

                // 정규 표현식으로 "(변함)"이 포함된 모든 라인을 찾기
                Pattern pattern = Pattern.compile(".*\\(변함\\).*", Pattern.MULTILINE);
                Matcher matcher = pattern.matcher(fullText);

                while (matcher.find()) {
                    int lineStart = matcher.start();
                    int lineEnd = matcher.end();

                    // (변함)이 포함된 라인에 빨간색 설정
                    spannableString.setSpan(
                            new ForegroundColorSpan(getResources().getColor(R.color.item_change_options_color)),
                            lineStart,
                            lineEnd,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
                }

                // 로그로 변함 라인 출력
                String[] colorChangeOptions = options.split("\n");
                for (String string : colorChangeOptions) {
                    if (string.contains("(변함)")) {
                        Log.w("변함 로그", string);
                    }
                }

                // 결과를 TextView에 설정
                mBinding.etItemOptions.setText(spannableString);
            }
        } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
            // 예외 발생 시 원본 텍스트를 설정
            mBinding.etItemOptions.setText(options);
        }


        int id = getResources().getIdentifier(img, "drawable", getPackageName());
        mBinding.ivItemImg.setBackgroundResource(id);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("item_data").child("unique");

        mBinding.tvModifyRunewordOptions.setVisibility(View.GONE);
        if (firebaseUser != null) {
            if (firebaseUser.getUid().equals("cjmkeke@gmail.com")){
                mBinding.etItemOptions.setEnabled(true);
                mBinding.tvModifyRunewordOptions.setVisibility(View.VISIBLE);
                mBinding.tvModifyRunewordOptions.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        databaseReference.child(databaseIndex).child("options").setValue(mBinding.etItemOptions.getText().toString());
                        finish();
                    }
                });
            } else {
                mBinding.etItemOptions.setEnabled(false);
                mBinding.tvModifyRunewordOptions.setVisibility(View.GONE);
            }

        } else {
            mBinding.etItemOptions.setEnabled(false);
            mBinding.tvModifyRunewordOptions.setVisibility(View.GONE);
        }

    }

}