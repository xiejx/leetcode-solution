package com.example.problem8xx;

/**
 * Easy
 * CPU: 74.20% Memory:27.92%
 */
public class Solution859 {
    public boolean buddyStrings(String s, String goal) {
        int n1 = s.length();
        int n2 = goal.length();
        if (n1 != n2) {
            return false;
        }
        char ch1 = ' ';
        char ch2 = ' ';
        int count = 0;
        int[] countChs = new int[26];
        for (int i = 0; i < n1; i++) {
            char temp1 = s.charAt(i);
            char temp2 = goal.charAt(i);
            countChs[temp1 - 'a']++;
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
        if (count == 2) {
            return true;
        }
        if (count != 0) {
            return false;
        }
        for (int i = 0; i < 26; i++) {
            if (countChs[i] >= 2) {
                return true;
            }
        }
        return false;
    }
}
