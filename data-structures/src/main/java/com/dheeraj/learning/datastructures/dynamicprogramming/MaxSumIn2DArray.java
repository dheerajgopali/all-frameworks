package com.dheeraj.learning.datastructures.dynamicprogramming;

import java.util.ArrayList;

/**
 * Created by dgopali on 11/25/2015.
 */
public class MaxSumIn2DArray {
    public static void main(String[] args) {
        MaxSumIn2DArray obj = new MaxSumIn2DArray();
    }

    public int maxSum2(ArrayList<ArrayList<Integer>> a){
        int N = a.get(0).size();
        int MAXSUM2[][] = new int[N+1][2];
        for(int i=0;i<MAXSUM2.length;i++){
            for(int j=0;j<MAXSUM2[0].length;j++){
                MAXSUM2[i][j] = 0;
            }
        }
        int ele = Math.max(a.get(0).get(0), a.get(1).get(0));
        MAXSUM2[0][1] = ele;

        for (int i = 1; i < N; i++)
        {
            int cur_element = Math.max(a.get(0).get(i), a.get(1).get(i));
            MAXSUM2[i][0] = Math.max(MAXSUM2[i-1][0], MAXSUM2[i-1][1]);
            MAXSUM2[i][1] = cur_element + MAXSUM2[i-1][0];
        }
        return Math.max(MAXSUM2[N-1][0], MAXSUM2[N-1][1]);
    }

    ////////Approach that didnt work
    int[][] MAXSUM;
    public int adjacent(ArrayList<ArrayList<Integer>> a) {
        ArrayList<Integer>  resList = new ArrayList<Integer>();
        MAXSUM = new int[2][a.get(0).size()];
        for(int i=0;i<MAXSUM.length;i++){
            for(int j=0;j<MAXSUM[0].length;j++){
                MAXSUM[i][j] = -1;
            }
        }
        for(int i=0 ; i<a.get(0).size() ; i++){
            resList.add(Math.max(a.get(0).get(i),a.get(1).get(i)));
        }
        int max1 = maxSum(resList, resList.size()-1, false);
        int max2 = maxSum(resList, resList.size()-1, true);
        return Math.max(max1,max2);
    }

    public int maxSum(ArrayList<Integer> a, int pos, boolean includeCurrentEle){
        int sum = 0;
        if(pos < 0)
            return 0;
        if(!includeCurrentEle){
            if(pos == 0){
                return 0;
            }
            if(MAXSUM[0][pos-1] == -1)
                MAXSUM[0][pos-1] = maxSum(a, pos - 1, false);
            if(MAXSUM[1][pos-1] == -1)
                MAXSUM[1][pos-1] = maxSum(a, pos - 1, true);
            sum += Math.max(MAXSUM[0][pos-1], MAXSUM[1][pos-1]);
            return sum;
        }
        else{
            if(pos == 0){
                return a.get(pos);
            }
            if(MAXSUM[0][pos-1] == -1)
                MAXSUM[0][pos-1] = maxSum(a, pos - 1, false);
            sum += MAXSUM[0][pos-1] + a.get(pos);
            return sum;
        }
    }
}