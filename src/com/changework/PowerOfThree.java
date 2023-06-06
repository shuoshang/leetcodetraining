package com.changework;


//在此范围中允许的最大的 3 的次方数为 319 = 1162261467 ，那么只要看这个数能否被 n 整除即可。
public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        int a;
        if(n!=0){
            a = 1162261467 % n;
        }else{
            return false;
        }
        if(a == 0 && n > 0){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args) {

        // write your code here
        PowerOfThree powerOfThree =  new PowerOfThree();
        boolean powerofthree = powerOfThree.isPowerOfThree(27);
        System.out.println(powerofthree);
    }
}
