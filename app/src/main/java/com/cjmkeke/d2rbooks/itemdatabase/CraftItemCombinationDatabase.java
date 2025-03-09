package com.cjmkeke.d2rbooks.itemdatabase;

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
import com.cjmkeke.d2rbooks.databinding.FragmentCraftItemCombinationDatabaseBinding;
import com.cjmkeke.d2rbooks.itemdatabase.craft_item_information.CraftConstants;
import com.cjmkeke.d2rbooks.itemdatabase.craft_item_information.CraftItemShow;

public class CraftItemCombinationDatabase extends Fragment {

    private static final String TAG = "CraftItemCombinationDatabase";
    private FragmentCraftItemCombinationDatabaseBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    private CraftItemShow craftItemShow;
    private Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentCraftItemCombinationDatabaseBinding.inflate(inflater, container, false);

        bundle = new Bundle();

        String[] hitPowerItemFilter = {"선택하지 않음", "힛파워 헬멧", "힛파워 부츠", "힛파워 장갑", "힛파워 벨트", "힛파워 쉴드", "힛파워 아머", "힛파워 아뮬렛", "힛파워 링", "힛파워 무기"};
        String[] casterItemFilter = {"선택하지 않음", "캐스터 헬멧", "캐스터 부츠", "캐스터 장갑", "캐스터 벨트", "캐스터 쉴드", "캐스터 아머", "캐스터 아뮬렛", "캐스터 링", "캐스터 무기"};
        String[] bloodItemFilter = {"선택하지 않음", "블러드 헬멧", "블러드 부츠", "블러드 장갑", "블러드 벨트", "블러드 쉴드", "블러드 아머", "블러드 아뮬렛", "블러드 링", "블러드 무기"};
        String[] safetyItemFilter = {"선택하지 않음", "세이프티 헬멧", "세이프티 부츠", "세이프티 장갑", "세이프티 벨트", "세이프티 쉴드", "세이프티 아머", "세이프티 아뮬렛", "세이프티 링", "세이프티 무기"};

        int[] hitPowerImages = {R.drawable.icons_na, R.drawable.hit_power_full_helm, R.drawable.hit_power_chain_boots, R.drawable.hit_power_bracers_m, R.drawable.hit_power_heavy_belt, R.drawable.hit_power_gothic_shield, R.drawable.hit_power_field_plate, R.drawable.amulet, R.drawable.ring, R.drawable.staff2};
        int[] casterImages = {R.drawable.icons_na,   R.drawable.caster_helmet,       R.drawable.caster_boots,          R.drawable.caster_gloves,       R.drawable.caster_belt,          R.drawable.caster_shield,           R.drawable.caster_armor,          R.drawable.amulet, R.drawable.ring, R.drawable.wand};
        int[] bloodImages = {R.drawable.icons_na,    R.drawable.blood_helmet,        R.drawable.blood_boots,           R.drawable.blood_gloves,        R.drawable.blood_belt,           R.drawable.blood_shield,            R.drawable.blood_armor,           R.drawable.amulet, R.drawable.ring, R.drawable.war_axe};
        int[] safetyImages = {R.drawable.icons_na,   R.drawable.safety_helmet,       R.drawable.safety_boots,          R.drawable.safety_gloves,       R.drawable.safety_belt,          R.drawable.safety_shield,           R.drawable.safety_armor,          R.drawable.amulet, R.drawable.ring, R.drawable.maiden_spear};



        CustomSpinnerAdapter adapter1 = new CustomSpinnerAdapter(getContext(), hitPowerItemFilter, hitPowerImages);
        mBinding.spHitPowerCraft.setAdapter(adapter1);
        mBinding.spHitPowerCraft.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;
                String selectedItem = parent.getItemAtPosition(position).toString();

                if (selectedItem.equals(hitPowerItemFilter[0])) {
                    fragment = new CraftItemShow();
                    bundle.putString("title", null);
                    bundle.putString("key", null);
                    bundle.putString("item", null);
                    bundle.putString("rune", null);
                    bundle.putString("jewel", null);
                    bundle.putString("color", null);
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(hitPowerItemFilter[1])) { // 헬멧
                    fragment = new CraftItemShow();
                    bundle.putString("title", null);
                    bundle.putString("key", null);
                    bundle.putString("item", null);
                    bundle.putString("rune", null);
                    bundle.putString("jewel", null);
                    bundle.putString("color", null);
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(hitPowerItemFilter[2])) { // 부츠
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.hit_power_boots_title));
                    bundle.putString("key", CraftConstants.BOOTS);
                    bundle.putString("item", "hit_power_chain_boots");
                    bundle.putString("rune", "ral");
                    bundle.putString("jewel", "perfect_saphire");
                    bundle.putString("color", "blue");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(hitPowerItemFilter[3])) { // 장갑
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.hit_power_gloves_title));
                    bundle.putString("key", CraftConstants.GLOVES);
                    bundle.putString("item", "hit_power_bracers_m");
                    bundle.putString("rune", "ort");
                    bundle.putString("jewel", "perfect_saphire");
                    bundle.putString("color", "blue");
                    bundle.putString("option", "hit_power_gloves");
                    bundle.putString("images", "excellent_hit_power_gloves");
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(hitPowerItemFilter[4])) { // 벨트
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.hit_power_belts_title));
                    bundle.putString("key", CraftConstants.BELT);
                    bundle.putString("item", "hit_power_heavy_belt");
                    bundle.putString("rune", "tal");
                    bundle.putString("jewel", "perfect_saphire");
                    bundle.putString("color", "blue");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(hitPowerItemFilter[5])) { // 쉴드
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.hit_power_shield_title));
                    bundle.putString("key", CraftConstants.SHIELD);
                    bundle.putString("item", "hit_power_gothic_shield");
                    bundle.putString("rune", "eth");
                    bundle.putString("jewel", "perfect_saphire");
                    bundle.putString("color", "blue");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(hitPowerItemFilter[6])) { // 아머
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.hit_power_armor_title));
                    bundle.putString("key", CraftConstants.ARMOR);
                    bundle.putString("item", "hit_power_field_plate");
                    bundle.putString("rune", "nef");
                    bundle.putString("jewel", "perfect_saphire");
                    bundle.putString("color", "blue");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(hitPowerItemFilter[7])) { //아뮬렛
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.hit_power_amulets_title));
                    bundle.putString("key", CraftConstants.AMULET);
                    bundle.putString("item", "amulet");
                    bundle.putString("rune", "thul");
                    bundle.putString("jewel", "perfect_saphire");
                    bundle.putString("color", "blue");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(hitPowerItemFilter[8])) { // 링
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.hit_power_rings_title));
                    bundle.putString("key", CraftConstants.RING);
                    bundle.putString("item", "ring");
                    bundle.putString("rune", "amn");
                    bundle.putString("jewel", "perfect_saphire");
                    bundle.putString("color", "blue");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(hitPowerItemFilter[9])) { // 무기
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.hit_power_weapon_title));
                    bundle.putString("key", CraftConstants.WEAPON);
                    bundle.putString("item", "staff2");
                    bundle.putString("rune", "tir");
                    bundle.putString("jewel", "perfect_saphire");
                    bundle.putString("color", "blue");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                }

                if (fragment != null) {
                    // 프래그먼트 트랜잭션 수행
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.replace_item_craft, fragment) // R.id.fragment_container는 프래그먼트를 담을 컨테이너 ID입니다.
                            .addToBackStack(null) // 백스택 추가 (뒤로가기 기능을 위해)
                            .commit();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        CustomSpinnerAdapter adapter2 = new CustomSpinnerAdapter(getContext(), casterItemFilter, casterImages);
        mBinding.spCasterCraft.setAdapter(adapter2);
        mBinding.spCasterCraft.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals(casterItemFilter[0])) {
                    fragment = new CraftItemShow();
                    bundle.putString("title", null);
                    bundle.putString("key", null);
                    bundle.putString("item", null);
                    bundle.putString("rune", null);
                    bundle.putString("jewel", null);
                    bundle.putString("color", null);
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(casterItemFilter[1])) {
                    // 헬멧
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.caster_helmet_title));
                    bundle.putString("key", CraftConstants.HELMET);
                    bundle.putString("item", "caster_helmet");
                    bundle.putString("rune", "nef");
                    bundle.putString("jewel", "perfect_amethyst");
                    bundle.putString("color", "purple");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(casterItemFilter[2])) {
                    // 부츠
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.caster_boots_title));
                    bundle.putString("key", CraftConstants.BOOTS);
                    bundle.putString("item", "caster_boots");
                    bundle.putString("rune", "thul");
                    bundle.putString("jewel", "perfect_amethyst");
                    bundle.putString("color", "purple");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(casterItemFilter[3])) {
                    // 장갑
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.caster_gloves_title));
                    bundle.putString("key", CraftConstants.GLOVES);
                    bundle.putString("item", "caster_gloves");
                    bundle.putString("rune", "ort");
                    bundle.putString("jewel", "perfect_amethyst");
                    bundle.putString("color", "purple");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(casterItemFilter[4])) {
                    // 벨트
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.caster_belts_title));
                    bundle.putString("key", CraftConstants.BELT);
                    bundle.putString("item", "caster_belt");
                    bundle.putString("rune", "ith");
                    bundle.putString("jewel", "perfect_amethyst");
                    bundle.putString("color", "purple");
                    bundle.putString("option", "caster_belt");
                    bundle.putString("images", "excellent_cater_belt");
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(casterItemFilter[5])) {
                    // 쉴드
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.caster_shield_title));
                    bundle.putString("key", CraftConstants.SHIELD);
                    bundle.putString("item", "caster_shield");
                    bundle.putString("rune", "eth");
                    bundle.putString("jewel", "perfect_amethyst");
                    bundle.putString("color", "purple");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(casterItemFilter[6])) {
                    // 아머
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.caster_armor_title));
                    bundle.putString("key", CraftConstants.ARMOR);
                    bundle.putString("item", "caster_armor");
                    bundle.putString("rune", "tal");
                    bundle.putString("jewel", "perfect_amethyst");
                    bundle.putString("color", "purple");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(casterItemFilter[7])) {
                    //아뮬렛
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.caster_amulets_title));
                    bundle.putString("key", CraftConstants.AMULET);
                    bundle.putString("item", "amulet");
                    bundle.putString("rune", "ral");
                    bundle.putString("jewel", "perfect_amethyst");
                    bundle.putString("color", "purple");
                    bundle.putString("option", "caster_amulet");
                    bundle.putString("images", "excellent_cater_amulet");
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(casterItemFilter[8])) {
                    // 링
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.caster_rings_title));
                    bundle.putString("key", CraftConstants.RING);
                    bundle.putString("item", "ring");
                    bundle.putString("rune", "amn");
                    bundle.putString("jewel", "perfect_amethyst");
                    bundle.putString("color", "purple");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(casterItemFilter[9])) {
                    // 무기
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.caster_weapon_title));
                    bundle.putString("key", CraftConstants.WEAPON);
                    bundle.putString("item", "wand");
                    bundle.putString("rune", "tir");
                    bundle.putString("jewel", "perfect_amethyst");
                    bundle.putString("color", "purple");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                }


                if (fragment != null) {
                    // 프래그먼트 트랜잭션 수행
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.replace_item_craft, fragment) // R.id.fragment_container는 프래그먼트를 담을 컨테이너 ID입니다.
                            .addToBackStack(null) // 백스택 추가 (뒤로가기 기능을 위해)
                            .commit();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        CustomSpinnerAdapter adapter3 = new CustomSpinnerAdapter(getContext(), bloodItemFilter, bloodImages);
        mBinding.spBloodCraft.setAdapter(adapter3);
        mBinding.spBloodCraft.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals(bloodItemFilter[0])) {
                    fragment = new CraftItemShow();
                    bundle.putString("title", null);
                    bundle.putString("key", null);
                    bundle.putString("item", null);
                    bundle.putString("rune", null);
                    bundle.putString("jewel", null);
                    bundle.putString("color", null);
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(bloodItemFilter[1])) {
                    // 헬멧
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.blood_helmet_title));
                    bundle.putString("key", CraftConstants.HELMET);
                    bundle.putString("item", "blood_helmet");
                    bundle.putString("rune", "ral");
                    bundle.putString("jewel", "perfect_ruby");
                    bundle.putString("color", "red");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(bloodItemFilter[2])) {
                    // 부츠
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.blood_boots_title));
                    bundle.putString("key", CraftConstants.BOOTS);
                    bundle.putString("item", "blood_boots");
                    bundle.putString("rune", "eth");
                    bundle.putString("jewel", "perfect_ruby");
                    bundle.putString("color", "red");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(bloodItemFilter[3])) {
                    // 장갑
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.blood_gloves_title));
                    bundle.putString("key", CraftConstants.GLOVES);
                    bundle.putString("item", "blood_gloves");
                    bundle.putString("rune", "nef");
                    bundle.putString("jewel", "perfect_ruby");
                    bundle.putString("color", "red");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(bloodItemFilter[4])) {
                    // 벨트
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.blood_belts_title));
                    bundle.putString("key", CraftConstants.BELT);
                    bundle.putString("item", "blood_belt");
                    bundle.putString("rune", "tal");
                    bundle.putString("jewel", "perfect_ruby");
                    bundle.putString("color", "red");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(bloodItemFilter[5])) {
                    // 쉴드
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.blood_shield_title));
                    bundle.putString("key", CraftConstants.SHIELD);
                    bundle.putString("item", "blood_shield");
                    bundle.putString("rune", "ith");
                    bundle.putString("jewel", "perfect_ruby");
                    bundle.putString("color", "red");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(bloodItemFilter[6])) {
                    // 아머
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.blood_armor_title));
                    bundle.putString("key", CraftConstants.ARMOR);
                    bundle.putString("item", "blood_armor");
                    bundle.putString("rune", "thul");
                    bundle.putString("jewel", "perfect_ruby");
                    bundle.putString("color", "red");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(bloodItemFilter[7])) {
                    //아뮬렛
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.blood_amulets_title));
                    bundle.putString("key", CraftConstants.AMULET);
                    bundle.putString("item", "amulet");
                    bundle.putString("rune", "amn");
                    bundle.putString("jewel", "perfect_ruby");
                    bundle.putString("color", "red");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(bloodItemFilter[8])) {
                    // 링
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.blood_rings_title));
                    bundle.putString("key", CraftConstants.RING);
                    bundle.putString("item", "ring");
                    bundle.putString("rune", "sol");
                    bundle.putString("jewel", "perfect_ruby");
                    bundle.putString("color", "red");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(bloodItemFilter[9])) {
                    // 무기
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.blood_weapon_title));
                    bundle.putString("key", CraftConstants.WEAPON);
                    bundle.putString("item", "war_axe");
                    bundle.putString("rune", "ort");
                    bundle.putString("jewel", "perfect_ruby");
                    bundle.putString("color", "red");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                }

                if (fragment != null) {
                    // 프래그먼트 트랜잭션 수행
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.replace_item_craft, fragment) // R.id.fragment_container는 프래그먼트를 담을 컨테이너 ID입니다.
                            .addToBackStack(null) // 백스택 추가 (뒤로가기 기능을 위해)
                            .commit();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        CustomSpinnerAdapter adapter4 = new CustomSpinnerAdapter(getContext(), safetyItemFilter, safetyImages);
        mBinding.spSafetyCraft.setAdapter(adapter4);
        mBinding.spSafetyCraft.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals(safetyItemFilter[0])) {
                    fragment = new CraftItemShow();
                    bundle.putString("title", null);
                    bundle.putString("key", null);
                    bundle.putString("item", null);
                    bundle.putString("rune", null);
                    bundle.putString("jewel", null);
                    bundle.putString("color", null);
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(safetyItemFilter[1])) {
                    // 헬멧
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.safety_helmet_title));
                    bundle.putString("key", CraftConstants.HELMET);
                    bundle.putString("item", "safety_helmet");
                    bundle.putString("rune", "ith");
                    bundle.putString("jewel", "perfect_emerald");
                    bundle.putString("color", "green");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(safetyItemFilter[2])) {
                    // 부츠
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.safety_boots_title));
                    bundle.putString("key", CraftConstants.BOOTS);
                    bundle.putString("item", "safety_boots");
                    bundle.putString("rune", "ort");
                    bundle.putString("jewel", "perfect_emerald");
                    bundle.putString("color", "green");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(safetyItemFilter[3])) {
                    // 장갑
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.safety_gloves_title));
                    bundle.putString("key", CraftConstants.GLOVES);
                    bundle.putString("item", "safety_gloves");
                    bundle.putString("rune", "ral");
                    bundle.putString("jewel", "perfect_emerald");
                    bundle.putString("color", "green");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(safetyItemFilter[4])) {
                    // 벨트
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.safety_belts_title));
                    bundle.putString("key", CraftConstants.BELT);
                    bundle.putString("item", "safety_belt");
                    bundle.putString("rune", "tal");
                    bundle.putString("jewel", "perfect_emerald");
                    bundle.putString("color", "green");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(safetyItemFilter[5])) {
                    // 쉴드
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.safety_shield_title));
                    bundle.putString("key", CraftConstants.SHIELD);
                    bundle.putString("item", "safety_shield");
                    bundle.putString("rune", "nef");
                    bundle.putString("jewel", "perfect_emerald");
                    bundle.putString("color", "green");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(safetyItemFilter[6])) {
                    // 아머
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.safety_armor_title));
                    bundle.putString("key", CraftConstants.ARMOR);
                    bundle.putString("item", "safety_armor");
                    bundle.putString("rune", "eth");
                    bundle.putString("jewel", "perfect_emerald");
                    bundle.putString("color", "green");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(safetyItemFilter[7])) {
                    //아뮬렛
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.safety_amulets_title));
                    bundle.putString("key", CraftConstants.AMULET);
                    bundle.putString("item", "amulet");
                    bundle.putString("rune", "thul");
                    bundle.putString("jewel", "perfect_emerald");
                    bundle.putString("color", "green");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(safetyItemFilter[8])) {
                    // 링
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.safety_rings_title));
                    bundle.putString("key", CraftConstants.RING);
                    bundle.putString("item", "ring");
                    bundle.putString("rune", "amn");
                    bundle.putString("jewel", "perfect_emerald");
                    bundle.putString("color", "green");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                } else if (selectedItem.equals(safetyItemFilter[9])) {
                    // 무기
                    fragment = new CraftItemShow();
                    bundle.putString("title", getString(R.string.safety_weapon_title));
                    bundle.putString("key", CraftConstants.WEAPON);
                    bundle.putString("item", "maiden_spear");
                    bundle.putString("rune", "sol");
                    bundle.putString("jewel", "perfect_emerald");
                    bundle.putString("color", "green");
                    bundle.putString("option", null);
                    bundle.putString("images", null);
                    fragment.setArguments(bundle);
                }

                if (fragment != null) {
                    // 프래그먼트 트랜잭션 수행
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.replace_item_craft, fragment) // R.id.fragment_container는 프래그먼트를 담을 컨테이너 ID입니다.
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

    private void loadAdapterPosition(int p1, int p2, int p3, int p4) {
            mBinding.spHitPowerCraft.setSelection(p1);
            mBinding.spCasterCraft.setSelection(p2);
            mBinding.spBloodCraft.setSelection(p3);
            mBinding.spSafetyCraft.setSelection(p4);
    }

}