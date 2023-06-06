package com.changework;

import java.util.Arrays;

//删除排序数组中的重复项
//使用快慢指针来记录遍历的坐标
//开始时这两个指针都指向第一个数字
//如果两个指针指的数字相同，则快指针向前走一步
//如果不同，则两个指针都向前走一步
//当快指针走完整个数组后，慢指针当前的坐标加1就是数组中不同数字的个数
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {

        int length = nums.length;
        if(length==0){
            return 0;
        }
        int n = length;
        for(int i =0;i<n;i++){
            if(i==n-1){
                return n;
            }
            int k = 0;
            int m = i;
            while(m+1<n && nums[m+1]==nums[i]){
                m=m+1;
                k=k+1;
            }
            if(k!=0 && m+1<n) {
                for (int j = m + 1; j < n; j++) {
                    nums[j - k] = nums[j];
                }
            }
            n=n-k;
        }
        return n;

    }
    public static void main(String[] args) {

        // write your code here
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray =  new RemoveDuplicatesFromSortedArray();
        int[] nums1 = new int[]{1,1,2};
        int n = removeDuplicatesFromSortedArray.removeDuplicates(nums1);
        System.out.println(n);
    }
}
