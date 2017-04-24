package com.dheeraj.learning.datastructures.string;

/**
 * Created by dgopali on 10/20/2015.
 */
public class PalindromeSpecificTest {
    public static void main(String[] args) {
        PalindromeSpecificTest pst = new PalindromeSpecificTest();
        System.out.println(pst.isPalindrome("\""));
    }

    public int isPalindrome(String a) {
        int i=0;
        int j=a.length()-1;
        while(i<=j){
            while(i<=j && !Character.isLetterOrDigit(a.charAt(i))){
                i++;
            }
            while(j>=0 && !Character.isLetterOrDigit(a.charAt(j))){
                j--;
            }
            if(i<=j){
                if(Character.toLowerCase(a.charAt(i)) == Character.toLowerCase(a.charAt(j))){
                    i++;
                    j--;
                }else{
                    return 0;
                }
            }
        }
        return 1;
    }
}
