package com.cjmkeke.d2rbooks.dialog;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivityHelmItemShowBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HelmItemShow extends Activity {

    private ActivityHelmItemShowBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    private Intent intent;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

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

        mBinding = ActivityHelmItemShowBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        intent = getIntent();
        String armorName = intent.getStringExtra("item_name");
        String defense = intent.getStringExtra("defense");
        String rating = intent.getStringExtra("rating");
        String position = intent.getStringExtra("position");
        String comment = intent.getStringExtra("comment");
        String soket = intent.getStringExtra("soket");

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        mBinding.llMainNomal.setVisibility(View.GONE);
        mBinding.llMainExceptional.setVisibility(View.GONE);
        mBinding.llMainElite.setVisibility(View.GONE);

        if (rating.trim().equals("노말") || rating.trim().equals("써클릿")) {
            mBinding.llMainNomal.setVisibility(View.VISIBLE);
            mBinding.llMainExceptional.setVisibility(View.GONE);
            mBinding.llMainElite.setVisibility(View.GONE);
            defenseCalculation(defense, mBinding.tvNomalDefense, mBinding.tvNomalDefense15, mBinding.tvNomalDefenseEthereal, mBinding.tvNomalDefenseEthereal15);

        } else if (rating.trim().equals("익셉셔널") || rating.trim().equals("써클릿")) {
            mBinding.llMainNomal.setVisibility(View.GONE);
            mBinding.llMainExceptional.setVisibility(View.VISIBLE);
            mBinding.llMainElite.setVisibility(View.GONE);
            defenseCalculation(defense, mBinding.tvExceptionalDefense, mBinding.tvExceptionalDefense15, mBinding.tvExceptionalDefenseEthereal, mBinding.tvExceptionalDefenseEthereal15);

        } else if (rating.trim().equals("고급") || rating.trim().equals("써클릿")) {
            mBinding.llMainNomal.setVisibility(View.GONE);
            mBinding.llMainExceptional.setVisibility(View.GONE);
            mBinding.llMainElite.setVisibility(View.VISIBLE);
            defenseCalculation(defense, mBinding.tvEliteDefense, mBinding.tvEliteDefense15, mBinding.tvEliteDefenseEthereal, mBinding.tvEliteDefenseEthereal15);
        }

        mBinding.tvName.setText(armorName);
        mBinding.tvRating.setText(rating);
        mBinding.tvSoket.setText(String.valueOf(soket));

        // 코멘트
        if (firebaseUser != null) {
            if (firebaseUser.getEmail().equals("cjmkeke@gmail.com")) {
                mBinding.tvHelmCommentCommit.setVisibility(View.VISIBLE);
                mBinding.etComment.setEnabled(true);
                mBinding.tvHelmCommentCommit.setOnClickListener(v -> {
                    databaseReference.child("item_data").child("helm").child(position).child("comment").setValue(mBinding.etComment.getText().toString());
                    finish();
                });
            } else {
                mBinding.tvHelmCommentCommit.setVisibility(View.GONE);
                mBinding.etComment.setEnabled(false);
            }
        } else {
            mBinding.etComment.setEnabled(false);
            mBinding.tvHelmCommentCommit.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(comment)) {
            mBinding.etComment.setText(comment);
        }

        databaseReference.child("item_data").child("helm").child(position).child("src").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String src = snapshot.getValue(String.class);
                    int value = src.indexOf(".");
                    String imgName = src.substring(0,value);
                    mBinding.ivImg.setImageResource(getResources().getIdentifier(imgName, "drawable", getPackageName()));
                } else {
                    mBinding.llMainImg.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("ArmorItemShow", "데이터베이스 에러 : "+ error.getMessage());
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

    private void defenseCalculation(String defense, TextView basicDefense, TextView basicDefenseUp, TextView etherealDefense, TextView etherealDefenseUp) {
        // 고급 5~15% 방상 계산
        String[] defenseSplit = defense.split("-");
        double defense1 = Double.parseDouble(defenseSplit[0].trim()); // 최소 방어력
        double defense2 = Double.parseDouble(defenseSplit[1].trim()); // 최대 방어력

        int basicDefenseMin = Integer.parseInt(defenseSplit[0]);
        int basicDefenseMax = Integer.parseInt(defenseSplit[1]);
        basicDefense.setText(basicDefenseMin + "-" + basicDefenseMax);

        int etherealMinDefenseDefault = (int) ((int) defense1 * 1.5);
        int etherealMaxDefenseDefault = (int) ((int) defense2 * 1.5);

        int minDefense = (int) defense1 + 1;
        int maxDefense = (int) defense2 + 1;

        // 15% 방상 계산 (최소치와 최대치 +1 사용 후 소수점 절삭)
        int result2 = (int) (maxDefense * 1.15);
        basicDefenseUp.setText(result2 + "");

//            // 에테리얼 계산 (최소치와 최대치 +1 사용 후 1.5배, 소수점 절삭)
        int etherealMaxDefense = (int) (maxDefense * 1.5);
        etherealDefense.setText(etherealMinDefenseDefault + "-" + etherealMaxDefenseDefault);

        // 에테리얼 15% 방상 계산 (소수점 절삭)
        int etherealEnhancedMax = (int) (etherealMaxDefense * 1.15);
        etherealDefenseUp.setText(etherealEnhancedMax + "");
    }
}