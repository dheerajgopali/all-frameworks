package com.dheeraj.learning.designpatterns.headfirst.proxy.gumball.server;

public class HasQuarterState implements State {
    private static final long serialVersionUID=2L;
    transient GumballMachine gumballMachine;

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
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("Turned");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
