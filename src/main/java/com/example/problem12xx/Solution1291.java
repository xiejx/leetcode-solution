package com.example.problem12xx;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * CPU: 100% Memory: 27.22%
 * @author xiejx
 * @date 2024/2/2 10:10
 */
public class Solution1291 {
    private int[] diff = new int[]{11,111,1111,11111,111111,1111111,11111111,111111111};
    // 最大递增次数为7 - i
    private int[] init = new int[]{12,123,1234,12345,123456,1234567,12345678,123456789};
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int cur = init[i];
            for (int j = 0; j <= 7 - i; j++) {
                if (cur >= low && cur <= high) {
                    list.add(cur);
                }
                cur += diff[i];
            }
        }
        return list;
    }
}
