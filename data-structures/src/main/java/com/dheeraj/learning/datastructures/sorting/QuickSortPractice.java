package com.dheeraj.learning.datastructures.sorting;

import com.dheeraj.learning.utilities.ArrayUtil;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSortPractice {
    int n;

    public static void main(String[] argS) {
        QuickSortPractice obj = new QuickSortPractice();
        //int[] arr = {9,8,7,6,5,4,3,2,1};

        for(int i=0;i<10;i++) {
            int low = (int)(Math.random()*10);
            int high = (int)(10+Math.random()*10);
            int[] arr = ArrayUtil.buildArrayWithRandomNumbers(high-low, low, high, false);
            //int[] arr = {2, 7, 0, 4, 9, 5, 8, 6, 1, 3};

            obj.n = arr.length;
            int[] src = Arrays.copyOf(arr, obj.n);
            System.out.println(Arrays.toString(arr));
            obj.quickSort(arr, 0, obj.n - 1);
            System.out.println(Arrays.toString(arr));
            Arrays.sort(src);
            Assert.assertArrayEquals(src, arr);

            /*QuickSortTest test = new QuickSortTest();
            List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
            System.out.println(list);
            test.sort(list);
            System.out.println(list);
            List<Integer> copy = new ArrayList<>(list);
            Collections.sort(copy);

            Assert.assertTrue(CollectionUtils.isEqualCollection(copy, list));*/
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        if(low>high)
            return;
        int l = low+1;
        int h = high;
        int pivot = arr[low];

        while(l <= h) {
            while (l < n && arr[l] < pivot)
                l++;
            while (h >= 0 && arr[h] > pivot)
                h--;
            if (l < h) {
                swap(arr, l, h);
                l++;
                h--;
            }
        }
        swap(arr, low, h);

        quickSort(arr, low, h-1);
        quickSort(arr, h+1, high);
    }

    public void swap(int[] arr, int src, int dest) {
        int temp = arr[src];
        arr[src] = arr[dest];
        arr[dest] = temp;
    }
}
