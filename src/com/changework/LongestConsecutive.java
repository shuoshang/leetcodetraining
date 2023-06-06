package com.changework;

import java.util.Arrays;


//最长连续序列：先排序
//这道题是主要是因为连续
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int res = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                temp++;
            } else {
                //如果不连续了就从头开始
                temp = 1;
            }
            res = Math.max(temp, res);
        }
        return res;
    }

    public static void main(String[] args) {

        // write your code here
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int[] maxanst = new int[]{100, 4, 200, 1, 3, 2};
        int maxans = longestConsecutive.longestConsecutive(maxanst);
        System.out.println(maxans);

    }
}
