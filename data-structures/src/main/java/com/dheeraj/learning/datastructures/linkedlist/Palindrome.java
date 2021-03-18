package com.dheeraj.learning.datastructures.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-linked-list/solution/
 */
public class Palindrome {
    public static void main(String[] args) {
        ListNode head = ListNode.create(Arrays.asList(1,2,2,1));
        Palindrome obj = new Palindrome();
        System.out.println(obj.isPalindrome(head));
    }
    ListNode frontPointer;

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursiveCheck(head);
    }

    public boolean recursiveCheck(ListNode node) {
        if(node!=null) {
            if(!recursiveCheck(node.next)) return false;
            if(node.val != frontPointer.val) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }
}
