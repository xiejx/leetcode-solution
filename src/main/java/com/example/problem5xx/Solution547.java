package com.example.problem5xx;

/**
 * Medium
 * CPU: 100% Memory: 29.38%
 * @author xiejx
 * @date 2024/1/30 20:20
 */
public class Solution547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                result++;
                isVisited[i] = true;
                dfs(isConnected, i, n, isVisited);
            }
        }

        return result;
    }

    private void dfs(int[][] isConnected, int i, int n, boolean[] isVisited) {
        for (int j = 0; j < n; j++) {
            if (!isVisited[j] && isConnected[i][j] == 1) {
                isVisited[j] = true;
                dfs(isConnected, j, n, isVisited);
            }
        }
    }
}
