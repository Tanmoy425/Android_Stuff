package com.example.colchesterguide;

import android.content.ClipData;

import java.util.ArrayList;

public class ItemList {

    ArrayList<Item> arrayList = new ArrayList<Item>();

    public void add(String title, String text, int image)
    {
        arrayList.add(new Item(title,text,image));
    }

    public void add(String title){arrayList.add(new Item(title));}

    public ArrayList<Item> get(){return arrayList;}
}
