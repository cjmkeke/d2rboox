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
import com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.barbarian.BarbarianCombat;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.barbarian.Masteries;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.barbarian.Warcries;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentBarbarianDatabaseBinding;

public class BarbarianDatabase extends Fragment {

    private static final String TAG = "BarbarianDatabase";
    private FragmentBarbarianDatabaseBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    private boolean isTabButton1 = false;
    private boolean isTabButton2 = false;
    private boolean isTabButton3 = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentBarbarianDatabaseBinding.inflate(inflater, container, false);

        int resIdSelect = getResources().getIdentifier("dw_act_select", "drawable", getContext().getPackageName());
        int resIdNoneSelect = getResources().getIdentifier("dw_button", "drawable", getContext().getPackageName());

        Fragment fragment = null;
        if (fragment == null) {
            replaceFragment(new Warcries());
        }

        mBinding.tvBarbarianTab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isTabButton1) {
                    mBinding.tvBarbarianTab1.setBackgroundResource(resIdSelect);
                    mBinding.tvBarbarianTab2.setBackgroundResource(resIdNoneSelect);
                    mBinding.tvBarbarianTab3.setBackgroundResource(resIdNoneSelect);
                    isTabButton1 = false;
                }


                replaceFragment(new Warcries());
            }
        });

        mBinding.tvBarbarianTab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTabButton3) {
                    mBinding.tvBarbarianTab2.setBackgroundResource(resIdSelect);
                    mBinding.tvBarbarianTab3.setBackgroundResource(resIdNoneSelect);
                    mBinding.tvBarbarianTab1.setBackgroundResource(resIdNoneSelect);
                    isTabButton3 = false;
                }
                replaceFragment(new Masteries());
            }
        });

        mBinding.tvBarbarianTab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isTabButton2) {
                    mBinding.tvBarbarianTab3.setBackgroundResource(resIdSelect);
                    mBinding.tvBarbarianTab2.setBackgroundResource(resIdNoneSelect);
                    mBinding.tvBarbarianTab1.setBackgroundResource(resIdNoneSelect);
                    isTabButton2 = false;
                }

                replaceFragment(new BarbarianCombat());
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
