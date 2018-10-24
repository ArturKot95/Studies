package com.neisse.project.ws;

public class Camera implements Device {
    // Camera is on by default
    private boolean on = true;
    // Deviation of camera (from 0 to 180 degrees). In default camera is pointing at the middle of area.
    private int position = 90;
    private String name;

    public String getName() {
        return name;
    }

    Camera(String name) {
        this.name = name;
    }

    @Override
    public void turnOn() {
        on = true;
    }

    @Override
    public void turnOff() {
        on = false;
    }

    void changePosition(int newPosition) {
        // If deviation is in range...
        if (newPosition > 0 && newPosition <= 180) {
            position = newPosition;
        }
    }

    @Override
    public String getStatus() {
        String response = "";
        response += "Camera (" + name + ")" + ", Position: " + position + "°.\n";
        response += on ? "Camera is on." : "Camera is off.";
        return response;
    }
}
