package com.dheeraj.learning.datastructures.tree;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/split-bst/
 */
public class SplitBST {
    public static void main(String[] args) {
        Node root = TreeUtil.createTreeWithInsertionOrder_Optimzed("4,2,6,1,3,5,7");

        Node[] result = splitBST(root, 2);
        System.out.println(result);
    }

    public static Node[] splitBST(Node root, int V) {
        if (root == null)
            return new Node[]{null, null};
        else if (root.val <= V) {
            Node[] bns = splitBST(root.right, V);
            root.right = bns[0];
            bns[0] = root;
            return bns;
        } else {
            Node[] bns = splitBST(root.left, V);
            root.left = bns[1];
            bns[1] = root;
            return bns;
        }
    }
}
