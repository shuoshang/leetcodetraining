package com.changework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntegerReverse {

    public int reverse(int x) {

        long n = 0;
        while(x!=0){
            n = n*10 + x%10;
            x = x/10;
        }

        return (int)n==n ? (int)n:0;

    }


    public static void main(String[] args) {

	// write your code here
        IntegerReverse integerReverse =  new IntegerReverse();
        int reverseint = integerReverse.reverse(-123);
        System.out.println(reverseint);
    }
}
