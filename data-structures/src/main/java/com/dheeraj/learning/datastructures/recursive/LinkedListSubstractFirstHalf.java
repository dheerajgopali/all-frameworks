package com.dheeraj.learning.datastructures.recursive;

import com.dheeraj.learning.datastructures.linkedlist.ListNode;
import com.dheeraj.learning.utilities.ListUtility;

/**
 * Created by dgopali on 11/1/2015.
 */
public class LinkedListSubstractFirstHalf {
    int size;

    public static void main(String[] args) {
        LinkedListSubstractFirstHalf ll = new LinkedListSubstractFirstHalf();
        ListNode a = ListNode.create(ListUtility.buildList("1,2,3,4,5,6"));
        ListNode.display(a);
        ll.subtractIterative(a);
        ListNode.display(a);

    }

    public ListNode subtractIterative(ListNode a){
        int size = getSize(a);
        ListNode firstHalf = a;
        ListNode temp = a;
        int counter=1;
        while(counter<size/2){
            temp = temp.next;
            counter++;
        }
        ListNode secondHalf = temp.next;
        temp.next = null;

        secondHalf = reverse(secondHalf);
        ListNode tempFirst = a;
        ListNode tempSecond = secondHalf;
        while(tempFirst!=null){
            tempFirst.val = tempSecond.val-tempFirst.val;
            tempFirst = tempFirst.next;
            tempSecond = tempSecond.next;
        }
        secondHalf = reverse(secondHalf);
        temp.next = secondHalf;
        return a;
    }

    public ListNode reverse(ListNode a){
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

    public int getSize(ListNode a){
        ListNode temp = a;
        int counter=0;
        while(temp!=null){
            temp=temp.next;
            counter++;
        }
        return counter;
    }

    public ListNode subtract(ListNode a) {
        ListNode temp = a;
        int counter=0;
        while(temp!=null){
            temp=temp.next;
            counter++;
        }
        size = counter;
        boolean isOdd = false;
        if(size%2==1)
            isOdd = true;
        substractRecursive(a,0,isOdd);
        return a;
    }

    public ListNode substractRecursive(ListNode a, int n, boolean isOdd){
        if(isOdd && n==size/2){
            return a.next;
        }
        if(!isOdd && n==size/2){
            return a;
        }
        ListNode currentNode = a;
        ListNode lastNode = substractRecursive(currentNode.next,n+1,isOdd);
        currentNode.val = lastNode.val-currentNode.val;
        return lastNode.next;
    }
}
