package com.dheeraj.learning.utilities;

/**
 * Created by dgopali on 10/18/2015.
 */
public class BinaryUtil {
    public static void main(String[] args) {
        /*for(int i=0;i<10;i++)
        System.out.println(convertDecimalToBinary(i));*/
        System.out.println(convertBinaryToDecimal("100000"));
    }
    public static String convertDecimalToBinary(int a){
        StringBuffer str = new StringBuffer();
        while(a!=0){
            int remainder = a%2;
            a=a/2;
            str.append(remainder);
        }
        return str.reverse().toString();
    }

    public static int convertBinaryToDecimal(String a){
        StringBuilder str = new StringBuilder(a);
        int len = a.length();
        int sum = 0;
        int j=0;
        for(int i=len-1;i>=0;i--,j++){
            sum = sum+(a.charAt(i)-'0')*(int)Math.pow(2,j);
        }
        return sum;
    }
}
