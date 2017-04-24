package com.dheeraj.learning.datastructures;

/**
 * Created by dgopali on 10/18/2015.
 */
public class ExcelColumnTitleTest {
    public static void main(String[] args) {
        ExcelColumnTitleTest ectt = new ExcelColumnTitleTest();
        System.out.println(ectt.titleToNumber("BB"));
    }

    public int titleToNumber(String a) {
        int length = a.length();
        int sum=0;
        int digitPosition=1;
        for(int i=length-1;i>=0;i--){
            char ch=a.charAt(i);
            sum = sum+digitPosition*getAlphabetIndex(ch);
            digitPosition=digitPosition*26;
        }
        return sum;
    }

    public int getAlphabetIndex(char ch){
        return ch-64;
    }
}
