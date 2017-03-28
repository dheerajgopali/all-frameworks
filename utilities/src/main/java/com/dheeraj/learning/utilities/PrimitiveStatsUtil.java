package com.dheeraj.learning.utilities;

/**
 * Created by dgopali on 10/29/2015.
 */
public class PrimitiveStatsUtil {
    public static void main(String[] args) {
        displayPrimitiveStats();
    }

    public static void displayPrimitiveStats(){
        System.out.println("INTEGER : 4 bytes");
        System.out.println(Integer.MIN_VALUE+" to "+Integer.MAX_VALUE);
        System.out.println("(-2^31) to (2^31-1)");
    }
}
