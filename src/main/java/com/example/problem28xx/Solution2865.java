package com.example.problem28xx;

import com.example.common.ListUtil;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Medium
 * CPU: 99.53% Memory: 60.85%
 * @author xiejx
 * @date 2024/1/24 11:46
 */
public class Solution2865 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long result = 0;
        int n = maxHeights.size();
        int[] nextSmall = new int[n + 1];
        int[] lastSmall = new int[n + 1];
        Deque<Integer> stack = new LinkedList<>();
        Arrays.fill(nextSmall, n);
        Arrays.fill(lastSmall, 0);
        for (int i = 0; i < n; i++) {
            int maxHeight = maxHeights.get(i);
            while (!stack.isEmpty()) {
                int top = stack.peekFirst();
                if (maxHeights.get(top) >= maxHeight) {
                    stack.removeFirst();
                    nextSmall[top] = i;
                } else {
                    break;
                }
            }
            stack.addFirst(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            int maxHeight = maxHeights.get(i);
            while (!stack.isEmpty()) {
                int top = stack.peekFirst();
                if (maxHeights.get(top) > maxHeight) {
                    stack.removeFirst();
                    lastSmall[top + 1] = i + 1;
                } else {
                    break;
                }
            }
            stack.addFirst(i);
        }

        long[] heights1 = new long[n + 1];
        long[] heights2 = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            int last = lastSmall[i];
            heights1[i] = heights1[last] + 1L * maxHeights.get(i - 1) * (i - last);
        }
        for (int i = n - 1; i >= 0; i--) {
            int next = nextSmall[i];
            heights2[i] = heights2[nextSmall[i]] + 1L * maxHeights.get(i) * (next - i);
        }
        for (int i = 0; i < n; i++) {
            result = Math.max(result, heights1[i] + heights2[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2865 test = new Solution2865();
        // 13
        System.out.println(test.maximumSumOfHeights(ListUtil.fromArray(new int[]{5,3,4,1,1})));
        // 22
        System.out.println(test.maximumSumOfHeights(ListUtil.fromArray(new int[]{6,5,3,9,2,7})));
        // 18
        System.out.println(test.maximumSumOfHeights(ListUtil.fromArray(new int[]{3,2,5,5,2,3})));
        // 22
        System.out.println(test.maximumSumOfHeights(ListUtil.fromArray(new int[]{22})));
    }
}
