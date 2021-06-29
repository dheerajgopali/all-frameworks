package com.dheeraj.learning.designpatterns.headfirst.strategy.simuduck;

public class FlyNoWay implements FlyBehavior{
    public void fly() {
        System.out.println("I can't fly");
    }
}
