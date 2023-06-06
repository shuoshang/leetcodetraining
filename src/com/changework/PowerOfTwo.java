package com.changework;

import java.util.Arrays;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        int a = n & (n-1);
        if(a ==0 && n >0){
            return true;
        }else{
        return false;
        }
    }

    public static void main(String[] args) {

        // write your code here
        PowerOfTwo powerOfTwo =  new PowerOfTwo();
        boolean poweroftwo = powerOfTwo.isPowerOfTwo(1);
        System.out.println(poweroftwo);
    }
}
