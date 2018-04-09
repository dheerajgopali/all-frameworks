package com.dheeraj.learning.datastructures.search;

import com.dheeraj.learning.utilities.ListUtility;

import java.util.List;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).
 * <p>
 * You are given a target value to search. If found in the array, return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Input : [4 5 6 7 0 1 2] and target = 4
 * Output : 0
 * <p>
 * NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
 * <p>
 * Algorithm:
 * Find the min element in the list. refer {@link BinarySearchRotatedList}
 * Then first binary search before minimum index part of the list
 * if not found search later minumum index part part of the list
 */
public class BinarySearchSpecificThree {
    public static void main(String[] args) {
        BinarySearchSpecificThree bsst = new BinarySearchSpecificThree();
        List<Integer> list = ListUtility.buildList("4,5,6,7,0,1,2");
        System.out.println(bsst.search(list, 4));
        System.out.println(bsst.searchSimpler(list, 7));
    }

    /**
     * This code looks simpler but the entire logic is aptly put in a short piece of code.
     *
     * @param a
     * @param b
     * @return
     */
    public int searchSimpler(final List<Integer> a, int b){
        int low=0;
        int high=a.size()-1;

        while(low<=high) {
            int mid = (low +high)/2;

            if(a.get(mid)==b)
                return mid;
            if(a.get(mid)>=a.get(low)) { // To check if the list from low to mid is sorted.
                if(b>=a.get(low)&&b<a.get(mid)) //Since low to mid is sorted, check if b is in between low and mid.
                    high=mid-1;
                else //Since b is not between low and mid, check right part of the list.
                    low=mid+1;
            }
            else { //This means low to mid is not sorted or there is pivot element in this.
                if(b>a.get(mid)&&b<=a.get(high)) //Since pivot is between low and mid now, search right part if b > mid and b < high.
                    low=mid+1;
                else //If it is not in the right part, it has to be in the left part.
                    high=mid-1;
            }
        }
        return -1;
    }

    public int search(final List<Integer> a, int b) {
        int pivotIndex = findMin(a);
        int low = 0;
        int high = a.size() - 1;
        if (pivotIndex == 0)
            return binarySearchRecursive(a, pivotIndex, high, b);
        else if (pivotIndex == high && b == a.get(pivotIndex))
            return pivotIndex;
        else {
            if (b < a.get(0)) {
                return binarySearchRecursive(a, pivotIndex, high, b);
            } else {
                return binarySearchRecursive(a, 0, pivotIndex - 1, b);
            }
        }
    }

    public int binarySearchRecursive(List<Integer> a, int low, int high, int ele) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (ele == a.get(mid))
            return mid;
        else if (ele < a.get(mid))
            return binarySearchRecursive(a, low, mid - 1, ele);
        else
            return binarySearchRecursive(a, mid + 1, high, ele);
    }

    /**
     * Refer {@link BinarySearchRotatedList} for explanation of this method
     * @param a
     * @return
     */
    public int findMin(final List<Integer> a) {
        int low = 0;
        int high = a.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a.get(low) <= a.get(high))
                return low;
            else if (a.get(mid) <= a.get(mid - 1) && a.get(mid) <= a.get(mid + 1))
                return mid;
            else if (a.get(mid) <= a.get(high))
                high = mid - 1;
            else if (a.get(mid) >= a.get(low))
                low = mid + 1;
        }
        return -1;
    }
}
