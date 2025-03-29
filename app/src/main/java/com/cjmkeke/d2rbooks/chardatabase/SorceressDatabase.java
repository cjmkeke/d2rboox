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
import com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.sorceress.Cold;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.sorceress.Fire;
import com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.sorceress.Lightning;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentSorceressDatabaseBinding;

public class SorceressDatabase extends Fragment {

    private static final String TAG = "SorceressDatabase";
    private FragmentSorceressDatabaseBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    private boolean isTabButton1 = false;
    private boolean isTabButton2 = false;
    private boolean isTabButton3 = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentSorceressDatabaseBinding.inflate(inflater, container, false);

        int resIdSelect = getResources().getIdentifier("dw_act_select", "drawable", getContext().getPackageName());
        int resIdNoneSelect = getResources().getIdentifier("dw_button", "drawable", getContext().getPackageName());

        Fragment fragment = null;
        if (fragment == null) {
            replaceFragment(new Cold());
        }

        mBinding.tvSorceressTab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isTabButton1) {
                    mBinding.tvSorceressTab1.setBackgroundResource(resIdSelect);
                    mBinding.tvSorceressTab2.setBackgroundResource(resIdNoneSelect);
                    mBinding.tvSorceressTab3.setBackgroundResource(resIdNoneSelect);
                    isTabButton1 = false;
                }


                replaceFragment(new Cold());
            }
        });

        mBinding.tvSorceressTab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTabButton3) {
                    mBinding.tvSorceressTab2.setBackgroundResource(resIdSelect);
                    mBinding.tvSorceressTab3.setBackgroundResource(resIdNoneSelect);
                    mBinding.tvSorceressTab1.setBackgroundResource(resIdNoneSelect);
                    isTabButton3 = false;
                }
                replaceFragment(new Lightning());
            }
        });

        mBinding.tvSorceressTab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isTabButton2) {
                    mBinding.tvSorceressTab3.setBackgroundResource(resIdSelect);
                    mBinding.tvSorceressTab2.setBackgroundResource(resIdNoneSelect);
                    mBinding.tvSorceressTab1.setBackgroundResource(resIdNoneSelect);
                    isTabButton2 = false;
                }

                replaceFragment(new Fire());
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
