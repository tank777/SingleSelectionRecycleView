package com.bgt.singleselectionrecycleview.model;

import android.graphics.drawable.Drawable;

/**
 * Created by Bhavesh on 20-08-2017.
 */

public class CustomViewModel {
    private String title;
    private Drawable selectedDrawable;
    private Drawable unselectedDrawable;

    public CustomViewModel(String title, Drawable unselectedDrawable, Drawable selectedDrawable) {
        this.title = title;
        this.selectedDrawable = selectedDrawable;
        this.unselectedDrawable = unselectedDrawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getSelectedDrawable() {
        return selectedDrawable;
    }

    public void setSelectedDrawable(Drawable selectedDrawable) {
        this.selectedDrawable = selectedDrawable;
    }

    public Drawable getUnselectedDrawable() {
        return unselectedDrawable;
    }

    public void setUnselectedDrawable(Drawable unselectedDrawable) {
        this.unselectedDrawable = unselectedDrawable;
    }
}
