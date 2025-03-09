package com.cjmkeke.d2rbooks.model;

import android.graphics.drawable.Drawable;

public class HaveRune {

    private String name;
    private Drawable dw;

    public HaveRune(String name, Drawable dw) {
        this.name = name;
        this.dw = dw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getDw() {
        return dw;
    }

    public void setDw(Drawable dw) {
        this.dw = dw;
    }
}
