package com.neisse.project.ws;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

//Service Implementation
@WebService(endpointInterface = "com.neisse.project.ws.SmartHomeServer")
public class SmartHomeImpl implements SmartHomeServer {
    AC ac = new AC();
    Garage garage = new Garage();
    List<Device> cameraList = new ArrayList<>();
    List<Device> lightList = new ArrayList<>();

    // Utility methods to effectively manage cameraList and lightList
    private Device searchForDevice(String deviceName, List<Device> list) {
        for (Device device : list) {
            if (Objects.equals(device.getName(), deviceName)) {
                return device;
            }
        }
        return null;
    }
    private void addToSmartHome(Device device, List<Device> list) {
        // First, check if this device doesn't actually exist in home
        Device existingDevice = searchForDevice(device.getName(), list);
        // existingDevice == null means that there will be no duplicates
        if (existingDevice == null) {
            list.add(device);
        } else {
            throw new Error("There is already device with name " + device.getName() + " in Smart Home");
        }
    }
    private Camera getCamera(String cameraName) {
        for (Device camera : cameraList) {
            if (Objects.equals(camera.getName(), cameraName)) {
                return (Camera) camera;
            }
        }
        throw new NoSuchElementException("No Camera with name " + cameraName);
    }
    private Light getLight(String lightName) {
        for (Device light : lightList) {
            if (Objects.equals(light.getName(), lightName)) {
                return (Light) light;
            }
        }
        throw new NoSuchElementException("No Light with name " + lightName);
    }

    @Override
    public void addCamera(String cameraName) {
        Camera newCamera = new Camera(cameraName);
        addToSmartHome(newCamera, cameraList);
    }

    @Override
    public void addLight(String lightName) {
        Light newLight = new Light(lightName);
        addToSmartHome(newLight, lightList);
    }

    @Override
    public void changeLightBrightness(String lightName, int newBrightness) {
        getLight(lightName).changeBrightness(newBrightness);
    }

    @Override
    public void turnOffLight(String lightName) {
        getLight(lightName).turnOff();
    }

    @Override
    public void turnOnLight(String lightName) {
        getLight(lightName).turnOn();
    }

    @Override
    public void turnOffCamera(String cameraName) {
        getCamera(cameraName).turnOff();
    }

    @Override
    public void turnOnCamera(String cameraName) {
        getCamera(cameraName).turnOn();
    }

    @Override
    public void rotateCamera(String cameraName, int newPosition) {
        getCamera(cameraName).changePosition(newPosition);
    }

    @Override
    public void openGarage() {
        garage.turnOn();
    }

    @Override
    public void closeGarage() {
        garage.turnOff();
    }

    @Override
    public void turnOnAC() {
        ac.turnOn();
    }

    @Override
    public void turnOffAC() {
        ac.turnOff();
    }

    @Override
    public void setTemperature(int newTemperature) {
        ac.setTemperature(newTemperature);
    }

    @Override
    public String getSmartHomeReport() {
        String response = "SMART HOME REPORT \n\n";
        response += "LIGHTS\n\n";
        for (Device light : lightList) {
            response += light.getStatus() + "\n";
        }
        response += "\n";
        response += "CAMERAS\n\n";
        for (Device camera : cameraList) {
            response += camera.getStatus() + "\n";
        }
        response += "\n";
        response += "GARAGE\n\n" + garage.getStatus() + "\n\n";
        response += "AC\n\n" + ac.getStatus() + "\n\n";

        return response;
    }
}