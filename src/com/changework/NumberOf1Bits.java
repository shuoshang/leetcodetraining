package com.changework;

public class NumberOf1Bits {

    public int hammingWeight(int n) {

        int t = 0;
        while(n!=0){
            t++;
            n = n & (n-1);
        }
        return t;
    }

    public static void main(String[] args) {

        // write your code here
        NumberOf1Bits numberOf1Bits =  new NumberOf1Bits();
        int  baoshu = numberOf1Bits.hammingWeight(00000000000000000000000000001011);
        System.out.println(baoshu);
    }
}
