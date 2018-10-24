package com.neisse.project.ws;

public class Meal extends Product {
    Meal(String name) {
        super(name);
        type = "meal";
        price = 150;
    }
}
