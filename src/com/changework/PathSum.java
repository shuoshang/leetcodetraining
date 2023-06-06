package com.changework;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSum {


    public boolean hasPathSum(TreeNode root, int sum) {

        if(root  == null) return false;
        if(root.val== sum && root.left == null && root.right == null){
                return true;
        }
        return  ispathsum(root, sum);
//        if(root==null) return false;
//        if(root.left==null && root.right==null) return sum==root.val;
//        return (hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val));
    }


    public boolean ispathsum(TreeNode node, int sum) {
        if(node  == null) return false;
        sum -= node.val;
        if(sum== 0 && node.left == null && node.right == null){
            return true;
        }

        return ispathsum(node.left,sum) ||  ispathsum(node.right,sum);
    }



    public static void main(String[] args){
        PathSum pathSum = new PathSum();
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(-3);
//        TreeNode node4 = new TreeNode(1);
//        TreeNode node5 = new TreeNode(3);
//        TreeNode node6 = new TreeNode(-2);
//        TreeNode node7 = new TreeNode(-1);

        TreeNode node1 = new TreeNode(-2);
        TreeNode node2 = new TreeNode(-1);
        TreeNode node3 = new TreeNode(-5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(-5);
        TreeNode node7 = new TreeNode(-1);
        TreeNode node8 = new TreeNode(-4);
        TreeNode node9 = new TreeNode(-5);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node4.left = node7;

        node1.left = node2;
        node2.right = node3;
        node3.left = node4;
        node3.right = node5;
        node4.right = node6;
        node6.right = node8;
        node5.right = node7;
        node7.left = node9;

        boolean list = pathSum.hasPathSum(node1,-10);
        System.out.println(list);
    }
}
