package com.dheeraj.learning.datastructures;

/**
 * Created by dgopali on 10/19/2015.
 */
public class MathsCalculations {
    public static void main(String[] args) {
        MathsCalculations mc = new MathsCalculations();
        System.out.println(mc.pow(79161127,99046373,57263970));
        //System.out.println(-12%10);
    }

    public int pow(int x, int y, int z) {
        return power(x,y)%z;
    }

    public int power(int x, int n) {
        if(n == 0)
            return 1;
        else if(n==1)
            return x;
        else if(n%2==0) {
            int y = power(x,n/2);
            return y*y;
        }else {
            int y = power(x,n-1/2);
            return y*y*x;
        }
    }
}
