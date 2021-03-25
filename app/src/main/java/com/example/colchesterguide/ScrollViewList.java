package com.example.colchesterguide;

import java.util.ArrayList;

public class ScrollViewList {

    private ArrayList<ScrollViewItems> arrayList = new ArrayList<>();

    public void additem(String title, int image){
        arrayList.add(new ScrollViewItems(title,image));
    }
    public void additem(String title){arrayList.add(new ScrollViewItems(title));}

    public ArrayList<ScrollViewItems> getArrayList() {
        return arrayList;
    }
}
