package com.dheeraj.learning.datastructures.array;

/**
 * Find the smallest positive integer value that cannot be represented as sum of any subset of a given array
 Given a sorted array (sorted in non-decreasing order) of positive numbers, find the smallest positive integer value that cannot be represented as sum of elements of any subset of given set.
 Expected time complexity is O(n).

 Examples:

 Input:  arr[] = {1, 3, 6, 10, 11, 15};
 Output: 2

 Input:  arr[] = {1, 1, 1, 1};
 Output: 5

 Input:  arr[] = {1, 1, 3, 4};
 Output: 10

 Input:  arr[] = {1, 2, 5, 10, 20, 40};
 Output: 4

 Input:  arr[] = {1, 2, 3, 4, 5, 6};
 Output: 22

 This program is very simple. It just looks so complex but it is very simple.
 //Yet to check the algorithm for this se
 */
public class SmallestPositiveIntegerValue {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 10, 11, 15};
        System.out.println(findSmallest(arr, arr.length));
    }

    static int findSmallest(int arr[], int n)
    {
        int res = 1; // Initialize result

        // Traverse the array and increment 'res' if arr[i] is
        // smaller than or equal to 'res'.
        for (int i = 0; i < n && arr[i] <= res; i++)
            res = res + arr[i];

        return res;
    }
}
