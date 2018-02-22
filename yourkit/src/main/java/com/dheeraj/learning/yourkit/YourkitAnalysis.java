package com.dheeraj.learning.yourkit;

/**
 * Created by gopad on 14-11-2017.
 */
public class YourkitAnalysis {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        test();
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime + " msec");
    }

    public static void test(){
        for(int i=0;i<100000;i++)
            System.out.print("Hello");
    }
}
