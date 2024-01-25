package com.example.problem28xx;

import java.util.List;

/**
 * Easy
 * CPU: 100% Memory: 14.54%
 * @author xiejx
 * @date 2024/1/25 10:06
 */
public class Solution2859 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int count = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if (Integer.bitCount(i) == k) {
                count += nums.get(i);
            }
        }
        return count;
    }
}
