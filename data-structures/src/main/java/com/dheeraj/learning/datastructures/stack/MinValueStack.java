package com.dheeraj.learning.datastructures.stack;

import java.util.Stack;

/**
 * Created by dgopali on 10/28/2015.
 */
public class MinValueStack {
    public static void main(String[] args) {
        MinValueStack obj = new MinValueStack();
        Solution s = new Solution();
    }

}

class Solution {
    Node top = null;
    Stack<Integer> minStack=new Stack<Integer>();
    public void push(int x) {
        Node newNode = new Node(x);
        if(top==null) {
            top = newNode;
            minStack.push(newNode.val);
        }
        else{
            newNode.next = top;
            top = newNode;
            int min = minStack.peek();
            if(top.val<min)
                min = top.val;
            minStack.push(min);
        }
    }

    public void pop() {
        if(top!=null){
            top = top.next;
            minStack.pop();
        }
    }

    public int top() {
        if(top == null)
            return -1;
        else
            return top.val;
    }

    public int getMin() {
        if(minStack.empty())
            return -1;
        return minStack.peek();
    }
}

class Node{
    public int val;
    public Node next;
    public Node(int x){
        this.val = x;
        this.next = null;
    }
}