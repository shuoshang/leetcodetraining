package com.changework;
//递增的三元子序列
//双向遍历
//首先简化该问题，如果求递增的二元子序列，该如何做？
//二元的话，对于位置 ii, 只要判断其前面 [0,i-1][0,i−1] 存不存在比其小的就可以了，因此我们遍历数组，可以维护一个最小值数组，对于位置 ii，表示数字 [0,i][0,i] 中的最小值。
//因此，如果位置 ii 的数字 大于 [0,i][0,i] 中的最小值，就表示存在递增的二元子序列。
//回到本题，如果求递增的三元组？
//三元组 i < j < ki<j<k，如果枚举中间位置 jj, 分别看 i < ji<j 和 j < kj<k，就可以转化为两个递增的二元子序列。
//对于 i < ji<j ，正向遍历数组，维护最小值，对于位置 ii，表示[0,i][0,i] 中的最小值。
//对于 j < kj<k ，反向遍历数组，维护最大值，对于位置 ii，表示[i,nums.length-1][i,nums.length−1] 中的最大值。
//因此，遍历数组，考虑每一个位置 jj，如果 nums[j]nums[j] 大于左边的 [0,i][0,i] 中的最小值，小于右边的 [i,nums.length][i,nums.length] 中的最大值，即存在递增的三元子序列。
//时间复杂度：O(n)O(n)
//空间复杂度：O(n)O(n)


import java.util.Arrays;

public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        int [] left_min = new int[nums.length];
        int [] right_max = new int[nums.length];

        left_min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            left_min[i] = Math.min(nums[i], left_min[i - 1]);
        }
        System.out.println(Arrays.toString(left_min));

        right_max[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            right_max[i] = Math.max(nums[i], right_max[i + 1]);

        }
        System.out.println(Arrays.toString(right_max));

        for (int i = 1; i < nums.length - 1; i++) {
            if (left_min[i] < nums[i] && nums[i] < right_max[i])
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,5,0,4,6};
        IncreasingTriplet zeroes=  new IncreasingTriplet();
        System.out.print(zeroes.increasingTriplet(nums) );
    }
}
