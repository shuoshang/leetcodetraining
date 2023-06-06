package com.changework;

import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int count = 0;
        int k = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[k]=nums[i];
                k++;
            }else{
                count++;
            }
        }
        for(int j=nums.length-1;j>=nums.length-count;j--){
            nums[j]=0;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {

        // write your code here
        MoveZeroes moveZeroes =  new MoveZeroes();
        int[] tokens = new int[]{0,1,0,3,12};
        moveZeroes.moveZeroes(tokens);
//        int token = moveZeroes.moveZeroes(tokens);
//        System.out.println(token);
    }
}
