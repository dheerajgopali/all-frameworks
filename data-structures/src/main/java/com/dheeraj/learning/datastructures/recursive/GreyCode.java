package com.dheeraj.learning.datastructures.recursive;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/31/2015.
 */
public class GreyCode {
    public static void main(String[] args) {
        GreyCode obj = new GreyCode();
        obj.gray("",3);
        System.out.println(obj.grayCode2(3));
    }

    public ArrayList<Integer> grayCode2(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (n == 0) {
            result.add(0);
            return result;
        }
        ;
        result.add(0);
        result.add(1);
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(result);
            Integer a = 1 << i;
            for (int k = result.size() - 1; k >= 0; k--) {
                tmp.add(result.get(k) + a);
            }
            result = tmp;
        }
        return result;
    }

    // append reverse of order n gray code to prefix string, and print
    public static void yarg(String prefix, int n) {
        if (n == 0) System.out.println(prefix);
        else {
            gray(prefix + "1", n - 1);
            yarg(prefix + "0", n - 1);
        }
    }

    // append order n gray code to end of prefix string, and print
    public static void gray(String prefix, int n) {
        if (n == 0) System.out.println(prefix);
        else {
            gray(prefix + "0", n - 1);
            yarg(prefix + "1", n - 1);
        }
    }

    int pos;

    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        StringBuilder str = new StringBuilder();
        list = getGreyCode(a,0,str,list);
        return list;
    }

    public ArrayList<Integer> getGreyCode(int n, int index, StringBuilder str, ArrayList<Integer> result){
        if(index == n){
            result.add(convertBinaryToDecimal(str.toString()));
            pos = pos-1;
            return result;
        }
        str.append("0");
        pos = pos+1;
        getGreyCode(n, index + 1, str, result);
        char lastChar = str.charAt(str.length()-1);
        str.append("1");
        str.append(lastChar);
        getGreyCode(n,index+1,str,result);
        str.deleteCharAt(str.length() - 1);
        return result;
    }

    public static int convertBinaryToDecimal(String a){
        StringBuilder str = new StringBuilder(a);
        int len = a.length();
        int sum = 0;
        int j=0;
        for(int i=len-1;i>=0;i--,j++){
            sum = sum+(a.charAt(i)-'0')*(int)Math.pow(2,j);
        }
        return sum;
    }
}