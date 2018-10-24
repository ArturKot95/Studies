package com.neisse.project.ws;

public abstract class Product {
    protected String name;
    protected int price;
    protected String type;

    Product() {}
    Product(String name) {
        this.name = name;
    }

    String getDescription() {
        return name + " (" + type + ") - " + price + "CZK";
    };
}
