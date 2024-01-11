package com.example.preblem19xx;

import java.util.Arrays;

/**
 * @author xiejx
 * @date 2024/1/11 20:43
 */
public class Solution1968 {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.sort(nums);
        int j = 0;
        for (int i = 0; i < n; i += 2) {
            result[i] = nums[j++];
        }
        for (int i = 1; i < n; i += 2) {
            result[i] = nums[j++];
        }
        return result;
    }
}
