package com.dheeraj.learning.datastructures.hashtable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by dgopali on 11/2/2015.
 */
public class IntegerDivisionToFractionString {
    public static void main(String[] args) {
        IntegerDivisionToFractionString obj = new IntegerDivisionToFractionString();

//        for(int i=100000000;i<1000000000;i=i+3)
//            for(int j=100000000;j<1000000000;j=j+7)
//
//
        System.out.println(obj.fractionToDecimal(1, -3));
//        System.out.println(Integer.MIN_VALUE/Integer.MAX_VALUE);
    }

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        if (numerator == 0)
            return "0";
        if (denominator == 0)
            return "";

        // is result is negative
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append('-');
        }

        // convert int to long
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        // quotient
        long res = num / den;
        result.append(res + "");

        // if remainder is 0, return result
        long remainder = (num % den) * 10;
        if (remainder == 0)
            return result.toString();

        // right-hand side of decimal point
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        result.append('.');
        while (remainder != 0) {
            // if digits repeat
            if (map.containsKey(remainder)) {
                int beg = map.get(remainder);
                result.insert(beg, '(');
                result.append(')');
                return result.toString();
            }

            // continue
            map.put(remainder, result.length());
            res = remainder / den;
            result.append(res + "");
            remainder = (remainder % den) * 10;
        }

        return result.toString();
    }


    public String fractionToDecimalV2(int num, int den) {
        StringBuilder integerPart = new StringBuilder();
        long numerator = Math.abs(num);
        long denominator = Math.abs(den);

        long remainder = numerator % denominator;
        integerPart.append(num / den + "");
        HashSet<Long> set = new HashSet<Long>();
        StringBuilder fractionPart = new StringBuilder();
        while (remainder != 0 && !set.contains(remainder)) {
            set.add(remainder);
            long res = (remainder * 10) / denominator;
            if (res < 0) {
                long temp = -res;
                fractionPart.append(temp);
            } else {
                fractionPart.append(res);
            }
            remainder = (remainder * 10) % denominator;
        }
        String resultString = null;
        if (fractionPart.length() != 0 && fractionPart.charAt(0) == '-') {
            fractionPart.deleteCharAt(0);
        }
        if ((double) num / (double) den < 0) {
            if (integerPart.charAt(0) != '-') {
                integerPart.insert(0, '-');
            }
        } else {
            if (integerPart.charAt(0) == '-') {
                integerPart.deleteCharAt(0);
            }
        }

        if (remainder != 0) {
            long res = (remainder * 10) / denominator;
            StringBuilder fractionPartRepetitive = new StringBuilder(fractionPart);
            fractionPartRepetitive.insert(fractionPartRepetitive.indexOf(res + ""), '(');
            fractionPartRepetitive.append(")");
            resultString = integerPart.toString() + "." + fractionPartRepetitive.toString();
        } else {
            resultString = integerPart.toString() + (fractionPart.toString().isEmpty() ? "" : ("." + fractionPart.toString()));
        }

        return resultString;
    }

    public void computeIntegerPart(StringBuilder integetPart, int numerator, int denominator) {
        if ((double) numerator / (double) denominator < 0) {
            if (integetPart.charAt(0) != '-') {
                integetPart.insert(0, '-');
            }
        } else {
            if (integetPart.charAt(0) == '-') {
                integetPart.deleteCharAt(0);
            }
        }
    }
}