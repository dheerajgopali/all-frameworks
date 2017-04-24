package com.dheeraj.learning.datastructures.recursive;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/31/2015.
 */
public class FindAllPalindromePartitions {
    public static void main(String[] args) {
        FindAllPalindromePartitions fa = new FindAllPalindromePartitions();
        System.out.println(fa.allPalPartitions("nitin"));
    }

    public boolean isPalindrome(String str, int low, int high) {
        while (low < high) {
            if (str.charAt(low) != str.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

    ArrayList<ArrayList<String>> allPart = new ArrayList<ArrayList<String>>();

    public void allPalPartUtil(ArrayList<String> currPart,
                               int start, int n, String str) {
        if (start >= n) {
            allPart.add(new ArrayList<String>(currPart));
            return;
        }

        for (int i = start; i < n; i++) {
            if (isPalindrome(str, start, i)) {
                currPart.add(str.substring(start, i + 1));

                allPalPartUtil(currPart, i + 1, n, str);

                currPart.remove(currPart.size() - 1);
            }
        }
    }

    public ArrayList<ArrayList<String>> allPalPartitions(String str) {
        int n = str.length();

        ArrayList<String> currPart = new ArrayList<String>();

        allPalPartUtil(currPart, 0, n, str);

        return allPart;
    }
}
