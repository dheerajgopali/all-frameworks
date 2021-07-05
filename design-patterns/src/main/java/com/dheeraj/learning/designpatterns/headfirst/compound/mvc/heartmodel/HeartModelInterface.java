package com.dheeraj.learning.designpatterns.headfirst.compound.mvc.heartmodel;

public interface HeartModelInterface {
    void initialize();

    void on();

    void off();

    int getHeartRate();

    void setHeartRate(int bpm);

    void registerObserver(BeatObserver o);

    void removeObserver(BeatObserver o);

    void registerObserver(BPMObserver o);

    void removeObserver(BPMObserver o);
}
