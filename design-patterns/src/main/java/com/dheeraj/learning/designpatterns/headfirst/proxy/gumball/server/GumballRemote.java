package com.dheeraj.learning.designpatterns.headfirst.proxy.gumball.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GumballRemote extends Remote {
    public int getCount() throws RemoteException;
    public String getLocation() throws RemoteException;
    public State getState() throws RemoteException;
}
