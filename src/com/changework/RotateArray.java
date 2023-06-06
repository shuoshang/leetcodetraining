package com.changework;

import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {

        for(int i=0;i<=k-1;i++){
            int tmp = nums[nums.length-1];
            for(int j=nums.length-2;j>=0;j--){
                nums[j+1]=nums[j];
            }
            nums[0]=tmp;
        }
    }

    public static void main(String[] args) {

        // write your code here
        RotateArray rotateArray =  new RotateArray();
        int[] nums  = new int[]{1,2,3,4,5,6,7};
        rotateArray.rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }


}
