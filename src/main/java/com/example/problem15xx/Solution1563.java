package com.example.problem15xx;

/**
 * Hard
 * CPU: 61.26% Memory: 45.05%
 */
public class Solution1563 {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int max = 0;
                for (int k = i; k < j; k++) {
                    int a = prefix[k + 1] - prefix[i];
                    int b = prefix[j + 1] - prefix[k + 1];
                    if (a > b) {
                        max = Math.max(max, b + dp[k + 1][j]);
                    } else if (a < b) {
                        max = Math.max(max, a + dp[i][k]);
                    } else {
                        max = Math.max(max, Math.max(b + dp[k + 1][j], a + dp[i][k]));
                    }
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution1563 test = new Solution1563();
        // 18
        System.out.println(test.stoneGameV(new int[]{6,2,3,4,5,5}));
        // 28
        System.out.println(test.stoneGameV(new int[]{7,7,7,7,7,7,7}));
        // 0
        System.out.println(test.stoneGameV(new int[]{4}));
    }
}
