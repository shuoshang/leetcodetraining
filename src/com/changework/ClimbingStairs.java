package com.changework;

public class ClimbingStairs {
    public int climbStairs(int n) {

//        if(n ==0 || n==1){
//            return 1;
//        }else if(n == 2){
//            return 2;
//        }else{
//            return climbStairs(n-1)+climbStairs(n-2);
//        }

        int[] dp =  new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        if(n<=1){
            return dp[n];
        }else{
            for(int i=2;i<=n;i++){
                dp[i]=dp[i-1]+dp[i-2];
            }
            return dp[n];
        }
     }

    public static void main(String[] args) {

        // write your code here
        ClimbingStairs climbingStairs =  new ClimbingStairs();
        int  number = climbingStairs.climbStairs(45);
        System.out.println(number);
    }
}
