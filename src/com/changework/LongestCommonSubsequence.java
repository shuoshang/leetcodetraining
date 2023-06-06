package com.changework;


//最长公共子序列：和公共子串的不同是，公共子序列不要求连续。
//最长公共子串
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] df = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //比较前一个值
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    df[i][j] = df[i - 1][j - 1] + 1;
                } else {
                    df[i][j] = Math.max(df[i - 1][j], df[i][j - 1]);

                }
            }
        }
        return df[n][m];
    }


    public int longestCommonSubstring(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] df = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //比较前一个值
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (i >= 1 && j >= 1)
                        df[i][j] = df[i - 1][j - 1] + 1;
                    else
                        df[i][j] = 1;
                } else {
                    df[i][j] = 0;
                }
                if (df[i][j] > max) {
                    max = df[i][j];
                }
            }

        }
        return max;
    }

    public static void main(String[] args) {

        // write your code here
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        int longestcommonprefix1 = longestCommonSubsequence.longestCommonSubsequence("abcde", "ace");
        int longestcommonprefix2 = longestCommonSubsequence.longestCommonSubstring("abcbcde", "bbcbce");
        System.out.println(longestcommonprefix1);
        System.out.println(longestcommonprefix2);

    }

}
