package com.dheeraj.learning.designpatterns.singleton.lazyinstantiation;

/**
 * Created by gopad on 03-04-2017.
 */
class A{
    private static A obj;   //private coz, obj should not be accessible from outside(if accessible can change the ref).
                            // Static for loading it while class loading phase.
    private A(){}           //Can't create an object from outside

    public static A getA(){//public static, coz method to be accessed without creating instance from outside.
        if (obj == null){
            synchronized(A.class){      //synchronized so that only one thread is accessing at a time for creation.
                                        //If more than one thread accesses it, they might create more than one instance of this object.
                if (obj == null){
                    obj = new A();//instance will be created at request time
                }
            }
        }
        return obj;
    }

    public void doSomething(){
        //write your code
    }
}
