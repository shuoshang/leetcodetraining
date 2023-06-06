package com.changework;

import java.util.Arrays;

//以 [ 26 ，30] 为例。
//首先，将 [ 26 , 30 ] 的范围数字用二进制表示出来：
//11010　　11011　　11100　　11101　　11110
//而输出 24 的二进制是 11000 。
//可以发现，只要找到二进制的 左边公共部分 即可。
//所以，可以先建立一个 32 位都是 1 的 mask，然后每次向左移一位，比较 m 和 n 是否相同，不同再继续左移一位，直至相同，然后把 m 和 mask 相与就是最终结果。
public class BitwiseANDofNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {

        int d = Integer.MAX_VALUE;
        while (  (m & d) != (n & d)) {

            d <<= 1;
        }
        return m & d;

    }


    public static void main(String[] args) {

        // write your code here
        BitwiseANDofNumbersRange bitwiseANDofNumbersRange =  new BitwiseANDofNumbersRange();
        int[] nums = new int[]{5,7};
        int  number = bitwiseANDofNumbersRange.rangeBitwiseAnd(nums[0],nums[1]);
        System.out.println(number);
    }
}
