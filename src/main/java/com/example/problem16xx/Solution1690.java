package com.example.problem16xx;

/**
 * Medium
 * CPU: 61.21% Memory: 59.48%
 */
public class Solution1690 {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }
        // 长度为（i,j）时，alice和boy的差值
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                    continue;
                }
                int temp = (j - i) % 2 == (n - 1) % 2 ? 1 : -1;
                int a = (prefix[j + 1] - prefix[i + 1]) * temp + dp[i + 1][j];
                int b = (prefix[j] - prefix[i]) * temp + dp[i][j - 1];
                if (temp == 1) {
                    dp[i][j] = Math.max(a, b);
                } else {
                    dp[i][j] = Math.min(a, b);
                }
            }
        }
        return dp[0][n - 1];
    }

    private int dfs(int[] prefix, int start, int end, boolean flag) {
        if (start >= end) {
            return 0;
        }
        // 去掉前面
        int a = dfs(prefix, start + 1, end, !flag);
        int b = dfs(prefix, start, end - 1, !flag);
        if (flag) {
            return Math.max(prefix[end + 1] - prefix[start + 1] + a, prefix[end] - prefix[start] + b);
        } else {
            return Math.min(-(prefix[end + 1] - prefix[start + 1]) + a, -(prefix[end] - prefix[start]) + b);
        }
    }


    public static void main(String[] args) {
        Solution1690 test = new Solution1690();
        // 6
        System.out.println(test.stoneGameVII(new int[]{5,3,1,4,2}));
        // 122
        System.out.println(test.stoneGameVII(new int[]{7,90,5,1,100,10,10,2}));
    }
}
