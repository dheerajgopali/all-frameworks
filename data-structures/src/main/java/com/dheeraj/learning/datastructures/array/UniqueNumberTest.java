package com.dheeraj.learning.datastructures.array;


import com.dheeraj.learning.utilities.ListUtility;

import java.util.HashMap;
import java.util.List;

/**
 * Created by dgopali on 10/22/2015.
 */
public class UniqueNumberTest {
    public static void main(String[] args) {
        UniqueNumberTest unt = new UniqueNumberTest();
        System.out.println(unt.singleNumber(ListUtility.buildList("1,1,2,100000,2,3,3")));
        System.out.println(unt.singleNumberUsingXOR(ListUtility.buildList("1,1,2,100000,2,3,3")));

    }

    public int singleNumber(final List<Integer> a) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<a.size();i++){
            if(map.get(a.get(i)) == null)
                map.put(a.get(i),1);
            else{
                map.put(a.get(i), map.get(a.get(i))+1);
            }
        }
        for(Integer integer : map.keySet()){
            if(map.get(integer) == 1)
                return integer;
        }
        return -1;
    }

    public int singleNumberUsingXOR(final List<Integer> a){
        int temp = 0;
        for(int i=0;i<a.size();i++){
            temp = temp ^ a.get(i);
        }

        return temp;
    }
}
