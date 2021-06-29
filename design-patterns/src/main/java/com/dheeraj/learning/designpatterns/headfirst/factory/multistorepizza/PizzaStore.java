package com.dheeraj.learning.designpatterns.headfirst.factory.multistorepizza;

import com.dheeraj.learning.designpatterns.headfirst.factory.pizza.Pizza;
import com.dheeraj.learning.designpatterns.headfirst.factory.pizza.SimplePizzaFactory;

public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza("cheese");

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    public abstract Pizza createPizza(String type);
}
