package com.example.problem16xx;

/**
 * Medium
 * CPU: 98.25% Memory: 62.99%
 * @author xiejx
 * @date 2024/1/18 20:52
 */
public class Solution1658 {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        x = sum - x;
        if (x < 0) {
            return -1;
        } else if (x == 0) {
            return n;
        }
        int max = -1;
        int start = 0;
        int tempSum = 0;
        for (int i = 0; i < n; i++) {
            tempSum += nums[i];
            if (tempSum == x) {
                max = Math.max(max, i - start + 1);
            }
            while (tempSum > x) {
                tempSum -= nums[start];
                start++;
            }
            if (tempSum == x) {
                max = Math.max(max, i - start + 1);
            }
        }

        return max == -1 ? -1 : n - max;
    }

    public static void main(String[] args) {
        Solution1658 test = new Solution1658();
        // 2
        System.out.println(test.minOperations(new int[]{1,1,4,2,3}, 5));
        // -1
        System.out.println(test.minOperations(new int[]{5,6,7,8,9}, 4));
        // 5
        System.out.println(test.minOperations(new int[]{3,2,20,1,1,3}, 10));
        System.out.println(test.minOperations(new int[]{1,1}, 3));
    }
}
