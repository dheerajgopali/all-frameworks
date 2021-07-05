package com.dheeraj.learning.designpatterns.headfirst.compound;

public interface QuackObservable {
    void registerObserver(Observer observer);

    void notifyObservers();
}