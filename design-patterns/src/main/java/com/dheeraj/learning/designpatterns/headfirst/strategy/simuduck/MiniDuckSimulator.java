package com.dheeraj.learning.designpatterns.headfirst.strategy.simuduck;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck d = new ModelDuck();
        d.setFlyBehavior(new FlyRocketPowered());
        d.performFly();
        d.performQuack();
    }
}
