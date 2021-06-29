package com.dheeraj.learning.designpatterns.headfirst.observer.weatherorama;

public class StatisticsDisplay implements Observer, DisplayElement {
    private WeatherData weatherData;
    private float avg;
    private float min;
    private float max;
    private int noOfReadings;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.register(this);
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temp: "+avg+"/"+min+"/"+max);
    }

    @Override
    public void update() {
        float temp = weatherData.getTemparature();
        avg = (noOfReadings*avg+temp)/++noOfReadings;
        min = Math.min(min, temp);
        max = Math.max(max, temp);
        display();
    }
}
