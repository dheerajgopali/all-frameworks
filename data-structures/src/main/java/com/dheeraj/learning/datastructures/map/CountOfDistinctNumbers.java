package com.dheeraj.learning.datastructures.map;


import com.dheeraj.learning.utilities.ListUtility;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dgopali on 11/17/2015.
 */
public class CountOfDistinctNumbers {
    public static void main(String[] args) {
        CountOfDistinctNumbers obj = new CountOfDistinctNumbers();
        System.out.println(obj.dNums(ListUtility.buildList("1,2,1,3,4,3"),3));
    }

    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> resList = new ArrayList<Integer>();
        if(B>A.size())
            return resList;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int len = A.size();
        int k = 0;
        for(int i=0;i<B;i++){
            if(map.keySet().contains(A.get(i))) {
                map.put(A.get(i),map.get(A.get(i))+1);
            }else{
                map.put(A.get(i),1);
            }
        }
        resList.add(map.size());
        for (int i=B;i<len;i++){
            int tempIndex = i-B;
            if(map.get(A.get(tempIndex)) > 1){
                map.put(A.get(tempIndex),map.get(A.get(tempIndex))-1);
            }else{
                map.remove(A.get(tempIndex));
            }
            if(map.keySet().contains(A.get(i))){
                map.put(A.get(i),map.get(A.get(i))+1);
            }else{
                map.put(A.get(i),1);
            }
            resList.add(map.size());
        }
        return resList;
    }
}