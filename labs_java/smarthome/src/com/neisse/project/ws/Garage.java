package com.neisse.project.ws;

public class Garage implements Device {
    // Garage is closed by default
    private boolean opened = false;

    @Override
    public String getName() {
        return "Smart Home Garage";
    }

    @Override
    public void turnOn() {
        opened = true;
    }

    @Override
    public void turnOff() {
        opened = false;
    }

    @Override
    public String getStatus() {
        return opened ? "Garage is opened." : "Garage is closed.";
    }
}
