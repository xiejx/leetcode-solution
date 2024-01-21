package com.example.contest;

public class Solution100188 {
    public int[] countOfPairs(int n, int x, int y) {
        int[] result = new int[n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = 1;
            dp[i + 1][i] = 1;
        }
        if (x != y) {
            dp[x - 1][y - 1] = 1;
            dp[y - 1][x - 1] = 1;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != 0) {
                    result[dp[i][j] - 1] += 1;
                }
            }
        }
        return result;
    }
}
