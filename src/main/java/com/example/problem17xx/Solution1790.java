package com.example.problem17xx;

/**
 * Easy
 * CPU: 100% Memory: 27.63%
 */
public class Solution1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 != n2) {
            return false;
        }
        char ch1 = ' ';
        char ch2 = ' ';
        int count = 0;
        for (int i = 0; i < n1; i++) {
            char temp1 = s1.charAt(i);
            char temp2 = s2.charAt(i);
            if (temp1 != temp2) {
                if (count == 0) {
                    ch1 = temp1;
                    ch2 = temp2;
                    count++;
                } else if (count == 1) {
                    count++;
                    if (ch1 != temp2 || ch2 != temp1) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return count != 1;
    }
}
