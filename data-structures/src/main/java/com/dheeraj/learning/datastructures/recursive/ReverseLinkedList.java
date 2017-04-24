package com.dheeraj.learning.datastructures.recursive;

import com.dheeraj.learning.datastructures.linkedlist.ListNode;
import com.dheeraj.learning.utilities.ListUtility;

/**
 * Created by dgopali on 10/29/2015.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode head = ListNode.create(ListUtility.buildList("1,2,3,4,5"));
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        ListNode reverse = rll.reverseList(head);
        System.out.println();
        while(reverse!=null){
            System.out.print(reverse.val + " ");
            reverse = reverse.next;
        }
    }

    public ListNode reverseList(ListNode a) {
        if(a.next == null) {
            return a;
        }else {
            ListNode head = reverseList(a.next);
            a.next.next = a;
            a.next = null;
            return head;
        }
    }
}
