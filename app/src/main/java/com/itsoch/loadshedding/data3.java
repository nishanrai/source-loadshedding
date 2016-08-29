package com.itsoch.loadshedding;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by saroj on 4/13/16.
 */
public class data3 {

    public static ArrayList<Item> generateData(){
        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("SUNDAY","12:00-3:00", "5:00-10:00" , ""));
        items.add(new Item("MONDAY","11:00-1:00", "4:00-7:00" , ""));
        items.add(new Item("TUESDAY","9:00-1:00", "3:00-6:00" , ""));
        items.add(new Item("WEDNESDAY","8:00-11:00", "1:00-4:00" , ""));
        items.add(new Item("THURSDAY","12:00-3:00", "5:00-10:00" , ""));
        items.add(new Item("FRIDAY","11:00-1:00", "4:00-7:00" , ""));
        items.add(new Item("SATURDAY","9:00-1:00", "3:00-6:00" , ""));

        return items;
    }
}