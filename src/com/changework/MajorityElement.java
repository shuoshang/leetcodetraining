package com.changework;


import java.util.HashMap;
import java.util.Map;

//遍历整个数组，同时统计每个数字出现的次数。
//最后将出现次数大于一半的元素返回即可。
public class MajorityElement {

    public int majorityElement(int[] nums) {



        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                int t = map.get(nums[i]);
                map.put(nums[i],t+1);
                if(t+1 > (nums.length/2)){
                    return nums[i];
                }
            }
        }
        return nums[0];

    }

    public static void main(String[] args) {

        // write your code here
        MajorityElement majorityElement =  new MajorityElement();
        int[] nums = new int[]{2,2,3,2};
        int majorityelement = majorityElement.majorityElement(nums);
        System.out.println(majorityelement);
    }
}
