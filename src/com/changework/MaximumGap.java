package com.changework;

import java.util.Arrays;
import java.util.Stack;

public class MaximumGap {

    public int maximumGap(int[] nums) {

        Arrays.sort(nums);
        int res=0;
        if(nums.length<2){
            return 0;
        }
        Stack<Integer> s = new Stack<>();
        for(int i = 0;i< nums.length;i++){
            if(i==0){
                s.push(nums[i]);
            }else{
                res = Math.max(res,nums[i]-s.peek());
                s.pop();
                s.push(nums[i]);
            }
        }

        return res;
    }


    public static void main(String[] args) {

        // write your code here
        MaximumGap maximumGap =  new MaximumGap();
        int[] tokens = new int[]{3,6,9,1};
        int token = maximumGap.maximumGap(tokens);
        System.out.println(token);
    }
}
