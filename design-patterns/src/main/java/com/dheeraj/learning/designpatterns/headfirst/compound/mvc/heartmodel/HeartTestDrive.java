package com.dheeraj.learning.designpatterns.headfirst.compound.mvc.heartmodel;

public class HeartTestDrive {
    public static void main(String[] args) {
        HeartModel heartModel = new HeartModel();
        ControllerInterface model = new HeartController(heartModel);
    }
}