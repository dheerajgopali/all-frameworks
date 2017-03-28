package com.dheeraj.learning.datastructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dgopali on 11/21/2015.
 */
public class TreeLinkNode {
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;

    public TreeLinkNode(int x) {
        val = x;
    }

    /**
     * Values are not sorted in any form. Just inserting each element to its parents left and right.
     * Limitation : current it works only for 6 elements
     * @param a
     * @return
     */
    public static TreeLinkNode create(String a){
        TreeLinkNode root = null;
        String[] str = a.split(",");
        root = createNode(str[0]);
        root.left = createNode(str[1]);
        root.right = createNode(str[2]);
        root.left.left = createNode(str[3]);
        root.left.right = createNode(str[4]);
        root.right.left = createNode(str[5]);
        root.right.right = createNode(str[6]);

        return root;
    }

    public static TreeLinkNode createNode(String val){
        return new TreeLinkNode(Integer.parseInt(val));
    }

    /**
     * Creates a perfect balanced tree
     *
     * @param a string containing comma separated integers in sorted order
     * @return
     */
    public static TreeLinkNode createBST(String a){
        TreeLinkNode root = null;
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
    public static TreeLinkNode createBSTWithBinarySortedString(String a){
        TreeLinkNode root = null;
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
    private static TreeLinkNode binaryInsert(TreeLinkNode root, String[] str, int low, int high){
        if(low>high)
            return root;
        int mid=(low+high)/2;
        root = insert(root, Integer.parseInt(str[mid]));
        root.left = binaryInsert(root.left, str, low, mid - 1);
        root.right = binaryInsert(root.right, str, mid + 1, high);
        return root;
    }

    /**
     * Inserts the given node either right or left.
     * @param root
     * @param x
     * @return
     */
    private static TreeLinkNode insertNode(TreeLinkNode root, int x){
        if(root == null){
            root = new TreeLinkNode(x);
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

    /**
     * Inserts a new node with given value in the tree in the appropirate location.
     * Wont guarantee balanced tree.
     * @param root
     * @param x
     * @return
     */
    private static TreeLinkNode insert(TreeLinkNode root, int x){
        if(root == null){
            root = new TreeLinkNode(x);
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

    public static void displayInOrder(TreeLinkNode root){
        if(root == null)
            return;
        displayInOrder(root.left);
        System.out.print(root.val + " ");
        displayInOrder(root.right);
    }

    public static void displayPreOrder(TreeLinkNode root){
        if(root == null)
            return;
        System.out.print(root.val + " ");
        displayPreOrder(root.left);
        displayPreOrder(root.right);
    }

    public static void displayPostOrder(TreeLinkNode root){
        if(root == null)
            return;
        displayPostOrder(root.left);
        displayPostOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void preOrder(TreeLinkNode root) {
        if (root == null) return;

        final Stack<TreeLinkNode> stack = new Stack<TreeLinkNode>();
        stack.add(root);

        while (!stack.empty()) {
            TreeLinkNode node = stack.pop();
            System.out.print(node.val + " ");
            // LIFO
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    public static void reverseOrder(TreeLinkNode root) {
        if (root == null) return;

        final Stack<TreeLinkNode> stack = new Stack<TreeLinkNode>();
        stack.add(root);

        while (!stack.empty()) {
            TreeLinkNode node = stack.pop();
            System.out.print(node.val + " ");
            // LIFO
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
    }

    public static void inOrder(TreeLinkNode root) {
        if (root == null) return;

        final Stack<TreeLinkNode> stack = new Stack<TreeLinkNode>();
        TreeLinkNode node = root;

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }


    public static void postOrder(TreeLinkNode root) {
        if (root == null) return;

        final Stack<TreeLinkNode> stack = new Stack<TreeLinkNode>();
        TreeLinkNode node = root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                if (node.right != null) stack.add(node.right);
                stack.add(node);
                node = node.left;
            }

            node = stack.pop();

            // (node.right) != null means this node is parent of that tiny subtree
            // stack.pop != null ensures it was not the root.
            if (node.right != null && !stack.isEmpty() && node.right == stack.peek()) {
                TreeLinkNode nodeRight = stack.pop();
                stack.push(node);
                node = nodeRight;
            } else {
                System.out.print(node.val + " ");
                node = null;
            }
        }
    }

    public static void displayLevelByLevel(TreeLinkNode root){
        if(root == null)
            return;
        ArrayList<TreeLinkNode> currentRow = new ArrayList<TreeLinkNode>();
        ArrayList<TreeLinkNode> nextRow = new ArrayList<TreeLinkNode>();
        currentRow.add(root);
        System.out.println();
        boolean inversed = false;
        while(!currentRow.isEmpty()){
            int currentRowLen = currentRow.size();
            for(int i=0;i<currentRowLen;i++){
                TreeLinkNode temp = currentRow.get(i);
                //System.out.print(temp.val + " ");
                if(temp.left!=null)
                    nextRow.add(temp.left);
                if(temp.right!=null)
                    nextRow.add(temp.right);
            }
            //Can change below call if you dont want zigzag
            displayList(currentRow, false);
            inversed = !inversed;
            currentRow.clear();
            currentRow.addAll(nextRow);
            nextRow.clear();
            System.out.println();
        }
    }

    public static void displayList(List<TreeLinkNode> list, boolean inversed){
        int len = list.size();
        if(inversed){
            for(int i=len-1;i>=0;i--){
                System.out.print(list.get(i).val+" ");
            }
        }else{
            for(int i=0;i<len;i++){
                System.out.print(list.get(i).val+" ");
            }
        }
    }

    /**
     * This method displays tree level by level using next pointer present in each node.
     * @param root
     */
    public static void displayUsingNextPointer(TreeLinkNode root){
        TreeLinkNode temp = root;

        while(temp!=null){
            TreeLinkNode horTemp = temp;
            while(horTemp!=null) {
                System.out.print(horTemp.val + " ");
                horTemp = horTemp.next;
            }
            System.out.println();
            temp = temp.left;
        }
    }
}
