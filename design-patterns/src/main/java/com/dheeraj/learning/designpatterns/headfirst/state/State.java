package com.dheeraj.learning.designpatterns.headfirst.state;

public interface State {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}
