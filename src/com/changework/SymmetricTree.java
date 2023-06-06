package com.changework;

import java.util.List;

//用递归做比较简单：
// 一棵树是对称的等价于它的左子树和右子树两棵树是对称的，问题就转变为判断两棵树是否对称
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        if(root==null){
            return true;
        }else {
            return isMirror(root,root);
        }

    }
    public boolean isMirror(TreeNode r1,TreeNode r2){
        if(r1 ==null && r2 ==null) return true;
        if(r1 ==null || r2 ==null) return false;
        return r1.val==r2.val && isMirror(r1.left,r2.right) && isMirror(r1.right,r2.left);
    }


    public static void main(String[] args){
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        node1.left = node3;
        node3.right = node4;
        boolean issymmetrictree = symmetricTree.isSymmetric(node1);
        System.out.println(issymmetrictree);

    }
}
