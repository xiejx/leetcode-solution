package com.example.problem9xx;

/**
 * Medium
 * CPU: 41.84% Memory: 35.15%
 * @author xiejx
 * @date 2024/1/23 11:22
 */
public class Solution978 {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int max = 1;
        int start = 0;
        for (int i = 1; i < n; i += 2) {
            if (arr[i] > arr[i - 1]) {
                max = Integer.max(max, i - start + 1);
            } else {
                start = i;
            }
            if (i + 1 >= n) {
                continue;
            }
            if (arr[i] > arr[i + 1]) {
                max = Integer.max(max, i - start + 2);
            } else {
                start = i + 1;
            }
        }
        start = 0;
        for (int i = 1; i < n; i += 2) {
            if (arr[i] < arr[i - 1]) {
                max = Integer.max(max, i - start + 1);
            } else {
                start = i;
            }
            if (i + 1 >= n) {
                continue;
            }
            if (arr[i] < arr[i + 1]) {
                max = Integer.max(max, i - start + 2);
            } else {
                start = i + 1;
            }
        }
        return max;
    }
}
