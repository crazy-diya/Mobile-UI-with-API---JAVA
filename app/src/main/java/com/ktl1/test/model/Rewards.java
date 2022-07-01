package com.ktl1.test.model;

public class Rewards {
    private String title;
    private String desc;
    private String date;
    private Integer image;

    public Rewards(String title, String desc, String date, Integer image) {
        this.title = title;
        this.desc = desc;
        this.date = date;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
