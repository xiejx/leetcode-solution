package com.example.problem13xx;

/**
 * Medium
 * CPU: 90.59% Memory: 6.22%
 */
public class Solution1347 {
    public int minSteps(String s, String t) {
        int n = s.length();
        int[] countS = new int[26];
        for (int i = 0; i < n; i++) {
            countS[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < n; i++) {
            int temp = t.charAt(i) - 'a';
            if (countS[temp] > 0) {
                countS[temp]--;
            }
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += countS[i];
        }
        return result;
    }
}
