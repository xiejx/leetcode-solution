package com.example.problem8xx;

/**
 * Medium
 * CPU: 27.99% Memory: 28.46%
 * 实际上，先取的总是可以赢，可以直接返回true
 * @author xiejx
 * @date 2024/2/2 17:06
 */
public class Solution877 {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // 长度为（i,j）时，alice和boy的差值
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = -piles[i];
                    continue;
                }
                int a = piles[i] + dp[i + 1][j];
                int b = piles[j] + dp[i][j - 1];
                if ((j - i) % 2 == 1) {
                    dp[i][j] = Math.max(a, b);
                } else {
                    dp[i][j] = Math.min(a, b);
                }
            }
        }
        return dp[0][n - 1] > 0;
    }

    public static void main(String[] args) {
        Solution877 test = new Solution877();
        // true
        System.out.println(test.stoneGame(new int[]{5,3,4,5}));
        // true
        System.out.println(test.stoneGame(new int[]{3,7,2,3}));
        // true
        System.out.println(test.stoneGame(new int[]{1,2,3,4,5,6,8,8}));
    }
}
