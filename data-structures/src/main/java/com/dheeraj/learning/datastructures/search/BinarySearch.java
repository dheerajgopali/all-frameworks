package com.dheeraj.learning.datastructures.search;

import com.dheeraj.learning.utilities.ListUtility;

import java.util.List;

/**
 * This is basic binary search implementation.
 * Binary search always assumes that the array is sorted.
 */
public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> list = ListUtility.buildList("1,2,3,4,5,6,7,8,10,20,30,40,50");
        System.out.println(list);
        System.out.println(binarySearchRecursive(list, 100, 0, list.size()-1));
        System.out.println(binarySearchIterative(list, 100, 0, list.size()-1));
    }

    /**
     * No need of third if condition.
     * @param list
     * @param searchFor
     * @param low
     * @param high
     * @return
     */
    public static int binarySearchRecursive(List<Integer> list, int searchFor, int low, int high) {
        int mid = (low + high)/2;
        if(low<=high) {
            if (list.get(mid) == searchFor)
                return mid;
            else if (list.get(mid) < searchFor) //If element is greater than the mid, then search in the left part of the list
                return binarySearchRecursive(list, searchFor, mid + 1, high);
            else // If the element is smaller than the mid. then search in the right part of the list.
                return binarySearchRecursive(list, searchFor, low, mid - 1);
        }
        return -1;
    }

    /**
     * Make sure to calculate mid value inside the while loop
     * @param list
     * @param searchFor
     * @param low
     * @param high
     * @return
     */
    public static int binarySearchIterative(List<Integer> list, int searchFor, int low, int high) {
        while(low <= high) {
            int mid = (low + high)/2;
            if(list.get(mid) == searchFor)
                return mid;
            else if(list.get(mid) < searchFor)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
