package com.example.minhkiet.silidingmenu.model;

/**
 * Created by Minh Kiet on 4/14/2016.
 */
public class ItemSlidingMenu {
    private int ImageId;
    private String title;

    public ItemSlidingMenu() {

    }

    public ItemSlidingMenu(int imageId, String title) {
        ImageId = imageId;
        this.title = title;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ItemSlidingMenu{" +
                "ImageId=" + ImageId +
                ", title='" + title + '\'' +
                '}';
    }
}
