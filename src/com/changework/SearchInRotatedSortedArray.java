package com.changework;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if(nums[mid] >= nums[lo]){

                if(target >= nums[lo] && target <=nums[mid]){
                    hi = mid -1;
                }else{
                    lo = mid +1;
                }

            }else{

                if(target > nums[mid] && target <=nums[hi]){
                    lo = mid +1;
                }else{
                    hi = mid -1;
                }
            }
    }
        return -1;
    }

    public static void main(String[] args) {

        // write your code here
        SearchInRotatedSortedArray searchInRotatedSortedArray =  new SearchInRotatedSortedArray();
        int[] nums  = new int[]{4,5,6,7,0,1,2};
        int romantoint = searchInRotatedSortedArray.search(nums,0);
        System.out.println(romantoint);
    }
}
