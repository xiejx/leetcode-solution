package com.example.problem7xx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Medium
 * 实际上可以直接使用BFS的方式
 * CPU: 17.45% Memory: 85.04%
 * @author xiejx
 * @date 2024/2/23 9:40
 */
public class Solution787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adjust = new List[n];
        for (int i = 0; i < n; i++) {
            adjust[i] = new ArrayList<>();
        }
        for (int[] flight: flights) {
            adjust[flight[0]].add(new int[]{flight[1], flight[2]});
        }
        int[][] dp = new int[k + 1][n];
        for (int i = 0; i < k + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < k + 1; i++) {
            dp[i][src] = 0;
        }
        for (int[] values: adjust[src]) {
            dp[0][values[0]] = values[1];
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i - 1][j] == -1) {
                    continue;
                }
                // 经过j到达的点的最小值
                for (int[] values: adjust[j]) {
                    int temp = values[1] + dp[i - 1][j];
                    if (dp[i][values[0]] == -1) {
                        dp[i][values[0]] = temp;
                    } else {
                        dp[i][values[0]] = Math.min(temp, dp[i][values[0]]);
                    }
                }
            }
        }
        return dp[k][dst];
    }

    public static void main(String[] args) {
        Solution787 test = new Solution787();
        System.out.println(test.findCheapestPrice(4, new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}}, 0, 3, 1));
    }
}
