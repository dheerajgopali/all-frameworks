package com.dheeraj.learning.datastructures;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/17/2015.
 */
public class PascalTriangleTest {
    public static void main(String[] args) {
        PascalTriangleTest ptt = new PascalTriangleTest();
        for(int i=0;i<5;i++)
                System.out.println(ptt.getRow(i));
    }

    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> list = getPascalRow(a);
        return list;
    }

    public ArrayList<Integer> getPascalRow(int a){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(a==0){
            list.add(1);
            return list;
        }else if (a==1){
            list.add(1);
            list.add(1);
            return list;
        }

        list.add(1);
        //Actual recursive logic
        ArrayList<Integer> previousList = getPascalRow(a-1);
        for(int i=0;i<a-1;i++){
            list.add(previousList.get(i)+previousList.get(i+1));
        }
        list.add(1);
        return list;
    }
}
