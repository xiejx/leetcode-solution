package com.example.problem16xx;

import java.util.*;

/**
 * Medium
 * 可以使用单调队列的方法，而不是优先队列
 * CPU: 53.92% Memory: 81.82%
 * @author xiejx
 * @date 2024/2/5 9:39
 */
public class Solution1696 {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> dp[b] - dp[a]);
        queue.add(0);
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
                queue.clear();
                queue.add(i - 1);
                queue.add(i);
            } else {
                int tempIndex = queue.peek();
                while (tempIndex < i - k) {
                    queue.poll();
                    tempIndex = queue.peek();
                }
                dp[i] = dp[tempIndex] + nums[i];
                queue.add(i);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution1696 test = new Solution1696();
        // 17
        System.out.println(test.maxResult(new int[]{10,-5,-2,4,0,3}, 3));
    }
}
