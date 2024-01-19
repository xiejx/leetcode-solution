package com.example.problem4xx;

import java.util.Arrays;

/**
 * Medium
 * CPU: 70.22% Memory: 57.14%
 * @author xiejx
 * @date 2024/1/18 20:45
 */
public class Solution462 {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // 所有数等于中位数就是最小的移动次数
        int target;
        if (n % 2 == 1) {
            target = nums[n / 2];
        } else {
            int temp = n / 2 - 1;
            target = nums[temp] + (nums[temp + 1] - nums[temp]) / 2;
        }
        int result = 0;
        for (int num: nums) {
            result += Math.abs(target - num);
        }
        return result;
    }
}
