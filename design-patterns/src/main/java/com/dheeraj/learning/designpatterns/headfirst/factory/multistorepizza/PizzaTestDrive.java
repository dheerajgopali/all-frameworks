package com.dheeraj.learning.designpatterns.headfirst.factory.multistorepizza;

import com.dheeraj.learning.designpatterns.headfirst.factory.pizza.SimplePizzaFactory;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore store = new NYPizzaStore();
        store.orderPizza("cheese");

        store = new CaliforniaPizzaStore();
        store.orderPizza("cheese");
    }
}
