package com.dheeraj.learning.utilities;

/**
 * Created by dgopali on 10/21/2015.
 */
public class StringUtil {
    public static void main(String[] args) {
        displayStringArray("abc.def.123".split("\\."));
    }

    public static void displayStringArray(String[] str){
        int len = str.length;
        System.out.print("{");
        for(int i=0;i<len;i++){
            System.out.print(" ["+str[i]+"] ");
        }
        System.out.print("}");
    }
}
