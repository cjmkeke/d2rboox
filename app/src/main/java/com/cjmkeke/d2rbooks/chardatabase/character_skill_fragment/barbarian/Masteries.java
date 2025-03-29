package com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.barbarian;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.chardatabase.tools.ProhibitionButton;
import com.cjmkeke.d2rbooks.databinding.FragmentMasteriesBinding;

public class Masteries extends Fragment {

    private FragmentMasteriesBinding mBinding;

    private final String CHARACTER_NAME = "barbarian";
    private final String CLASS_NAME = "masteriesSkill";
    private final String SKILL_TABLE_NAME = "masteries";
    private final String CHARACTER_SKILL_STRING = "masteries_barbarian";

    private final String[] SKILL_TABLE_ARRAY_1 = {"masteries_skill_1", "masteries_skill_2", "masteries_skill_3", "masteries_skill_4", "masteries_skill_5", "masteries_skill_6", "masteries_skill_7", "masteries_skill_8", "masteries_skill_9", "masteries_skill_10"};
    private final String[] SKILL_TABLE_ARRAY_2 = {"combat_skill_1", "combat_skill_2", "combat_skill_3", "combat_skill_4", "combat_skill_5", "combat_skill_6", "combat_skill_7", "combat_skill_8", "combat_skill_9", "combat_skill_10"};
    private final String[] SKILL_TABLE_ARRAY_3 = {"warcries_skill_1", "warcries_skill_2", "warcries_skill_3", "warcries_skill_4", "warcries_skill_5", "warcries_skill_6", "warcries_skill_7", "warcries_skill_8", "warcries_skill_9", "warcries_skill_10"};

    private final String SKILL_POINT_KEY = "skillPoint_barbarian";
    private final String SKILL_POINT_QUEST_COMPLETE_KEY = "skillQuestCompletePoint_barbarian";

    private SharedPreferences fontSharedPreferences;
    private String messagePremiseSkill = "이 스킬을 사용하시려면 선행 스킬을 먼저 선택해주세요.";
    public int skillPoint;
    public int skillQuestCompletePoint;
    public int skill_point_1;
    public int skill_point_2;
    public int skill_point_3;
    public int skill_point_4;
    public int skill_point_5;
    public int skill_point_6;
    public int skill_point_7;
    public int skill_point_8;
    public int skill_point_9;
    public int skill_point_10;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener;
    private ProhibitionButton prohibitionButton = new ProhibitionButton();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_masteries, container, false);
    }
}