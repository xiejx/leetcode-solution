package com.example.problem9xx;

/**
 * Medium
 * CPU: 100% Memory: 62.77%
 * @author xiejx
 * @date 2024/1/19 20:12
 */
public class Solution931 {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] dp0 = new int[n];
        int[] dp1 = new int[n];
        System.arraycopy(matrix[0], 0, dp0, 0, n);
        for (int i = 1; i < m; i++) {
            if (i % 2 == 0) {
                calc(dp1, dp0, matrix[i]);
            } else {
                calc(dp0, dp1, matrix[i]);
            }
        }
        int min = Integer.MAX_VALUE;

        if (m % 2 == 1) {
            for (int num: dp0) {
                min = Math.min(min, num);
            }
        } else {
            for (int num: dp1) {
                min = Math.min(min, num);
            }
        }
        return min;
    }

    private void calc(int[] dp0, int[] dp1, int[] cur) {
        int n = dp0.length;
        for (int i = 0; i < n; i++) {
            dp1[i] = dp0[i] + cur[i];
        }
        for (int i = 1; i < n; i++) {
            dp1[i] = Math.min(dp0[i - 1] + cur[i], dp1[i]);
        }
        for (int i = 0; i < n - 1; i++) {
            dp1[i] = Math.min(dp0[i + 1] + cur[i], dp1[i]);
        }
    }

    public static void main(String[] args) {
        Solution931 test = new Solution931();
        System.out.println(test.minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));
    }
}
