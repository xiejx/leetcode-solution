package com.example.problem12xx;

/**
 * Hard
 * CPU: 62.05% Memory: 84.23%
 * @author xiejx
 * @date 2024/1/22 12:50
 */
public class Solution1289 {
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
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    temp = Math.min(temp, dp0[j]);
                }
            }
            dp1[i] = cur[i] + temp;
        }
    }

    public static void main(String[] args) {
        Solution1289 test = new Solution1289();
        // 13
        System.out.println(test.minFallingPathSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        // 7
        System.out.println(test.minFallingPathSum(new int[][]{{7}}));
        // -192
        System.out.println(test.minFallingPathSum(new int[][]{{-73,61,43,-48,-36},{3,30,27,57,10},{96,-76,84,59,-15},{5,-49,76,31,-7},{97,91,61,-46,67}}));
        int n = 200;
        int[][] matrix = new int[n][n];
        long start = System.currentTimeMillis();
        System.out.println(test.minFallingPathSum(matrix));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + " 毫秒");
    }
}
