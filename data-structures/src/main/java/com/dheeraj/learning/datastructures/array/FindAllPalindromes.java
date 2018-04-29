package com.dheeraj.learning.datastructures.array;

/**
 * Print all possible palindromes in the given string
 */
public class FindAllPalindromes {
    public static void main(String[] args) {
        findAllPalindromes("liril");
    }

    public static void findAllPalindromes(String str){
        StringBuilder strB = new StringBuilder(str);
        int subStrSize = 1;
        while(subStrSize <= strB.length()){
            int left=0;
            int right=subStrSize-1;
            while(left<=right && right<strB.length()){
                boolean isPalin = isPalindrome(strB.substring(left, right+1));
                if(isPalin) {
                    System.out.print(strB.substring(left, right+1)+", ");
                    left = right+1;
                    right=left+subStrSize-1;
                }else{
                    left++;right++;
                }

            }
            System.out.println();
            subStrSize++;
        }
    }

    public static boolean isPalindrome(String str){
        StringBuilder strB = new StringBuilder(str);
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(strB.charAt(i)!=strB.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }
}
