package com.dheeraj.learning.datastructures.array;

import java.util.Arrays;

/**
 * Pythagorean Triplet in an array
 Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.

 Example:

 Input: arr[] = {3, 1, 4, 6, 5}
 Output: True
 There is a Pythagorean triplet (3, 4, 5).

 Input: arr[] = {10, 4, 6, 12, 5}
 Output: False
 There is no Pythagorean triplet.
 */
public class PythagoreanTriplet {
    public static void main(String[] args) {
        int[] arr = {3,1,4,6,5};
        //int[] arr = {10,4,6,12,5};
        System.out.println(hasPythagoreanTriplet(arr));
        System.out.println(hasPythagoreanTripletV2(arr));
        System.out.println(hasPythagoreanTripletV3(arr));
    }

    /**
     * This is my own algo. This might do unnecessary iterations.
     * @param arr
     * @return
     */
    public static boolean hasPythagoreanTriplet(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n-2; i++) {
            int a = arr[i]*arr[i];
            for (int j = i+1; j < n-1; j++) {
                int b = arr[j]*arr[j];
                for (int k = j+1; k < n; k++) {
                    int c = arr[k]*arr[k];
                    if(a+b == c) {
                        System.out.println(arr[i]+", "+arr[j]+", "+arr[k]);
                        return true;
                    }
                    else if(a+b < c)
                        break;
                }
            }
        }
        return false;
    }

    /**
     * The following logic doesnt work. It is difficult to get the condition on when to increment j or k.
     * check v2 for solution.
     *
     * @param arr
     * @return
     */
    public static boolean hasPythagoreanTripletV2(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n-2; i++) {
            int a = arr[i]*arr[i];
            int j=i+1;
            int k=n-1;
            int b;
            int c;
            while(j<k){
                b=arr[j]*arr[j];
                c=arr[k]*arr[k];
                if(a+b==c){
                    System.out.println(arr[i]+", "+arr[j]+", "+arr[k]);
                    return true;
                }else if(a+b < c)
                    j++;
                else
                    k--;
            }
        }
        return false;
    }

    public static boolean hasPythagoreanTripletV3(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = n-1; i >= 2; i--) { //Here we are iterating i because, we are isolating i and considering as C
            int c = arr[i]*arr[i];       //Then we are cheking for a and b using middle method algorithm. i.e consider two corners and
            int j=0;                     //increment first or decrement last as needed until they reach one another.
            int k=i-1;
            int a;
            int b;
            while(j<k){
                a=arr[j]*arr[j];
                b=arr[k]*arr[k];
                if(a+b==c){
                    System.out.println(arr[j]+", "+arr[k]+", "+arr[i]);
                    return true;
                }else if(a+b < c)
                    j++;
                else
                    k--;
            }
        }
        return false;
    }
}
