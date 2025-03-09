package com.cjmkeke.d2rbooks.chardatabase.write;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.cjmkeke.d2rbooks.databinding.ActivitySkillBinding;

public class Skill extends AppCompatActivity {

    private static final String TAG = "Skill";
    private ActivitySkillBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivitySkillBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());


//        mBinding.tvS.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                int resId = getResources().getIdentifier("skill_pala_1", "drawable", getPackageName());
//                mBinding.tvS.setBackgroundResource(resId);
//
//            }
//        });
//
//
//        mBinding.tvA.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                int resId = getResources().getIdentifier("skill_pala_1", "drawable", getPackageName());
//                mBinding.tvA.setBackgroundResource(resId);
//
//            }
//        });

    }
}