package com.dheeraj.learning.designpatterns.headfirst.factory.multistorepizza;

import com.dheeraj.learning.designpatterns.headfirst.factory.pizza.*;

public class NYPizzaStore extends PizzaStore {

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new NYCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new NYPepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new NYClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new NYVeggiePizza();
        }
        return pizza;
    }
}
