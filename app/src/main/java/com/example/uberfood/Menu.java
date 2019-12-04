package com.example.uberfood;

public class Menu {
    private String id;
    private String image;
    private  String name;
    private String rate;

    public Menu(String id, String image, String name, String rate) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.rate = rate;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getRate() {
        return rate;
    }
}
