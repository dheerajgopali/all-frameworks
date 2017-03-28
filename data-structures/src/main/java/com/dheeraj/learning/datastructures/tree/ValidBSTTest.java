package com.dheeraj.learning.datastructures.tree;

/**
 * Created by dgopali on 11/5/2015.
 */
public class ValidBSTTest {
    public static void main(String[] args) {
        ValidBSTTest obj = new ValidBSTTest();
        System.out.println(obj.isValidBST(TreeNode.createBST("1,2,3,4,5,6")));
    }

    public int isValidBST(TreeNode a) {
        return isBST(a,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public int isBST(TreeNode a, int minValue, int maxValue){
        if(a==null) return 1;
        if(minValue <= a.val && a.val < maxValue
                && isBST(a.left, minValue, a.val) == 1
                && isBST(a.right, a.val, maxValue) == 1)
            return 1;
        else
            return 0;
    }
}