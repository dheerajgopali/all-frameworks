package com.dheeraj.learning.datastructures.tree;

/**
 * Created by dgopali on 11/5/2015.
 */
public class TreeTest {
    public static void main(String[] args) {
        TreeTest obj = new TreeTest();
        //TreeNode root = TreeNode.createBST("1,4,7,10,13,16,19,22,25,28,31,34,37,40,43,46,49,52,55,58,61,64,67,70,73,76,79,82,85,88,91,94,97,100,103,106,109,112,115,118,121,124,127,130,133,136,139,142,145,148,151,154,157,160,163,166,169,172,175,178,181,184,187,190,193,196,199,202,205,208,211,214,217,220,223,226,229,232,235,238,241,244,247,250,253,256,259,262,265,268,271,274,277,280,283,286,289,292,295,298,301,304,307,310,313,316,319,322,325,328,331,334,337,340,343,346,349,352,355,358,361,364,367,370,373,376,379,382,385,388,391,394,397,400,403,406,409,412,415,418,421,424,427,430,433,436,439,442,445,448,451,454,457,460,463,466,469,472,475,478,481,484,487,490,493,496,499,502,505,508,511,514,517,520,523,526,529,532,535,538,541,544,547,550,553,556,559,562,565,568,571,574,577,580,583,586,589,592,595,598,601,604,607,610,613,616,619,622,625,628,631,634,637,640,643,646,649,652,655,658,661,664,667,670,673,676,679,679,682,685,688,691,694,697,700,703,706,709,712,715,718,721,724,727,730,733,736,739,742,745,748,751,754,757,760,763,766,769,772,775,778,781,784,787,790,793,796,799,802,805,808,811,814,817,820,823,826,829,832,835,838,841,844,847,850,853,856,859,862,865,868,871,874,877,880,883,886,889,892,895,898,901,904,907,910,913,916,919,922,925,928,931,934,937,940,943,946,949,952,955,958,961,964,967,970,973,976,979,982,985,988,991,994,997,1000,1003,1006,1009,1012,1015");
        /*TreeNode root = TreeNode.createBSTWithBinarySortedString("430,244,505,103,385,454,547,91,223,328,388,436,457,529,565,58,100,217,238,256,352,-1,397,433,451,-1,490,526,532,550,634,55,76,97,-1,214,220,235,241,247,259,346,370,391,412,-1,-1,445,-1,472,493,508,-1,-1,538,-1,556,580,646,10,-1,67,82,94,-1,166,-1,-1,-1,226,-1,-1,-1,-1,250,-1,268,334,349,367,373,-1,394,409,427,442,448,463,478,-1,502,-1,514,535,544,553,559,571,601,637,-1,4,52,61,73,79,85,-1,-1,157,190,-1,232,-1,253,262,316,331,340,-1,-1,358,-1,-1,382,-1,-1,403,-1,415,-1,439,-1,-1,-1,460,469,475,481,499,-1,511,517,-1,-1,541,-1,-1,-1,-1,562,568,577,598,622,-1,640,1,7,34,-1,-1,64,70,-1,-1,-1,-1,88,139,163,175,205,229,-1,-1,-1,-1,265,286,325,-1,-1,337,343,355,364,376,-1,400,406,-1,424,-1,-1,-1,-1,466,-1,-1,-1,-1,487,496,-1,-1,-1,-1,523,-1,-1,-1,-1,-1,-1,574,-1,595,-1,616,631,-1,643,-1,-1,-1,-1,16,37,-1,-1,-1,-1,-1,-1,118,154,160,-1,172,184,196,208,-1,-1,-1,-1,274,304,319,-1,-1,-1,-1,-1,-1,-1,361,-1,-1,379,-1,-1,-1,-1,421,-1,-1,-1,484,-1,-1,-1,520,-1,-1,-1,586,-1,613,619,625,-1,-1,-1,13,25,-1,46,109,136,145,-1,-1,-1,169,-1,181,187,193,199,-1,211,271,280,301,310,-1,322,-1,-1,-1,-1,418,-1,-1,-1,-1,-1,583,592,610,-1,-1,-1,-1,628,-1,-1,19,28,40,49,106,112,127,-1,142,151,-1,-1,178,-1,-1,-1,-1,-1,-1,202,-1,-1,-1,-1,277,283,298,-1,307,313,-1,-1,-1,-1,-1,-1,589,-1,607,-1,-1,-1,-1,22,-1,31,-1,43,-1,-1,-1,-1,-1,115,121,130,-1,-1,148,-1,-1,-1,-1,-1,-1,-1,-1,-1,289,-1,-1,-1,-1,-1,-1,-1,604,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,124,-1,133,-1,-1,-1,292,-1,-1,-1,-1,-1,-1,-1,295,-1,-1");
        TreeNode successor = obj.getSuccessor(root, 454);
        System.out.println(successor.val + ", "+successor.right.val);*/
        TreeNode root = TreeNode.createBST("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15");
        TreeNode.displayPreOrder(root);
        System.out.println();
        TreeNode.preOrder(root);
        System.out.println();
        TreeNode.displayInOrder(root);
        System.out.println();
        TreeNode.inOrder(root);
        System.out.println();
        TreeNode.displayPostOrder(root);
        System.out.println();
        TreeNode.postOrder(root);
    }

    public TreeNode getSuccessor(TreeNode a, int b) {
        TreeNode currentNode = findNode(a,b);
        if(currentNode == null)
            return null;
        if(currentNode.right != null){
            return findMin(currentNode.right);
        }else{
            TreeNode successor = null;
            TreeNode ancestor = a;
            while(ancestor != currentNode){
                if(currentNode.val <= ancestor.val){
                    successor = ancestor;
                    ancestor = ancestor.left;
                }else
                    ancestor = ancestor.right;
            }
            return successor;
        }
    }

    public TreeNode findNode(TreeNode root, int ele){
        TreeNode temp = root;
        while(temp!=null && ele != temp.val){
            if(ele < temp.val){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        return temp;
    }

    /**
     * The below recursive method to find node is expensive. So created above iterative method.
     * @param root
     * @param ele
     * @return
     */
    public TreeNode findNodeR(TreeNode root, int ele){
        if(root==null) return null;
        if(ele == root.val){
            return root;
        }else if(ele < root.val){
            return findNode(root.left,ele);
        }else{
            return findNode(root.right,ele);
        }
    }

    public TreeNode findMin(TreeNode a){
        if(a == null) return null;
        while(a.left!=null){
            a = a.left;
        }
        return a;
    }
}