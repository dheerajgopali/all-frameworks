package com.dheeraj.learning.datastructures.array;

/**
 * Smallest subarray with sum greater than a given value
 Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.

 Examples:
 arr[] = {1, 4, 45, 6, 0, 19}
 x  =  51
 Output: 3
 Minimum length subarray is {4, 45, 6}

 arr[] = {1, 10, 5, 2, 7}
 x  = 9
 Output: 1
 Minimum length subarray is {10}

 arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
 x = 280
 Output: 4
 Minimum length subarray is {100, 1, 0, 200}

 arr[] = {1, 2, 4}
 x = 8
 Output : Not Possible
 Whole array sum is smaller than 8.
 */
public class SmallestSubArrayWithSumGreaterThanGivenValue {
    public static void main(String[] args) {
        int arr[] = {1, 4, 45, 6, 0, 19};
        System.out.println(findSmallest(arr, 51));
        System.out.println(findSmallestV2(arr, 51));
        int arr2[] = {-8, 1, 4, 2, -6};
        System.out.println(findSmallestV3(arr2, 5));

    }

    /**
     * This is the trivial solution I've come up with.
     *
     * Time complexity of the above approach is clearly O(n2).
     * @param arr
     * @param value
     * @return
     */
    static int findSmallest(int[] arr, int value){
        int n = arr.length;
        int currSmallSubArrayLength=Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum=0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if(sum > value){
                    currSmallSubArrayLength=Math.min(currSmallSubArrayLength, j-i+1);
                    break;
                }
            }
        }

        return currSmallSubArrayLength;
    }

    /**
     * The idea here is
     * 1. Add a few elements until the sum is greater than the given value.
     * 2. Record the size
     * 3. Remove the elements from the first in this subset until sum <= value.
     * 4. Repeat the logic from step 1. This time end variable will be started after the subset.
     *
     * Time complexity of the above approach is clearly O(n).
     * @param arr
     * @param value
     * @return
     */
    static int findSmallestV2(int[] arr, int value){
        int n = arr.length;
        // Initialize current sum and minimum length
        int curr_sum = 0, min_len = n + 1;

        // Initialize starting and ending indexes
        int start = 0, end = 0;
        while (end < n)
        {
            // Keep adding array elements while current sum
            // is smaller than x
            while (curr_sum <= value && end < n)
                curr_sum += arr[end++];

            // If current sum becomes greater than x.
            while (curr_sum > value && start < n)
            {
                // Update minimum length if needed
                if (end - start < min_len)
                    min_len = end - start;

                // remove starting elements
                curr_sum -= arr[start++];
            }
        }
        return min_len;
    }

    /**
     * With negative numbers
     * How to handle negative numbers?
     The above solution may not work if input array contains negative numbers. For example arr[] = {- 8, 1, 4, 2, -6}.
     To handle negative numbers, add a condition to ignore subarrays with negative sums.
     * @param arr
     * @param value
     * @return
     */
    static int findSmallestV3(int[] arr, int value){
        int n = arr.length;
        // Initialize current sum and minimum length
        int curr_sum = 0, min_len = n + 1;

        // Initialize starting and ending indexes
        int start = 0, end = 0;
        while (end < n)
        {
            // Keep adding array elements while current sum
            // is smaller than x
            while (curr_sum <= value && end < n){
                // Ignore subarrays with negative sum if
                // x is positive.
                if (curr_sum <= 0 && value > 0)
                {
                    start = end;
                    curr_sum = 0;
                }
                curr_sum += arr[end++];
            }


            // If current sum becomes greater than x.
            while (curr_sum > value && start < n)
            {
                // Update minimum length if needed
                if (end - start < min_len)
                    min_len = end - start;

                // remove starting elements
                curr_sum -= arr[start++];
            }
        }
        return min_len;
    }

}
