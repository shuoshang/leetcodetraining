package com.changework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {

            if (!map.containsKey(nums[j])) {
                map.put(nums[j], 1);
            } else {
                map.put(nums[j], map.get(nums[j]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==1){
                res = entry.getKey();
            }
        }
        return res;
    }
        public static void main (String[] args){

            // write your code here
            SingleNumberII singleNumberII = new SingleNumberII();
            int[] nums = new int[]{2, 2, 3, 2};
            int singlenumber = singleNumberII.singleNumber(nums);
            System.out.println(singlenumber);
        }
    }
