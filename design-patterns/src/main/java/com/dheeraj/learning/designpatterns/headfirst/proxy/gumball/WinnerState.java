package com.dheeraj.learning.designpatterns.headfirst.proxy.gumball;

import com.dheeraj.learning.designpatterns.headfirst.proxy.gumball.server.GumballMachine;

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
        if(gumballMachine.getCount()>0)
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        else
            gumballMachine.setState(gumballMachine.getSoldState());
    }
}
