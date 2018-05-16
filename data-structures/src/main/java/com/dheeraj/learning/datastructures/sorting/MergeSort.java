package com.dheeraj.learning.datastructures.sorting;

import java.util.Arrays;

/**
 * Like QuickSort, Merge Sort is a Divide and Conquer algorithm. It divides input array in two halves, calls itself for the two halves and then merges the two sorted halves. The merge() function is used for merging two halves. The merge(arr, l, m, r) is key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one. See following C implementation for details.

 MergeSort(arr[], l,  r)
 If r > l
 1. Find the middle point to divide the array into two halves:
 middle m = (l+r)/2
 2. Call mergeSort for first half:
 Call mergeSort(arr, l, m)
 3. Call mergeSort for second half:
 Call mergeSort(arr, m+1, r)
 4. Merge the two halves sorted in step 2 and 3:
 Call merge(arr, l, m, r)
 The following diagram from wikipedia shows the complete merge sort process for an example array {38, 27, 43, 3, 9, 82, 10}. If we take a closer look at the diagram, we can see that the array is recursively divided in two halves till the size becomes 1. Once the size becomes 1, the merge processes comes into action and starts merging arrays back till the complete array is merged.


 Time Complexity: Sorting arrays on different machines. Merge Sort is a recursive algorithm and time complexity can be expressed as following recurrence relation.
 T(n) = 2T(n/2) + \Theta(n)
 The above recurrence can be solved either using Recurrence Tree method or Master method. It falls in case II of Master Method and solution of the recurrence is \Theta(nLogn).
 Time complexity of Merge Sort is \Theta(nLogn) in all 3 cases (worst, average and best) as merge sort always divides the array in two halves and take linear time to merge two halves.

 Auxiliary Space: O(n)

 Algorithmic Paradigm: Divide and Conquer

 Sorting In Place: No in a typical implementation

 Stable: Yes

 Applications of Merge Sort

 Merge Sort is useful for sorting linked lists in O(nLogn) time.In case of linked lists the case is different mainly due to difference in memory allocation of arrays and linked lists. Unlike arrays, linked list nodes may not be adjacent in memory. Unlike array, in linked list, we can insert items in the middle in O(1) extra space and O(1) time. Therefore merge operation of merge sort can be implemented without extra space for linked lists.
 In arrays, we can do random access as elements are continuous in memory. Let us say we have an integer (4-byte) array A and let the address of A[0] be x then to access A[i], we can directly access the memory at (x + i*4). Unlike arrays, we can not do random access in linked list. Quick Sort requires a lot of this kind of access. In linked list to access i’th index, we have to travel each and every node from the head to i’th node as we don’t have continuous block of memory. Therefore, the overhead increases for quick sort. Merge sort accesses data sequentially and the need of random access is low.

 Inversion Count Problem
 Used in External Sorting
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int low, int high){
        if(low >= high)
            return;
        int mid = (low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);

        merge(arr, low, mid, high);
    }

    static void merge(int[] arr, int low, int mid, int high){
        //Create two temporary lists.
        int n1 = mid-low+1;
        int n2 = high-mid;

        int[] leftList = new int[n1];
        int[] rightList = new int[n2];

        for (int i = 0; i < n1 ; i++) {
            leftList[i] = arr[low + i];
        }

        for (int i = 0; i < n2; i++) {
            rightList[i] = arr[mid + 1 + i];
        }
        int k=low;
        int l1=0;
        int l2=0;
        while(l1<n1 && l2<n2){
            if(leftList[l1] < rightList[l2])
                arr[k++] = leftList[l1++];
            else
                arr[k++] = rightList[l2++];
        }

        if(l1<n1){
            for (int i = l1; i < n1; i++) {
                arr[k++] = leftList[i];
            }
        }else {
            for (int i = l2; i < n2; i++) {
                arr[k++] = rightList[i];
            }
        }
    }
}
