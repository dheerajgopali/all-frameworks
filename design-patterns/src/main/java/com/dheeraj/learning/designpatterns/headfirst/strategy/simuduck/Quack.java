package com.dheeraj.learning.designpatterns.headfirst.strategy.simuduck;

public class Quack implements QuackBehavior{
    public void quack() {
        System.out.println("quack, quack");
    }
}
