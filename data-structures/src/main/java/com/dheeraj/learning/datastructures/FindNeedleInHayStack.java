package com.dheeraj.learning.datastructures;

/**
 * https://leetcode.com/problems/implement-strstr/submissions/
 *
 * Test cases
 * "hello"
 * "ll"
 * "aaaaa"
 * "bba"
 * ""
 * "a"
 * "aaa"
 * "aaa"
 * "mississippi"
 * "a"
 * "abc"
 * "c"
 */
public class FindNeedleInHayStack {
    public static void main(String[] args) {
        FindNeedleInHayStack obj = new FindNeedleInHayStack();
        System.out.println(obj.strStrFromSolution("baaaaaaaa", "bagytisyy"));
    }

    public int strStr(String haystack, String needle) {
        int nN = needle.length();
        int nH = haystack.length();
        if(nH==0)
            return 0;

        if(nN > nH)
            return -1;

        int b = 26;

        //Find the hash for needle
        long needleHash = 0;
        long hayHash = 0;
        long mod = (long)Math.pow(2,31);
        //Reverse hash didnt work. So doing forward hash.
        for (int i = 0; i < nN; i++) {
            needleHash = (needleHash*b + (needle.charAt(i) - 'a')) % mod;
            hayHash = (hayHash*b + (haystack.charAt(i) - 'a')) % mod;
        }

        if(needleHash == hayHash)
            return 0;
        long aL = 1;
        for (int i = 1; i <= nN; ++i) aL = (aL * b) % mod;

        int i;
        for(i=1;i<nH-nN+1;i++) {
            if(needleHash == hayHash)
                return i;
            else {
                hayHash = (b*(hayHash)-(haystack.charAt(i-1)-'a')*aL + (haystack.charAt(i+nN-1)-'a'))%mod;
            }
        }
        if(needleHash == hayHash)
            return i-1;
        return -1;
    }

    // function to convert character to integer
    public int charToInt(int idx, String s) {
        return (int)s.charAt(idx) - (int)'a';
    }

    public int strStrFromSolution(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L > n) return -1;

        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long)Math.pow(2, 31);

        // compute the hash of strings haystack[:L], needle[:L]
        long h = 0, ref_h = 0;
        for (int i = 0; i < L; ++i) {
            h = (h * a + charToInt(i, haystack)) % modulus;
            ref_h = (ref_h * a + charToInt(i, needle)) % modulus;
        }
        if (h == ref_h) return 0;

        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

        for (int start = 1; start < n - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - charToInt(start - 1, haystack) * aL
                    + charToInt(start + L - 1, haystack)) % modulus;
            if (h == ref_h) return start;
        }
        return -1;
    }
}
