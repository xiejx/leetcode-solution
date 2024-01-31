package com.example.problem26xx;

import java.util.HashSet;
import java.util.Set;

/**
 * Easy
 * CPU: 79.96% Memory: 19.82%
 * @author xiejx
 * @date 2024/1/31 9:41
 */
public class Solution2670 {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Set<Integer> set = new HashSet<>();
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            prefix[i] = set.size();
        }
        set.clear();
        int[] suffix = new int[n];
        for (int i = n - 1; i > 0; i--) {
            set.add(nums[i]);
            suffix[i - 1] = set.size();
        }
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] - suffix[i];
        }
        return result;
    }
}
