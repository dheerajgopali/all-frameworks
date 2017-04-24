package com.dheeraj.learning.datastructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dgopali on 11/5/2015.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * Creates a perfect balanced tree
     *
     * @param a string containing comma separated integers in sorted order
     * @return
     */
    public static TreeNode createBST(String a){
        TreeNode root = null;
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
    public static TreeNode createBSTWithBinarySortedString(String a){
        TreeNode root = null;
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
    private static TreeNode binaryInsert(TreeNode root, String[] str, int low, int high){
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
    private static TreeNode insert(TreeNode root, int x){
        if(root == null){
            root = new TreeNode(x);
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

    public static void displayInOrder(TreeNode root){
        if(root == null)
            return;
        displayInOrder(root.left);
        System.out.print(root.val + " ");
        displayInOrder(root.right);
    }

    public static void displayPreOrder(TreeNode root){
        if(root == null)
            return;
        System.out.print(root.val + " ");
        displayPreOrder(root.left);
        displayPreOrder(root.right);
    }

    public static void displayPostOrder(TreeNode root){
        if(root == null)
            return;
        displayPostOrder(root.left);
        displayPostOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void preOrder(TreeNode root) {
        if (root == null) return;

        final Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            // LIFO
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    public static void reverseOrder(TreeNode root) {
        if (root == null) return;

        final Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            // LIFO
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
    }

    public static void inOrder(TreeNode root) {
        if (root == null) return;

        final Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;

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


    public static void postOrder(TreeNode root) {
        if (root == null) return;

        final Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;

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
                TreeNode nodeRight = stack.pop();
                stack.push(node);
                node = nodeRight;
            } else {
                System.out.print(node.val + " ");
                node = null;
            }
        }
    }

    public static void displayLevelByLevel(TreeNode root){
        if(root == null)
            return;
        ArrayList<TreeNode> currentRow = new ArrayList<TreeNode>();
        ArrayList<TreeNode> nextRow = new ArrayList<TreeNode>();
        currentRow.add(root);
        System.out.println();
        boolean inversed = false;
        while(!currentRow.isEmpty()){
            int currentRowLen = currentRow.size();
            for(int i=0;i<currentRowLen;i++){
                TreeNode temp = currentRow.get(i);
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

    public static void displayList(List<TreeNode> list, boolean inversed){
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
}
