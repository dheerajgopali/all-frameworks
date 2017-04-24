package com.dheeraj.learning.datastructures.linkedlist;

/**
 * Created by dgopali on 10/26/2015.
 */
public class ReverRangeList {
    public static void main(String[] args) {
        ListNode node4 = new ListNode(1);//564;
        ListNode node5 = new ListNode(2);//564;
        ListNode node6 = new ListNode(3);//564;
        node4.next = node5;
        node5.next = node6;
        ReverRangeList rr = new ReverRangeList();
        ListNode result = rr.reverseBetween(node4, 1, 2);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }

    }

    public ListNode reverseBetween(ListNode a, int m, int n) {
        ListNode tempBefore = null;
        ListNode tempAfter = null;
        ListNode tempLeft = null;
        ListNode tempRight = null;
        if(m==1){
            tempBefore = null;
            tempLeft = a;
        }else{
            int counter = 1;
            tempBefore = a;
            while(counter<m-1){
                tempBefore = tempBefore.next;
                counter++;
            }
            tempLeft = tempBefore.next;
        }

        int counter = 1;
        tempAfter = a;
        while(counter<n){
            tempAfter = tempAfter.next;
            counter++;
        }
        tempRight = tempAfter;
        tempAfter = tempAfter.next;
        tempRight.next = null;

        ListNode reversed = reverseList(tempLeft);
        ListNode result = null;
        if(m==1){
            tempLeft.next = tempAfter;
            result = reversed;
        }else{
            tempBefore.next = reversed;
            tempLeft.next = tempAfter;
            result = a;
        }
        return result;
    }

    public ListNode reverseList(ListNode a) {
        ListNode prev = null;
        ListNode current = a;
        ListNode next = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        a = prev;
        return a;
    }
}
