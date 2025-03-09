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

import androidx.annotation.NonNull;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivityShowRuneBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShowRune extends Activity {

    private ActivityShowRuneBinding mBinding;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String runeValue;
    private SharedPreferences fontSharedPreferences;

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

        mBinding = ActivityShowRuneBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        Intent intent = getIntent();
        runeValue = intent.getStringExtra("el");

        if (intent.getStringExtra("el") != null) {
            runeValue = intent.getStringExtra("el");
        } else if (intent.getStringExtra("eld") != null) {
            runeValue = intent.getStringExtra("eld");
        } else if (intent.getStringExtra("tir") != null) {
            runeValue = intent.getStringExtra("tir");
        } else if (intent.getStringExtra("nef") != null) {
            runeValue = intent.getStringExtra("nef");
        } else if (intent.getStringExtra("eth") != null) {
            runeValue = intent.getStringExtra("eth");
        } else if (intent.getStringExtra("ith") != null) {
            runeValue = intent.getStringExtra("ith");
        } else if (intent.getStringExtra("tal") != null) {
            runeValue = intent.getStringExtra("tal");
        } else if (intent.getStringExtra("ral") != null) {
            runeValue = intent.getStringExtra("ral");
        } else if (intent.getStringExtra("ort") != null) {
            runeValue = intent.getStringExtra("ort");
        } else if (intent.getStringExtra("thul") != null) {
            runeValue = intent.getStringExtra("thul");
        } else if (intent.getStringExtra("amn") != null) {
            runeValue = intent.getStringExtra("amn");
        } else if (intent.getStringExtra("sol") != null) {
            runeValue = intent.getStringExtra("sol");
        } else if (intent.getStringExtra("shael") != null) {
            runeValue = intent.getStringExtra("shael");
        } else if (intent.getStringExtra("dol") != null) {
            runeValue = intent.getStringExtra("dol");
        } else if (intent.getStringExtra("hel") != null) {
            runeValue = intent.getStringExtra("hel");
        } else if (intent.getStringExtra("io") != null) {
            runeValue = intent.getStringExtra("io");
        } else if (intent.getStringExtra("lum") != null) {
            runeValue = intent.getStringExtra("lum");
        } else if (intent.getStringExtra("ko") != null) {
            runeValue = intent.getStringExtra("ko");
        } else if (intent.getStringExtra("fal") != null) {
            runeValue = intent.getStringExtra("fal");
        } else if (intent.getStringExtra("lem") != null) {
            runeValue = intent.getStringExtra("lem");
        } else if (intent.getStringExtra("pul") != null) {
            runeValue = intent.getStringExtra("pul");
        } else if (intent.getStringExtra("um") != null) {
            runeValue = intent.getStringExtra("um");
        } else if (intent.getStringExtra("mal") != null) {
            runeValue = intent.getStringExtra("mal");
        } else if (intent.getStringExtra("ist") != null) {
            runeValue = intent.getStringExtra("ist");
        } else if (intent.getStringExtra("gul") != null) {
            runeValue = intent.getStringExtra("gul");
        } else if (intent.getStringExtra("vex") != null) {
            runeValue = intent.getStringExtra("vex");
        } else if (intent.getStringExtra("ohm") != null) {
            runeValue = intent.getStringExtra("ohm");
        } else if (intent.getStringExtra("lo") != null) {
            runeValue = intent.getStringExtra("lo");
        } else if (intent.getStringExtra("sur") != null) {
            runeValue = intent.getStringExtra("sur");
        } else if (intent.getStringExtra("ber") != null) {
            runeValue = intent.getStringExtra("ber");
        } else if (intent.getStringExtra("jah") != null) {
            runeValue = intent.getStringExtra("jah");
        } else if (intent.getStringExtra("cham") != null) {
            runeValue = intent.getStringExtra("cham");
        } else if (intent.getStringExtra("zod") != null) {
            runeValue = intent.getStringExtra("zod");
        }

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("rune");
        databaseReference.child(runeValue).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String name = snapshot.child("name").getValue(String.class);

//                // 비교할 대상의 룬 이름들
//                String[] runeEngName = {"El", "Eld", "Tir", "Nef", "Eth", "Ith", "Tal", "Ral", "Ort", "Thul", "Amn", "Sol", "Shael", "Dol", "Hel",
//                        "Io,", "Lum", "Ko", "Fal", "Lem", "Pul", "Um", "Mal", "Ist", "Gul", "Vex", "Ohm", "Lo", "Sur", "Ber", "Jah", "Cham", "Zod"};

                String[] itemNames;


                itemNames = name.split("\\[");
                if (itemNames.length >= 0) {
                    int resourceId = getResources().getIdentifier(itemNames[0].toLowerCase().trim(), "drawable", getPackageName());
                    mBinding.ivImg.setBackgroundResource(resourceId);
                    mBinding.tvName.setText(snapshot.child("name").getValue(String.class));
                }

                mBinding.tvLevel.setText(snapshot.child("level").getValue(String.class) + " 레벨");
                mBinding.tvUpgrade.setText(snapshot.child("upgrades").getValue(String.class));

                String str = snapshot.child("weapon").getValue(String.class);
                String str1 = str.replace(",", "\n");
                mBinding.tvWeapons.setText(str1);

                String str2 = snapshot.child("armor").getValue(String.class);
                String str3 = str2.replace(",", "\n");
                mBinding.tvArmor.setText(str3);

                String upgrade = snapshot.child("upgrades").getValue(String.class);
                String upgradeFinal = snapshot.child("upgrades_final").getValue(String.class);

                if ("".equals(upgrade)) {
                    mBinding.tvM.setVisibility(View.GONE);
                }

                if (upgradeFinal != null && !upgradeFinal.isEmpty()) {
                    mBinding.ivUpgradeFinal.setVisibility(View.VISIBLE);
                    int resId = getResources().getIdentifier(upgradeFinal.toLowerCase(), "drawable", getPackageName());
                    if (resId != 0) {
                        mBinding.ivUpgradeFinal.setImageResource(resId); // 해당 리소스를 설정
                    }
                } else {
                    mBinding.ivUpgradeFinal.setVisibility(View.GONE);
                }

                if (upgrade != null && !upgrade.isEmpty()) {
                    // 문자열을 콤마로 분리하여 배열로 변환
                    String[] upgrades = upgrade.split(",");

                    // 첫 번째 업그레이드
                    if (upgrades.length >= 1) {
                        mBinding.ivUpgrade1.setVisibility(View.VISIBLE);
                        // 리소스 이름을 문자열로 찾기
                        int resId = getResources().getIdentifier(upgrades[0].trim().toLowerCase(), "drawable", getPackageName());
                        if (resId != 0) {
                            mBinding.ivUpgrade1.setImageResource(resId); // 해당 리소스를 설정
                        }
                    }

                    // 두 번째 업그레이드
                    if (upgrades.length >= 2) {
                        mBinding.ivUpgrade2.setVisibility(View.VISIBLE);
                        // 리소스 이름을 문자열로 찾기
                        int resId = getResources().getIdentifier(upgrades[1].trim().toLowerCase(), "drawable", getPackageName());
                        if (resId != 0) {
                            mBinding.ivUpgrade2.setImageResource(resId); // 해당 리소스를 설정
                        }
                    }

                    // 세 번째 업그레이드
                    if (upgrades.length >= 3) {
                        mBinding.ivUpgrade3.setVisibility(View.VISIBLE);
                        // 리소스 이름을 문자열로 찾기
                        int resId = getResources().getIdentifier(upgrades[2].trim().toLowerCase(), "drawable", getPackageName());
                        if (resId != 0) {
                            mBinding.ivUpgrade3.setImageResource(resId); // 해당 리소스를 설정
                        }
                    }
                    // 네 번째 업그레이드
                    if (upgrades.length >= 4) {
                        mBinding.ivUpgrade4.setVisibility(View.VISIBLE);
                        // 리소스 이름을 문자열로 찾기
                        int resId = getResources().getIdentifier(upgrades[3].trim().toLowerCase(), "drawable", getPackageName());
                        if (resId != 0) {
                            mBinding.ivUpgrade4.setImageResource(resId); // 해당 리소스를 설정
                        }
                    }

                } else {
                    // 업그레이드가 없으면 모든 업그레이드 ImageView를 숨김
                    mBinding.ivUpgrade1.setVisibility(View.GONE);
                    mBinding.ivUpgrade2.setVisibility(View.GONE);
                    mBinding.ivUpgrade3.setVisibility(View.GONE);
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
}
