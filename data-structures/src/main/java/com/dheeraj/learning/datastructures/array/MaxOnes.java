package com.dheeraj.learning.datastructures.array;

import com.dheeraj.learning.utilities.ListUtility;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/25/2015.
 */
public class MaxOnes {
    public static void main(String[] args) {
        MaxOnes mo = new MaxOnes();
        System.out.println(mo.maxone(new ArrayList<Integer>(ListUtility.buildList("1,1,1,0,1,1,1,0")),2));
    }

    public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
        int wL = 0, wR = 0;
        int nZero = 0;
        int bestWindowWidth = -1;
        int bestWR = 0;
        int bestWL = 0;
        while(wR < a.size()){
            if (nZero <= b){
                if (wR < a.size() && a.get(wR).equals(0)) nZero++;
                wR++;
            }

            if (nZero > b){
                if (wL < a.size() && a.get(wL).equals(0)) nZero--;
                wL++;
            }

            if (wR - wL > bestWindowWidth){
                bestWindowWidth = wR - wL;
                bestWR = wR-1;
                bestWL = wL;
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=bestWL;i<=bestWR;i++){
            list.add(i);
        }
        return list;
    }
}
