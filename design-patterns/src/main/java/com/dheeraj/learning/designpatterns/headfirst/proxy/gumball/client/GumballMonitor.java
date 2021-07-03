package com.dheeraj.learning.designpatterns.headfirst.proxy.gumball.client;

import com.dheeraj.learning.designpatterns.headfirst.proxy.gumball.server.GumballMachine;
import com.dheeraj.learning.designpatterns.headfirst.proxy.gumball.server.GumballRemote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMonitor {
    GumballRemote machine;

    public GumballMonitor(GumballRemote machine) {
        this.machine = machine;
    }

    public void report() {
        try {
            System.out.println("Gumball Machine: " + machine.getLocation());
            System.out.println("Current inventory: " + machine.getCount() + " gumballs");
            System.out.println("Current state: " + machine.getState());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

