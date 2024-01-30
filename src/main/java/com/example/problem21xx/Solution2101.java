package com.example.problem21xx;

/**
 * Medium
 * CPU: 93.70% Memory: 83.38%
 * @author xiejx
 * @date 2024/1/30 20:35
 */
public class Solution2101 {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        boolean[][] canDetonate = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            int[] bomb = bombs[i];
            long temp = 1L * bomb[2] * bomb[2];
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    long a = 1L * (bombs[j][0] - bomb[0]) * (bombs[j][0] - bomb[0]) + 1L * (bombs[j][1] - bomb[1]) * (bombs[j][1] - bomb[1]);
                    canDetonate[i][j] = a <= temp;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            boolean[] isVisited = new boolean[n];
            isVisited[i] = true;
            result = Math.max(result, dfs(canDetonate, isVisited, i, n) + 1);
        }
        return result;
    }

    private int dfs(boolean[][] canDetonate, boolean[] isVisited, int i, int n) {
        int result = 0;
        for (int j = 0; j < n; j++) {
            if (!isVisited[j] && canDetonate[i][j]) {
                isVisited[j] = true;
                result += dfs(canDetonate, isVisited, j, n) + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2101 test = new Solution2101();
        System.out.println(test.maximumDetonation(new int[][]{{37207,2653,5261},{40784,59523,20635},{16390,1426,39102},{42236,12,96855},{72839,62027,61667},{60691,58191,48447},{42932,46579,41248},{35868,43119,6870},{41693,98905,17374},{43441,1266,41621}}));
    }
}
