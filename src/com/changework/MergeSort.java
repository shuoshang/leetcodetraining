package com.changework;

import java.util.Arrays;

public class MergeSort {

        public static int[] sort(int[] data, int left, int right) {
            if (left >= right)
                return data;
            // 找出中间索引
            int center = (left + right) / 2;
            // 对左边数组进行递归nums
            sort(data, left, center);
            // 对右边数组进行递归
            sort(data, center + 1, right);
            // 合并
            merge(data, left, center, right);
//            System.out.println(Arrays.toString(data));

            return data;
        }

/**
 * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序
 *
 * @param data   数组对象
 * @param left   左数组的第一个元素的索引
 * @param center 左数组的最后一个元素的索引，center+1是右数组第一个元素的索引
 * @param right  右数组最后一个元素的索引
 */
        public static void merge(int[] data, int left, int center, int right) {
            // 临时数组
            int[] tmpArr = new int[data.length];
            // 右数组第一个元素索引
            int mid = center + 1;
            // third 记录临时数组的索引
            int third = left;
            // 缓存左数组第一个元素的索引
            int tmp = left;
            while (left <= center && mid <= right) {
                // 从两个数组中取出最小的放入临时数组
                if (data[left] <= data[mid]) {
                    tmpArr[third++] = data[left++];
                } else {
                    tmpArr[third++] = data[mid++];
                }
            }
            // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
            while (mid <= right) {
                tmpArr[third++] = data[mid++];
            }
            while (left <= center) {
                tmpArr[third++] = data[left++];
            }
            // 将临时数组中的内容拷贝回原数组中
            // （原left-right范围的内容被复制回原数组）
            while (tmp <= right) {
                data[tmp] = tmpArr[tmp++];
            }
        }

    public static void main(String[] args) {
        // write your code here
        MergeSort mergeSort =  new MergeSort();
//        int[] nums = new int[]{6,2,7,2,5,7,3,9};
        int[] nums = new int[]{1,2,2,3,3,3,4,4,4,4,5,5,5,5,5};
        sort(nums,0,nums.length-1);
//        int sum = 0;
//        for(int i=0 ;i<nums.length-sum;i++){
//            int count = 0;
//            int j = i+1;
//            while(nums[i] == nums[j] && j<nums.length-sum){
//                count ++;
//                j++;
//            }
//            if(count>=1){
//                for(int k =j;k<nums.length-sum;k++){
//                    nums[k-count] = nums[k];
//                }
//            }
//            sum = sum + count;
//        }
//        System.out.println(sum);
        int i = 0;
        int j = i+1;
        while(j < nums.length){
            while(nums[i] != nums[j] &&  j !=  nums.length -1){
                i++;
                j++;
            }
            if(j == nums.length -1){
                break;
            }
            while(nums[i] == nums[j] && j !=  nums.length -1){
                j++;
            }
            if(j == nums.length -1){
                i++;
                nums[i] = nums[j];
                break;
            }
            i++;
            nums[i] = nums[j];
            j++;
            while(nums[i] != nums[j] &&  j !=  nums.length -1){
                i++;
                nums[i] = nums[j];
                j++;
            }
            if(j == nums.length -1 && nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
                break;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
