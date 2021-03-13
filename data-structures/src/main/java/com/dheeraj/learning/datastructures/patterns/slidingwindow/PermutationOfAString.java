package com.dheeraj.learning.datastructures.patterns.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/permutation-in-string/solution/
 */
public class PermutationOfAString {
    public static void main(String[] args) {
        PermutationOfAString obj = new PermutationOfAString();
        System.out.println(obj.checkInclusionWithArrays("oao","eidbaooo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();

        if(n1*n2 == 0)
            return false;

        HashMap<Character, Integer> s1CharCountMap = new HashMap<>();
        for(int i=0;i<n1;i++) {
            s1CharCountMap.compute(s1.charAt(i), (k,v)->v==null?1:v+1);
        }

        HashMap<Character, Integer> s2CharCountMap = new HashMap<>();
        for(int i=0,j=0;j<n2;j++) {
            s2CharCountMap.compute(s2.charAt(j), (k,v)->v==null?1:v+1);
            if(j-i==n1-1) {
                if(s1CharCountMap.equals(s2CharCountMap)) {
                    return true;
                } else {
                    char ch = s2.charAt(i);
                    if(s2CharCountMap.get(ch) == 1)
                        s2CharCountMap.remove(ch);
                    else
                        s2CharCountMap.compute(s2.charAt(i), (k,v)->v-1);
                    i++;
                }
            }
        }

        return false;
    }

    public boolean checkInclusionWithArrays(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();

        if(n1*n2 == 0)
            return false;

        int[] s1CharCount = new int[26];
        for(int i=0;i<n1;i++) {
            s1CharCount[s1.charAt(i)-'a']+=1;
        }

        int[] s2CharCount = new int[26];
        for(int i=0,j=0;j<n2;j++) {
            s2CharCount[s2.charAt(j)-'a'] += 1;
            if(j-i==n1-1) {
                if(Arrays.equals(s1CharCount, s2CharCount)) {
                    return true;
                } else {
                    char ch = s2.charAt(i);
                    s2CharCount[ch-'a'] -= 1;
                    i++;
                }
            }
        }

        return false;
    }
}
