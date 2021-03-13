package com.dheeraj.learning.datastructures.patterns.slidingwindow;

/**
 * https://www.geeksforgeeks.org/find-maximum-minimum-sum-subarray-size-k/
 */
public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        MaxSumSubArray obj = new MaxSumSubArray();
        System.out.println(obj.findMaxSumInAnySubArray(arr, 4));
    }

    public int findMaxSumInAnySubArray(int[] input, int k) {
        int n=input.length;
        if(n*k==0 || k>n)
            return 0;
        int currSum = 0;
        for(int i=0;i<k;i++) {
            currSum += input[i];
        }

        int max = currSum;
        for(int i=0,j=k;j<n;) {
            currSum += input[j++]-input[i++];
            max = Math.max(max, currSum);
        }

        return max;
    }
}
