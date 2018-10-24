package com.neisse.project.endpoint;

import com.neisse.project.ws.RestaurantImpl;

import javax.xml.ws.Endpoint;

//Endpoint publisher
public class RestaurantServerPublisher {

  public static void main(String[] args) {
      Endpoint.publish("http://localhost:9876/ts", new RestaurantImpl());
  }

}