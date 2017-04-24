package com.dheeraj.learning.datastructures.hashtable;

import java.util.HashSet;

/**
 * Created by dgopali on 11/1/2015.
 */
public class NonRepeatedString {
    public static void main(String[] args) {
        NonRepeatedString obj = new NonRepeatedString();
        System.out.println(obj.lengthOfLongestSubstring("dabcdedf"));
    }

    public int lengthOfLongestSubstring(String a) {
        int max = 0;
        int len = a.length();
        HashSet<Character> set = new HashSet<Character>();
        int curLen = 0;
        int k=0;
        for(int i=0;i<len;i++){
            if(!set.contains(a.charAt(i))){
                set.add(a.charAt(i));
                curLen++;
            }else{
                curLen=0;
                i = a.indexOf(a.charAt(i),k++);
                set.clear();
            }
            if(max < curLen){
                max = curLen;
            }
        }
        return max;
    }
}