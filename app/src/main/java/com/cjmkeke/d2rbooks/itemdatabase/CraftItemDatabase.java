package com.cjmkeke.d2rbooks.itemdatabase;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentCraftItemDatabaseBinding;
import com.cjmkeke.d2rbooks.dialog.CraftItemShow;
import com.cjmkeke.d2rbooks.dialog.ShowRune;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CraftItemDatabase extends Fragment {

    private FragmentCraftItemDatabaseBinding mBinding;
    private boolean isHitPowerVisible = true;
    private boolean isBloodVisible = true;
    private boolean isSafetyVisible = true;
    private boolean isCasterVisible = true;
    private SharedPreferences fontSharedPreferences;

    private FirebaseDatabase firebaseDatabase;
    private ImageView perfectJewelry;
    private ImageView item1, item2, item3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentCraftItemDatabaseBinding.inflate(inflater, container, false);

        showHitPowerItems();

        mBinding.tvHitPowerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHitPowerVisible) {
                    showHitPowerItems();
                    hideOtherNotHitPowerGroups();
                } else {
                    isHitPowerVisible = !isHitPowerVisible; // 버튼을 다시 누를 때 상태 반전
                    isBloodVisible = false;
                    isCasterVisible = false;
                    isSafetyVisible = false;
                }
            }
        });

        mBinding.tvBloodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBloodVisible) {
                    showBloodItems();
                    hideOtherNotBloodGroups();
                } else {
                    isBloodVisible = !isBloodVisible;
                    isHitPowerVisible = false;
                    isCasterVisible = false;
                    isSafetyVisible = false;
                }
            }
        });

        mBinding.tvSafetyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSafetyVisible) {
                    showSafetyItems();
                    hideOtherNotSafetyGroups();
                } else {
                    isSafetyVisible = !isSafetyVisible;
                    isHitPowerVisible = false;
                    isCasterVisible = false;
                    isBloodVisible = false;
                }
            }
        });

        mBinding.tvCasterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCasterVisible) {
                    showCasterItems();
                    hideOtherNotCasterGroups();
                } else {
                    isCasterVisible = !isCasterVisible;
                    isHitPowerVisible = false;
                    isSafetyVisible = false;
                    isBloodVisible = false;
                }
            }
        });

        firebaseDatabase = FirebaseDatabase.getInstance();
        
        // TODO 힛파워
        DatabaseReference refHitPower = firebaseDatabase.getReference("craft").child("hitpower");
        mBinding.tvHitPowerHelmet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refHitPower, "helmet", "perfect_saphire");
                showCubeAndJewel();
            }
        });

        mBinding.tvHitPowerBoots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refHitPower, "boots", "perfect_saphire");
                showCubeAndJewel();
            }
        });

        mBinding.tvHitPowerGloves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refHitPower, "gloves", "perfect_saphire");
                showCubeAndJewel();
            }
        });

        mBinding.tvHitPowerBelt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refHitPower, "belt", "perfect_saphire");
                showCubeAndJewel();
            }
        });

        mBinding.tvHitPowerShield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refHitPower, "shield", "perfect_saphire");
                showCubeAndJewel();
            }
        });

        mBinding.tvHitPowerArmor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refHitPower, "armor", "perfect_saphire");
                showCubeAndJewel();
            }
        });

        mBinding.tvHitPowerWeapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refHitPower, "weapon", "perfect_saphire");
                showCubeAndJewel();
            }
        });

        mBinding.tvHitPowerRing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseAccessories(refHitPower, "ring", "ring", "perfect_saphire");
                showCubeAndJewel();
            }
        });

        mBinding.tvHitPowerAmulet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseAccessories(refHitPower, "amulet", "amulet", "perfect_saphire");
                showCubeAndJewel();
            }
        });

        // TODO 블러드
        DatabaseReference refBlood = firebaseDatabase.getReference("craft").child("blood");
        mBinding.tvBloodHelmet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refBlood, "helmet", "perfect_ruby");
                showCubeAndJewel();
            }
        });

        mBinding.tvBloodBoots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refBlood, "boots", "perfect_ruby");
                showCubeAndJewel();
            }
        });

        mBinding.tvBloodGloves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refBlood, "gloves", "perfect_ruby");
                showCubeAndJewel();
            }
        });

        mBinding.tvBloodBelt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refBlood, "belt", "perfect_ruby");
                showCubeAndJewel();
            }
        });

        mBinding.tvBloodShield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refBlood, "shield", "perfect_ruby");
                showCubeAndJewel();
            }
        });

        mBinding.tvBloodArmor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refBlood, "armor", "perfect_ruby");
                showCubeAndJewel();
            }
        });

        mBinding.tvBloodWeapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refBlood, "weapon", "perfect_ruby");
                showCubeAndJewel();
            }
        });

        mBinding.tvBloodRing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseAccessories(refBlood, "ring", "ring", "perfect_ruby");
                showCubeAndJewel();
            }
        });

        mBinding.tvBloodAmulet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseAccessories(refBlood, "amulet", "amulet", "perfect_ruby");
                showCubeAndJewel();
            }
        });

        // TODO 캐스터
        DatabaseReference refCaster = firebaseDatabase.getReference("craft").child("caster");
        mBinding.tvCasterHelmet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refCaster, "helmet","perfect_amethyst");
                showCubeAndJewel();
            }
        });

        mBinding.tvCasterBoots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refCaster, "boots","perfect_amethyst");
                showCubeAndJewel();
            }
        });

        mBinding.tvCasterGloves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refCaster, "gloves","perfect_amethyst");
                showCubeAndJewel();
            }
        });

        mBinding.tvCasterBelt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refCaster, "belt","perfect_amethyst");
                showCubeAndJewel();
            }
        });

        mBinding.tvCasterShield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refCaster, "shield","perfect_amethyst");
                showCubeAndJewel();
            }
        });

        mBinding.tvCasterArmor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refCaster, "armor","perfect_amethyst");
                showCubeAndJewel();
            }
        });

        mBinding.tvCasterWeapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refCaster, "weapon","perfect_amethyst");
                showCubeAndJewel();
            }
        });

        mBinding.tvCasterRing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseAccessories(refCaster, "ring", "ring","perfect_amethyst");
                showCubeAndJewel();
            }
        });

        mBinding.tvCasterAmulet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseAccessories(refCaster, "amulet", "amulet","perfect_amethyst");
                showCubeAndJewel();
            }
        });

        // TODO 세이프티
        DatabaseReference refSafety = firebaseDatabase.getReference("craft").child("safety");
        mBinding.tvSafetyHelmet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refSafety, "helmet","perfect_emerald");
                showCubeAndJewel();
            }
        });

        mBinding.tvSafetyBoots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refSafety, "boots","perfect_emerald");
                showCubeAndJewel();
            }
        });

        mBinding.tvSafetyGloves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refSafety, "gloves","perfect_emerald");
                showCubeAndJewel();
            }
        });

        mBinding.tvSafetyBelt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refSafety, "belt","perfect_emerald");
                showCubeAndJewel();
            }
        });

        mBinding.tvSafetyShield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refSafety, "shield","perfect_emerald");
                showCubeAndJewel();
            }
        });

        mBinding.tvSafetyArmor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refSafety, "armor","perfect_emerald");
                showCubeAndJewel();
            }
        });

        mBinding.tvSafetyWeapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseItem(refSafety, "weapon","perfect_emerald");
                showCubeAndJewel();
            }
        });

        mBinding.tvSafetyRing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseAccessories(refSafety, "ring", "ring","perfect_emerald");
                showCubeAndJewel();
            }
        });

        mBinding.tvSafetyAmulet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.viewCraft.ivHoradricCube.setVisibility(View.VISIBLE);
                mBinding.viewCraft.ivJewel.setVisibility(View.VISIBLE);
                showDatabaseAccessories(refSafety, "amulet", "amulet","perfect_emerald");
                showCubeAndJewel();
            }
        });
        
        return mBinding.getRoot();
    }

    private void showHitPowerItems() {
        mBinding.tvHitPowerAmulet.setVisibility(View.VISIBLE);
        mBinding.tvHitPowerArmor.setVisibility(View.VISIBLE);
        mBinding.tvHitPowerBelt.setVisibility(View.VISIBLE);
        mBinding.tvHitPowerBoots.setVisibility(View.VISIBLE);
        mBinding.tvHitPowerGloves.setVisibility(View.VISIBLE);
        mBinding.tvHitPowerHelmet.setVisibility(View.VISIBLE);
        mBinding.tvHitPowerRing.setVisibility(View.VISIBLE);
        mBinding.tvHitPowerShield.setVisibility(View.VISIBLE);
        mBinding.tvHitPowerWeapon.setVisibility(View.VISIBLE);
    }

    private void showBloodItems() {
        mBinding.tvBloodAmulet.setVisibility(View.VISIBLE);
        mBinding.tvBloodArmor.setVisibility(View.VISIBLE);
        mBinding.tvBloodBelt.setVisibility(View.VISIBLE);
        mBinding.tvBloodBoots.setVisibility(View.VISIBLE);
        mBinding.tvBloodGloves.setVisibility(View.VISIBLE);
        mBinding.tvBloodHelmet.setVisibility(View.VISIBLE);
        mBinding.tvBloodRing.setVisibility(View.VISIBLE);
        mBinding.tvBloodShield.setVisibility(View.VISIBLE);
        mBinding.tvBloodWeapon.setVisibility(View.VISIBLE);
    }

    private void showSafetyItems() {
        mBinding.tvSafetyAmulet.setVisibility(View.VISIBLE);
        mBinding.tvSafetyArmor.setVisibility(View.VISIBLE);
        mBinding.tvSafetyBelt.setVisibility(View.VISIBLE);
        mBinding.tvSafetyBoots.setVisibility(View.VISIBLE);
        mBinding.tvSafetyGloves.setVisibility(View.VISIBLE);
        mBinding.tvSafetyHelmet.setVisibility(View.VISIBLE);
        mBinding.tvSafetyRing.setVisibility(View.VISIBLE);
        mBinding.tvSafetyShield.setVisibility(View.VISIBLE);
        mBinding.tvSafetyWeapon.setVisibility(View.VISIBLE);
    }

    private void showCasterItems() {
        mBinding.tvCasterAmulet.setVisibility(View.VISIBLE);
        mBinding.tvCasterArmor.setVisibility(View.VISIBLE);
        mBinding.tvCasterBelt.setVisibility(View.VISIBLE);
        mBinding.tvCasterBoots.setVisibility(View.VISIBLE);
        mBinding.tvCasterGloves.setVisibility(View.VISIBLE);
        mBinding.tvCasterHelmet.setVisibility(View.VISIBLE);
        mBinding.tvCasterRing.setVisibility(View.VISIBLE);
        mBinding.tvCasterShield.setVisibility(View.VISIBLE);
        mBinding.tvCasterWeapon.setVisibility(View.VISIBLE);
    }

    private void hideOtherNotHitPowerGroups() {
        // Blood group
        mBinding.tvBloodAmulet.setVisibility(View.GONE);
        mBinding.tvBloodArmor.setVisibility(View.GONE);
        mBinding.tvBloodBelt.setVisibility(View.GONE);
        mBinding.tvBloodBoots.setVisibility(View.GONE);
        mBinding.tvBloodGloves.setVisibility(View.GONE);
        mBinding.tvBloodHelmet.setVisibility(View.GONE);
        mBinding.tvBloodRing.setVisibility(View.GONE);
        mBinding.tvBloodShield.setVisibility(View.GONE);
        mBinding.tvBloodWeapon.setVisibility(View.GONE);

        // Caster group
        mBinding.tvCasterAmulet.setVisibility(View.GONE);
        mBinding.tvCasterArmor.setVisibility(View.GONE);
        mBinding.tvCasterBelt.setVisibility(View.GONE);
        mBinding.tvCasterBoots.setVisibility(View.GONE);
        mBinding.tvCasterGloves.setVisibility(View.GONE);
        mBinding.tvCasterHelmet.setVisibility(View.GONE);
        mBinding.tvCasterRing.setVisibility(View.GONE);
        mBinding.tvCasterShield.setVisibility(View.GONE);
        mBinding.tvCasterWeapon.setVisibility(View.GONE);

        // Safety group
        mBinding.tvSafetyAmulet.setVisibility(View.GONE);
        mBinding.tvSafetyArmor.setVisibility(View.GONE);
        mBinding.tvSafetyBelt.setVisibility(View.GONE);
        mBinding.tvSafetyBoots.setVisibility(View.GONE);
        mBinding.tvSafetyGloves.setVisibility(View.GONE);
        mBinding.tvSafetyHelmet.setVisibility(View.GONE);
        mBinding.tvSafetyRing.setVisibility(View.GONE);
        mBinding.tvSafetyShield.setVisibility(View.GONE);
        mBinding.tvSafetyWeapon.setVisibility(View.GONE);
    }

    private void hideOtherNotBloodGroups() {

        mBinding.tvHitPowerAmulet.setVisibility(View.GONE);
        mBinding.tvHitPowerArmor.setVisibility(View.GONE);
        mBinding.tvHitPowerBelt.setVisibility(View.GONE);
        mBinding.tvHitPowerBoots.setVisibility(View.GONE);
        mBinding.tvHitPowerGloves.setVisibility(View.GONE);
        mBinding.tvHitPowerHelmet.setVisibility(View.GONE);
        mBinding.tvHitPowerRing.setVisibility(View.GONE);
        mBinding.tvHitPowerShield.setVisibility(View.GONE);
        mBinding.tvHitPowerWeapon.setVisibility(View.GONE);

        // Caster group
        mBinding.tvCasterAmulet.setVisibility(View.GONE);
        mBinding.tvCasterArmor.setVisibility(View.GONE);
        mBinding.tvCasterBelt.setVisibility(View.GONE);
        mBinding.tvCasterBoots.setVisibility(View.GONE);
        mBinding.tvCasterGloves.setVisibility(View.GONE);
        mBinding.tvCasterHelmet.setVisibility(View.GONE);
        mBinding.tvCasterRing.setVisibility(View.GONE);
        mBinding.tvCasterShield.setVisibility(View.GONE);
        mBinding.tvCasterWeapon.setVisibility(View.GONE);

        // Safety group
        mBinding.tvSafetyAmulet.setVisibility(View.GONE);
        mBinding.tvSafetyArmor.setVisibility(View.GONE);
        mBinding.tvSafetyBelt.setVisibility(View.GONE);
        mBinding.tvSafetyBoots.setVisibility(View.GONE);
        mBinding.tvSafetyGloves.setVisibility(View.GONE);
        mBinding.tvSafetyHelmet.setVisibility(View.GONE);
        mBinding.tvSafetyRing.setVisibility(View.GONE);
        mBinding.tvSafetyShield.setVisibility(View.GONE);
        mBinding.tvSafetyWeapon.setVisibility(View.GONE);
    }

    private void hideOtherNotCasterGroups() {

        mBinding.tvHitPowerAmulet.setVisibility(View.GONE);
        mBinding.tvHitPowerArmor.setVisibility(View.GONE);
        mBinding.tvHitPowerBelt.setVisibility(View.GONE);
        mBinding.tvHitPowerBoots.setVisibility(View.GONE);
        mBinding.tvHitPowerGloves.setVisibility(View.GONE);
        mBinding.tvHitPowerHelmet.setVisibility(View.GONE);
        mBinding.tvHitPowerRing.setVisibility(View.GONE);
        mBinding.tvHitPowerShield.setVisibility(View.GONE);
        mBinding.tvHitPowerWeapon.setVisibility(View.GONE);

        mBinding.tvBloodAmulet.setVisibility(View.GONE);
        mBinding.tvBloodArmor.setVisibility(View.GONE);
        mBinding.tvBloodBelt.setVisibility(View.GONE);
        mBinding.tvBloodBoots.setVisibility(View.GONE);
        mBinding.tvBloodGloves.setVisibility(View.GONE);
        mBinding.tvBloodHelmet.setVisibility(View.GONE);
        mBinding.tvBloodRing.setVisibility(View.GONE);
        mBinding.tvBloodShield.setVisibility(View.GONE);
        mBinding.tvBloodWeapon.setVisibility(View.GONE);

        // Caster group
//        mBinding.tvCasterAmulet.setVisibility(View.GONE);
//        mBinding.tvCasterArmor.setVisibility(View.GONE);
//        mBinding.tvCasterBelt.setVisibility(View.GONE);
//        mBinding.tvCasterBoots.setVisibility(View.GONE);
//        mBinding.tvCasterGloves.setVisibility(View.GONE);
//        mBinding.tvCasterHelmet.setVisibility(View.GONE);
//        mBinding.tvCasterRing.setVisibility(View.GONE);
//        mBinding.tvCasterShield.setVisibility(View.GONE);
//        mBinding.tvCasterWeapon.setVisibility(View.GONE);

        // Safety group
        mBinding.tvSafetyAmulet.setVisibility(View.GONE);
        mBinding.tvSafetyArmor.setVisibility(View.GONE);
        mBinding.tvSafetyBelt.setVisibility(View.GONE);
        mBinding.tvSafetyBoots.setVisibility(View.GONE);
        mBinding.tvSafetyGloves.setVisibility(View.GONE);
        mBinding.tvSafetyHelmet.setVisibility(View.GONE);
        mBinding.tvSafetyRing.setVisibility(View.GONE);
        mBinding.tvSafetyShield.setVisibility(View.GONE);
        mBinding.tvSafetyWeapon.setVisibility(View.GONE);
    }

    private void hideOtherNotSafetyGroups() {

        mBinding.tvHitPowerAmulet.setVisibility(View.GONE);
        mBinding.tvHitPowerArmor.setVisibility(View.GONE);
        mBinding.tvHitPowerBelt.setVisibility(View.GONE);
        mBinding.tvHitPowerBoots.setVisibility(View.GONE);
        mBinding.tvHitPowerGloves.setVisibility(View.GONE);
        mBinding.tvHitPowerHelmet.setVisibility(View.GONE);
        mBinding.tvHitPowerRing.setVisibility(View.GONE);
        mBinding.tvHitPowerShield.setVisibility(View.GONE);
        mBinding.tvHitPowerWeapon.setVisibility(View.GONE);

        mBinding.tvBloodAmulet.setVisibility(View.GONE);
        mBinding.tvBloodArmor.setVisibility(View.GONE);
        mBinding.tvBloodBelt.setVisibility(View.GONE);
        mBinding.tvBloodBoots.setVisibility(View.GONE);
        mBinding.tvBloodGloves.setVisibility(View.GONE);
        mBinding.tvBloodHelmet.setVisibility(View.GONE);
        mBinding.tvBloodRing.setVisibility(View.GONE);
        mBinding.tvBloodShield.setVisibility(View.GONE);
        mBinding.tvBloodWeapon.setVisibility(View.GONE);

        // Caster group
        mBinding.tvCasterAmulet.setVisibility(View.GONE);
        mBinding.tvCasterArmor.setVisibility(View.GONE);
        mBinding.tvCasterBelt.setVisibility(View.GONE);
        mBinding.tvCasterBoots.setVisibility(View.GONE);
        mBinding.tvCasterGloves.setVisibility(View.GONE);
        mBinding.tvCasterHelmet.setVisibility(View.GONE);
        mBinding.tvCasterRing.setVisibility(View.GONE);
        mBinding.tvCasterShield.setVisibility(View.GONE);
        mBinding.tvCasterWeapon.setVisibility(View.GONE);

        // Safety group
//        mBinding.tvSafetyAmulet.setVisibility(View.GONE);
//        mBinding.tvSafetyArmor.setVisibility(View.GONE);
//        mBinding.tvSafetyBelt.setVisibility(View.GONE);
//        mBinding.tvSafetyBoots.setVisibility(View.GONE);
//        mBinding.tvSafetyGloves.setVisibility(View.GONE);
//        mBinding.tvSafetyHelmet.setVisibility(View.GONE);
//        mBinding.tvSafetyRing.setVisibility(View.GONE);
//        mBinding.tvSafetyShield.setVisibility(View.GONE);
//        mBinding.tvSafetyWeapon.setVisibility(View.GONE);
    }

    private void showDatabaseItem(DatabaseReference databaseReference, String item, String jewel){
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                int resourceIdJewelry = getResources().getIdentifier(jewel, "drawable", getContext().getPackageName());
                if (resourceIdJewelry != 0) {
                    mBinding.viewCraft.ivPerfectJewelry.setImageResource(resourceIdJewelry);
                }

                if (item.equals("weapon")){
                    int resourceIdWeapon = getResources().getIdentifier("sell_inventory_fill", "drawable", getContext().getPackageName());
                    if (resourceIdWeapon != 0) {
                        mBinding.viewCraft.ivItem1.setBackgroundResource(resourceIdWeapon);
                        mBinding.viewCraft.ivItem1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getContext(), "!!!!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                } else {
                    int resourceIdWeapon = getResources().getIdentifier("sell_inventory", "drawable", getContext().getPackageName());
                    if (resourceIdWeapon != 0) {
                        mBinding.viewCraft.ivItem1.setBackgroundResource(resourceIdWeapon);
                        mBinding.viewCraft.ivItem1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                    }
                }

                String rune = snapshot.child(item).child("rune").getValue(String.class);
                int resourceIdRune = getResources().getIdentifier(rune, "drawable", getContext().getPackageName());
                if (resourceIdRune != 0) {
                    mBinding.viewCraft.ivRune.setImageResource(resourceIdRune);
                    mBinding.viewCraft.ivRune.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity(), ShowRune.class);
                            intent.putExtra(rune, rune);
                            startActivity(intent);
                        }
                    });
                }

                String type = snapshot.child(item).child("type").getValue(String.class);
                String typeSplit = type.replace("or", "\n");
                String item1 = snapshot.child(item).child("item1").getValue(String.class);
                int resourceIdItem1 = getResources().getIdentifier(item1, "drawable", getContext().getPackageName());
                if (resourceIdItem1 != 0) {
                    mBinding.viewCraft.ivItem1.setImageResource(resourceIdItem1);
                    mBinding.viewCraft.ivItem1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity(), CraftItemShow.class);
                            intent.putExtra("item1", item1);
                            intent.putExtra("type", typeSplit);
                            startActivity(intent);
                        }
                    });
                } else {
                    mBinding.viewCraft.ivItem1.setVisibility(View.GONE);
                    mBinding.viewCraft.ivItem1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                }
                
                String commonnessOptions1 = snapshot.child("commonness_options1").getValue(String.class);
                mBinding.viewCraft.tvOption1.setText("공통 옵션 : "+commonnessOptions1);
                String commonnessOptions2 = snapshot.child("commonness_options2").getValue(String.class);
                mBinding.viewCraft.tvOption2.setText("공통 옵션 : "+commonnessOptions2);
                String itemOptions = snapshot.child(item).child("options").getValue(String.class);

                String changeItemOptionsFirst = item.substring(0,1);
                String changeItemOptionsAfter = item.substring(1);
                mBinding.viewCraft.tvOption3.setText(changeItemOptionsFirst.toUpperCase()+changeItemOptionsAfter+" 에 들어가는 옵션 : "+ itemOptions);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void showDatabaseAccessories(DatabaseReference databaseReference, String item, String accessories, String jewel){
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                int resourceIdJewelry = getResources().getIdentifier(jewel, "drawable", getContext().getPackageName());
                if (resourceIdJewelry != 0) {
                    mBinding.viewCraft.ivPerfectJewelry.setImageResource(resourceIdJewelry);
                }

                if (item.equals("weapon")){
                    int resourceIdWeapon = getResources().getIdentifier("sell_inventory_fill", "drawable", getContext().getPackageName());
                    if (resourceIdWeapon != 0) {
                        mBinding.viewCraft.ivItem1.setBackgroundResource(resourceIdWeapon);
                        mBinding.viewCraft.ivItem1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getContext(), "!!!!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                } else {
                    int resourceIdWeapon = getResources().getIdentifier("sell_inventory", "drawable", getContext().getPackageName());
                    if (resourceIdWeapon != 0) {
                        mBinding.viewCraft.ivItem1.setBackgroundResource(resourceIdWeapon);
                        mBinding.viewCraft.ivItem1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                    }
                }

                String rune = snapshot.child(item).child("rune").getValue(String.class);
                int resourceIdRune = getResources().getIdentifier(rune, "drawable", getContext().getPackageName());
                if (resourceIdRune != 0) {
                    mBinding.viewCraft.ivRune.setImageResource(resourceIdRune);
                    mBinding.viewCraft.ivRune.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity(), ShowRune.class);
                            intent.putExtra(rune, rune);
                            startActivity(intent);
                        }
                    });
                }

                String type = snapshot.child(item).child("type").getValue(String.class);
                String typeSplit = type.replace("or", "\n");
                int resourceIdItem1 = getResources().getIdentifier(accessories, "drawable", getContext().getPackageName());
                if (resourceIdItem1 != 0) {
                    mBinding.viewCraft.ivItem1.setImageResource(resourceIdItem1);
                    mBinding.viewCraft.ivItem1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity(), CraftItemShow.class);
                            intent.putExtra("item1", accessories);
                            intent.putExtra("type", typeSplit);
                            startActivity(intent);
                        }
                    });
                } else {
                    mBinding.viewCraft.ivItem1.setVisibility(View.GONE);
                    mBinding.viewCraft.ivItem1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                }

                String commonnessOptions1 = snapshot.child("commonness_options1").getValue(String.class);
                mBinding.viewCraft.tvOption1.setText("공통 옵션 : "+commonnessOptions1);
                String commonnessOptions2 = snapshot.child("commonness_options2").getValue(String.class);
                mBinding.viewCraft.tvOption2.setText("공통 옵션 : "+commonnessOptions2);
                String itemOptions = snapshot.child(item).child("options").getValue(String.class);

                String changeItemOptionsFirst = item.substring(0,1);
                String changeItemOptionsAfter = item.substring(1);
                mBinding.viewCraft.tvOption3.setText(changeItemOptionsFirst.toUpperCase()+changeItemOptionsAfter+" 에 들어가는 옵션 : "+ itemOptions);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void showCubeAndJewel() {
        int resourceId1 = getResources().getIdentifier("horadric_cube", "drawable", getContext().getPackageName());
        int resourceId2 = getResources().getIdentifier("jewel", "drawable", getContext().getPackageName());
        mBinding.viewCraft.ivHoradricCube.setImageResource(resourceId1);
        mBinding.viewCraft.ivJewel.setImageResource(resourceId2);
        mBinding.viewCraft.tvEqualSign.setText("=");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null; // 메모리 누수를 방지하기 위해 바인딩 해제
    }
}
