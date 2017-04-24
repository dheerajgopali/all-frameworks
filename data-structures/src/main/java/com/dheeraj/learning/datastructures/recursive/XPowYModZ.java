package com.dheeraj.learning.datastructures.recursive;

/**
 * Created by dgopali on 10/29/2015.
 */
public class XPowYModZ {
    public static void main(String[] args) {
        XPowYModZ x = new XPowYModZ();
        System.out.println(x.Mod(71045970, 41535484, 64735492));
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
