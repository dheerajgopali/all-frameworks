package com.dheeraj.learning.datastructures.array;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/15/2015.
 */
public class DigitSumTest {
    public static void main(String[] args) {
        DigitSumTest dst = new DigitSumTest();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(6);
        list.add(5);
        //1, 1, 1, 3, 2, 1, 1, 2, 5, 9, 6, 5
        System.out.println(dst.plusOne(list));
    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        int previousCarry = 0;
        boolean previousNine = true;
        for (int i = a.size() - 1; i >= 0; i--) {
            if (a.get(i) == 9 && previousNine) {
                a.set(i, 0);
                previousCarry = 1;
            } else {
                previousNine = false;
                if (i == a.size() - 1)
                    a.set(i, a.get(i) + 1);
                else
                    a.set(i, a.get(i) + previousCarry);
                previousCarry = 0;
            }
        }
        return removePrecedingZeros(a, previousCarry);
    }

    public ArrayList<Integer> removePrecedingZeros(ArrayList<Integer> a, int previousCarry) {
        ArrayList<Integer> newList = new ArrayList<Integer>();
        if (previousCarry == 1) {
            newList.add(1);
        }
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == 0 && newList.size() == 0)
                continue;
            newList.add(a.get(i));
        }

        return newList;
    }
}
