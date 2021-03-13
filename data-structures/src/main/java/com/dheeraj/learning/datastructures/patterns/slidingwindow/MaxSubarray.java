package com.dheeraj.learning.datastructures.patterns.slidingwindow;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * - This is not sliding window problem. We just have to traverse list and find if the current sum + num[k] > num[k]
 */
public class MaxSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubarray maxSubarray = new MaxSubarray();
        maxSubarray.maxSubArray(nums);
    }

    /**
     * Not a sliding window problem.
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int currSum=nums[0];
        int globalSum=nums[0];
        for(int i=1;i<nums.length;i++) {
            currSum = Math.max(nums[i],currSum+nums[i]);
            if(globalSum < currSum)
                globalSum = currSum;
        }
        return globalSum;

        /*int n = nums.length;
        int max = Integer.MIN_VALUE;
        int maxSoFar = max;
        for(int i=0, j=0;j<n;j++) {
            if(max < 0){
                if(max < nums[j]) {
                    max = nums[j];
                }
                if(nums[j]<0)
                    i++;
            } else {
                if((max+nums[j]) < 0) {
                    max = 0;
                    i=j+1;
                } else {
                    max = max+nums[j];
                }
            }
            maxSoFar = Math.max(maxSoFar, max);
        }
        return maxSoFar;*/


    }
}
