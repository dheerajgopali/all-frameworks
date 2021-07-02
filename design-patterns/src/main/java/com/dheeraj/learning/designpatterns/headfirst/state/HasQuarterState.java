package com.dheeraj.learning.designpatterns.headfirst.state;

public class HasQuarterState implements State {
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Wait");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Ejected");
        gumballMachine.setState(gumballMachine.noQuarterState);
    }

    @Override
    public void turnCrank() {
        System.out.println("Turned");
        gumballMachine.setState(gumballMachine.soldState);
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
