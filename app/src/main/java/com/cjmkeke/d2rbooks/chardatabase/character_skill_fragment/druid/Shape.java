package com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.druid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.chardatabase.tools.ProhibitionButton;
import com.cjmkeke.d2rbooks.databinding.FragmentShapeBinding;

public class Shape extends Fragment {

    private FragmentShapeBinding mBinding;
    private final String CHARACTER_NAME = "druid";
    private final String CHARACTER_SKILL_NAME = "Summoning";
    private final String CHARACTER_SKILL_NAME_SMALL_SIZE = "summoning";
    private final String SKILL_NAME_1 = "shape";
    private final String SKILL_NAME_2 = "elemental";
    private final String SKILL_NAME_3 = "druidSummoning";

    private final String CLASS_NAME = CHARACTER_NAME+CHARACTER_SKILL_NAME+"Skill";
    private final String SKILL_TABLE_NAME = CHARACTER_NAME+CHARACTER_SKILL_NAME;
    private final String SKILL_POINT_KEY = "skillPoint_"+CHARACTER_NAME;
    private final String SKILL_POINT_QUEST_COMPLETE_KEY = "skillQuestCompletePoint_"+CHARACTER_NAME;
    private final String[] SKILL_TABLE_ARRAY_1 = {SKILL_NAME_1+"_skill_1", SKILL_NAME_1+"_skill_2", SKILL_NAME_1+"_skill_3", SKILL_NAME_1+"_skill_4", SKILL_NAME_1+"_skill_5", SKILL_NAME_1+"_skill_6", SKILL_NAME_1+"_skill_7", SKILL_NAME_1+"_skill_8", SKILL_NAME_1+"_skill_9", SKILL_NAME_1+"_skill_10"};
    private final String[] SKILL_TABLE_ARRAY_2 = {SKILL_NAME_2+"_skill_1", SKILL_NAME_2+"_skill_2", SKILL_NAME_2+"_skill_3", SKILL_NAME_2+"_skill_4", SKILL_NAME_2+"_skill_5", SKILL_NAME_2+"_skill_6", SKILL_NAME_2+"_skill_7", SKILL_NAME_2+"_skill_8", SKILL_NAME_2+"_skill_9", SKILL_NAME_2+"_skill_10"};
    private final String[] SKILL_TABLE_ARRAY_3 = {SKILL_NAME_3+"_skill_1", SKILL_NAME_3+"_skill_2", SKILL_NAME_3+"_skill_3", SKILL_NAME_3+"_skill_4", SKILL_NAME_3+"_skill_5", SKILL_NAME_3+"_skill_6", SKILL_NAME_3+"_skill_7", SKILL_NAME_3+"_skill_8", SKILL_NAME_3+"_skill_9", SKILL_NAME_3+"_skill_10"};
    private final String CHARACTER_SKILL_STRING = CHARACTER_SKILL_NAME_SMALL_SIZE+"_"+CHARACTER_NAME;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_shape, container, false);
    }
}