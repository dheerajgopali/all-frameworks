package com.dheeraj.learning.datastructures.sorting;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/15/2015.
 */
public class QuickSortTest {
    public static void main(String str[]){
        QuickSortTest sorter = new QuickSortTest();
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(4);
        a.add(3);
        a.add(2);
        a.add(1);
        a.add(-1);
        a.add(-2);
        a.add(-4);
        //int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        System.out.println(sorter.sort(a));
        //System.out.println(sorter.sortAsWave(a));

    }

    public ArrayList<Integer> sortAsWave(ArrayList<Integer> array){
        boolean isAscending = false;
        for(int i=0;i<array.size() - 1; i++){
            if(array.get(i) < array.get(i+1) && !isAscending){
                exchangeNumbers(i,i+1,array);
            } else if(array.get(i) > array.get(i+1) && isAscending){
                exchangeNumbers(i,i+1,array);
            }
            isAscending = !isAscending;
        }
        return array;
    }

    public ArrayList<Integer> sort(ArrayList<Integer> inputArr) {

        if (inputArr == null || inputArr.size() == 0) {
            return null;
        }
        int length = inputArr.size();
        ArrayList<Integer> outputArray = quickSort(0, length - 1, inputArr);
        return outputArray;
    }

    private ArrayList<Integer> quickSort(int lowerIndex, int higherIndex, ArrayList<Integer> array) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array.get(lowerIndex+(higherIndex-lowerIndex)/2);
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array.get(i) < pivot) {
                i++;
            }
            while (array.get(j) > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j, array);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j, array);
        if (i < higherIndex)
            quickSort(i, higherIndex, array);

        return array;
    }

    private void exchangeNumbers(int i, int j, ArrayList<Integer> array) {
        int temp = array.get(i);
        array.set(i,array.get(j));
        array.set(j,temp);
    }
}
