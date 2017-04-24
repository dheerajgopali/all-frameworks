package com.dheeraj.learning.datastructures.sorting;

import com.dheeraj.learning.utilities.ListUtility;

import java.util.ArrayList;

/**
 * Created by dgopali on 11/19/2015.
 */
public class CountNumberOfInversions {
    public static void main(String[] args) {
        CountNumberOfInversions obj = new CountNumberOfInversions();
        System.out.println(obj.countInversions(ListUtility.buildList("2,4,1,3,5")));
    }

    public int countInversions(ArrayList<Integer> a) {

        ArrayList<Integer> temp = new ArrayList<Integer>();
        int counter = mergeSort(a, temp, 0, a.size()-1);
        return counter;
    }

    int mergeSort(ArrayList<Integer> arr, ArrayList<Integer> temp, int left, int right)
    {
        int mid, inv_count = 0;
        if (right > left)
        {
            mid = (right + left)/2;

            inv_count  = mergeSort(arr, temp, left, mid);
            inv_count += mergeSort(arr, temp, mid+1, right);

            inv_count += merge(arr, temp, left, mid+1, right);
        }
        return inv_count;
    }

    int merge(ArrayList<Integer> arr, ArrayList<Integer> temp, int left, int mid, int right)
    {
        int i, j, k;
        int inv_count = 0;

        i = left; /* i is index for left subarray*/
        j = mid;  /* i is index for right subarray*/
        k = left; /* i is index for resultant merged subarray*/
        while ((i <= mid - 1) && (j <= right))
        {
            if (arr.get(i) <= arr.get(j))
            {
                temp.add(k++, arr.get(i++));
            }
            else
            {
                temp.add(k++, arr.get(j++));

     /*this is tricky -- see above explanation/diagram for merge()*/
                inv_count = inv_count + (mid - i);
            }
        }

  /* Copy the remaining elements of left subarray
   (if there are any) to temp*/
        while (i <= mid - 1)
            temp.add(k++, arr.get(i++));

  /* Copy the remaining elements of right subarray
   (if there are any) to temp*/
        while (j <= right)
            temp.add(k++, arr.get(j++));

  /*Copy back the merged elements to original array*/
        for (i=left; i <= right; i++)
            arr.set(i, temp.get(i));

        return inv_count;
    }
}