package com.changework;

//找到数组的中间元素 mid。
//如果中间元素 > 数组第 low 个元素，则在 mid 右边搜索变化点。
//如果中间元素 < 数组第 high 个元素，则在 mid 左边搜索变化点。
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {

       int low = 0;
       int high = nums.length-1;
       while(low < high){
           if(nums[low] < nums[high]){
               return nums[low];
           }else{
               int mid = low + (high - low) / 2;
               if (nums[mid] >= nums[low]){
                   low = mid + 1;
               }
               if(nums[mid] < nums[high]){
                   high = mid;
               }
           }
       }
       return nums[low];

    }
    public static void main(String[] args) {

        // write your code here
        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray =  new FindMinimumInRotatedSortedArray();
        int[] tokens = new int[]{2,1};
        int token = findMinimumInRotatedSortedArray.findMin(tokens);
        System.out.println(token);
    }
}
