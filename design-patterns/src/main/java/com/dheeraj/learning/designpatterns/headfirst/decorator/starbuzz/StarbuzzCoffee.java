package com.dheeraj.learning.designpatterns.headfirst.decorator.starbuzz;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage.setSize(Beverage.Size.TALL);
        beverage = new Soy(beverage);
        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription());
        System.out.println(beverage.cost());
    }
}
