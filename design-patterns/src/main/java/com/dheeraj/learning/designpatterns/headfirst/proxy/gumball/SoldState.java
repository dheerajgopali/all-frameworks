package com.dheeraj.learning.designpatterns.headfirst.proxy.gumball;

import com.dheeraj.learning.designpatterns.headfirst.proxy.gumball.server.GumballMachine;

public class SoldState implements State {
    GumballMachine gumballMachine;
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("wait");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Can't");
    }

    @Override
    public void turnCrank() {
        System.out.println("Can't");
    }

    @Override
    public void dispense() {
        System.out.println("Dispensing");
        if(gumballMachine.getCount()>0)
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        else
            gumballMachine.setState(gumballMachine.getSoldState());
    }
}
