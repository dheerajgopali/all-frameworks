package com.dheeraj.learning.datastructures.dynamicprogramming;

import com.dheeraj.learning.utilities.ArrayUtil;
import com.dheeraj.learning.utilities.ListUtility;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;
import java.util.List;

/**
 * Find minimum number of coins that make a given value
 Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?

 Examples:

 Input: coins[] = {25, 10, 5}, V = 30
 Output: Minimum 2 coins required
 We can use one coin of 25 cents and one of 5 cents

 Input: coins[] = {9, 6, 5, 1}, V = 11
 Output: Minimum 2 coins required
 We can use one coin of 6 cents and 1 coin of 5 cents

 Algo :
 1.Substract a coin from total and find minimum number of coins required for the rest.
 2.You store the result into an array as the same value you end up computing again and again

 */
public class MinNoOfCoins {
    static int temp = 0;
    public static void main(String[] args) {
        List<Integer> list = ListUtility.buildList("9,6,5,1");
        int value = 35;
        Integer[] table = new Integer[value+1];
        table[0]=0;
        for(int i=1;i<=value;i++)
            table[i]=Integer.MAX_VALUE;
        System.out.println(basicFindRecursive(list,list.size(),value));//17=6+6+5
        System.out.println(temp);
        temp=0;
        System.out.println(findRecursiveDynamicProgram(list,list.size(),value, table));//17=6+6+5
        System.out.println(temp);
        //35 -- 27 + 6 + 1 + 1, 18 + 6 + 6 + 5
        /*for (int i = 0; i <= value; i++) {
            System.out.println("Minimum number required for "+i+" is :"+ table[i]+", ");
        }*/


        temp=0;
        System.out.println(findIterativeDynamicProgram(list,list.size(),value));//17=6+6+5
        System.out.println(temp);

    }

    public static int basicFindRecursive(List<Integer> coins, int noOfCoins, int value){
        temp++;
        if(value == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < noOfCoins; i++) {
            if(coins.get(i) <= value){
                int subres = basicFindRecursive(coins, noOfCoins, value-coins.get(i));
                if(subres!=Integer.MAX_VALUE && subres + 1 < res)
                    res = subres + 1;
            }
        }
        return res;
    }

    public static int findRecursiveDynamicProgram(List<Integer> coins, int noOfCoins, int value, Integer[] table){
        temp++;
        if(table[value]!=Integer.MAX_VALUE)
            return table[value];

        for (int i = 0; i < noOfCoins; i++) {
            if(coins.get(i) <= value){
                int subres = (table[value-coins.get(i)]==Integer.MAX_VALUE)?findRecursiveDynamicProgram(coins, noOfCoins, value-coins.get(i), table):table[value-coins.get(i)];
                if(subres!=Integer.MAX_VALUE && subres + 1 < table[value])
                    table[value] = subres + 1;
            }
        }
        return table[value];
    }

    public static int findIterativeDynamicProgram(List<Integer> coins, int noOfCoins, int value)
    {
        // table[i] will be storing
        // the minimum number of coins
        // required for i value. So
        // table[V] will have result
        int table[] = new int[value + 1];

        // Base case (If given value V is 0)
        table[0] = 0;

        // Initialize all table values as Infinite
        for (int i = 1; i <= value; i++)
            table[i] = Integer.MAX_VALUE;

        // Compute minimum coins required for all
        // values from 1 to V
        for (int i = 1; i <= value; i++)
        {
            // Go through all coins smaller than i
            for (int j = 0; j < noOfCoins; j++) {
                if (coins.get(j) <= i) {
                    int sub_res = table[i - coins.get(j)];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;


                }
                temp++;
            }

        }
        return table[value];

    }
}
