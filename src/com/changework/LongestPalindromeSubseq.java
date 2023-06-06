package com.changework;


//最长回文子序列：和最长回文子串的区别是可以不连续
//如果子串的两边字符相等，那么去掉这俩字符后的子串的最长回文子序列长度比原来少了 2
//即当 s[i] == s[j] 时，dp[i][j] = dp[i+1][j-1] + 2 。
//如果两边字符不相等，最长回文序列要么全落在去掉右边界字符后的左子串内，要么全落在去掉左边界字符后的右子串内 。
//此时 dp[i][j] = max(dp[i+1][j], dp[i][j-1])
//自下而上、自左而右，所以取右上角最大的
public class LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n <= 0) return 0;

        // dp[i][j] 表示子串 i..j 内的最长回文序列长度
        int dp[][] = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // 初始化，至少为 1
                dp[i][j] = 1;
                if (s.charAt(i) == s.charAt(j)) {
                    // 第一种情况，两边字符相等 回文序列长度 += 2
                    // 注意子串i+1..j-1 的有效性
                    if (i + 1 <= j - 1)
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    else {
                        // 即 j-i <= 1 ，此时 i..j 至多有 2 个字符
                        // 两个字符相等时，自身回文，取其长度
                        dp[i][j] = j - i + 1;
                    }
                } else {
                    // 第一种情况，两边字符不等 回文序列长度取左右之大
                    // 此时必然 j > i
                    // 所以，一定有 j >= i+1  或者 i-1 <= j，也就是子串一定有效
                    // 仍需要注意 i+1 和 j-1 的越界处理
                    if (i + 1 < n) dp[i][j] = Math.max(dp[i][j], dp[i + 1][j]);
                    if (j - 1 >= 0) dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }


    public static void main(String[] args) {

        // write your code here
        LongestPalindromeSubseq ss =  new LongestPalindromeSubseq();
        int longestPalindromeSubseq = ss.longestPalindromeSubseq("bbbab");
        System.out.println(longestPalindromeSubseq);
    }
}
