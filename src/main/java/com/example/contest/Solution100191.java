package com.example.contest;

public class Solution100191 {
    public int minimumPushes(String word) {
        int n = word.length();
        if (n <= 8) {
            return n;
        } else if (n <= 16) {
            return 8 + 2 * (n - 8);
        } else if (n <= 24) {
            return 24 + 3 * (n - 16);
        } else {
            return 48 + 4 * (n - 24);
        }
    }
}
