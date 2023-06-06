package com.changework;

import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    List<List<Integer>> list = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<Integer> remain = new LinkedList<>();
        ispathsum(root, sum,remain);
        return  list;
//        if(root==null) return false;
//        if(root.left==null && root.right==null) return sum==root.val;
//        return (hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val));
    }
    public void ispathsum(TreeNode node, int sum,List<Integer> remain) {
        if(node  == null) return ;
        sum -= node.val;
        remain.add(node.val);
        if(sum== 0 && node.left == null && node.right == null){
            list.add(new LinkedList<>(remain));
        }
        ispathsum(node.left,sum,remain);
        ispathsum(node.right,sum,remain);
        remain.remove(remain.size()-1);
    }

    public static void main(String[] args){
        PathSumII pathSum = new PathSumII();
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(-3);
//        TreeNode node4 = new TreeNode(1);
//        TreeNode node5 = new TreeNode(3);
//        TreeNode node6 = new TreeNode(-2);
//        TreeNode node7 = new TreeNode(-1);

        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.left = node9;
        node6.right = node10;

        List<List<Integer>> list = pathSum.pathSum(node1,22);
        System.out.println(list.toString());
    }
}
