package com.dheeraj.learning.utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dgopali on 10/17/2015.
 */
public class ListUtility {

    public static void main(String[] args) {
        System.out.println(buildList("10,20"));
    }

    public static ArrayList<Integer> buildList(String str){
        String[] list = str.split(",");
        ArrayList<Integer> intList = new ArrayList<Integer>();
        int length=list.length;
        for(int i=0;i<length;i++){
            intList.add(Integer.parseInt(list[i]));
        }
        return intList;
    }
}
