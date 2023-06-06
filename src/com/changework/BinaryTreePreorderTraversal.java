package com.changework;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        TreeNode cur = new TreeNode();
        Stack<TreeNode> stack = new Stack<>();
        cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur!=null){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return list;

//        if(root != null){
//            list.add(root.val);
//            inorderTraversal(root.left);
//            inorderTraversal(root.right);
//        }
//        return list;
    }


    public static void main(String[] args){
        BinaryTreePreorderTraversal binaryTreePreorderTraversal = new BinaryTreePreorderTraversal();
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);

        node1.left = node3;
        node3.right = node4;
        List<Integer> list = binaryTreePreorderTraversal.inorderTraversal(node1);
        System.out.println(list);
    }
}
