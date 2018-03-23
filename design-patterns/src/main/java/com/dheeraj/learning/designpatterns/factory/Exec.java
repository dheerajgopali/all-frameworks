package com.dheeraj.learning.designpatterns.factory;

/**
 * There are three OS objects/classes, Windows, Androind and Mac. Based on input given factory retrieves relevant object.
 */
public class Exec {
    public static void main(String[] args) {
        //Create a factory OSFactory
        //Create classes Windows, Mac, Android
        //Instantiate factory
        //Call get instance method
        //Print a statement
        OSFactory osf = new OSFactory();
        OS os = osf.getInstance("Windows");
        os.print();
    }
}
