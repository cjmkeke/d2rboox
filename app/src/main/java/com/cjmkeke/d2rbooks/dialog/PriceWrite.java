package com.cjmkeke.d2rbooks.dialog;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivityPriceWriteBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PriceWrite extends AppCompatActivity {

    private static final String TAG = "PriceWrite";
    private ActivityPriceWriteBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private String server = "ladder";
    private String runeName = "jah";
    private String lastKey = "";
    private boolean jah = true;
    private boolean ber;
    private boolean ladder = true;
    private boolean standard;

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

        mBinding = ActivityPriceWriteBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        firebaseDatabase = FirebaseDatabase.getInstance();

        mBinding.cbPriceLadder.setChecked(true);
        mBinding.cbPriceJah.setChecked(true);
        mBinding.cbPriceLadder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ladder = true;
                    standard = false;
                    mBinding.cbPriceStandard.setChecked(false);
                    server = "ladder";
                }
            }
        });

        mBinding.cbPriceStandard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    standard = true;
                    ladder = false;
                    mBinding.cbPriceLadder.setChecked(false);
                    server = "standard";
                }
            }
        });

        mBinding.cbPriceBer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    runeName = "ber";
                    ber = true;
                    jah = false;
                    mBinding.cbPriceJah.setChecked(false);
                    Log.w(TAG, runeName);
                }
            }
        });

        mBinding.cbPriceJah.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ber = false;
                    jah = true;
                    runeName = "jah";
                    mBinding.cbPriceBer.setChecked(false);
                    Log.w(TAG, runeName);
                }
            }
        });

        DatabaseReference databaseReference1 = firebaseDatabase.getReference("price").child("rune").child(server).child(runeName);
        databaseReference1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String[] keysArr = new String[(int) snapshot.getChildrenCount()]; // 키 배열 생성
                int index = 0;
             // 키들을 배열에 저장
                for (DataSnapshot data : snapshot.getChildren()) {
                    keysArr[index++] = data.getKey();
                }
                if (keysArr.length > 0) {
                    lastKey = keysArr[keysArr.length - 1];
                    mBinding.etYear.setText(lastKey);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mBinding.tvPriceConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ber && !jah) {
                    Toast.makeText(PriceWrite.this, "룬을 선택해주세요.", Toast.LENGTH_SHORT).show();
                } else if (!ladder && !standard) {
                    Toast.makeText(PriceWrite.this, "서버를 선택해주세요.", Toast.LENGTH_SHORT).show();
                } else if (!TextUtils.isEmpty(mBinding.etPrice.getText().toString()) && !TextUtils.isEmpty(mBinding.etYear.getText().toString())) {
                    String year = mBinding.etYear.getText().toString();
                    String day = mBinding.etDay.getText().toString();
                    int value = Integer.parseInt(mBinding.etPrice.getText().toString());
                    databaseReference = firebaseDatabase.getReference("price").child("rune").child(server).child(runeName).child(year).child(day);
                    databaseReference.setValue(value);
                }
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