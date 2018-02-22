package com.dheeraj.learning.datastructures.sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * I've written the below logic after going through merge sort procedure.
 */
public class MergeSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(15);
        list.add(30);
        list.add(45);
        list.add(12);
        list.add(46);
        System.out.println(list);
        divide(0,3,6, list);
        System.out.println(list);
    }

    public static void divide(int p, int q, int r, ArrayList<Integer> list){
        if(p < q)
            divide(p, p+((q-p)/2), q, list);
        if(q+1 < r)
            divide(q+1, q+1+((r-q-1)/2), r, list);
        sort(p,q,r, list);
    }

    public static void sort(int p, int q, int r, ArrayList<Integer> list) {
        while(p <= q && q+1 <= r) {
            if(list.get(p) > list.get(q+1))
                Collections.swap(list, p, q+1);
            p++;
        }
    }
}
