package com.dheeraj.learning.designpatterns.headfirst.factory.multistorepizza;

import com.dheeraj.learning.designpatterns.headfirst.factory.pizza.Pizza;

public class CACheesePizza extends Pizza {
    public CACheesePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";
        toppings.add("Shredded Mozzarella Cheese");
    }

    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
