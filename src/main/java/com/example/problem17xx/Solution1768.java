package com.example.problem17xx;

/**
 * Easy
 * CPU: 100% Memory: 49.37%
 */
public class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        char[] chs = new char[len1 + len2];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            chs[k] = word1.charAt(i);
            chs[k + 1] = word2.charAt(j);
            k += 2;
            i++;
            j++;
        }
        while (i < len1) {
            chs[k] = word1.charAt(i);
            i++;
            k++;
        }
        while (j < len2) {
            chs[k] = word2.charAt(j);
            j++;
            k++;
        }
        return String.valueOf(chs);
    }
}
