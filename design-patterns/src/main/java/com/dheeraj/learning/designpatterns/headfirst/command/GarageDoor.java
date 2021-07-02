package com.dheeraj.learning.designpatterns.headfirst.command;

public class GarageDoor {
    String name;

    public GarageDoor(String name) {
        this.name = name;
    }

    public void open() {
        System.out.println("Garage door is opened");
    }

    public void close() {
        System.out.println("Garaged door is closed");
    }
}
