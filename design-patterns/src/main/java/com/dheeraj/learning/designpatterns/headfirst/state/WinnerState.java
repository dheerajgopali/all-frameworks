package com.dheeraj.learning.designpatterns.headfirst.state;

public class WinnerState implements State {
    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Cant insert");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("cant eject");
    }

    @Override
    public void turnCrank() {
        System.out.println("Can't");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        gumballMachine.releaseBall();
        if(gumballMachine.count>0)
            gumballMachine.setState(gumballMachine.noQuarterState);
        else
            gumballMachine.setState(gumballMachine.soldOutState);
    }
}
