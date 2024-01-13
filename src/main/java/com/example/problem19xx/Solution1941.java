package com.example.problem19xx;

/**
 * Easy
 * CPU: 100% Memory: 23.34%
 */
public class Solution1941 {
    public boolean areOccurrencesEqual(String s) {
        int[] count = new int[26];
        for (char ch: s.toCharArray()) {
            count[ch - 'a'] += 1;
        }
        int temp = 0;
        for (int num: count) {
            if (num != 0) {
                if (temp == 0) {
                    temp = num;
                } else if (temp != num) {
                    return false;
                }
            }
        }
        return true;
    }
}
