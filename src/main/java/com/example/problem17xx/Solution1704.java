package com.example.problem17xx;

/**
 * Easy
 * CPU: 88.24% Memory:24.13%
 * @author xiejx
 * @date 2024/1/12 11:38
 */
public class Solution1704 {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int m = n / 2;
        int numOfVowel = 0;
        // 统计前半段
        for (int i = 0; i < m; i++) {
            if (isVowel(s.charAt(i))) {
                numOfVowel++;
            }
        }
        // 减去后半段
        for (int i = m; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                numOfVowel--;
            }
        }
        return numOfVowel == 0;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
