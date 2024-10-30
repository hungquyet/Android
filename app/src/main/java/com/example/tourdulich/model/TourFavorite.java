package com.example.tourdulich.model;

public class TourFavorite {

    private int resourceImage;
    private String name;
    private String description;
    private String price;

    public TourFavorite(int resourceImage, String name, String description, String price) {
        this.resourceImage = resourceImage;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
