package com.dheeraj.learning.datastructures.search;

import com.dheeraj.learning.utilities.ListUtility;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm’s runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 Example:

 Given [5, 7, 7, 8, 8, 10]

 and target value 8,

 return [3, 4].
 */
public class BinarySearchSpecificTwo {
    public static void main(String[] args) {
        BinarySearchSpecificTwo bsst = new BinarySearchSpecificTwo();
        ArrayList<Integer> list = ListUtility.buildList("5,7,7,8,8,10");
        System.out.println(bsst.searchRange(list, 8));
    }

    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int firstIndex = findIndex(a, b, true);
        if (firstIndex != -1) {
            int lastIndex = findIndex(a, b, false);
            list.add(firstIndex);
            list.add(lastIndex);
        } else {
            list.add(-1);
            list.add(-1);
        }

        return list;
    }

    public int findIndex(List<Integer> a, int b, boolean firstIndex) {
        int low = 0;
        int high = a.size() - 1;

        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (b == a.get(mid)) {
                index = mid;
                if (firstIndex) {
                    if (a.get(mid) == a.get(low)) { //This if else condition is not required. Can directly put high = mid-1;
                        index = low;                //Because anyway current low value will be the mid value for the next iteration.
                        break;
                    } else
                        high = mid - 1;
                } else {
                    if (a.get(mid) == a.get(high)) {
                        index = high;
                        break;
                    } else
                        low = mid + 1;
                }
            } else if (b > a.get(mid))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return index;
    }

    public int findIndexSimplified(List<Integer> a, int b, boolean firstIndex) {
        int low = 0;
        int high = a.size() - 1;

        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (b == a.get(mid)) {
                index = mid;
                if (firstIndex) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (b > a.get(mid))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return index;
    }
}
