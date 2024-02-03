package com.example.problem10xx;

/**
 * Medium
 * CPU: 9.33% Memory: 5.62%
 */
public class Solution1043 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[][][] dp = new int[n][k][2];
        dp[0][0][0] = arr[0];
        dp[0][0][1] = arr[0];
        for (int i = 1; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < k; j++) {
                temp = Math.max(temp, dp[i - 1][j][0]);
            }
            dp[i][0][0] = temp + arr[i];
            dp[i][0][1] = arr[i];
            for (int j = 1; j < k; j++) {
                if (i < j) {
                    break;
                }
                int prevMax = dp[i - 1][j - 1][1];
                int curVal = arr[i];
                if (curVal <= prevMax) {
                    dp[i][j][0] = dp[i - 1][j - 1][0] + prevMax;
                    dp[i][j][1] = prevMax;
                } else {
                    dp[i][j][1] = curVal;
                    dp[i][j][0] = dp[i - 1][j - 1][0] + (curVal - prevMax) * j + curVal;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(dp[n - 1][i][0], max);
        }
        return max;
    }

    // 官方题解
    // d[i]表示以i为结尾的最大值
    public int maxSumAfterPartitioning0(int[] arr, int k) {
        int n = arr.length;
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int maxValue = arr[i - 1];
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                d[i] = Math.max(d[i], d[j] + maxValue * (i - j));
                if (j > 0) {
                    maxValue = Math.max(maxValue, arr[j - 1]);
                }
            }
        }
        return d[n];
    }

    public static void main(String[] args) {
        Solution1043 test = new Solution1043();
        // 84
        System.out.println(test.maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));
        // 83
        System.out.println(test.maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4));
        // 1
        System.out.println(test.maxSumAfterPartitioning(new int[]{1}, 1));
    }
}
