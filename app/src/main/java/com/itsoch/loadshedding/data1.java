package com.itsoch.loadshedding;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by saroj on 4/13/16.
 */
public class data1 {

    public static ArrayList<Item> generateData(){
        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("SUNDAY","11:00-1:00", "4:00-7:00" , ""));
        items.add(new Item("MONDAY","9:00-12:00", "3:00-6:00" , ""));
        items.add(new Item("TUESDAY","8:00-11:00", "1:00-4:00" , ""));
        items.add(new Item("WEDNESDAY","12:00-3:00", "", "" ));
        items.add(new Item("THURSDAY","11:00-1:00", "4:00-7:00" , ""));
        items.add(new Item("FRIDAY","9:00-6:00", "" , ""));
        items.add(new Item("SATURDAY","8:00-11:00", "1:00-4:00" , ""));

        return items;
    }
}