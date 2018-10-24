package com.neisse.project.client;

import com.neisse.project.ws.SmartHomeServer;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class SmartHomeClient {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9876/ts?wsdl");

        QName qname = new QName("http://ws.project.neisse.com/", "SmartHomeImplService");

        Service service = Service.create(url, qname);

        SmartHomeServer smartHome = service.getPort(SmartHomeServer.class);

        smartHome.addCamera("garden");
        smartHome.addCamera("parking");
        smartHome.addLight("kitchen");
        smartHome.addLight("bathroom");
        smartHome.addLight("saloon");

        smartHome.openGarage();
        smartHome.setTemperature(18);
        smartHome.changeLightBrightness("bathroom", 50);
        smartHome.turnOnLight("saloon");
        smartHome.rotateCamera("parking", 75);
        smartHome.turnOffCamera("garden");

        System.out.println(smartHome.getSmartHomeReport());
    }

}