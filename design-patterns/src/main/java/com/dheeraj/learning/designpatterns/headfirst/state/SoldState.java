package com.dheeraj.learning.designpatterns.headfirst.state;

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
        if(gumballMachine.count>0)
            gumballMachine.setState(gumballMachine.noQuarterState);
        else
            gumballMachine.setState(gumballMachine.soldOutState);
    }
}
