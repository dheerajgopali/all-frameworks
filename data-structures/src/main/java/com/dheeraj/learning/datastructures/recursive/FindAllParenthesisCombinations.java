package com.dheeraj.learning.datastructures.recursive;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by dgopali on 10/31/2015.
 */
public class FindAllParenthesisCombinations {
    public static void main(String[] args) {
        FindAllParenthesisCombinations obj = new FindAllParenthesisCombinations();
        ArrayList<String> list = obj.generateParenthesis(3);

        System.out.println(list);
    }

    /*void _printParenthesis(int pos, int n, int open, int close)
    {
        static char str[MAX_SIZE];

        if(close == n)
        {
            printf("%s \n", str);
            return;
        }
        else
        {
            if(open > close) {
                str[pos] = '}';
                _printParenthesis(pos+1, n, open, close+1);
            }
            if(open < n) {
                str[pos] = '{';
                _printParenthesis(pos+1, n, open+1, close);
            }
        }
    }*/

    public ArrayList<String> generateParenthesis(int a) {
        char[] chArray = new char[a*2];
        ArrayList<String> list = new ArrayList<String>();
        generateParenthesis(0,a,0,0,chArray,list);
        Collections.sort(list);
        return list;
    }

    public ArrayList<String> generateParenthesis(int pos, int n, int open, int close, char[] chArray, ArrayList<String> list){

        if(close == n){
            list.add(new String(chArray));
            return list;
        }
        else{
            if(open > close){
                chArray[pos]=')';
                generateParenthesis(pos+1,n,open,close+1,chArray,list);
            }
            if(open < n){
                chArray[pos]='(';
                generateParenthesis(pos+1,n,open+1,close,chArray,list);
            }
        }

        return null;
    }
}