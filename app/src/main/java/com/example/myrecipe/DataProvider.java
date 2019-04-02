package com.example.myrecipe;


/* Give each row of data as an object */

public class DataProvider {

    private String id;
    private String productName;
    private String weight;
    private String price;
    private String description;

    public DataProvider(String id, String productName, String weight, String price, String description) {
        this.id = id;
        this.productName = productName;
        this.weight = weight;
        this.price = price;
        this.description = description;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
