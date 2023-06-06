package com.changework;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//因为是左右根，所以根右左入库
public class BinaryTreePostorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        TreeNode cur, pre = null;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                list.add(cur.val);
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null)
                    stack.push(cur.right);
                 if (cur.left != null)
                    stack.push(cur.left);
            }
        }
        return list;
    }

    public static void main(String[] args){
        BinaryTreePostorderTraversal binaryTreePostorderTraversal = new BinaryTreePostorderTraversal();
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);

        node1.left = node3;
        node3.right = node4;
        List<Integer> list = binaryTreePostorderTraversal.inorderTraversal(node1);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
