package com.changework;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {

        int j = 1;
        int count = 1;
        if(nums.length<=2){
            return nums.length;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                count++;
            }else{
                count = 1;
            }
            if(count <= 2){
                nums[j] = nums[i];
                j+=1;
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;

    }


    public static void main(String[] args) {

        // write your code here
        RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII =  new RemoveDuplicatesFromSortedArrayII();
//        int[] nums1 = new int[]{0,0,1,1,1,1,2,3,3};
//        int[] nums1 = new int[]{1,1,1,2,2,3};
        int[] nums1 = new int[]{1,1,1};
        int n = removeDuplicatesFromSortedArrayII.removeDuplicates(nums1);
        System.out.println(n);
    }
}
