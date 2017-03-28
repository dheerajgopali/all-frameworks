package com.dheeraj.learning.datastructures.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by dgopali on 11/21/2015.
 */
public class TreeLinkNodeTest {
    public static void main(String[] args) {
        TreeLinkNodeTest obj = new TreeLinkNodeTest();
        TreeLinkNode tree = TreeLinkNode.create("1,2,5,3,4,6,7");
        TreeLinkNode.displayLevelByLevel(tree);
        obj.connect(tree);
        TreeLinkNode.displayUsingNextPointer(tree);
    }

    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        ArrayList<TreeLinkNode> currentRow = new ArrayList<TreeLinkNode>();
        ArrayList<TreeLinkNode> nextRow = new ArrayList<TreeLinkNode>();
        currentRow.add(root);
        System.out.println();
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
            for(int i=0;i<currentRowLen-1;i++){
                currentRow.get(i).next = currentRow.get(i+1);
            }
            currentRow.clear();
            currentRow.addAll(nextRow);
            nextRow.clear();
        }
    }


}