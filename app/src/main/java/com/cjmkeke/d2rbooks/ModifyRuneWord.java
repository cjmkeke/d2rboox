package com.cjmkeke.d2rbooks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivityModifyRuneWordBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.suke.widget.SwitchButton;

public class ModifyRuneWord extends AppCompatActivity {

    private ActivityModifyRuneWordBinding mBinding;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
//    private String search;
//    private String runeName;
    private String runeName;
    private String originalRuneName;
    private boolean amazon;
    private boolean assassin;
    private boolean necromancer;
    private boolean paladins;
    private boolean mercenary;
    private boolean ladder;
    private boolean early;
    private boolean druid;
    private boolean specialItem;
    private boolean sorceress;
    private boolean barbarian;
    private boolean all;
    private String rune1, rune2, rune3, rune4, rune5, rune6;
    private SharedPreferences fontSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fontSharedPreferences = getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);

        mBinding = ActivityModifyRuneWordBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        Intent intent = getIntent();
        runeName = intent.getStringExtra("runeName");

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("runeword");
        mBinding.etSearch.setText(runeName);
        
        mBinding.tvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = mBinding.etSearch.getText().toString();
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (str != null) {
                            if (snapshot.child(str).exists()) {
                                String runeWordName = snapshot.child(str).child("itemName").getValue(String.class);
                                mBinding.tvRunewordName.setText(runeWordName + " 룬워드를 수정중입니다.");

                                amazon = snapshot.child(str).child("amazon").getValue(Boolean.class);
                                assassin = snapshot.child(str).child("assassin").getValue(Boolean.class);
                                necromancer = snapshot.child(str).child("necromancer").getValue(Boolean.class);
                                paladins = snapshot.child(str).child("paladins").getValue(Boolean.class);
                                mercenary = snapshot.child(str).child("mercenary").getValue(Boolean.class);
                                ladder = snapshot.child(str).child("ladder").getValue(Boolean.class);
                                early = snapshot.child(str).child("early").getValue(Boolean.class);
                                druid = snapshot.child(str).child("druid").getValue(Boolean.class);
                                specialItem = snapshot.child(str).child("specialItem").getValue(Boolean.class);
                                sorceress = snapshot.child(str).child("sorceress").getValue(Boolean.class);
                                barbarian = snapshot.child(str).child("barbarian").getValue(Boolean.class);
                                all = snapshot.child(str).child("all").getValue(Boolean.class);
                                rune1 = snapshot.child(str).child("rune1").getValue(String.class);
                                rune2 = snapshot.child(str).child("rune2").getValue(String.class);
                                rune3 = snapshot.child(str).child("rune3").getValue(String.class);
                                rune4 = snapshot.child(str).child("rune4").getValue(String.class);
                                rune5 = snapshot.child(str).child("rune5").getValue(String.class);
                                rune6 = snapshot.child(str).child("rune6").getValue(String.class);

                                mBinding.swAmazon.setChecked(amazon);
                                mBinding.swAssassin.setChecked(assassin);
                                mBinding.swNecromancer.setChecked(necromancer);
                                mBinding.swPaladins.setChecked(paladins);
                                mBinding.swMercenary.setChecked(mercenary);
                                mBinding.swLadder.setChecked(ladder);
                                mBinding.swEarly.setChecked(early);
                                mBinding.swDruid.setChecked(druid);
                                mBinding.swSpecialItem.setChecked(specialItem);
                                mBinding.swSorceress.setChecked(sorceress);
                                mBinding.swBarbarian.setChecked(barbarian);
                                mBinding.swAll.setChecked(all);

                                mBinding.etRune1.setText(rune1);
                                mBinding.etRune2.setText(rune2);
                                mBinding.etRune3.setText(rune3);
                                mBinding.etRune4.setText(rune4);
                                mBinding.etRune5.setText(rune5);
                                mBinding.etRune6.setText(rune6);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (runeName != null) {
                    if (snapshot.child(runeName).exists()) {
                        String runeWordName = snapshot.child(runeName).child("itemName").getValue(String.class);
                        mBinding.tvRunewordName.setText(runeWordName + " 룬워드를 수정중입니다.");

                        amazon = snapshot.child(runeName).child("amazon").getValue(Boolean.class);
                        assassin = snapshot.child(runeName).child("assassin").getValue(Boolean.class);
                        necromancer = snapshot.child(runeName).child("necromancer").getValue(Boolean.class);
                        paladins = snapshot.child(runeName).child("paladins").getValue(Boolean.class);
                        mercenary = snapshot.child(runeName).child("mercenary").getValue(Boolean.class);
                        ladder = snapshot.child(runeName).child("ladder").getValue(Boolean.class);
                        early = snapshot.child(runeName).child("early").getValue(Boolean.class);
                        druid = snapshot.child(runeName).child("druid").getValue(Boolean.class);
                        specialItem = snapshot.child(runeName).child("specialItem").getValue(Boolean.class);
                        sorceress = snapshot.child(runeName).child("sorceress").getValue(Boolean.class);
                        barbarian = snapshot.child(runeName).child("barbarian").getValue(Boolean.class);
                        all = snapshot.child(runeName).child("all").getValue(Boolean.class);
                        rune1 = snapshot.child(runeName).child("rune1").getValue(String.class);
                        rune2 = snapshot.child(runeName).child("rune2").getValue(String.class);
                        rune3 = snapshot.child(runeName).child("rune3").getValue(String.class);
                        rune4 = snapshot.child(runeName).child("rune4").getValue(String.class);
                        rune5 = snapshot.child(runeName).child("rune5").getValue(String.class);
                        rune6 = snapshot.child(runeName).child("rune6").getValue(String.class);

                        mBinding.swAmazon.setChecked(amazon);
                        mBinding.swAssassin.setChecked(assassin);
                        mBinding.swNecromancer.setChecked(necromancer);
                        mBinding.swPaladins.setChecked(paladins);
                        mBinding.swMercenary.setChecked(mercenary);
                        mBinding.swLadder.setChecked(ladder);
                        mBinding.swEarly.setChecked(early);
                        mBinding.swDruid.setChecked(druid);
                        mBinding.swSpecialItem.setChecked(specialItem);
                        mBinding.swSorceress.setChecked(sorceress);
                        mBinding.swBarbarian.setChecked(barbarian);
                        mBinding.swAll.setChecked(all);

                        mBinding.etRune1.setText(rune1);
                        mBinding.etRune2.setText(rune2);
                        mBinding.etRune3.setText(rune3);
                        mBinding.etRune4.setText(rune4);
                        mBinding.etRune5.setText(rune5);
                        mBinding.etRune6.setText(rune6);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mBinding.swAmazon.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (runeName != null) {
                    databaseReference.child(runeName).child("amazon").setValue(isChecked);
                } else {
                    Toast.makeText(ModifyRuneWord.this, "먼저 룬워드를 검색해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBinding.swAssassin.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (runeName != null) {
                    databaseReference.child(runeName).child("assassin").setValue(isChecked);
                } else {
                    Toast.makeText(ModifyRuneWord.this, "먼저 룬워드를 검색해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBinding.swNecromancer.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (runeName != null) {
                    databaseReference.child(runeName).child("necromancer").setValue(isChecked);
                } else {
                    Toast.makeText(ModifyRuneWord.this, "먼저 룬워드를 검색해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBinding.swPaladins.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (runeName != null) {
                    databaseReference.child(runeName).child("paladins").setValue(isChecked);
                } else {
                    Toast.makeText(ModifyRuneWord.this, "먼저 룬워드를 검색해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBinding.swMercenary.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (runeName != null) {
                    databaseReference.child(runeName).child("mercenary").setValue(isChecked);
                } else {
                    Toast.makeText(ModifyRuneWord.this, "먼저 룬워드를 검색해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBinding.swLadder.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (runeName != null) {
                    databaseReference.child(runeName).child("ladder").setValue(isChecked);
                } else {
                    Toast.makeText(ModifyRuneWord.this, "먼저 룬워드를 검색해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBinding.swEarly.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (runeName != null) {
                    databaseReference.child(runeName).child("early").setValue(isChecked);
                } else {
                    Toast.makeText(ModifyRuneWord.this, "먼저 룬워드를 검색해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBinding.swDruid.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (runeName != null) {
                    databaseReference.child(runeName).child("druid").setValue(isChecked);
                } else {
                    Toast.makeText(ModifyRuneWord.this, "먼저 룬워드를 검색해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBinding.swSpecialItem.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (runeName != null) {
                    databaseReference.child(runeName).child("specialItem").setValue(isChecked);
                } else {
                    Toast.makeText(ModifyRuneWord.this, "먼저 룬워드를 검색해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBinding.swSorceress.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (runeName != null) {
                    databaseReference.child(runeName).child("sorceress").setValue(isChecked);
                } else {
                    Toast.makeText(ModifyRuneWord.this, "먼저 룬워드를 검색해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBinding.swBarbarian.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (runeName != null) {
                    databaseReference.child(runeName).child("barbarian").setValue(isChecked);
                } else {
                    Toast.makeText(ModifyRuneWord.this, "먼저 룬워드를 검색해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBinding.swAll.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (runeName != null) {
                    databaseReference.child(runeName).child("all").setValue(isChecked);
                } else {
                    Toast.makeText(ModifyRuneWord.this, "먼저 룬워드를 검색해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBinding.tvConfirm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (runeName != null) {
                    databaseReference.child(runeName).child("rune1").setValue(mBinding.etRune1.getText().toString());
                } else {
                    Toast.makeText(ModifyRuneWord.this, "먼저 룬워드를 검색해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBinding.tvConfirm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (runeName != null) {
                    databaseReference.child(runeName).child("rune2").setValue(mBinding.etRune2.getText().toString());
                } else {
                    Toast.makeText(ModifyRuneWord.this, "먼저 룬워드를 검색해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBinding.tvConfirm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (runeName != null) {
                    databaseReference.child(runeName).child("rune3").setValue(mBinding.etRune3.getText().toString());
                } else {
                    Toast.makeText(ModifyRuneWord.this, "먼저 룬워드를 검색해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBinding.tvConfirm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (runeName != null) {
                    databaseReference.child(runeName).child("rune4").setValue(mBinding.etRune4.getText().toString());
                } else {
                    Toast.makeText(ModifyRuneWord.this, "먼저 룬워드를 검색해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        mBinding.tvConfirm5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (runeName != null) {
                    databaseReference.child(runeName).child("rune5").setValue(mBinding.etRune5.getText().toString());
                } else {
                    Toast.makeText(ModifyRuneWord.this, "먼저 룬워드를 검색해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBinding.tvConfirm6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (runeName != null) {
                    databaseReference.child(runeName).child("rune6").setValue(mBinding.etRune6.getText().toString());
                } else {
                    Toast.makeText(ModifyRuneWord.this, "먼저 룬워드를 검색해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        databaseReference.child(runeName).child("comment").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String comment = snapshot.getValue(String.class);
                    mBinding.etComment.setText(comment);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mBinding.tvCommentConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child(runeName).child("comment").setValue(mBinding.etComment.getText().toString());
                Toast.makeText(ModifyRuneWord.this, "수정되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}