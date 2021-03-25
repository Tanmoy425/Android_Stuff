package com.example.colchesterguide;

public class ScrollViewItems {

    public String title;
    public int image = -1;

    public ScrollViewItems(String title, int image) {
        this(title);
        this.image = image;
    }

    public ScrollViewItems(String title) { this.title = title; }

    public String getTitle() { return title; }

    public int getImage() {return image; }

    public boolean isLink() {
        return image == -1 && title.equals("-1");
    }
}
