package com.changework;

//最大连续子序列和，又名最大和的连续子数组（子数组最少包含一个元素），返回其最大和
//注意是连续
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int tmp = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // nums[i]可能大于0也可以小于0，当目前的tmp是负的，最大的就会变成 nums[i]
            if (tmp < 0) {
                res = Math.max(res, nums[i]);
                tmp = nums[i];
            }
            // nums[i]可能大于0也可以小于0，当目前的tmp是和正的，最大的就会变成 tmp + nums[i]
            else {
                res = Math.max(res, tmp + nums[i]);
                tmp = tmp + nums[i];
            }
        }
        return res;
    }

    //动态规划方法
    //nums[i] 是所考虑的连续数组的结尾元素，因此 dp(i) 必然包含 nums[i] 作为成分
    //假设已知 dp(i-1)，考虑其递推到 dp(i)：
    int maxSubArray2(int nums[], int length) {
        if (length <= 0) return 0;

        int max = 0;
        int[] dp = new int[length];
        dp[0] = nums[0];

        for (int i = 1; i < length; i++) {
            //如果 dp(i-1) 是正数，考虑到要求最大和，因此将它吸收，即 dp(i) = dp(i-1) + nums[i]
            if (dp[i - 1] > 0)
                dp[i] = dp[i - 1] + nums[i];
            //否则，不吸收 dp(i-1) ，即 dp(i) = nums[i]
            else
                dp[i] = nums[i];
            //对所有 0..n-1 的 i 求解其 dp(i) ，找出其中最大值即结果
            if (max < dp[i]) max = dp[i];
        }
        return max;
    }

    //当成应用题：画线段
    //任意一个连续数组 [i..j] 之和可以表达为 sum(j) - sum(i-1)
    //要使右侧区间内数字之和最大， 势必要求左侧前缀和 sum(i-1) 最小
    //也就是，要找出 j 左边的前缀和的最小值，它可以在计算前缀和的过程中记录下来
    //最后，对所有 j 找出其右侧区间的最大和 ，记录其中最大的即结果。
    public int maxSubArray3(int[] nums) {
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
        MaximumSubarray maxSubArray = new MaximumSubarray();
        int[] tokens = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray.maxSubArray(tokens));
        System.out.println(maxSubArray.maxSubArray2(tokens, tokens.length));
        System.out.println(maxSubArray.maxSubArray3(tokens));
    }
}
