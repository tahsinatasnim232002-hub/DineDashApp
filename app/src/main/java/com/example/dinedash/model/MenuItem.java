package com.example.dinedash.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MenuItem implements Parcelable {
    private String name;
    private double price;
    private int quantity; // item er quantity

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 1; // default 1
    }

    protected MenuItem(Parcel in) {
        name = in.readString();
        price = in.readDouble();
        quantity = in.readInt();
    }

    public static final Creator<MenuItem> CREATOR = new Creator<MenuItem>() {
        @Override
        public MenuItem createFromParcel(Parcel in) {
            return new MenuItem(in);
        }

        @Override
        public MenuItem[] newArray(int size) {
            return new MenuItem[size];
        }
    };

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeDouble(price);
        parcel.writeInt(quantity);
    }
}
