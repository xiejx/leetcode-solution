package com.example.problem25xx;

/**
 * Medium
 * CPU: 50% Memory: 22.41%
 */
public class Solution2531 {
    public boolean isItPossible(String word1, String word2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char ch: word1.toCharArray()) {
            count1[ch - 'a'] += 1;
        }
        for (char ch: word2.toCharArray()) {
            count2[ch - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] == 0) {
                continue;
            }
            for (int j = 0; j < 26; j++) {
                if (count2[j] == 0) {
                    continue;
                }
                count1[i] -= 1;
                count2[i] += 1;
                count1[j] += 1;
                count2[j] -= 1;
                if (countDistinct(count1) == countDistinct(count2)) {
                    return true;
                }
                count1[i] += 1;
                count2[i] -= 1;
                count1[j] -= 1;
                count2[j] += 1;
            }
        }
        return false;
    }

    private int countDistinct(int[] count) {
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] >= 1) {
                result += 1;
            }
        }
        return result;
    }
}
