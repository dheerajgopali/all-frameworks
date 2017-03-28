package com.dheeraj.learning.datastructures.stack;

import com.dheeraj.learning.utilities.ListUtility;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by dgopali on 10/28/2015.
 */
public class NearestTest {
    public static void main(String[] args) {
        NearestTest obj = new NearestTest();
        System.out.println(obj.prevSmaller(new ArrayList<Integer>(ListUtility.buildList("1,4,5,2,8,10"))));
    }

    /**
     * 1) Create a new empty stack st

     2) Iterate over array `A`,
     where `i` goes from `0` to `size(A) - 1`.
     a) We are looking for value just smaller than `A[i]`. So keep popping from `st` till elements in `st >= A[i]` or st becomes empty.
     b) If `st` is non empty, then the top element is our previous element. Else the previous element does not exist.
     c) push `A[i]` onto st
     *
     */

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        int len = arr.size();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<len;i++){
            if(stack.empty()){
                stack.push(arr.get(i));
                list.add(-1);
            }else{
                while(!stack.empty()){
                    int temp = stack.pop();
                    if(arr.get(i) > temp) {
                        stack.push(temp);
                        break;
                    }
                }
                if(stack.empty())
                    list.add(-1);
                else {
                    list.add(stack.peek());
                }
                stack.push(arr.get(i));
            }
        }

        return list;
    }
}