package com.dheeraj.learning.datastructures.array;

import com.dheeraj.learning.utilities.ListUtility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by dgopali on 10/24/2015.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates rd= new RemoveDuplicates();
        System.out.println(rd.removeDuplicates(new ArrayList<Integer>(ListUtility.buildList("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3"))));
    }

    public int removeDuplicatesStandard(ArrayList<Integer> a) {
        int len = a.size();
        Iterator<Integer> it = a.iterator();
        it.remove();
        ListIterator<Integer> lit = a.listIterator();

        for(int i=0;i<len-1;i++){
            if(a.get(i).equals(a.get(i + 1))){
                a.remove(i + 1);
                i--;
                len--;
            }
        }
        return len;
    }

    public int removeDuplicates(ArrayList<Integer> a) {
        int len = a.size();
        for(int i=0;i<len-1;i++){
            int counter=0;
            int index = i;
            while(i<len-1 && a.get(i).equals(a.get(i+1))){
                i++;
                counter++;
            }
            if(counter>0){
                arrayShift(a,index+1,counter);
                len = len-counter;
                i = index;
            }
        }
        return len;
    }

    public void arrayShift(ArrayList<Integer> a,int index,int noOfElements){
        for(int i=index;(i+noOfElements)<a.size();i++){
            a.set(i,a.get(i+noOfElements));
        }
        int len = a.size();
        for(int i=len-noOfElements;i<len;i++){
            a.remove(i);
            i--;
            len--;
        }
    }
}
