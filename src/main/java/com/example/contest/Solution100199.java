package com.example.contest;

import java.util.Arrays;

public class Solution100199 {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = Integer.bitCount(nums[i]);
        }
        int prev = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] != count[i - 1]) {
                Arrays.sort(nums, prev, i);
                prev = i;
            }
        }
        Arrays.sort(nums, prev, n);
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
