package com.neisse.project.endpoint;

import javax.xml.ws.Endpoint;
import com.neisse.project.ws.SmartHomeImpl;

//Endpoint publisher
public class SmartHomeServerPublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9876/ts", new SmartHomeImpl());
    }

}