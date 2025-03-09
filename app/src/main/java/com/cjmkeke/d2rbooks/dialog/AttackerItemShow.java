package com.cjmkeke.d2rbooks.dialog;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivityAttackerItemShowBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AttackerItemShow extends Activity {

    private ActivityAttackerItemShowBinding mBinding;
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
        mBinding = ActivityAttackerItemShowBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        intent = getIntent();
        String armorName = intent.getStringExtra("item_name");
        String attackPower1 = intent.getStringExtra("attackPower1");
        String attackPower2 = intent.getStringExtra("attackPower2");
        String rating = intent.getStringExtra("rating");
        String soket = intent.getStringExtra("soket");
        String comment = intent.getStringExtra("comment");
        String position = intent.getStringExtra("position");

        mBinding.llMainNomal.setVisibility(View.GONE);
        mBinding.llMainExceptional.setVisibility(View.GONE);
        mBinding.llMainElite.setVisibility(View.GONE);

        mBinding.tvName.setText(armorName);
        mBinding.tvRating.setText(rating);
        mBinding.tvSoket.setText(String.valueOf(soket));

        // 등급에 따라 뭐가 보일지 결정하자.
        if (rating.equals("노말")) {
            mBinding.llMainNomal.setVisibility(View.VISIBLE);
            if (attackPower1 != null) {
                mBinding.tvNomalOneHand.setText(attackPower1);
            }

            if (attackPower1.equals("0")) {
                mBinding.llMainNormalOneHand.setVisibility(View.GONE);
            }

            if (attackPower2 != null) {
                mBinding.tvNomalTwoHand.setText(attackPower2);
            }

            if (attackPower2.equals("0")) {
                mBinding.llMainNormalTwoHand.setVisibility(View.GONE);
            }

        } else if (rating.equals("익셉셔널")) {
            mBinding.llMainExceptional.setVisibility(View.VISIBLE);
            if (attackPower1 != null) {
                mBinding.tvExceptionalOneHand.setText(attackPower1);
            }

            if (attackPower1.equals("0")) {
                mBinding.llMainExceptionalOneHand.setVisibility(View.GONE);
            }

            if (attackPower2 != null) {
                mBinding.tvExceptionalOneHand.setText(attackPower2);
            }

            if (attackPower2.equals("0")) {
                mBinding.llMainExceptionalTwoHand.setVisibility(View.GONE);
            }
        } else if (rating.equals("고급")) {
            mBinding.llMainElite.setVisibility(View.VISIBLE);

            if (attackPower1 != null) {
                mBinding.tvEliteOneHand.setText(attackPower1);
            }

            if (attackPower1.equals("0")) {
                mBinding.llMainEliteOneHand.setVisibility(View.GONE);
            }

            if (attackPower2 != null) {
                mBinding.tvEliteTwoHand.setText(attackPower2);
            }

            if (attackPower2.equals("0")) {
                mBinding.llMainEliteTwoHand.setVisibility(View.GONE);
            }
        }

        // 코멘트
        if (firebaseUser != null) {
            if (firebaseUser.getEmail().equals("cjmkeke@gmail.com")) {
                mBinding.tvAttackerCommentCommit.setVisibility(View.VISIBLE);
                mBinding.etComment.setEnabled(true);
                mBinding.tvAttackerCommentCommit.setOnClickListener(v -> {
                    databaseReference.child("item_data").child("weapon").child(position).child("comment").setValue(mBinding.etComment.getText().toString());
                    finish();
                });
            } else {
                mBinding.tvAttackerCommentCommit.setVisibility(View.GONE);
                mBinding.etComment.setEnabled(false);
            }
        } else {
            mBinding.etComment.setEnabled(false);
            mBinding.tvAttackerCommentCommit.setVisibility(View.GONE);
        }

        mBinding.etComment.setText(comment);
        mBinding.llMainComment.setVisibility(View.VISIBLE);

        databaseReference.child("item_data").child("weapon").child(position).child("src").addValueEventListener(new ValueEventListener() {
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

    private void powerNormalCalculate(String attackPower1, String attackPower2,
                                      TextView OneHandPower,
                                      TextView OneHandPower15,
                                      TextView OneHandPowerEthereal,
                                      TextView OneHandPowerEthereal15,
                                      TextView TwhHandPower,
                                      TextView TwoHandPower15,
                                      TextView TwoHandEthereal,
                                      TextView TwoHandEthereal15) {
        normalPower(
                attackPower1,
                attackPower2,
                OneHandPower,
                OneHandPower15,
                OneHandPowerEthereal,
                OneHandPowerEthereal15,
                TwhHandPower,
                TwoHandPower15,
                TwoHandEthereal,
                TwoHandEthereal15);
    }

    private void normalPower(
            String attackPower1,
            String attackPower2,
            TextView oneHandPower,
            TextView oneHandPower15,
            TextView oneHandPowerEthereal,
            TextView oneHandPowerEthereal15,
            TextView twoHandPower,
            TextView twoHandPower15,
            TextView twoHandPowerEthereal,
            TextView twoHandPowerEthereal15
    ) {

        // 원핸드 파워 로직
        String[] attack1 = attackPower1.split("-");
        double attack_01 = Double.parseDouble(attack1[0].trim());
        double attack_02 = Double.parseDouble(attack1[1].trim());

        // 한손 일반 상태의 한손 데미지
        int minOneHand = Integer.parseInt(attack1[0]);
        int maxOneHand = Integer.parseInt(attack1[1]);
        oneHandPower.setText(minOneHand + " - " + maxOneHand);

//        int minDefense = (int) attack_01 + 1;
//        int maxDefense = (int) attack_02 + 1;

        // 한손  일반 상태에서의 15% 맥뎀
        int result1 = (int) (minOneHand * 1.15);
        int result2 = (int) (maxOneHand * 1.15);
        oneHandPower15.setText(result1 + " - " + result2);

        // 한손  에테리얼 원핸드
        int etherealMinAttackPower = (int) ((int) attack_01 * 1.5);
        int etherealMaxAttackPower = (int) ((int) attack_02 * 1.5);
        oneHandPowerEthereal.setText(etherealMinAttackPower + " - " + etherealMaxAttackPower);

        // 한손  에테리얼 원핸드 15% 맥뎀
        int result3 = (int) (etherealMinAttackPower * 1.15);
        int result4 = (int) (etherealMaxAttackPower * 1.15);
        oneHandPowerEthereal15.setText(result3 + " - " + result4);

        mBinding.llMainNormalTwoHand.setVisibility(View.GONE);
        mBinding.llMainNormalTwoHand15.setVisibility(View.GONE);
        mBinding.llMainNormalTwoHandEthereal.setVisibility(View.GONE);
        mBinding.llMainNormalTwoHandEthereal15.setVisibility(View.GONE);

        // 이 밑으로는 양손 데미지
        if (attackPower2 != null && !attackPower2.equals("0")) {
            String[] attack2 = attackPower2.split("-");
            double minTwoHand = Double.parseDouble(attack2[0].trim()); // 최소 방어력
            double maxTwoHand = Double.parseDouble(attack2[1].trim()); // 최대 방어력

            int minTwoHand1 = Integer.parseInt(attack2[0]);
            int maxTwoHand2 = Integer.parseInt(attack2[1]);
            twoHandPower.setText(minTwoHand1 + " - " + maxTwoHand2);

            int minAttack = (int) minTwoHand + 1;
            int maxAttack = (int) maxTwoHand + 1;

            // 양손 일반 상태에서의 15% 맥뎀
            int result01 = (int) (minAttack * 1.15);
            int result02 = (int) (maxAttack * 1.15);
            twoHandPower15.setText(result01 + " - " + result02);

            // 양손 에테리얼 원핸드
            int twoHandEtherealMinAttackPower = (int) ((int) minTwoHand1 * 1.5);
            int twoHandEtherealMaxAttackPower = (int) ((int) maxTwoHand2 * 1.5);
            twoHandPowerEthereal.setText(twoHandEtherealMinAttackPower + " - " + twoHandEtherealMaxAttackPower);

            // 양손 에테리얼 원핸드 15% 맥뎀
            int result03 = (int) (twoHandEtherealMinAttackPower * 1.15);
            int result04 = (int) (twoHandEtherealMaxAttackPower * 1.15);
            twoHandPowerEthereal15.setText(result03 + " - " + result04);

            mBinding.llMainNormalTwoHand.setVisibility(View.VISIBLE);
            mBinding.llMainNormalTwoHand15.setVisibility(View.VISIBLE);
            mBinding.llMainNormalTwoHandEthereal.setVisibility(View.VISIBLE);
            mBinding.llMainNormalTwoHandEthereal15.setVisibility(View.VISIBLE);

        }
    }

    private void powerExceptionalCalculate(String attackPower1, String attackPower2,
                                           TextView OneHandPower,
                                           TextView OneHandPower15,
                                           TextView OneHandPowerEthereal,
                                           TextView OneHandPowerEthereal15,
                                           TextView TwhHandPower,
                                           TextView TwoHandPower15,
                                           TextView TwoHandEthereal,
                                           TextView TwoHandEthereal15) {
        exceptionalPower(
                attackPower1,
                attackPower2,
                OneHandPower,
                OneHandPower15,
                OneHandPowerEthereal,
                OneHandPowerEthereal15,
                TwhHandPower,
                TwoHandPower15,
                TwoHandEthereal,
                TwoHandEthereal15);
    }

    private void exceptionalPower(
            String attackPower1,
            String attackPower2,
            TextView oneHandPower,
            TextView oneHandPower15,
            TextView oneHandPowerEthereal,
            TextView oneHandPowerEthereal15,
            TextView twoHandPower,
            TextView twoHandPower15,
            TextView twoHandPowerEthereal,
            TextView twoHandPowerEthereal15
    ) {

        // 원핸드 파워 로직
        String[] attack1 = attackPower1.split("-");
        double attack_01 = Double.parseDouble(attack1[0].trim());
        double attack_02 = Double.parseDouble(attack1[1].trim());

        // 한손 일반 상태의 한손 데미지
        int minOneHand = Integer.parseInt(attack1[0]);
        int maxOneHand = Integer.parseInt(attack1[1]);
        oneHandPower.setText(minOneHand + " - " + maxOneHand);

//        int minDefense = (int) attack_01 + 1;
//        int maxDefense = (int) attack_02 + 1;

        // 한손  일반 상태에서의 15% 맥뎀
        int result1 = (int) (minOneHand * 1.15);
        int result2 = (int) (maxOneHand * 1.15);
        oneHandPower15.setText(result1 + " - " + result2);

        // 한손  에테리얼 원핸드
        int etherealMinAttackPower = (int) ((int) attack_01 * 1.5);
        int etherealMaxAttackPower = (int) ((int) attack_02 * 1.5);
        oneHandPowerEthereal.setText(etherealMinAttackPower + " - " + etherealMaxAttackPower);

        // 한손  에테리얼 원핸드 15% 맥뎀
        int result3 = (int) (etherealMinAttackPower * 1.15);
        int result4 = (int) (etherealMaxAttackPower * 1.15);
        oneHandPowerEthereal15.setText(result3 + " - " + result4);

        mBinding.llMainNormalTwoHand.setVisibility(View.GONE);
        mBinding.llMainNormalTwoHand15.setVisibility(View.GONE);
        mBinding.llMainNormalTwoHandEthereal.setVisibility(View.GONE);
        mBinding.llMainNormalTwoHandEthereal15.setVisibility(View.GONE);

        // 이 밑으로는 양손 데미지
        if (attackPower2 != null && !attackPower2.equals("0")) {
            String[] attack2 = attackPower2.split("-");
            double minTwoHand = Double.parseDouble(attack2[0].trim()); // 최소 방어력
            double maxTwoHand = Double.parseDouble(attack2[1].trim()); // 최대 방어력

            int minTwoHand1 = Integer.parseInt(attack2[0]);
            int maxTwoHand2 = Integer.parseInt(attack2[1]);
            twoHandPower.setText(minTwoHand1 + " - " + maxTwoHand2);

            int minAttack = (int) minTwoHand + 1;
            int maxAttack = (int) maxTwoHand + 1;

            // 양손 일반 상태에서의 15% 맥뎀
            int result01 = (int) (minTwoHand1 * 1.15);
            int result02 = (int) (maxTwoHand2 * 1.15);
            twoHandPower15.setText(result01 + " - " + result02);

            // 양손 에테리얼 원핸드
            int twoHandEtherealMinAttackPower = (int) ((int) minTwoHand1 * 1.5);
            int twoHandEtherealMaxAttackPower = (int) ((int) maxTwoHand2 * 1.5);
            twoHandPowerEthereal.setText(twoHandEtherealMinAttackPower + " - " + twoHandEtherealMaxAttackPower);

            // 양손 에테리얼 원핸드 15% 맥뎀
            int result03 = (int) (twoHandEtherealMinAttackPower * 1.15);
            int result04 = (int) (twoHandEtherealMaxAttackPower * 1.15);
            twoHandPowerEthereal15.setText(result03 + " - " + result04);

            mBinding.llMainNormalTwoHand.setVisibility(View.VISIBLE);
            mBinding.llMainNormalTwoHand15.setVisibility(View.VISIBLE);
            mBinding.llMainNormalTwoHandEthereal.setVisibility(View.VISIBLE);
            mBinding.llMainNormalTwoHandEthereal15.setVisibility(View.VISIBLE);

        } else {
            mBinding.llMainNormalTwoHand.setVisibility(View.GONE);
            mBinding.llMainNormalTwoHand15.setVisibility(View.GONE);
            mBinding.llMainNormalTwoHandEthereal.setVisibility(View.GONE);
            mBinding.llMainNormalTwoHandEthereal15.setVisibility(View.GONE);

            mBinding.llMainExceptionalTwoHand.setVisibility(View.GONE);
            mBinding.llMainExceptionalTwoHand15.setVisibility(View.GONE);
            mBinding.llMainExceptionalTwoHandEthereal.setVisibility(View.GONE);
            mBinding.llMainExceptionalTwoHandEthereal15.setVisibility(View.GONE);

            mBinding.llMainEliteTwoHand.setVisibility(View.GONE);
            mBinding.llMainEliteTwoHand15.setVisibility(View.GONE);
            mBinding.llMainEliteTwoHandEthereal.setVisibility(View.GONE);
            mBinding.llMainEliteTwoHandEthereal15.setVisibility(View.GONE);

        }
    }

    private void powerEliteCalculate(String attackPower1, String attackPower2,
                                     TextView OneHandPower,
                                     TextView OneHandPower15,
                                     TextView OneHandPowerEthereal,
                                     TextView OneHandPowerEthereal15,
                                     TextView TwhHandPower,
                                     TextView TwoHandPower15,
                                     TextView TwoHandEthereal,
                                     TextView TwoHandEthereal15) {
        elitePower(
                attackPower1,
                attackPower2,
                OneHandPower,
                OneHandPower15,
                OneHandPowerEthereal,
                OneHandPowerEthereal15,
                TwhHandPower,
                TwoHandPower15,
                TwoHandEthereal,
                TwoHandEthereal15);
    }

    private void elitePower(
            String attackPower1,
            String attackPower2,
            TextView oneHandPower,
            TextView oneHandPower15,
            TextView oneHandPowerEthereal,
            TextView oneHandPowerEthereal15,
            TextView twoHandPower,
            TextView twoHandPower15,
            TextView twoHandPowerEthereal,
            TextView twoHandPowerEthereal15
    ) {

        // 원핸드 파워 로직
        String[] attack1 = attackPower1.split("-");
        double attack_01 = Double.parseDouble(attack1[0].trim());
        double attack_02 = Double.parseDouble(attack1[1].trim());

        // 한손 일반 상태의 한손 데미지
        int minOneHand = Integer.parseInt(attack1[0]);
        int maxOneHand = Integer.parseInt(attack1[1]);
        oneHandPower.setText(minOneHand + " - " + maxOneHand);

//        int minDefense = (int) attack_01 + 1;
//        int maxDefense = (int) attack_02 + 1;

        // 한손  일반 상태에서의 15% 맥뎀
        int result1 = (int) (minOneHand * 1.15);
        int result2 = (int) (maxOneHand * 1.15);
        oneHandPower15.setText(result1 + " - " + result2);

        // 한손  에테리얼 원핸드
        int etherealMinAttackPower = (int) ((int) attack_01 * 1.5);
        int etherealMaxAttackPower = (int) ((int) attack_02 * 1.5);
        oneHandPowerEthereal.setText(etherealMinAttackPower + " - " + etherealMaxAttackPower);

        // 한손  에테리얼 원핸드 15% 맥뎀
        int result3 = (int) (etherealMinAttackPower * 1.15);
        int result4 = (int) (etherealMaxAttackPower * 1.15);
        oneHandPowerEthereal15.setText(result3 + " - " + result4);

        mBinding.llMainNormalTwoHand.setVisibility(View.GONE);
        mBinding.llMainNormalTwoHand15.setVisibility(View.GONE);
        mBinding.llMainNormalTwoHandEthereal.setVisibility(View.GONE);
        mBinding.llMainNormalTwoHandEthereal15.setVisibility(View.GONE);

        // 이 밑으로는 양손 데미지
        if (attackPower2 != null && !attackPower2.equals("0")) {
            String[] attack2 = attackPower2.split("-");
            double minTwoHand = Double.parseDouble(attack2[0].trim()); // 최소 방어력
            double maxTwoHand = Double.parseDouble(attack2[1].trim()); // 최대 방어력

            int minTwoHand1 = Integer.parseInt(attack2[0]);
            int maxTwoHand2 = Integer.parseInt(attack2[1]);
            twoHandPower.setText(minTwoHand1 + " - " + maxTwoHand2);

            int minAttack = (int) minTwoHand + 1;
            int maxAttack = (int) maxTwoHand + 1;

            // 양손 일반 상태에서의 15% 맥뎀
            int result01 = (int) (minTwoHand1 * 1.15);
            int result02 = (int) (maxTwoHand2 * 1.15);
            twoHandPower15.setText(result01 + " - " + result02);

            // 양손 에테리얼 원핸드
            int twoHandEtherealMinAttackPower = (int) ((int) minTwoHand1 * 1.5);
            int twoHandEtherealMaxAttackPower = (int) ((int) maxTwoHand2 * 1.5);
            twoHandPowerEthereal.setText(twoHandEtherealMinAttackPower + " - " + twoHandEtherealMaxAttackPower);

            // 양손 에테리얼 원핸드 15% 맥뎀
            int result03 = (int) (twoHandEtherealMinAttackPower * 1.15);
            int result04 = (int) (twoHandEtherealMaxAttackPower * 1.15);
            twoHandPowerEthereal15.setText(result03 + " - " + result04);

            mBinding.llMainNormalTwoHand.setVisibility(View.VISIBLE);
            mBinding.llMainNormalTwoHand15.setVisibility(View.VISIBLE);
            mBinding.llMainNormalTwoHandEthereal.setVisibility(View.VISIBLE);
            mBinding.llMainNormalTwoHandEthereal15.setVisibility(View.VISIBLE);

        } else {
            mBinding.llMainNormalTwoHand.setVisibility(View.GONE);
            mBinding.llMainNormalTwoHand15.setVisibility(View.GONE);
            mBinding.llMainNormalTwoHandEthereal.setVisibility(View.GONE);
            mBinding.llMainNormalTwoHandEthereal15.setVisibility(View.GONE);

            mBinding.llMainExceptionalTwoHand.setVisibility(View.GONE);
            mBinding.llMainExceptionalTwoHand15.setVisibility(View.GONE);
            mBinding.llMainExceptionalTwoHandEthereal.setVisibility(View.GONE);
            mBinding.llMainExceptionalTwoHandEthereal15.setVisibility(View.GONE);

            mBinding.llMainEliteTwoHand.setVisibility(View.GONE);
            mBinding.llMainEliteTwoHand15.setVisibility(View.GONE);
            mBinding.llMainEliteTwoHandEthereal.setVisibility(View.GONE);
            mBinding.llMainEliteTwoHandEthereal15.setVisibility(View.GONE);

        }
    }


}