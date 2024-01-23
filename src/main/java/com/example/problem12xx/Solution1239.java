package com.example.problem12xx;

import java.util.*;

/**
 * Medium
 * CPU: 98.99% Memory: 95.06
 * @author xiejx
 * @date 2024/1/23 10:17
 */
public class Solution1239 {
    private int max;
    public int maxLength(List<String> arr) {
        int n = arr.size();
        max = 0;
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = 0;
            boolean flag = true;
            for (char ch: arr.get(i).toCharArray()) {
                int chVal = 1 << (ch - 'a');
                if ((temp & chVal) != 0) {
                    flag = false;
                    break;
                } else {
                    temp += chVal;
                }
            }
            if (flag) {
                nums.add(temp);
            }
        }
        dfs(0, nums, 0);
        return max;
    }

    private void dfs(int index, List<Integer> num, int cur) {
        if (index == num.size()) {
            max = Math.max(max, Integer.bitCount(cur));
            return;
        }
        if ((cur & num.get(index)) == 0) {
            dfs(index + 1, num, cur + num.get(index));
        }
        dfs(index + 1, num, cur);
    }
}
