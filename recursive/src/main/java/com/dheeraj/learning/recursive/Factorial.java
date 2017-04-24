package com.dheeraj.learning.recursive;

/**
 * Created by gopad on 24-03-2017.
 */
public class Factorial {
    public static int getFactorialOf(int n){
        if(n==1 || n==0)
            return 1;
        else
            return n * getFactorialOf(n-1);
    }
}
