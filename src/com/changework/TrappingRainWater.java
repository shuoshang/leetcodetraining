package com.changework;

import java.util.Arrays;

public class TrappingRainWater {

    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        int ans = 0;
        while(left < right){
            if(height[left] < height[right]){
                 if(height[left] >= left_max){
                     left_max = height[left];
                 }else{
                     ans += left_max - height[left];
                 }
                 left = left + 1;
            }else{
                if(height[right] >= right_max){
                    right_max = height[right];
                }else{
                    ans += right_max - height[right];
                }
                right = right - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        // write your code here
        TrappingRainWater trappingRainWater =  new TrappingRainWater();
        int[] nums1 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int n = trappingRainWater.trap(nums1);
        System.out.println(n);
    }
}
