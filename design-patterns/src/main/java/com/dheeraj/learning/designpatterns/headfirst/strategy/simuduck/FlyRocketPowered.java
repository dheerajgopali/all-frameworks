package com.dheeraj.learning.designpatterns.headfirst.strategy.simuduck;

public class FlyRocketPowered implements FlyBehavior {
    public void fly() {
        System.out.println("I'm flying with Rocket power");
    }
}