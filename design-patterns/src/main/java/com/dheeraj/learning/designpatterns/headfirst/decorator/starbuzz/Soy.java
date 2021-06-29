package com.dheeraj.learning.designpatterns.headfirst.decorator.starbuzz;

public class Soy extends CondimentDecorator {
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        double cost = 0;
        if(beverage.getSize().equals(Size.TALL)) {
            cost = .10;
        } else if(Size.GRANDE.equals(beverage.getSize())) {
            cost = .15;
        } else {
            cost = .20;
        }
        return beverage.cost() + cost;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+", Soy";
    }
}
