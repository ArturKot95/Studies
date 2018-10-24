package com.neisse.project.ws;

public class Light implements Device {
    // Brightness (in percentage). Light is off by default.
    private int brightness = 0;
    private String name;

    public String getName() {
        return name;
    }

    Light(String name) {
        this.name = name;
    }

    // Brightness higher than 0 means light is on
    @Override
    public void turnOn() {
        brightness = 100;
    }

    // Brightness == 0 means light is off
    @Override
    public void turnOff() {
        brightness = 0;
    }

    public void changeBrightness(int newBrightness) {
        if (newBrightness >= 0 && newBrightness <= 100) {
            brightness = newBrightness;
        }
    }

    @Override
    public String getStatus() {
        String response = "";
        response += "Light (" + name + ")";
        response += brightness > 0 ? " is on. Brightness: " + brightness + "%" : " is off.";
        return response;
    }
}
