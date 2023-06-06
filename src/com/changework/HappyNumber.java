package com.changework;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n!=1 && !set.contains(n)){
            set.add(n);
            n = gettatalnum(n);
        }
        return n == 1;
    }

    public int gettatalnum(int n){
        int totalnum =0;
        while(n!=0){
            int d = n % 10;
            n = n / 10;
            totalnum += d * d;
        }
        return totalnum;
    }


    public static void main(String[] args) {

        // write your code here
        HappyNumber happyNumber =  new HappyNumber();
        boolean  number = happyNumber.isHappy(19);
        System.out.println(number);
    }
}
