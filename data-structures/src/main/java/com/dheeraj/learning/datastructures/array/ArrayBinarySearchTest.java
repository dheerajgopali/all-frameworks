package com.dheeraj.learning.datastructures.array;

import com.dheeraj.learning.utilities.ArrayUtil;

import java.util.ArrayList;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.

 This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than or equal to the last integer of the previous row.
 Example:

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return 1 ( 1 corresponds to true )

 Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem

 Algo :
 Get the row index by just modifying regular binary search tree algo.
 Instead of checking if an element equals, we check if here if the searchfor ele is in between current row first and last values
 while(low<=high)
    mid = (low+high)/2;
    if(key >= A[mid][0] and key <= a[mid][noOfColumns])
        //Search horizontally like regular binary search in this row.
    else key < A[mid][0]
        high = mid - 1;
    else
        low = mid + 1;

 Takeaway : Identifying which row to search is important part of this question. Since the elements in the rows are sorted,
 we could compare with last element to know if that is the row we want. Otherwise we might have needed lot of conditions.
 * Created by dgopali on 10/19/2015.
 */
public class ArrayBinarySearchTest {
    public static void main(String[] args) {
        ArrayBinarySearchTest abst = new ArrayBinarySearchTest();
        ArrayList<ArrayList<Integer>> list = ArrayUtil.buildArrayList("1,10,10,20",2,2);
        ArrayUtil.displayArray(list);
        System.out.println(abst.searchMatrix(list,10));
    }

    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int rowIndex = binarySearchI(a,b);
        if(rowIndex == -1){
            return 0;
        }else{
            return binarySearch(a.get(rowIndex),b);
        }
    }

    public int binarySearch(ArrayList<Integer> a, int b){
        int M = a.size();
        int low = 0;
        int high = M-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(a.get(mid)==b){
                return 1;
            }else if(b<a.get(mid)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return 0;
    }

    public int binarySearchI(ArrayList<ArrayList<Integer>> a, int b){
        int M = a.size();
        int N = a.get(0).size();
        int low = 0;
        int high = M-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(a.get(mid).get(0)<=b && b<=a.get(mid).get(N-1)){
                return mid;
            }else if(b<a.get(mid).get(0)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
}
