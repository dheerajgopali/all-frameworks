package com.dheeraj.learning.datastructures.stack;

import java.util.Stack;

/**
 * This is the question asked in first round for service now interview.
 */
public class MaxValueStack {
    public static void main(String[] args) {
        Approach1 a1 = new Approach1();
        a1.push(4);
        System.out.println("Current max : "+a1.maxOf());
        a1.push(19);
        System.out.println("Current max : "+a1.maxOf());
        a1.push(7);
        System.out.println("Current max : "+a1.maxOf());
        a1.push(5);
        System.out.println("Current max : "+a1.maxOf());
        a1.push(20);
        System.out.println("Current max : "+a1.maxOf());
        System.out.println(a1.stack);
        a1.pop();
        System.out.println("Current max : "+a1.maxOf());
        a1.pop();
        System.out.println("Current max : "+a1.maxOf());
        a1.push(25);
        System.out.println("Current max : "+a1.maxOf());
        a1.pop();
        System.out.println("Current max : "+a1.maxOf());



        /*Approach1.Node temp = a1.currentLargest;
        while(temp!=null){
            System.out.println("Val : "+temp.value+", count : "+temp.count);
            temp=temp.next;
        }*/
    }

    /**
     * This is the first approach i've told them. Memory efficient but difficult to understand logic
     * Another easier way is to use another stack for storing maximum value.
     */
    static class Approach1 {
        Stack<Integer> stack = new Stack<>();
        Node currentLargest = new Node();
        void push(int ele) {

            if(stack.isEmpty()) {
                currentLargest.value = ele;
                currentLargest.count++;
            } else {
                if(ele > currentLargest.value) {
                    Node temp = new Node();
                    temp.value = ele;
                    temp.count++;
                    temp.next = currentLargest;
                    currentLargest = temp;
                } else {
                    currentLargest.count++;
                }
            }
            stack.push(ele);
        }

        int pop() {
            if(currentLargest.count > 1)
                currentLargest.count--;
            else
                currentLargest = currentLargest.next;
            return stack.pop();
        }

        int maxOf(){
            return currentLargest.value;
        }

        class Node {
            int value;
            int count=0;
            Node next;
        }
    }
}
