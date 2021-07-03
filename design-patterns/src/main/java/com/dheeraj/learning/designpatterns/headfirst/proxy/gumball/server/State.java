package com.dheeraj.learning.designpatterns.headfirst.proxy.gumball.server;

import java.io.Serializable;

public interface State extends Serializable {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}
