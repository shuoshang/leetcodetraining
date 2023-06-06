package com.changework;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//题目解析
//用**栈(Stack)**的思路来处理问题。
//中序遍历的顺序为左-根-右，具体算法为：
//从根节点开始，先将根节点压入栈
//然后再将其所有左子结点压入栈，取出栈顶节点，保存节点值
//再将当前指针移到其右子节点上，若存在右子节点，则在下次循环时又可将其所有左子结点压入栈中
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        TreeNode cur = new TreeNode();
        Stack<TreeNode> stack = new Stack<>();
        cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;

    }

    public static void main(String[] args){
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);

        node1.left = node3;
        node3.right = node4;
        List<Integer> list = binaryTreeInorderTraversal.inorderTraversal(node1);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
