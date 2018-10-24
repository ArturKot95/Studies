package com.neisse.project.client;

import com.neisse.project.ws.RestaurantServer;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class RestaurantClient {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9876/ts?wsdl");

        QName qname = new QName("http://ws.project.neisse.com/", "RestaurantImplService");

        Service service = Service.create(url, qname);

        RestaurantServer restaurant = service.getPort(RestaurantServer.class);

        int schnitzel = restaurant.createProduct("meal", "Schnitzel with Fries");
        int ceasar = restaurant.createProduct("salad", "Ceasar");
        int kozel = restaurant.createProduct("drink", "Kozel 0.5L");

        // you can't duplicate products in menu
        System.out.println(restaurant.createProduct("drink", "Kozel 0.5L") == kozel);

        restaurant.changeProductName(schnitzel, "Burgers");

        restaurant.addToInvoice(kozel);
        restaurant.addToInvoice(kozel);
        restaurant.addToInvoice(kozel);
        restaurant.addToInvoice(schnitzel);
        restaurant.addToInvoice(ceasar);
        restaurant.removeFromInvoice(kozel);

        restaurant.changeProductPrice(kozel, 35);
        restaurant.changeProductName(kozel, "Kozel 0.7L");

        System.out.println(restaurant.invoiceContains(schnitzel));
        System.out.println(restaurant.checkout());
    }

}
