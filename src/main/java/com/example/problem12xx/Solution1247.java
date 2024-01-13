package com.example.problem12xx;

/**
 * Medium
 * CPU:100% Memory: 10.79%
 */
public class Solution1247 {
    public int minimumSwap(String s1, String s2) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int n1 = chs1.length;
        int n2 = chs2.length;
        if (n1 != n2) {
            return -1;
        }
        int x = 0;
        int y = 0;
        for (int i = 0; i < n1; i++) {
            char ch1 = chs1[i];
            char ch2 = chs2[i];
            if (ch1 != ch2) {
                if (ch1 == 'x') {
                    x += 1;
                } else {
                    y += 1;
                }
            }
        }
        if ((x + y) % 2 != 0) {
            return -1;
        }
        int result = 0;
        result += x / 2 + y / 2;
        if (x % 2 != 0) {
            result += 2;
        }
        return result;
    }
}
