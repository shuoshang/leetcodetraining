package com.changework;

import java.util.Arrays;


//初始化左指针 left 指向数组起始，初始化右指针 right 指向数组结尾。
//根据已排序这个特性，
//（1）如果 numbers[left] 与 numbers[right] 的和 tmp 小于 target ，说明应该增加 tmp ，因此 left 右移指向一个较大的值。
//（2）如果 tmp大于 target ，说明应该减小 tmp ，因此 right 左移指向一个较小的值。
//（3）tmp 等于 target ，则找到，返回 left + 1 和 right + 1。（注意以 1 为起始下标）
public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right  = numbers.length -1 ;
        int[] res = new int[2];
        while(left < right){

            if(numbers[left]+numbers[right]==target){
                res = new int[]{left+1,right+1};
                break;
            }else if(numbers[left]+numbers[right]<target){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        // write your code here
        TwoSumIIInputArrayIsSorted twoSumIIInputArrayIsSorted =  new TwoSumIIInputArrayIsSorted();
        int[] nums = new int[]{2,7,11,15};
        int [] twoSum2 = twoSumIIInputArrayIsSorted.twoSum(nums,9);
        System.out.println(Arrays.toString(twoSum2));
    }
}
