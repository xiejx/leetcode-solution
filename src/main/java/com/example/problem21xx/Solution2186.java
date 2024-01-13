package com.example.problem21xx;

/**
 * Medium
 * CPU: 90.23% Memory: 61.72%
 */
public class Solution2186 {
    public int minSteps(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int[] countChs = new int[26];
        for (int i = 0; i < n1; i++) {
            countChs[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < n2; i++) {
            countChs[t.charAt(i) - 'a'] -= 1;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += Math.abs(countChs[i]);
        }
        return result;
    }
}
