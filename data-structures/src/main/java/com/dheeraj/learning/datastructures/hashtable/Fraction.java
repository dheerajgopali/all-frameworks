package com.dheeraj.learning.datastructures.hashtable;

import java.text.DecimalFormat;
import java.util.Formatter;

/**
 * Created by dgopali on 11/1/2015.
 */
public class Fraction {
    public static void main(String[] args) {
        Fraction obj = new Fraction();
        System.out.println(obj.fractionToDecimal(22,7));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        double num = numerator;;
        double den = denominator;

        double res = num/den;
        DecimalFormat df = new DecimalFormat("#.###################################");
        String str = df.format(res);
        return str;
    }
}