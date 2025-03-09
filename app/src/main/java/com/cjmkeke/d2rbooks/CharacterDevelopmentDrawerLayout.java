package com.cjmkeke.d2rbooks;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cjmkeke.d2rbooks.chardatabase.AmazonDatabase;
import com.cjmkeke.d2rbooks.chardatabase.AssassinDatabase;
import com.cjmkeke.d2rbooks.chardatabase.BarbarianDatabase;
import com.cjmkeke.d2rbooks.chardatabase.DruidDatabase;
import com.cjmkeke.d2rbooks.chardatabase.NecromancerDatabase;
import com.cjmkeke.d2rbooks.chardatabase.PaladinsDatabase;
import com.cjmkeke.d2rbooks.chardatabase.SorceressDatabase;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivityCharacterDevelopmentDrawerLayoutBinding;

public class CharacterDevelopmentDrawerLayout extends AppCompatActivity {

    private ActivityCharacterDevelopmentDrawerLayoutBinding mBinding;
    private SharedPreferences fontSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("CharacterDevelopmentDrawerLayout");

        fontSharedPreferences = getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);

        mBinding = ActivityCharacterDevelopmentDrawerLayoutBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        Fragment fragment = null;
        if (fragment == null) {
            replaceFragment(new PaladinsDatabase());
        }

        setOnClickIntent(mBinding.ivAmazon, mBinding.tvCharName, "아마존", new AmazonDatabase());
        setOnClickIntent(mBinding.ivAssassin, mBinding.tvCharName, "암살자", new AssassinDatabase());
        setOnClickIntent(mBinding.ivNecromancer, mBinding.tvCharName, "강령술사", new NecromancerDatabase());
        setOnClickIntent(mBinding.ivBabarian, mBinding.tvCharName, "야만용사", new BarbarianDatabase());
        setOnClickIntent(mBinding.ivPaladins, mBinding.tvCharName, "성기사", new PaladinsDatabase());
        setOnClickIntent(mBinding.ivSorceress, mBinding.tvCharName, "원소술사", new SorceressDatabase());
        setOnClickIntent(mBinding.ivDruid, mBinding.tvCharName, "드루이드", new DruidDatabase());

    }

    private void setOnClickIntent(ImageView targetCharacter, TextView showTextCharacter, String characterName, Fragment fragment) {
        targetCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTextCharacter.setText(characterName);
                replaceFragment(fragment);
            }
        });
    }

    // FrameLayout에 Fragment를 교체하는 함수
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_char_main, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();  // 상태 손실이 허용된 커밋 사용
    }


}