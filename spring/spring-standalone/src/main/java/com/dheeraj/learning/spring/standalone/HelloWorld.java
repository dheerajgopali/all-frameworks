package com.dheeraj.learning.spring.standalone;

/**
 * Created by gopad on 25-04-2017.
 */
public class HelloWorld {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Hello ! " + name);
    }
}