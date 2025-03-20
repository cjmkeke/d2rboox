package com.cjmkeke.d2rbooks.chardatabase;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.amazon.Bow;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.amazon.Javelin;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.amazon.Passive;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentAmazonDatabaseBinding;

public class AmazonDatabase extends Fragment {

    private static final String TAG = "AmazonDatabase";
    private FragmentAmazonDatabaseBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    private boolean isTabButtonDefense = false;
    private boolean isTabButtonAttack = false;
    private boolean isTabButtonBattle = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentAmazonDatabaseBinding.inflate(inflater, container, false);

        int resIdSelect = getResources().getIdentifier("dw_act_select", "drawable", getContext().getPackageName());
        int resIdNoneSelect = getResources().getIdentifier("dw_button", "drawable", getContext().getPackageName());

        Fragment fragment = null;
        if (fragment == null) {
            replaceFragment(new Javelin());
        }

        mBinding.tvAmazoneTabJavelin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isTabButtonDefense) {
                    mBinding.tvAmazoneTabJavelin.setBackgroundResource(resIdSelect);
                    mBinding.tvAmazoneTabBow.setBackgroundResource(resIdNoneSelect);
                    mBinding.tvAmazoneTabPassive.setBackgroundResource(resIdNoneSelect);
                    isTabButtonDefense = false;
                }


                replaceFragment(new Javelin());
            }
        });

        mBinding.tvAmazoneTabPassive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isTabButtonAttack) {
                    mBinding.tvAmazoneTabPassive.setBackgroundResource(resIdSelect);
                    mBinding.tvAmazoneTabBow.setBackgroundResource(resIdNoneSelect);
                    mBinding.tvAmazoneTabJavelin.setBackgroundResource(resIdNoneSelect);
                    isTabButtonAttack = false;
                }

                replaceFragment(new Passive());
            }
        });

        mBinding.tvAmazoneTabBow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTabButtonBattle) {
                    mBinding.tvAmazoneTabBow.setBackgroundResource(resIdSelect);
                    mBinding.tvAmazoneTabPassive.setBackgroundResource(resIdNoneSelect);
                    mBinding.tvAmazoneTabJavelin.setBackgroundResource(resIdNoneSelect);
                    isTabButtonBattle = false;
                }
                replaceFragment(new Bow());
            }
        });

        return mBinding.getRoot();

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_skill_change, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();  // 상태 손실이 허용된 커밋 사용
    }
}
