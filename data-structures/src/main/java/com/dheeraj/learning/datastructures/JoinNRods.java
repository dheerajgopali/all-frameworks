package com.dheeraj.learning.datastructures;

/**
 * Created by gopad on 24-05-2017.
 */
public class JoinNRods {
    //Create an index array
    //Sort index array based on original array
    //Add the minimum value with adjacent least rod and update the value.
    public static void main(String[] args) {
        System.out.println(calculateMinimumEffort(3, new Integer[]{10,35,5}));
    }

    public static int calculateMinimumEffort(int n, Integer[] array){
        int flag=-1;
        int currentTotal = 0;
        int sum=0;
        while(flag==-1) {
            for (int i = 0; i < n; i++) {
                int index = findLeast(array);
                int adjacentIndex = findAdjacentLeast(array, index);

                if(adjacentIndex== -1) {//This condition identifies if there is only one value in the array left;
                    flag = 0;
                    break;
                }
                //previousSum = sum;
                sum = array[index] + array[adjacentIndex];
                currentTotal += sum;
                array[index] = sum;
                array[adjacentIndex] = -1;
            }
        }

        //return the only element in the array;
        printArray(array);
        return currentTotal;
    }

    public static int findLeast(Integer[] array){
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0;i<array.length;i++){
            if(minValue > array[i] && array[i]!=-1){
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int findAdjacentLeast(Integer[] array, int index){
        int leftIndex=-1;
        int rightIndex=-1;
        for(int i=index-1;i>=0;i--){
            if(array[i]!=-1){
                leftIndex=i;
                break;
            }
        }

        for(int i=index+1;i<array.length;i++){
            if(array[i]!=-1){
                rightIndex=i;
                break;
            }
        }

        if(leftIndex == -1)
            return rightIndex;
        else if(rightIndex == -1)
            return leftIndex;
        else{
            if(array[leftIndex] < array[rightIndex])
                return leftIndex;
            else
                return rightIndex;
        }
    }

    public static int getOnlyElementInArray(Integer[] array){
        for (int i = 0; i < array.length ; i++) {
            if(array[i]!=-1)
                return array[i];
        }
        return -1;
    }

    public static void printArray(Integer[] array){
        for(int i=0;i<array.length;i++){
            System.out.println("index : "+i+", value : "+array[i]);
        }
    }
}