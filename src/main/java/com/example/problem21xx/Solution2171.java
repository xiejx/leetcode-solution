package com.example.problem21xx;

import java.util.Arrays;

/**
 * Medium
 * CPU:47.66% Memory:22.43%
 * @author xiejx
 * @date 2024/1/18 14:08
 */
public class Solution2171 {
    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        Arrays.sort(beans);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += beans[i];
        }
        long result = sum;
        for (int i = 0; i < n; i++) {
            // 小于i的全部去掉，大于等于i的去掉大的部分
            long temp = sum - 1L * beans[i] * (n - i);
            result = Math.min(temp, result);
        }
        return result;
    }
}
