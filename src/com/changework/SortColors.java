package com.changework;

import java.util.Arrays;

//设定两个索引，一个从左往右滑动zero，一个从右往左滑动two。
//遍历nums，当nums[i]的值为1时，i++；
//当nums[i]的值为2时，two的值先减1，而后交换nums[i]与nums[two]，此时在观察nums[i]的值；
//当nums[i]的值为0时，zero++，而后交换nums[i]与nums[zero]，i++;当 i = two时，结束循环。
public class SortColors {

    public int[] sortColors(int[] nums) {

        int zero = -1;
        int two = nums.length ;
        int i = 0;
        while(i < two){
            if(nums[i]==1){
                i++;
            }else if(nums[i]==2){
                two--;
                int k = nums[i];
                nums[i] = nums[two];
                nums[two] = k;
            }else{
                zero ++;
                int k = nums[i];
                nums[i] = nums[zero];
                nums[zero] = k;
                i++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        // write your code here
        SortColors sortColors =  new SortColors();
        int[] nums = new int[]{2,0,2,1,1,0};
        int [] numssorted = sortColors.sortColors(nums);
        System.out.println(Arrays.toString(numssorted));
    }
}
