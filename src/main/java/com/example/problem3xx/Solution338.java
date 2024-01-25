package com.example.problem3xx;

/**
 *
 * Easy
 * CPU: 89.65 Memory: 28.81%
 * @author xiejx
 * @date 2024/1/25 10:42
 */
public class Solution338 {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }
}
