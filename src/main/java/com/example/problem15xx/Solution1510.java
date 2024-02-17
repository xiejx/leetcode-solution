package com.example.problem15xx;

/**
 * Hard
 * CPU: 72.80% Memory: 69.60%
 */
public class Solution1510 {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int j = 1; j * j <= i; j++) {
                if(!dp[i - j * j]) {
                    flag = false;
                    break;
                }
            }
            dp[i] = !flag;
        }
        return dp[n];
    }
}
