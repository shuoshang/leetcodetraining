package com.changework;


import java.util.Arrays;

public class TopKNumber {


    // TopK 会原地把 k 大数放到 a 的前 k 个
    void TopK(int a[], int n, int k) {
        QuickSelect(a, 0, n - 1, k);
        System.out.println(Arrays.toString(a));
    }

    void QuickSelect(int a[], int start, int end, int k) {
        if (start >= end || k <= 0) return;

        int p = Partition(a, start, end);
        int m = p + 1;  // 整个数组中在基准元素左边的元素个数

        if (k < m)
            QuickSelect(a, start, p - 1, k);
        else if (k > m)
            // 注意传 k 而非 k - m ，对齐 m 的意义
            QuickSelect(a, p + 1, end, k);
        else
            return;
    }

    // 数组原地分割，取 v = a[start]
    // >v 在左，=v 在中，<v在右
    // 返回基准元素在整个数组中的位置
    // 和快排完全一样
    int Partition(int a[], int start, int end) {
        int v = a[start];
        int left = start;
        int right = end;
        int i = start;
        while (i <= right) {
            if (a[i] > v) {
                swap(a, i, left);
                left++;
                i++;
            } else if (a[i] < v) {
                swap(a, i, right);
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
        TopKNumber topKNumber =  new TopKNumber();
        int[] nums1 = new int[]{5,3,1,9,7,2,5,8,4};
        topKNumber.TopK(nums1,nums1.length,4);
    }
}
