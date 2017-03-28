package com.dheeraj.learning.datastructures.recursive;

import com.dheeraj.learning.utilities.ListUtility;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by dgopali on 10/31/2015.
 */
public class GetAllPermutations {
    public static void main(String[] args) {
        GetAllPermutations getAllPermutations = new GetAllPermutations();
        System.out.println(getAllPermutations.permuteDuplicates(new ArrayList<Integer>(ListUtility.buildList("1,1,2"))));
    }

    public ArrayList<ArrayList<Integer>> permuteDuplicates(ArrayList<Integer> a) {
        HashSet<ArrayList<Integer>> list = permuteDuplicates(a, a.size() - 1);
        return new ArrayList<ArrayList<Integer>>(list);
    }

    public HashSet<ArrayList<Integer>> permuteDuplicates(ArrayList<Integer> a, int n) {
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        if(n==0){
            ArrayList<Integer> rowList = new ArrayList<Integer>();
            rowList.add(a.get(n));
            set.add(rowList);
            return set;
        }
        HashSet<ArrayList<Integer>> tempList = permuteDuplicates(a, n - 1);
        for(ArrayList<Integer> interList : tempList){
            ArrayList<ArrayList<Integer>> temp = getAllPermutations(interList, a.get(n));
            set.addAll(temp);
        }
        return set;
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> list = permute(a,a.size()-1);
        return list;
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a, int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(n==0){
            ArrayList<Integer> rowList = new ArrayList<Integer>();
            rowList.add(a.get(n));
            list.add(rowList);
            return list;
        }
        ArrayList<ArrayList<Integer>> tempList = permute(a,n-1);
        for(int i=0;i<tempList.size();i++){
            ArrayList<ArrayList<Integer>> temp = getAllPermutations(tempList.get(i), a.get(n));
            list.addAll(temp);
        }
        return list;
    }

    public ArrayList<ArrayList<Integer>> getAllPermutations(ArrayList<Integer> tempList, Integer integer){
        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        int len = tempList.size();
        int k = 0;
        ArrayList<Integer> tempFirst = new ArrayList<Integer>();
        tempFirst.add(integer);
        tempFirst.addAll(tempList.subList(0,len));
        resList.add(tempFirst);
        k++;
        while(k<len){
            ArrayList<Integer> tempMiddle = new ArrayList<Integer>();
            tempMiddle.addAll(tempList.subList(0,k));
            tempMiddle.add(integer);
            tempMiddle.addAll(tempList.subList(k, len));
            resList.add(tempMiddle);
            k++;
        }
        ArrayList<Integer> tempLast = new ArrayList<Integer>();
        tempLast.addAll(tempList.subList(0, len));
        tempLast.add(integer);
        resList.add(tempLast);

        return resList;
    }
}
