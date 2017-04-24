package com.dheeraj.learning.datastructures.hashtable;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by dgopali on 11/1/2015.
 */
public class ColourfulNumber {
    public static void main(String[] args) {
        ColourfulNumber obj = new ColourfulNumber();
        System.out.println(obj.colorful(3245));
    }

    public int colorful(int num) {
        ArrayList<Integer> digits = new ArrayList<Integer>();
        int temp = num;
        while(temp!=0){
            int digit = temp%10;
            temp = temp/10;
            digits.add(digit);
        }

        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int digitIndex=0;digitIndex<digits.size();digitIndex++){
            for(int j=0;j<digits.size()-digitIndex;j++){
                int value = 1;
                for(int k=j;k<=j+digitIndex;k++){
                    value = value*digits.get(k);
                }
                if(hashSet.contains(value)){
                    return 0;
                }
                hashSet.add(value);
            }
        }
        return 1;
    }

    public int colorfuldup(int a) {
        ArrayList<Integer> digits = new ArrayList<Integer>();
        int temp = a;
        while(temp!=0){
            int digit = temp%10;
            temp = temp/10;
            digits.add(digit);
        }

        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<digits.size();i++){
            for(int j=0;j<digits.size()-i;j++){
                int val = 1;
                for(int k=j;k<=j+i;k++){
                    val = val*digits.get(k);
                }
                if(set.contains(val)){
                    return 0;
                }
                set.add(val);
            }
        }
        return 1;
    }
}