package com.example.friendsr;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
    String name;
    String description;
    int image;
    float rating;

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Product(String name, String description, int image, int rating) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.rating = rating;

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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public static ArrayList<Product> generateDataSource() {
        ArrayList<Product> thebrands = new ArrayList<>();
        thebrands.add(
                new Product("Messi","No 1 social site",
                        R.drawable.messi, 0));
        thebrands.add(
                new Product("Beckham","No 1 social site",
                        R.drawable.beckham, 0));
        thebrands.add(
                new Product("Ronaldo","No 1 social site",
                        R.drawable.ronaldo, 0));
        thebrands.add(
                new Product("Kaka","No 1 social site",
                        R.drawable.kaka, 0));
        thebrands.add(
                new Product("Oscar","No 1 social site",
                        R.drawable.oscar, 0));
        thebrands.add(
                new Product("Reus","No 1 social site",
                        R.drawable.reus, 0));

        return thebrands;
    }
}
