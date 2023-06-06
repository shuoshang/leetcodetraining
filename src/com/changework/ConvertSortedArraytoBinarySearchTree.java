package com.changework;

import java.util.ArrayList;
import java.util.List;

//将有序数组转换成二叉树
public class ConvertSortedArraytoBinarySearchTree {

    List<Integer> list = new ArrayList<>();
    public TreeNode sortedArrayToBST(int[] nums) {
        return  helper(nums,0 ,nums.length-1);
    }

    public TreeNode helper(int[]nums,int left,int right) {
       if(left>right){
           return null;
       }
       int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,left,mid - 1);
        root.right = helper(nums,mid+1,right);
        return root;
    }

    public static void main(String[] args){
        ConvertSortedArraytoBinarySearchTree convertSortedArraytoBinarySearchTree = new ConvertSortedArraytoBinarySearchTree();

        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode list = convertSortedArraytoBinarySearchTree.sortedArrayToBST(nums);
    }
}
