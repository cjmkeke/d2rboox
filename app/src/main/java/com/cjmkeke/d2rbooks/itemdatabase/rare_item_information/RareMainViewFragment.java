package com.cjmkeke.d2rbooks.itemdatabase.rare_item_information;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentRareMainViewBinding;
import com.cjmkeke.d2rbooks.itemdatabase.CustomSpinnerAdapter;

public class RareMainViewFragment extends Fragment {

    private static final String TAG = "SPFixOptionsDatabase";
    private SharedPreferences fontSharedPreferences;
    private FragmentRareMainViewBinding mBinding;
    private final String[] ITEMS = new String[]{"레어 아뮬렛", "레어 링", "레어 헬맷", "레어 무기", "레어 장갑", "레어 부츠", "레어 쥬얼"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentRareMainViewBinding.inflate(inflater, container, false);

        int[] images = {
                R.drawable.amulet,
                R.drawable.ring,
                R.drawable.safety_helmet,
                R.drawable.soser_weapon2,
                R.drawable.gloves2,
                R.drawable.boots4,
                R.drawable.jewel};

        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(getContext(), ITEMS, images);
        mBinding.spinnerSpfix.setAdapter(adapter);
        mBinding.spinnerSpfix.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Fragment selectedFragment = null;

                if (selectedItem.equals(ITEMS[0])) { // "아뮬렛"
                    selectedFragment = new AmuletOptionsDatabase();
                } else if (selectedItem.equals(ITEMS[1])) { // "링"
                    selectedFragment = new RingOptionsDatabase();
                } else if (selectedItem.equals(ITEMS[2])) { // "헬맷"
                    selectedFragment = new HelmetOptionsDatabase();
                } else if (selectedItem.equals(ITEMS[3])) { // "무기"
                    selectedFragment = new WeaponsOptionsDatabase();
                } else if (selectedItem.equals(ITEMS[4])) { // "장갑"
                    selectedFragment = new GloveOptionsDatabase();
                } else if (selectedItem.equals(ITEMS[5])) { // "장갑"
                    selectedFragment = new BootsOptionsDatabase();
                } else if (selectedItem.equals(ITEMS[6])) { // "장갑"
                    selectedFragment = new JewelOptionsDatabase();
                }

                if (selectedFragment != null) {
                    // 프래그먼트 트랜잭션 수행
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.replace_spx, selectedFragment) // R.id.fragment_container는 프래그먼트를 담을 컨테이너 ID입니다.
                            .addToBackStack(null) // 백스택 추가 (뒤로가기 기능을 위해)
                            .commit();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return mBinding.getRoot();
    }
}