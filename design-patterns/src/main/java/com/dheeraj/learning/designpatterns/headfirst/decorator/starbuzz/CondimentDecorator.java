package com.dheeraj.learning.designpatterns.headfirst.decorator.starbuzz;

public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;

    public abstract String getDescription();
}
