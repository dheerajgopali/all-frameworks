package com.dheeraj.learning.designpatterns.headfirst.factory.pizza;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore store = new PizzaStore(new SimplePizzaFactory());
        store.orderPizza("cheese");
    }
}
