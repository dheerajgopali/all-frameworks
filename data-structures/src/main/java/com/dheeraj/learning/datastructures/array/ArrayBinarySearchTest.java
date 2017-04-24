package com.dheeraj.learning.datastructures.array;

import com.dheeraj.learning.utilities.ArrayUtil;

import java.util.ArrayList;

/**
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
