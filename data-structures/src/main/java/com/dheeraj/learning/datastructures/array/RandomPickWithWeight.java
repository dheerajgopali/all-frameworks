package com.dheeraj.learning.datastructures.array;

import java.util.Map;
import java.util.TreeMap;

public class RandomPickWithWeight {
    public static void main(String[] args) {
        int[] arr = {3,14,1,7};
        RandomPickWithWeight w = new RandomPickWithWeight();
        w.solution(arr);
        for(int i=0;i<10000;i++) {
            System.out.print(w.pickIndex()+", ");
        }
    }

    int total;
    int[] w;
    TreeMap<Double, Integer> map;
    public void solution(int[] w) {
        this.w=w;
        double sum = 0;
        map = new TreeMap<>();
        for(int i=0;i<w.length;i++) {
            sum += w[i];
        }
        map.put(0.0, 0);
        double curSum = 0;
        int i;
        for(i=0;i<w.length-1;i++) {
            curSum += w[i];
            map.put(curSum/sum, null);
            map.put(curSum/sum+0.000001,i+1);
        }
        map.put((curSum+w[i])/sum, null);
    }

    private Integer mappedValue(TreeMap<Double, Integer> map, Double key) {
        Map.Entry<Double, Integer> e = map.floorEntry(key);
        if (e != null && e.getValue() == null) {
            e = map.lowerEntry(key);
        }
        return e == null ? null : e.getValue();
    }

    public int pickIndex() {
        double random = Math.random();
        return mappedValue(map, random);
    }
}

class Solution {


}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */