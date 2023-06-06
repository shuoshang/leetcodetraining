package com.changework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//使用查找表来解决该问题。
//设置一个 map 容器 record 用来记录元素的值与索引，然后遍历数组 nums。
//每次遍历时使用临时变量 mapkey 用来保存目标值与当前值的差值
//在此次遍历中查找 record ，查看是否有与 mapkey 一致的值，如果查找成功则返回查找值的索引值与当前变量的值 i
//如果未找到，则在 record 保存该元素与索引值 i
public class TwoSum {


    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int mapkey = target-nums[i];
            if(map.containsKey(mapkey)){
                return new int[]{map.get(mapkey),i};
            }
            map.put(nums[i],i);
        }
        return null;

    }


    public static void main(String[] args) {

	// write your code here
        TwoSum twoSum =  new TwoSum();
        int[] nums = new int[]{2,7,11,15};
        int [] twoSum2 = twoSum.twoSum(nums,9);
        System.out.println(Arrays.toString(twoSum2));
    }
}
