package com.changework;


//快速排序
//找到基准元素再递归
import java.util.Arrays;

public class TopKNumberOp {
    public int[] smallestK(int[] arr, int k) {
        QuickSelect(arr, 0, arr.length- 1, k);
       return  Arrays.copyOfRange(arr, 0, k);
    }


    void QuickSelect(int arr[], int start, int end, int k) {
        if (start >= end || k <= 0) return;

        int p = Partition(arr, start, end);
        int m = p + 1;  // 整个数组中在基准元素左边的元素个数

        if (k < m)
            QuickSelect(arr, start, p - 1, k);
        else if (k > m)
            // 注意传 k 而非 k - m ，对齐 m 的意义
            QuickSelect(arr, p + 1, end, k);
        else
            return;
    }

    // 数组原地分割，取 v = a[start]
    // >v 在左，=v 在中，<v在右
    // 返回基准元素在整个数组中的位置
    // 和快排完全一样
    int Partition(int arr[], int start, int end) {
        int v = arr[start];
        int left = start;
        int right = end;
        int i = start;
        while (i <= right) {
            if (arr[i] < v) {
                swap(arr, i, left);
                left++;
                i++;
            } else if (arr[i] > v) {
                //i不动
                swap(arr, i, right);
                right--;
            } else {
                i++;
            }
        }
        return i - 1;
    }

    public void swap(int[] nums, int i, int index) {
        int k = nums[i];
        nums[i] = nums[index];
        nums[index] = k;
    }

    public static void main(String[] args) {

        // write your code here
        TopKNumberOp topKNumber =  new TopKNumberOp();
        int[] nums1 = new int[]{1,3,5,7,2,4,6,8};
        System.out.println(Arrays.toString(topKNumber.smallestK(nums1,4)));;
    }
}
