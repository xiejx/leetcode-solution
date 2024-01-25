package com.example.problem11xx;

/**
 * Medium
 * CPU: 42.72% Memory: 42.31%
 * @author xiejx
 * @date 2024/1/25 10:18
 */
public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        Solution1143 test = new Solution1143();
        // 1
        System.out.println(test.longestCommonSubsequence("bl", "yby"));
    }
}
