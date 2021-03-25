package com.example.colchesterguide;

public class Item {

    public String title;
    public String text = "-1";
    public int image = -1;

    public Item(String title, String text, int image) {
        this(title);
        this.text = text;
        this.image = image;
    }

    public Item(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public int getImage() {
        return image;
    }

    public boolean isLink() {
        return image == -1 && text.equals("-1");
    }
}
