package com.dheeraj.learning.datastructures.bits;

public class Overflow {
    public static void main(String[] args) {
        System.out.println(countGoodNumbers((long)Math.pow(10,15)));
    }

    public static int countGoodNumbers(long n) {
        long even = n/2;
        long odd = n-n/2;
        long mod = (long)Math.pow(10,9)+7;

        long resEven = pow(4, even, mod);
        long resOdd = pow(5, odd, mod);

        return (int)((resEven * resOdd)%mod);
    }

    public static long pow(long val, long power, long mod) {
        if(power==0)
            return 1;
        if(power%2==1) {
            return (val * pow((val * val)%mod, (power-1)/2, mod))%mod;
        } else {
            return  pow((val * val)%mod, power/2, mod);
        }
    }
}
