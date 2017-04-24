package com.dheeraj.learning.datastructures.linkedlist;

import java.util.List;

/**
 * Created by dgopali on 10/27/2015.
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public void insert(int x){
        ListNode listNode = new ListNode(x);
        this.next = listNode;
    }

    public static ListNode create(List<Integer> list){
        ListNode head = null;
        ListNode previous = null;
        for(Integer integer : list){
            ListNode listNode = new ListNode(integer);
            if(head==null){
                head = listNode;
                previous = listNode;
            }else{
                previous.next = listNode;
                previous = previous.next;
            }
        }
        return head;
    }

    public static void display(ListNode a){
        ListNode temp = a;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return val + ",";
    }
}
