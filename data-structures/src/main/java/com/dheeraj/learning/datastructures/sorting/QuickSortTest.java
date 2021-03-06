package com.dheeraj.learning.datastructures.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given
 * array around the picked pivot. There are many different versions of quickSort that pick pivot in different ways.

 Always pick first element as pivot.
 Always pick last element as pivot (implemented below)
 Pick a random element as pivot.
 Pick median as pivot.
 The key process in quickSort is partition(). Target of partitions is, given an array and an element x of array as pivot,
 put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, and put all greater
 elements (greater than x) after x. All this should be done in linear time.
 *
 * Created by dgopali on 10/15/2015.
 */
public class QuickSortTest {
    public static void main(String str[]){
        QuickSortTest sorter = new QuickSortTest();
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(6);
        a.add(2);
        a.add(1);
        a.add(3);
        a.add(5);
        a.add(4);
        //int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        //System.out.println(sorter.sort(a));
        //System.out.println(sorter.sortAsWave(a));
        sorter.quickSort(0,a.size()-1,a);
        System.out.println(a);
    }

    private List<Integer> quickSort(int lowerIndex, int higherIndex, List<Integer> array) {
        if(lowerIndex>higherIndex) return null;
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
        quickSort(lowerIndex, j, array);
        quickSort(i, higherIndex, array);

        return array;
    }

    private void exchangeNumbers(int i, int j, List<Integer> array) {
        int temp = array.get(i);
        array.set(i,array.get(j));
        array.set(j,temp);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //NON-WORKING CODE BELOW
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * This is the one I want to follow alwasys.
     * @param list
     * @param left
     * @param right
     */
    void quickSort(ArrayList<Integer> list, int left, int right){
        if(left>=right)
            return;
        int index = partition(list, left, right);
        quickSortV2(list,left,index-1); //Sort the left list.
        quickSortV2(list,index+1,right);         //Sort the right list.
    }

    public int partition(ArrayList<Integer> list, int left, int right){
        int pivotIndex = left;
        int pivot = list.get(left); //The left most element is the pivot element.
        while (left < right) {    //Ensure that the left and right pointers are not crossed before entering the loop.
            while (list.get(left) <= pivot && left < right) //left pointer should not reach the last element. Definitely it's to be < a[pivot]
                left++; //Increment until a[left] >= a[pivot]
            while (list.get(right) > pivot) //Dont need > first condition as we've used just > symbol. It means atleast it'll stop at the pivot location
                right--;                              //when right==pivot.
            if (left < right) {                       //Swap here if left<right. If left>right we do it outside the loop.
                exchangeNumbers(left, right, list);   //Here we swap expecting there are further elements that need to swapped in this loop itself.
                left++;
                right--;
            }
        }
        exchangeNumbers(pivotIndex, right, list); //If it has come out of the loop, it means, left>=right. So swap with pivot element. Always use right element
        //to swap because after coming out of loop, a[right] will be less than a[pivot]
        return right;
    }

    /**
     *
     * @param list
     * @param first
     * @param last
     */
    void quickSortV2(ArrayList<Integer> list, int first, int last){
        if(first>=last)
            return;
        int pivot = first; //The left most element is the pivot element.
        int i = first+1; // Here you can use first itself and change the condition in line 33 to <= instead of <.
        int j = last;   //From 2nd element to last element we reorder elements based on whether they are greater or lesser than pivot.
        while (i < j) {    //Ensure that the left and right pointers are not crossed before entering the loop.
            while (list.get(i) < list.get(pivot) && i < last) //left pointer should not reach the last element. Definitely it's to be < a[pivot]
                i++; //Increment until a[left] >= a[pivot]
            while (list.get(j) > list.get(pivot)) //Dont need > first condition as we've used just > symbol. It means atleast it'll stop at the pivot location
                j--;                              //when right==pivot.
            if (i < j) {                       //Swap here if left<right. If left>right we do it outside the loop.
                exchangeNumbers(i, j, list);   //Here we swap expecting there are further elements that need to swapped in this loop itself.
                i++;
                j--;
            }
        }
        exchangeNumbers(pivot, j, list); //If it has come out of the loop, it means, left>=right. So swap with pivot element. Always use right element
        //to swap because after coming out of loop, a[right] will be less than a[pivot]
        quickSortV2(list,first+1,j-1); //Sort the left list.
        quickSortV2(list,j+1,last);         //Sort the right list.
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

    public List<Integer> sort(List<Integer> inputArr) {

        if (inputArr == null || inputArr.size() == 0) {
            return null;
        }
        int length = inputArr.size();
        List<Integer> outputArray = quickSort(0, length - 1, inputArr);
        return outputArray;
    }
}
