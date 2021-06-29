package com.dheeraj.learning.designpatterns.headfirst.singleton.doublecheck;

/**
 * Double check is done if already created. If multithreaded singleton is causing perf
 * overhead, this is better.
 */
public class Singleton {
    private volatile static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
