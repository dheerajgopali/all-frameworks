package com.dheeraj.learning.designpatterns.headfirst.command;

public class CeilingFan {
    String name;

    public CeilingFan(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println("Ceiling Fan on");
    }

    public void off() {
        System.out.println("Ceiling fan off");
    }
}
