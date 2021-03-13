package com.dheeraj.learning.datastructures.search;

import com.dheeraj.learning.utilities.ListUtility;

import java.util.Arrays;
import java.util.List;

/**
 * If the searched element not found, return the probable location of the element;
 */
public class BinarySearchSpecificThree {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,7,8,10,20,30,40,50};
        BinarySearchSpecificThree obj = new BinarySearchSpecificThree();
        System.out.println(obj.binarySearchJavaStandard(nums, 0, nums.length, 1));
        System.out.println(Arrays.binarySearch(nums, 0, nums.length, 1));
    }

    private int binarySearch(int[] nums, int startIndex, int target) {
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * Same as Arrays.binarySearch()..
     *
     * @param nums
     * @param start
     * @param end
     * @param key
     * @return
     */
    public int binarySearchJavaStandard(int[] nums, int start, int end, int key) {
        while(start < end) {
            int mid = (start+end)/2;
            int midValue = nums[mid];
            if(midValue == key) {
                return mid;
            } else if(midValue < key) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -(start+1); //Added +1 here to handle If the insertion point is 0. -0 doesn't notify that key not found.
    }
}
