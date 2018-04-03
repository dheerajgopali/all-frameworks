package com.dheeraj.learning.datastructures.search;


import com.dheeraj.learning.utilities.ListUtility;

import java.util.List;

/**
 * Suppose a sorted array A is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array will not contain duplicates.

 NOTE 1: Also think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*

 Algo : The below algo doesn't work if there are duplicates
 Case 1 : when a[low] < a[high]
        retur low
 case 2 : when a[mid] <= a[(mid + N -1)%N] or a[mid] >= a[(mid + 1)%N] //Since this is a rotating array, need to use modular division
        return mid
 case 3 : when a[low]<= a[mid]
            low = mid + 1
 case 4 : when a[mid] <= a[high]
            high = mid - 1;
 *
 */
public class BinarySearchRotatedList {
    public static void main(String[] args) {
        BinarySearchRotatedList bsrt = new BinarySearchRotatedList();
        List<Integer> list = ListUtility.buildList("194,195,196,197,198,199,201,203,204,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,23,24,25,26,27,29,30,31,32,33,34,35,36,37,39,40,42,43,44,45,47,48,49,50,51,52,53,54,55,57,58,59,60,61,63,65,66,68,69,70,71,73,74,76,77,79,80,81,82,83,84,86,87,88,89,91,92,93,94,95,97,98,99,101,103,104,105,106,107,108,109,110,113,114,115,117,118,120,121,122,123,124,127,128,130,131,133,134,135,136,137,139,140,141,142,143,144,146,147,148,149,150,151,152,153,154,155,158,159,160,161,162,163,164,166,167,169,170,171,172,174,175,177,178,179,181,182,184,185,187,189,190,192,193");
        System.out.println(bsrt.search(list, 1));
    }

    public int search(final List<Integer> a, int b) {
        int pivotIndex = findMin(a);
        int low=0;
        int high=a.size()-1;
        if(pivotIndex == 0)
            return binarySearchRecursive(a,pivotIndex,high,b);
        else if(pivotIndex == high && b == a.get(pivotIndex))
            return pivotIndex;
        else{
            if(b < a.get(0)){
                return binarySearchRecursive(a,pivotIndex,high,b);
            }else{
                return binarySearchRecursive(a,0,pivotIndex-1,b);
            }
        }
    }

    public int binarySearchRecursive(List<Integer> a, int low, int high, int ele){
        if(low>high)
            return -1;
        int mid=(low+high)/2;
        if(ele == a.get(mid))
            return mid;
        else if(ele < a.get(mid))
            return binarySearchRecursive(a,low,mid-1,ele);
        else
            return binarySearchRecursive(a,mid+1,high,ele);
    }

    public int findMin(final List<Integer> a) {
        int low=0;
        int high=a.size()-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(a.get(low)<=a.get(high))
                return low;
            else if(a.get(mid)<=a.get(mid-1) && a.get(mid)<=a.get(mid+1))
                return mid;
            else if(a.get(mid)<=a.get(high))
                high = mid-1;
            else if(a.get(mid)>=a.get(low))
                low = mid+1;
        }
        return -1;
    }
}
