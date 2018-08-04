package com.dheeraj.learning.profiling;

/**
 * The aim of this class is to analyze garbage collection in java.
 * 1.How to generate a minor gc using sample code
 * 2.How to generate a major gc using sample code
 * 3.How to set mix and max heap size
 * 4.How to set young generation to old generation ratio of heap memory
 * 5.How to use various garbage collectors
 *
 * This reference has good info about java gc
 * http://developeriq.in/articles/2014/oct/31/garbage-collection-and-changes-in-java-8/
 */
public class MemoryTest {
    public static void main(String[] args) {
        //Run with this config -Xms10m -Xmx30m to get major gc as well.
        codeToInvokeMinorGC();
    }

    public static void codeToInvokeMinorGC() {
        for (int i = 0; i < 1000000000; i++) {
            Integer temp = 100000;
            System.out.println(temp);
        }
        System.out.println("Completed loop");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
