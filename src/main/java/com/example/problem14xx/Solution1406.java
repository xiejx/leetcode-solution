package com.example.problem14xx;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Hard
 * CPU 79.11%
 * Memory: 81.78%
 */
public class Solution1406 {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int temp = 0;
            for (int j = 0; j < 3 && i + j < n; j++) {
                temp += stoneValue[i + j];
                dp[i] = Math.max(dp[i], temp - dp[i + j + 1]);
            }
        }
        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    public static void main(String[] args) {
        Solution1406 test = new Solution1406();
        // Bob
        System.out.println(test.stoneGameIII(new int[]{1,2,3,7}));
        // Alice
        System.out.println(test.stoneGameIII(new int[]{1,2,3,-9}));
        // Tie
        System.out.println(test.stoneGameIII(new int[]{1,2,3,6}));
    }
}
