package com.changework;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int res =nums[0] ;
       for(int i = 1;i<nums.length;i++){

           res = res ^ nums[i];
       }
       return res;


    }

    public static void main(String[] args) {

        // write your code here
        SingleNumber singleNumber =  new SingleNumber();
        int[] nums = new int[]{4,1,2,1,2};
        int singlenumber = singleNumber.singleNumber(nums);
        System.out.println(singlenumber);
    }
}
