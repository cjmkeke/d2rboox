package com.cjmkeke.d2rbooks.dialog;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivityShowRuneWordDialogBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShowRuneWordDialog extends Activity {

    private ActivityShowRuneWordDialogBinding mBinding;
    private Intent intent;
    private String runeName;
    private String url;
    private String rune1;
    private String rune2;
    private String rune3;
    private String rune4;
    private String rune5;
    private String rune6;

    private String item_name;

    private SharedPreferences fontSharedPreferences;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;

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

        mBinding = ActivityShowRuneWordDialogBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        mBinding.webview.getSettings().setJavaScriptEnabled(true);
        mBinding.webview.setWebViewClient(new WebViewClient());

        // TODO 관리자 화면
        mBinding.etShowItemOptions.setEnabled(false);
        mBinding.tvModifyRunewordOptions.setVisibility(View.GONE);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            if (firebaseUser.getEmail().equals("cjmkeke@gmail.com")) {
                mBinding.etShowItemOptions.setEnabled(false);
                mBinding.llAdmin.setVisibility(View.GONE);
                mBinding.tvModifyRunewordOptions.setVisibility(View.GONE);
            } else {
                mBinding.etShowItemOptions.setEnabled(false);
                mBinding.llAdmin.setVisibility(View.GONE);
            }
        } else {
            mBinding.llAdmin.setVisibility(View.GONE);
        }

        intent = getIntent();
        if (intent != null) {
            runeName = intent.getStringExtra("runeName");
            rune1 = intent.getStringExtra("rune1");
            rune2 = intent.getStringExtra("rune2");
            rune3 = intent.getStringExtra("rune3");
            rune4 = intent.getStringExtra("rune4");
            rune5 = intent.getStringExtra("rune5");
            rune6 = intent.getStringExtra("rune6");
            url = intent.getStringExtra("url");
        }

        if (rune1 != null) {
            int resourceId = getResources().getIdentifier(rune1.toLowerCase(), "drawable", getPackageName());
            if (resourceId != 0) {
                mBinding.ivRune1.setBackgroundResource(resourceId);
                mBinding.tvRune1Name.setText(rune1);
            } else {
                Log.e("ShowRuneWordDialog", "Resource not found for rune1: " + rune1);
            }
        }

        if (rune2 != null) {
            int resourceId = getResources().getIdentifier(rune2.toLowerCase(), "drawable", getPackageName());
            if (resourceId != 0) {
                mBinding.ivRune2.setBackgroundResource(resourceId);
                mBinding.tvRune2Name.setText(rune2);
            } else {
                Log.e("ShowRuneWordDialog", "Resource not found for rune2: " + rune2);
            }
        }

        if (rune3 != null) {
            int resourceId = getResources().getIdentifier(rune3.toLowerCase(), "drawable", getPackageName());
            if (resourceId != 0) {
                mBinding.ivRune3.setBackgroundResource(resourceId);
                mBinding.tvRune3Name.setText(rune3);
            } else {
                Log.e("ShowRuneWordDialog", "Resource not found for rune3: " + rune3);
            }
        }

        if (rune4 != null) {
            int resourceId = getResources().getIdentifier(rune4.toLowerCase(), "drawable", getPackageName());
            if (resourceId != 0) {
                mBinding.ivRune4.setBackgroundResource(resourceId);
                mBinding.tvRune4Name.setText(rune4);
            } else {
                Log.e("ShowRuneWordDialog", "Resource not found for rune4: " + rune4);
            }
        }

        if (rune5 != null) {
            int resourceId = getResources().getIdentifier(rune5.toLowerCase(), "drawable", getPackageName());
            if (resourceId != 0) {
                mBinding.ivRune5.setBackgroundResource(resourceId);
                mBinding.tvRune5Name.setText(rune5);
            } else {
                Log.e("ShowRuneWordDialog", "Resource not found for rune5: " + rune5);
            }
        }

        if (rune6 != null) {
            int resourceId = getResources().getIdentifier(rune6.toLowerCase(), "drawable", getPackageName());
            if (resourceId != 0) {
                mBinding.ivRune6.setBackgroundResource(resourceId);
                mBinding.tvRune6Name.setText(rune6);
            } else {
                Log.e("ShowRuneWordDialog", "Resource not found for rune6: " + rune6);
            }
        }

        mBinding.webview.loadUrl(url);
        databaseReference.child("runeword").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mBinding.etRune1Name.setText(snapshot.child(runeName).child("rune1").getValue(String.class));
                mBinding.etRune2Name.setText(snapshot.child(runeName).child("rune2").getValue(String.class));
                mBinding.etRune3Name.setText(snapshot.child(runeName).child("rune3").getValue(String.class));
                mBinding.etRune4Name.setText(snapshot.child(runeName).child("rune4").getValue(String.class));
                mBinding.etRune5Name.setText(snapshot.child(runeName).child("rune5").getValue(String.class));
                mBinding.etRune6Name.setText(snapshot.child(runeName).child("rune6").getValue(String.class));

                if (snapshot.child(runeName).child("comment").exists()){
                    mBinding.tvShowItemComment.setText(snapshot.child(runeName).child("comment").getValue(String.class));
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mBinding.tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rune1 = mBinding.etRune1Name.getText().toString();
                String rune2 = mBinding.etRune2Name.getText().toString();
                String rune3 = mBinding.etRune3Name.getText().toString();
                String rune4 = mBinding.etRune4Name.getText().toString();
                String rune5 = mBinding.etRune5Name.getText().toString();
                String rune6 = mBinding.etRune6Name.getText().toString();


                if (TextUtils.isEmpty(rune1)) {
                    databaseReference.child("runeword").child(runeName).child("rune1").setValue("");
                } else {
                    databaseReference.child("runeword").child(runeName).child("rune1").setValue(mBinding.etRune1Name.getText().toString());
                    Log.d("rune1", mBinding.etRune1Name.getText().toString());
                }

                if (TextUtils.isEmpty(rune2)) {
                    databaseReference.child("runeword").child(runeName).child("rune2").setValue("");
                } else {
                    databaseReference.child("runeword").child(runeName).child("rune2").setValue(mBinding.etRune2Name.getText().toString());
                }

                if (TextUtils.isEmpty(rune3)) {
                    databaseReference.child("runeword").child(runeName).child("rune3").setValue("");
                } else {
                    databaseReference.child("runeword").child(runeName).child("rune3").setValue(mBinding.etRune3Name.getText().toString());
                }

                if (TextUtils.isEmpty(rune4)) {
                    databaseReference.child("runeword").child(runeName).child("rune4").setValue("");
                } else {
                    databaseReference.child("runeword").child(runeName).child("rune4").setValue(mBinding.etRune4Name.getText());
                }

                if (TextUtils.isEmpty(rune5)) {
                    databaseReference.child("runeword").child(runeName).child("rune5").setValue("");
                } else {
                    databaseReference.child("runeword").child(runeName).child("rune5").setValue(mBinding.etRune5Name.getText());
                }

                if (TextUtils.isEmpty(rune6)) {
                    databaseReference.child("runeword").child(runeName).child("rune6").setValue("");
                } else {
                    databaseReference.child("runeword").child(runeName).child("rune6").setValue(mBinding.etRune6Name.getText());
                }

            }
        });

//        mBinding.tvItemNameGet.setText(item_name);
//        Log.w("ShowRuneWordDialog", item_name);

        // cjmkeke@gmail.com 이라고 한다면 Edittext를 수정할수있도록 하고 아니면, 수정할수 없도록하자.

        databaseReference.child("item_data").child("test").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snap : snapshot.getChildren()) {
                    String itemName = snap.child("item_name").getValue(String.class);
                    if (itemName != null) {
                        if (runeName.equals(itemName)) {
                            String neededItem = snap.child("item_need").getValue(String.class);
                            String level = snap.child("level").getValue(String.class);
                            String options = snap.child("option").getValue(String.class);

                            mBinding.tvShowItemName.setText(itemName);
                            mBinding.tvShowNeedItem.setText(neededItem);
                            mBinding.tvShowLevel.setText(level);

                            String replacedOptions = options.replace(",", "\n"); // ,를 \n으로 변경
                            SpannableString spannableString = new SpannableString(replacedOptions);

                            // 각 줄에 대해 색상 적용
                            int start = 0;
                            String[] lines = replacedOptions.split("\n");
                            for (String line : lines) {
                                int end = start + line.length();

                                // "변함"이 포함된 줄에만 색상 적용
                                if (line.contains("변함")) {
                                    spannableString.setSpan(
                                            new ForegroundColorSpan(Color.parseColor("#6E6EFF")), // 원하는 색상 설정
                                            start,
                                            end,
                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                    );
                                }
                                start = end + 1;
                            }

                            mBinding.etShowItemOptions.setText(spannableString);

                            mBinding.tvModifyRunewordOptions.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    databaseReference.child("item_data").child("test").child(snap.getKey()).child("option").setValue(mBinding.etShowItemOptions.getText().toString());
                                }
                            });

                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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