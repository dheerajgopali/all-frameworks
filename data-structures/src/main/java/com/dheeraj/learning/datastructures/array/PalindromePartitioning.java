package com.dheeraj.learning.datastructures.array;

/**
 * Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
 * For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”.
 * Determine the fewest cuts needed for palindrome partitioning of a given string. For example, minimum 3 cuts are needed for
 * “ababbbabbababa”. The three cuts are “a|babbbab|b|ababa”. If a string is palindrome, then minimum 0 cuts are needed.
 * If a string of length n containing all different characters, then minimum n-1 cuts are needed.
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(minPartitionsRequired("ababbbabbababa"));
        System.out.println(minPartitionsRequired("dheeraj"));
    }

    public static int minPartitionsRequired(String str){
        int strLength = str.length();
        boolean[][] P = new boolean[strLength][strLength];
        int[][] C = new int[strLength][strLength];

        //initialize dynamic programming variables
        for (int i = 0; i < strLength; i++) {
            P[i][i]=true;
            C[i][i]=0;
        }

        int i=0;
        int j=0;

        //Increase string size one character at a time
        for(int L=2; L <= strLength; L++){
            i=0;
            j=i+L-1;
            while(i<=strLength-L){
                if(L==2)
                    P[i][j] = str.charAt(i) == str.charAt(j);
                else
                    P[i][j] = (str.charAt(i) == str.charAt(j)) && P[i+1][j-1];

                if(P[i][j])
                    C[i][j] = 0;
                else{
                    C[i][j] = Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        C[i][j] = Integer.min(C[i][j], C[i][k] + C[k+1][j] + 1);
                    }
                }
                i++;j++;
            }
        }
        return C[0][strLength-1];
    }
}
