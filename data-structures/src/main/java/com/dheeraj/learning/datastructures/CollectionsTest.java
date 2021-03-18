package com.dheeraj.learning.datastructures;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("20","2","3","9","5","4");
        System.out.println(list);
        Collections.sort(list.subList(1,list.size()));
        System.out.println(list);
    }
}
