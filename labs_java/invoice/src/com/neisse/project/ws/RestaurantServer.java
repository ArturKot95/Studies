package com.neisse.project.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface RestaurantServer {

    // Add product to invoice
    @WebMethod void addToInvoice(int productId);
    // Remove product from invoice
    @WebMethod void removeFromInvoice(int productId);
    // Checks if invoice contains selected product
    @WebMethod String invoiceContains(int productId);

    // Create product
    @WebMethod int createProduct(String type, String name);

    // Finalize the invoice
    @WebMethod String checkout();

    // Manage product available in the restaurant
    @WebMethod void changeProductName(int productId, String newName);
    @WebMethod void changeProductPrice(int productId, int newPrice);
}