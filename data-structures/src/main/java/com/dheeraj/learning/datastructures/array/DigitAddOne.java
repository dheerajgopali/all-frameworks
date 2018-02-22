package com.dheeraj.learning.datastructures.array;

import java.util.ArrayList;
import java.util.List;

public class DigitAddOne {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(2);
        list.add(4);

        int temp = addDigit(list, 0, list.size());
        if(temp!=0)
            list.add(0, temp);

        System.out.println(list);
    }

    public static int addDigit(List<Integer> list, int index, int size) {
        if(index==size-1) {
            if(list.get(index)==9){
                list.set(index,0);
                return 1;
            }else {
                list.set(index, list.get(index)+1);
                return 0;
            }
        } else {

            int temp=0;
            temp = addDigit(list, index+1, size);
            if(list.get(index) + temp > 9){
                list.set(index,0);
                return 1;
            }else if (temp == 1){
                list.set(index, list.get(index)+1);
                return 0;
            }else
                return 0;
        }
    }
}
