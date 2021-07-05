package com.dheeraj.learning.designpatterns.headfirst.compound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flock implements Quackable {
    List<Quackable> ducks = new ArrayList<>();
    Observable observable;

    public Flock() {
        this.observable = new Observable(this);
    }

    public void add(Quackable quackable) {
        ducks.add(quackable);
    }

    @Override
    public void registerObserver(Observer observer) {
        for (Quackable quackable : ducks) {
            quackable.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (Quackable quackable : ducks) {
            quackable.notifyObservers();
        }
    }

    @Override
    public void quack() {
        Iterator<Quackable> iterator = ducks.iterator();
        while (iterator.hasNext()) {
            Quackable quackable = iterator.next();
            quackable.quack();
        }
    }
}
