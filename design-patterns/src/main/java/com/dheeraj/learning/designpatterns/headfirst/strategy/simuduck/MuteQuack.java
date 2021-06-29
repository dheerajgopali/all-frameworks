package com.dheeraj.learning.designpatterns.headfirst.strategy.simuduck;

public class MuteQuack implements QuackBehavior{
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
