package com.example.zalisme.restaurantcashier;


import java.io.Serializable;

public class Menu implements Serializable {

    private String Titles;
    private int Thumbnail;
    private int Price;
    private int Quantity;

    public Menu() {
    }

    public Menu(String titles, int thumbnail,int price, int quantity) {
        Titles = titles;
        Thumbnail = thumbnail;
        Price = price;
        Quantity = quantity;
    }

    public int getQuantity() {
        return Quantity;
    }

    public int getPrice() {
        return Price;
    }

    public String getTitles() {
        return Titles;
    }

    public int getThumbnail() {
        return Thumbnail;
    }


    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setTitles(String titles) {
        Titles = titles;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }


}
