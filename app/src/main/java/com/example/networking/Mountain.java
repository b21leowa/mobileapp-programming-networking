package com.example.networking;

import com.google.gson.annotations.SerializedName;

public class Mountain {
    private String ID;
    private String name;
    private int feet;

    @SerializedName("size")
    private int size;
    private String location;


    Mountain(String name, String location, int size) {
        this.name = name;
        this.location = location;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getSizeString () {
        return ""+size;
    }

    public String getID() {
        return ID;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public int getFeet() {
        return feet;
    }

    public int getMeter() {
        return size;
    }
}
