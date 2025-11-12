package com.example.dinedash.model;

public class OrderedItem {
    private String name;
    private int quantity;
    private double price;

    public OrderedItem(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}