package com.dheeraj.learning.threads.recursive;

/**
 * Created by gopad on 24-03-2017.
 */
public class Executor {
    public static void main(String[] args) {
        Factorial fact = new Factorial();
        System.out.println(fact.getFactorialOf(10));
    }
}
