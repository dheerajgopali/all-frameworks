package com.dheeraj.learning.datastructures;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/18/2015.
 */
public class FactorsTest {
    public static void main(String[] args) {
        FactorsTest ft = new FactorsTest();
        System.out.println(ft.allFactors(38808));
        //System.out.println(6==Math.sqrt(38808));
    }

    public ArrayList<Integer> allFactors(int a) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        int asqrt = (int)Math.sqrt(a);
        for(int i=1;i<=asqrt;i++){
            if(a%i==0){
                list.add(i);
                if(i!=Math.sqrt(a))
                    list2.add(a/i);
            }
        }
        for(int i=list2.size()-1;i>=0;i--){
            list.add(list2.get(i));
        }
        return list;
    }
}
