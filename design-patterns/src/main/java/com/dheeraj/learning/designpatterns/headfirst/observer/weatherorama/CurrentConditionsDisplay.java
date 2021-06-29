package com.dheeraj.learning.designpatterns.headfirst.observer.weatherorama;

public class CurrentConditionsDisplay implements DisplayElement, Observer {
    private float temparature;
    private float humidity;
    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.register(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: "+temparature+"F degrees and "+humidity+"% humidity");
    }

    @Override
    public void update() {
        this.temparature = weatherData.getTemparature();
        this.humidity = weatherData.getHumidity();
        display();
    }
}
