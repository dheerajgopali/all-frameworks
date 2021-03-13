package com.dheeraj.learning.datastructures.patterns.slidingwindow;

/**
 * https://www.techiedelight.com/find-maximum-length-sequence-continuous-ones-sliding-window/
 */
public class FindMaxContinuousOnes {
    public static void main(String[] args) {
        int[] arr = { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 };
        FindMaxContinuousOnes obj = new FindMaxContinuousOnes();
        System.out.println(obj.findIndex(arr));
    }

    public int findIndex(int[] input) {
        int n = input.length;
        int max = 0;
        int zeroIndex=-1;
        int finalZeroIndex=-1;
        for(int i=0,j=0;j<n;j++) {
            if(input[j] == 0) {
                if(zeroIndex >= i) {
                    i = zeroIndex + 1;
                }
                zeroIndex=j;
            }
            if(max <= j-i+1) {
                finalZeroIndex = zeroIndex;
                max = j-i+1;
            }
        }

        return finalZeroIndex;
    }
}
