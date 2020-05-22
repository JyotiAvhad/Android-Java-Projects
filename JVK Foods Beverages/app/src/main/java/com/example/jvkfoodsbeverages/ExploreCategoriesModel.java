package com.example.jvkfoodsbeverages;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;

public class ExploreCategoriesModel {

    private String catName;
    private String catPlacesCount;
    private int catBGColor;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatPlacesCount() {
        return catPlacesCount;
    }

    public void setCatPlacesCount(String catPlacesCount) {
        this.catPlacesCount = catPlacesCount;
    }

    public int getCatBGColor() {
        return catBGColor;
    }

    public void setCatBGColor(int catBGColor) {
        this.catBGColor = catBGColor;
    }
}
