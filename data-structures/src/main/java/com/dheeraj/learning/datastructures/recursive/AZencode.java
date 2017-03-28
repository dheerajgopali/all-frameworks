package com.dheeraj.learning.datastructures.recursive;

/**
 * Created by dgopali on 11/23/2015.
 */
public class AZencode {
    public static void main(String[] args) {
        AZencode obj = new AZencode();
        System.out.println(obj.numDecodings("32925665678138257423442343752148360796465852883409126159293254159974370974059818198867156827877059067081419274873853679038"));
    }

    private int [] matrix;
    public int numDecodings(String A) {
        matrix = new int[A.length()];
        for(int i=0;i<A.length();i++){
            matrix[i] = -1;
        }
        return numDecRec(A.length() - 1, A);
    }

    private int numDecRec(int index, String A) {
        if (index < 0)
            return 1;
        if (matrix[index] != -1)
            return matrix[index];
        int count = 0;
        if (A.charAt(index) > '0') {
            count = numDecRec(index - 1, A);
        }
        if (checkTwoDigit(index, A)) {
            count += numDecRec(index - 2, A);
        }

        return matrix[index] = count;
    }

    private boolean checkTwoDigit(int index, String A) {
        if (index > 0
                && (A.charAt(index - 1) == '1' || A.charAt(index - 1) == '2' && A.charAt(index) <= '6'))
            return true;

        return false;
    }

}