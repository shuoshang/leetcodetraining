package com.changework;


public class SqrtX {
    public int mySqrt(int x) {
        int l = 0 ;
        int r = x ;
        int ans = -1;
        while(l<=r){
           int mid = l + (r-l)/2;
           if((long)mid * mid <= x){
               ans = mid;
               l = mid + 1;
           }else{
               r = mid - 1;
           }
        }
        return ans;

    }
    public static void main(String[] args) {
        // write your code here
        SqrtX sqrtX =  new SqrtX();
        int  numssorted = sqrtX.mySqrt(8);
        System.out.println(numssorted);
    }
}
