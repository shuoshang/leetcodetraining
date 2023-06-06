package com.changework;

import java.util.Arrays;

public class StoneGame {

    public boolean stoneGame(int[] piles) {

                int len = piles.length;
                //dp数组代表从i号数字到j号数字先手能赢后手的石头数
                int[][] dp = new int[len][len];
                for(int i=0;i<len;i++){
                    dp[i][i] = piles[i];
                }
                for(int i=len-1;i>=0;i--){
                    for(int j=i+1;j<len;j++){
                        dp[i][j] = Math.max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1]);
                    }
                }
                //打印确认 此处可以省略
                for(int i=0;i<len;i++){
                    System.out.println(Arrays.toString(dp[i]));
                }
                return dp[0][len-1]>0;
            }


    public static void main(String[] args) {
        // write your code here
        StoneGame stoneGame =  new StoneGame();
        int[] nums = new int[]{5,3,4,5};
        boolean res = stoneGame.stoneGame(nums);
        System.out.println(res);
    }
}
