package com.dheeraj.learning.datastructures.array;

import com.dheeraj.learning.utilities.ArrayUtil;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/17/2015.
 */
public class ArraySpiralTraversal {
    public static void main(String[] args) {
        ArraySpiralTraversal ast = new ArraySpiralTraversal();
        //ArrayList<ArrayList<Integer>> list = ArrayUtil.buildArray("1,2,3,4,5,6,7,8,9", 3, 3);
        ArrayUtil.displayArray(ast.getArray(4));
    }

    public ArrayList<ArrayList<Integer>> getArray(int a){
        ArrayList<ArrayList<Integer>> list = getArrayListInitializedWithZeros(a); //new ArrayList<ArrayList<Integer>>();
        int k=1,top=0,bottom=a-1,left=0,right=a-1;
        while(top<=bottom && left<=right){
            //RIGHT
            for(int i=left;i<=right;i++){
                list.get(top).set(i,k++);

            }
            top++;
            //DOWN
            for(int i=top;i<=bottom;i++){
                list.get(i).set(right,k++);
            }
            right--;
            //LEFT
            for(int i=right;i>=left;i--){
                list.get(bottom).set(i,k++);

            }
            bottom--;
            //UP
            for(int i=bottom;i>=top;i--){
                list.get(i).set(left,k++);

            }
            left++;
        }
        return list;
    }

    public ArrayList<ArrayList<Integer>> getArrayListInitializedWithZeros(int a){
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<a;i++){
            ArrayList<Integer> eachRow = new ArrayList<Integer>();
            for(int j=0;j<a;j++){
                eachRow.add(0);
            }
            list.add(eachRow);
        }
        return list;
    }
}
