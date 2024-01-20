package com.example.contest;

import java.util.Arrays;

public class Solution100181 {
    public int minimumCost(int[] nums) {
        int result = nums[0];
        int n = nums.length;
        Arrays.sort(nums, 1, n);
        return result + nums[1] + nums[2];
    }
}
