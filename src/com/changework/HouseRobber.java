package com.changework;

import java.util.Arrays;

public class HouseRobber {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length==0 || nums == null){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {

        // write your code here
        HouseRobber houseRobber =  new HouseRobber();
        int[] nums  = new int[]{1,2,3,1};
        int rob = houseRobber.rob(nums);
        System.out.println(rob);
    }
}
