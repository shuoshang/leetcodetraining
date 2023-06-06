package com.changework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//二叉树的右视图
//与之前二叉树的层次遍历类似的，该问题需要用到队列,
//建立一个 queue
//遍历每层的节点时，把下一层的节点都存入到 queue 中
//每当开始新一层节点的遍历之前，先把新一层最后一个节点值存到结果中
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        TreeNode cur = null;
        queue.add(root);
        List<Integer> list =  new ArrayList<>();
        if(root == null)
            return list;
        while(!queue.isEmpty()){
            cur = queue.peek();
            queue.poll();
            if(queue.isEmpty()){
                list.add(cur.val);
                if (cur.left != null) {
                    queue2.add(cur.left);
                }
                if (cur.right != null) {
                    queue2.add(cur.right);
                }
                while(!queue2.isEmpty()){
                    queue.add(queue2.peek());
                    queue2.poll();
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
        return list;
    }

    public static void main(String[] args){
        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
        node2.right = node5;
        List<Integer> list = binaryTreeRightSideView.rightSideView(node1);
        System.out.println(list.toString());
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
    }
}
