package com.dheeraj.learning.datastructures;

import com.dheeraj.learning.utilities.ListUtility;

import java.util.*;

/**
 * Created by dgopali on 11/3/2015.
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        System.out.println(obj.twoSum(ListUtility.buildList("4,7,-4,2,2,2,3,-5,-3,9,-4,9,-7,7,-1,9,9,4,1,-4,-2,3,-3,-5,4,-7,7,9,-4,4,-8"),-3));
    }

    public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
        ArrayList<Integer> finalList = new ArrayList<Integer>();
        ArrayList<Integer> tempList = new ArrayList<Integer>(a);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int low = 0;
        int high = tempList.size()-1;
        int currentLow = Integer.MAX_VALUE;
        int currentHigh = Integer.MAX_VALUE;
        boolean isSolutionExist = false;

        Collections.sort(tempList);

        while(low<high){
            long sum = (long)tempList.get(low)+(long)tempList.get(high);
            if(sum<b){
                low++;
            }else if(sum>b){
                high--;
            }else if(sum == b){
                isSolutionExist = true;
                map.put(high,low);
                low++;
            }
        }

        for(Integer key : map.keySet()){
            if(a.indexOf(tempList.get(key)) > a.indexOf(tempList.get(map.get(key)))){
                int tempLow = a.indexOf(tempList.get(map.get(key)));
                int tempHigh = getHighIndex(a, tempLow, tempList.get(key));
                if(tempHigh < currentHigh) {
                    currentHigh = tempHigh;
                    currentLow = tempLow;
                }
                else if (tempHigh == currentHigh){
                    if(tempLow < currentLow){
                        currentLow = tempLow;
                    }
                }
            }else{
                int tempLow = a.indexOf(tempList.get(key));
                int tempHigh = getHighIndex(a, tempLow, tempList.get(map.get(key)));
                if(tempHigh < currentHigh) {
                    currentHigh = tempHigh;
                    currentLow = tempLow;
                }
                else if (tempHigh == currentHigh){
                    if(tempLow < currentLow){
                        currentLow = tempLow;
                    }
                }
            }
        }

        if(isSolutionExist){
            finalList.add(currentLow + 1);
            finalList.add(currentHigh + 1);
        }

        return finalList;
    }

    public int getHighIndex(List<Integer> list, int minIdex, int ele){
        for(int i=minIdex+1;i<list.size();i++){
            if(list.get(i).equals(ele)){
                return i;
            }
        }

        return -1;
    }

    public ArrayList<Integer> twoSumV2(final List<Integer> a, int b) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> copyList = new ArrayList<Integer>(a);
        int low = 0;
        int high = a.size()-1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int currentLow = Integer.MAX_VALUE;
        int currentHigh = Integer.MAX_VALUE;
        Collections.sort(a);
        boolean isSolutionExist = false;
        while(low<high){
            long sum = (long)a.get(low)+(long)a.get(high);
            if(sum<b){
                low++;
            }else if(sum>b){
                high--;
            }else if(sum == b){
                isSolutionExist = true;
                map.put(high,low);
                low++;
            }
        }

        for(Integer key : map.keySet()){
            if(copyList.indexOf(a.get(key)) > copyList.indexOf(a.get(map.get(key)))){
                int tempLow = copyList.indexOf(a.get(map.get(key)));
                int tempHigh = getOriginalIndexV2(copyList, tempLow, a.get(key));
                if(tempHigh < currentHigh) {
                    currentHigh = tempHigh;
                    currentLow = tempLow;
                }
                else if (tempHigh == currentHigh){
                    if(tempLow < currentLow){
                        currentLow = tempLow;
                    }
                }
            }else{
                int tempLow = copyList.indexOf(a.get(key));
                int tempHigh = getOriginalIndexV2(copyList, tempLow, a.get(map.get(key)));
                if(tempHigh < currentHigh) {
                    currentHigh = tempHigh;
                    currentLow = tempLow;
                }
                else if (tempHigh == currentHigh){
                    if(tempLow < currentLow){
                        currentLow = tempLow;
                    }
                }
            }
        }

        if(isSolutionExist){
            list.add(currentLow+1);
            list.add(currentHigh+1);
        }

        return list;
    }

    public int getOriginalIndexV2(ArrayList<Integer> list, int minIdex, int ele){
        for(int i=minIdex+1;i<list.size();i++){
            if(list.get(i).equals(ele)){
                return i;
            }
        }

        return -1;
    }
}