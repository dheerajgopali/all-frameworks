package com.dheeraj.learning.datastructures.array;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/30/2015.
 */
public class FlipBits {
    public static void main(String[] args) {
        FlipBits fb = new FlipBits();
        System.out.println(fb.flip("011"));
    }

    public ArrayList<Integer> flip(String A) {
        int len = A.length();
        int s = -1, e = -1, c, bestWindowWidth=-1,bestWR=0,bestWL=0,minC;
        for (int i = 0; i < len; i++) {
            if (A.charAt(i) == '0') {
                c = 0;
                s = i;
                e = i;
                minC = -1000;
                for (int j = i; j < len; j++, i++) {
                    if (A.charAt(i) == '0')
                        c++;
                    else
                        c--;

                    if (c < 0) {
                        s = -1;
                        e = -1;
                        break;
                    }

                    if (A.charAt(i) == '0') {
                        e = i;
                    }

                    if (c > bestWindowWidth){
                        bestWindowWidth = c;
                        bestWR = e;
                        bestWL = s;
                    }
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        if (bestWindowWidth > -1) {
            list.add(bestWL+1);
            list.add(bestWR+1);
        }

        return list;
    }
}
