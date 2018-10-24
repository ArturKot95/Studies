package com.neisse.project.ws;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface SmartHomeServer {

    // Devices creation
    @WebMethod void addCamera(String cameraName);
    @WebMethod void addLight(String lightName);

    // Lights
    @WebMethod void changeLightBrightness(String lightName, int newBrightness);
    @WebMethod void turnOffLight(String lightName);
    @WebMethod void turnOnLight(String lightName);

    // Cameras
    @WebMethod void turnOffCamera(String cameraName);
    @WebMethod void turnOnCamera(String cameraName);
    @WebMethod void rotateCamera(String cameraName, int newPosition);

    // Garage
    @WebMethod void openGarage();
    @WebMethod void closeGarage();

    // Air Conditioning
    @WebMethod void turnOnAC();
    @WebMethod void turnOffAC();
    @WebMethod void setTemperature(int newTemperature);

    // Report
    @WebMethod String getSmartHomeReport();
}