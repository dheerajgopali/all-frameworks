package com.dheeraj.learning.recursive;

/**
 * Created by gopad on 24-03-2017.
 */
public class Palindrome {
    public static boolean isPalindrome(StringBuilder str){
        int len = str.length();
        if(len==0 || len==1)
            return true;
        else
            return (str.charAt(0) == str.charAt(len-1)) && isPalindrome(new StringBuilder(str.substring(1,len-1)));
    }

    public static boolean isPalindrome(String str){
        return isPalindrome(str,0,str.length()-1);
    }

    //efficient.. not to create new strings
    public static boolean isPalindrome(String str, int start, int end){
        if(start >= end)
            return true;
        else
            return (str.charAt(start) == str.charAt(end)) && isPalindrome(str, start+1, end-1);
    }
}
