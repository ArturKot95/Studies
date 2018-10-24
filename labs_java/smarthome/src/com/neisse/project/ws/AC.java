package com.neisse.project.ws;

public class AC implements Device {
    // Temeperature in Celsius
    // AC will always have temperature in this range
    private final int MIN_TEMP = 15;
    private final int MAX_TEMP = 30;
    // Default temperature - 20 degrees
    private int temperature = 20;
    // AC is turned on by default
    private boolean on = true;

    @Override
    public String getName() {
        return "Smart Home AC";
    }

    @Override
    public void turnOn() {
        on = true;
    }

    @Override
    public void turnOff() {
        on = false;
    }

    public void setTemperature(int newTemperature) {
        // If requested temperature is in AC's range...
        if (newTemperature >= MIN_TEMP && newTemperature <= MAX_TEMP) {
            temperature = newTemperature;
        } else {
            throw new IndexOutOfBoundsException("Type proper temperature. From 15 to 30°C");
        }
    }

    @Override
    public String getStatus() {
        return on ? "AC is on. Temperature: " + temperature + "." : "AC is off.";
    }
}
