package com.changework;

import java.util.Arrays;

public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {

        int t = 0;
        while(n!=0){
            n = n/5;
            t = t+n;
        }
        return t;

    }


    public static void main(String[] args) {

        // write your code here
        FactorialTrailingZeroes factorialTrailingZeroes =  new FactorialTrailingZeroes();
        int factorialtrailingZeroes = factorialTrailingZeroes.trailingZeroes(10);
        System.out.println(factorialtrailingZeroes);
    }
}
