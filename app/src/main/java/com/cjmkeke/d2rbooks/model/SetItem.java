package com.cjmkeke.d2rbooks.model;

public class SetItem {

    // 메인에 보일 세트 아이템의 이름
    private String set_item_name;
    private String set_item_partial_effect;
    private String set_item_finished_effect;

    // 그 이후 잠깐 !
    private String set_item_list;
    private String item_name;
    private String option;
    private String option1;
    private String option2;
    private String set_name;
    private String type;
    private String img;

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getSet_name() {
        return set_name;
    }

    public void setSet_name(String set_name) {
        this.set_name = set_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSet_item_name() {
        return set_item_name;
    }

    public void setSet_item_name(String set_item_name) {
        this.set_item_name = set_item_name;
    }

    public String getSet_item_list() {
        return set_item_list;
    }

    public void setSet_item_list(String set_item_list) {
        this.set_item_list = set_item_list;
    }

    public String getSet_item_partial_effect() {
        return set_item_partial_effect;
    }

    public void setSet_item_partial_effect(String set_item_partial_effect) {
        this.set_item_partial_effect = set_item_partial_effect;
    }

    public String getSet_item_finished_effect() {
        return set_item_finished_effect;
    }

    public void setSet_item_finished_effect(String set_item_finished_effect) {
        this.set_item_finished_effect = set_item_finished_effect;
    }
}
