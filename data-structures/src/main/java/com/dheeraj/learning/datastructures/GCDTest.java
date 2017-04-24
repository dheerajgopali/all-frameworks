package com.dheeraj.learning.datastructures;

/**
 * Created by dgopali on 10/18/2015.
 */
public class GCDTest {

    public static void main(String[] args) {
        GCDTest gcdTest = new GCDTest();
        System.out.println(gcdTest.gcd(100,100));
    }
    public int gcd(int a, int b) {
        if(a==b)
            return a;
        else if(a<b){
            if(b%a==0)
                return a;
            else
                return gcd(a,b-a);
        } else if(a>b){
            if(a%b==0)
                return b;
            else
                return gcd(a-b,b);
        }
        return 0;
    }
}
