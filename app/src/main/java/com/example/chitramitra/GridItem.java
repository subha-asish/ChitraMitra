package com.example.chitramitra;

public class GridItem {
    String imgURL;
    String Desc;

    public GridItem(String imgURL, String desc) {
        this.imgURL = imgURL;
        Desc = desc;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgID(String imgID) {
        this.imgURL = imgID;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
