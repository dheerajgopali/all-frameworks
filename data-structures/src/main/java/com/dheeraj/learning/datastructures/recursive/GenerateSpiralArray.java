package com.dheeraj.learning.datastructures.recursive;


import com.dheeraj.learning.utilities.ArrayUtil;

import java.util.ArrayList;

/**
 * Created by dgopali on 11/1/2015.
 */
public class GenerateSpiralArray {
    public static void main(String[] args) {
        GenerateSpiralArray gsa = new GenerateSpiralArray();
        for(int i=1;i<=10;i++)
            ArrayUtil.displayArray(gsa.prettyPrint(i));
    }
    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        ArrayList<ArrayList<Integer>> list = prettyPrintRecursive(a);
        return list;
    }

    public ArrayList<ArrayList<Integer>> prettyPrintRecursive(int n){
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(n==1){
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            tempList.add(n);
            list.add(tempList);
            return list;
        }
        ArrayList<ArrayList<Integer>> tempList = prettyPrintRecursive(n-1);
        ArrayList<Integer> topList = new ArrayList<Integer>();
        for(int i=0;i<(2*n-1);i++){
            topList.add(n);
        }
        list.add(topList);


        for(int i=0;i<(2*n-3);i++){
            ArrayList<Integer> middleList = new ArrayList<Integer>();
            middleList.add(n);
            middleList.addAll(tempList.get(i));
            middleList.add(n);
            list.add(middleList);
        }

        ArrayList<Integer> bottomList = new ArrayList<Integer>();
        for(int i=0;i<(2*n-1);i++){
            bottomList.add(n);
        }
        list.add(bottomList);

        return list;
    }
}
