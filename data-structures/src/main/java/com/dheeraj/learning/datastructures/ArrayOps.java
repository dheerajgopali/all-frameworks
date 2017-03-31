package com.dheeraj.learning.datastructures;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/14/2015.
 */
public class ArrayOps {
    public static void main(String[] args) {
        ArrayOps ops = new ArrayOps();
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println(Integer.MAX_VALUE + " " + Integer.MIN_VALUE);
        list.add(-1469348094);
        list.add(1036140795);
        list.add(2140651434);
        list.add(-317097467);
        list.add(1376710097);
        list.add(1330573317);
        list.add(1687926652);
        //-1469348094, 1036140795, 2040651434, -317097467, 1376710097, 1330573317, 1687926652
                                                //2147483648
        //336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421
        // [ -846930886, -1714636915, 424238335, -1649760492 ]
        System.out.println(ops.maxset2(list));
    }

    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        int newArrayIndex = 0;
        ArrayList<ArrayList<Integer>> newList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Long> maxDetails = new ArrayList<Long>();
        boolean previousNegative=false;
        long sum = 0;
        boolean allnegative = true;
        for(int i=0 ; i < a.size() ; i++){
            if(a.get(i) < 0){ //Negative numbers
                previousNegative=true;
                continue;
            } else {
                allnegative = false;
                if (previousNegative) {
                    previousNegative = false;
                    if (newList.size() != 0) {
                        //maxDetails.add(sum);
                        sum = 0;
                        newArrayIndex++;
                    }
                }

                if (newArrayIndex == newList.size()) {
                    //Create a list
                    ArrayList<Integer> tempSubList = new ArrayList<Integer>();
                    newList.add(tempSubList);
                }
                newList.get(newArrayIndex).add(a.get(i));
                sum = sum + a.get(i);
            }
        }
        if(allnegative){
            return new ArrayList<Integer>();
        }
        for(int i=0;i<newList.size();i++){
            ArrayList<Integer> list = newList.get(i);
            sum = 0;
            for(int j=0;j<list.size();j++){
                sum = sum+list.get(j);
            }
            maxDetails.add(sum);
        }
        /*if(!previousNegative)
            maxDetails.add(sum);*/
        ArrayList<Integer> temp2 = getMaxIndexes(maxDetails);
        if(temp2.size()>1){ //Have duplicates
            ArrayList<Integer> temp3 = getLongerArrays(newList, temp2);
            return newList.get(temp3.get(0));
        }else{
            return newList.get(temp2.get(0));
        }
    }

    public ArrayList<Integer> getLongerArrays(ArrayList<ArrayList<Integer>> newList, ArrayList<Integer> temp2){
        int max=0;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i=0 ; i< temp2.size();i++){
            if(max < newList.get(i).size()){
                max = newList.get(i).size();
            }
        }
        for(int i=0 ; i< temp2.size();i++){
            if(max == newList.get(i).size()){
                temp.add(i);
            }
        }
        return temp;
    }

    public ArrayList<Integer> getMaxIndexes(ArrayList<Long> list){
        Long max=Long.MIN_VALUE;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i=0 ; i< list.size();i++){
            if(max < list.get(i)){
                max = list.get(i);
            }
        }
        for(int i=0 ; i< list.size();i++){
            if(max == list.get(i)){
                temp.add(i);
            }
        }
        return temp;
    }

    public ArrayList<Integer> maxset2(ArrayList<Integer> a) {
        long maxSum = 0;
        long newSum = 0;
        ArrayList<Integer> maxArray = new ArrayList<Integer>();
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (Integer i : a) {
            if (i >= 0) {
                newSum += i;
                newArray.add(i);
            } else {
                newSum = 0;
                newArray = new ArrayList<Integer>();
            }
            if ((maxSum < newSum) || ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
                maxSum = newSum;
                maxArray = newArray;
            }
        }
        return maxArray;
    }
}
