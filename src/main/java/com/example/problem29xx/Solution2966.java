package com.example.problem29xx;

import java.util.Arrays;

/**
 * Medium
 * CPU: 93.20% Memory: 11.55%
 * @author xiejx
 * @date 2024/2/1 20:52
 */
public class Solution2966 {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] result = new int[(n - 1) / 3 + 1][3];
        for (int i = 0; i < result.length; i++) {
            int start = i * 3;
            if (nums[start + 2] <= nums[start] + k) {
                result[i][0] = nums[start];
                result[i][1] = nums[start + 1];
                result[i][2] = nums[start + 2];
            } else {
                return new int[][]{};
            }
        }
        return result;
    }
}
