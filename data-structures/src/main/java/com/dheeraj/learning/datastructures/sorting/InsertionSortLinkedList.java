package com.dheeraj.learning.datastructures.sorting;

import com.dheeraj.learning.datastructures.linkedlist.ListNode;
import com.dheeraj.learning.utilities.ListUtility;

/**
 * Created by dgopali on 10/27/2015.
 */
public class InsertionSortLinkedList {
    public static void main(String[] args) {
        ListNode head = ListNode.create(ListUtility.buildList("3,-1,-100,1"));
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        InsertionSortLinkedList isll = new InsertionSortLinkedList();
        temp = isll.insertionSort(head);
        System.out.println();
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }

    public ListNode insertionSort(ListNode head){
        ListNode temp = head;
        ListNode newHead = null;
        ListNode newTemp = null;
        while(temp!=null){
            ListNode currentNode = temp;
            temp = temp.next;
            currentNode.next = null;
            if(newHead == null){
                newHead = currentNode;
            }else{
                newTemp = newHead;
                ListNode previousNode = null;
                while(newTemp!=null && currentNode.val>newTemp.val){
                    previousNode = newTemp;
                    newTemp = newTemp.next;
                }
                if(newTemp == newHead){
                    currentNode.next = newTemp;
                    newHead = currentNode;
                }else{
                    previousNode.next = currentNode;
                    currentNode.next = newTemp;
                }
            }

        }

        return newHead;
    }


}
