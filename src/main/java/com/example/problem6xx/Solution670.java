package com.example.problem6xx;

/**
 * Medium
 * CPU: 100% Memory: 39.02%
 * @author xiejx
 * @date 2024/1/22 9:51
 */
public class Solution670 {
    public int maximumSwap(int num) {
        char[] chs = String.valueOf(num).toCharArray();
        int n = chs.length;
        for (int i = 0; i < n - 1; i++) {
            char temp = '\0';
            int index = -1;
            for (int j = i + 1; j < n; j++) {
                if (chs[j] > chs[i] && chs[j] >= temp) {
                    index = j;
                    temp = chs[j];
                }
            }
            if (index != -1) {
                char ch = chs[index];
                chs[index] = chs[i];
                chs[i] = ch;
                return Integer.parseInt(String.valueOf(chs));
            }
        }
        return num;
    }
}
