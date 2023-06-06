package com.changework;

//最长递增子序列：不要求连续
//最长严格递增子序列的长度
//两层循环，第二层 j<i；动态规划都有个dp[i]/dp[j],用的都是当前dp的值

import java.util.Arrays;

//贪心+二分查找
//外层循环，d[len]和num[i]比较通过，比较不通过就走二分查找，也是
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int path[][] = new int[nums.length][nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            //双层循环里的动态规划
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            int k = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] == dp[j] + 1) {
                    // 记录 j 为 i 的来源位置
                    path[i][k++] = j;
                }
            }
            // 占位 -1 表示 dp[i] 是初始化而来
            if (k == 0) path[i][k++] = -1;
            // 末尾标识结束点
            path[i][k] = -2;

            maxans = Math.max(maxans, dp[i]);
        }
        System.out.println(Arrays.deepToString(path));
        return maxans;
    }
    public int lengthOfLIS2(int[] nums) {

        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {  // 当前元素大于最长递增子序列的最后一个元素
                d[len+1] = nums[i];  // 将当前元素添加到递增子序列中
                len++;  // 更新最长递增子序列的长度
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;  // 计算中间位置
                    if (d[mid] < nums[i]) {  // 如果中间位置的值小于当前元素
                        pos = mid;  // 更新位置 pos
                        l = mid + 1;  // 缩小搜索范围，继续向右搜索
                    } else {
                        r = mid - 1;  // 缩小搜索范围，继续向左搜索
                    }
                }
                d[pos + 1] = nums[i];  // 在找到的位置后插入当前元素，更新递增子序列的某个元素
            }
        }
        System.out.println(Arrays.toString(d));  // 输出递增子序列数组，以便查看变化过程
        return len;  // 返回最长递增子序列的长度
    }



    public static void main(String[] args) {

        // write your code here
        LengthOfLIS lengthOfLIS =  new LengthOfLIS();
        int[] maxanst = new int[]{10,9,2,5,3,7,101,18};
//        System.out.println(lengthOfLIS.lengthOfLIS(maxanst));
        System.out.println(lengthOfLIS.lengthOfLIS2(maxanst));

    }
}
