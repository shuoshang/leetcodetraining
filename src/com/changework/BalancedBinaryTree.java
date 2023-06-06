package com.changework;

import java.util.*;


//采取后序遍历的方式遍历二叉树的每一个结点。
//在遍历到一个结点之前已经遍历了它的左右子树，
// 那么只要在遍历每个结点的时候记录它的深度（某一结点的深度等于它到叶结点的路径的长度），
// 就可以一边遍历一边判断每个结点是不是平衡的。
public class BalancedBinaryTree {
    List<Integer> newlist = new ArrayList<>();
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }else{
            if(isBalanced(root.left) && isBalanced(root.right)){
                int left  = getdepth(root.left);
                int right  = getdepth(root.right);
                newlist.add(root.val);
                if(Math.abs(left-right) <= 1){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
    }

    public static int getdepth(TreeNode t) {
        if (t == null) {
            return 0;
        } else {
            int i1 = getdepth(t.left);
            int i2 = getdepth(t.right);
            return Math.max(i1, i2) + 1;
        }
    }
    public static void main(String[] args){
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node4.left = node6;
        node4.right = node7;
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        boolean bl = balancedBinaryTree.isBalanced(node1);
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
    }
}
