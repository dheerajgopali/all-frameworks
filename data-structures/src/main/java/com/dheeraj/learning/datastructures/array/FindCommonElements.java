package com.dheeraj.learning.datastructures.array;

import com.dheeraj.learning.utilities.ListUtility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dgopali on 10/24/2015.
 */
public class FindCommonElements {

    public static void main(String[] args) {
        FindCommonElements fce = new FindCommonElements();
        List<Integer> list1 = ListUtility.buildList("1,3,8,10,13,13,16,16,16,18,21,23,24,31,31,31,33,35,35,37,37,38,40,41,43,47,47,48,48,52,52,53,53,55,56,60,60,61,61,63,63,64,66,67,67,68,69,71,80,80,80,80,80,80,81,85,87,87,88,89,90,94,95,97,98,98,100,101");
        List<Integer> list2 = ListUtility.buildList("5,7,14,14,25,28,28,34,35,38,38,39,46,53,65,67,69,70,78,82,94,94,98");
        System.out.println(fce.intersect(list1,list2));
    }

    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i=0;
        int j=0;
        int len1 = a.size()-1;
        int len2 = b.size()-1;

        while(i<=len1 && j<=len2){
            if(a.get(i).equals(b.get(j))){
                list.add(a.get(i));
                i++;
                j++;
            }else if(a.get(i) < b.get(j)){
                i++;
            }else{
                j++;
            }
        }

        return list;
    }
}
