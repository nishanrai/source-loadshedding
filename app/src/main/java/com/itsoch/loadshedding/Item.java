package com.itsoch.loadshedding;

/**
 * Created by saroj on 4/8/16.
 */
public class Item {
    private String title;
    private String description;
    private String day;
    private String third;


    public Item(String day,String title, String description , String third) {
        super();
        this.title = title;
        this.description = description;
        this.day = day;
        this.third = third;

    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDay(){return day;}

    public void setDay(String day) {
        this.day = day;
    }

    public String getthird(){return third;}

    public void setthird(String third) {
        this.third = third;
    }
}