package com.dheeraj.learning.designpatterns.singleton.earlyinstantiation;

/**
 * Created by gopad on 03-04-2017.
 */
class A{
    private static A obj=new A();//Early, instance will be created at load time (while class loading)
    private A(){}

    public static A getA(){
        return obj;
    }

    public void doSomething(){
        //write your code
    }
}
