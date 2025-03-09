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
import com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.assassin.Martial;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.assassin.Shadow;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.assassin.Traps;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentAssassinDatabaseBinding;

public class AssassinDatabase extends Fragment {

    private static final String TAG = "AssassinDatabase";
    private FragmentAssassinDatabaseBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    private boolean isTabButtonDefense = false;
    private boolean isTabButtonAttack = false;
    private boolean isTabButtonBattle = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentAssassinDatabaseBinding.inflate(inflater, container, false);

        int resIdSelect = getResources().getIdentifier("dw_act_select", "drawable", getContext().getPackageName());
        int resIdNoneSelect = getResources().getIdentifier("dw_button", "drawable", getContext().getPackageName());

        Fragment fragment = null;
        if (fragment == null) {
            replaceFragment(new Martial());
        }

        mBinding.tvAssassinTabMartial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isTabButtonDefense){
                    mBinding.tvAssassinTabMartial.setBackgroundResource(resIdSelect);
                    mBinding.tvAssassinTabShadow.setBackgroundResource(resIdNoneSelect);
                    mBinding.tvAssassinTabTraps.setBackgroundResource(resIdNoneSelect);
                    isTabButtonDefense = false;
                }


                replaceFragment(new Martial());
            }
        });

        mBinding.tvAssassinTabShadow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isTabButtonAttack){
                    mBinding.tvAssassinTabShadow.setBackgroundResource(resIdSelect);
                    mBinding.tvAssassinTabTraps.setBackgroundResource(resIdNoneSelect);
                    mBinding.tvAssassinTabMartial.setBackgroundResource(resIdNoneSelect);
                    isTabButtonAttack = false;
                }

                replaceFragment(new Shadow());
            }
        });

        mBinding.tvAssassinTabTraps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTabButtonBattle){
                    mBinding.tvAssassinTabTraps.setBackgroundResource(resIdSelect);
                    mBinding.tvAssassinTabShadow.setBackgroundResource(resIdNoneSelect);
                    mBinding.tvAssassinTabMartial.setBackgroundResource(resIdNoneSelect);
                    isTabButtonBattle = false;
                }
                replaceFragment(new Traps());
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
