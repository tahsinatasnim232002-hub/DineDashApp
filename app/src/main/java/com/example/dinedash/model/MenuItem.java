package com.example.dinedash.model;
public class MenuItem {
    private Long id;
    private String name;
    private String description;
    private double price;
    private boolean available;
    private String imageUrl;

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return available; }
    public String getImageUrl() { return imageUrl; }
}