package com.dheeraj.learning.utilities.comparator;

import java.util.Comparator;
import java.util.List;

/**
 * Created by dgopali on 10/30/2015.
 */
public class ListOfInteger implements Comparator<List<Integer>> {
    public int compare(List<Integer> a, List<Integer> b) {
        int an = a.size();
        int bn = b.size();
        for (int i = 0; i < Math.min(an, bn); i++) {
            int cmp = a.get(i).compareTo(b.get(i));
            if (cmp != 0)
                return cmp;
        }
        return a.size() < b.size()?-1:1;
    }
}
