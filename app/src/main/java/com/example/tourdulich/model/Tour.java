package com.example.tourdulich.model;

public class Tour {

    private int resourceImage;
    private String name;
    private String description;
    private String price;
    private String status;

    public Tour(int resourceImage, String name, String description, String price) {
        this.resourceImage = resourceImage;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Tour(int resourceImage, String name, String price) {
        this.resourceImage = resourceImage;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Tour(int resourceImage){
        this.resourceImage = resourceImage;
    }

    public Tour(int resourceImage, String name, String description, String price, String status ){
        this.resourceImage = resourceImage;
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
