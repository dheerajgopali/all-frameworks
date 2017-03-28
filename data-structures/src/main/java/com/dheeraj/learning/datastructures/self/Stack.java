package com.dheeraj.learning.datastructures.self;

/**
 * Created by dgopali on 9/13/2015.
 */
public class Stack {

    int[] array = new int[100];
    int top = -1;

    public static void main(String[] args) {

    }

    public void push(int ele) {
        if(top==99)
            System.out.println("Stack full");
        else
            array[++top]=ele;
    }

    public int pop(){
        if(top==-1) {
            System.out.println("Stack empty");
            return -1;
        }
        else
            return array[top--];
    }

    public int peep(){
        return array[top];
    }

    public void showAllEle(){
        if(top!=-1){
            for(int i=0;i<top;i++){

            }
        }
    }
}
