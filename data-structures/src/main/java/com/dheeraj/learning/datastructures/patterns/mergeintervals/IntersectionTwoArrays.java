package com.dheeraj.learning.datastructures.patterns.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionTwoArrays {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length * nums2.length == 0)
            return new int[0];
        List<Integer> res = new ArrayList<>();
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        for(Integer var : set1) {
            if(set2.contains(var))
                res.add(var);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
