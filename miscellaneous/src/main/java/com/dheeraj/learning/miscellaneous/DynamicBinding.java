package com.dheeraj.learning.miscellaneous;

public class DynamicBinding {
    public static void main(String args[]) {
        Animal a = new Dog();
        a.eat();
    }
}

class Dog extends Animal {
    void eat() {
        System.out.println("Dog is eating...");
    }
}

class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}