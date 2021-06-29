package com.dheeraj.learning.designpatterns.headfirst.observer.weatherorama;

public interface Subject {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();
    void measurementsChanged();
}
