package com.changework;

import java.util.ArrayList;
import java.util.Arrays;

//这里提到了时间复杂度为 O(log(m+n)) ，很容易想到的就是二分查找，所以现在要做的就是在两个排序数组中进行二分查找。
//具体思路如下，将问题 转化为在两个数组中找第 K 个小的数 。
//求中位数，其实就是求第 k 小数的一种特殊情况。
//首先在两个数组中分别找出第 k/2 大的数，再比较这两个第 k/2 大的数，这里假设两个数组为 A ，B。
//那么比较结果会有下面几种情况：
//A[k/2] = B[k/2],那么第 k 大的数就是 A[k/2]
//A[k/2] > B[k/2],那么第 k 大的数肯定在 A[0:k/2+1] 和 B[k/2:] 中，这样就将原来的所有数的总和减少到一半了，再在这个范围里面找第 k/2 大的数即可，这样也达到了二分查找的区别了。
//A[k/2] > B[k/2],那么B[k/2]前面那些数字就不用参与了，下一个位置就是减去那几个不用参与的数量
//A[k/2] < B[k/2]，那么第 k 大的数肯定在 B[0:k/2+1]和 A[k/2:] 中，同理在这个范围找第 k/2 大的数就可以了。
//A[k/2] < B[k/2],那么A[k/2]前面那些数字就不用参与了
public class MedianofTwoSortedArrays2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex  = totalLength / 2;
            double median = getKth(nums1, nums2, length1,length2,midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKth(nums1, nums2,length1,length2, midIndex1 + 1) + getKth(nums1, nums2, length1,length2,midIndex2 + 1)) / 2.0;
            return median;
        }
    }

        //一个小技巧：将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。

    private int getKth(int[] nums1, int[] nums2,int m,int n,int k) {

        int length1 = m;
        int length2 = n;
        int index1 = 0, index2 = 0;

        while (true) {
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int t = k / 2;
            int newindex1 = Math.min(t + index1, length1);
            int newindex2 = Math.min(t + index2, length2);
            int p1 = nums1[newindex1 - 1];
            int p2 = nums2[newindex2 - 1];
            if (p1 <= p2) {
                k = k - (newindex1 - index1);
                index1 = newindex1;
            } else {
                k = k - (newindex2 - index2);
                index2 = newindex2;
            }
        }
    }

    public static void main(String[] args) {

        // write your code here
        MedianofTwoSortedArrays2 medianofTwoSortedArrays2 =  new MedianofTwoSortedArrays2();
        int[] nums1 = new int[]{1,3,4,7};
        int[] nums2 = new int[]{1,2,3,4,5,6,7,8,9,10};
        double median = medianofTwoSortedArrays2.findMedianSortedArrays(nums1,nums2);
        System.out.println(median);
    }
}
