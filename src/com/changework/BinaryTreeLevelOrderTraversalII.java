package com.changework;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        TreeNode cur = null;
        queue.add(root);
        List<List<Integer>> list =  new ArrayList<>();
        if(root == null)
            return list;
        List<Integer> newlist = new ArrayList<>();
        newlist.add(root.val);
        list.add(newlist);
        while(!queue.isEmpty()){
            cur = queue.peek();
            queue.poll();
            if(queue.isEmpty()){
                if (cur.left != null) {
                    queue2.add(cur.left);
                }
                if (cur.right != null) {
                    queue2.add(cur.right);
                }
                List<Integer> newlist2 = new ArrayList<>();
                while(!queue2.isEmpty()){
                    newlist2.add(queue2.peek().val);
                    queue.add(queue2.peek());
                    queue2.poll();
                }
                if(newlist2.size()!=0 ){
                    list.add(newlist2);
                }
            }else{
                if (cur.left != null) {
                    queue2.add(cur.left);
                }
                if (cur.right != null) {
                    queue2.add(cur.right);
                }
            }
        }
//        Collections.reverse(list);
        return list;
    }
    public static void main(String[] args){
        BinaryTreeLevelOrderTraversalII binaryTreeLevelOrderTraversalII = new BinaryTreeLevelOrderTraversalII();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        TreeNode node6 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node2.left = node6;
        node2.right = node7;

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        List<List<Integer>> list = binaryTreeLevelOrderTraversalII.levelOrderBottom(node1);
        System.out.println(list.toString());
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
    }
}
