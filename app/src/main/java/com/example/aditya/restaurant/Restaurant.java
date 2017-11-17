package com.example.aditya.restaurant;

/**
 * Created by aditya on 12/11/17.
 */

import android.content.Intent;

import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    public static Map<String,Integer> menu = new HashMap<String,Integer>();
    static{
        menu.put("Biryani",110);
        menu.put("Dosa",55);
        menu.put("Bread Pakoda",20);
        menu.put("Kadhai Chicken",220);
        menu.put("Haka Noodles",60);
        menu.put("Cold Drink",35);
        menu.put("Dark Passion",110);
        menu.put("Pizza",450);
        menu.put("Idli",40);
        menu.put("Vada",35);
        menu.put("Pasta",80);
    }

    public static void add(String name,int cost){
        menu.put(name,cost);
    }

    public static void remove(String name){
        if(menu.containsKey(name))
            menu.remove(name);
    }

}
