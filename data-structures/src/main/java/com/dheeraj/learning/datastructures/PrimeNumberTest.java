package com.dheeraj.learning.datastructures;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/18/2015.
 */
public class PrimeNumberTest {
    public static void main(String[] args) {
        PrimeNumberTest pnt = new PrimeNumberTest();
        /*for(int i=0;i<=5;i++){
            System.out.print(pnt.isPrime(i) ? i + " ":"");
        }*/
        System.out.println(pnt.sieve(10));
    }

    //Prime numbers under N including N
    public ArrayList<Integer> sieve(int a) {
        boolean[] primes = new boolean[a+1];
        for(int i=0;i<primes.length;i++){
            primes[i]=true;
        }
        primes[0]=false;
        primes[1]=false;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int asqrt = (int)Math.sqrt(a);
        for(int i=2;i<=asqrt;i++){
            if(primes[i]){
                for(int j=2;i*j<=a;j++){
                    primes[i*j]=false;
                }
            }
        }

        for(int i=2;i<primes.length;i++){
            if(primes[i])
                list.add(i);
        }
        return list;
    }

    public ArrayList<Integer> primesum(int a) {
        ArrayList<Integer> list = new ArrayList();
        if(a==4){
            list.add(2);
            list.add(2);
            return list;
        }
        for(int i=3;i<a;i=i+2){
            int left=i;
            int right=a-i;
            if(isPrime(right)){
                list.add(left);
                list.add(right);
                return list;
            }
        }
        return null;
    }

    boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public int isPrime2(int A) {
        if(A<2)
            return 0;
        int upperLimit = (int)(Math.sqrt(A));
        for (int i = 2; i <= upperLimit; i++) {
            if (i < A && A % i == 0) return 0;
        }
        return 1;
    }
}
