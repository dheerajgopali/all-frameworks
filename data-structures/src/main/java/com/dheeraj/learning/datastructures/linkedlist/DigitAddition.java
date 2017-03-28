package com.dheeraj.learning.datastructures.linkedlist;

/**
 * Created by dgopali on 10/25/2015.
 */
public class DigitAddition {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);//243


        //node1.next = node2;

        ListNode node4 = new ListNode(9);//564;
        ListNode node5 = new ListNode(9);//564;
        ListNode node6 = new ListNode(9);//564;
        node4.next = node5;
        node5.next = node6;

        DigitAddition da = new DigitAddition();
        ListNode res = da.addTwoNumbers(node1, node4);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        if (a == null && b != null)
            return b;
        if (b == null && a != null)
            return a;
        ListNode tempA = a;
        ListNode tempB = b;
        ListNode resultHead = null;
        ListNode resultCurrent = null;
        int sum = 0;
        int carry = 0;
        while (tempA != null && tempB != null) {
            sum = tempA.val + tempB.val + carry;

            ListNode newNode = new ListNode(sum % 10);
            if (resultHead == null) {
                resultHead = newNode;
                resultCurrent = newNode;
            } else {
                resultCurrent.next = newNode;
                resultCurrent = newNode;
            }
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }

            tempA = tempA.next;
            tempB = tempB.next;
        }
        while (tempA != null) {
            sum = tempA.val + carry;

            ListNode newNode = new ListNode(sum % 10);
            resultCurrent.next = newNode;
            resultCurrent = newNode;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }

            tempA = tempA.next;
        }
        while (tempB != null) {
            sum = tempB.val + carry;
            ListNode newNode = new ListNode(sum % 10);
            resultCurrent.next = newNode;
            resultCurrent = newNode;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }

            tempB = tempB.next;
        }
        if(carry==1){
            ListNode newNode = new ListNode(1);
            resultCurrent.next = newNode;
        }

        ListNode revList = reverseList(resultHead);
        while(revList!=null){
            if(revList.val==0) {
                ListNode temp = revList.next;
                revList.next = null;
                revList = temp;
            }else
                break;
        }
        ListNode originalList = reverseList(revList);

        return originalList;
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


