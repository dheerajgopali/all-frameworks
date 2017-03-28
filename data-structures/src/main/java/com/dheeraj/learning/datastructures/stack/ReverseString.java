package com.dheeraj.learning.datastructures.stack;

import java.util.Stack;

/**
 * Created by dgopali on 10/27/2015.
 */
public class ReverseString {
    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        System.out.println(rs.reverseString("abc"));
    }

    public String reverseString(String a) {
        Stack<Character> stack = new Stack<Character>();
        int len = a.length();
        for(int i=0;i<len;i++){
            stack.push(a.charAt(i));
        }
        StringBuilder str = new StringBuilder();
        while(!stack.empty()){
            str.append(stack.pop());
        }

        return str.toString();
    }
}
