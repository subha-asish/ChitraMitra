package com.example.chitramitra;

public class GridItem {
    String imgURL;
    String Title;
    String Year;
    String Imdb;



    public GridItem(String imgURL, String title, String year, String imdb) {
        this.imgURL = imgURL;
        Title = title;
        Year = year;
        Imdb = imdb;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getImdb() {
        return Imdb;
    }

    public void setImdb(String imdb) {
        Imdb = imdb;
    }
}
