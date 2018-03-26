package com.dheeraj.learning.designpatterns.adapter;

/**
 * Adapter pattern : Converts interface of a class to another interface that the client expects.
 *
 * Interface : Pen
 * Another Interface : PenAdapter - Though this is not an interface, but acts as interface/proxy for PilotPen class.
 * Client : AssignmentWork
 * Client wants to write assignment
 *
 * Here we are not modifying PilotPen or Pen interface or Assignment work. We are just adding an Adapter class to keep the existing
 * code as is and still the code works as the client needs it.
 */
public class Exec {
    public static void main(String[] args) {
        //Create interface Pen - You can just write assigment with this. But you want to write assignment with PilotPen
        //Create PilotPen class
        //Create PenAdapter to work on PilotPen
        Pen p = new PenAdapter();
        AssignmentWork aw = new AssignmentWork();
        aw.setP(p);
        aw.writeAssignment("This is my assignment");

    }
}
