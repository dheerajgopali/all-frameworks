package com.dheeraj.learning.datastructures.array;

/**
 * Given an array of distinct elements, rearrange the elements of array in zig-zag fashion in O(n) time. The converted array should be in form a < b > c < d > e < f.

 Example:
 Input:  arr[] = {4, 3, 7, 8, 6, 2, 1}
 Output: arr[] = {3, 7, 4, 8, 2, 6, 1}

 Input:  arr[] =  {1, 4, 3, 2}
 Output: arr[] =  {1, 4, 2, 3}
 */
public class ConvertArrayIntoZigZagFashion {
    public static void main(String[] args) {
        int[] arr = {4,3,7,8,6,2,1};
        zigZag(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
    }

    static void zigZag(int[] arr) {
        // Flag true indicates relation "<" is expected,
        // else ">" is expected.  The first expected relation
        // is "<"
        boolean flag = true;

        int temp = 0;

        for (int i = 0; i <= arr.length - 2; i++) {
            if (flag)  /* "<" relation expected */ {
                /* If we have a situation like A > B > C,
                   we get A > B < C by swapping B and C */
                if (arr[i] > arr[i + 1]) {
                    // swap
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }

            } else /* ">" relation expected */ {
                /* If we have a situation like A < B < C,
                   we get A < C > B by swapping B and C */
                if (arr[i] < arr[i + 1]) {
                    // swap
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            flag = !flag; /* flip flag */
        }
    }
}
