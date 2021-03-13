package com.dheeraj.learning.datastructures;

import java.util.HashMap;

/**
 * Leetcode example
 */
public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        obj.get(1);
        obj.put(3,3);
        obj.get(2);
        obj.put(4,4);
        obj.get(1);
        obj.get(3);
        obj.get(4);
    }
}

class LRUCache {

    HashMap<Integer, DLLNode> map;
    class DLLNode{
        int val;
        DLLNode next;
        DLLNode prev;
        DLLNode(int val, DLLNode next, DLLNode prev) {
            this.val=val;
            this.next=next;
            this.prev=prev;
        }
    }
    DLLNode head;
    DLLNode tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new DLLNode(-1, null, null);
        tail = new DLLNode(-1, null, null);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLLNode temp = map.get(key);
        if(temp==null)
            return -1;
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            temp.next = head.next;
            temp.prev = head;
            head.next = temp;
        }
        return temp.val;
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            if(map.size() == capacity) {
                DLLNode nodeToRemove = tail.prev;
                nodeToRemove.prev.next = tail;
                tail.prev = nodeToRemove.prev;
                nodeToRemove.next=null;
                nodeToRemove.prev=null;
                map.remove(nodeToRemove.val);
            }
            DLLNode temp = new DLLNode(value, null, null);
            temp.next = tail;
            temp.prev = tail.prev;
            tail.prev.next = temp;
            tail.prev = temp;
            map.put(key, temp);
        } else {
            DLLNode temp = map.get(key);
            temp.val = value;
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            temp.next = head.next;
            temp.prev = head;
        }
    }
}



