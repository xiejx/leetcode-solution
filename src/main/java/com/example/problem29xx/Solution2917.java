package com.example.problem29xx;

/**
 * Easy
 * CPU: 94.18% Memory: 68.86%
 * @author xiejx
 * @date 2024/1/25 10:45
 */
public class Solution2917 {
    public int findKOr(int[] nums, int k) {
        int result = 0;
        int n = nums.length;
        for (int i = 0; i < 31; i++) {
            int temp = 0;
            int set = 1 << i;
            for (int j = 0; j < n; j++) {
                if ((nums[j] & set) > 0) {
                    temp++;
                }
                if (temp >= k) {
                    break;
                }
            }
            if (temp >= k) {
                result += set;
            }
        }
        return result;
    }
}
