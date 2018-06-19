package com.example.android.laguide;

/**
 * Created by masus on 2/24/2018.
 */

public class Attraction {
    private static final int NO_IMAGE_PROVIDED = -1;
    private int imageResId = NO_IMAGE_PROVIDED;
    private String locationUriString;
    private String name;
    private String description;


    public Attraction(int imageResId, String locationUriString, String name, String description) {
        this.imageResId = imageResId;
        this.locationUriString = locationUriString;
        this.name = name;
        this.description = description;
    }

    public Attraction(String locationUriString, String name, String description) {
        this.locationUriString = locationUriString;
        this.name = name;
        this.description = description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getLocationUriString() {
        return locationUriString;
    }

    public String getName() {
        return name;
    }

    public  String getDescription() {
        return description;
    }

    public boolean hasImage() {
        return imageResId != NO_IMAGE_PROVIDED;
    }
}
