package com.dheeraj.learning.datastructures.sorting;

import com.dheeraj.learning.utilities.ListUtility;

import java.util.ArrayList;

/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.

 Example:
 First Pass:
 ( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
 ( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4
 ( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2
 ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.

 Second Pass:
 ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
 ( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
 ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
 ( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )
 Now, the array is already sorted, but our algorithm does not know if it is completed. The algorithm needs one whole pass without any swap to know it is sorted.

 Third Pass:
 ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
 ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
 ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
 ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )

 * Created by dgopali on 10/16/2015.
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        BubbleSortTest bst = new BubbleSortTest();
        ArrayList<Integer> list = ListUtility.buildList("1,2,3,4,5");
        System.out.println(bst.bubbleSort(new ArrayList<>(list)));
        System.out.println(bst.bubbleSortSelf(new ArrayList<>(list)));
    }

    /**
     * This is not bubble sort. We are just taking the largest element to the last.
     *
     * @param list
     * @return
     */
    public ArrayList<Integer> notBubbleSort(ArrayList<Integer> list){
        int iterations=0;
        for(int i=0;i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)>list.get(j)){
                    swap(i,j,list);
                }
                iterations++;
            }
        }
        System.out.println("Iterations : "+iterations);
        return list;
    }

    public ArrayList<Integer> bubbleSort(ArrayList<Integer> list){
        int iterations=0;
        int n=list.size();
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(list.get(j)>list.get(j+1)){
                    swap(j,j+1,list);
                }
                iterations++;
            }
        }
        System.out.println("Iterations : "+iterations);
        return list;
    }

    /**
     * Having an extra flag to identify if the list is already sorted is useful when the list is already sorted or mostly sorted.
     * It just reduces the unnecessary comparisons on a sorted list.
     * @param list
     * @return
     */
    public ArrayList<Integer> bubbleSortSelf(ArrayList<Integer> list){
        int iterations=0;
        int n=list.size();
        boolean swapped;
        for(int i=0;i<n-1;i++){
            swapped=false;
            for(int j=0;j<n-i-1;j++){
                if(list.get(j)>list.get(j+1)){
                    swap(j,j+1,list);
                    swapped=true;
                }
                iterations++;
            }
            if(!swapped)
                break;
        }
        System.out.println("Iterations : "+iterations);
        return list;
    }

    public void swap(int i, int j, ArrayList<Integer> list){
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
}
