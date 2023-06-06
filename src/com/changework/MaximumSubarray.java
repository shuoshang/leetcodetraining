package com.changework;


//最大和的连续子数组（子数组最少包含一个元素），返回其最大和
//注意是连续
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {


        int tmp = nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
           // nums[i]可能大于0也可以小于0，当目前的tmp是负的，最大的就会变成 nums[i]
            if(tmp < 0){
                res = Math.max(res, nums[i]);
                tmp = nums[i];
            }
            // nums[i]可能大于0也可以小于0，当目前的tmp是和正的，最大的就会变成 tmp + nums[i]
            else{
                res = Math.max(res, tmp + nums[i]);
                tmp = tmp + nums[i];
            }
        }
        return res;
    }


   //应用题：画线段
    public int maxSubArray2(int[] nums) {
        int sum = 0;
        // Min value of sum(i), where i < j.
        int min = 0;
        // Max value of delta, where delta = sum(j) - min.
        int max = nums[0];

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            int delta = sum - min;
            if (delta > max) max = delta;
            if (sum < min) min = sum;
        }
        return max;
    }


    public static void main(String[] args) {

        // write your code here
        MaximumSubarray maxSubArray =  new MaximumSubarray();
        int[] tokens = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray.maxSubArray(tokens));
        System.out.println(maxSubArray.maxSubArray2(tokens));
    }
}
