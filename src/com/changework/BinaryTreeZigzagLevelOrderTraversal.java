package com.changework;

import java.util.*;

//二叉树的锯齿形层次遍历
//该问题需要用到队列，与之前的二叉树的层次遍历类似，不同点在于在偶数层需要翻转一下。
//建立一个queue
//先把根节点放进去，这时候找根节点的左右两个子节点
//去掉根节点，此时queue里的元素就是下一层的所有节点
//循环遍历，将结果存到一个一维向量里
//遍历完之后再把这个一维向量存到二维向量里
//如果该层为偶数层，则reverse翻转一下
//以此类推，可以完成层序遍历
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        int count = 1;
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
                count = count+1;
                List<Integer> newlist2 = new ArrayList<>();
                while(!queue2.isEmpty()){
                    newlist2.add(queue2.peek().val);
                    queue.add(queue2.peek());
                    queue2.poll();
                }
                if(newlist2.size()!=0 && count%2 !=0){
                    list.add(newlist2);
                }
                if(newlist2.size()!=0 && count%2 ==0){
                    Collections.reverse(newlist2);
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
        return list;
    }

    public static void main(String[] args){
        BinaryTreeZigzagLevelOrderTraversal binaryTreeZigzagLevelOrderTraversal = new BinaryTreeZigzagLevelOrderTraversal();
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
        List<List<Integer>> list = binaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(node1);
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
    }

}
