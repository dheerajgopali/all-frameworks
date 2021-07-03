package com.dheeraj.learning.designpatterns.headfirst.proxy.gumball.server;

public class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Can't insert quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Can't eject quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("Can't turn crank");
    }

    public void refill() {
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void dispense() {
        System.out.println("Can't dispense");
    }
}
