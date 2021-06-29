package com.dheeraj.learning.designpatterns.headfirst.strategy.simuduck;

public class Squeak implements QuackBehavior{
    public void quack() {
        System.out.println("Squeak");
    }
}
