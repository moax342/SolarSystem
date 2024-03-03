package com.moax.solarsystem;

public class ModelItemCardView {
    private int image;
    private String title,Desc;

    public ModelItemCardView(int image, String title, String desc) {
        this.image = image;
        this.title = title;
        this.Desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
