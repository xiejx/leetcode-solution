package com.example.problem27xx;

/**
 * Easy
 * CPU: 100% Memory: 17.96%
 * @author xiejx
 * @date 2024/1/23 9:57
 */
public class Solution2765 {
    public int alternatingSubarray(int[] nums) {
        int result = -1;
        int n = nums.length;
        int pos = 1;
        int start = 0;
        int i = 1;
        while (i < n) {
            if (nums[i] - nums[i - 1] == pos) {
                pos = -pos;
                result = Math.max(result, i - start + 1);
            } else if (nums[i] - nums[i - 1] == 1) {
                start = i - 1;
                pos = -1;
                result = Math.max(result, i - start + 1);
            } else {
                start = i;
                pos = 1;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2765 test = new Solution2765();
        System.out.println(test.alternatingSubarray(new int[]{2,3,4,3,4}));
    }
}
