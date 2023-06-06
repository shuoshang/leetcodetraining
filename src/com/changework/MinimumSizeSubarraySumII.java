package com.changework;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//长度最小的子数组-209
//给定一个n个正整数的数组和一个正整数 target 。
//找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
// 并返回其长度。如果不存在符合条件的子数组，返回 0 。

public class MinimumSizeSubarraySumII {

    List<List<Integer>> res = new LinkedList<>();
    int retes ;
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int ret = nums.length;
        retes = nums.length;
        for(int i =0;i<nums.length;i++){
            dfs(new LinkedList<>(),new LinkedList<>(),i,nums,ret,s,sum);
        }
        if(res.size()==0){
            System.out.println(res);
            return 0;
        }
        System.out.println(res);
        return retes;

    }
    public void dfs(LinkedList<Integer> remain,LinkedList<Integer> remainindex ,int first,int[] nums,int ret,int s,int sum){
        if(sum >= s){  //判断终止条件
            ret =  Math.min(remain.size(),retes);
            retes = ret;
            res.add(new LinkedList<Integer>(remain));  //添加到结果中
            return;
        }

        if(first >nums.length-1) return;

        remain.add(nums[first]);
        sum = sum + nums[first];
        dfs(remain,remainindex,first+1,nums,ret ,s ,sum);
        sum = sum - remain.get(remain.size()-1);
        remain.remove(remain.size()-1);
    }
    public static void main(String[] args){
        // write your code here
        MinimumSizeSubarraySumII minimumSizeSubarraySumII =  new MinimumSizeSubarraySumII();
//        int[] nums = new int[]{12,28,83,4,25,26,25,2,25,25,25,12};
        int[] nums = new int[]{12,28,83,4,25,26,25,2,25,25,25,12};
        int palindromepartitioning = minimumSizeSubarraySumII.minSubArrayLen(213,nums);
        System.out.println(palindromepartitioning);
    }
}