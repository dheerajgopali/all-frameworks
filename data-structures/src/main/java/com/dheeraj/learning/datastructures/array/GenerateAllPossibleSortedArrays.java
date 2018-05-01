package com.dheeraj.learning.datastructures.array;

import java.util.ArrayList;

/**
 * Generate all possible sorted arrays from alternate elements of two given sorted arrays
 Given two sorted arrays A and B, generate all possible arrays such that first element is taken from A then from B then from A and so on in increasing order till the arrays exhausted. The generated arrays should end with an element from B.

 For Example
 A = {10, 15, 25}
 B = {1, 5, 20, 30}

 The resulting arrays are:
 10 20
 10 20 25 30
 10 30
 15 20
 15 20 25 30
 15 30
 25 30
 */
public class GenerateAllPossibleSortedArrays {
    public static void main(String[] args) {
        int[] arrA = {10,15, 25};
        int[] arrB = {1, 5, 20,30};
        ArrayList<Integer> currentPart = new ArrayList<>();
        ArrayList<ArrayList<Integer>> superList = new ArrayList<>();
        methodA(arrA, arrB, currentPart, superList, 0, 0);
        for (ArrayList<Integer> list :
                superList) {
            for (Integer i :
                    list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    /**
     * This is the method I've composed completely from scratch
     *
     * Idea is loop over the elements of A. Add the element to current list if current element in A is less than last element in temporary list.
     * Then call method B. Here give i+1 as aIndex so that next time when methodA is called, we start from i+1 instead of i. This reduces unnecessary comparisons.
     * Then remove the current element and iterate further to see if the next elements satisfy the less than condition too.
     * @param arrA
     * @param arrB
     * @param currentPart
     * @param superList
     * @param aIndex
     * @param bIndex
     */
    public static void methodA(int[] arrA, int[] arrB, ArrayList<Integer> currentPart, ArrayList<ArrayList<Integer>> superList, int aIndex, int bIndex) {
        for(int i=aIndex; i < arrA.length ; i++) {
            if(currentPart.isEmpty() || currentPart.get(currentPart.size()-1) < arrA[i]) {
                currentPart.add(arrA[i]);
                methodB(arrA, arrB, currentPart, superList, i+1, bIndex);
                currentPart.remove(currentPart.size()-1);
            }
        }
    }

    /**
     * * This is the method I've composed completely from scratch
     * The logic here is same as methodA except that whenever an element is found satisfying the less than condition, add it to the superlist.
     * Beware that if you add the list ( i.e., currentPart) directly to superList, it'll be treated as reference and gets modified throughout the program.
     * So we've created a new ArrayList and added it.
     * @param arrA
     * @param arrB
     * @param currentPart
     * @param superList
     * @param aIndex
     * @param bIndex
     */
    public static void methodB(int[] arrA, int[] arrB, ArrayList<Integer> currentPart, ArrayList<ArrayList<Integer>> superList, int aIndex, int bIndex) {
        for(int i=bIndex; i < arrB.length ; i++) {
            if(currentPart.get(currentPart.size()-1) < arrB[i]) {
                currentPart.add(arrB[i]);
                superList.add(new ArrayList<Integer>(currentPart));
                methodA(arrA, arrB, currentPart, superList, aIndex, i+1);
                currentPart.remove(currentPart.size()-1);
            }
        }
    }
}
