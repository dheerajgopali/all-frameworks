package com.dheeraj.learning.designpatterns.headfirst.compound;

public class QuackCounter implements Quackable {
    static int quackCounter = 0;
    Quackable quackable;
    Observable observable;

    public QuackCounter(Quackable quackable) {
        this.quackable = quackable;
        observable = new Observable(this);
    }

    public static int getQuackCounter() {
        return quackCounter;
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }

    @Override
    public void quack() {
        quackable.quack();
        notifyObservers();
        quackCounter++;
    }

    @Override
    public String toString() {
        return quackable.toString();
    }
}
