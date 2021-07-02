package com.dheeraj.learning.designpatterns.headfirst.command;

public class Light {
    String name;

    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name+" is switched on");
    }

    public void off() {
        System.out.println(name+" is switched off");
    }
}
