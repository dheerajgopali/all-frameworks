package com.dheeraj.learning.utilities;

/**
 * Created by dgopali on 10/21/2015.
 */
public class RomanUtil {
    public static void main(String[] args) {
        System.out.println(toInt("XIVX"));
    }

    public static int toInt(String romanNumber){
        int len = romanNumber.length();
        if(romanNumber.length() == 0 || romanNumber.equals(""))
            return 0;
        else if(romanNumber.length() == 1){
            return toInt(romanNumber.charAt(0));
        }
        int sum = 0;
        sum = toInt(romanNumber.charAt(len-1));
        for(int i=len-1;i>0;i--){
            int a = toInt(romanNumber.charAt(i));
            int b = toInt(romanNumber.charAt(i-1));
            if(b<a)
                sum = sum-b;
            else
                sum = sum+b;
        }
        return sum;
    }

    public static int toInt(char a){
        switch (a){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }
}
