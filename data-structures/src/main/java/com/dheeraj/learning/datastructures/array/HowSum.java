package com.dheeraj.learning.datastructures.array;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=oBt53YbR9Kk&t=5813s
 * Dynamic Programming - Learn to Solve Algorithmic Problems & Coding Challenges
 */
public class HowSum {
    public static void main(String[] args) {
        int[] arr = {7,14};
        HowSum hs = new HowSum();
        long startTime = System.currentTimeMillis();        
        System.out.println(hs.howSum(arr, 300));
        long endTime = System.currentTimeMillis();
        System.out.println("Total time in millis: "+(endTime-startTime));

        startTime = System.currentTimeMillis();
        System.out.println(hs.howSumWithDP(arr, 300, new HashMap<>()));
        endTime = System.currentTimeMillis();
        System.out.println("Total time in millis: "+(endTime-startTime));

    }

    public List<Integer> howSumWithDP(int[] arr, int target, HashMap<Integer, List<Integer>> map) {
        if(map.containsKey(target)) {
            return map.get(target);
        }
        if(target==0) {
            return new ArrayList<>();
        } else if(target < 0) {
            return null;
        }

        for (int j : arr) {            
            List<Integer> res = howSumWithDP(arr, target - j, map);

            if (res != null) {
                res.add(j);
                map.put(target, res);
                return res;
            }
        }

        map.put(target, null);
        return null;
    }
    
    public List<Integer> howSum(int[] arr, int target) {
        if(target==0) {
            return new ArrayList<>();
        } else if(target < 0) {
            return null;
        }

        for (int j : arr) {
            List<Integer> res = howSum(arr, target - j);
            if (res != null) {
                res.add(j);
                return res;
            }
        }

        return null;
    }
}
