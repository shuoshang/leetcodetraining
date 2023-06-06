package com.changework;

import java.text.SimpleDateFormat;
import java.util.*;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        TreeNode cur = new TreeNode();
        TreeNode pre = new TreeNode();
        pre =  null;
        if (root ==null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if(pre !=null && pre.val >= cur.val) return false;
                pre =  cur;
                cur = cur.right;
            }
        }
        return true;

//        return helper(root,null,null);

    }

    public boolean helper(TreeNode node,Integer lower,Integer upper){
        if(node == null){
            return true;
        }
        int val =  node.val;
        if(lower!=null && val<=lower){
            return false;
        }
        if(upper!=null && val>=upper){
            return false;
        }
        if(!helper(node.left,lower,val)){
            return false;
        }
        if(!helper(node.right,val,upper)){
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);

//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(1);
//        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        boolean list = validateBinarySearchTree.isValidBST(node1);
        System.out.println(list);
    }
}
