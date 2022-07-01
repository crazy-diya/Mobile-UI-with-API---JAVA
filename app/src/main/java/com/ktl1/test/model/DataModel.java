package com.ktl1.test.model;

public class DataModel {
    private String title;
    private String sub_title;
    private String expire_date;
    private String image;
    private boolean is_completed;

    public DataModel(String title, String sub_title, String expire_date, String image, boolean is_completed) {
        this.title = title;
        this.sub_title = sub_title;
        this.expire_date = expire_date;
        this.image = image;
        this.is_completed = is_completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isIs_completed() {
        return is_completed;
    }

    public void setIs_completed(boolean is_completed) {
        this.is_completed = is_completed;
    }
}
