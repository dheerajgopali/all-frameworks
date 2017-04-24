package com.dheeraj.learning.datastructures.array;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/30/2015.
 */
public class PowerTest {
    public static void main(String[] args) {
        PowerTest pt = new PowerTest();
        System.out.println(pt.isPower(1024000007));
    }

    public boolean isPower(int n) {
        if (n == 1)
            return true;
        ArrayList<Integer> list = allFactors(n);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 2; j <= Math.sqrt(n); j++) {
                if (Math.pow(list.get(i), j) == n)
                    return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> allFactors(int a) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        int asqrt = (int)Math.sqrt(a);
        for(int i=1;i<=asqrt;i++){
            if(a%i==0){
                list.add(i);
                if(i!=Math.sqrt(a))
                    list2.add(a/i);
            }
        }
        for(int i=list2.size()-1;i>=0;i--){
            list.add(list2.get(i));
        }
        return list;
    }

    public int gcd(int a, int b) {
        if(a==b)
            return a;
        else if(a<b){
            if(b%a==0)
                return a;
            else
                return gcd(a,b-a);
        } else if(a>b){
            if(a%b==0)
                return b;
            else
                return gcd(a-b,b);
        }
        return 0;
    }
}
