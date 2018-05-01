package com.dheeraj.learning.datastructures;

import java.util.Arrays;

/**
 * Count triplets with sum smaller than a given value
 Given an array of distinct integers and a sum value. Find count of triplets with sum smaller than given sum value. Expected Time Complexity is O(n2).

 Examples:

 Input : arr[] = {-2, 0, 1, 3}
 sum = 2.
 Output : 2
 Explanation :  Below are triplets with sum less than 2
 (-2, 0, 1) and (-2, 0, 3)

 Input : arr[] = {5, 1, 3, 4, 7}
 sum = 12.
 Output : 4
 Explanation :  Below are triplets with sum less than 4
 (1, 3, 4), (1, 3, 5), (1, 3, 7) and
 (1, 4, 5)
 */
public class CountTripletsWithSumSmallerToGivenValue {
    static int countOfTriplets=0;
    public static void main(String[] args) {
        //Integer[] arr = {-2, 0, 1, 3};
        Integer[] arr = {5, 1, 3, 4, 7};
        int[] arr2 = {5, 1, 3, 4, 7};
        System.out.println(countTriplets(arr, 0, 12, arr.length, 0, 0));
        //System.out.println(countTripletsV2(arr, 0, 12, arr.length, 0, 0, 0));
        System.out.println(countOfTriplets);

        System.out.println(countTripletsV2(arr2, 5, 12));
    }

    /**
     * Couldnt use countOfTriplets as a parameter. Logic didnt work out like that.
     * This is self made logic for this program.
     * @param arr
     * @param sum
     * @param value
     * @param length
     * @param counter
     * @param start
     * @return
     */
    public static int countTriplets(Integer[] arr, int sum, int value, int length, int counter, int start){
        if(counter==3){
            if(sum < value) {
                return 1;
            }else
                return 0;
        }

        for(int i=start;i<length;i++){
            int temp = countTriplets(arr, sum + arr[i], value, length, ++counter, i+1);
            if(temp == 1){
                countOfTriplets++;
            }
            --counter;
        }

        return 0;
    }

    /**
     * Easiest and efficient solution
     *
     * An Efficient Solution can count triplets in O(n2) by sorting the array first, and then using method 1 of this post in a loop.

     1) Sort the input array in increasing order.
     2) Initialize result as 0.
     3) Run a loop from i = 0 to n-2.  An iteration of this loop finds all
     triplets with arr[i] as first element.
     a) Initialize other two elements as corner elements of subarray
     arr[i+1..n-1], i.e., j = i+1 and k = n-1
     b) Move j and k toward each other until they meet, i.e., while (j < k)
     (i) if (arr[i] + arr[j] + arr[k] >= sum), then do k--

     // Else for current i and j, there can (k-j) possible third elements
     // that satisfy the constraint.
     (ii) Else Do ans += (k - j) followed by j++

     */
    public static int countTripletsV2(int[] arr, int n, int sum){
        // Sort input array
        Arrays.sort(arr);

        // Initialize result
        int ans = 0;

        // Every iteration of loop counts triplet with
        // first element as arr[i].
        for (int i = 0; i < n - 2; i++)
        {
            // Initialize other two elements as corner elements
            // of subarray arr[j+1..k]
            int j = i + 1, k = n - 1;

            // Use Meet in the Middle concept
            while (j < k)
            {
                // If sum of current triplet is more or equal,
                // move right corner to look for smaller values
                // This means all the elements in between i and j also satisfy this condition.
                if (arr[i] + arr[j] + arr[k] >= sum)
                    k--;

                    // Else move left corner
                else
                {
                    // This is important. For current i and j, there
                    // can be total k-j third elements.
                    ans += (k - j);
                    j++; // Current j element is done. Go to next j element and
                }
            }
        }
        return ans;
    }
}
