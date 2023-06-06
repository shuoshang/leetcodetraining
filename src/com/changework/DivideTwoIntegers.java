package com.changework;

import java.util.Arrays;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;

        boolean k=(dividend>0&&divisor>0)||(dividend<0&&divisor<0);
        int result=0;
        dividend=-Math.abs(dividend);
        divisor=-Math.abs(divisor);
        while(dividend<=divisor) {
            dividend-=divisor;
            result+=1;
        }
        return k?result:-result;
    }

    public static void main(String[] args) {

        // write your code here
        DivideTwoIntegers divideTwoIntegers =  new DivideTwoIntegers();
        int n = divideTwoIntegers.divide(10,3);
        System.out.println(n);
    }
}


