package com.dheeraj.learning.designpatterns.headfirst.singleton.eager;

/**
 * The class loader instantiates this. Threads are not started when this is instantiated.
 * So works in multi thread env too.
 * But be careful if multiple class loaders are used to instantiate this class.
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
