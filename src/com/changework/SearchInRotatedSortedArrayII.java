package com.changework;

public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {

        if(nums==null || nums.length==0){
            return false;
        }
        int tail = nums.length -1;
        while(tail > 1 && nums[0] >= nums[tail] && nums[tail] >= nums[tail-1]){
            tail --;
        }
        int begin = 0;
        int end = 0;
        if(target >= nums[0]){
            begin = 0;
            end = tail;

        }else{
            begin = tail;
            end = nums.length -1;
        }

        while(begin <= end){

            int mid = begin + (end - begin)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[mid] > target){
                if(mid == end){
                    if(nums[begin] == target) return true;
                    return false;
                }
                end = mid;
            }
            if(nums[mid] < target){
                if(mid == begin){
                    if(nums[end] == target) return true;
                    return false;
                }
                begin = mid;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        // write your code here
        SearchInRotatedSortedArrayII searchInRotatedSortedArrayII =  new SearchInRotatedSortedArrayII();
        int[] nums  = new int[]{2,5,6,0,0,1,2};
        boolean romantoint = searchInRotatedSortedArrayII.search(nums,0);
        System.out.println(romantoint);
    }
}
