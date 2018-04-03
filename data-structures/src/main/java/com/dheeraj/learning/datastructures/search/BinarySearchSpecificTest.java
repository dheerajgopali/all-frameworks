package com.dheeraj.learning.datastructures.search;

import com.dheeraj.learning.utilities.ListUtility;

import java.util.List;

/**
 * Given a sorted array of integers, find the number of occurrences of a given target value.
 Your algorithm’s runtime complexity must be in the order of O(log n).
 If the target is not found in the array, return 0

 **Example : **
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return 2.

 //Modify regular binary search algo. Instead of stopping after finding the element, search for the first occurrence and
 the last occurrence of the same element.
 * Created by dgopali on 10/19/2015.
 */
public class BinarySearchSpecificTest {

    public static void main(String[] args) {
        BinarySearchSpecificTest bsst = new BinarySearchSpecificTest();
        List<Integer> list = ListUtility.buildList("2,2,2,2,5,5,5,6,7,8");
        System.out.println(bsst.findCount(list, 1));
    }

    public int findCount(final List<Integer> a, int b) {
        int firstIndex = binarySearch(a,a.size(),b,true);
        if(firstIndex==-1)
            return 0;
        else{
            int lastIndex = binarySearch(a,a.size(),b,false);
            return lastIndex-firstIndex+1;
        }

    }

    public int binarySearch(List<Integer> a, int n, int x, boolean searchFirst){
        int low=0,high=n-1,result=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(a.get(mid)==x){
                result=mid;
                if(searchFirst)
                    high = mid-1;
                else
                    low = mid+1;
            }else if(x<a.get(mid)) high=mid-1;
            else low=mid+1;
        }
        return result;
    }
}
