package com.dheeraj.learning.designpatterns.headfirst.command;

public class Stereo {
    String name;

    public Stereo(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println("Stereo is on");
    }

    public void setCD() {
        System.out.println("CD is set");
    }

    public void setVolume(int vol) {
        System.out.println("Volume set to "+vol);
    }

    public void off() {
        System.out.println("Stereo is off");
    }
}
