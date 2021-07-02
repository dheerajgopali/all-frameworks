package com.dheeraj.learning.designpatterns.headfirst.template;

public abstract class CaffeineBeverage {
    void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    public void boilWater() {
        System.out.println("Boiling water");
    }

    public abstract void brew();

    public abstract void addCondiments();

    public void pourInCup() {
        System.out.println("Pouring into cup");
    }


}
