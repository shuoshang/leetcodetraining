package com.changework;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if( root == null) return 0;
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
            int len=q.size();
            level++;
            while(len>=1){
                TreeNode tem=q.peek();
                q.poll();
                if(tem.left !=null)  q.add(tem.left);
                if(tem.right !=null) q.add(tem.right);
                if(tem.left==null & tem.right==null){
                    return level;
                }
                len--;
            }
        }
        return level;
    }


    public static void main(String[] args){
        MinimumDepthofBinaryTree minimumDepthofBinaryTree = new MinimumDepthofBinaryTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);

        node1.left = node3;
        node3.right = node4;
        Integer list = minimumDepthofBinaryTree.minDepth(node1);
        System.out.println(list);
    }
}
