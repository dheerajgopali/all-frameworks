package com.dheeraj.learning.datastructures.array;

import com.dg.af.utilities.ListUtility;

import java.util.ArrayList;

/**
 * Created by dgopali on 11/26/2015.
 */
public class FindSmallestPositiveNumber {
    public static void main(String[] args) {
        FindSmallestPositiveNumber obj = new FindSmallestPositiveNumber();
        System.out.println(obj.firstMissingPositive(new ArrayList<Integer>(ListUtility.buildList("-8,-7,-6"))));
    }
    public int firstMissingPositive(ArrayList<Integer> A) {
        int n = A.size();

        for (int i = 0; i < n; i++) {
            while (A.get(i) != i + 1) {
                if (A.get(i) <= 0 || A.get(i) >= n)
                    break;

                if(A.get(i)==A.get(A.get(i)-1))
                    break;

                int temp = A.get(i);
                A.set(i, A.get(temp - 1));
                A.set(temp - 1, temp);
            }
        }

        for (int i = 0; i < n; i++){
            if (A.get(i) != i + 1){
                return i + 1;
            }
        }

        return n + 1;
    }
}