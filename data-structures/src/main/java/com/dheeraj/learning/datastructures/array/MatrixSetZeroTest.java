package com.dheeraj.learning.datastructures.array;

import com.dheeraj.learning.utilities.ArrayUtil;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/18/2015.
 */
public class MatrixSetZeroTest {
    public static void main(String[] args) {
        MatrixSetZeroTest mszt = new MatrixSetZeroTest();
        ArrayList<ArrayList<Integer>> list = ArrayUtil.buildArrayList("1,0,1,1,1,1,1,1,1", 3, 3);
        ArrayUtil.displayArray(list);
        mszt.setZeroes(list);
        ArrayUtil.displayArray(list);
    }

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        if(a.size()==1)
            return;
        int M = a.size();
        int N = a.get(0).size();
        ArrayList<Integer> rowList = new ArrayList<Integer>();
        ArrayList<Integer> colList = new ArrayList<Integer>();
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(a.get(i).get(j)==0){
                    rowList.add(i);
                    break;
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(a.get(j).get(i)==0){
                    colList.add(i);
                    break;
                }
            }
        }
        for(Integer val : rowList){
            for(int i=0;i<N;i++){
                a.get(val).set(i,0);
            }
        }
        for(Integer val : colList){
            for(int i=0;i<M;i++){
                a.get(i).set(val,0);
            }
        }
    }
}
