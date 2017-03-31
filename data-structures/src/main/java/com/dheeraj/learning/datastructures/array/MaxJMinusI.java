package com.dheeraj.learning.datastructures.array;

import com.dheeraj.learning.utilities.ListUtility;

import java.util.List;

/**
 * Created by dgopali on 10/25/2015.
 */
public class MaxJMinusI {
    public static void main(String[] args) {
        MaxJMinusI mji = new MaxJMinusI();
        System.out.println(mji.maximumGap2(ListUtility.buildList("3,3,3,5,5,5,5")));
    }

    public int maximumGap(final List<Integer> a) {
        int max = -1;
        boolean flag = false;
        for(int i=0;i<a.size();i++){
            for(int j=i+1;j<a.size();j++){
                if(a.get(i)<=a.get(j)){
                    if(j-i > max) {
                        flag = true;
                        max = j - i;
                    }
                }
            }
        }

        return flag?max:0;
    }

    //approach 2
    public int maximumGap2(final List<Integer> a) {
        if(a.size()==1)
            return 0;
        //If descending
        int k=0;
        for(;k<a.size()-1;k++){
            if(a.get(k)<=a.get(k+1))
                break;
        }
        if(k==a.size()-1){
            return 0;
        }

        int maxDiff;
        int i, j;
        int n = a.size();
        int[] LMin = new int[n];
        int[] RMax = new int[n];

   /* Construct LMin[] such that LMin[i] stores the minimum value
       from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = a.get(0);
        for (i = 1; i < n; ++i)
            LMin[i] = min(a.get(i), LMin[i-1]);

    /* Construct RMax[] such that RMax[j] stores the maximum value
       from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n-1] = a.get(n-1);
        for (j = n-2; j >= 0; --j)
            RMax[j] = max(a.get(j), RMax[j+1]);

    /* Traverse both arrays from left to right to find optimum j - i
        This process is similar to merge() of MergeSort */
        i = 0; j = 0; maxDiff = -1;
        while (j < n && i < n)
        {
            if (LMin[i] <= RMax[j])
            {
                maxDiff = max(maxDiff, j-i);
                j = j + 1;
            }
            else
                i = i+1;
        }

        return maxDiff;
    }

    int max(int x, int y)
    {
        return x > y? x : y;
    }

    int min(int x, int y)
    {
        return x < y? x : y;
    }
}
