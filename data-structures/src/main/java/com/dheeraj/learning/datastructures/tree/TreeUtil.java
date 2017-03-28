package com.dheeraj.learning.datastructures.tree;

import com.dheeraj.learning.datastructures.self.Tree;

/**
 * Created by dgopali on 9/26/2015.
 */
public class TreeUtil {
    public static void main(String[] args) {
        TreeNode head = TreeNode.createBST("1,2,3,4,5");
        //Check whether a binary tree is balanced.
        NodeData nodeData = isBalanced(head);
        System.out.println(nodeData.balanced + " " + nodeData.height);
    }

    public static NodeData isBalanced(TreeNode head) {
        if(head == null)
            return new NodeData(-1,1);
        NodeData left = isBalanced(head.left);
        NodeData right = isBalanced(head.right);
        if(left.balanced == 0 || right.balanced == 0 || Math.abs(left.height-right.height)>1){
            return new NodeData(-1,0);
        }
        return new NodeData(1+Math.max(left.height,right.height),1);
    }

    public static NodeDataV2 isBalancedV2(Tree head) {
        NodeDataV2 left = null;
        NodeDataV2 right = null;
        if(head == null)
            return new NodeDataV2(-1,true);
        if(head.left == null && head.right == null)
            return new NodeDataV2(0,true);
        if(head.left != null) {
            left = isBalancedV2(head.left);
            if(!left.balanced){
                return left;
            }
        }
        if(head.right != null){
            right = isBalancedV2(head.right);
            if(!right.balanced){
                return right;
            }
        }

        int height = 0;
        if(head.left != null && head.right == null) {
            if(left.height > 0){
                return new NodeDataV2(0, false);
            }
            height = 1 + left.height;
        } else if (head.left == null && head.right != null) {
            if(right.height > 0){
                return new NodeDataV2(0, false);
            }
            height = 1 + right.height;
        } else {
            int isBalanced = Math.abs(left.height - right.height);
            if(isBalanced > 1)
                return new NodeDataV2(0,false);

            height = 1 + Math.max(left.height, right.height);;
        }

        return new NodeDataV2(height, true);
    }

}

class NodeData {
    int height = -1;
    int balanced = 1;

    public NodeData(int height, int balanced){
        this.height = height;
        this.balanced = balanced;
    }
}

class NodeDataV2 {
    int height = -1;
    boolean balanced = true;

    public NodeDataV2(int height, boolean balanced){
        this.height = height;
        this.balanced = balanced;
    }
}