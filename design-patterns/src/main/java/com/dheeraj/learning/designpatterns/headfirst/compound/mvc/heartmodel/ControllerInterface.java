package com.dheeraj.learning.designpatterns.headfirst.compound.mvc.heartmodel;

public interface ControllerInterface {
    void start();

    void stop();

    void increaseBPM();

    void decreaseBPM();

    void setBPM(int bpm);
}