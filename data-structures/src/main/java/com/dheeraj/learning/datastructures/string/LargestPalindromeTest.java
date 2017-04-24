package com.dheeraj.learning.datastructures.string;

/**
 * Created by dgopali on 10/21/2015.
 */
public class LargestPalindromeTest {
    public static void main(String[] args) {
        LargestPalindromeTest lpt = new LargestPalindromeTest();
        System.out.println(lpt.longestPalindrome("aaaabaaa"));
    }

    public String longestPalindrome(String str){
        if(str.length() == 0){
            return "";
        }
        int oldPalindromeLength = 0;
        boolean isPalindrome = false;
        int len = str.length();
        int startIndex = 0;
        int endIndex = 0;
        for(int i=0;i<len;i++){
            int leftIndex = i;
            int rightIndex = getRightIndex(str, i, len-1, str.charAt(i));
            int palinI = leftIndex;
            int palinJ = rightIndex;
            isPalindrome = false;
            int expectedPalindromeLength = rightIndex - leftIndex + 1;

            while(palinI <= palinJ && (expectedPalindromeLength > oldPalindromeLength)){
                if(str.charAt(palinI) == str.charAt(palinJ)){
                    palinI++;
                    palinJ--;
                    isPalindrome = true;
                }else{
                    palinI = i;
                    palinJ = getRightIndex(str, i, rightIndex-1, str.charAt(i));
                    rightIndex = palinJ;
                    expectedPalindromeLength = palinJ - palinI + 1;
                    isPalindrome = false;
                }
            }

            if(isPalindrome){
                int curPalindromeLength = rightIndex - i + 1;
                if(curPalindromeLength > oldPalindromeLength){
                    startIndex = i;
                    endIndex = rightIndex;
                    oldPalindromeLength = curPalindromeLength;
                }
            }
        }
        return str.substring(startIndex, endIndex+1);
    }

    public int getRightIndex(String str, int start, int end, char ch){
        for(int i=end;i>=start;i--){
            if(ch == str.charAt(i)){
                return i;
            }
        }
        return -1;
    }
}
