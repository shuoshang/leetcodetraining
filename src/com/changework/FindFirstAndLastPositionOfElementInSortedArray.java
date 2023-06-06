package com.changework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {

        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);
            if (nums[mid] == target) {
                int lIndex = mid - 1, rIndex = mid + 1;
                while (lIndex >= 0 && lIndex < nums.length && nums[lIndex] == target) {
                    lIndex--;
                }
                while (rIndex >= 0 && rIndex < nums.length && nums[rIndex] == target) {
                    rIndex++;
                }
                return new int[]{lIndex + 1, rIndex - 1};
            }
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return new int[]{-1, -1};

    }


    public static void main(String[] args) {

        // write your code here
        FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray =  new FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums  = new int[]{5,7,7,8,8,10};
        int[] n  = findFirstAndLastPositionOfElementInSortedArray.searchRange(nums,8);
        System.out.println(Arrays.toString(n));
    }
}
