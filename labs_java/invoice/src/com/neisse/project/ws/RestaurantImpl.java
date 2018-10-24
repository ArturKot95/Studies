package com.neisse.project.ws;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

//Service Implementation
@WebService(endpointInterface = "com.neisse.project.ws.RestaurantServer")
public class RestaurantImpl implements RestaurantServer {
    // List collecting all restaurant's products
    List<Product> productList = new ArrayList<Product>();
    // List collecting all selected customer's products
    List<Product> customerList = new ArrayList<Product>();

    private Product findProductById(int productId) {
        for (Product product : productList) {
            if (product.hashCode() == productId) {
                return product;
            }
        }
        throw new NoSuchElementException("No Product with ID " + productId + ".");
    }
    
    @Override
    public void addToInvoice(int productId) {
        customerList.add(findProductById(productId));
    }

    @Override
    public void removeFromInvoice(int productId) {
        customerList.remove(findProductById(productId));
    }

    @Override
    public String invoiceContains(int productId) {
        if (customerList.contains(findProductById(productId))) {
            Product product = findProductById(productId);
            return "Product " + product.getDescription() + " is in your  invoice.";
        }

        return "There is no selected product in your invoice.";
    }

    @Override
    public int createProduct(String type, String name) {
        for (Product product : productList) {
            // If the same product is found, return it's id
            if (Objects.equals(product.type, type) && Objects.equals(product.name, name)) {
                return product.hashCode();
            }
        }

        // Otherwise, create new Product and return it's id
        type = type.toLowerCase();
        Product product;
        // Recognize type of product...
        switch (type) {
            case "drink":
                product = new Drink(name);
                break;
            case "meal":
                product = new Meal(name);
                break;
            case "salad":
                product = new Salad(name);
                break;
            // If product hasn't proper type, throw error
            default:
                throw new Error("Provide proper product type! (beer, meal or salad).");
        }

        productList.add(product);
        return product.hashCode();
    }

    @Override
    public String checkout() {
        String response = "";

        if (customerList.isEmpty()) {
            response = "Invoice is empty.";
        } else {
            int totalPrice = 0;
            response = "INVOICE:\n";

            for (Product product : customerList) {
                response += product.getDescription() + "\n";
                totalPrice += product.price;
            }

            response += "Total price: " + totalPrice + "CZK. Thank you :)";
            customerList.clear();
        }
        return response;
    }

    @Override
    public void changeProductName(int productId, String newName) {
        /*Product menuProduct = productList.get(productList.indexOf(RestaurantServer.findProductById(productId)));
        Product invoiceProduct = customerList.get(customerList.indexOf(RestaurantServer.findProductById(productId)));

        if (menuProduct != null) {
            for (Product product : productList) {
                if (Objects.equals(menuProduct.name, product.name) && Objects.equals(menuProduct.type, product.type)) {
                    product.name = newName;
                }
            }
        }*/

        // Change price in menu list
        productList.get(productList.indexOf(findProductById(productId))).name = newName;
        // In customer's invoice also, if item exists
        if (customerList.contains(findProductById(productId))) {
            customerList.get(customerList.indexOf(findProductById(productId))).name = newName;
        }
    }

    @Override
    public void changeProductPrice(int productId, int newPrice) {
        // Change price in menu list
        productList.get(productList.indexOf(findProductById(productId))).price = newPrice;
        // In customer's invoice also, if item exists
        if (customerList.contains(findProductById(productId))) {
            customerList.get(customerList.indexOf(findProductById(productId))).price = newPrice;
        }
    }
}