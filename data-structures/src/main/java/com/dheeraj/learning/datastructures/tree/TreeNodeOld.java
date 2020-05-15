package com.dheeraj.learning.datastructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dgopali on 11/5/2015.
 */
public class TreeNodeOld {
    int val;
    Node left;
    Node right;

    public TreeNodeOld(int x) {
        val = x;
    }





    public static void reverseOrder(Node root) {
        if (root == null) return;

        final Stack<Node> stack = new Stack<Node>();
        stack.add(root);

        while (!stack.empty()) {
            Node node = stack.pop();
            System.out.print(node.val + " ");
            // LIFO
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
    }

    public static void inOrder(Node root) {
        if (root == null) return;

        final Stack<Node> stack = new Stack<Node>();
        Node node = root;

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


    public static void postOrder(Node root) {
        if (root == null) return;

        final Stack<Node> stack = new Stack<Node>();
        Node node = root;

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
                Node nodeRight = stack.pop();
                stack.push(node);
                node = nodeRight;
            } else {
                System.out.print(node.val + " ");
                node = null;
            }
        }
    }

    public static void displayLevelByLevel(Node root){
        if(root == null)
            return;
        ArrayList<Node> currentRow = new ArrayList<Node>();
        ArrayList<Node> nextRow = new ArrayList<Node>();
        currentRow.add(root);
        System.out.println();
        boolean inversed = false;
        while(!currentRow.isEmpty()){
            int currentRowLen = currentRow.size();
            for(int i=0;i<currentRowLen;i++){
                Node temp = currentRow.get(i);
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

    public static void displayList(List<Node> list, boolean inversed){
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
