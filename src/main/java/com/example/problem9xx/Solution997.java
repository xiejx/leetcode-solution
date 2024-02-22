package com.example.problem9xx;

/**
 * Easy
 * CPU: 71.04% Memory: 63.27%
 * @author xiejx
 * @date 2024/2/22 10:02
 */
public class Solution997 {
    public int findJudge(int n, int[][] trust) {
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int[] rela: trust) {
            starts[rela[0] - 1]++;
            ends[rela[1] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (starts[i] == 0 && ends[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}
