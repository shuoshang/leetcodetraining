package com.changework;

import java.util.Arrays;

//动态规划
public class UniquePaths {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int [m][n];
        Arrays.fill(dp[0],1);
        for(int i=1;i<m;i++){
            dp[i][0]=1;
            for(int j=1;j<n;j++){
                dp[i][j] =dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {

        // write your code here
        UniquePaths uniquePaths =  new UniquePaths();
        int matrix = uniquePaths.uniquePaths(3,3);
        System.out.println ( matrix);

    }
}
