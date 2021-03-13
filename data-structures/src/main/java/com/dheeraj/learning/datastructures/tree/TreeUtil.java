package com.dheeraj.learning.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
    /**
     * Creates a perfect balanced tree
     *
     * @param a string containing comma separated integers in sorted order
     * @return
     */
    public static Node createBST(String a){
        Node root = null;
        String[] str = a.split(",");
        root = binaryInsert(root,str,0,str.length-1);

        return root;
    }

    /**
     * Creates a perfect balanced tree
     *
     * @param a string containing comma separated integers in binary sorted order
     * @return
     */
    public static Node createBSTWithBinarySortedString(String a){
        Node root = null;
        String[] str = a.split(",");
        for(int i=0;i<str.length;i++){
            root = insert(root,Integer.parseInt(str[i]));
        }

        return root;
    }

    /**
     * Inserts a list of string values into tree in perfectly balanced manner.
     *
     * @param root
     * @param str
     * @param low
     * @param high
     * @return
     */
    private static Node binaryInsert(Node root, String[] str, int low, int high){
        if(low>high)
            return root;
        int mid=(low+high)/2;
        root = insert(root, Integer.parseInt(str[mid]));
        root.left = binaryInsert(root.left, str, low, mid - 1);
        root.right = binaryInsert(root.right, str, mid + 1, high);
        return root;
    }

    /**
     * Inserts a new node with given value in the tree in the appropirate location.
     * Wont guarantee balanced tree.
     * @param root
     * @param x
     * @return
     */
    private static Node insert(Node root, int x){
        if(root == null){
            root = new Node(x);
            //The below extra condition is for interviewbit input standard for tree
            if(x==-1)
                return null;
            return root;
        }
        if(x <= root.val){
            root.left = insert(root.left, x);
        }else{
            root.right = insert(root.right, x);
        }
        return root;
    }

    public static Node createTreeWithInsertionOrder(String s) {
        String[] str = s.split(",");
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(str[0]));
        queue.add(root);
        int num = 1;
        while(!queue.isEmpty() && num < str.length){
            Node curr = queue.poll();
            curr.left = new Node(Integer.parseInt(str[num++]));
            queue.offer(curr.left);
            if (num < str.length) {
                curr.right = new Node(Integer.parseInt(str[num++]));
                queue.offer(curr.right);
            }
        }

        return root;
    }

    public static Node createTreeWithInsertionOrder_Optimzed(String s) {
            String[] str = s.split(",");
            Node root = null;
            return insertLevelOrder(str, root, 0);
    }

    public static Node insertLevelOrder(String[] arr, Node root, int i) {
        if (i < arr.length) {
            root = new Node(Integer.parseInt(arr[i]));
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }
}
