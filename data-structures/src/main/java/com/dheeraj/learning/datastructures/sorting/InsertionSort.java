package com.dheeraj.learning.datastructures.sorting;

import com.dheeraj.learning.utilities.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Algorithm
 // Sort an arr[] of size n
 insertionSort(arr, n)
 Loop from i = 1 to n-1.
 ……a) Pick element arr[i] and insert it into sorted sequence arr[0…i-1]

 Info:
 Time Complexity: O(n*n)

 Auxiliary Space: O(1)

 Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order. And it takes minimum time (Order of n) when elements are already sorted.

 Algorithmic Paradigm: Incremental Approach

 Sorting In Place: Yes

 Stable: Yes

 Online: Yes

 Uses: Insertion sort is used when number of elements is small. It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.

 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {12, 11, 13, 5, 6};
        sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * The method I've written on my own from scratch.
     * @param arr
     */
    static void insertionSort(int[] arr) {
        int n=arr.length;
        for(int i=1;i<n;i++){
            for (int j = 0; j < i; j++) {
                if(arr[i] < arr[j]){
                    int temp = arr[i];
                    shift(arr, j, i-1);
                    arr[j] = temp;
                    break;
                }
            }
        }
    }

    static void shift(int[] arr, int i, int j) {
        for (int k = j; k >= i; k--) { //Be careful with this logic. Since we are shifting to the right, we do it from right to left.
            arr[k+1] = arr[k];             // i.e decreasing order. Loop will start from right and decreasing its value by one.
        }
    }

    /**
     * The one from geekforgeeks.
     *
     * @param arr
     */
    static void sort(int arr[])
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }
}
