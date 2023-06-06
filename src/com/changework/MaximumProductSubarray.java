package com.changework;

import org.omg.PortableInterceptor.INACTIVE;

//乘积最大值
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i],nums[i]);
            imin = Math.min(imin * nums[i],nums[i]);
            max = Math.max(max,imax);
        }
        return max;

    }

    public static void main(String[] args) {

        // write your code here
        MaximumProductSubarray maximumProductSubarray =  new MaximumProductSubarray();
        int[] tokens = new int[]{2,3,-2,4};
        int token = maximumProductSubarray.maxProduct(tokens);
        System.out.println(token);
    }


}
