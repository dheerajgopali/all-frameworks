package com.dheeraj.learning.designpatterns.headfirst.singleton.multithread;

/**
 * This supports multithreads. But read heavy getInstance(). Only one thread can access at a time.
 * If number of invocations of getinstance() in not more, you can use this.
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
