package com.dheeraj.learning.designpatterns.headfirst.observer.weatherorama;

public class ForecastDisplay implements Observer, DisplayElement{
    private WeatherData weatherData;
    private float lastPressure;
    private float currentPressure;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.register(this);
    }

    @Override
    public void display() {
        System.out.println("LastPressure: "+lastPressure+", Current Pressure: "+currentPressure);
    }

    @Override
    public void update() {
        lastPressure = currentPressure;
        currentPressure = weatherData.getPressure();
        display();
    }
}
