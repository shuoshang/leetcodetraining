package com.changework;

public class SearchInsertPosition {


    public int searchInsert(int[] nums, int target) {

        for(int i = 0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }else if(nums[i] > target){
                return i;
            }else{
                continue;
            }
        }
        return nums.length;

    }

    public static void main(String[] args) {

        // write your code here
        SearchInsertPosition searchInsertPosition =  new SearchInsertPosition();
        int[] nums  = new int[]{1,3,5,6};
        int romantoint = searchInsertPosition.searchInsert(nums,2);
        System.out.println(romantoint);
    }
}
