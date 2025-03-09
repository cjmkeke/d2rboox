package com.cjmkeke.d2rbooks;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivityItemDatabaseDrawerLayoutBinding;
import com.cjmkeke.d2rbooks.itemdatabase.ArmorItemDatabase;
import com.cjmkeke.d2rbooks.itemdatabase.CraftItemCombinationDatabase;
import com.cjmkeke.d2rbooks.itemdatabase.HelmItemDatabase;
import com.cjmkeke.d2rbooks.itemdatabase.HoradricCubeDatabase;
import com.cjmkeke.d2rbooks.itemdatabase.SetItemDatabase;
import com.cjmkeke.d2rbooks.itemdatabase.ShieldItemDatabase;
import com.cjmkeke.d2rbooks.itemdatabase.UniqueItemDatabase;
import com.cjmkeke.d2rbooks.itemdatabase.WeaponItemDatabase;
import com.cjmkeke.d2rbooks.itemdatabase.information.MapTcDatabase;
import com.cjmkeke.d2rbooks.itemdatabase.information.TerrorZone;
import com.cjmkeke.d2rbooks.itemdatabase.information.Uber;
import com.cjmkeke.d2rbooks.itemdatabase.magic_item_information.MagicMainViewFragment;
import com.cjmkeke.d2rbooks.itemdatabase.rare_item_information.AmuletOptionsDatabase;
import com.cjmkeke.d2rbooks.itemdatabase.rare_item_information.RareMainViewFragment;
import com.cjmkeke.d2rbooks.itemdatabase.rare_item_information.RingOptionsDatabase;

public class ItemDatabaseDrawerLayout extends AppCompatActivity {

    private final String TAG = "ItemDatabaseDrawerLayout";
    private ActivityItemDatabaseDrawerLayoutBinding mBinding;
    private SharedPreferences fontSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fontSharedPreferences = getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);

        mBinding = ActivityItemDatabaseDrawerLayoutBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        SharedPreferences sharedPreferences = getSharedPreferences("app_settings_preferences", MODE_PRIVATE);
        boolean isShow = sharedPreferences.getBoolean("a", true);

        if (isShow) {
            mBinding.tvHoradricCubeCubing.setVisibility(View.GONE);
        } else {
            mBinding.tvHoradricCubeCubing.setVisibility(View.VISIBLE);
        }

        mBinding.tvOpenDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mBinding.drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    mBinding.drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        mBinding.tvMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new CraftItemCombinationDatabase());
                mBinding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        mBinding.tvHoradricCubeCubing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new HoradricCubeDatabase());
                mBinding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        mBinding.tvRareSpfix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new RareMainViewFragment());
                mBinding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        mBinding.tvMagicSpfix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new MagicMainViewFragment());
                mBinding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        mBinding.tvOptionsAmulet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new AmuletOptionsDatabase());
                mBinding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        mBinding.tvOptionsRing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new RingOptionsDatabase());
                mBinding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        mBinding.tvArmorMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new ArmorItemDatabase());
                mBinding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        mBinding.tvHelm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new HelmItemDatabase());
                mBinding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        mBinding.tvShield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new ShieldItemDatabase());
                mBinding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        mBinding.tvWeapons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new WeaponItemDatabase());
                mBinding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });


        mBinding.tvUnique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new UniqueItemDatabase());
                mBinding.drawerLayout.closeDrawer(GravityCompat.START);

            }
        });

        mBinding.tvSetItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new SetItemDatabase());
                mBinding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        mBinding.tvTerrorZone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new TerrorZone());
                mBinding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        mBinding.tvUberDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new Uber());
                mBinding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        mBinding.tvMapTc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new MapTcDatabase());
                mBinding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        mBinding.tvBackHandleActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 백 스택의 모든 프래그먼트 제거
                FragmentManager fragmentManager = getSupportFragmentManager();
                while (fragmentManager.getBackStackEntryCount() > 0) {
                    fragmentManager.popBackStackImmediate();
                }
                finish(); // 현재 액티비티 종료
            }
        });
    }

    // FrameLayout에 Fragment를 교체하는 함수
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_main, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();  // 상태 손실이 허용된 커밋 사용
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(TAG, "onDestroy");
    }
}
