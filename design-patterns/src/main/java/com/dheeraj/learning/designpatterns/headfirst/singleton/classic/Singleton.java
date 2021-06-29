package com.dheeraj.learning.designpatterns.headfirst.singleton.classic;

/**
 * This is s simple class. Works in non-multithread env.
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
