package com.dheeraj.learning.datastructures.stack;

import java.util.Stack;

/**
 * Created by dgopali on 10/27/2015.
 */
public class ParanthesisBalanceTest {
    public static void main(String[] args) {
        ParanthesisBalanceTest pbt = new ParanthesisBalanceTest();
        //System.out.println(pbt.isValid("[](){()())}"));
        //System.out.println(pbt.braces("(a + (a + b))"));
        System.out.println(pbt.simplifyPath("/home/../abc"));
    }

    public String simplifyPath(String a) {
        int len = a.length();
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<len;i++){
            if(a.charAt(i)=='.' && (i<len-1?a.charAt(i+1)=='/':true))
                i=i+1;
            else if(a.charAt(i)=='.' && a.charAt(i+1) == '.') {
                i=i+2;
                stack.pop();
                while(!stack.empty() && stack.pop() != '/');
                stack.push('/');
            }else{
                stack.push(a.charAt(i));
            }
        }
        char lastEle = stack.pop();
        if(lastEle != '/' || stack.empty())
            stack.push(lastEle);
        Stack<Character> reverse = new Stack<Character>();
        while (!stack.empty()){
            reverse.push(stack.pop());
        }
        StringBuilder str = new StringBuilder();
        while(!reverse.empty()){
            str.append(reverse.pop());
        }

        return str.toString();
    }

    public int isValid(String a) {
        int len = a.length();
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<len;i++){
            if(a.charAt(i)=='(' || a.charAt(i)=='{' || a.charAt(i)=='[')
                stack.push(a.charAt(i));
            else{
                if(stack.empty() || stack.peek() != getLeftChar(a.charAt(i))){
                    return 0;
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.empty())
            return 1;
        else
            return 0;
    }

    public char getLeftChar(char ch) {
        if (ch == ')')
            return '(';
        else if (ch == '}')
            return '{';
        else if (ch == ']')
            return '[';
        else
            return '0';
    }

    public int braces(String a) {
        int len = a.length();
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<len;i++){
            if(a.charAt(i)=='(' || a.charAt(i)=='+' || a.charAt(i)=='*' || a.charAt(i)=='-' || a.charAt(i)=='/') {
                stack.push(a.charAt(i));
            }else if(a.charAt(i) == ')'){
                if(stack.empty() || !isOperator(stack.peek())){
                    return 1;
                }else{
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return 0;
    }

    public boolean isOperator(char ch){
        if(ch == '+' || ch == '*' || ch=='-' || ch=='/'){
            return true;
        }
        return false;
    }
}
