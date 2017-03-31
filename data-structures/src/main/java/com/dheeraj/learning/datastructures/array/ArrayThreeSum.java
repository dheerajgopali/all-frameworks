package com.dheeraj.learning.datastructures.array;

import com.dheeraj.learning.utilities.ListUtility;

import java.util.*;

/**
 * Created by dgopali on 10/23/2015.
 */
public class ArrayThreeSum {
    public static void main(String[] args) {
        ArrayThreeSum ats = new ArrayThreeSum();
        List<Integer> list = ListUtility.buildList("1,-4,0,0,5,-5,1,0,-2,4,-4,1,-1,-4,3,4,-1,-1,-3");
        System.out.println(ats.threeSum(new ArrayList<Integer>(list)));
        //System.out.println(ats.threeSumClosest(new ArrayList<Integer>(list), 6));
    }

    public ArrayList<ArrayList<Integer>> threeSumStandard(ArrayList<Integer> a) {
        /*HashSet<Integer> set = new HashSet<Integer>(array);
        ArrayList<Integer> a = new ArrayList<Integer>(set);*/
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<a.size()-2;i++){
            int l=i+1;
            int r=a.size()-1;
            while(l<r){
                long sum = a.get(i)+a.get(l)+a.get(r);
                if(sum == 0 && i!=l && l!=r && r!=i){
                    ArrayList<Integer> row = new ArrayList<Integer>();
                    row.add(a.get(i));
                    row.add(a.get(l));
                    row.add(a.get(r));
                    if(!list.contains(row));
                        list.add(row);
                    l++;
                }else if(sum < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return list;
    }

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<a.size()-2;){
            int l=i+1;
            int r=a.size()-1;
            while(l<r){
                long sum = a.get(i)+a.get(l)+a.get(r);
                if(sum == 0 ){
                    if(i!=l && l!=r && r!=i){
                    ArrayList<Integer> row = new ArrayList<Integer>();
                    row.add(a.get(i));
                    row.add(a.get(l));
                    row.add(a.get(r));
                    list.add(row);
                    }
                    int ele = a.get(l);
                    while(a.get(l)==ele)
                        l++;
                }else if(sum < 0){
                    int ele = a.get(l);
                    while(a.get(l)==ele)
                        l++;
                }else {
                    int ele = a.get(r);
                    while(a.get(r)==ele)
                        r--;
                }
            }
            int ele = a.get(i);
            while(a.get(i)==ele)
                i++;
        }
        return list;
    }

    public int threeSumClosest(ArrayList<Integer> a, int target) {
        int minTarget = Integer.MIN_VALUE;
        boolean maxBool = false;
        int maxTarget = Integer.MAX_VALUE;
        boolean minBool = false;
        a = sort(a);
        for(int i=0;i<a.size()-2;i++){
            int l=i+1;
            int r=a.size()-1;
            while(l<r){
                int sum = a.get(i)+a.get(l)+a.get(r);
                if(sum > target && sum < maxTarget) {
                    maxTarget = sum;
                    maxBool=true;
                }
                if(sum < target && sum > minTarget) {
                    minTarget = sum;
                    minBool = true;
                }
                if(sum == target){
                    return sum;
                }else if(sum < target){
                    l++;
                }else{
                    r--;
                }
            }
        }
        if (maxBool && !minBool){
            return maxTarget;
        }else if(minBool && !maxBool){
            return minTarget;
        }else if(maxBool && minBool){
            int diff1 = target - maxTarget;
            int diff2 = target - minTarget;
            if(Math.abs(diff1) > Math.abs(diff2)){
                return minTarget;
            }else{
                return maxTarget;
            }
        }
        return  -1;
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
