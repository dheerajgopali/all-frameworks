package com.dheeraj.learning.datastructures.v2.hundredprograms;

/**
 * This works without using extra space.
 */
public class FindMinInStack {
    public static void main(String[] args) {
        MaxStack stk = new MaxStack();
        stk.push(7);
        stk.getMin();
        stk.push(6);
        stk.getMin();
        stk.push(10);
        stk.getMin();
        stk.push(5);
        stk.getMin();

    }
}

class Stack {
    int top=-1;
    int min=-1;
    Integer[] arr = new Integer[100];

    public void peek(){
        System.out.println(arr[top]);
    }

    public void push(int ele){
        if(top==-1) {
            arr[++top] = ele;
            min = ele;
        }
        else{
            if(ele >= min)
                arr[++top]=ele;
            else{
                arr[++top]=2*ele-min;
                min = ele;
            }
        }
    }

    public int pop(){
        if(arr[top] >= min){
            return arr[top--];
        }else {
            min = 2*min - arr[top];
            return arr[top--];
        }
    }

    public void getMin(){
        System.out.println(min);
    }
}