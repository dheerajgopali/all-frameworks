package com.dheeraj.learning.designpatterns.headfirst.decorator.starbuzz;

public abstract class Beverage {
    public enum Size {TALL, GRANDE, VENTI };
    Size size = Size.TALL;
    String description = "unknown beverage";

    public String getDescription() {
        return getSize()+", "+description;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public abstract double cost();
}
