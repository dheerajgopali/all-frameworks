package com.dheeraj.learning.designpatterns.headfirst.factory.multistorepizza;

import com.dheeraj.learning.designpatterns.headfirst.factory.pizza.Pizza;

public class NYCheesePizza extends Pizza {

    public NYCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }
}
