package com.example.problem12xx;

/**
 * Easy
 * CPU: 100% Memory: 55.95%
 * @author xiejx
 * @date 2024/1/22 12:40
 */
public class Solution1221 {
    public int balancedStringSplit(String s) {
        char[] chs = s.toCharArray();
        int count = 0;
        int result = 0;
        for (char ch: chs) {
            if (ch == 'L') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result++;
            }
        }
        return result;
    }
}
