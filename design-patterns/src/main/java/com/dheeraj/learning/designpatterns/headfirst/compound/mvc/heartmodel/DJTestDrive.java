package com.dheeraj.learning.designpatterns.headfirst.compound.mvc.heartmodel;

public class DJTestDrive {
    public static void main(String[] args) {
        BeatModelInterface model = new BeatModel();
        ControllerInterface controller = new BeatController(model);
    }
}