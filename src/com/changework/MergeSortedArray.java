package com.changework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) throws ParseException {

//        int i = 0;
//        int j = 0;
//        int count = 0;
//        while(j<=n-1 && i<=m+count){
//
//                if(nums1[i]<=nums2[j] ){
//                    i++;
//                }else{
//                    for(int k=nums1.length-2;k>=i;k--){
//                        nums1[k+1]=nums1[k];
//                    }
//                    count++;
//                    nums1[i]=nums2[j];
//                    i++;
//                    j++;
//                }
//            }
//        int t = i-1;
//        while( t<=nums1.length-1 && j<=n-1){
//            nums1[t]=nums2[j];
//            t++;
//            j++;
//        }

        int i = m - 1, j = n - 1;
        int idx = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                nums1[idx--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
            } else if (i >= 0) {
                nums1[idx--] = nums1[i--];
            } else {
                nums1[idx--] = nums2[j--];
            }
        }
        System.out.println(Arrays.toString(nums1));

        String transDate = "20200229";
        String accDate = "20210729";

        Date todate = new SimpleDateFormat("yyyyMMdd").parse(transDate);
        Calendar calendar = Calendar.getInstance(); // 得到日历
        calendar.setTime(todate);// 把当前时间赋给日历
        calendar.add(Calendar.MONTH, 18); // 设置为下一个月
        Date date = calendar.getTime();
        String res = new SimpleDateFormat("yyyyMMdd").format(date);
        if (accDate
                .compareTo(res) < 0) {
            boolean result = true;
            System.out.println(result);
        }
    }
    public static void main(String[] args) throws ParseException {

        // write your code here
        MergeSortedArray mergeSortedArray =  new MergeSortedArray();

//        int[] nums1 = new int[]{1,2,3,0,0,0};
//        int[] nums2 = new int[]{2,5,6};
        int[] nums1 = new int[]{-1,0,0,3,3,3,0,0,0};
        int[] nums2 = new int[]{1,2,2};
//        int[] nums1 = new int[]{1,2,3,0,0,0};
////        int[] nums2 = new int[]{4,5,6};
        mergeSortedArray.merge(nums1,3,nums2,3);

    }
}
