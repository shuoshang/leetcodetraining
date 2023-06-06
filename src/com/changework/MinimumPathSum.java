package com.changework;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int [m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[0][0] =  grid[0][0];
                }else if(i>0 && j==0){
                    dp[i][0] = dp[i-1][0] + grid[i][0];
                }else if(j>0 && i==0){
                    dp[0][j] = dp[0][j-1] + grid[0][j];
                }else{
                    dp[i][j] =  Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {

        // write your code here
        MinimumPathSum minimumPathSum =  new MinimumPathSum();
//        int[][] nums1 = new int[][]{{0,0}};
        int[][] nums1 = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int matrix = minimumPathSum.minPathSum(nums1);
        System.out.println ( matrix);

    }
}
