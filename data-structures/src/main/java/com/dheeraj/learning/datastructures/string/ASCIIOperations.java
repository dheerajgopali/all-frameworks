package com.dheeraj.learning.datastructures.string;

/**
 * Created by dgopali on 9/15/2015.
 */
public class ASCIIOperations {
    public static void main(String[] args) {
        displayAllASCIIChars();
    }

    public static void displayAllASCIIChars() {
        for(int i=0;i<256;i++){
            System.out.println(i+" : "+(char)i);
        }
    }
}
