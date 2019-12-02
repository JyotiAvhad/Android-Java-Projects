package com.example.foodies.pojo;

public class BreakfastItem {

    private String itemName;
    private int image;

    public BreakfastItem(String name, int img) {
        itemName = name;
        image = img;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}