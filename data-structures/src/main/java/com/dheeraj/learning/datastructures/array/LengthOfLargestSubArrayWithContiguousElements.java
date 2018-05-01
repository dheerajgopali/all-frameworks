package com.dheeraj.learning.datastructures.array;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

/**
 * Length of the largest subarray with contiguous elements | Set 1
 Given an array of distinct integers, find length of the longest subarray which contains numbers that can be arranged in a continuous sequence.

 Examples:

 Input:  arr[] = {10, 12, 11};
 Output: Length of the longest contiguous subarray is 3

 Input:  arr[] = {14, 12, 11, 20}; //Even if 15,16 is added in the end to this list, 14 cant be considered to for 14,15,16. Because of their positions.
 Output: Length of the longest contiguous subarray is 2

 Input:  arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
 Output: Length of the longest contiguous subarray is 5

 Sorting is not a solution as the positions is important here.
 The important thing to note in question is, it is given that all elements are distinct. If all elements are distinct,
 then a subarray has contiguous elements if and only if the difference between maximum and minimum elements in subarray is
 equal to the difference between last and first indexes of subarray. So the idea is to keep track of minimum and maximum element in every subarray.
 */
public class LengthOfLargestSubArrayWithContiguousElements {
    public static void main(String[] args) {
        int arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
        System.out.println(findLength(arr));
    }

    public static int findLength(int[] arr){
        int noOfIterations = 0;
        int n=arr.length;
        int max_len = 1;  // Initialize result
        for (int i = 0; i < n - 1; i++)
        {
            // Initialize min and max for all subarrays starting with i
            int mn = arr[i], mx = arr[i];

            // Consider all subarrays starting with i and ending with j
            for (int j = i + 1; j < n; j++)
            {
                // Update min and max in this subarray if needed
                mn = min(mn, arr[j]);
                mx = max(mx, arr[j]);

                /*if((mx-mn)>n){            //This works. I've added this logic to reduce the number of iterations. Just removed for easy understanding.
                    noOfIterations++;       //If the difference of max and min is greater than the length of the array, we can't find contiguous subarray.
                    break;                  ///Any subarray which contains current elements i and j will not be a valid contiguous subarray.
                }*/

                // If current subarray has all contiguous elements
                if ((mx - mn) == j - i)
                    max_len = max(max_len, mx - mn + 1);
                noOfIterations++;
            }
        }
        System.out.println("Number of iterations : "+noOfIterations);
        return max_len;
    }
}
