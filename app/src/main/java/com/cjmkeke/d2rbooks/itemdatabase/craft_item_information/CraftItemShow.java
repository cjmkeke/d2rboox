package com.cjmkeke.d2rbooks.itemdatabase.craft_item_information;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentCraftItemShowBinding;

public class CraftItemShow extends Fragment {

    private static final String TAG = "HitPowerItem";
    private SharedPreferences fontSharedPreferences;
    private FragmentCraftItemShowBinding mBinding;
    private Bundle bundle;
    private final float textSize = 14;
    private final float defaultTextSize = 16;
    private final String DO_NOT_PREFER_OPTION = "선호하지 않는 옵션입니다.\n다른 크래프트를 만들어보는게 어떨까요?";
    private final String HIT_POWER_GLOVES = "부분 스킬 +2\n공격 속도 +20\n힘 +10-15\n민첩성 +10-15\n-----------------------------\n부분 스킬 +2\n공격 속도 +20\n힘 +10-15 또는 민첩성 +10-15\n저항력 1가지 옵션\n\n위 옵션으로 나왔을때 가장 좋습니다. 크래프트를 만들때는 노말등급의 아이템보다 최소 익셉셔널 아이템을 사용해야 대우를 받습니다.\n아래는 으뜸 옵션입니다.";
    private final String CASTER_BELT = "시전 속도 +5+10\n힘 +21+30\n생명력 +41-60\n생명력 회복 +6+10\n타격 회복 속도 +24 \n\n상급 옵션으로 나왔을때 가치가 판단됩니다.\n유니크 아이템중에서 스파이더웹 새시를 더 선호하기 때문에\n많이 사용하지는 않습니다. 크래프트를 만들때는 노말등급의\n아이템보다 최소 익셉셔널 아이템을 사용해야 대우를 받습니다.\n아래는 패힛이 아쉽기는 하지만 좋은 아이템입니다. \n\n출처 : https://www.inven.co.kr/board/diablo2/5743/85461";
    private final String CASTER_AMULETS = "케릭터 모든 스킬 +2\n시전 속도 +10-20\n민첩성 +20(최고치)\n힘 +30(최고치)\n모든 저항력 +20(최고치)\n마나 +20\n\n크래프트중에서 제일 많이 사용하고 있는 아이템입니다.\n모든 옵션이 최고치로 나오는 것은 정말 힘듭니다.\n힘든 그만큼 값어 치는 엄청납니다.\n대부분 유저는 마라의 만화경 유니크 아뮬렛을 사용합니다.\n\n출처 : 카오스큐브 Sucker";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentCraftItemShowBinding.inflate(inflater, container, false);
        bundle = getArguments();

        mBinding.tvOptions.setTextSize(defaultTextSize);

        if (bundle != null) {
            String hitPowerItem = bundle.getString("key");
            String item_key = bundle.getString("item");
            String rune_key = bundle.getString("rune");
            String title_key = bundle.getString("title");
            String jewels = bundle.getString("jewel");
            String colors = bundle.getString("color");
            String options = bundle.getString("option");
            String images = bundle.getString("images");

            int color = ContextCompat.getColor(getContext(), R.color.dia_color);
            if (colors != null && colors.equals("blue")) {
                color = ContextCompat.getColor(getContext(), R.color.dia_color_blue);
            } else if (colors != null && colors.equals("red")) {
                color = ContextCompat.getColor(getContext(), R.color.dia_color_red);
            } else if (colors != null && colors.equals("green")) {
                color = ContextCompat.getColor(getContext(), R.color.dia_color_green);
            } else if (colors != null && colors.equals("purple")) {
                color = ContextCompat.getColor(getContext(), R.color.dia_color_purple);
            }

            if (item_key != null && rune_key != null && jewels != null) {
                mBinding.llItemShowRoomMain.setVisibility(View.VISIBLE);
                mBinding.svShowRoom.setVisibility(View.VISIBLE);
                int item = getResources().getIdentifier(item_key, "drawable", getContext().getPackageName());
                int rune = getResources().getIdentifier(rune_key, "drawable", getContext().getPackageName());
                int jewel = getResources().getIdentifier(jewels, "drawable", getContext().getPackageName());
                if (images == null) {
                    int id = getContext().getResources().getIdentifier("icons_na", "drawable", getContext().getPackageName());
                    mBinding.ivItemImage.setBackgroundResource(id);
                }

                if ("excellent_hit_power_gloves".equals(images)) {
                    mBinding.ivItemImage.setVisibility(View.VISIBLE);
                    int id = getContext().getResources().getIdentifier(images, "drawable", getContext().getPackageName());
                    mBinding.ivItemImage.setBackgroundResource(id);
                } else if ("excellent_cater_belt".equals(images)) {
                    mBinding.ivItemImage.setVisibility(View.VISIBLE);
                    int id = getContext().getResources().getIdentifier(images, "drawable", getContext().getPackageName());
                    mBinding.ivItemImage.setBackgroundResource(id);
                } else if ("excellent_cater_amulet".equals(images)) {
                    int id = getContext().getResources().getIdentifier(images, "drawable", getContext().getPackageName());
                    mBinding.ivItemImage.setBackgroundResource(id);
                }

                if ("hit_power_gloves".equals(options)) {
                    mBinding.tvOptions.setTextSize(textSize);
                    mBinding.tvOptions.setText(HIT_POWER_GLOVES);
                } else if ("caster_belt".equals(options)) {
                    mBinding.tvOptions.setTextSize(textSize);
                    mBinding.tvOptions.setText(CASTER_BELT);
                } else if ("caster_amulet".equals(options)) {
                    mBinding.tvOptions.setTextSize(textSize);
                    mBinding.tvOptions.setText(CASTER_AMULETS);
                }

                if (options == null) {
                    mBinding.tvOptions.setTextSize(defaultTextSize);
                    mBinding.tvOptions.setText(DO_NOT_PREFER_OPTION);
                }

                int endIndex = title_key.indexOf("좋습니다.") + "좋습니다.".length();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append(title_key);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#D4C491")), 0, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(color), endIndex, title_key.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                mBinding.tvCraftTitle.setText(spannableStringBuilder);
                mBinding.ivCraftItem.setBackgroundResource(item);
                mBinding.ivCraftRune.setBackgroundResource(rune);
                mBinding.ivJewels.setBackgroundResource(jewel);
            } else {
                mBinding.llItemShowRoomMain.setVisibility(View.GONE);
                mBinding.svShowRoom.setVisibility(View.GONE);
            }


        }
        return mBinding.getRoot();
    }
}