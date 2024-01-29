package com.example.problem5xx;

/**
 * Medium
 * CPU: 18% Memory: 74.40%
 * @author xiejx
 * @date 2024/1/26 9:47
 */
public class Solution576 {
    private int MOD = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int result = 0;
        if (maxMove == 0) {
            return 0;
        }
        int[][][] dp = new int[m][n][maxMove];
        dp[startRow][startColumn][0] = 1;
        for (int k = 1; k < maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 上一步在哪
                    // 上
                    if (i - 1 >= 0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                    }
                    // 下
                    if (i + 1 < m) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i + 1][j][k - 1]) % MOD;
                    }
                    // 左
                    if (j - 1 >= 0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i][j - 1][k - 1]) % MOD;
                    }
                    // 右
                    if (j + 1 < n) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i][j + 1][k - 1]) % MOD;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < maxMove; k++) {
                result = (result + dp[0][i][k]) % MOD;
                result = (result + dp[m - 1][i][k]) % MOD;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < maxMove; k++) {
                result = (result + dp[i][0][k]) % MOD;
                result = (result + dp[i][n - 1][k]) % MOD;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution576 test = new Solution576();
        // 6
        System.out.println(test.findPaths(2,2,2,0,0));
        // 0
        System.out.println(test.findPaths(10,10,0,5,5));
    }
}
