package com.dheeraj.learning.datastructures.array;

import com.dheeraj.learning.utilities.ArrayUtil;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/17/2015.
 */
public class ArrayDiagonalTest {
    public static void main(String[] args) {
        ArrayDiagonalTest adt = new ArrayDiagonalTest();
        ArrayList<ArrayList<Integer>> list = ArrayUtil.buildArrayList("1", 1, 1);
        ArrayUtil.displayArray(adt.diagonal(list));
    }

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        int length = a.size();
        int i=0,j=0;
        while(j<length){
            int tempi=i;
            int tempj=j;
            ArrayList<Integer> eachRow = new ArrayList<Integer>();
            while(tempj>=0){
                eachRow.add(a.get(tempi).get(tempj));
                tempi++;
                tempj--;
            }
            list.add(eachRow);
            j++;
        }
        i++;
        j--;
        while(i<length){
            int tempi=i;
            int tempj=j;
            ArrayList<Integer> eachRow = new ArrayList<Integer>();
            while(tempi<length){
                eachRow.add(a.get(tempi).get(tempj));
                tempi++;
                tempj--;
            }
            list.add(eachRow);
            i++;
        }
        return list;
    }
}
