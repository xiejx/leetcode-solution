package com.example.problem2xx;

/**
 * Medium
 * CPU: 87.41% Memory: 12.19%
 */
public class Solution299 {
    public String getHint(String secret, String guess) {
        int[] countA = new int[10];
        int[] countB = new int[10];
        char[] chs1 = secret.toCharArray();
        char[] chs2 = guess.toCharArray();
        for (char ch: secret.toCharArray()) {
            countA[ch - '0'] += 1;
        }
        for (char ch: guess.toCharArray()) {
            countB[ch - '0'] += 1;
        }
        int x = 0;
        int y = 0;
        for (int i = 0; i < chs1.length; i++) {
            if (chs1[i] == chs2[i]) {
                x += 1;
            }
        }
        for (int i = 0; i < 10; i++) {
            y += Math.min(countA[i], countB[i]);
        }
        return x + "A" + (y - x) + "B";
    }
}
