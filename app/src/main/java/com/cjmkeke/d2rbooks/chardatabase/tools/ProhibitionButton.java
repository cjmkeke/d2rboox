package com.cjmkeke.d2rbooks.chardatabase.tools;

import android.widget.ImageView;

public class ProhibitionButton {

    /**
     * @param imageView 예) imageView
     * @param skillId 예) R.id.iv_skill_image_view_3
     * @param id1 예) skill_point_1
     * @apiNote R.id.iv_skill_image_view_3 버튼을 누를때 skill_point_1 가 0이면 눌러지지 않도록
     * **/
    public boolean upButton(ImageView imageView, int skillId, int id1){
        int id = imageView.getId();
        boolean i = false;
        if (id == skillId) {
            if (id1 != 0) {
                return false;
            } else {
                return true;
            }
        }
        return i;
    }

    public boolean upButton(ImageView imageView, int skillId, int id1, int id2){
        int id = imageView.getId();
        boolean i = false;
        if (id == skillId) {
            if (id1 != 0 && id2 != 0) {
                return false;
            } else {
                return true;
            }
        }
        return i;
    }

    public boolean upButton(ImageView imageView, int skillId, int id1, int id2, int id3){
        int id = imageView.getId();
        boolean i = false;
        if (id == skillId) {
            if (id1 != 0 && id2 != 0 && id3 != 0) {
                return false;
            } else {
                return true;
            }
        }
        return i;
    }

    /**
     * @param skillId R.id.... 스킬 아이디를 입력하세요.
     * @param skillUp R.id.... 와 일치하는 스킬 스탯
     * @param skillDown 눌러지면 안되는 스탯의 아래 스킬
     * @apiNote iv_skill_image_view_1, skill_point_1, skill_point_4
     * **/
    public boolean downButton(ImageView imageView, int skillId, int skillUp, int skillDown){
        int id = imageView.getId();
        boolean i = false;
        
        // 눌러지면 안되는 버튼
        if (id == skillId) {
            // 밑에 스킬이 1이라도 있으면,    위에 스킬이 1 밑으로 안내려가게.
            if (skillDown >= 1 && skillUp <= 1) {
                i = true;
            } else {
                i = false;
            }
        }
        return i;
    }
}
