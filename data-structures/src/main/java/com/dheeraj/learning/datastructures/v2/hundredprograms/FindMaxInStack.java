package com.dheeraj.learning.datastructures.v2.hundredprograms;

public class FindMaxInStack {
    public static void main(String[] args) {
        MaxStack stk = new MaxStack();
        stk.push(10);
        stk.getMin();
        stk.peek();
        stk.push(5);
        stk.getMin();
        stk.peek();
        stk.push(2);
        stk.getMin();
        stk.peek();
        stk.push(25);
        stk.getMin();
        stk.peek();
    }
}

class MaxStack {
    int top=-1;
    int max =-1;
    Integer[] arr = new Integer[100];

    public void peek(){
        int temp=0;
        if(arr[top]<=max)
            temp = arr[top];
        else {
            temp = max;
        }
        System.out.println(temp);
    }

    public void push(int ele){
        if(top==-1) {
            arr[++top] = ele;
            max = ele;
        }
        else{
            if(ele <= max)
                arr[++top]=ele;
            else{
                arr[++top]=2*ele- max;
                max = ele;
            }
        }
    }

    public int pop(){
        if(arr[top] <= max){
            return arr[top--];
        }else {
            max = 2* max - arr[top];
            return arr[top--];
        }
    }

    public void getMin(){
        System.out.println(max);
    }
}