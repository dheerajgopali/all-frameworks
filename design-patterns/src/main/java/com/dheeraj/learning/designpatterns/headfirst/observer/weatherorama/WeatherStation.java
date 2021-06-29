package com.dheeraj.learning.designpatterns.headfirst.observer.weatherorama;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(10,20,30);
        weatherData.setMeasurements(10,20,32);
        weatherData.setMeasurements(10,245,33);
    }
}
