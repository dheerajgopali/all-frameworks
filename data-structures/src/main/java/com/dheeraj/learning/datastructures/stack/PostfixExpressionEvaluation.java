package com.dheeraj.learning.datastructures.stack;

import com.dheeraj.learning.utilities.ArrayUtil;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by dgopali on 10/28/2015.
 */
public class PostfixExpressionEvaluation {
    public static void main(String[] args) {
        PostfixExpressionEvaluation obj = new PostfixExpressionEvaluation();
        System.out.println(obj.evalRPN(new ArrayList<String>(ArrayUtil.buildArray("-500"))));
        //System.out.println("0".matches("^-?\\d+$"));
    }

    public int evalRPN(ArrayList<String> a) {
        Stack<String> stack = new Stack<String>();
        int len = a.size();
        for(int i=0;i<len;i++){
            String ele = a.get(i);
            if(ele.matches("^-?\\d+$")){
                stack.push(ele);
            }else{
                String p2 = stack.pop();
                String p1 = stack.pop();
                int intP2 = Integer.parseInt(p2);
                int intP1 = Integer.parseInt(p1);
                int result = 0;
                if(ele.equals("*")){
                    result = intP1*intP2;
                } else if(ele.equals("/")){
                    result = intP1/intP2;
                } else if(ele.equals("+")){
                    result = intP1+intP2;
                } else if(ele.equals("-")){
                    result = intP1-intP2;
                }
                stack.push(result+"");
            }
        }
        String finalResult = "";
        try {
            finalResult = stack.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Integer.parseInt(finalResult);
    }
}