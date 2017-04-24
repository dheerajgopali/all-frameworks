package com.dheeraj.learning.datastructures.sorting;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/16/2015.
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        BubbleSortTest bst = new BubbleSortTest();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(2);
        System.out.println(bst.bubbleSort(list));
    }

    public ArrayList<Integer> bubbleSort(ArrayList<Integer> list){
        for(int i=0;i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)<list.get(j)){
                    swap(i,j,list);
                }
            }
        }
        return list;
    }

    public void swap(int i, int j, ArrayList<Integer> list){
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
}
