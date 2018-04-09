package com.dheeraj.learning.datastructures.recursive;

/**
 * Created by dgopali on 10/29/2015.
 */
public class XPowYModZ {
    public static void main(String[] args) {
        XPowYModZ x = new XPowYModZ();
        //System.out.println(x.mod(71045970, 41535484, 64735492));
        System.out.println(x.Mod(71045970, 41535484, 64735492));
        System.out.println(x.mod2(71045970, 41535484, 64735492));
        //System.out.println(x.mod(2, 4, 3));
        //System.out.println(x.mod2(2, 4, 3));
        //System.out.println(1%1);
    }


    /**
     * This is most trivial approach. The integer will overflow in this approach.
     * @param x
     * @param pow
     * @param mod
     * @return
     */
    public int mod(int x, int pow, int mod) {
        int result = pow(x, pow);
        return result%mod;
    }

    public int pow(int x, int pow) {
        int result;
        if(pow == 0)
            return 1;
        else if(pow == 1)
            return x;
        else{
            long temp = pow(x, pow/2);
            result = (int)(temp * temp);
            if(pow % 2 == 1)
                result *= x;
        }

        return result;
    }


    /**
     * Check here for detailed explanation
     * https://en.wikipedia.org/wiki/Modular_exponentiation#Right-to-left_binary_method
     *
     * This algorithm makes use of the fact that, given two integers a and b, the following two equations are equivalent:

     c mod m = (a ⋅ b) mod m
     c mod m = [(a mod m) ⋅ (b mod m)] mod m

     exponent has to be written in the form of power of 2. This makes further calculations simpler.
     So b^e becomes b^(2^i). here this is series of multiplicaitons with chaning i
     eg : exponent 10 can be represented in binary as 1010. so 10 = 2^1+2^3.
     Say we take 5^10%13
     result = 5^(10)%13
            = 5^(2^1+2^3)%13
            = (5^2^1 % 13 * 5^2^3 % 13) % 13 //because a*b mod m = (a mod m * b mod m) mod m.
            = (25 % 13 * 390625 % 13) % 13
            = (12 * 1) % 13
            = 12

     Using long result and base because for bigger number integer multiplication overflows max integer value.

     Check this link as well for better understanding
     https://stackoverflow.com/questions/2177781/how-to-calculate-modulus-of-large-numbers

     * @param base
     * @param exponent
     * @param modulus
     * @return
     */
    public int mod2(int base, int exponent, int modulus){
        long result = 1;
        long base2 = base;
        while(exponent > 0) {
            if(exponent % 2 == 1) //When binary representation has 0s we should not compute result. We'll compute only when there is 1 in the binary digit.
                result = (result * base2) % modulus;
            exponent = exponent >> 1; //Moving digits right. So that we work on one digit at a time in the loop.
            base2 = ( base2 * base2 ) % modulus; //Since we need next multiple base power in the next iteration.
        }
        return (int)result;
    }


    public int Mod(int a, int b, int c) {
        if(b==0)
            return 1%c;
        else if(b%2==0){
            long y = Mod(a,b/2,c);
            return (int)((y*y)%c);
        }else{
            long temp1 = (a+c)%c;
            long temp2 = Mod(a,b-1,c);
            return (int)((temp1*temp2)%c);
        }
    }



}
