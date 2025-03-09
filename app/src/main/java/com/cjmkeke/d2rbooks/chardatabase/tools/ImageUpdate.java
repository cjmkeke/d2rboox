package com.cjmkeke.d2rbooks.chardatabase.tools;


import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.Spanned;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjmkeke.d2rbooks.R;

public class ImageUpdate {

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;
    private ImageView imageView9;
    private ImageView imageView10;
    private Context context;
    private String skillTabCharacterName; // shadow_assassin

    public ImageUpdate(Context context, String skillTabCharacterName, ImageView imageView1, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10) {
        this.context = context;
        this.skillTabCharacterName = skillTabCharacterName;
        this.imageView1 = imageView1;
        this.imageView2 = imageView2;
        this.imageView3 = imageView3;
        this.imageView4 = imageView4;
        this.imageView5 = imageView5;
        this.imageView6 = imageView6;
        this.imageView7 = imageView7;
        this.imageView8 = imageView8;
        this.imageView9 = imageView9;
        this.imageView10 = imageView10;
    }

    public void skillImageUpdate(SharedPreferences sharedPreferences, String skillTabName) {

        // skill_shadow_assassin_1_2
        // skill_traps_1_2

        int imageId1 = context.getResources().getIdentifier("skill_"+skillTabCharacterName+"_1_2", "drawable", context.getPackageName());
        int imageId2 = context.getResources().getIdentifier("skill_"+skillTabCharacterName+"_2_2", "drawable", context.getPackageName());
        int imageId3 = context.getResources().getIdentifier("skill_"+skillTabCharacterName+"_3_2", "drawable", context.getPackageName());
        int imageId4 = context.getResources().getIdentifier("skill_"+skillTabCharacterName+"_4_2", "drawable", context.getPackageName());
        int imageId5 = context.getResources().getIdentifier("skill_"+skillTabCharacterName+"_5_2", "drawable", context.getPackageName());
        int imageId6 = context.getResources().getIdentifier("skill_"+skillTabCharacterName+"_6_2", "drawable", context.getPackageName());
        int imageId7 = context.getResources().getIdentifier("skill_"+skillTabCharacterName+"_7_2", "drawable", context.getPackageName());
        int imageId8 = context.getResources().getIdentifier("skill_"+skillTabCharacterName+"_8_2", "drawable", context.getPackageName());
        int imageId9 = context.getResources().getIdentifier("skill_"+skillTabCharacterName+"_9_2", "drawable", context.getPackageName());
        int imageId10 = context.getResources().getIdentifier("skill_"+skillTabCharacterName+"_10_2", "drawable", context.getPackageName());

        if ( imageId1 != 0){
            System.out.println(imageId1);
            if (sharedPreferences.getInt(skillTabName+"_skill_1", 0) != 0) {
                imageView1.setImageResource(imageId1);
            }
        }

        if ( imageId2 != 0){
            if (sharedPreferences.getInt(skillTabName+"_skill_2", 0) != 0) {
                imageView2.setImageResource(imageId2);
            }
        }

        if ( imageId3 != 0){
            if (sharedPreferences.getInt(skillTabName+"_skill_3", 0) != 0) {
                imageView3.setImageResource(imageId3);
            }
        }

        if ( imageId4 != 0){
            if (sharedPreferences.getInt(skillTabName+"_skill_4", 0) != 0) {
                imageView4.setImageResource(imageId4);
            }
        }

        if ( imageId5 != 0){
            if (sharedPreferences.getInt(skillTabName+"_skill_5", 0) != 0) {
                imageView5.setImageResource(imageId5);
            }
        }

        if ( imageId6 != 0){
            if (sharedPreferences.getInt(skillTabName+"_skill_6", 0) != 0) {
                imageView6.setImageResource(imageId6);
            }
        }

        if ( imageId7 != 0){
            if (sharedPreferences.getInt(skillTabName+"_skill_7", 0) != 0) {
                imageView7.setImageResource(imageId7);
            }
        }

        if ( imageId8 != 0){
            if (sharedPreferences.getInt(skillTabName+"_skill_8", 0) != 0) {
                imageView8.setImageResource(imageId8);
            }
        }

        if ( imageId9 != 0){
            if (sharedPreferences.getInt(skillTabName+"_skill_9", 0) != 0) {
                imageView9.setImageResource(imageId9);
            }
        }

        if ( imageId10 != 0){
            if (sharedPreferences.getInt(skillTabName+"_skill_10", 0) != 0) {
                imageView10.setImageResource(imageId10);
            }
        }
    }

    public void skillPreviewDialog(Context context, Spanned spanned, int id) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.skill_preview_paladins_defense);
        TextView skillPreview = dialog.findViewById(R.id.tv_preview);
        ImageView imageView = dialog.findViewById(R.id.iv_skill_preview);
        imageView.setBackgroundResource(id);
        skillPreview.setText(spanned);

        // 다이얼로그 크기 조정
        Window window = dialog.getWindow();
        if (window != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
            int width = displayMetrics.widthPixels;

            window.setLayout((int) (width * 0.9), WindowManager.LayoutParams.WRAP_CONTENT); // 화면 폭의 90% 사용
            window.setGravity(Gravity.CENTER);
        }

        dialog.show();
    }

}
