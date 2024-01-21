package com.example.contest;

import java.util.Arrays;

public class Solution100192 {
    public int minimumPushes(String word) {
        int result = 0;
        int[] count = new int[26];
        for (char ch: word.toCharArray()) {
            count[ch - 'a'] += 1;
        }
        Arrays.sort(count);
        for (int i = 0; i < 2; i++) {
            result += 4 * count[i];
        }
        for (int i = 0; i < 8; i++) {
            result += 3 * count[i + 2];
        }
        for (int i = 0; i < 8; i++) {
            result += 2 * count[i + 10];
        }
        for (int i = 0; i < 8; i++) {
            result += count[i + 18];
        }
        return result;
    }
}
