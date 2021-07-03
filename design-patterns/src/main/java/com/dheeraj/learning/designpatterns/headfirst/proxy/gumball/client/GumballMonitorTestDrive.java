package com.dheeraj.learning.designpatterns.headfirst.proxy.gumball.client;

import com.dheeraj.learning.designpatterns.headfirst.proxy.gumball.server.GumballRemote;

import java.rmi.Naming;

public class GumballMonitorTestDrive {
    public static void main(String[] args) {
        /*String[] location = {"rmi://santafe.mightygumball.com/gumballmachine",
                "rmi://boulder.mightygumball.com/gumballmachine",
                "rmi://austin.mightygumball.com/gumballmachine"};*/
        String[] location = {"rmi://localhost/gumballmachine"};
        GumballMonitor[] monitor = new GumballMonitor[location.length];
        for (int i=0; i < location.length; i++) {
            try {
                GumballRemote machine =
                        (GumballRemote) Naming.lookup(location[i]);
                monitor[i] = new GumballMonitor(machine);
                System.out.println(monitor[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i=0; i < monitor.length; i++) {
            monitor[i].report();
        }
    }
}
