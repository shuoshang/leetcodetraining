package com.changework;

import java.util.Arrays;

public class FastSort {

    //6,1,2,7,9,3,4,5,10,8
    public void fastSort(int[] ss,int low ,int high){

        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = ss[low];
        while( i < j) {
            while (temp <= ss[j] && i < j) {
                j--;
            }
            while (temp >= ss[i] && i < j) {
                i++;
            }
            if (i < j) {
                t = ss[j];
                ss[j] = ss[i];
                ss[i] = t;
            }
        }
            ss[low] = ss[i];
            ss[i] = temp;
            //递归调用左半数组
            fastSort(ss, low, j-1);
            //递归调用右半数组
            fastSort(ss, j+1, high);

    }


    public static void main(String[] args) {

        // write your code here
        FastSort fastSort =  new FastSort();
        int[] ss =  new int[]{6,1,2,7,9,3,4,5,10,8};
        fastSort.fastSort(ss,0,ss.length-1);
        System.out.println(Arrays.toString(ss));
    }

}
